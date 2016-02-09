package edu.bsu.cs222;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
 
public class FunctionalFrame extends JInternalFrame {

	private static final long serialVersionUID = -7444691075013965405L;
	private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	private FunctionalPanel panel;
    public FunctionalFrame() {
    	super("Functional Frame", true, false,false);
    	((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
    	setVisible(true);
    	setBackground(new Color(0,0,0,0));
    	setResizable(false);
        setBorder(null);
    	setBounds(screen.width-250, 100,200,500);
    	panel = new FunctionalPanel();
        setContentPane(panel);
    }
    

	public void addSpeedSlider(SpeedSlider slider){
    	panel.add(slider);
    }
    
    public void addDateTextField(JTextField textField){
    	panel.add(textField);
    }


	public void addButton(JButton button) {
		panel.add(button);
	}
	
	public void addJLabel(JLabel label){
		panel.add(label);
	}


	public void addDateTimeSpinner(JSpinner dateTimeSpinner) {
		panel.add(dateTimeSpinner);
	}
}