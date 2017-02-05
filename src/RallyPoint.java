import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hankerins on 1/31/17.
 */

public class RallyPoint extends Controllable {

    Army army;

    Map.MapDirection[][] paths;

    @Override
    void endTurn() {

    }

    @Override
    void doTurn(){

    }


    void killMe() {

    }

    @Override
    void clearCommands() {

    }

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

    //TODO: delete or fix this default constructor
    RallyPoint(){
        paths = new Map.MapDirection[GameInfo.MAP_SIZE][GameInfo.MAP_SIZE];

    }
    RallyPoint(Army army){
        this.army = army;
    }
}
