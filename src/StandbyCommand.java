/**
 * Created by Tyler Barkley on 2/5/2017.
 */
public class StandbyCommand implements Command {

    Concrete target;

    StandbyCommand(Concrete target){
        this.target = target;
    }

    @Override
    public void execute() {
        target.standby();
    }
}
