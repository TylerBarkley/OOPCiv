/**
 * Created by Trevor on 1/31/2017.
 */
public class StatsFactory {
    static Stats produceStats(String orderableToBeCreated){
        Stats statsOfOrderable=new Stats();
        /* Example of MeleeFigther Stats Construction*/
        if(orderableToBeCreated.equals("MeleeFighter")) {
            statsOfOrderable.setArmor(3);
            statsOfOrderable.setDefensiveDamage(1);
            statsOfOrderable.setHealth(2);
            statsOfOrderable.setOffensiveDamage(3);
            statsOfOrderable.setUpKeep(3);
            statsOfOrderable.setMovement(1);
            statsOfOrderable.setProductionRates(1.25);
        }
        return statsOfOrderable;
    }
}
