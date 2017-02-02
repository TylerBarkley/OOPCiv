/**
 * Created by hankerins on 1/31/17.
 */
public class UnitInstruction extends Instruction {

    public final static int U_MAKEARMY  	= 10;
    public final static int U_JOINARMY  	= 11;
    public final static int U_BUILDBASE 	= 12;
    public final static int U_STANDBY 	    = 13;
    public final static int U_POWERDOWN 	= 14;
    public final static int U_POWERUP 	    = 15;
    public final static int U_CANCELQUEUE   = 16;
    public final static int U_MOVEENTER     = 17;


    public UnitInstruction(int inst_num){
        super(inst_num);
        setString();

    }
    public void setString(){
        setStringDirection();
        if(inst_num == U_MAKEARMY)			inst = "MakeArmy";
        else if(inst_num == U_JOINARMY)		inst = "JoinArmy";
        else if(inst_num == U_BUILDBASE)	inst = "BuildBase";
        else if(inst_num == U_STANDBY)  	inst = "Standby";
        else if(inst_num == U_POWERDOWN)	inst = "PowerDown";
        else if(inst_num == U_POWERUP)      inst = "PowerUp";
        else if(inst_num == U_CANCELQUEUE)  inst = "CancelQueue";
        else if(inst_num == U_MOVEENTER)    inst = "MoveEnter";

    }

}
