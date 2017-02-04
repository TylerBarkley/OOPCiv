import java.awt.Component;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class UnitOverview extends Overview{

	private JTable unitTable;
	private JTextArea unitStatsArea;
	
	public UnitOverview(Player player, int width, int height) {
		super(player, width, height);
		unitTable = new JTable(new UnitTableModel());
		unitStatsArea = new JTextArea(5,40);
		unitStatsArea.setEditable(false);
		unitTable.setFillsViewportHeight(true);
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
	
	private void displayUnitStatus(Unit unit){
		
	}

	public void updateView() {

	}

	public void displayView() {
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		JLabel title = new JLabel("Unit Overview");
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(title);
		this.add(new JScrollPane(unitTable));
		this.add(new JScrollPane(unitStatsArea));
		
		
	}
	
	public void updateMenu(MenuState menuState){
		
	}
	
	public static void main(String[] args) { //For testing purposes only! 
		JFrame frame = new JFrame();
		frame.setSize(1200, 800);
		frame.add(new UnitOverview(null,1200,800));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class UnitTableModel extends AbstractTableModel {

	private String[] columnNames;
	private Object[][] data; 
	
	public UnitTableModel() {
		generateColumnNames();
		generateData();
	}
	
	private void generateColumnNames() {
		columnNames = new String[GameInfo.MAX_PER_TYPE + 1];
		columnNames[0] = "Unit Types";
		
		for(int i = 1; i < columnNames.length;i++) {
			columnNames[i] = Integer.toString(i);
		}
	}
	
	private void generateData() {
		data = new Object[GameInfo.UNIT_TYPES_NAMES.length][GameInfo.MAX_PER_TYPE + 1];
		
		for(int j = 0; j <GameInfo.MAX_PER_TYPE + 1;j++ ) {
			for(int i = 0; i <GameInfo.UNIT_TYPES_NAMES.length; i++) {
				if(j == 0) {
					data[i][j] = GameInfo.UNIT_TYPES_NAMES[i];
				}
				else {
					data[i][j] = new String("");
				}
			}
		}
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data[rowIndex][columnIndex];
	}
	
}
