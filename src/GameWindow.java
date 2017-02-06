import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		tabbedPane.addKeyListener(new KeyListenerHandler(player,this));

		this.mainScreen=new MainScreen(player,opponent,map,width,height);
		this.unitOverview=new UnitOverview(player, width, height);
		this.structureOverview=new StructureOverview(player, width, height);

		//for testing only
		mainScreen.placeDecal(new RedCross(), 1, 2);
		mainScreen.placeDecal(new SkullCrossBones(), 4, 4);

		this.addKeyListener(new KeyListenerHandler(player, this));
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

	public void focusOn(Unit unit){
		mainScreen.focusOn(unit);
	}

	public void focusOn(Structure structure){
		mainScreen.focusOn(structure);
	}

	public static void main(String[] args) {
		Map map=new Map(10, 10, false);
		Player player=new Player(map);
		Player opponent=new Player(map);
		GameWindow game = new GameWindow(player,opponent,map,1275,850);
		game.openWindow();


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


}
