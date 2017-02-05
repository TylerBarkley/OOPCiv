/**
 * Created by zrgam_000 on 2/5/2017.
 */
public class DisbandCommand implements Command{
    Army target;

    DisbandCommand(Army target){
        this.target = target;
    }

    @Override
    public void execute() {
        this.target.disband();
    }
}
