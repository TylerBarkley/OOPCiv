/**
 * Created by hankerins on 2/5/17.
 */
public class StructureCommand implements Command {
    Structure target;
    StructureInstruction s_inst;

    StructureCommand(Structure target, StructureInstruction s_inst){
        this.target = target;
        this.s_inst = s_inst;
    }

    @Override
    public void execute() {
        switch (s_inst.toInt()){
            case StructureInstruction.S_ATTACK:

                break;
            case StructureInstruction.S_DEFEND:

                break;
            case StructureInstruction.S_MAKE_EXPLORER:

                break;
            case StructureInstruction.S_MAKE_COLONIST:

                break;
            case StructureInstruction.S_MAKE_MELEE:

                break;
            case StructureInstruction.S_MAKE_RANGED:

                break;
            case StructureInstruction.S_HEALUNIT:

                break;
            case StructureInstruction.S_DECOMMISSION:

                break;
            case StructureInstruction.S_POWERDOWN:

                break;
            case StructureInstruction.S_POWERUP:

                break;
            case StructureInstruction.S_CANCELQUEUE:

                break;
        }
    }

    public String toString(){
        return s_inst.toString();
    }

}
