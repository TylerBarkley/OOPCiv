/**
 * Created by Trevor on 2/2/2017.
 */
public class UnitFactory {
    static Unit createUnit(int orderableToBeCreated,Player player, Location loc, Map map) {
        Unit unitToBeCreated = null;
        if (orderableToBeCreated == GameInfo.MELEEUNIT) {
            unitToBeCreated = new MeleeFighter(player, loc, map, CID.giveCID(player, orderableToBeCreated), StatsFactory.createStats(orderableToBeCreated));

        } else if (orderableToBeCreated == GameInfo.RANGEDUNIT) {
            unitToBeCreated = new MeleeFighter(player, loc, map, CID.giveCID(player, orderableToBeCreated), StatsFactory.createStats(orderableToBeCreated));

        } else if (orderableToBeCreated == GameInfo.COLONIST) {
            unitToBeCreated = new MeleeFighter(player, loc, map, CID.giveCID(player, orderableToBeCreated), StatsFactory.createStats(orderableToBeCreated));

        } else if (orderableToBeCreated == GameInfo.EXPLORER) {
            unitToBeCreated = new MeleeFighter(player, loc, map, CID.giveCID(player, orderableToBeCreated), StatsFactory.createStats(orderableToBeCreated));
        }

        if(unitToBeCreated != null && player.register(unitToBeCreated)) { return unitToBeCreated; }

        return null;
    }

    static Unit createUnit(Base base, int orderableToBeCreated){
        Unit unitToBeCreated = null;
                ;
        if(orderableToBeCreated==GameInfo.MELEEUNIT) {
            unitToBeCreated=new MeleeFighter(base);

        } else if(orderableToBeCreated==GameInfo.RANGEDUNIT) {
            unitToBeCreated = new RangedFighter(base);

        }else if(orderableToBeCreated==GameInfo.COLONIST) {
            unitToBeCreated=new Colonist(base);

        } else if(orderableToBeCreated==GameInfo.EXPLORER) {
            unitToBeCreated=new Explorer(base);

        }

        if(unitToBeCreated != null && base.getPlayer().register(unitToBeCreated)) { return unitToBeCreated; }

        return null;
    }
}
