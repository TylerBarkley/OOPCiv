import java.util.ArrayList;

/**
 * Created by Trevor on 1/31/2017.
 */
public class Colonist extends Unit {

    public Colonist(Player player, Location loc, Map map, CID cid, Stats myStats, int actionPointCap) {
        super(player, loc, map, cid, myStats, actionPointCap);
    }


    boolean buildBase(){
        int personelID;

        //StatsFactory baseStats = new StatsFactory();
        //baseStats.create(GameInfo.BASE);

        ArrayList<Structure> bases = getPlayer().getStructures().get(GameInfo.BASE);

        for (personelID = 0; personelID < GameInfo.MAX_PER_TYPE; personelID++){
            if(bases.get(personelID) == null) break;
        }

        if(personelID == GameInfo.MAX_PER_TYPE){
            return false;
        }

        Base placedBase = new Base(getPlayer(), getLoc(), getMap(), new CID(GameInfo.BASE, personelID), myStats, 1, 2);

        getMap().getTile(getLoc()).addStructure(placedBase);

        this.killMe();

        return true;
    }
}