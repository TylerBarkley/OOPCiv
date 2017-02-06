import java.util.ArrayList;

/**
 * Created by Trevor on 1/31/2017.
 */
public class Colonist extends Unit {

    Colonist(Player player, Location loc, Map map, CID cid, Stats myStats){
        super(player, loc, map, myStats);

        this.getCID().typeID = GameInfo.COLONIST;
    }

    Colonist(Base base){
        super(base.getPlayer(), base.getLoc(), base.getMap(), StatsFactory.createStats(GameInfo.COLONIST));

        this.getCID().typeID = GameInfo.COLONIST;
    }

    public String toString(){
        return "Explorer";
    }


    void buildBase(){

        Structure placedBase = StructureFactory.createStructure(GameInfo.BASE, this);

        if(placedBase != null) {
            getMap().getTile(getLoc()).addStructure(placedBase);

            this.killMe();
        }
    }
}
