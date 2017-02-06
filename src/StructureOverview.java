import java.awt.Color;
import java.awt.Component;
import java.util.Iterator;
import java.util.Queue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

public class StructureOverview extends Overview{

	private JTable structureTable;
	private JTextArea structureStatsArea;
	private JLabel currentMode, currentInstance,currentType,currentInstruction;
	private StructureTableModel model;
	private StructureTableRenderer renderer;
	
	public StructureOverview(Player player, int width, int height) {
		super(player, width, height);
		
		model = new StructureTableModel();
		structureTable = new JTable(model);
		structureTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		structureTable.setRowSelectionAllowed(true);
		structureTable.setColumnSelectionAllowed(true);
		structureTable.setEnabled(false);
		
		structureStatsArea = new JTextArea();
		structureStatsArea.setEditable(false);
		
		currentMode = new JLabel("CURRENT MODE= "); 
		currentMode.setAlignmentX(Component.CENTER_ALIGNMENT);
		currentInstance = new JLabel("CURRENT INSTANCE= "); 
		currentInstance.setAlignmentX(Component.CENTER_ALIGNMENT);
		currentType = new JLabel("CURRENT TYPE= ");
		currentType.setAlignmentX(Component.CENTER_ALIGNMENT);
		currentInstruction = new JLabel("CURRENT INSTRUCTION= ");
		currentInstruction.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		renderer = new StructureTableRenderer();
		
		updateMenuStateText();
		setRenderer();
		displayView();
		
	}

	private Structure getAllStructures(){
		return null;
	}
	
	private void displayStructureStatus(Structure structure){
		
	}

	private void updateMenuStateText() {
		currentMode.setText("CURRENT MODE= " + this.ms.getCurrentModeString());
		currentInstance.setText("CURRENT INSTANCE= " + this.ms.getCurrentInstanceIndex());
		currentType.setText("CURRENT TYPE= " + this.ms.getCurrentTypeString());
		currentInstruction.setText("CURRENT INSTRUCTION= " + this.ms.getCurrentInstruction().toString());
	}
	
	private void displayCurrentStructureStatus(){
		
		if(player.getStructures().get(this.ms.getCurrentType()).get(this.ms.getCurrentInstanceIndex()) != null) {
			structureStatsArea.setText("");
			Stats status =  player.getStructures().get(this.ms.getCurrentType()).get(this.ms.getCurrentInstanceIndex()).getMyStats();
			structureStatsArea.setText(status.toString() + "\n");
			CommandQueue unitCommandQueue = player.getStructures().get(this.ms.getCurrentType()).get(this.ms.getCurrentInstanceIndex()).getCommandQueue();
			
			Queue<Command> unitQueue = unitCommandQueue.getCommandQueue();
			Iterator<Command> iterator = unitQueue.iterator();
			while(iterator.hasNext()) {
				structureStatsArea.append(iterator.next().toString() + " ");
			}
		}
		
	}
	
	
	public void updateView() {
		updateMenuStateText();
		renderer.updateSelectedUnit(this.ms.getCurrentMode(), this.ms.getCurrentType(), this.ms.getCurrentInstanceIndex());
		model.updateData(this.player);
		if(this.ms.getCurrentMode() == GameInfo.STRUCTUREMODE) {
			displayCurrentStructureStatus();
		}

	}

	public void displayView() {
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		JLabel title = new JLabel("Structure Overview");
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(title);
		
		this.add(new FixedScrollPane(structureTable,width,height/3));
		this.add(new FixedScrollPane(structureStatsArea,width,height/3));
		
		JLabel menuTitle = new JLabel("MENU STATE: ");
		menuTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(menuTitle);
		this.add(currentMode);
		this.add(currentType);
		this.add(currentInstance);
		this.add(currentInstruction);
		this.setBackground(Color.orange);
	}
	
	public void setRenderer() {
		for(int i = 1; i < GameInfo.MAX_PER_TYPE + 1;i++) {
			structureTable.getColumnModel().getColumn(i).setCellRenderer(renderer);
		}
	}
	
	public void updateMenu(){
		
	}
	
}
