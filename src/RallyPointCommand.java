/**
 * Created by hankerins on 2/5/17.
 */
public class RallyPointCommand implements Command {
    RallyPoint target;
    RallyPointInstruction rp_inst;

    RallyPointCommand(RallyPoint target, RallyPointInstruction rp_inst){
        this.target = target;
        this.rp_inst = rp_inst;
    }

    @Override
    public void execute() {
        switch (rp_inst.toInt()){
            case RallyPointInstruction.RP_MOVEENTER:

                break;
            case RallyPointInstruction.RP_DELETE:

                break;
        }
    }
}
