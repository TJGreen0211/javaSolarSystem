package edu.bsu.cs222;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BottomPanel extends TransparentPanel {
	public static BottomPanelBuilder withMultipleFramesContainer(
			MultipleFramesContainer multipleFramesContainer) {
		return new BottomPanelBuilder(multipleFramesContainer);
	}

	public static final class BottomPanelBuilder {
		private MultipleFramesContainer multipleFramesContainer;
		private SolarSystemFactory solarSystemFactory;

		private BottomPanelBuilder(
				MultipleFramesContainer multipleFramesContainer) {
			this.multipleFramesContainer = multipleFramesContainer;
		}

		public BottomPanel andSolarSystemFactory(
				SolarSystemFactory solarSystemFactory) {
			this.solarSystemFactory = solarSystemFactory;
			return new BottomPanel(this);
		}

	}

	private static final long serialVersionUID = 4047666995255596401L;
	private ImageIcon planetImageIcon;
	private Image planetImage;
	private JButton[] imageButton = new JButton[100];
	private MultipleFramesContainer multipleFramesContainer;
	private StarSystem starSystem;
	private URL fileURL;
	private Planet planet;
	private int buttonIndex;

	public BottomPanel(BottomPanelBuilder builder) {
		super();
		this.multipleFramesContainer = builder.multipleFramesContainer;
		starSystem = builder.solarSystemFactory.makeSolarSystem();
		buttonIndex = 0;
		this.setBorder(null);
		this.setVisible(true);
		addPlanetToPanel();
	}

	private void addPlanetToPanel() {
		Iterator<Planet> iterator = starSystem.planetIterator();
		while (iterator.hasNext()) {
			nextPlanet(iterator);
			setURL();
			putPlanetImageToButton();
			setupButton(imageButton[buttonIndex]);
			add(imageButton[buttonIndex]);
			increaseIndex();
		}
	}

	private void increaseIndex() {
		buttonIndex++;
	}

	private void putPlanetImageToButton() {
		planetImageIcon = new ImageIcon(fileURL);
		planetImage = planetImageIcon.getImage().getScaledInstance(65, 65,
				java.awt.Image.SCALE_SMOOTH);
		imageButton[buttonIndex] = new JButton(planet.planetName()
				.toUpperCase(), new ImageIcon(planetImage));
		imageButton[buttonIndex].addActionListener(PlanetActionListener
				.planetInformation(planet.toString())
				.andMultipleFramesContainer(multipleFramesContainer));
	}

	private void setURL() {
		fileURL = this.getClass().getResource(
				"images/" + planet.planetName() + ".png");
	}

	private void nextPlanet(Iterator<Planet> iterator) {
		planet = iterator.next();

	}

	private void setupButton(JButton button) {
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setForeground(Color.white);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.TOP);
		button.setFont(new Font("Sans Serif", Font.PLAIN, 12));
	}

	@Override
	public void paintComponent(Graphics g) {
		paintPanel(g);
	}
}
