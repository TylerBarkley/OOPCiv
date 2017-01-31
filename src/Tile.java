import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trevor on 1/30/2017.
 */
public class Tile {

    public int xPosition;

    public int yPosition;

    Terrain terrainType;

    ArrayList<Unit> unitsOnTile;

    Tile(int xPosition,int yPosition, char terrainType){
        this.xPosition=xPosition;
        this.yPosition=yPosition;
        unitsOnTile=new ArrayList<Unit>();
        if(terrainType=='W') {
            this.terrainType = new Water();
        }
        if(terrainType=='M'){
            this.terrainType=new Mountain();
        }
        if(terrainType=='G'){
            this.terrainType=new Ground();
        }

    }

    boolean isTraversable(Unit unitMovingToTile){
        return terrainType.isTraversableBy(unitMovingToTile);
    }

    void addUnit(Unit toBeAddedUnit){
        System.out.println("Added Unit");
        unitsOnTile.add(toBeAddedUnit);
    }

    void removeUnit(Unit toBeDeletedUnit){
        System.out.println("Removed Unit");
        unitsOnTile.remove(toBeDeletedUnit);
        System.out.println(unitsOnTile.size());
    }

    void print(){
        if(unitsOnTile.size()>0){
            System.out.print(unitsOnTile.get(0).displayCharacter);
        }else {
            terrainType.print();
        }
    }

}
