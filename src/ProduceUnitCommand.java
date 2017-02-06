/**
 * Created by zrgam_000 on 2/5/2017.
 */
public class ProduceUnitCommand implements Command {

    private Base target;
    private int unitCode;

    public ProduceUnitCommand(Base base, int unitCode){
        target = base;
        this.unitCode = unitCode;
    }

    @Override
    public String toString(){
        return "Produce Unit";
    }

    @Override
    public void execute() {
        target.ProduceUnit(unitCode);
    }
}
