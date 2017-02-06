import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by hankerins on 2/5/17.
 */
public class RunGame {
    public static void main(String args[]) throws IOException { //for testing purposes only!
        //MAP, PLAYERS, INITIAL UNITS
        Map map=new Map(10, 10, false);
        Player p1=new Player(map);
        Explorer explorer1 = new Explorer(p1, new Location(2, 3), map, StatsFactory.createStats(GameInfo.EXPLORER));
        Explorer explorer2 = new Explorer(p1, new Location(2, 5), map, StatsFactory.createStats(GameInfo.EXPLORER));
        Colonist colonist1 = new Colonist(p1, new Location(1, 4), map, CID.giveCID(p1,
                GameInfo.COLONIST), StatsFactory.createStats(GameInfo.COLONIST));
        Player p2=new Player(map);
        explorer1 = new Explorer(p2, new Location(8, 3), map, StatsFactory.createStats(GameInfo.EXPLORER));
        explorer2 = new Explorer(p2, new Location(8, 5), map, StatsFactory.createStats(GameInfo.EXPLORER));
        colonist1 = new Colonist(p2, new Location(7, 4), map, CID.giveCID(p2,
                GameInfo.COLONIST), StatsFactory.createStats(GameInfo.COLONIST));

        //SCREENS
        MainScreen main=new MainScreen(p1,p2,map,1275,850);
        JFrame frame = new JFrame();
        frame.setSize(1275, 850);
        frame.add(main);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.placeDecal(new RedCross(), 1, 2);
        main.placeDecal(new SkullCrossBones(), 4, 4);

        main.focusOn(new Location(0, 0));

        //KEYLISTENER -> switch this between players when turn ends
       // new KeyListenerTester(p1);

    }

}
