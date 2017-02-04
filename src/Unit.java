/**
 * Created by Trevor on 1/30/2017.
 */

    public abstract class Unit extends Concrete {

    Army myArmy;
    double state;
    String unitType;
    UnitStats unitstats;

    Player player;

    void standby(){
        state=1;
    }
    void powerDown(){
        state=.75;
    }
    void powerUp(){
        state=1.25;
    }

    /*TODO: make a  Move Rally Point*/

    public void doTurn(){

        while(getActionPointCap() > 0 && !getCommandQueue().isEmpty()) {
            getCommandQueue().carryOut();
        }

        if(getCommandQueue().isEmpty()){
            setActionPoints(getActionPointCap());
        }
    }

    void endTurn(){
        //TODO Resource Consumption at end of turn

        //Reset the unit's action points
        int possibleMovement = myArmy == null ? ((UnitStats) myStats).getMovement() : myArmy.getAvailableMovement();
        setActionPoints(getActionPoints() + possibleMovement);
        if(getActionPoints() > possibleMovement){
            setActionPoints(possibleMovement);
        }
    }

    void clearCommands(){
        this.getCommandQueue().clear();
        setActionPoints(myArmy == null ? getActionPointCap() : myArmy.getAvailableMovement());
    }

    void move(Map.MapDirection md){
        Location targetLoc = getLoc().getAdjacent(md);
        Tile targetTile = getMap().getTile(targetLoc);

        if(targetTile.addUnit(this)){
           getMap().getTile(this.getLoc()).removeUnit(this);
           this.setLoc(targetLoc);
        }
        else{
            this.clearCommands();
        }
    }

    void killMe(){
        getPlayer().remove(this);
        getMap().getTile(getLoc()).removeUnit(this);
    }
    
    String getUnitType() {
    	return unitType;
    }
    
    UnitStats getUnitStats() {
    	return unitstats;
    }

    Unit(String unitType, Map currentMap){
        setMyStats(UnitStatsFactory.produceUnitStats(unitType));
        setMap(currentMap);
        setActionPointCap(((UnitStats) myStats).getMovement());
        this.unitType = unitType;
    }

    Army makeArmy(){
        Army army = new Army(this, player);
        return army;
    }

    void joinArmy(Army army){
        myArmy = army;
        army.getEntireArmy().add(this);
        army.getReinforcements().add(this);
    }

//TODO: get rid of empty constructor for units below (used for testing)

    Unit(){
        unitType = "placeholder";
    }

    Unit(Player player){
        this.player = player;
        this.standby();
        unitType = "placeholder";
    }
}
