/**
 * Created by hankerins on 1/31/17.
 */



public abstract class Mode {

    Player player;

    int currentType = 0;
    int currentInstance = 0;
    int currentInstructionIndex;
    Instruction currentInstruction;

    abstract int cycleTypeL();
    abstract int cycleTypeR();

    abstract int cycleInstanceL();
    abstract int cycleInstanceR();

    abstract Instruction cycleInstructionL();
    abstract Instruction cycleInstructionR();

    Instruction getCurrentInstruction(){
        return currentInstruction;
    }

}
