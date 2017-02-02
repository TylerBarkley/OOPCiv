import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KeyListenerTester extends JFrame implements KeyListener {

    JLabel label;
    boolean ctrl;
    public KeyListenerTester(String s) {
        super(s);
        JPanel p = new JPanel();
        label = new JLabel("Key Listener!");
        p.add(label);
        add(p);
        addKeyListener(this);
        setSize(200, 100);
        setVisible(true);

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
            }
            else{
                System.out.println("Cycle Type instance right");
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(ctrl == true){
                System.out.println("Cycle Type left");
            }
            else{
                System.out.println("Cycle Type instance left");
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if(ctrl == true){
                System.out.println("Cycle Mode up");
            }
            else{
                System.out.println("Cycle Command up");
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if(ctrl == true){
                System.out.println("Cycle Mode down");
            }
            else{
                System.out.println("Cycle Type Command down");
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

    public static void main(String[] args) {
        new KeyListenerTester("Key Listener Tester");
    }
}