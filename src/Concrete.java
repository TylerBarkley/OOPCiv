/**
 * Created by Tyler Barkley on 2/4/2017.
 */
public abstract class Concrete extends Controllable{


    protected Stats myStats;
    private int currentHealth;
    private int actionPoints;
    private int actionPointCap;
    Map.MapDirection facingDirection;
    double state;

    public Concrete(Player player, Location loc, Map map, Stats myStats) {
        super(player, loc, map);
        this.myStats = myStats;
        this.currentHealth = myStats.getHealth();
        this.actionPointCap = myStats.getRate();
        this.actionPoints = actionPointCap;
    }


    void healMe(int ammount){

        if((this.currentHealth += ammount) > myStats.getHealth()) {
            this.currentHealth = myStats.getHealth();
        }
    }

    void damageMe(int ammount){
        this.currentHealth -= ammount-this.getMyStats().getArmor();

        if(this.currentHealth <= 0){
            this.killMe();
        }
    }

    abstract void standby(); //{ state=.75; }
    abstract void wait4me(); //{ state=1; }
    abstract void powerDown(); //{state=.25;}
    abstract void powerUp();
    abstract void attack(Map.MapDirection md);


    public void setFacingDirection(Map.MapDirection facingDirection) {
        this.facingDirection = facingDirection;
    }

    abstract void killMe();

    public void setMyStats(Stats myStats) {
        this.myStats = myStats;
    }

    public double getState() {
        return state;
    }

    public void setState(double state) {
        this.state = state;
    }

    public Stats getMyStats() {
        return myStats;
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
