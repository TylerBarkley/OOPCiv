/**
 * Created by zrgam_000 on 2/1/2017.
 */
public class UnitCommand implements Command{
    Unit target;
    UnitInstruction u_inst;

    UnitCommand(Unit target, UnitInstruction u_inst){
        this.target = target;
        this.u_inst = u_inst;
    }

    @Override
    public void execute() {
        switch (u_inst.toInt()){
            case UnitInstruction.U_MAKEARMY:
                target.makeArmy();
                break;
            case UnitInstruction.U_JOINARMY:
                //access the last selected instance of army
                Army army = (Army)target.getPlayer().getMenuState().getModeList().get(GameInfo.ARMYMODE).getCurrentInstance();
                target.joinArmy(army);
                break;
            case UnitInstruction.U_BUILDBASE:
                //TODO: write for colonist
                break;
            case UnitInstruction.U_STANDBY:
                target.standby();
                break;
            case UnitInstruction.U_POWERDOWN:
                target.powerDown();
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
    }
}