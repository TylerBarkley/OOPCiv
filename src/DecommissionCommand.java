/**
 * Created by Tyler Barkley on 2/5/2017.
 */
public class DecommissionCommand implements Command {

    Concrete target;

    DecommissionCommand(Concrete target){
        this.target = target;
    }

    @Override
    public void execute() {
        target.killMe();
    }
}
