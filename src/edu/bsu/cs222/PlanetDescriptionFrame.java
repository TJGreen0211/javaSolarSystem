package edu.bsu.cs222;

import java.awt.Color;

import javax.swing.JInternalFrame;

public class PlanetDescriptionFrame extends JInternalFrame {
	private static final long serialVersionUID = 1206540272136951535L;

	public PlanetDescriptionFrame(String planetInformation) {
		super("Planet Description", true, true, true);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setResizable(false);
		setBounds(100, 100, 600, 400);
		PlanetDescriptionPanel description = new PlanetDescriptionPanel(planetInformation);
		setContentPane(description);
	}

}
