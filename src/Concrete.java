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
        this.currentHealth -= ammount;

        if(this.currentHealth <= 0){
            this.killMe();
        }
    }

    void standby(){
        state=.75;
    }
    void wait4me(){
        state=1;
    }
    void powerDown(){
        state=.25;
    }
    void powerUp(){
        state=1.25;
    }


    public void setFacingDirection(Map.MapDirection facingDirection) {
        this.facingDirection = facingDirection;
    }

    abstract void killMe();

    public void setMyStats(Stats myStats) {
        this.myStats = myStats;
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
