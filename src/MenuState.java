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
    int currentMode = GameInfo.UNITMODE;
    int currentType = 0;
    int currentInstanceIndex = 0;
    Controllable currentInstance;
    Instruction currentInstruction;

    Player player;

    ArrayList<Mode> ModeList;

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
        if(currentMode == GameInfo.ARMYMODE){
            return "Army";
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
        if(currentMode == GameInfo.STRUCTUREMODE){
            if(currentType == GameInfo.BASE){
                return "Base";
            }
        }
        return "blah";
    }
    String getCurrentModeString(){
        if(currentMode == GameInfo.RALLYPOINTMODE){
            return "Rally Point";
        }
        if(currentMode == GameInfo.ARMYMODE){
            return "Army";
        }
        if(currentMode == GameInfo.UNITMODE){
            return "Unit";
        }
        if(currentMode == GameInfo.STRUCTUREMODE){
            return "Structure";
        }
        return "blah";
    }



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
        int startedMode = currentMode;
        do{
            currentMode--;
            if(currentMode < GameInfo.RALLYPOINTMODE) {
                currentMode = GameInfo.STRUCTUREMODE;
            }
        } while(!player.orderableExists(currentMode) && currentMode != startedMode);
        currentInstruction = ModeList.get(currentMode).getCurrentInstruction();
        return currentMode;
    }
    int cycleModeR(){
        int startedMode=currentMode;
        do{
            currentMode++;
            if(currentMode>GameInfo.STRUCTUREMODE) {
                currentMode = GameInfo.RALLYPOINTMODE;
            }
        }while(!player.orderableExists(currentMode)&&currentMode!=startedMode);
        currentInstruction = ModeList.get(currentMode).getCurrentInstruction();
        return currentMode;
    }

    /*int cycleModeL(){
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
    }*/

    int cycleTypeL(){
        currentType = ModeList.get(currentMode).cycleTypeL();
        currentInstanceIndex = ModeList.get(currentMode).getCurrentInstanceIndex(); //needed because this method may change currentInstanceIndex in UnitMode
        currentInstance = ModeList.get(currentMode).getCurrentInstance();
        updateInstruction();
        return currentType;
    }

    int cycleTypeR(){
        currentType = ModeList.get(currentMode).cycleTypeR();
        currentInstanceIndex = ModeList.get(currentMode).getCurrentInstanceIndex(); //needed because this method may change currentInstanceIndex in UnitMode
        currentInstance = ModeList.get(currentMode).getCurrentInstance();
        updateInstruction();
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

    Instruction updateInstruction(){
        UnitMode um = (UnitMode)ModeList.get(GameInfo.UNITMODE);
        currentInstruction = um.updateInstruction();
        return currentInstruction;
    }

    ArrayList<Mode> getModeList(){
        return ModeList;
    }


}