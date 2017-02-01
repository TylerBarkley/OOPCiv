import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.*;

public class StatusViewport extends Viewport{

	private int width, height;
	private JTextArea structureArea, unitArea;
	
	public StatusViewport(int height, int width) {
		super(height, width);
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

	@Override
	public void updateView() {
		// TODO Auto-generated method stub
		
	}
	
	public void displayView() {
		
		JPanel panelA = new JPanel() {
			public Dimension getMinimumSize() {
				return getPreferredSize();
			}
			
			public Dimension getPreferredSize() {
				return new Dimension(width/2 - 20 ,height);
			}
			
			public Dimension getMaximumSize() {
				return getPreferredSize();
			}
		};
		panelA.setLayout(new BoxLayout(panelA,BoxLayout.Y_AXIS));
		panelA.add(new JLabel("Structures"));
		panelA.add(new JScrollPane(structureArea));
		
		
		
		JPanel panelB = new JPanel() {
			public Dimension getMinimumSize() {
				return getPreferredSize();
			}
			
			public Dimension getPreferredSize() {
				return new Dimension(width/2 - 20,height);
			}
			
			public Dimension getMaximumSize() {
				return getPreferredSize();
			}
		};
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
	
	public static void main(String args[]) {
		JFrame frame = new JFrame();
		frame.setSize(600,600);
		frame.add(new StatusViewport(600,600));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

