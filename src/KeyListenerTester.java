import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KeyListenerTester extends JFrame implements KeyListener {

    JLabel label;
    boolean ctrl;
    Player player;

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
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            System.out.println("Enter");
        }
        if(e.getKeyCode() == KeyEvent.VK_0){
            System.out.println("10");
        }
        if(e.getKeyCode() == KeyEvent.VK_1){
            System.out.println("01");
        }
        if(e.getKeyCode() == KeyEvent.VK_2){
            System.out.println("02");
        }
        if(e.getKeyCode() == KeyEvent.VK_3){
            System.out.println("03");
        }
        if(e.getKeyCode() == KeyEvent.VK_4){
            System.out.println("04");
        }
        if(e.getKeyCode() == KeyEvent.VK_5){
            System.out.println("05");
        }
        if(e.getKeyCode() == KeyEvent.VK_6){
            System.out.println("06");
        }
        if(e.getKeyCode() == KeyEvent.VK_7){
            System.out.println("07");
        }
        if(e.getKeyCode() == KeyEvent.VK_8){
            System.out.println("08");
        }
        if(e.getKeyCode() == KeyEvent.VK_9){
            System.out.println("09");
        }
        System.out.println("Current Mode: " + player.getMenuState().currentMode + "\n");
        System.out.println("Current Type: " + player.getMenuState().currentType + "\n");
        System.out.println("Current Instance: " + player.getMenuState().currentInstanceIndex + "\n");
        System.out.println("Current Mode: " + player.getMenuState().currentInstruction.getInstString() + "\n");
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
        Player player1 = new Player();
        for(int i = 0; i < GameInfo.UNIT_TYPES; i++){
            for(int j = 0; j < 4; j++){
                player1.getUnits().get(i).add(new Unit_Test());
            }
        }
        for(int i = 0; i < GameInfo.STRUCTURE_TYPES; i++){
            for(int j = 0; j < 4; j++){
                player1.getStructures().get(i).add(new Structure());
            }
        }
        for(int i = 0; i < 4; i++){
            player1.getArmies().add(new Army());
        }
        for(int i = 0; i < 4; i++){
            player1.getRallyPoints().add(new RallyPoint());
        }
        new KeyListenerTester("Key Listener Tester", player1);
    }
}