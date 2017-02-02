/**
 * Created by zrgam_000 on 2/1/2017.
 */
public class ArmyMoveCommand implements Command {
    Army targetArmy;
    Map.MapDirection md;

    @Override
    public void execute() {

        //targetArmy.move(md); official, need to use change cardinal direction to Map.MapDirection
    }
}
