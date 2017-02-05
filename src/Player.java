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


    Location location; //this is the player's point of focus
    MenuState menuState;
    Map map; //made before player

    public Player(Map map){
        armies = new ArrayList<Army>();

        rallyPoints = new ArrayList<RallyPoint>();

        units = new ArrayList<ArrayList<Unit>>();

        for(int i = 0; i < GameInfo.UNIT_TYPES; i++){
            units.add(new ArrayList<Unit>());
        }

        structures = new ArrayList<ArrayList<Structure>>();

        for(int i = 0; i < GameInfo.STRUCTURE_TYPES; i++){
            structures.add(new ArrayList<Structure>());
        }

        this.map = map;
        this.location = new Location(0, 0);

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

        units.get(target.getCID().typeID).remove(target.getCID().personelID);
    }

    public void remove(Structure target){
        structures.get(target.getCID().typeID).remove(target.getCID().personelID);
    }

    public boolean orderableExists(int modeType){
        if(modeType == GameInfo.UNITMODE) {
            System.out.println("CHECKING UNITMODE");
            for (int i = 0; i < units.size(); i++) {
                for (int j = 0; j < units.get(i).size(); j++) {
                    if (units.get(i).get(j) != null) {
                        return true;
                    }
                }
            }
        } else if(modeType==GameInfo.STRUCTUREMODE){
            System.out.println("CHECKING STRUCTUREMODE");
            for (int i = 0; i < structures.size(); i++) {
                for (int j = 0; j < structures.get(i).size(); j++) {
                    if (structures.get(i).get(j) != null){
                        return true;
                    }
                }
            }
        } else if(modeType==GameInfo.RALLYPOINTMODE){
            System.out.println("CHECKING RALLYPOINT");
            for (int i = 0; i < rallyPoints.size(); i++) {
                if (rallyPoints.get(i) != null){
                    return true;
                }
            }
        } else if(modeType==GameInfo.ARMYMODE){
            System.out.println("CHECKING ARMYMODE");
            for (int i = 0; i < rallyPoints.size(); i++) {
                if (armies.get(i) != null){
                    return true;
                }
            }
        }
        System.out.println(modeType);
        return false;
    }
}
