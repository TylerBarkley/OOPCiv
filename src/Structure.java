/**
 * Created by hankerins on 1/31/17.
 */
public class Structure extends Concrete {

    private double state;
    private String structureType;
    private double ProductionRates;

    public Structure(Player player, Location loc, Map map, CID cid, Stats myStats, int actionPointCap, int ProductionRates) {
        super(player, loc, map, cid, myStats, actionPointCap);
        this.ProductionRates = ProductionRates;
    }

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
    
    String getStructureType() {
    	return structureType;
    }
    
//    public UnitStats getStats() {return StructureStats;    }

    //TODO BE FULLY IMPLEMENTED FOR STRUCTURES


    public void setStructureType(String structureType) {
        this.structureType = structureType;
    }

    public double getState() {
        return state;
    }

    public void setState(double state) {
        this.state = state;
    }
}
