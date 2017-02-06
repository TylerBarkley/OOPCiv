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
			newX = x;
			newY = y+1;
			break;
		case NORTHEAST:
			newX = x+1;
			newY = y+1;
			break;
		case NORTHWEST:
			newX = x-1;
			newY = y+1;
			break;
		case EAST:
			newX = x+1;
			newY = y;
			break;
		case WEST:
			newX = x-1;
			newY = y;
			break;
		case SOUTH:
			newX = x;
			newY = y-1;
			break;
		case SOUTHEAST:
			newX = x+1;
			newY = y-1;
			break;
		case SOUTHWEST:
			newX = x-1;
			newY = y-1;
			break;
		}

		return new Location(newX, newY);
	}

	HashMap<Location, Map.MapDirection> getAllAdjacent(){
		HashMap<Location, Map.MapDirection> adjacencies = new HashMap<Location, Map.MapDirection>();

		Location adj=getAdjacent(Map.MapDirection.NORTH);
		if(adj.isValid())
			adjacencies.put(adj,Map.MapDirection.NORTH);
		
		adj=getAdjacent(Map.MapDirection.NORTHEAST);
		if(adj.isValid())
			adjacencies.put(adj, Map.MapDirection.NORTHEAST);
		
		adj=getAdjacent(Map.MapDirection.NORTHWEST);
		if(adj.isValid())
			adjacencies.put(adj, Map.MapDirection.NORTHWEST);
		
		adj=getAdjacent(Map.MapDirection.EAST);
		if(adj.isValid())
			adjacencies.put(adj, Map.MapDirection.EAST);
		
		adj=getAdjacent(Map.MapDirection.WEST);
		if(adj.isValid())
			adjacencies.put(adj, Map.MapDirection.WEST);
		
		adj=getAdjacent(Map.MapDirection.SOUTH);
		if(adj.isValid())
			adjacencies.put(adj, Map.MapDirection.SOUTH);
		
		adj=getAdjacent(Map.MapDirection.SOUTHEAST);
		if(adj.isValid())
			adjacencies.put(adj, Map.MapDirection.SOUTHEAST);
		
		adj=getAdjacent(Map.MapDirection.SOUTHWEST);
		if(adj.isValid())
			adjacencies.put(adj, Map.MapDirection.SOUTHWEST);

		return adjacencies;
	}

	boolean equals(Location target){
		return x == target.x && y == target.y;
	}

	public boolean isValid(){
		return (x>=0) && (x < GameInfo.MAP_SIZE) && (y>=0) && (y< GameInfo.MAP_SIZE);
	}
}
