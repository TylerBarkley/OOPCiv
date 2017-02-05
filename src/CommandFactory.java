import java.util.ArrayList;

/**
 * Created by zrgam_000 on 2/2/2017.
 */

//TODO: fill in all the command factories' cases
public class CommandFactory {

    static Command create(Instruction inst, Controllable target) {
        Unit u;
        Structure s;
        Army a;
        RallyPoint rp;

        if(target instanceof Unit){
            u = (Unit)target;
            return UnitCommandFactory.create(inst, u);
        }

        if(target instanceof Structure){
            s = (Structure)target;
            return StructureCommandFactory.create(inst, s);
        }

        if(target instanceof Army){
            a = (Army)target;
            return  ArmyCommandFactory.create(inst, a);
        }

        if(target instanceof RallyPoint){
            rp = (RallyPoint)target;
            return RallyPointCommandFactory.create(inst, rp);
        }

        return null;
    }



}
