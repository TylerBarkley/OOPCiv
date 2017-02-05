import java.util.ArrayList;

/**
 * Created by Trevor on 1/30/2017.
 */
public class Tile {

    Location loc;

    Terrain terrainType;

    private ArrayList<Unit> unitsOnTile;

    Structure structOnTile;

    Tile(Location loc, char terrainType){
        this.loc = loc;
        setUnitsOnTile(new ArrayList<Unit>(GameInfo.MAX_UNITS));
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

    boolean openTile(Player player){
        if(structOnTile.getPlayer() != player){
            return false;
        }

        for(Unit unit : getUnitsOnTile()){
            if(unit.getPlayer() != player){
                return false;
            }

            else{
                return true;
            }
        }

        return true;
    }

    boolean isTraversable(Unit unitMovingToTile){
        return terrainType.isTraversableBy(unitMovingToTile);
    }

    boolean addUnit(Unit toBeAddedUnit){
        System.out.println("Added Unit");
        if(!isTraversable(toBeAddedUnit)){ return false; }
        getUnitsOnTile().add(toBeAddedUnit);
        terrainType.effect(toBeAddedUnit);
        return true;
    }

    void removeUnit(Unit toBeDeletedUnit){
        System.out.println("Removed Unit");
        getUnitsOnTile().remove(toBeDeletedUnit);
        System.out.println(getUnitsOnTile().size());
    }

    void removeStructure(){
        structOnTile = null;
    }

    void addStructure(Structure struct){
        structOnTile = struct;
    }

    public ArrayList<Unit> getUnitsOnTile() {
        return unitsOnTile;
    }

    public void setUnitsOnTile(ArrayList<Unit> unitsOnTile) {
        this.unitsOnTile = unitsOnTile;
    }
}
