package edu.bsu.cs222;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InstructionPanel extends JPanel {

	private static final long serialVersionUID = 2060516615231529484L;
	private GridBagConstraints constraints;
	private URL imageLocation;
	private Image zoomingHelperImage;
	private JLabel helperLabel;
	private JLabel imageHelperLabel;

	public InstructionPanel() {
		super(new GridBagLayout());
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(5, 5, 5, 5);
		createZoomInHelper();
		createZoomOutHelper();

	}

	private void createZoomOutHelper() {
		createZoomOutHelperText();
		createZoomOutHelperLabel();
	}

	private void createZoomOutHelperLabel() {
		getImage("touchPad5");
		configureImageHelperLabel();
		constraints.gridx = 1;
		constraints.gridy = 2;
		add(imageHelperLabel, constraints);
	}

	private void getImage(String description) {
		imageLocation = this.getClass().getResource(
				"images/" + description + ".png");
		zoomingHelperImage = new ImageIcon((imageLocation)).getImage();
	}

	private void createZoomOutHelperText() {
		helperLabel = new JLabel(
				"<html><i>To zoom out: place two fingers on <br> the touchpad and pull them towards<br> each other</i></html>");
		constraints.gridx = 1;
		constraints.gridy = 1;
		add(helperLabel, constraints);
	}

	private void createZoomInHelper() {
		createZoomInHelperText();
		createZoomInHelperLabel();
	}

	private void createZoomInHelperLabel() {
		getImage("touchPad4");
		configureImageHelperLabel();
		constraints.gridx = -1;
		constraints.gridy = 2;
		add(imageHelperLabel, constraints);
	}

	private void configureImageHelperLabel() {
		imageHelperLabel = new JLabel(new ImageIcon(zoomingHelperImage));
		imageHelperLabel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,
				Color.BLACK));
	}

	private void createZoomInHelperText() {
		helperLabel = new JLabel(
				"<html><i>To zoom in: place two fingers on <br> the touchpad and push them away <br> from each other</i></html>");
		constraints.gridx = -1;
		constraints.gridy = 1;
		add(helperLabel, constraints);
	}
}
