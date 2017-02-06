/**
 * Created by zrgam_000 on 2/6/2017.
 */
public class AttackCommand implements Command {

    Concrete target;
    Map.MapDirection md;

    AttackCommand(Concrete target, Map.MapDirection md){
        this.target = target;
        this.md = md;
    }

    @Override
    public void execute() {
        target.attack(md);
    }

    public String toString(){
        return "Attack " + md.toString();
    }
}
