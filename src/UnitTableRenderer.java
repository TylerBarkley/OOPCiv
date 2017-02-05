import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class UnitTableRenderer extends DefaultTableCellRenderer {
	private int currentType = -1;
	private int currentInstance = -1;
	
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		
		JLabel label;
		if(row == currentType && column == currentInstance + 1) {
			isSelected = true;
			label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			label.setBorder(BorderFactory.createLineBorder(Color.RED));
		}
		else {
			isSelected = false;
			label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		}
		
		if(value instanceof Unit  || value instanceof Army) {
			label.setText("");
			label.setBackground(Color.GREEN);
		}
		
		return label;
	}
	
	public void updateSelectedUnit(int currentMode, int currentType, int currentInstance) {
		if(currentMode == GameInfo.ARMYMODE || currentMode == GameInfo.UNITMODE) {
			this.currentType = currentType;
			this.currentInstance = currentInstance;
		}
		else {
			currentType = -1;
			currentInstance = -1;
		}
	}
}
