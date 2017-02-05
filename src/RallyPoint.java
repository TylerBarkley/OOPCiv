/**
 * Created by hankerins on 1/31/17.
 */

public class RallyPoint extends Controllable {

    Army army;

    @Override
    void endTurn() {

    }

    @Override
    void doTurn(){

    }


    void killMe() {

    }

    @Override
    void clearCommands() {

    }


    RallyPoint(Army army){
        super(army.getPlayer(), army.getLoc(), army.getMap(), CID.giveCID(army.getPlayer(), GameInfo.RALLYPOINT));
        this.army = army;
    }
}
