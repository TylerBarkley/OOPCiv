import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


public class StructureTableModel extends AbstractTableModel {

	private String[] columnNames;
	private Object[][] data;
	
	public StructureTableModel() {
		generateColumnNames();
		generateData();
	
	}
	
	private void generateColumnNames() {
		columnNames = new String[GameInfo.MAX_PER_TYPE + 1];
		columnNames[0] = "Structure Types";
		
		for(int i = 1; i < columnNames.length;i++) {
			columnNames[i] = Integer.toString(i);
		}
	}
	
	private void generateData() {
		data = new Object[GameInfo.STRUCTURE_TYPES_NAMES.length][GameInfo.MAX_PER_TYPE + 1];
		
		for(int j = 0; j <GameInfo.MAX_PER_TYPE + 1;j++ ) {
			for(int i = 0; i <GameInfo.STRUCTURE_TYPES_NAMES.length; i++) {
				if(j == 0) {
					data[i][j] = GameInfo.STRUCTURE_TYPES_NAMES[i];
				}
				else {
					data[i][j] = new String("");
				}
			}
		}

	}
	
	public void updateData(Player player) {
		ArrayList<ArrayList<Structure>> structures = player.getStructures();
		
		for(int j = 1; j <GameInfo.MAX_PER_TYPE + 1;j++ ) {
			for(int i = 0; i <GameInfo.STRUCTURE_TYPES; i++) {
				if(structures.get(i).get(j-1) != null) {
					data[i][j] = structures.get(i).get(j-1);
				} 
				else {
					data[i][j] = new String("");
				}
				updateCell(i,j);
			}
		}
		
		
	}
	
	public void updateCell(int row, int column) {
		this.fireTableCellUpdated(row,column);
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
	
	public Class getColumnClass(int c) {
		return getValueAt(0,c).getClass();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data[rowIndex][columnIndex];
	}

}
