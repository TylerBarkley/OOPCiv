/**
 * Created by Trevor on 2/4/2017.
 */
public class StructureFactory {
    public  static Structure createStructure(int structureType,Player player, Location loc, Map map){
        Structure structureToBeCreated;
        if (structureType==GameInfo.BASE) {
            structureToBeCreated=new Base(player, loc, map, CID.giveCID(player, GameInfo.BASE), StatsFactory.createStats(GameInfo.BASE));
            return structureToBeCreated;
        }
        return null;
    }

    public  static Structure createStructure(int structureType, Colonist creator){
        Structure structureToBeCreated;
        if (structureType==GameInfo.BASE) {
            structureToBeCreated = new Base(creator);
            return structureToBeCreated;
        }
        return null;
    }
}
