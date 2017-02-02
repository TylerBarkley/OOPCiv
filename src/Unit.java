/**
 * Created by Trevor on 1/30/2017.
 */

    public abstract class Unit extends Controllable {

    Army myArmy;
    double state;

    /*Player ownedByPlayer */
    void Standby(){
        state=1;
    }
    void powerDown(){
        state=.75;
    }
    void powerUp(){
        state=1.25;
    }

    /*TODO: make a  Move Rally Point*/

    void endTurn(){
        //TODO Resource Consumption at end of turn

        //Reset the unit's action points
        int possibleMovement = myArmy == null ? ((UnitStats) myStats).getMovement() : myArmy.getAvailableMovement();
        if((actionPoints += possibleMovement) < possibleMovement){
            actionPoints = possibleMovement;
        }
    }

    void clearCommands(){
        this.getCommandQueue().clear();
        this.actionPoints = myArmy == null ? ((UnitStats) myStats).getMovement() : myArmy.getAvailableMovement();
    }

    void move(Map.MapDirection md){
        Location targetLoc = loc.getAdjacent(md);
        Tile targetTile = map.getTile(targetLoc);

        if(targetTile.addUnit(this)){
           map.getTile(this.getLoc()).removeUnit(this);
           this.setLoc(targetLoc);
        }
        else{
            this.clearCommands();
        }
    }

    void killMe(){
        player.remove(this);
        map.getTile(getLoc()).removeUnit(this);
    }

    void printStats(){  }

    public UnitStats getStats() {return UnitStats;    }

    Unit(String unitType, Map currentMap){
        myStats = UnitStatsFactory.produceUnitStats(unitType);
        map=currentMap;
    }
}
