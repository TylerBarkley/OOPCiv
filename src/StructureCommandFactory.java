/**
 * Created by hankerins on 2/4/17.
 */
public class StructureCommandFactory extends CommandFactory {
    static Command create(Instruction inst, Structure target){

        //at any given point, MenuState holds a current instance (target) and current Instruction
        //When player hits KP-Enter, call CommandFactory.create(MenuState.getCurrentInstruction(), Menustate.getCurrentInstance())
        //inside this large method is the logic of what kind of command gets created

        switch (inst.toInt()){
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

        return  null;  //will return an object of a specific command type, which will hold a target and logic
    }
}
