import java.util.ArrayList;

/**
 * Created by zrgam_000 on 1/31/2017.
 */
public class Base extends Structure {

    //UnitFactory unitFactory;

    public Base(Player player, Location loc, Map map, CID cid, Stats myStats) {
        super(player, loc, map, cid, myStats);
    }
    public Base(Colonist colonist) {
        super(colonist.getPlayer(), colonist.getLoc(), colonist.getMap(), CID.giveCID(colonist.getPlayer(),
                GameInfo.BASE), StatsFactory.createStats(GameInfo.BASE));
    }


    boolean ProduceUnit (int unitType){

        int personelID;

        ArrayList<Unit> units = getPlayer().getUnits().get(unitType);

        for (personelID = 0; personelID < GameInfo.MAX_PER_TYPE; personelID++){
            if(units.get(personelID) == null) break;
        }

        if(personelID == GameInfo.MAX_PER_TYPE){
            return false;
        }

        Unit placedUnit = UnitFactory.createUnit(unitType, getPlayer(), getLoc(), getMap());

        getMap().getTile(getLoc()).addUnit(placedUnit);

        return true;
    }
}
