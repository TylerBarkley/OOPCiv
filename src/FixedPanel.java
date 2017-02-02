import java.awt.Dimension;

import javax.swing.JPanel;

public class FixedPanel extends JPanel{
	private int width;
	private int height;
	public FixedPanel(int width, int height){
		this.width=width;
		this.height=height;
	}
	
	public Dimension getMinimumSize() {
		return getPreferredSize();
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(width,height);
	}
	
	public Dimension getMaximumSize() {
		return getPreferredSize();
	}
}
