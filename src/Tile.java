import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trevor on 1/30/2017.
 */
public class Tile {

    Location loc;

    Terrain terrainType;

    ArrayList<Unit> unitsOnTile;

    Tile(Location loc, char terrainType){
        this.loc = loc;
        unitsOnTile=new ArrayList<Unit>(GameInfo.MAX_UNITS);
        if(terrainType=='W') {
            this.terrainType = new Water(new AOENothing());
        }
        if(terrainType=='M'){
            this.terrainType=new Mountain(new AOENothing());
        }
        if(terrainType=='G'){
            this.terrainType=new Ground(new AOENothing());
        }

    }

    boolean isTraversable(Unit unitMovingToTile){
        return terrainType.isTraversableBy(unitMovingToTile);
    }

    boolean addUnit(Unit toBeAddedUnit){
        System.out.println("Added Unit");
        if(!isTraversable(toBeAddedUnit)){ return false; }
        unitsOnTile.add(toBeAddedUnit);
        terrainType.effect(toBeAddedUnit);
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
