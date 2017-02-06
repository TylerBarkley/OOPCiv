public class RunGame {
    public static void main(String args[]) {
        //MAP, PLAYERS, INITIAL UNITS
        Map map=new Map(10, 10, false);
        
        Player p1=new Player(map);
        Player p2=new Player(map);
        
        Explorer explorer1 = new Explorer(p1, new Location(2, 3), map, StatsFactory.createStats(GameInfo.EXPLORER));
        Explorer explorer2 = new Explorer(p1, new Location(2, 5), map, StatsFactory.createStats(GameInfo.EXPLORER));
        Colonist colonist1 = new Colonist(p1, new Location(1, 4), map, CID.giveCID(p1,
                GameInfo.COLONIST), StatsFactory.createStats(GameInfo.COLONIST));
        
        p1.register(explorer1);
        p1.register(explorer2);
        p1.register(colonist1);
        
        explorer1 = new Explorer(p2, new Location(8, 3), map, StatsFactory.createStats(GameInfo.EXPLORER));
        explorer2 = new Explorer(p2, new Location(8, 5), map, StatsFactory.createStats(GameInfo.EXPLORER));
        colonist1 = new Colonist(p2, new Location(7, 4), map, CID.giveCID(p2,
                GameInfo.COLONIST), StatsFactory.createStats(GameInfo.COLONIST));
        
        p2.register(explorer1);
        p2.register(explorer2);
        p2.register(colonist1);

        //SCREENS
        int width=1200, height=800;
        
        GameWindow window=new GameWindow(p1, p2, map, width, height);
        
        window.openWindow();
        window.placeDecal(new RedCross(), 1, 2);
        window.placeDecal(new SkullCrossBones(), 4, 4);
        
        window.focusOn(new Location(5, 5));
        window.focusOn(new Location(5, 6));
        window.focusOn(new Location(5, 7));
        window.focusOn(new Location(6, 7));
        window.focusOn(new Location(7, 7));
        window.focusOn(new Location(8, 8));
        window.focusOn(new Location(9, 9));
        window.focusOn(new Location(2, 2));
        window.focusOn(new Location(2, 3));
        window.focusOn(new Location(2, 4));
        window.focusOn(new Location(2, 5));
        window.focusOn(new Location(3, 5));
        window.focusOn(new Location(4, 5));
        window.focusOn(new Location(5, 5));
        window.focusOn(new Location(0, 9));
        window.focusOn(new Location(9, 0));
    }

}
