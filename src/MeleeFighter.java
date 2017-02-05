/**
 * Created by Trevor on 1/31/2017.
 */
public class MeleeFighter extends Unit {
    MeleeFighter(Player player, Location loc, Map map, CID cid, Stats myStats){
        super(player, loc, map,cid, myStats);
    };

    MeleeFighter(Base base){
        super(base.getPlayer(), base.getLoc(), base.getMap(), CID.giveCID(base.getPlayer(), GameInfo.MELEEUNIT),
                StatsFactory.createStats(GameInfo.MELEEUNIT));

    }

    public String toString(){
        return "Melee Fighter";
    }
}
