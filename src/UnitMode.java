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
        unitInstructions = new ArrayList<UnitInstruction>();
        //this loop adds each possible unit instruction (besides move directions) to the list of instructions
        //TODO: decide how to move units not in an army, for now those instructions aren't in the instruction list
        for(int i = UnitInstruction.U_MAKEARMY; i <= UnitInstruction.U_MOVEENTER; i++){
            unitInstructions.add(new UnitInstruction(i));
        }
        //initialize the first instruction into currentInstruction
        currentInstructionIndex = 0;
        currentInstruction = unitInstructions.get(0);

    }

    //CycleType methods reset the instance to 0 because we have different #s of different troops.
    int cycleTypeL(){
        int startCurrentType=currentType;
        if(currentType == GameInfo.EXPLORER)
            currentType = GameInfo.RANGEDUNIT;
        else currentType--;
        boolean foundUnit=false;
        while(startCurrentType!=currentType&&!foundUnit) {
            for (int i = 0; currentType < player.getUnits().size() && i < player.getUnits().get(currentType).size(); i++) {
                if (player.getUnits().get(currentType).get(i) != null) {
                    foundUnit=true;
                    currentInstanceIndex=i;
                    break;
                }
            }
            if(!foundUnit) {
                currentType--;
                if (currentType == GameInfo.EXPLORER) {
                    currentType = GameInfo.RANGEDUNIT;
                }
            }
        }


        currentInstanceIndex = 0;
        currentInstance = units.get(currentType).get(currentInstanceIndex);
        return currentType;
    }
    int cycleTypeR(){

        int startCurrentType=currentType;
        if(currentType == GameInfo.RANGEDUNIT)
            currentType = GameInfo.EXPLORER;
        else currentType++;
        boolean foundUnit=false;
        while(startCurrentType!=currentType&&!foundUnit) {
            for (int i = 0; currentType < player.getUnits().size() && i < player.getUnits().get(currentType).size(); i++) {
                if (player.getUnits().get(currentType).get(i) != null) {
                   foundUnit=true;
                   currentInstanceIndex=i;
                   break;
                }
            }
            if(!foundUnit) {
                currentType++;
                if (currentType == GameInfo.RANGEDUNIT) {
                    currentType = GameInfo.EXPLORER;
                }
            }
        }


        currentInstance = units.get(currentType).get(currentInstanceIndex);
        return currentType;
    }
    Controllable cycleInstanceL(){
        int lastInstance = player.getUnits().get(currentType).size() -1;
        int startIndex=currentInstanceIndex;
        if(currentInstanceIndex == 0)
            currentInstanceIndex = lastInstance;
        else currentInstanceIndex--;
       while(currentInstanceIndex!=startIndex){
           if(player.getUnits().get(currentType).get(currentInstanceIndex)!=null){
                break;
           }
           currentInstanceIndex--;
           if(currentInstanceIndex<0){
               currentInstanceIndex=lastInstance;
           }
       }
        currentInstance = units.get(currentType).get(currentInstanceIndex);
        return currentInstance;
    }
    Controllable cycleInstanceR(){
        int lastInstance = player.getUnits().get(currentType).size() -1;
        int startIndex=currentInstanceIndex;
        if(currentInstanceIndex == lastInstance)
            currentInstanceIndex = 0;
        else currentInstanceIndex++;
        while(currentInstanceIndex!=startIndex){
            if(player.getUnits().get(currentType).get(currentInstanceIndex)!=null){
                break;
            }
            currentInstanceIndex++;
            if(currentInstanceIndex>lastInstance){
                currentInstanceIndex=lastInstance;
            }
        }
        currentInstance = units.get(currentType).get(currentInstanceIndex);
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
