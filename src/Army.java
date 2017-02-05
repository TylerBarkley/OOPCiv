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

    public void doTurn(){
        //TODO Make method that does every available command
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
        if(arrived.getActionPointCap() < getAvailableMovement()){
            setAvailableMovement(arrived.getActionPointCap());
        }
    }

    @Override
    void endTurn() {

    }

    @Override
    void killMe() {

    }

    @Override
    void clearCommands() {

    }

    void remove(Unit target){
        entireArmy.remove(target);
        battleGroup.remove(target);
        reinforcements.remove(target);
    }

    //Make an army with a unit, also creates its rally point
    Army(Unit unit, Player player){
        super(player, unit.getLoc(), unit.getMap(),null, null);
        entireArmy.add(unit);
        battleGroup.add(unit);
        player.getArmies().add(this);
        RallyPoint rallyPoint = new RallyPoint(this);
        this.rallyPoint = rallyPoint;
        player.getRallyPoints().add(rallyPoint);
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
