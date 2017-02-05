import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hankerins on 1/31/17.
 */

public class RallyPoint extends Controllable {

    Army army;

    Map.MapDirection[][] paths;

    public void generatePaths(){
        Queue<Location> bfsQueue = new LinkedList<Location>();
        bfsQueue.add(this.getLoc());

        paths[this.getLoc().x][this.getLoc().y] = null;

        while(!bfsQueue.isEmpty()){

            Location nextLoc = bfsQueue.poll();

            HashMap<Location, Map.MapDirection> adjacency = nextLoc.getAllAdjacent();

            for(Location loc : adjacency.keySet()){

                if(paths[loc.x][loc.y] == null && !this.getLoc().equals(loc) && getMap().getTile(loc).openTile(getPlayer())){
                    paths[loc.x][loc.y] = adjacency.get(loc);
                    bfsQueue.add(loc);
                }

            }
        }
    }

    Map.MapDirection getPath(Location loc){
        return paths[loc.x][loc.y];
    }

    RallyPoint(Army army){
        super(army.getPlayer(), army.getLoc(), army.getMap(), CID.giveCID(army.getPlayer(), GameInfo.RALLYPOINT));
        this.army = army;
        paths = new Map.MapDirection[GameInfo.MAP_SIZE][GameInfo.MAP_SIZE];
        }

    @Override
    void endTurn() {

    }

    @Override
    void clearCommands() {

    }

    @Override
    void doTurn() {

    }
}
