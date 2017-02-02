/**
 * Created by Tyler Barkley on 2/1/2017.
 */
public class StructureStats {
    int offensiveDamage;

    int defensiveDamage;

    int armor;

    int movement;

    int health;

    int UpKeep;

    double ProductionRates;

    void setOffensiveDamage(int offensiveDamage){this.offensiveDamage=offensiveDamage;}

    void setDefensiveDamage(int defensiveDamage){this.defensiveDamage=defensiveDamage;}

    void setArmor(int armor){this.armor=armor;}

    void setHealth(int health){this.health=health;}

    void setUpKeep(int UpKeep){this.UpKeep=UpKeep;}

    void setProductionRates(double ProductionRates){this.ProductionRates=ProductionRates;}

    void print(){
        System.out.print("Health: "+health);
        System.out.print(" Offensive Damage: "+offensiveDamage);
        System.out.print(" Defensive Damage: "+defensiveDamage);
        System.out.print(" Armor: "+armor);
        System.out.print(" UpKeep: "+UpKeep);
        System.out.print(" Production Rates: "+ProductionRates);
        System.out.println();

    }

    StructureStats(){
    }
}
