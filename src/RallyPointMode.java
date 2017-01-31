import java.util.ArrayList;

/**
 * Created by hankerins on 1/31/17.
 */
public class RallyPointMode extends Mode {

    ArrayList<RallyPoint> rallyPoints;

    RallyPointMode(Player player){
        this.player = player;
        this.rallyPoints = player.getRallyPoints();
    }

    int cycleTypeL(){ return 0; } //no types in RP mode
    int cycleTypeR(){ return 0; }

    int cycleInstanceL(){
        int lastInstance = rallyPoints.size() -1;
        if(currentInstance == 0)
            currentInstance = lastInstance;
        else currentInstance--;
        return currentInstance;
    }
    int cycleInstanceR(){
        int lastInstance = rallyPoints.size() - 1;
        if(currentInstance == lastInstance)
            currentInstance = 0;
        else currentInstance++;
        return currentInstance;
    }
}
}
