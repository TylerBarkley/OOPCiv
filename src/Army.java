import sun.plugin2.message.GetAppletMessage;

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

    public void addToReinforcements(Unit target){
        reinforcements.add(target);
    }

    public void addToArmy(Unit target){
        entireArmy.add(target);
    }

    public void orderMove(Map.MapDirection md){
        for(Unit target : battleGroup){
            //target.getCommandQueue().add(target.commandFactory.create(Move Instruction, target));
        }
    }

    public void powerDown(){
        for(Unit target : battleGroup){
            //target.getCommandQueue().add(target.commandFactory.create(PowerDown, target));
        }
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

    public void Reinforce(Unit arrived){

    }

    @Override
    void endTurn() {
        //TODO SPAGHETTI OUT OF MY POCKET
    }

    @Override
    void killMe() {
        for(Unit target : entireArmy){
            target.killMe();
        }
    }

    @Override
    void clearCommands() {
        getCommandQueue().clear();
    }

    void remove(Unit target){
        entireArmy.remove(target);
        battleGroup.remove(target);
        reinforcements.remove(target);
    }

    //Make an army with a unit, also creates its rally point
    Army(Unit unit, Player player){

        super(player, unit.getLoc(), unit.getMap(),CID.giveCID(player, GameInfo.ARMY), StatsFactory.createStats(GameInfo.ARMY));

        commandFactory = new CommandFactory();

        this.addToArmy(unit);

        this.addToBattleGroup(unit);

        player.getArmies().add(getCID().getPersonelID(), this);
        RallyPoint rallyPoint = new RallyPoint(this);
        this.rallyPoint = rallyPoint;
        player.getRallyPoints().add(getCID().getPersonelID(), rallyPoint);
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