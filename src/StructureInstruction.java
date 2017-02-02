/**
 * Created by hankerins on 1/31/17.
 */
public class StructureInstruction extends Instruction {

    public final static int S_ATTACK        	= 30;
    public final static int S_DEFEND            = 31;
    public final static int S_MAKE_EXPLORER    	= 320;
    public final static int S_MAKE_COLONIST    	= 321;
    public final static int S_MAKE_MELEE      	= 322;
    public final static int S_MAKE_RANGED     	= 323;
    public final static int S_HEALUNIT 	        = 33;
    public final static int S_DECOMMISSION 	    = 34;
    public final static int S_POWERDOWN 	    = 35;
    public final static int S_POWERUP       	= 36;
    public final static int S_CANCELQUEUE 	    = 37;


    public StructureInstruction(int inst_num){
        super(inst_num);
        setString();

    }
    public void setString(){
        setStringDirection();
        if(inst_num == S_ATTACK)			    inst = "Attack";
        else if(inst_num == S_DEFEND)	    	inst = "Defend";
        else if(inst_num == S_MAKE_EXPLORER)    inst = "MakeExplorer";
        else if(inst_num == S_MAKE_COLONIST)    inst = "MakeColonist";
        else if(inst_num == S_MAKE_MELEE)       inst = "MakeMelee";
        else if(inst_num == S_MAKE_RANGED)      inst = "MakeRanged";
        else if(inst_num == S_HEALUNIT)         inst = "HealUnit";
        else if(inst_num == S_DECOMMISSION)		inst = "Decommission";
        else if(inst_num == S_POWERDOWN)        inst = "PowerDown";
        else if(inst_num == S_POWERUP)		    inst = "PowerUp";
        else if(inst_num == S_CANCELQUEUE)      inst = "CancelQueue";

    }
}
