/**
 * Created by Trevor on 1/30/2017.
 */

public abstract class Unit extends Controllable {
    int unitID;


    Tile currentTileOn;

    Map map;

    Stats unitStats;

    char displayCharacter='U';

    char cardinalDirectionFacing;

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


    void move(char cardinalDirection){
        currentTileOn.removeUnit(this);
       switch(cardinalDirection) {
           case 'N':
               if (map.map[currentTileOn.xPosition - 1][currentTileOn.yPosition].isTraversable(this)) {
                   map.map[currentTileOn.xPosition - 1][currentTileOn.yPosition].addUnit(this);//North
                   currentTileOn = map.map[currentTileOn.xPosition - 1][currentTileOn.yPosition];
               } else {
                   currentTileOn.addUnit(this);//Add the unit back, move not successful
               }
               break;
           case 'S':
               if (map.map[currentTileOn.xPosition + 1][currentTileOn.yPosition].isTraversable(this)) {
                   map.map[currentTileOn.xPosition + 1][currentTileOn.yPosition].addUnit(this); //South
                   currentTileOn = map.map[currentTileOn.xPosition + 1][currentTileOn.yPosition];
               } else {
                   currentTileOn.addUnit(this); //Add the unit back, move not successful
               }
               break;
           case 'E':
               if (map.map[currentTileOn.xPosition][currentTileOn.yPosition+1].isTraversable(this)) {
                   map.map[currentTileOn.xPosition][currentTileOn.yPosition + 1].addUnit(this);  //East
                   currentTileOn = map.map[currentTileOn.xPosition][currentTileOn.yPosition + 1];
               } else {
                    currentTileOn.addUnit(this);
               }

                    break;
           case 'W':
               if (map.map[currentTileOn.xPosition][currentTileOn.yPosition-1].isTraversable(this)) {
                   map.map[currentTileOn.xPosition][currentTileOn.yPosition -1].addUnit(this);  //East
                   currentTileOn = map.map[currentTileOn.xPosition][currentTileOn.yPosition-1];
               } else {
                   currentTileOn.addUnit(this);
               }
               break;
           case 'A':  map.map[currentTileOn.xPosition-1][currentTileOn.yPosition-1].addUnit(this);//North Weast
                    currentTileOn=map.map[currentTileOn.xPosition-1][currentTileOn.yPosition-1];
                    break;
           case 'B':  map.map[currentTileOn.xPosition-1][currentTileOn.yPosition+1].addUnit(this);//North East
                    currentTileOn=map.map[currentTileOn.xPosition-1][currentTileOn.yPosition+1];
                    break;
           case 'C':  map.map[currentTileOn.xPosition+1][currentTileOn.yPosition+1].addUnit(this); //South East
                    currentTileOn= map.map[currentTileOn.xPosition+1][currentTileOn.yPosition+1];
                    break;
           case 'D': map.map[currentTileOn.xPosition+1][currentTileOn.yPosition-1].addUnit(this);  //South Weast
                    currentTileOn=map.map[currentTileOn.xPosition+1][currentTileOn.yPosition-1];
                    break;
       }
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
