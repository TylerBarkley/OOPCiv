/**
 * Created by Trevor on 1/31/2017.
 */
public class Stats {
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

    void setMovement(int movement){this.movement=movement;}

    void setHealth(int health){this.health=health;}

    void setUpKeep(int UpKeep){this.UpKeep=UpKeep;}

    void setProductionRates(double ProductionRates){this.ProductionRates=ProductionRates;}

    void print(){
        System.out.print("Health: "+health);
        System.out.print(" Offensive Damage: "+offensiveDamage);
        System.out.print(" Defensive Damage: "+defensiveDamage);
        System.out.print(" Armor: "+armor);
        System.out.print(" Movement: "+movement);
        System.out.print(" UpKeep: "+UpKeep);
        System.out.print(" Production Rates: "+ProductionRates);
        System.out.println();

    }

    Stats(){
    }
}
