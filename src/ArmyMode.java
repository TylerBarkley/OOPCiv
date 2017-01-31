/**
 * Created by hankerins on 1/31/17.
 */
public class ArmyMode extends Mode {

    public final static int ENTIREARMY     	= 0;
    public final static int BATTLEGROUP    	= 1;
    public final static int REINFORCEMENTS 	= 2;

    int cycleTypeL(){
        if(currentType == 0)
            currentType = 2;
        else currentType--;
        return currentType;
    }
    int cycleTypeR(){
        if(currentType == 2)
            currentType = 0;
        else currentType++;
        return currentType;
    }
}
