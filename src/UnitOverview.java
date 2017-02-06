import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

import javax.swing.*;


public class UnitOverview extends Overview{

	private JTable unitTable;
	private JTextArea unitStatsArea;
	private JLabel currentMode, currentInstance,currentType,currentInstruction;
	private UnitTableModel model;
	private UnitTableRenderer renderer;
	
	public UnitOverview(Player player, int width, int height) {
		super(player, width, height);
		
		model = new UnitTableModel();
		unitTable = new JTable(model);
		
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
		updateMenuStateText();
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
		if(player.getUnits().get(this.ms.getCurrentType()).get(this.ms.getCurrentInstanceIndex()) != null) {
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
		
	}

	public void updateView() {
		updateMenuStateText();
		renderer.updateSelectedUnit(this.ms.getCurrentMode(), this.ms.getCurrentType(), this.ms.getCurrentInstanceIndex());
		model.updateData(this.player);
		if(this.ms.getCurrentMode() == GameInfo.UNITMODE || this.ms.getCurrentMode() == GameInfo.ARMYMODE) {
			displayCurrentUnitStatus();
		}
		
		
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
		this.setBackground(Color.orange);
	}
	
	public void updateMenu(){
		
	}
	
	private void updateMenuStateText() {
		currentMode.setText("CURRENT MODE= " + this.ms.getCurrentModeString());
		currentInstance.setText("CURRENT INSTANCE= " + this.ms.getCurrentInstanceIndex());
		currentType.setText("CURRENT TYPE= " + this.ms.getCurrentTypeString());
		currentInstruction.setText("CURRENT INSTRUCTION= " + this.ms.getCurrentInstruction().toString());
	}
	

	private void setRenderer() {
		for(int i = 1; i < GameInfo.MAX_PER_TYPE + 1;i++) {
			unitTable.getColumnModel().getColumn(i).setCellRenderer(renderer);
		}
	}
}