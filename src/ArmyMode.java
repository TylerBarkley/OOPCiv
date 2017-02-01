import java.util.ArrayList;

/**
 * Created by hankerins on 1/31/17.
 */
public class ArmyMode extends Mode {

    ArrayList<Army> armies;

    //Constructor

    ArmyMode(Player player){
        this.player = player;
        armies = player.getArmies();
    }




    //CycleType methods DO NOT reset instance because there is a 1:1:1 ratio between types
    int cycleTypeL(){
        if(currentType == GameInfo.ENTIREARMY)
            currentType = GameInfo.REINFORCEMENTS;
        else currentType--;
        return currentType;
    }
    int cycleTypeR(){
        if(currentType == GameInfo.REINFORCEMENTS)
            currentType = GameInfo.ENTIREARMY;
        else currentType++;
        return currentType;
    }
    int cycleInstanceL(){
        int lastInstance = armies.size() -1;
        if(currentInstance == 0)
            currentInstance = lastInstance;
        else currentInstance--;
        return currentInstance;
    }
    int cycleInstanceR(){
        int lastInstance = armies.size() - 1;
        if(currentInstance == lastInstance)
            currentInstance = 0;
        else currentInstance++;
        return currentInstance;
    }
}
