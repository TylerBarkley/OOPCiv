/**
 * Created by zrgam_000 on 2/1/2017.
 */
public class MoveCommand implements Command {
    Unit target;
    Map.MapDirection direction;

    MoveCommand(Unit target, Map.MapDirection md){
        this.target = target;
        direction = md;
    }

    @Override
    public void execute() {
        target.move(direction);
    }
}