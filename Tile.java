import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trevor on 1/30/2017.
 */
public class Tile {
    public int xPosition;
    public int yPosition;
    ArrayList<Unit> unitsOnTile;
    Tile(int xPosition,int yPosition){
        this.xPosition=xPosition;
        this.yPosition=yPosition;
        unitsOnTile=new ArrayList<Unit>();
    }
    boolean isPassable(Unit unitMovingToTile){
        return true;
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
            System.out.print("U");
        }else {
            System.out.print("T");
        }
    }

}
