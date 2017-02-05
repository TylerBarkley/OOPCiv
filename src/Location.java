import sun.security.action.GetLongAction;

import java.util.*;

/**
 * Created by zrgam_000 on 1/31/2017.
 */
public class Location {
    int x;
    int y;

    Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    Location getAdjacent(Map.MapDirection md){
        int newX = x;
        int newY = y;
        switch (md){
            case NORTH:
                newX = x-1;
                newY = y;
                break;
            case NORTHEAST:
                newX = x-1;
                newY = y+1;
                break;
            case NORTHWEST:
                newX = x-1;
                newY = y-1;
                break;
            case EAST:
                newX = x;
                newY = y+1;
                break;
            case WEST:
                newX = x;
                newY = y-1;
                break;
            case SOUTH:
                newX = x+1;
                newY = y;
                break;
            case SOUTHEAST:
                newX = x+1;
                newY = y+1;
                break;
            case SOUTHWEST:
                newX = x+1;
                newY = y-1;
                break;
        }

        return new Location(newX, newY);
    }

    HashMap<Location, Map.MapDirection> getAllAdjacent(){
        HashMap<Location, Map.MapDirection> adjacencies = new HashMap<Location, Map.MapDirection>();

        adjacencies.put(getAdjacent(Map.MapDirection.NORTH),Map.MapDirection.NORTH);
        adjacencies.put(getAdjacent(Map.MapDirection.NORTHEAST), Map.MapDirection.NORTHEAST);
        adjacencies.put(getAdjacent(Map.MapDirection.NORTHWEST), Map.MapDirection.NORTHWEST);
        adjacencies.put(getAdjacent(Map.MapDirection.EAST), Map.MapDirection.EAST);
        adjacencies.put(getAdjacent(Map.MapDirection.WEST), Map.MapDirection.WEST);
        adjacencies.put(getAdjacent(Map.MapDirection.SOUTH), Map.MapDirection.SOUTH);
        adjacencies.put(getAdjacent(Map.MapDirection.SOUTHEAST), Map.MapDirection.SOUTHEAST);
        adjacencies.put(getAdjacent(Map.MapDirection.SOUTHWEST), Map.MapDirection.SOUTHWEST);

        return adjacencies;
    }

    boolean equals(Location target){
        return x == target.x && y == target.y;
    }
}
