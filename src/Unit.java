/**
 * Created by Trevor on 1/30/2017.
 */
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
        actionPoints = myArmy == null ? stats.movement : myArmy.stats.movement;
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

    void healMe(){

    }

    void damageMe(){

    }

    void killMe(){
        player.remove(this);
        map.getTile(getLoc()).removeUnit(this);
    }

    void printStats(){
        unitStats.print();
    }

    Unit(String unitType,Tile tileCreatedOn, Map currentMap){
        tileCreatedOn.addUnit(this);
        unitStats=StatsFactory.produceStats(unitType);
        currentTileOn=tileCreatedOn;
        map=currentMap;
    }
}
