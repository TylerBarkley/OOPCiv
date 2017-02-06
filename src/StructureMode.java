import java.util.ArrayList;

/**
 * Created by hankerins on 1/31/17.
 */
public class StructureMode extends Mode {

    ArrayList<ArrayList<Structure>> structures;
    ArrayList<StructureInstruction> structureInstructions;

    StructureMode(Player player){
        this.player = player;
        structures = player.getStructures();
        structureInstructions = new ArrayList<StructureInstruction>();
        //this loop adds each possible structure instruction to the list of instructions
        for(int i = StructureInstruction.S_ATTACK; i <= StructureInstruction.S_CANCELQUEUE; i++){
            structureInstructions.add(new StructureInstruction(i));
        }
        //initialize the first instruction into currentInstruction
        currentInstructionIndex = 0;
        currentInstruction = structureInstructions.get(0);

    }



    int cycleTypeL(){ return currentType; } //always returns 0.  These do nothing while there is only one structure type
    int cycleTypeR(){ return currentType; } //always returns 0.  When we add more structure types, copy UnitMode.java

    Controllable cycleInstanceL(){
        int lastInstance = structures.get(currentType).size() -1;
        int startIndex=currentInstanceIndex;
        if(currentInstanceIndex == 0)
            currentInstanceIndex = lastInstance;
        else currentInstanceIndex--;
        while(currentInstanceIndex!=startIndex){
            if(player.getStructures().get(currentType).get(currentInstanceIndex)!=null){
                break;
            }
            currentInstanceIndex--;
            if(currentInstanceIndex<0){
                currentInstanceIndex=lastInstance;
            }
        }
        currentInstance = structures.get(currentType).get(currentInstanceIndex);
        return currentInstance;
    }

    Controllable cycleInstanceR(){
        int lastInstance = structures.size() - 1;
        int startIndex=currentInstanceIndex;
        if(currentInstanceIndex == lastInstance)
            currentInstanceIndex = 0;
        else currentInstanceIndex++;
        while(currentInstanceIndex!=startIndex){
            if(player.getStructures().get(currentType).get(currentInstanceIndex)!=null){
                break;
            }
            currentInstanceIndex++;
            if(currentInstanceIndex>lastInstance){
                currentInstanceIndex=0;
            }
        }
        currentInstance = structures.get(currentType).get(currentInstanceIndex);
        return currentInstance;
    }

    Instruction cycleInstructionL(){
        int lastInstruction = structureInstructions.size() - 1;
        if(currentInstructionIndex == 0)
            currentInstructionIndex = lastInstruction; //cycle back to last instruction
        else currentInstructionIndex--;
        currentInstruction = structureInstructions.get(currentInstructionIndex);
        return currentInstruction;
    }
    Instruction cycleInstructionR(){
        int lastInstruction = structureInstructions.size() - 1;
        if(currentInstructionIndex == lastInstruction)
            currentInstructionIndex = 0; //cycle back to last instruction
        else currentInstructionIndex++;
        currentInstruction = structureInstructions.get(currentInstructionIndex);
        return currentInstruction;
    }
}
