/**
 * Created by hankerins on 1/31/17.
 */
public class Structure extends Concrete {

    double state;
    private String structureType;
    private StructureStats structureStats;
    
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
        getPlayer().remove(this);

//      map.getTile(getLoc()).removeStructure();
    }

    @Override
    void clearCommands() {
        this.getCommandQueue().clear();
        setActionPoints(getActionPointCap());
    }

    void printStats(){ }
    
    StructureStats getStructureStats() {
    	return structureStats;
    }
    
    String getStructureType() {
    	return structureType;
    }
    
//    public UnitStats getStats() {return StructureStats;    }

    //TODO BE FULLY IMPLEMENTED FOR STRUCTURES
    Structure(String structureType,Tile tileCreatedOn, Map currentMap){
//        tileCreatedOn.addStructure(this);
        myStats = StructureStatsFactory.produceStructureStats(structureType);
//        currentTileOn=tileCreatedOn;
        setMap(currentMap);
        setActionPointCap(1);
    }

    //TODO: delete or fix this default constructor
    Structure(){

    }

    public void setStructureStats(StructureStats structureStats) {
        this.structureStats = structureStats;
    }

    public void setStructureType(String structureType) {
        this.structureType = structureType;
    }
}
