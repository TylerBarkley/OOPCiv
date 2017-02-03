import java.util.ArrayList;

/**
 * Created by hankerins on 1/31/17.
 */
public class ArmyMode extends Mode {

    ArrayList<Army> armies;
    ArrayList<ArmyInstruction> armyInstructions;

    //Constructor

    ArmyMode(Player player){
        this.player = player;
        armies = player.getArmies();
        //this loop adds each possible army instruction to the list of instructions

        for(int i = ArmyInstruction.A_ATTACK; i <= ArmyInstruction.A_CANCELQUEUE; i++){
            armyInstructions.add(new ArmyInstruction(i));
        }
        //initialize the first instruction into currentInstruction
        currentInstruction = armyInstructions.get(0);
        currentInstructionIndex = 0;
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
    Instruction cycleInstructionL(){
        int lastInstruction = armyInstructions.size() - 1;
        if(currentInstructionIndex == 0)
            currentInstructionIndex = lastInstruction; //cycle back to last instruction
        else currentInstructionIndex--;
        currentInstruction = armyInstructions.get(currentInstructionIndex);
        return currentInstruction;
    }
    Instruction cycleInstructionR(){
        int lastInstruction = armyInstructions.size() - 1;
        if(currentInstructionIndex == lastInstruction)
            currentInstructionIndex = 0; //cycle back to last instruction
        else currentInstructionIndex++;
        currentInstruction = armyInstructions.get(currentInstructionIndex);
        return currentInstruction;
    }
}
