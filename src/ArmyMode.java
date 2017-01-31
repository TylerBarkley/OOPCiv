import java.util.ArrayList;

/**
 * Created by hankerins on 1/31/17.
 */
public class ArmyMode extends Mode {







    int currentType = 0;
    int currentInstance = 0;
    int currentInstruction = 0;

    //ArrayList<TypeMode> TypeModeList;

    //Constructor
    //This is one possible approach, submode cycling.
    // I'm gonna try another approach in the Unit mode and see if its better
    /*ArmyMode(){
        TypeMode ea = new EntireArmyTypeMode();
        TypeMode bg = new BattleGroupTypeMode();
        Mode r = new ReinforcementsTypeMode();
        TypeModeList.add(ea);
        TypeModeList.add(bg);
        TypeModeList.add(r);
    }*/
    ArmyMode(Player player){
        this.player = player;
    }





    int cycleTypeL(){
        if(currentType == 0)
            currentType = 2;
        else currentType--;
        return currentType;
    }
    int cycleTypeR(){
        if(currentType == 2)
            currentType = 0;
        else currentType++;
        return currentType;
    }
}
