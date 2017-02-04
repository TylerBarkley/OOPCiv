/**
 * Created by Tyler Barkley on 2/4/2017.
 */
public abstract class Concrete extends Controllable{


    protected Stats myStats;
    private int currentHealth;
    private int actionPoints;
    private int actionPointCap;


    void healMe(int ammount){

        if((this.currentHealth += ammount) > myStats.getHealth()) {
            this.currentHealth = myStats.getHealth();
        }
    }

    void damageMe(int ammount){
        this.currentHealth -= ammount;

        if(this.currentHealth <= 0){
            this.killMe();
        }
    }

    abstract void killMe();

    public CID getCID() {
        return cid;
    }

    public void setMyStats(Stats myStats) {
        this.myStats = myStats;
    }

    public int getActionPoints() {
        return actionPoints;
    }

    public void setActionPoints(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    public int getActionPointCap() {
        return actionPointCap;
    }

    public void setActionPointCap(int actionPointCap) {
        this.actionPointCap = actionPointCap;
    }
}
