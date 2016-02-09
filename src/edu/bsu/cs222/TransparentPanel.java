package edu.bsu.cs222;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.JPanel;

public abstract class TransparentPanel extends JPanel {

	private static final long serialVersionUID = 1781161871739725336L;

	protected void paintPanel(Graphics g) {
		final int R = 99;
		final int G = 184;
		final int B = 255;
		Paint p = new GradientPaint(0.0f, 0.0f, new Color(R, G, B, 150), 0.0f,
				getHeight(), new Color(R, G, B, 10), true);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(p);
		g2d.fillRect(0, 0, getWidth(), getHeight());
	}

}
