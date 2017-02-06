import java.util.ArrayList;

/**
 * Created by hankerins on 1/31/17.
 */

//TODO: implement abstract methods
public class Army extends Concrete {
    private ArrayList<Unit> battleGroup;
    private ArrayList<Unit> reinforcements;
    private ArrayList<Unit> entireArmy;

    Player player;

    RallyPoint rallyPoint;

    CommandFactory commandFactory;

    public void doTurn(){
        while(!getCommandQueue().isEmpty()){
           getCommandQueue().carryOut();
        }
    }

    public void addToBattleGroup(Unit target){
        int population = battleGroup.size();

        target.setBattleGroup(true);

        battleGroup.add(target);
        Stats workingStats = getMyStats();

        workingStats.setArmor((((population*workingStats.getArmor()) + target.getMyStats().getArmor()) / (population+1) ));
        workingStats.setDefensiveDamage((((population*workingStats.getDefensiveDamage()) + target.getMyStats().getDefensiveDamage()) / (population+1) ));
        workingStats.setHealth((((population*workingStats.getHealth()) + target.getMyStats().getHealth()) / (population+1) ));
        workingStats.setOffensiveDamage((((population*workingStats.getOffensiveDamage()) + target.getMyStats().getOffensiveDamage()) / (population+1) ));
        workingStats.setUpKeep((((population*workingStats.getUpKeep()) + target.getMyStats().getUpKeep()) / (population+1) ));

        if(this.getActionPointCap() > target.getActionPointCap()){
            this.setActionPointCap(target.getActionPointCap());
        }
    }

    public void attack(Map.MapDirection md){
        for(Unit units : this.battleGroup){
            units.giveCommand(new AttackCommand(units, md));
        }
    }

    public void addToReinforcements(Unit target){
        reinforcements.add(target);
        rallyPoint.givePathCommands(target);
    }

    public void addToArmy(Unit target){
        entireArmy.add(target);
    }

    public void orderMove(Map.MapDirection md){
        for(Unit target : battleGroup){
            target.giveCommand(new PowerDownCommand(target));
        }
    }

    public void powerUp(){
        for(Unit target : battleGroup){
            target.giveCommand(new PowerUpCommand(target));
        }
    }

    public void powerDown(){
        for(Unit target : battleGroup){
            target.giveCommand(new PowerDownCommand(target));
        }
    }

    void standby(){
        for(Unit target : battleGroup){
            target.giveCommand(new StandbyCommand(target));
        }
    }

    void wait4me(){
        for(Unit target : battleGroup){
            target.giveCommand(new WaitCommand(target));
        }
    }

    public double getState() {
        return state;
    }

    public ArrayList<Unit> getBattleGroup() {
        return battleGroup;
    }

    public ArrayList<Unit> getReinforcements() {
        return reinforcements;
    }

    public ArrayList<Unit> getEntireArmy() {
        return entireArmy;
    }

    public void setBattleGroup(ArrayList<Unit> battleGroup) {
        this.battleGroup = battleGroup;
    }

    public void setReinforcements(ArrayList<Unit> reinforcements) {
        this.reinforcements = reinforcements;
    }

    public void setEntireArmy(ArrayList<Unit> entireArmy) {
        this.entireArmy = entireArmy;
    }

    private int availableMovement;

    public int getAvailableMovement() {
        return availableMovement;
    }

    public void setAvailableMovement(int availableMovement) {
        this.availableMovement = availableMovement;
    }

    public void reinforce(Unit arrived){
        this.addToBattleGroup(arrived);
        this.reinforcements.remove(arrived);
    }

    @Override
    void endTurn() {
        for(Unit unit : reinforcements){
            if(unit.getLoc().equals(rallyPoint.getLoc()) && unit.getLoc().equals(this.getLoc())){
                this.reinforce(unit);
            }
        }
    }

    @Override
    void killMe() {
        for(Unit target : entireArmy){
            target.killMe();
        }

        getPlayer().remove(rallyPoint);
        getPlayer().remove(this);
    }

    @Override
    void clearCommands() {

        for(Unit unit : this.battleGroup){
            unit.clearCommands();
        }

        getCommandQueue().clear();
    }

    void remove(Unit target){
        entireArmy.remove(target);
        battleGroup.remove(target);
        reinforcements.remove(target);

        if(entireArmy.isEmpty()){
            this.killMe();
        }
    }

    public int getTypeID(){
    	return GameInfo.ARMY;
    }
    
    //Make an army with a unit, also creates its rally point
    Army(Unit unit, Player player){

        super(player, unit.getLoc(), unit.getMap(), StatsFactory.createStats(GameInfo.ARMY));

        this.setLoc(unit.getLoc());

        this.getCID().modeID = GameInfo.ARMYMODE;

        this.addToArmy(unit);

        this.addToBattleGroup(unit);

        //Papers, Please
        this.getPlayer().register(this);

        RallyPoint rallyPoint = new RallyPoint(this);
        this.rallyPoint = rallyPoint;
        this.getPlayer().register(rallyPoint);
    }

    public RallyPoint getRallyPoint() {
        return rallyPoint;
    }

    public void disband() {

        for(Unit unit : this.entireArmy){
            unit.setMyArmy(null);
            unit.setBattleGroup(false);
            unit.clearCommands();
        }

        this.entireArmy.clear();
        this.battleGroup.clear();
        this.reinforcements.clear();
        this.getPlayer().remove(this);
    }
    //Make an army, also creates its rally point
   /*
    Army(Player player){
        player.getArmies().add(this);
        RallyPoint rallyPoint = new RallyPoint(this);
        this.rallyPoint = rallyPoint;
        player.getRallyPoints().add(rallyPoint);
    }
    */
}