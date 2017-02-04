/**
 * Created by hankerins on 2/4/17.
 */
public class UnitCommandFactory extends CommandFactory {

    static Command create(Instruction inst, Unit target){

        //at any given point, MenuState holds a current instance (target) and current Instruction
        //When player hits KP-Enter, call CommandFactory.create(MenuState.getCurrentInstruction(), Menustate.getCurrentInstance())
        //inside this large method is the logic of what kind of command gets created

        switch (inst.toInt()){
            case UnitInstruction.U_MAKEARMY:
                target.makeArmy();
                break;
            case UnitInstruction.U_JOINARMY:

                break;
            case UnitInstruction.U_BUILDBASE:

                break;
            case UnitInstruction.U_STANDBY:
                target.standby();
                break;
            case UnitInstruction.U_POWERDOWN:
                target.powerDown(); //this doesn't work because controllable doesn't have this function
                break;
            case UnitInstruction.U_POWERUP:
                target.powerUp();
                break;
            case UnitInstruction.U_CANCELQUEUE:
                target.clearCommands();
                break;
            case UnitInstruction.U_MOVEENTER:

                break;
        }
        return  null;  //will return an object of a specific command type, which will hold a target and logic
    }
}
