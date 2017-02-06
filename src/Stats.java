/**
 * Created by Tyler Barkley on 2/1/2017.
 */
public class  Stats {
    private int offensiveDamage;

    private int defensiveDamage;

    private int armor;

    private int health;

    private int UpKeep;

    private int rate;

    void setOffensiveDamage(int offensiveDamage){this.offensiveDamage=offensiveDamage;}

    void setDefensiveDamage(int defensiveDamage){this.defensiveDamage=defensiveDamage;}

    void setArmor(int armor){this.armor=armor;}

    void setHealth(int health){this.health=health;}
    void setUpKeep(int UpKeep){this.UpKeep=UpKeep;}
    void setRate(int rate){this.rate = rate;};

    int getOffensiveDamage(){return offensiveDamage;}

    int getDefensiveDamage(){return defensiveDamage;}

    int getArmor(){return armor;}

    int getHealth(){return health;}

    int getUpKeep(){return UpKeep;}

    int getRate(){return rate;}

    public String toString(){
        String s = "";
        s += ("\nHealth: "+getHealth());
        s += (" \nOffensive Damage: "+getOffensiveDamage());
        s += (" \nDefensive Damage: "+getDefensiveDamage());
        s += (" \nArmor: "+getArmor());
        s += ("\nUpKeep: "+getUpKeep());

        return s;
    }
    Stats(){
        //DEFAULT
    }

}
