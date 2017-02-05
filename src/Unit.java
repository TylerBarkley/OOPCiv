/**
 * Created by Trevor on 1/30/2017.
 */

    public abstract class Unit extends Concrete {
    String unitType;
    Army myArmy;
    double state;

    public Unit(Player player, Location loc, Map map, CID cid, Stats myStats, int actionPointCap) {
        super(player, loc, map, cid, myStats, actionPointCap);
        myArmy = null;
        state = 1.0;
    }

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

    }

    void endTurn(){
        //TODO Resource Consumption at end of turn

        //Reset the unit's action points
        int possibleMovement = myArmy == null ? this.getActionPointCap() : myArmy.getAvailableMovement();
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
        myArmy.remove(this);
        getMap().getTile(getLoc()).removeUnit(this);
    }

    Army makeArmy(){
        return new Army(this, getPlayer());
    }

    void joinArmy(Army army){
        myArmy = army;
        army.getEntireArmy().add(this);
        army.getReinforcements().add(this);
    }
    public String toString(){
        return unitType;
    }

//TODO: get rid of empty constructor for units below (used for testing)
}
