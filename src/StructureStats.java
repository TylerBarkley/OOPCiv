/**
 * Created by Tyler Barkley on 2/1/2017.
 */
public class StructureStats extends Stats{

    private double ProductionRates;

    void setProductionRates(double ProductionRates){this.ProductionRates=ProductionRates;}

    double getProductionRates(){return ProductionRates;}
    int getMovement(){return 0;}

    void print(){
        System.out.print("Health: "+getHealth());
        System.out.print(" Offensive Damage: "+getOffensiveDamage());
        System.out.print(" Defensive Damage: "+getDefensiveDamage());
        System.out.print(" Armor: "+getArmor());
        System.out.print(" UpKeep: "+getUpKeep());
        System.out.print(" Production Rates: "+getProductionRates());
        System.out.println();
    }

    StructureStats(){
    }
}
