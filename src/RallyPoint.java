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

    //TODO: delete or fix this default constructor
    RallyPoint(){

    }
    RallyPoint(Army army){
        this.army = army;
    }
}
