/**
 * Created by Trevor on 1/31/2017.
 */
public class Explorer extends Unit  {
    Explorer(Player player, Location loc, Map map, Stats myStats){
        super(player, loc, map, myStats);

        this.getCID().typeID = GameInfo.EXPLORER;
    }

    Explorer(Base base){
        super(base.getPlayer(), base.getLoc(), base.getMap(), StatsFactory.createStats(GameInfo.EXPLORER));

        this.getCID().typeID = GameInfo.EXPLORER;
    }

    public String toString(){
        return "Explorer";
    }
}
