import java.util.ArrayList;

/**
 * Created by zrgam_000 on 2/2/2017.
 */

//TODO: fill in all the command factories' cases
public class CommandFactory {

    static Command create(Instruction inst, Controllable target) {
        Unit u;
        UnitInstruction ui;
        Structure s;
        StructureInstruction si;
        Army a;
        ArmyInstruction ai;
        RallyPoint rp;
        RallyPointInstruction rpi;
        
        if(target instanceof Unit){
            u = (Unit)target;
            ui = (UnitInstruction)inst;
            UnitCommand uc = new UnitCommand(u, ui);
            return uc;
            //return UnitCommandFactory.create(inst, u);
        }

        if(target instanceof Structure){
            s = (Structure)target;
            si = (StructureInstruction)inst;
            StructureCommand sc = new StructureCommand(s, si);
            return sc;
            //return StructureCommandFactory.create(inst, s);
        }

        if(target instanceof Army){
            a = (Army)target;
            ai = (ArmyInstruction)inst;
            ArmyCommand ac = new ArmyCommand(a, ai);
            return ac;
            //return  ArmyCommandFactory.create(inst, a);
        }

        if(target instanceof RallyPoint){
            rp = (RallyPoint)target;
            rpi = (RallyPointInstruction)inst;
            RallyPointCommand rpc = new RallyPointCommand(rp, rpi);
            return rpc;
            //return RallyPointCommandFactory.create(inst, rp);
        }

        return null;
    }



}
