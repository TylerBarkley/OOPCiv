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
        rallyPointInstructions = new ArrayList<RallyPointInstruction>();
        //this loop adds each possible RP instruction to the list of instructions
        for(int i = RallyPointInstruction.RP_MOVEENTER; i <= RallyPointInstruction.RP_DELETE; i++){
            rallyPointInstructions.add(new RallyPointInstruction(i));
        }
        //initialize the first instruction into currentInstruction
        currentInstructionIndex = 0;
        currentInstruction = rallyPointInstructions.get(0);

    }

    int cycleTypeL(){ return 0; } //no types in RP mode
    int cycleTypeR(){ return 0; }

    Controllable cycleInstanceL(){
        int lastInstance = rallyPoints.size() -1;
        if(currentInstanceIndex == 0)
            currentInstanceIndex = lastInstance;
        else currentInstanceIndex--;
        return rallyPoints.get(currentInstanceIndex);
    }
    Controllable cycleInstanceR(){
        int lastInstance = rallyPoints.size() - 1;
        if(currentInstanceIndex == lastInstance)
            currentInstanceIndex = 0;
        else currentInstanceIndex++;
        return rallyPoints.get(currentInstanceIndex);
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
