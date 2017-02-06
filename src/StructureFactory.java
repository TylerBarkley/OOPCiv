/**
 * Created by Trevor on 2/4/2017.
 */
public class StructureFactory {
    public  static Structure createStructure(int structureType,Player player, Location loc, Map map){
        Structure structureToBeCreated = null;
        if (structureType==GameInfo.BASE) {
            structureToBeCreated=new Base(player, loc, map);

        }

        if(structureToBeCreated != null && player.register(structureToBeCreated)) { return structureToBeCreated; }

        return null;
    }

    public  static Structure createStructure(int structureType, Colonist creator){
        Structure structureToBeCreated = null;
        if (structureType==GameInfo.BASE) {
            structureToBeCreated = new Base(creator);

        }

        if(structureToBeCreated != null && creator.getPlayer().register(structureToBeCreated)) { return structureToBeCreated; }
        return null;
    }
}
