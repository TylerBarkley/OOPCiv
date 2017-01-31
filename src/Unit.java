/**
 * Created by Trevor on 1/30/2017.
 */
public class Unit extends Controllable {
    Tile currentTileOn;
    Map map;
    char displayCharacter='U';
    char cardinalDirectionFacing;
    void move(char cardinalDirection){
        currentTileOn.removeUnit(this);
       switch(cardinalDirection){
           case 'N': map.map[currentTileOn.xPosition-1][currentTileOn.yPosition].addUnit(this);//North
                    currentTileOn= map.map[currentTileOn.xPosition-1][currentTileOn.yPosition];
                    break;
           case 'S': map.map[currentTileOn.xPosition+1][currentTileOn.yPosition].addUnit(this); //South
                    currentTileOn= map.map[currentTileOn.xPosition+1][currentTileOn.yPosition];
                     break;
           case 'E': map.map[currentTileOn.xPosition][currentTileOn.yPosition+1].addUnit(this);  //East
                     currentTileOn=map.map[currentTileOn.xPosition][currentTileOn.yPosition+1];
                    break;
           case 'W':  map.map[currentTileOn.xPosition][currentTileOn.yPosition-1].addUnit(this);  //Weast
                    currentTileOn=map.map[currentTileOn.xPosition][currentTileOn.yPosition-1];
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
    Unit(Tile tileCreatedOn, Map currentMap){
        tileCreatedOn.addUnit(this);
        currentTileOn=tileCreatedOn;
        map=currentMap;
    }
}
