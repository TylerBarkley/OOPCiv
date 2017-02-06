/**
 * Created by zrgam_000 on 1/31/2017.
 */
public class Base extends Structure {

    //UnitFactory unitFactory;

    public Base(Player player, Location loc, Map map) {
        super(player, loc, map, StatsFactory.createStats(GameInfo.BASE));
    }

    public Base(Colonist colonist) {
        super(colonist.getPlayer(), colonist.getLoc(), colonist.getMap(), StatsFactory.createStats(GameInfo.BASE));
        this.getCID().typeID = GameInfo.BASE;
        structureType="Base";
    }


    void ProduceUnit (int unitType){

        Unit placedUnit = UnitFactory.createUnit(this, unitType);

        if(placedUnit != null) {
            getMap().getTile(getLoc()).addUnit(placedUnit);
        }
    }
    
    public int getTypeID(){
    	return GameInfo.BASE_VIEW_ID;
    }

    public void healDirection(Map.MapDirection md) {
        Tile targetTile = this.getMap().getTile(getLoc());

        for(Unit luckyGuys : targetTile.getUnitsOnTile()){
            luckyGuys.healMe(5);
        }
    }
}
