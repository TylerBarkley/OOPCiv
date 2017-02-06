import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KeyListenerHandler implements KeyListener {

    
    boolean ctrl;
    Player player;
    MenuState ms;
    GameWindow window;
    public KeyListenerHandler( Player player, GameWindow window) {
        
    	this.player = player;
        ms = player.getMenuState();
        this.window = window;

    }

    void setPlayer(Player player){
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
        
        Location loc=player.location;
        int x=loc.x;
        int y=loc.y;
        
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD0){
            System.out.println("0 pressed (Does nothing)");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD1){
        	window.focusOn(new Location(x-1,y+1));
            System.out.println("1 pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD2){
        	window.focusOn(new Location(x,y+1));
            System.out.println("2 pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD3){
        	window.focusOn(new Location(x+1,y+1));
            System.out.println("3 pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD4){
        	window.focusOn(new Location(x-1,y));
            System.out.println("4 pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD5){
        	window.focusOn(ms.currentInstance);
            System.out.println("5 pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD6){
        	window.focusOn(new Location(x+1,y));
            System.out.println("6 pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD7){
        	window.focusOn(new Location(x-1,y-1));
            System.out.println("7 pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD8){
        	window.focusOn(new Location(x,y-1));
            System.out.println("8 pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD9){
        	window.focusOn(new Location(x+1,y-1));
            System.out.println("9 pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            System.out.println(" ");
        }
        window.updateView();
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
        if(e.getKeyCode() == KeyEvent.VK_L){
            System.out.println("WE PRESSED L");
            this.player.setMyTurn(false);
        }
        
        Location loc=player.location;
        int x=loc.x;
        int y=loc.y;
        
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD0){
            System.out.println("0 pressed (Does nothing)");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD1){
        	window.focusOn(new Location(x-1,y+1));
            System.out.println("1 pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD2){
        	window.focusOn(new Location(x,y+1));
            System.out.println("2 pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD3){
        	window.focusOn(new Location(x+1,y+1));
            System.out.println("3 pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD4){
        	window.focusOn(new Location(x-1,y));
            System.out.println("4 pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD5){
        	window.focusOn(ms.currentInstance);
            System.out.println("5 pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD6){
        	window.focusOn(new Location(x+1,y));
            System.out.println("6 pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD7){
        	window.focusOn(new Location(x-1,y-1));
            System.out.println("7 pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD8){
        	window.focusOn(new Location(x,y-1));
            System.out.println("8 pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD9){
        	window.focusOn(new Location(x+1,y-1));
            System.out.println("9 pressed");
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
        window.updateMenu();
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
        window.updateView();
    }

    /*
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
        }


        new KeyListenerHandler("Key Listener Tester", player1);
    }
		*/

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