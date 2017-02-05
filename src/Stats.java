/**
 * Created by Tyler Barkley on 2/1/2017.
 */
public class  Stats {
    private int offensiveDamage;

    private int defensiveDamage;

    private int armor;

    private int health;

    private int UpKeep;

    private int movement;

    void setOffensiveDamage(int offensiveDamage){this.offensiveDamage=offensiveDamage;}

    void setDefensiveDamage(int defensiveDamage){this.defensiveDamage=defensiveDamage;}

    void setArmor(int armor){this.armor=armor;}

    void setHealth(int health){this.health=health;}
    void setMovement(int movement){this.health=health;}
    void setUpKeep(int UpKeep){this.UpKeep=UpKeep;}

    int getOffensiveDamage(){return offensiveDamage;}

    int getDefensiveDamage(){return defensiveDamage;}

    int getArmor(){return armor;}

    int getHealth(){return health;}

    int getUpKeep(){return UpKeep;}

    int getMovement(){return movement;}

    public String toString(){
        String s = "";
        s += ("Health: "+getHealth());
        s += (" Offensive Damage: "+getOffensiveDamage());
        s += (" Defensive Damage: "+getDefensiveDamage());
        s += (" Armor: "+getArmor());
        s += (" UpKeep: "+getUpKeep());

        return s;
    }
    Stats(){
        //DEFAULT
    }

}
