/**
 * Created by Tyler Barkley on 2/5/2017.
 */
public class PowerDownCommand implements Command {

    Concrete target;

    PowerDownCommand(Concrete target){
        this.target = target;
    }

    @Override
    public void execute() {
        target.powerDown();
    }

    public String toString(){
        return "PowerDown";
    }
}
