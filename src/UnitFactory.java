/**
 * Created by Trevor on 2/2/2017.
 */
public class UnitFactory {
    static Unit createUnit(String orderableToBeCreated, Map currentMap){
        Unit unitToBeCreated;
        if(orderableToBeCreated.equals("MeleeFighter")) {
            unitToBeCreated=new MeleeFighter(orderableToBeCreated,currentMap);
            return unitToBeCreated;
        }
        /*RangedFighter UnitStats Construction*/
        else if(orderableToBeCreated.equals("RangedFighter")) {
            unitToBeCreated=new RangedFighter(orderableToBeCreated,currentMap);
            return unitToBeCreated;
        }
        /*Explorer UnitStats Construction*/
        else if(orderableToBeCreated.equals("Explorer")) {
            unitToBeCreated=new Explorer(orderableToBeCreated,currentMap);
            return unitToBeCreated;

        }
        /*Colonist UnitStats Construction*/
        else if(orderableToBeCreated.equals("Colonist")) {
            unitToBeCreated=new Colonist(orderableToBeCreated,currentMap);
            return unitToBeCreated;
        }
        return null;
    }
}
