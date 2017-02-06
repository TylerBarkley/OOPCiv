/**
 * Created by hankerins on 1/31/17.
 */
public abstract class Structure extends Concrete {

    private double state;
    private String structureType;

    public Structure(Player player, Location loc, Map map, Stats myStats) {
        super(player, loc, map, myStats);

        this.getCID().modeID = GameInfo.STRUCTUREMODE;
    }

    void powerDown(){
        state=.75;
    }
    void powerUp(){
        state=1.25;
    }

    public void doTurn(){

        while(getActionPointCap() > 0 && !getCommandQueue().isEmpty()) {
            getCommandQueue().carryOut();
        }

    }

    void endTurn() {

        setActionPoints(getActionPoints() + getActionPointCap());
        if(getActionPoints() > getActionPointCap()){
            setActionPoints(getActionPointCap());
        }

    }

    void killMe(){
        getPlayer().remove(this);
        getMap().getTile(getLoc()).removeStructure();
    }

    @Override
    void clearCommands() {
        this.getCommandQueue().clear();
        setActionPoints(getActionPointCap());
    }
    
    public String toString() {
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
