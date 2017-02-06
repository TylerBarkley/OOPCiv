/**
 * Created by Trevor on 1/31/2017.
 */
public class RangedFighter extends Unit {

    RangedFighter(Player player, Location loc, Map map, CID cid, Stats myStats){
        super(player, loc, map, myStats);

        this.getCID().typeID = GameInfo.RANGEDUNIT;
    };

    RangedFighter(Base base){
        super(base.getPlayer(), base.getLoc(), base.getMap(), StatsFactory.createStats(GameInfo.RANGEDUNIT));

        this.getCID().typeID = GameInfo.RANGEDUNIT;
    }

    public String toString(){
        return "Ranged Fighter";
    }

}