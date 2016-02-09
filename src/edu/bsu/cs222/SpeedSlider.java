package edu.bsu.cs222;

import javax.swing.JSlider;

public class SpeedSlider extends JSlider {
	private static final long serialVersionUID = 8998592156308019318L;
	private static final int MINIMANAL_DAY_INCREMENT_SPEED = -80000;
	private static final int MAXIMUM_DAY_INCREMENT_SPEED = 80000;

	public SpeedSlider() {
		super(MINIMANAL_DAY_INCREMENT_SPEED, MAXIMUM_DAY_INCREMENT_SPEED);
		this.setValue(0);
		this.setOpaque(false);
		this.setMinorTickSpacing(5);
		this.setPaintLabels(true);
		this.setBorder(null);
	}
}
