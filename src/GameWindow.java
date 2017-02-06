import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class GameWindow extends JFrame {
	private Player player;
	private Player opponent;
	private Map map;
	private int width;
	private int height;

	private JTabbedPane tabbedPane;

	private MainScreen mainScreen;
	private UnitOverview unitOverview;
	private StructureOverview structureOverview;

	public GameWindow(Player player, Player opponent, Map map, int width, int height) {
		this.player = player;
		this.opponent=opponent;
		this.map = map;
		this.width = width;
		this.height = height;
		this.setTitle("Lost In the Sauce");

		this.tabbedPane=new JTabbedPane();
		removeDefaultKeyListeners();
		tabbedPane.addKeyListener(new KeyListenerHandler(player,this));
		
		this.mainScreen=new MainScreen(player,opponent,map,width,height);
		this.unitOverview=new UnitOverview(player, width, height);
		this.structureOverview=new StructureOverview(player, width, height);
		
		tabbedPane.setFocusable(true);
		addComponentListener(new ComponentListener() {
		    public void componentResized(ComponentEvent e) { updateView();}

			public void componentMoved(ComponentEvent e) {updateView();}

			public void componentShown(ComponentEvent e) {updateView();}

			public void componentHidden(ComponentEvent e) {updateView();}
		});
		
		setUpTabbedPane();
		addGameMenu();
	}

	public GameWindow(Player player, Player opponent, Map map) {
		this(player, opponent, map, 1080, 720);
	}

	private void setUpTabbedPane() {
		tabbedPane.addTab("Main Screen", mainScreen);
		tabbedPane.addTab("Structure Overview", structureOverview);
		tabbedPane.addTab("Unit Overview", unitOverview);
		this.add(tabbedPane);
	}

	public void openWindow(){
		this.setSize(width, height);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void closeWindow(){
		this.closeWindow();
	}

	public void switchToUnitOverview(){
		tabbedPane.setSelectedComponent(unitOverview);
	}

	public void switchToStructureOverview(){
		tabbedPane.setSelectedComponent(structureOverview);
	}

	public void switchToMainScreen(){
		tabbedPane.setSelectedComponent(mainScreen);
	}

	public void updateMapView(){ 
		mainScreen.updateAreaView();
	}

	public void updateUnitViews(){  
		mainScreen.updateSatusView();
		unitOverview.updateView();
	}

	public void updateStructureViews(){ 
		mainScreen.updateSatusView();
		structureOverview.updateView();
	}

	public void updateView(){
		mainScreen.updateAreaView();
		mainScreen.updateSatusView();
		unitOverview.updateView();
		structureOverview.updateView();
	}

	public void updateMenu(){
		mainScreen.updateMenu();
		unitOverview.updateMenu();
		structureOverview.updateMenu();
	}

	public void focusOn(Location loc){
		mainScreen.focusOn(loc);
	}

	public void focusOn(Controllable c){
		mainScreen.focusOn(c);
	}

	private void removeDefaultKeyListeners() {
	 
		Action doNothing = new AbstractAction() {
		    public void actionPerformed(ActionEvent e) {
		        //do nothing
		    }
		};
		
		tabbedPane.getInputMap().put(KeyStroke.getKeyStroke("LEFT"),"doNothing");
		tabbedPane.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"),"doNothing");
		tabbedPane.getInputMap().put(KeyStroke.getKeyStroke("UP"),"doNothing");
		tabbedPane.getInputMap().put(KeyStroke.getKeyStroke("DOWN"),"doNothing");
		tabbedPane.getInputMap().put(KeyStroke.getKeyStroke("LEFT"),"doNothing");
		tabbedPane.getInputMap().put(KeyStroke.getKeyStroke("ENTER"),"doNothing");
		tabbedPane.getInputMap().put(KeyStroke.getKeyStroke("control DOWN"),"doNothing");
		tabbedPane.getInputMap().put(KeyStroke.getKeyStroke("control UP"),"doNothing");
		tabbedPane.getInputMap().put(KeyStroke.getKeyStroke("control"),"doNothing");
		tabbedPane.getActionMap().put("doNothing",doNothing);
		
	}
	private void addGameMenu() {


		JMenu fileMenu = new JMenu("File");

		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		fileMenu.add(exitItem);

		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		this.setJMenuBar(menuBar);

	}

	public void placeDecal(Decal decal, int x, int y) {
		mainScreen.placeDecal(decal, x, y);
	}
}
