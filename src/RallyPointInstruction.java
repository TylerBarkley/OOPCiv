/**
 * Created by hankerins on 1/31/17.
 */

//enum RPInst {N, NE, E, SE, S, SW, W, NW, Place}


public class RallyPointInstruction extends Instruction {

    public final static int RP_MOVEENTER   	= 40;
    public final static int RP_DELETE     	= 41;


    public RallyPointInstruction(int inst_num){
        super(inst_num);
        setString();

    }
    public void setString(){
        setStringDirection();
        if(inst_num == RP_MOVEENTER)		inst = "MoveEnter";
        else if(inst_num == RP_DELETE)		inst = "Delete";

    }

}
