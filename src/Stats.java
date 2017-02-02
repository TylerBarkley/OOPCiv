/**
 * Created by Tyler Barkley on 2/1/2017.
 */
public abstract class  Stats {
    private int offensiveDamage;

    private int defensiveDamage;

    private int armor;

    private int health;

    private int UpKeep;

    void setOffensiveDamage(int offensiveDamage){this.offensiveDamage=offensiveDamage;}

    void setDefensiveDamage(int defensiveDamage){this.defensiveDamage=defensiveDamage;}

    void setArmor(int armor){this.armor=armor;}

    void setHealth(int health){this.health=health;}

    void setUpKeep(int UpKeep){this.UpKeep=UpKeep;}

    int getOffensiveDamage(){return offensiveDamage;}

    int getDefensiveDamage(){return defensiveDamage;}

    int getArmor(){return armor;}

    int getHealth(){return health;}

    int getUpKeep(){return UpKeep;}
    abstract int getMovement();
    abstract void print();

}
