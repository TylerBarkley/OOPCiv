import java.util.ArrayList;

/**
 * Created by hankerins on 1/31/17.
 */
public class UnitMode extends Mode {

    ArrayList<ArrayList<Unit>> units;
    ArrayList<UnitInstruction> unitInstructions;



    UnitMode(Player player){
        this.player = player;
        units = player.getUnits();
        //this loop adds each possible unit instruction (besides move directions) to the list of instructions
        //TODO: decide how to move units not in an army, for now those instructions aren't in the instruction list
        for(int i = UnitInstruction.U_MAKEARMY; i <= UnitInstruction.U_MOVEENTER; i++){
            unitInstructions.add(new UnitInstruction(i));
        }
        //initialize the first instruction into currentInstruction
        currentInstruction = unitInstructions.get(0);
        currentInstructionIndex = 0;
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

    Instruction cycleInstructionL(){
        int lastInstruction = unitInstructions.size() - 1;
        if(currentInstructionIndex == 0)
            currentInstructionIndex = lastInstruction; //cycle back to last instruction
        else currentInstructionIndex--;
        currentInstruction = unitInstructions.get(currentInstructionIndex);
        return currentInstruction;
    }
    Instruction cycleInstructionR(){
        int lastInstruction = unitInstructions.size() - 1;
        if(currentInstructionIndex == lastInstruction)
            currentInstructionIndex = 0; //cycle back to last instruction
        else currentInstructionIndex++;
        currentInstruction = unitInstructions.get(currentInstructionIndex);
        return currentInstruction;
    }

}
