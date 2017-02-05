/**
 * Created by Trevor on 1/31/2017.
 */
public class RangedFighter extends Unit {

    RangedFighter(Player player, Location loc, Map map, CID cid, Stats myStats){
        super(player, loc, map,cid, myStats);
    };

    RangedFighter(Base base){
        super(base.getPlayer(), base.getLoc(), base.getMap(), CID.giveCID(base.getPlayer(), GameInfo.RANGEDUNIT),
                StatsFactory.createStats(GameInfo.RANGEDUNIT));

    }

    public String toString(){
        return "Ranged Fighter";
    }

}