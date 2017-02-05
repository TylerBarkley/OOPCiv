import java.util.ArrayList;

/**
 * Created by zrgam_000 on 1/31/2017.
 */
public class Base extends Structure {

    UnitFactory unitFactory;

    public Base(Player player, Location loc, Map map, CID cid, Stats myStats, int actionPointCap, int ProductionRates) {
        super(player, loc, map, cid, myStats, actionPointCap, ProductionRates);

        unitFactory = new UnitFactory();
    }

    boolean ProduceUnit (int unitType){
        /*
        int personelID;

        //StatsFactory unitStats = new StatsFactory();
        //unitStats.create(unitType);


        ArrayList<Unit> units = getPlayer().getUnits().get(unitType);

        for (personelID = 0; personelID < GameInfo.MAX_PER_TYPE; personelID++){
            if(units.get(personelID) == null) break;
        }

        if(personelID == GameInfo.MAX_PER_TYPE){
            return false;
        }

        Unit placedUnit = new Unit(getPlayer(), getLoc(), getMap(), new CID(unitType, personelID), myStats, getActionPointCap(), 2);


        getMap().getTile(getLoc()).addUnit(placedUnit);
        */
        return true;
    }

}
