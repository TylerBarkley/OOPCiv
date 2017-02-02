/**
 * Created by Tyler Barkley on 2/1/2017.
 */
public class StructureStatsFactory {
    static StructureStats produceStructureStats(String orderableToBeCreated){
        StructureStats statsOfOrderable=new StructureStats();
        /*Base Stats Construction*/
        if(orderableToBeCreated.equals("Base")) {
            statsOfOrderable.setArmor(4);
            statsOfOrderable.setDefensiveDamage(2);
            statsOfOrderable.setHealth(10);
            statsOfOrderable.setOffensiveDamage(4);
            statsOfOrderable.setUpKeep(6);
            statsOfOrderable.setProductionRates(1.25);
        }
        return statsOfOrderable;
    }
}
