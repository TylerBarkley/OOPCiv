import java.util.ArrayList;

/**
 * Created by hankerins on 1/31/17.
 */

/*  The MenuState holds the most recent state of menu navigation, including Mode, Type, Instance, and instruction
  * Pressing enter should create whatever command is dictated by the MenuState.
  * The individual Mode classes retain whatever state they had last time they were accessed.
  *
  * MENU STATE, MODES, TYPE MENUS, ETC ARE NOT STATIC SO THAT WE CAN HAVE 2 INSTANCES OF EACH: ONE FOR EITHER PLAYER
  *
  *
  * */
public class MenuState {

    //The following stats define what happens when a player hits Enter: currentInstance, currentInstruction
    //They should be visible to the player in the main menu
    int currentMode = GameInfo.RALLYPOINTMODE;
    int currentType = 0;
    int currentInstanceIndex = 0;
    Controllable currentInstance;
    Instruction currentInstruction;

    int getCurrentMode(){
        return currentMode;
    }

    int getCurrentType(){
        return currentType;
    }

    int getCurrentInstanceIndex(){
        return currentInstanceIndex;
    }

    Controllable getCurrentInstance(){
        return currentInstance;
    }

    Instruction getCurrentInstruction(){
        return currentInstruction;
    }

    void setCurrentMode(int currentMode){
        this.currentMode = currentMode;
    }

    void setCurrentType(int currentType){
        this.currentType = currentType;
    }

    void setCurrentInstanceIndex(int currentInstanceIndex){
        this.currentInstanceIndex = currentInstanceIndex;
    }

    void setCurrentInstance(Controllable currentInstance){
        this.currentInstance = currentInstance;
    }

    void setCurrentInstruction(Instruction currentInstruction){
        this.currentInstruction = currentInstruction;
    }

    String getCurrentTypeString(){
        if(currentMode == GameInfo.RALLYPOINTMODE){
            return "Rally Point";
        }
        if(currentMode == GameInfo.UNITMODE){
            if(currentType == GameInfo.EXPLORER){
                return "Explorer";
            }
            else if(currentType == GameInfo.COLONIST){
                return "Colonist";
            }
            else if(currentType == GameInfo.MELEEUNIT){
                return "Melee Unit";
            }
            else if(currentType == GameInfo.RANGEDUNIT){
                return "Ranged Unit";
            }
        }
        return "blah";
    }

    Player player;

    ArrayList<Mode> ModeList;

    //Constructor
    MenuState(Player player){
        this.player = player;
        Mode rp = new RallyPointMode(player);
        Mode a = new ArmyMode(player);
        Mode u = new UnitMode(player);
        Mode s = new StructureMode(player);
        ModeList = new ArrayList<Mode>();
        ModeList.add(rp);
        ModeList.add(a);
        ModeList.add(u);
        ModeList.add(s);
        currentInstruction = ModeList.get(currentMode).getCurrentInstruction();
    }

    int cycleModeL(){
        if(currentMode == GameInfo.RALLYPOINTMODE)
            currentMode = GameInfo.STRUCTUREMODE;
        else currentMode--;
        currentInstruction = ModeList.get(currentMode).getCurrentInstruction();
        return currentMode;
    }
    int cycleModeR(){
        if(currentMode == GameInfo.STRUCTUREMODE)
            currentMode = GameInfo.RALLYPOINTMODE;
        else currentMode++;
        currentInstruction = ModeList.get(currentMode).getCurrentInstruction();
        return currentMode;
    }

    int cycleTypeL(){
        currentType = ModeList.get(currentMode).cycleTypeL();
        currentInstanceIndex = ModeList.get(currentMode).getCurrentInstanceIndex(); //needed because this method may change currentInstanceIndex in UnitMode
        currentInstance = ModeList.get(currentMode).getCurrentInstance();
        return currentType;
    }

    int cycleTypeR(){
        currentType = ModeList.get(currentMode).cycleTypeR();
        currentInstanceIndex = ModeList.get(currentMode).getCurrentInstanceIndex(); //needed because this method may change currentInstanceIndex in UnitMode
        currentInstance = ModeList.get(currentMode).getCurrentInstance();
        return currentType;
    }

    Controllable cycleInstanceL(){
        currentInstance = ModeList.get(currentMode).cycleInstanceL();
        currentInstanceIndex = ModeList.get(currentMode).getCurrentInstanceIndex();
        return currentInstance;
    }

    Controllable cycleInstanceR(){
        currentInstance = ModeList.get(currentMode).cycleInstanceR();
        currentInstanceIndex = ModeList.get(currentMode).getCurrentInstanceIndex();
        return currentInstance;
    }

    Instruction cycleInstructionL(){
        currentInstruction = ModeList.get(currentMode).cycleInstructionL();
        return currentInstruction;
    }

    Instruction cycleInstructionR(){
        currentInstruction = ModeList.get(currentMode).cycleInstructionR();
        return currentInstruction;
    }


}