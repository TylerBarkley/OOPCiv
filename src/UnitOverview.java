import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

import javax.swing.*;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class UnitOverview extends Overview{

	private JTable unitTable;
	private JTextArea unitStatsArea;
	private JLabel currentMode, currentInstance,currentType,currentInstruction;
	private UnitTableModel model;
	private UnitTableRenderer renderer;
	
	public UnitOverview(Player player, int width, int height) {
		super(player, width, height);
		unitTable = new JTable(new UnitTableModel());
		
		unitTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		unitTable.setRowSelectionAllowed(true);
		unitTable.setColumnSelectionAllowed(true);
		unitTable.setEnabled(false);
		
		unitStatsArea = new JTextArea();
		unitStatsArea.setEditable(false);
		
		currentMode = new JLabel("CURRENT MODE= "); 
		currentMode.setAlignmentX(Component.CENTER_ALIGNMENT);
		currentInstance = new JLabel("CURRENT INSTANCE= "); 
		currentInstance.setAlignmentX(Component.CENTER_ALIGNMENT);
		currentType = new JLabel("CURRENT TYPE= ");
		currentType.setAlignmentX(Component.CENTER_ALIGNMENT);
		currentInstruction = new JLabel("CURRENT INSTRUCTION= ");
		currentInstruction.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		renderer = new UnitTableRenderer();
		setRenderer();
		displayView();
	}
	
	private ArrayList<Unit> getAllUnits(){
		ArrayList<Unit> allUnits=new ArrayList<Unit>();
		for(ArrayList<Unit> units: player.getUnits()){
			allUnits.addAll(units);
		}
		return allUnits;
	}
	
	private ArrayList<Unit> getExplorerUnits(){
		return player.getUnits().get(GameInfo.EXPLORER);	
	}
	
	private ArrayList<Unit> getColonistUnits(){
		return player.getUnits().get(GameInfo.COLONIST);
	}
	
	private ArrayList<Unit> getMeleeFighterUnits(){
		return player.getUnits().get(GameInfo.MELEEUNIT);
	}
	
	private ArrayList<Unit> getRangedFighterUnits(){
		return player.getUnits().get(GameInfo.RANGEDUNIT);
	}
	
	private ArrayList<Army> getArmies(){
		return player.getArmies();
	}
	
	private void displayCurrentUnitStatus(){
		unitStatsArea.setText("");
		
		Stats status =  player.getUnits().get(this.ms.getCurrentType()).get(this.ms.getCurrentInstanceIndex()).getMyStats();
		unitStatsArea.setText(status.toString() + "\n");
		CommandQueue unitCommandQueue = player.getUnits().get(this.ms.getCurrentType()).get(this.ms.getCurrentInstanceIndex()).getCommandQueue();
		
		Queue<Command> unitQueue = unitCommandQueue.getCommandQueue();
		Iterator<Command> iterator = unitQueue.iterator();
		while(iterator.hasNext()) {
			unitStatsArea.append(iterator.next().toString() + " ");
		}
	}

	public void updateView() {
		model.updateData(this.player);
		
	}

	public void displayView() {
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		JLabel title = new JLabel("Unit Overview");
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(title);
	
		
		this.add(new FixedScrollPane(unitTable,width,height/3));
		this.add(new FixedScrollPane(unitStatsArea,width,height/3));
		
		JLabel menuTitle = new JLabel("MENU STATE: ");
		menuTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(menuTitle);
		this.add(currentMode);
		this.add(currentType);
		this.add(currentInstance);
		this.add(currentInstruction);
		
	}
	
	public void updateMenu(){
		updateMenuStateText();
		renderer.updateSelectedUnit(this.ms.getCurrentMode(), this.ms.getCurrentType(), this.ms.getCurrentInstanceIndex());
		if(this.ms.getCurrentMode() == GameInfo.UNITMODE || this.ms.getCurrentMode() == GameInfo.ARMYMODE) {
			displayCurrentUnitStatus();
			model.updateCell(this.ms.getCurrentType(), this.ms.getCurrentInstanceIndex() + 1);
		}
	}
	
	private void updateMenuStateText() {
		currentMode.setText("CURRENT MODE= " + this.ms.getCurrentModeString());
		currentInstance.setText("CURRENT INSTANCE= " + this.ms.getCurrentInstanceIndex());
		currentType.setText("CURRENT TYPE= " + this.ms.getCurrentTypeString());
		currentInstruction.setText("CURRENT INSTRUCTION= " + this.ms.getCurrentTypeString());
	}
	
	public static void main(String[] args) { //For testing purposes only! 
		JFrame frame = new JFrame();
		
		frame.setSize(1200, 800);
		frame.add(new UnitOverview(null,1200,800));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void setRenderer() {
		for(int i = 1; i < GameInfo.MAX_PER_TYPE + 1;i++) {
			unitTable.getColumnModel().getColumn(i).setCellRenderer(renderer);
		}
	}
}