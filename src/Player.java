import java.util.ArrayList;

/**
 * Created by Zac on 1/31/2017.
 */
public class Player {
    int numUnits = 0;

    private boolean myTurn;

    ArrayList<ArrayList<Unit>> units;

    ArrayList<ArrayList<Structure>>  structures;

    ArrayList<Army> armies;

    ArrayList<RallyPoint>  rallyPoints;


    Location location; //this is the player's point of focus
    MenuState menuState;
    Map map; //made before player

    public Player(Map map){
        armies = new ArrayList<Army>(GameInfo.MAX_PER_TYPE);

        rallyPoints = new ArrayList<RallyPoint>(GameInfo.MAX_PER_TYPE);

        for(int i = 0; i < GameInfo.MAX_PER_TYPE; i++){
            armies.add(null);
            rallyPoints.add(null);
        }

        units = new ArrayList<ArrayList<Unit>>(GameInfo.UNIT_TYPES);

        for(int i = 0; i < GameInfo.UNIT_TYPES; i++){
            units.add(new ArrayList<Unit>(GameInfo.MAX_PER_TYPE));
            for(int j = 0; j < GameInfo.MAX_PER_TYPE; j++){
                units.get(i).add(null);
            }
        }

        structures = new ArrayList<ArrayList<Structure>>(GameInfo.STRUCTURE_TYPES);

        for(int i = 0; i < GameInfo.STRUCTURE_TYPES; i++){
            structures.add(new ArrayList<Structure>(GameInfo.MAX_PER_TYPE));

            for(int j = 0; j < GameInfo.MAX_PER_TYPE; j++){
                structures.get(i).add(null);
            }
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

    private ArrayList<? extends Controllable> getTypeArray(CID targetCID){
        switch(targetCID.modeID){
            case GameInfo.UNITMODE:
                return units.get(targetCID.typeID);

            case GameInfo.ARMYMODE:
                return armies;

            case GameInfo.RALLYPOINTMODE:
                return rallyPoints;

            case GameInfo.STRUCTUREMODE:
                return structures.get(targetCID.typeID);

        }

        return null;
    }

    public boolean register(Controllable newControllable){
        ArrayList<Controllable> targetArray = (ArrayList<Controllable>) getTypeArray(newControllable.getCID());

        for (int i = 0; i < GameInfo.MAX_PER_TYPE; i++){
            if(targetArray.get(i) == null && numUnits < 25){
                newControllable.getCID().personelID = i;
                targetArray.set(i, newControllable);
                numUnits++;
                return true;
            }
        }

        return false;
    }

    public void remove(Controllable controllableToBeRemoved){
        ArrayList<Controllable> targetArray = (ArrayList<Controllable>) getTypeArray(controllableToBeRemoved.getCID());

        if(controllableToBeRemoved.getCID().modeID == GameInfo.UNITMODE) { numUnits--; }

        targetArray.set(controllableToBeRemoved.getCID().getPersonelID(), null);
    }


    public void endTurn(){

        System.out.println("ENDING TURN");

        for(Army army : this.getArmies()){
            if(army != null){ army.doTurn(); }
        }

        for(ArrayList<Unit> units : this.getUnits()){
            for(Unit unit : units){
                if(unit != null){ unit.doTurn(); }
            }
        }

        for(ArrayList<Structure> structures : this.getStructures()){
            for(Structure struct : structures){
                if(struct != null){ struct.doTurn(); }
            }
        }

        for(Army army : this.getArmies()){
            if(army != null){ army.endTurn(); }
        }

        for(ArrayList<Unit> units : this.getUnits()){
            for(Unit unit : units){
                if(unit != null){ unit.endTurn(); }
            }
        }

        for(ArrayList<Structure> structures : this.getStructures()){
            for(Structure struct : structures){
                if(struct != null){ struct.endTurn(); }
            }
        }
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
        //System.out.println(modeType);
        return false;
    }

    public boolean isAlive() {

        for(ArrayList<Unit> units : this.getUnits()){
            for(Unit unit : units){
                if(unit != null){ return true; }
            }
        }

        for(ArrayList<Structure> structures : this.getStructures()){
            for(Structure struct : structures){
                if(struct != null){ return true; }
            }
        }

        return false;
    }

    public boolean isMyTurn() {
        return myTurn;
    }

    public void setMyTurn(boolean myTurn) {
        this.myTurn = myTurn;
    }
}
