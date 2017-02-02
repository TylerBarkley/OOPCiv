/**
 * Created by hankerins on 1/31/17.
 */
public abstract class Controllable {
    Player player;
    CID cid;
    Location loc;
    Map map;
    CommandQueue commandQueue;
    Stats myStats;

    int currentHealth;
    int actionPoints;

    abstract void endTurn();

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

    void giveCommand(Command incomingCommand){
        commandQueue.add(incomingCommand);
    }

    abstract void clearCommands();

    public abstract void doTurn();

    public Player getPlayer() {
        return player;
    }

    public CID getCID() {
        return cid;
    }

    public Location getLoc() {
        return loc;
    }

    public Map getMap() {
        return map;
    }

    public CommandQueue getCommandQueue() {
        return commandQueue;
    }

    public void setLoc(Location target) {
        this.loc = target;
    }
}
