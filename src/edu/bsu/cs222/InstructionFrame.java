package edu.bsu.cs222;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class InstructionFrame extends JFrame {

	private static final long serialVersionUID = -3195926367321232500L;

	public InstructionFrame() {
		JPanel panel = new InstructionPanel();
		this.getContentPane().add(panel, BorderLayout.CENTER);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
