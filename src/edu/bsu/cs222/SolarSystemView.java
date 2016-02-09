package edu.bsu.cs222;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.net.URL;
import java.util.Iterator;

import javax.swing.ImageIcon;

import org.joda.time.DateTime;

public class SolarSystemView {

	private StarSystem solarSystem;
	private Sun sun;
	private Planet planet;
	private URL imageLocation;
	private Image planetImage;
	private Iterator<Planet> planetIterator;

	public SolarSystemView(SolarSystemFactory solarSystemFactory) {
		this.solarSystem = solarSystemFactory.makeSolarSystem();
	}

	public void drawPlanets(Graphics2D g2d) {
		initializePlanetIterator();
		while (hasNextElement()) {
			toNextPlanetInIterator();
			drawPlanetImage(g2d);
		}
	}

	private boolean hasNextElement() {
		return planetIterator.hasNext();
	}

	private void initializePlanetIterator() {
		planetIterator = solarSystem.planetIterator();
	}

	private void drawPlanetImage(Graphics2D g2d) {
		double x = (planet.calculateXAtCentralLocation(sun.sunX())
				+ sun.sunDiameter() / 2 - planet.planetDiameter() / 2);
		double y = (planet.calculateYAtCentralLocation(sun.sunY())
				+ sun.sunDiameter() / 2 - planet.planetDiameter() / 2);
		g2d.drawImage(getPlanetImage(planet.planetName()), (int) x, (int) y,
				(int) planet.planetDiameter(), (int) planet.planetDiameter(),
				null);
	}

	private void toNextPlanetInIterator() {
		planet = planetIterator.next();
	}

	private Image getPlanetImage(String planetName) {
		getImage(planetName);
		return planetImage;
	}

	private void getImage(String planetName) {
		imageLocation = this.getClass().getResource(
				"images/" + planetName + ".png");
		planetImage = new ImageIcon((imageLocation)).getImage();
	}

	public void drawSun(Graphics2D g2d) {
		Iterator<Sun> iterator = solarSystem.sunIterator();
		while (iterator.hasNext()) {
			sun = iterator.next();
			g2d.drawImage(getSunImage(), (int) (sun.sunX()),
					(int) (sun.sunY()), (int) sun.sunDiameter(),
					(int) sun.sunDiameter(), null);
		}
	}

	public void inputDateToMovePlanet(DateTime dateTime) {
		planetIterator = solarSystem.planetIterator();
		while (planetIterator.hasNext()) {
			planetIterator.next().putPlanetOn(dateTime);
		}
	}

	private Image getSunImage() {
		imageLocation = this.getClass().getResource("images/sun.png");
		Image sunImage = new ImageIcon((imageLocation)).getImage();
		return sunImage;
	}

	public void drawPlanetPaths(Graphics2D g2d) {
		initializePlanetIterator();
		while (hasNextElement()) {
			toNextPlanetInIterator();
			showPlanetPathOnScreen(g2d);
		}

	}

	private void showPlanetPathOnScreen(Graphics2D g2d) {
		g2d.draw(new Ellipse2D.Double(sun.sunX() + sun.sunDiameter() / 2
				- planet.semiMajorAxis(), sun.sunY() + sun.sunDiameter() / 2
				- planet.semiMinorAxis(), 2 * planet.semiMajorAxis(),
				2 * planet.semiMinorAxis()));
	}
}
