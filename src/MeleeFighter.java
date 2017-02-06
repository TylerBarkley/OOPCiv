/**
 * Created by Trevor on 1/31/2017.
 */
public class MeleeFighter extends Unit {
    MeleeFighter(Player player, Location loc, Map map, CID cid, Stats myStats){
        super(player, loc, map, myStats);

        this.getCID().typeID = GameInfo.MELEEUNIT;
    }

    MeleeFighter(Base base){
        super(base.getPlayer(), base.getLoc(), base.getMap(), StatsFactory.createStats(GameInfo.MELEEUNIT));

        this.getCID().typeID = GameInfo.MELEEUNIT;
    }

    public String toString(){
        return "Melee Fighter";
    }
}
