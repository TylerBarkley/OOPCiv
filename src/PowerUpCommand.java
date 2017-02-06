/**
 * Created by Tyler Barkley on 2/5/2017.
 */
public class PowerUpCommand implements Command {

    Concrete target;

    PowerUpCommand(Concrete target){
        this.target = target;
    }

    @Override
    public void execute() {
        target.powerUp();
    }

    public String toString(){
        return "PowerUp";
    }
}
