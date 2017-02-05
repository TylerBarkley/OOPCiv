/**
 * Created by Trevor on 2/2/2017.
 */
public class UnitFactory {
    static Unit createUnit(int orderableToBeCreated,Player player, Location loc, Map map){
        Unit unitToBeCreated;
        if(orderableToBeCreated==GameInfo.MELEEUNIT) {
            unitToBeCreated=new MeleeFighter(player, loc, map,CID.giveCID(player,orderableToBeCreated), StatsFactory.createStats(orderableToBeCreated),2);
            return unitToBeCreated;
        } else if(orderableToBeCreated==GameInfo.RANGEDUNIT) {
            unitToBeCreated = new MeleeFighter(player, loc, map, CID.giveCID(player, orderableToBeCreated), StatsFactory.createStats(orderableToBeCreated), 2);
            return unitToBeCreated;
        }else if(orderableToBeCreated==GameInfo.COLONIST) {
            unitToBeCreated=new MeleeFighter(player, loc, map,CID.giveCID(player,orderableToBeCreated), StatsFactory.createStats(orderableToBeCreated),2);
            return unitToBeCreated;
        } else if(orderableToBeCreated==GameInfo.EXPLORER) {
            unitToBeCreated=new MeleeFighter(player, loc, map,CID.giveCID(player,orderableToBeCreated), StatsFactory.createStats(orderableToBeCreated),2);
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
