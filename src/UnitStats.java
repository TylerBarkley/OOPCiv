/**
 * Created by Tyler Barkley on 2/1/2017.
 */
public class UnitStats extends Stats {

    private int movement;

    void setMovement(int movement){this.movement=movement;}

    int getMovement(){return movement;}


    void print(){
        System.out.print("Health: "+getHealth());
        System.out.print(" Offensive Damage: "+getOffensiveDamage());
        System.out.print(" Defensive Damage: "+getDefensiveDamage());
        System.out.print(" Armor: "+getArmor());
        System.out.print(" UpKeep: "+getUpKeep());
        System.out.print(" Production Rates: "+getMovement());
        System.out.println();
    }

    UnitStats(){
    }
}
