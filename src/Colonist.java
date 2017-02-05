import java.util.ArrayList;

/**
 * Created by Trevor on 1/31/2017.
 */
public class Colonist extends Unit {

    Colonist(Player player, Location loc, Map map, CID cid, Stats myStats){
        super(player, loc, map,cid, myStats);
    };

    Colonist(Base base){
        super(base.getPlayer(), base.getLoc(), base.getMap(), CID.giveCID(base.getPlayer(), GameInfo.COLONIST),
                StatsFactory.createStats(GameInfo.COLONIST));

    }

    public String toString(){
        return "Explorer";
    }


    boolean buildBase(){
        int personelID;

        ArrayList<Structure> bases = getPlayer().getStructures().get(GameInfo.BASE);

        for (personelID = 0; personelID < GameInfo.MAX_PER_TYPE; personelID++){
            if(bases.get(personelID) == null) break;
        }

        if(personelID == GameInfo.MAX_PER_TYPE){
            return false;
        }

        //Base placedBase = (getPlayer(), getLoc(), getMap(), new CID(GameInfo.BASE, personelID), myStats, 1, 2);

        //getMap().getTile(getLoc()).addStructure(placedBase);

        this.killMe();

        return true;
    }
}
