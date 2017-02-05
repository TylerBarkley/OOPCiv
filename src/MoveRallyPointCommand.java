/**
 * Created by zrgam_000 on 2/5/2017.
 */
public class MoveRallyPointCommand implements Command{
    RallyPoint rp;
    Location loc;

    MoveRallyPointCommand(RallyPoint rp, Location loc){
        this.rp = rp;
        this.loc = loc;
    }

    @Override
    public void execute() {
        rp.moveRallyPoint(loc);
    }
}
