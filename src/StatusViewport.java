import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

public class StatusViewport extends Viewport{

	private int width, height;
	private JTextArea structureArea, unitArea;
	private JLabel currentMode, currentInstance,currentType,currentInstruction;

	public StatusViewport(Player player, int width, int height) {
		super(player, width, height);
		this.width = width;
		this.height = height;

		structureArea = new JTextArea();
		unitArea = new JTextArea();

		structureArea.setEditable(false);
		unitArea.setEditable(false);

		currentMode = new JLabel("CURRENT MODE= "); 
		currentMode.setAlignmentX(Component.CENTER_ALIGNMENT);
		currentInstance = new JLabel("CURRENT INSTANCE= "); 
		currentInstance.setAlignmentX(Component.CENTER_ALIGNMENT);
		currentType = new JLabel("CURRENT TYPE= ");
		currentType.setAlignmentX(Component.CENTER_ALIGNMENT);
		currentInstruction = new JLabel("CURRENT INSTRUCTION= ");
		currentInstruction.setAlignmentX(Component.CENTER_ALIGNMENT);

		updateMenuStates();
		displayView();
	}

	public void displayAllStatuses(){
		ArrayList<ArrayList<Unit>> units = this.player.getUnits();
		ArrayList<ArrayList<Structure>> strucs = this.player.getStructures();

		for(int i = 0; i < units.size();i++) {
			for(int j = 0; j < units.get(i).size(); j++) {
				if(units.get(i).get(j) != null){
					String unitType = units.get(i).get(j).toString();
					Stats unitStats = units.get(i).get(j).getMyStats();
					unitArea.append(unitType +":" + "\n" + "Health: " + unitStats.getHealth() +"\n\n");
				}
			}
		}

		for(int i = 0; i < strucs.size();i++) {
			for(int j = 0; j < strucs.get(i).size(); j++) {
				if(strucs.get(i).get(j) != null){
					String structureType = strucs.get(i).get(j).toString();
					Stats structureStats = strucs.get(i).get(j).getMyStats();
					structureArea.append(structureType +":" + "\n" + "Health: " + structureStats.getHealth() +"\n\n");
				}
			}
		}

	}

	private void displayUnitStatus(Unit unit){
		//not safe, possibility of listing the same unit twice
		String unitType = unit.toString();
		Stats unitStats = unit.getMyStats();
		unitArea.append(unitType +":" + "\n" + "Health: " + unitStats.getHealth() + unitStats.getUpKeep()+"\n\n");
	}

	private void displayStructureStatus(Structure structure){
		//not safe, possibility of listing same structure twice
		String structureType = structure.toString();
		Stats structureStats = structure.getMyStats();
		structureArea.append(structureType +":" + "\n" + "Health: " + structureStats.getHealth() + structureStats.getUpKeep() + "\n\n");

	}

	public void updateView() {
		unitArea.setText("");
		structureArea.setText("");
		displayAllStatuses();
		updateMenuStates();
	}

	public void displayView() {

		FixedPanel panelA= new FixedPanel(width/2, height/2);
		panelA.setLayout(new BoxLayout(panelA,BoxLayout.Y_AXIS));
		panelA.add(new JLabel("Structures"));
		panelA.add(new JScrollPane(structureArea));



		FixedPanel panelB= new FixedPanel(width/2, height/2);
		panelB.setLayout(new BoxLayout(panelB,BoxLayout.Y_AXIS));
		panelB.add(new JLabel("Units",JLabel.CENTER));
		panelB.add(new JScrollPane(unitArea));

		JPanel panelAB = new JPanel();
		panelAB.setLayout(new BoxLayout(panelAB,BoxLayout.X_AXIS));
		panelAB.add(Box.createHorizontalStrut(10));
		panelAB.add(panelA);
		panelAB.add(Box.createHorizontalStrut(10));
		panelAB.add(panelB);
		panelAB.add(Box.createHorizontalStrut(10));
		//panelAB.setBackground(Color.blue);

		JPanel textPanel = new FixedPanel(width,height/5);
		textPanel.setLayout(new BoxLayout(textPanel,BoxLayout.Y_AXIS));



		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setBackground(Color.orange);
		//this.add(Box.createVerticalGlue());
		JLabel title = new JLabel("Status ViewPort");
		title.setAlignmentX(Component.CENTER_ALIGNMENT);

		this.add(title);
		this.add(panelAB);	
		JLabel menu = new JLabel("MENU STATE");
		menu.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(menu);
		this.add(currentMode);

		this.add(currentType);
		this.add(currentInstance);
		this.add(currentInstruction);
		
		updateView();
	}

	void updateMenuStates() {
		currentMode.setText("CURRENT MODE= " + player.getMenuState().getCurrentModeString());
		currentInstance.setText("CURRENT INSTANCE= " + player.getMenuState().getCurrentInstanceIndex());
		currentType.setText("CURRENT TYPE= " + player.getMenuState().getCurrentTypeString());
		currentInstruction.setText("CURRENT INSTRUCTION= " + player.getMenuState().getCurrentInstruction().toString());
	}

	public void swapTurn(Player player) {
		this.player=player;
	}

}

