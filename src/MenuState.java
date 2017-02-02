import java.util.ArrayList;

/**
 * Created by hankerins on 1/31/17.
 */

/*  The MenuState holds the most recent state of menu navigation, including Mode, Type, Instance, and instruction
  * Pressing enter should create whatever command is dictated by the MenuState.
  * The individual Mode classes retain whatever state they had last time they were accessed.
  *
  * MENU STATE, MODES, TYPE MENUS, ETC ARE NOT STATIC SO THAT WE CAN HAVE 2 INSTANCES OF EACH: ONE FOR EITHER PLAYER
  * ^^ After discussing the above w/ an OOP alum, I've learned we should avoid static classes.
  *
  *
  * */
public class MenuState {

    //The following 4 stats define what happens when a player hits Enter
    //They should be visible to the player in the main menu
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
        if(currentMode == GameInfo.RALLYPOINTMODE)
            currentMode = GameInfo.STRUCTUREMODE;
        else currentMode--;
        return currentMode;
    }
    int cycleModeR(){
        if(currentMode == GameInfo.STRUCTUREMODE)
            currentMode = GameInfo.RALLYPOINTMODE;
        else currentMode++;
        return currentMode;
    }

    int cycleTypeL(){
        currentType = ModeList.get(currentMode).cycleTypeL();
        currentInstance = ModeList.get(currentMode).currentInstance; //needed because this method may change currentInstance in UnitMode
        return currentType;
    }

    int cycleTypeR(){
        currentType = ModeList.get(currentMode).cycleTypeR();
        currentInstance = ModeList.get(currentMode).currentInstance; //needed because this method may change currentInstance in UnitMode
        return currentType;
    }

    int cycleInstanceL(){
        currentInstance = ModeList.get(currentMode).cycleInstanceL();
        return currentInstance;
    }

    int cycleInstanceR(){
        currentInstance = ModeList.get(currentMode).cycleInstanceR();
        return currentInstance;
    }


}
