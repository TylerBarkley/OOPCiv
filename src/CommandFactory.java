/**
 * Created by zrgam_000 on 2/2/2017.
 */
public class CommandFactory {

    static Command create(Instruction inst, Controllable target){
        //at any given point, MenuState holds a current instance (target) and current Instruction
        //When player hits KP-Enter, call CommandFactory.create(MenuState.getCurrentInstruction(), Menustate.getCurrentInstance())
        //inside this large method is the logic of what kind of command gets created
        return  null;  //will return an object of a specific command type, which will hold a target and logic
    }
}
