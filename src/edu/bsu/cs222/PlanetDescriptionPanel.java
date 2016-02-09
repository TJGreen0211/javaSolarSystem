package edu.bsu.cs222;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JTextArea;

public class PlanetDescriptionPanel extends TransparentPanel {
	private static final long serialVersionUID = 4047666995255596401L;
	private JTextArea planetInformationArea;

	public PlanetDescriptionPanel(String planetInformation) {
		super();
		planetInformationArea = new JTextArea(20, 20);
		planetInformationArea.setFont(planetInformationArea.getFont()
				.deriveFont(16.0f));
		planetInformationArea.setOpaque(false);
		planetInformationArea.setForeground(Color.WHITE);
		planetInformationArea.setText(planetInformation);
		planetInformationArea.setEditable(false);
		add(planetInformationArea);
	}

	@Override
	public void paintComponent(Graphics g) {
		paintPanel(g);
	}
}
