import java.util.ArrayList;

/**
 * Created by Trevor on 1/31/2017.
 */
public class Colonist extends Unit {

    Colonist(Player player, Location loc, Map map, CID cid, Stats myStats){
        super(player, loc, map,cid, myStats);
    };

    Colonist(Base base){
        super(base.getPlayer(), base.getLoc(), base.getMap(), CID.giveCID(base.getPlayer(), GameInfo.COLONIST),
                StatsFactory.createStats(GameInfo.COLONIST));

    }

    public String toString(){
        return "Explorer";
    }


    void buildBase(){

        Structure placedBase = StructureFactory.createStructure(GameInfo.BASE, this);

        getMap().getTile(getLoc()).addStructure(placedBase);

        this.killMe();
    }
}
