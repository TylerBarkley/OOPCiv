import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trevor on 1/30/2017.
 */
public class Tile {

    Location loc;

    Terrain terrainType;

    ArrayList<Unit> unitsOnTile;

    Structure structOnTile;

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
        return true;
    }

    void removeUnit(Unit toBeDeletedUnit){
        System.out.println("Removed Unit");
        unitsOnTile.remove(toBeDeletedUnit);
        System.out.println(unitsOnTile.size());
    }

    void removeStructure(){
        structOnTile = null;
    }

    void addStructure(Structure struct){
        structOnTile = struct;
    }
}
