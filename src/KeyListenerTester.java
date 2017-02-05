import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KeyListenerTester extends JFrame implements KeyListener {

    JLabel label;
    boolean ctrl;
    Player player;
    MenuState ms;

    public KeyListenerTester(String s, Player player) {
        super(s);
        JPanel p = new JPanel();
        label = new JLabel("Key Listener!");
        p.add(label);
        add(p);
        addKeyListener(this);
        setSize(200, 100);
        setVisible(true);
        this.player = player;
        ms = player.getMenuState();

    }

    @Override
    public void keyTyped(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Right key typed");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Left key typed");
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("Up key typed");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("Down key typed");
        }
        if(e.getKeyCode() == KeyEvent.VK_CONTROL){
            System.out.println("Starting control");
            ctrl = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD0){
            System.out.println(" ");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD1){
            System.out.println(" ");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD2){
            System.out.println(" ");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD3){
            System.out.println(" ");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD4){
            System.out.println(" ");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD5){
            System.out.println(" ");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD6){
            System.out.println(" ");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD7){
            System.out.println(" ");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD8){
            System.out.println(" ");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD9){
            System.out.println(" ");
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            System.out.println(" ");
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

        //TODO: all key presses should update view, single function to do so

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(ctrl == true){
                System.out.println("Cycle Type right");
                player.getMenuState().cycleTypeR();
            }
            else{
                System.out.println("Cycle Type instance right");
                player.getMenuState().cycleInstanceR();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(ctrl == true){
                System.out.println("Cycle Type left");
                player.getMenuState().cycleTypeL();
            }
            else{
                System.out.println("Cycle Type instance left");
                player.getMenuState().cycleInstanceL();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if(ctrl == true){
                System.out.println("Cycle Mode up");
                player.getMenuState().cycleModeL();
            }
            else{
                System.out.println("Cycle Command up");
                player.getMenuState().cycleInstructionL();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if(ctrl == true){
                System.out.println("Cycle Mode down");
                player.getMenuState().cycleModeR();
            }
            else{
                System.out.println("Cycle Type Command down");
                player.getMenuState().cycleInstructionR();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_CONTROL){
            ctrl = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD0){
            System.out.println("N10");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD1){
            System.out.println("N01");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD2){
            System.out.println("N02");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD3){
            System.out.println("N03");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD4){
            System.out.println("N04");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD5){
            System.out.println("N05");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD6){
            System.out.println("N06");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD7){
            System.out.println("N07");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD8){
            System.out.println("N08");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD9){
            System.out.println("N09");
        }
        //
        //
        //
        //
        //
        //ZAC THIS IS WHERE THE COMMANDS GET MADE!!
        //
        //
        //
        //
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            System.out.println("Enter");
            Command co = CommandFactory.create(ms.getCurrentInstruction(), ms.getCurrentInstance());
            ms.getCurrentInstance().giveCommand(co);
        }
        if(e.getKeyCode() == KeyEvent.VK_1){
            System.out.println("01");
            //TODO check for unit existence
            shortcutInstance(1);
        }
        if(e.getKeyCode() == KeyEvent.VK_2){
            System.out.println("02");
            //TODO check for unit existence
            shortcutInstance(2);
        }
        if(e.getKeyCode() == KeyEvent.VK_3){
            System.out.println("03");
            shortcutInstance(3);
        }
        if(e.getKeyCode() == KeyEvent.VK_4){
            System.out.println("04");
            shortcutInstance(4);
        }
        if(e.getKeyCode() == KeyEvent.VK_5){
            System.out.println("05");
            shortcutInstance(5);
        }
        if(e.getKeyCode() == KeyEvent.VK_6){
            System.out.println("06");
            shortcutInstance(6);
        }
        if(e.getKeyCode() == KeyEvent.VK_7){
            System.out.println("07");
            shortcutInstance(7);
        }
        if(e.getKeyCode() == KeyEvent.VK_8){
            System.out.println("08");
            shortcutInstance(8);
        }
        if(e.getKeyCode() == KeyEvent.VK_9){
            System.out.println("09");
            shortcutInstance(9);
        }
        if(e.getKeyCode() == KeyEvent.VK_0){
            System.out.println("10");
            shortcutInstance(10);
        }
        System.out.println("Current Mode: " + ms.getCurrentModeString() + "\n");
        System.out.println("Current Type: " + ms.getCurrentTypeString() + "\n");
        System.out.println("Current Instance: " + ms.currentInstanceIndex + "\n");
        System.out.println("Current Instruction: " + ms.getCurrentInstruction().toString() + "\n");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {

        }
        if(e.getKeyCode() == KeyEvent.VK_CONTROL){
            ctrl = false;
        }
    }

    //test program, makes a player with 4 of each controllable
    //makes a key listener and does the major navigation operations
    //prints results
    public static void main(String[] args) {

        Map map = new Map(10, 10, false); //builds T+T's map


        Player player1 = new Player(map);

        //this is actual stuff we have to start

        Explorer explorer1 = new Explorer(player1, new Location(2, 3), map, CID.giveCID(player1,
                GameInfo.EXPLORER), StatsFactory.createStats(GameInfo.EXPLORER));
        Explorer explorer2 = new Explorer(player1, new Location(2, 5), map, CID.giveCID(player1,
                GameInfo.EXPLORER), StatsFactory.createStats(GameInfo.EXPLORER));
        Colonist colonist1 = new Colonist(player1, new Location(1, 4), map, CID.giveCID(player1,
                GameInfo.COLONIST), StatsFactory.createStats(GameInfo.COLONIST));

        /*for(int i = 0; i < GameInfo.UNIT_TYPES; i++){
            for(int j = 0; j < 4; j++){
                player1.getUnits().get(i).add(new Explorer());
            }
        }
        for(int i = 0; i < GameInfo.STRUCTURE_TYPES; i++){
            for(int j = 0; j < 4; j++){
                player1.getStructures().get(i).add(new Structure());
            }
        }
        for(int i = 0; i < 4; i++){
            player1.getArmies().add(new Army(player1.getUnits().get(GameInfo.EXPLORER).get(0), player1));
        }
        for(int i = 0; i < 4; i++){
            player1.getRallyPoints().add(new RallyPoint());
        }*/


        new KeyListenerTester("Key Listener Tester", player1);
    }

    public void shortcutInstance(int input){
        int currentIndex = ms.getCurrentInstanceIndex();
        int wantedIndex = input;
        int diff = wantedIndex - currentIndex;
        if(diff < 0){
            diff = Math.abs(diff);
            for(int i = 0; i < diff; i++) {
                player.getMenuState().cycleInstanceL();
            }
        }
        else if(diff > 0){
            for(int i = 0; i < diff; i++){
                player.getMenuState().cycleInstanceR();
            }
        }
    }
}