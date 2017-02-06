/**
 * Created by hankerins on 1/31/17.
 */
public class ArmyInstruction extends Instruction {

    public final static int A_ATTACK    	= 20;
    public final static int A_DEFEND 	    = 21;
    public final static int A_WAIT      	= 22;
    public final static int A_STANDBY      	= 23;
    public final static int A_DISBAND 	    = 24;
    public final static int A_DECOMMISSION 	= 25;
    public final static int A_POWERDOWN 	= 26;
    public final static int A_POWERUP   	= 27;
    public final static int A_CANCELQUEUE 	= 28;


    public ArmyInstruction(int inst_num){
        super(inst_num);
        setString();

    }
    public void setString(){
        setStringDirection();
        if(inst_num == A_ATTACK)			    inst = "Attack";
        else if(inst_num == A_DEFEND)	    	inst = "Defend";
        else if(inst_num == A_WAIT)	    	    inst = "Wait";
        else if(inst_num == A_STANDBY)	    	inst = "Standby";
        else if(inst_num == A_DISBAND)		    inst = "Disband";
        else if(inst_num == A_DECOMMISSION)		inst = "DecommissionCommand";
        else if(inst_num == A_POWERDOWN)        inst = "PowerDown";
        else if(inst_num == A_POWERUP)		    inst = "PowerUp";
        else if(inst_num == A_CANCELQUEUE)      inst = "CancelQueue";

    }
}
