/**
 * Created by hankerins on 1/31/17.
 */
public class UnitMode extends Mode {

    public final static int EXPLORER     	= 0;
    public final static int COLONIST    	= 1;
    public final static int MELEEUNIT    	= 2;
    public final static int RANGEDUNIT    	= 3;

    int cycleTypeL(){
        if(currentType == 0)
            currentType = 3;
        else currentType--;
        return currentType;
    }
    int cycleTypeR(){
        if(currentType == 3)
            currentType = 0;
        else currentType++;
        return currentType;
    }
}
