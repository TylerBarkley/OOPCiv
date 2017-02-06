/**
 * Created by Tyler Barkley on 2/5/2017.
 */
public class WaitCommand implements Command {

    Concrete target;

    WaitCommand(Concrete target){
        this.target = target;
    }


    @Override
    public void execute() {
       target.wait4me();
    }

    public String toString(){
        return "Wait";
    }
}
