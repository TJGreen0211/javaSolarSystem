package edu.bsu.cs222;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.bsu.cs222.Planet;
import edu.bsu.cs222.StarSystem;
import edu.bsu.cs222.Sun;

public class StarSystemTest {

	private StarSystem starSystem;
	private Sun sun;
	private Planet planet;

	@Before
	public void setup() {
		sun = Sun.withSunX(800).sunY(400).andSunDiameter(400);
		planet = Planet.withSemiMajorAxis(800).andDiameter(100)
				.andInitialAngle(135).andSemiMinorAxis(799)
				.andOrbitalPeriod(89).createPlanet();
	}

	@Test
	public void testStarSystem_true_initialStarSystem() {
		starSystem = StarSystem.creatStarSystem();
		assertTrue(starSystem.isEmpty());
	}

	@Test
	public void testStarSystem_false_addSun() {
		starSystem = StarSystem.creatStarSystem();
		starSystem.addSun(sun);
		assertFalse(starSystem.isEmpty());
	}

	@Test
	public void testStarSystem_false_addPlanet() {
		starSystem = StarSystem.creatStarSystem();
		starSystem.addPlanet(planet);
		assertFalse(starSystem.isEmpty());
	}

}
