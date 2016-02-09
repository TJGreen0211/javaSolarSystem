package edu.bsu.cs222;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JInternalFrame;

public class BottomFrame extends JInternalFrame {
	private static final long serialVersionUID = -3054535526463109247L;

	public static PlanetInformationFrameBuilder multipleFramesContainer(
			MultipleFramesContainer multipleFramesContainer) {
		return new PlanetInformationFrameBuilder(multipleFramesContainer);
	}

	public static final class PlanetInformationFrameBuilder {
		private MultipleFramesContainer multipleFramesContainer;
		private SolarSystemFactory solarSystemFactory;

		private PlanetInformationFrameBuilder(
				MultipleFramesContainer multipleFramesContainer) {
			this.multipleFramesContainer = multipleFramesContainer;
		}

		public BottomFrame andPlanetInformation(
				SolarSystemFactory solarSystemFactory) {
			this.solarSystemFactory = solarSystemFactory;
			return new BottomFrame(this);
		}

	}

	private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	private BottomPanel planetsInformationPanel;

	public BottomFrame(PlanetInformationFrameBuilder builder) {
		super("Planets' Information", false, false, false);
		((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI())
				.setNorthPane(null);
		planetsInformationPanel = BottomPanel.withMultipleFramesContainer(
				builder.multipleFramesContainer).andSolarSystemFactory(
				builder.solarSystemFactory);
		GraphicsEnvironment env = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		env.getMaximumWindowBounds().getHeight();
		this.setBorder(null);
		this.setContentPane(planetsInformationPanel);
		this.setBounds(0, (int) env.getMaximumWindowBounds().getHeight() - 125,
				(int) screen.getWidth(), 125);
		this.setVisible(true);
	}
}
