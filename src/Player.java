import java.util.ArrayList;

/**
 * Created by Zac on 1/31/2017.
 */
public class Player {
    int numUnits = 0;
    ArrayList<ArrayList<Unit>> units;
    ArrayList<ArrayList<Structure>>  structures;
    ArrayList<Army> armies;
    ArrayList<RallyPoint>  rallyPoints;

    MenuState menuState;

    public Player(){
        for(int i = 0; i < GameInfo.UNIT_TYPES; i++){
            units.add(new ArrayList<Unit>());
        }
        for(int i = 0; i < GameInfo.STRUCTURE_TYPES; i++){
            structures.add(new ArrayList<Structure>());
        }

        menuState = new MenuState(this);
    }

    ArrayList<ArrayList<Unit>> getUnits(){
        return units;
    }
    ArrayList<ArrayList<Structure>> getStructures(){
        return structures;
    }
    ArrayList<Army> getArmies(){
        return armies;
    }
    ArrayList<RallyPoint> getRallyPoints(){
        return rallyPoints;
    }
    MenuState getMenuState(){
        return menuState;
    }

    public void remove(Unit target){
        if(target.myArmy != null){
            //TODO target.myArmy.remove(target);
        }

        units.get(target.getCID().typeID).remove(target.getCID().personelID);
    }

    public void remove(Structure target){
        structures.get(target.getCID().typeID).remove(target.getCID().personelID);
    }
}
