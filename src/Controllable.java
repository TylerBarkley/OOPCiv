/**
 * Created by hankerins on 1/31/17.
 */
public abstract class Controllable implements Viewable{
    private Player player;
    private Location loc;
    private Map map;
    private CommandQueue commandQueue;
    CID cid;

    public Controllable(Player player, Location loc, Map map){
        this.player = player;
        this.loc = loc;
        this.map = map;

        cid = new CID();

        commandQueue = new CommandQueue();
    }

    abstract void endTurn();

    public CID getCID() {
        return cid;
    }

    void giveCommand(Command incomingCommand){
        commandQueue.add(incomingCommand);
    }

    abstract void clearCommands();

    abstract void doTurn();

    public Player getPlayer() {
        return player;
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

    public void setCommandQueue(CommandQueue commandQueue) {
        this.commandQueue = commandQueue;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
