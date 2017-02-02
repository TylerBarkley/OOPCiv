/**
 * Created by hankerins on 1/31/17.
 */
public abstract class Instruction {

    public final static int NW 	        = 91;
    public final static int N          	= 92;
    public final static int NE         	= 93;
    public final static int W          	= 94;
    public final static int E        	= 96;
    public final static int SW      	= 97;
    public final static int S          	= 98;
    public final static int SE      	= 99;


    int inst_num;
    String inst;

    public Instruction(int inst_num) {
        this.inst_num = inst_num;

    }

    public void setStringDirection() {

        if(inst_num == NW)			inst = "NW";
        else if(inst_num == N)		inst = "N";
        else if(inst_num == NE)		inst = "NE";
        else if(inst_num == W)		inst = "W";
        else if(inst_num == E)		inst = "E";
        else if(inst_num == SW)     inst = "SW";
        else if(inst_num == S)		inst = "S";
        else if(inst_num == SE)     inst = "SE";
    }

    public int getInstNum(){
        return inst_num;
    }
    public String getInstString() {
        return inst;
    }

}
