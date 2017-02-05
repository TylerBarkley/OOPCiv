/**
 * Created by hankerins on 2/4/17.
 */
public class ArmyCommandFactory extends CommandFactory {

    static Command create(Instruction inst, Army target){

        //at any given point, MenuState holds a current instance (target) and current Instruction
        //When player hits KP-Enter, call CommandFactory.create(MenuState.getCurrentInstruction(), Menustate.getCurrentInstance())
        //inside this large method is the logic of what kind of command gets created

        switch (inst.toInt()){
            case ArmyInstruction.A_ATTACK:

                break;
            case ArmyInstruction.A_DEFEND:

                break;
            case ArmyInstruction.A_WAIT:

                break;
            case ArmyInstruction.A_DISBAND:

                break;
            case ArmyInstruction.A_DECOMMISSION:

                break;

            case ArmyInstruction.A_POWERDOWN:

                break;
            case ArmyInstruction.A_POWERUP:

                break;

            case ArmyInstruction.A_CANCELQUEUE:

                break;

        }
        return  null;  //will return an object of a specific command type, which will hold a target and logic
    }
}
