/**
 * Created by hankerins on 2/5/17.
 */
public class ArmyCommand implements Command {
    Army target;
    ArmyInstruction a_inst;

    ArmyCommand(Army target, ArmyInstruction a_inst){
        this.target = target;
        this.a_inst = a_inst;
    }
    @Override
    public void execute() {
        switch (a_inst.toInt()){
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
    }
    public String toString(){
        return a_inst.toString();
    }
}
