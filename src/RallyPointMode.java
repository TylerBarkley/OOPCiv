import java.util.ArrayList;

/**
 * Created by hankerins on 1/31/17.
 */
public class RallyPointMode extends Mode {

    ArrayList<RallyPoint> rallyPoints;
    ArrayList<RallyPointInstruction> rallyPointInstructions;

    RallyPointMode(Player player){
        this.player = player;
        this.rallyPoints = player.getRallyPoints();
        //this loop adds each possible RP instruction to the list of instructions

        for(int i = RallyPointInstruction.RP_MOVEENTER; i <= RallyPointInstruction.RP_DELETE; i++){
            rallyPointInstructions.add(new RallyPointInstruction(i));
        }
        //initialize the first instruction into currentInstruction
        currentInstruction = rallyPointInstructions.get(0);
        currentInstructionIndex = 0;
    }

    int cycleTypeL(){ return 0; } //no types in RP mode
    int cycleTypeR(){ return 0; }

    int cycleInstanceL(){
        int lastInstance = rallyPoints.size() -1;
        if(currentInstance == 0)
            currentInstance = lastInstance;
        else currentInstance--;
        return currentInstance;
    }
    int cycleInstanceR(){
        int lastInstance = rallyPoints.size() - 1;
        if(currentInstance == lastInstance)
            currentInstance = 0;
        else currentInstance++;
        return currentInstance;
    }
    Instruction cycleInstructionL(){
        int lastInstruction = rallyPointInstructions.size() - 1;
        if(currentInstructionIndex == 0)
            currentInstructionIndex = lastInstruction; //cycle back to last instruction
        else currentInstructionIndex--;
        currentInstruction = rallyPointInstructions.get(currentInstructionIndex);
        return currentInstruction;
    }
    Instruction cycleInstructionR(){
        int lastInstruction = rallyPointInstructions.size() - 1;
        if(currentInstructionIndex == lastInstruction)
            currentInstructionIndex = 0; //cycle back to last instruction
        else currentInstructionIndex++;
        currentInstruction = rallyPointInstructions.get(currentInstructionIndex);
        return currentInstruction;
    }
}
