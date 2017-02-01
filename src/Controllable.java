/**
 * Created by hankerins on 1/31/17.
 */
public abstract class Controllable {
    Player player;
    Stats stats;
    CID cid;
    Location loc;
    Map map;
    CommandQueue commandQueue;

    int currentHealth;
    int actionPoints;

    abstract void endTurn();

    abstract void healMe();

    abstract void damageMe();

    abstract void killMe();

    void giveCommand(Command incomingCommand){
        commandQueue.add(incomingCommand);
    }

    void clearCommands(){
        commandQueue.clear();
    }

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

    public Stats getStats() {
        return stats;
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
