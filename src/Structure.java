/**
 * Created by hankerins on 1/31/17.
 */
public class Structure extends Controllable {

    StructureStats structurestats;
    double state;

    void powerDown(){
        state=.75;
    }
    void powerUp(){
        state=1.25;
    }

    public void doTurn(){
        //TODO
    }

    void endTurn() {
        //TODO Resource Consumption at end of turn
        //TODO Unit Production at end of turn
    }

    void killMe(){
        player.remove(this);

//      map.getTile(getLoc()).removeStructure();
    }

    void printStats(){
        structurestats.print();
    }

//    public UnitStats getStats() {return StructureStats;    }

    //TODO BE FULLY IMPLEMENTED FOR STRUCTURES
    Structure(String structureType,Tile tileCreatedOn, Map currentMap){
//        tileCreatedOn.addStructure(this);
        structurestats=StructureStatsFactory.produceStructureStats(structureType);
//        currentTileOn=tileCreatedOn;
        map=currentMap;
    }
}
