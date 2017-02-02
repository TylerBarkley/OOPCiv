/**
 * Created by Tyler Barkley on 2/1/2017.
 */
public class UnitStatsFactory {
    static UnitStats produceUnitStats(String orderableToBeCreated){
        UnitStats statsOfOrderable=new UnitStats();
        /*MeleeFighter Stats Construction*/
        if(orderableToBeCreated.equals("MeleeFighter")) {
            statsOfOrderable.setArmor(3);
            statsOfOrderable.setDefensiveDamage(3);
            statsOfOrderable.setHealth(5);
            statsOfOrderable.setOffensiveDamage(4);
            statsOfOrderable.setUpKeep(3);
            statsOfOrderable.setMovement(1);
        }
        /*RangedFighter Stats Construction*/
        else if(orderableToBeCreated.equals("RangedFighter")) {
            statsOfOrderable.setArmor(2);
            statsOfOrderable.setDefensiveDamage(1);
            statsOfOrderable.setHealth(4);
            statsOfOrderable.setOffensiveDamage(3);
            statsOfOrderable.setUpKeep(3);
            statsOfOrderable.setMovement(2);
        }
        /*Explorer Stats Construction*/
        else if(orderableToBeCreated.equals("Explorer")) {
            statsOfOrderable.setArmor(1);
            statsOfOrderable.setDefensiveDamage(1);
            statsOfOrderable.setHealth(3);
            statsOfOrderable.setOffensiveDamage(1);
            statsOfOrderable.setUpKeep(2);
            statsOfOrderable.setMovement(3);
        }
        /*Colonist Stats Construction*/
        else if(orderableToBeCreated.equals("Colonist")) {
            statsOfOrderable.setArmor(1);
            statsOfOrderable.setDefensiveDamage(1);
            statsOfOrderable.setHealth(4);
            statsOfOrderable.setOffensiveDamage(1);
            statsOfOrderable.setUpKeep(2);
            statsOfOrderable.setMovement(2);
        }
        return statsOfOrderable;
    }
}
