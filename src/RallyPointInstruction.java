/**
 * Created by hankerins on 1/31/17.
 */

//enum RPInst {N, NE, E, SE, S, SW, W, NW, Place}


public class RallyPointInstruction extends Instruction {
    //Rally Point movement instructions are queued then executed immediately upon Place.
    //This way we can check if there's a path from old Rally Point to new Rally Point easily at each move instruction.
    //RPInst inst;

    public final static int NW     	= 1;
    public final static int N     	= 2;
    public final static int NE   	= 3;
    public final static int W    	= 4;
    public final static int SELECT 	= 5;
    public final static int E    	= 6;
    public final static int SW   	= 7;
    public final static int S    	= 8;
    public final static int SE   	= 9;


    int inst;
    public RallyPointInstruction(int inst) {
       this.inst = inst;
    }

}
