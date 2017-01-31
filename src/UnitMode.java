import java.util.ArrayList;

/**
 * Created by hankerins on 1/31/17.
 */
public class UnitMode extends Mode {




    int cycleTypeL(){
        if(currentType == 0)
            currentType = 3;
        else currentType--;
        return currentType;
    }
    int cycleTypeR(){
        if(currentType == 3)
            currentType = 0;
        else currentType++;
        return currentType;
    }
    int cycleInstanceL(){
        ArrayList<ArrayList<Unit>> units = player.getUnits();

        return 0;
    }
    int cycleInstanceR(){
        return 0;
    }
}
