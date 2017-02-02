import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.*;

public class StatusViewport extends Viewport{

	private int width, height;
	private JTextArea structureArea, unitArea;
	
	public StatusViewport(Player player, int width, int height) {
		super(player, width, height);
		this.width = width;
		this.height = height;
		
		structureArea = new JTextArea();
		unitArea = new JTextArea();
		
		structureArea.setEditable(false);
		unitArea.setEditable(false);
		
		displayView();
	}

	public void displayAllStatuses(){
		
		
	}
	
	private void displayUnitStatus(Unit unit){
		
	}
	
	private void displayStructureStatus(Structure structure){
		
	}

	public void updateView() {
		
	}
	
	public void displayView() {
		
		FixedPanel panelA= new FixedPanel(width/2-20, height);
		panelA.setLayout(new BoxLayout(panelA,BoxLayout.Y_AXIS));
		panelA.add(new JLabel("Structures"));
		panelA.add(new JScrollPane(structureArea));
		
		
		
		FixedPanel panelB= new FixedPanel(width/2-20, height);
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
		
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		//this.add(Box.createVerticalGlue());
		JLabel title = new JLabel("Status ViewPort");
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		this.add(title);
		this.add(panelAB);	
	}
}

