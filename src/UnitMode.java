import java.util.ArrayList;

/**
 * Created by hankerins on 1/31/17.
 */
public class UnitMode extends Mode {

    ArrayList<ArrayList<Unit>> units;

    UnitMode(Player player){
        this.player = player;
        units = player.getUnits();
    }

    //CycleType methods reset the instance to 0 because we have different #s of different troops.
    int cycleTypeL(){
        currentInstance = 0;
        if(currentType == GameInfo.EXPLORER)
            currentType = GameInfo.RANGEDUNIT;
        else currentType--;
        return currentType;
    }
    int cycleTypeR(){
        currentInstance = 0;
        if(currentType == GameInfo.RANGEDUNIT)
            currentType = GameInfo.EXPLORER;
        else currentType++;
        return currentType;
    }
    int cycleInstanceL(){
        int lastInstance = units.get(currentType).size() -1;
        if(currentInstance == 0)
            currentInstance = lastInstance;
        else currentInstance--;
        return currentInstance;
    }
    int cycleInstanceR(){
        int lastInstance = units.size() - 1;
        if(currentInstance == lastInstance)
            currentInstance = 0;
        else currentInstance++;
        return currentInstance;
    }
}
