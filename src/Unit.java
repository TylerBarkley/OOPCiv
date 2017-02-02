/**
 * Created by Trevor on 1/30/2017.
 */

    public abstract class Unit extends Controllable {

    Army myArmy;
    UnitStats unitstats;
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
        actionPoints = myArmy == null ? unitstats.movement : myArmy.stats.movement;
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

    void printStats(){
        unitstats.print();
    }

    public UnitStats getStats() {return UnitStats;    }

    Unit(String unitType,Tile tileCreatedOn, Map currentMap){
        tileCreatedOn.addUnit(this);
        unitstats=UnitStatsFactory.produceUnitStats(unitType);
        currentTileOn=tileCreatedOn;
        map=currentMap;
    }
}
