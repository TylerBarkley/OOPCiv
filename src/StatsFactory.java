/**
 * Created by Trevor on 2/4/2017.
 */
/*public final static int EXPLORER     	= 0;
public final static int COLONIST    	= 1;
public final static int MELEEUNIT    	= 2;
public final static int RANGEDUNIT    	= 3;*/
//TODO Finish Stats Factory With Details
public class StatsFactory {
    public static Stats createStats(int concreteType){
        Stats concreteTypeStats=new Stats();
        //MELEEFIGHTER
        if(concreteType==GameInfo.MELEEUNIT) {
            concreteTypeStats.setDefensiveDamage(0);
            concreteTypeStats.setOffensiveDamage(0);
            concreteTypeStats.setHealth(0);
            concreteTypeStats.setUpKeep(0);
            concreteTypeStats.setRate(0);
        } else if(concreteType==GameInfo.RANGEDUNIT) {
            concreteTypeStats.setDefensiveDamage(0);
            concreteTypeStats.setOffensiveDamage(0);
            concreteTypeStats.setHealth(0);
            concreteTypeStats.setUpKeep(0);
            concreteTypeStats.setRate(0);
        }  else  if(concreteType==GameInfo.COLONIST) {
            concreteTypeStats.setDefensiveDamage(0);
            concreteTypeStats.setOffensiveDamage(0);
            concreteTypeStats.setHealth(0);
            concreteTypeStats.setUpKeep(0);
            concreteTypeStats.setRate(0);
        } else if(concreteType==GameInfo.EXPLORER) {
            concreteTypeStats.setDefensiveDamage(0);
            concreteTypeStats.setOffensiveDamage(0);
            concreteTypeStats.setHealth(0);
            concreteTypeStats.setUpKeep(0);
            concreteTypeStats.setRate(0);
        } else if(concreteType== GameInfo.BASE){
            concreteTypeStats.setDefensiveDamage(0);
            concreteTypeStats.setOffensiveDamage(0);
            concreteTypeStats.setHealth(0);
            concreteTypeStats.setUpKeep(0);
            concreteTypeStats.setRate(0);
        }
        else if(concreteType== GameInfo.ARMY){
            concreteTypeStats.setDefensiveDamage(0);
            concreteTypeStats.setOffensiveDamage(0);
            concreteTypeStats.setHealth(0);
            concreteTypeStats.setUpKeep(0);
            concreteTypeStats.setRate(0);
        }
        return concreteTypeStats;

    }
}
