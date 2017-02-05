/**
 * Created by zrgam_000 on 2/5/2017.
 */
public class HealCommand implements Command{

    Base target;
    Map.MapDirection md;

    HealCommand(Base target, Map.MapDirection md){
        this.target = target;
        this.md = md;
    }

    @Override
    public void execute() {
        target.healDirection(md);
    }
}
