/**
 * Created by hankerins on 2/4/17.
 */
public class UnitCommandFactory extends CommandFactory {

    static UnitCommand create(UnitInstruction inst, Unit target){
        UnitCommand uc = new UnitCommand(target, inst);
        return uc;
    }
}
