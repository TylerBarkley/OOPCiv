/**
 * Created by Trevor on 2/2/2017.
 */
public class UnitFactory {
    static Unit createUnit(int orderableToBeCreated,Player player, Location loc, Map map) {
        Unit unitToBeCreated;
        if (orderableToBeCreated == GameInfo.MELEEUNIT) {
            unitToBeCreated = new MeleeFighter(player, loc, map, CID.giveCID(player, orderableToBeCreated), StatsFactory.createStats(orderableToBeCreated));
            return unitToBeCreated;
        } else if (orderableToBeCreated == GameInfo.RANGEDUNIT) {
            unitToBeCreated = new MeleeFighter(player, loc, map, CID.giveCID(player, orderableToBeCreated), StatsFactory.createStats(orderableToBeCreated));
            return unitToBeCreated;
        } else if (orderableToBeCreated == GameInfo.COLONIST) {
            unitToBeCreated = new MeleeFighter(player, loc, map, CID.giveCID(player, orderableToBeCreated), StatsFactory.createStats(orderableToBeCreated));
            return unitToBeCreated;
        } else if (orderableToBeCreated == GameInfo.EXPLORER) {
            unitToBeCreated = new MeleeFighter(player, loc, map, CID.giveCID(player, orderableToBeCreated), StatsFactory.createStats(orderableToBeCreated));
            return unitToBeCreated;
        }

        return null;
    }

    static Unit createUnit(Base base, int orderableToBeCreated){
        Unit unitToBeCreated;
        if(orderableToBeCreated==GameInfo.MELEEUNIT) {
            unitToBeCreated=new MeleeFighter(base);
            return unitToBeCreated;
        } else if(orderableToBeCreated==GameInfo.RANGEDUNIT) {
            unitToBeCreated = new RangedFighter(base);
            return unitToBeCreated;
        }else if(orderableToBeCreated==GameInfo.COLONIST) {
            unitToBeCreated=new Colonist(base);
            return unitToBeCreated;
        } else if(orderableToBeCreated==GameInfo.EXPLORER) {
            unitToBeCreated=new Explorer(base);
            return unitToBeCreated;
        }
        //TODO: NEED TO IMPLEMENT THESE CONSTRUCTION
        /*RangedFighter UnitStats Construction*/
      /*  else if(orderableToBeCreated.equals("RangedFighter")) {
            unitToBeCreated=new RangedFighter(player, loc, map, cid, StatsFactory.createStats("RANGEDFIGHTER"),2);
            return unitToBeCreated;
        }*/
        /*Explorer UnitStats Construction*/
       /* else if(orderableToBeCreated.equals("Explorer")) {
            unitToBeCreated=new Explorer(player, loc, map, cid, StatsFactory.createStats("EXPLORER"),1);
            return unitToBeCreated;

        }*/
        /*Colonist UnitStats Construction*/
        /*else if(orderableToBeCreated.equals("Colonist")) {
            unitToBeCreated=new Colonist(player, loc, map, cid, StatsFactory.createStats("COLONIST"),2);
            return unitToBeCreated;
        }*/
        return null;
    }
}
