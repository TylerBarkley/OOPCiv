/**
 * Created by hankerins on 1/31/17.
 */



public abstract class Mode {

    Player player;

    int currentType = 0;
    int currentInstanceIndex = 0;
    Controllable currentInstance;

    int currentInstructionIndex;
    Instruction currentInstruction;

    abstract int cycleTypeL();
    abstract int cycleTypeR();

    abstract Controllable cycleInstanceL();
    abstract Controllable cycleInstanceR();

    abstract Instruction cycleInstructionL();
    abstract Instruction cycleInstructionR();

    Instruction getCurrentInstruction(){
        return currentInstruction;
    }

    int getCurrentInstanceIndex(){ return currentInstanceIndex; }

    Controllable getCurrentInstance(){ return currentInstance; }

    public void refresh(){}
}
