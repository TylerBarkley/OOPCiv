/**
 * Created by Trevor on 1/31/2017.
 */
public class Explorer extends Unit  {
    Explorer(Player player, Location loc, Map map, CID cid, Stats myStats){
        super(player, loc, map,cid, myStats);
    };

    Explorer(Base base){
        super(base.getPlayer(), base.getLoc(), base.getMap(), CID.giveCID(base.getPlayer(), GameInfo.EXPLORER),
                StatsFactory.createStats(GameInfo.EXPLORER));

    }

    public String toString(){
        return "Explorer";
    }
}
