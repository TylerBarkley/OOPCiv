import java.util.ArrayList;

/**
 * Created by hankerins on 1/31/17.
 */
public class StructureMode extends Mode {

    ArrayList<ArrayList<Structure>> structures;

    StructureMode(Player player){
        this.player = player;
        structures = player.getStructures();
    }



    int cycleTypeL(){
        return currentType;
    } //These do nothing while there is only one structure type
    int cycleTypeR(){
        return currentType;
    } //When we add more structure types, copy UnitMode.java

    int cycleInstanceL(){
        int lastInstance = structures.get(currentType).size() -1;
        if(currentInstance == 0)
            currentInstance = lastInstance;
        else currentInstance--;
        return currentInstance;
    }
    int cycleInstanceR(){
        int lastInstance = structures.size() - 1;
        if(currentInstance == lastInstance)
            currentInstance = 0;
        else currentInstance++;
        return currentInstance;
    }
}
