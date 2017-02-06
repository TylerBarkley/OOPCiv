import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class UnitTableModel extends AbstractTableModel {

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
	
	public Class getColumnClass(int c) {
		return getValueAt(0,c).getClass();
	}
	
	public void updateData(Player player) {
		ArrayList<ArrayList<Unit>> units = player.getUnits();
		
		for(int j = 1; j <GameInfo.MAX_PER_TYPE + 1;j++ ) {
			for(int i = 0; i <GameInfo.UNIT_TYPES; i++) {
				
				if(units.get(i).get(j-1) != null) {
					data[i][j] = units.get(i).get(j-1);
				} else data[i][j] = new String("");
					 
				updateCell(i,j);
			}
		}
		
		
		ArrayList<Army> armies = player.getArmies();
		
		for(int j = 1; j < GameInfo.MAX_PER_TYPE + 1;j++) {
			if(armies.get(j-1) != null) data[GameInfo.UNIT_TYPES][j] = armies.get(j-1);
			else data[GameInfo.UNIT_TYPES][j] = new String("");
			}
			
		
		
	}
	
	public void updateCell(int row, int column) {
		this.fireTableCellUpdated(row,column);
	}
	
}