import java.util.ArrayList;

/**
 * Created by hankerins on 1/31/17.
 */

/*MENU STATE, MODES, TYPE MENUS, ETC ARE NOT STATIC SO THAT WE CAN HAVE 2 INSTANCES OF EACH: ONE FOR EITHER PLAYER
 * AT LEAST THAT'S MY EXPLANATION, REALLY I JUST SUCK AT STATIC CLASSES. */
public class MenuState {

    public final static int RALLYPOINTMODE  = 0;
    public final static int ARMYMODE       	= 1;
    public final static int UNITMODE       	= 2;
    public final static int STRUCTUREMODE   = 3;

    int currentMode = 0;
    int currentType = 0;
    int currentInstance = 0;
    int currentInstruction = 0;

    Player player;

    ArrayList<Mode> ModeList;

    //Constructor
    MenuState(Player player){
        this.player = player;
        Mode rp = new RallyPointMode(player);
        Mode a = new ArmyMode(player);
        Mode u = new UnitMode(player);
        Mode s = new StructureMode(player);
        ModeList.add(rp);
        ModeList.add(a);
        ModeList.add(u);
        ModeList.add(s);
    }

    int cycleModeL(){
        if(currentMode == 0)
            currentMode = 3;
        else currentMode--;
        return currentMode;
    }
    int cycleModeR(){
        if(currentMode == 3)
            currentMode = 0;
        else currentMode++;
        return currentMode;
    }

    int cycleTypeL(){
        currentType = ModeList.get(currentMode).cycleTypeL();
        return currentType;
    }

    int cycleTypeR(){
        currentType = ModeList.get(currentMode).cycleTypeR();
        return currentType;
    }



}
