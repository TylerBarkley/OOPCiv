/**
 * Created by Tyler Barkley on 2/5/2017.
 */
public class BuildBaseCommand implements Command {

    Colonist target;

    BuildBaseCommand(Colonist target){
        this.target = target;
    }

    @Override
    public void execute() {
        target.buildBase();
    }
}
