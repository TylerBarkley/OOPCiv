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
        if(e.getKeyCode() == KeyEvent.VK_CONTROL){
            ctrl = false;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(ctrl == true){
                player.getMenuState().cycleTypeR();
            }
            else{
                player.getMenuState().cycleInstanceR();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(ctrl == true){
                player.getMenuState().cycleTypeL();
            }
            else{
                player.getMenuState().cycleInstanceL();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if(ctrl == true){
                player.getMenuState().cycleModeL();
            }
            else{
                player.getMenuState().cycleInstructionL();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if(ctrl == true){
                player.getMenuState().cycleModeR();
            }
            else{
                player.getMenuState().cycleInstructionR();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_CONTROL){
            ctrl = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_L){
            this.player.setMyTurn(false);
        }
        
        Location loc=player.location;
        
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD1){
        	window.focusOn(loc.getAdjacent(Map.MapDirection.SOUTHWEST));
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD2){
        	window.focusOn(loc.getAdjacent(Map.MapDirection.SOUTH));
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD3){
        	window.focusOn(loc.getAdjacent(Map.MapDirection.SOUTHEAST));
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD5){
        	window.focusOn(ms.currentInstance);
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD7){
        	window.focusOn(loc.getAdjacent(Map.MapDirection.NORTHWEST));
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD8){
        	window.focusOn(loc.getAdjacent(Map.MapDirection.NORTH));
        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD9){
        	window.focusOn(loc.getAdjacent(Map.MapDirection.NORTHEAST));
        }

        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            Command co = CommandFactory.create(ms.getCurrentInstruction(), ms.getCurrentInstance());
            ms.getCurrentInstance().giveCommand(co);
            if(ms.getCurrentInstance() instanceof RallyPoint){
                ms.getCurrentInstance().getCommandQueue().carryOut();
            }

        }
        if(e.getKeyCode() == KeyEvent.VK_1){
            shortcutInstance(1);
        }
        if(e.getKeyCode() == KeyEvent.VK_2){
            shortcutInstance(2);
        }
        if(e.getKeyCode() == KeyEvent.VK_3){
            shortcutInstance(3);
        }
        if(e.getKeyCode() == KeyEvent.VK_4){
            shortcutInstance(4);
        }
        if(e.getKeyCode() == KeyEvent.VK_5){
            shortcutInstance(5);
        }
        if(e.getKeyCode() == KeyEvent.VK_6){
            shortcutInstance(6);
        }
        if(e.getKeyCode() == KeyEvent.VK_7){
            shortcutInstance(7);
        }
        if(e.getKeyCode() == KeyEvent.VK_8){
            shortcutInstance(8);
        }
        if(e.getKeyCode() == KeyEvent.VK_9){
            shortcutInstance(9);
        }
        if(e.getKeyCode() == KeyEvent.VK_0){
            shortcutInstance(10);
        }
        window.updateMenu();
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