/**
 * Created by Trevor on 1/30/2017.
 */

    public abstract class Unit extends Concrete {
    private Army myArmy;
    private boolean battleGroup;


    //CONSTRUCTOR

    public Unit(Player player, Location loc, Map map, Stats myStats) {
        super(player, loc, map, myStats);

        this.getCID().modeID = GameInfo.UNITMODE;
        //Code to put this Unit into the appropriate place in player's Unit Array
        player.getUnits().get(cid.getTypeID()).add(cid.getPersonelID(), this);

        myArmy = null;
        state = 1.0;
        this.setFacingDirection(Map.MapDirection.NORTH);
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
        int possibleMovement = battleGroup ? this.getActionPointCap() : myArmy.getAvailableMovement();
        setActionPoints(getActionPoints() + possibleMovement);
        if(getActionPoints() > possibleMovement){
            setActionPoints(possibleMovement);
        }
    }

    void clearCommands(){
        this.getCommandQueue().clear();
        setActionPoints(battleGroup ? getActionPointCap() : myArmy.getAvailableMovement());
    }

    void move(Map.MapDirection md){

        Location targetLoc = getLoc().getAdjacent(md);
        Tile targetTile = getMap().getTile(targetLoc);

        if(!targetTile.openTile(this.getPlayer())){
            this.myArmy.getRallyPoint().redoPaths();
            return;
        }

        targetTile.addUnit(this);
        getMap().getTile(this.getLoc()).removeUnit(this);
        this.setLoc(targetLoc);
        this.setFacingDirection(md);

        if(battleGroup){
            this.myArmy.setLoc(this.getLoc());
        }
    }

    void killMe(){
        getPlayer().remove(this);
        myArmy.remove(this);
        getMap().getTile(getLoc()).removeUnit(this);
    }

    public boolean isBattleGroup(){
        return battleGroup;
    }

    Army makeArmy(){
        this.battleGroup = true;
        return new Army(this, getPlayer());
    }

    void joinArmy(Army army){
        myArmy = army;
        army.getEntireArmy().add(this);
        army.getReinforcements().add(this);
    }

    public void setBattleGroup(boolean battleGroup) {
        this.battleGroup = battleGroup;
    }

    public void setMyArmy(Army myArmy) {
        this.myArmy = myArmy;
    }

    public Army getMyArmy(){return myArmy;}

//TODO: get rid of empty constructor for units below (used for testing)
}
