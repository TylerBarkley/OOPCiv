/**
 * Created by zrgam_000 on 2/6/2017.
 */
public class AttackCommand implements Command {

    Army target;
    Map.MapDirection md;

    AttackCommand(Army target, Map.MapDirection md){
        this.target = target;
        this.md = md;
    }

    @Override
    public void execute() {
        target.attack(md);
    }
}
