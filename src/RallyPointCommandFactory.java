/**
 * Created by hankerins on 2/4/17.
 */
public class RallyPointCommandFactory extends CommandFactory {

    static Command create(Instruction inst, RallyPoint target){

        //at any given point, MenuState holds a current instance (target) and current Instruction
        //When player hits KP-Enter, call CommandFactory.create(MenuState.getCurrentInstruction(), Menustate.getCurrentInstance())
        //inside this large method is the logic of what kind of command gets created

        switch (inst.toInt()){
            case RallyPointInstruction.RP_MOVEENTER:

                break;
            case RallyPointInstruction.RP_DELETE:

                break;
        }
        return  null;  //will return an object of a specific command type, which will hold a target and logic
    }

}
