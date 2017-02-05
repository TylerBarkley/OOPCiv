/**
 * Created by hankerins on 2/4/17.
 */
public class UnitCommandFactory extends CommandFactory {

    static UnitCommand create(UnitInstruction inst, Unit target){
        UnitCommand uc = new UnitCommand(target, inst);
        return uc;

        //at any given point, MenuState holds a current instance (target) and current Instruction
        //When player hits KP-Enter, call CommandFactory.create(MenuState.getCurrentInstruction(), Menustate.getCurrentInstance())
        //inside this large method is the logic of what kind of command gets created

        //will return an object of a specific command type, which will hold a target and logic
    }
}
