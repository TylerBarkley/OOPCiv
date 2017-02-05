/**
 * Created by Trevor on 1/31/2017.
 */
public class MeleeFighter extends Unit {
    MeleeFighter(Player player, Location loc, Map map, CID cid, Stats myStats, int actionPointCap){
        super(player, loc, map,cid, myStats,actionPointCap);
        unitType="MELEEUNIT";
    };
}
