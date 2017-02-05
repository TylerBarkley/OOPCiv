/**
 * Created by zrgam_000 on 1/31/2017.
 */
public class Base extends Structure {

    //UnitFactory unitFactory;

    public Base(Player player, Location loc, Map map) {
        super(player, loc, map, CID.giveCID(player, GameInfo.BASE), StatsFactory.createStats(GameInfo.BASE));
    }

    public Base(Colonist colonist) {
        super(colonist.getPlayer(), colonist.getLoc(), colonist.getMap(), CID.giveCID(colonist.getPlayer(),
                GameInfo.BASE), StatsFactory.createStats(GameInfo.BASE));
    }


    void ProduceUnit (int unitType){

        Unit placedUnit = UnitFactory.createUnit(this, unitType);

        getMap().getTile(getLoc()).addUnit(placedUnit);
    }

    public void healDirection(Map.MapDirection md) {
        Tile targetTile = this.getMap().getTile(getLoc());

        for(Unit luckyGuys : targetTile.getUnitsOnTile()){
            luckyGuys.healMe(5);
        }
    }
}
