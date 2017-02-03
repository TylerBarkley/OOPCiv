import java.util.ArrayList;

/**
 * Created by hankerins on 1/31/17.
 */

//TODO: implement abstract methods
public class Army extends Controllable {
    ArrayList<Unit> battleGroup;
    ArrayList<Unit> reinforcements;
    ArrayList<Unit> entireArmy;

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
        if(arrived.getUnitStats().getMovement() < getAvailableMovement()){
            setAvailableMovement(arrived.getUnitStats().getMovement());
        }
    }
    void move(char cardinalDirection){

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

    //TODO: delete this default army constructor (or make it useful
    Army(){

    }
}
