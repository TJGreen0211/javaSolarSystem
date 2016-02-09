package edu.bsu.cs222;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.junit.Before;
import org.junit.Test;

import edu.bsu.cs222.Planet;

public class PlanetTest {
	private static final double EPSILON = 0.00001;
	private static final DateTime INITIAL_DATE = new DateTime(2000, 1, 1, 0, 0, 0);
	private DateTime date;
	private Planet mercury;
	private Planet earth;
	private double actual;
	private double expected;
	private DateTime changedDate;
	private Period period;

	@Before
	public void setup() {
		mercury = Planet.withSemiMajorAxis(950).andDiameter(24)
				.andInitialAngle(290).andOrbitalPeriod(87.89)
				.andSemiMinorAxis(927.704).createPlanet();

		earth = Planet.withSemiMajorAxis(1400).andDiameter(77)
				.andInitialAngle(135).andOrbitalPeriod(365)
				.andSemiMinorAxis(1399).createPlanet();
	}

	@Test
	public void testMercuryRadians_initialPosition() {
		actual = mercury.putPlanetOn(INITIAL_DATE);
		expected = Math.toRadians(290);
		assertEquals(expected, actual, EPSILON);
	}

	@Test
	public void testMercuryRadians_aSecondLater() {
		date = new DateTime(2000, 1, 1, 0, 0, 1);
		assertTrue(mercury.putPlanetOn(INITIAL_DATE) < mercury.putPlanetOn(date));
	}

	@Test
	public void testMercuryRaidans_aSecondBefore() {
		date = new DateTime(1999, 12, 31, 23, 59, 59);
		period = Period.seconds(1);
		changedDate = INITIAL_DATE.minus(period);
		assertEquals(mercury.putPlanetOn(changedDate),
				mercury.putPlanetOn(date), EPSILON);
	}

	@Test
	public void testEarthRadians_initialPosition() {
		actual = earth.putPlanetOn(INITIAL_DATE);
		expected = Math.toRadians(135);
		assertEquals(expected, actual, EPSILON);
	}

	@Test
	public void testEarthRadians_aYearLater() {
		date = new DateTime(2000, 12, 31, 00, 00, 00);
		assertEquals(earth.putPlanetOn(INITIAL_DATE), earth.putPlanetOn(date), EPSILON);
	}

	@Test
	public void testEarthRadians_twoYearsLater() {
		date = new DateTime(2001, 12, 31, 00, 00, 00);
		assertEquals(earth.putPlanetOn(INITIAL_DATE), earth.putPlanetOn(date), EPSILON);
	}

	@Test
	public void testEarthRadians_onePointTwoYearLater() {
		period = Period.days(73);
		changedDate = INITIAL_DATE.plus(period);
		date = new DateTime(2000, 12, 31, 0, 0, 0);
		date = date.plus(period);
		assertEquals(earth.putPlanetOn(changedDate), earth.putPlanetOn(date), EPSILON);
	}

	@Test
	public void testEarthRadians_onePointTwoYearBefore() {
		period = Period.days(73);
		changedDate = INITIAL_DATE.minus(period);
		date = new DateTime(1999, 1, 1, 0, 0, 0);
		date = date.minus(period);
		assertEquals(earth.putPlanetOn(changedDate), earth.putPlanetOn(date), EPSILON);
	}

	@Test
	public void testEarthRadians_twoYearsBefore() {
		period = Period.days(730);
		changedDate = INITIAL_DATE.minus(period);
		date = new DateTime(1998, 1, 1, 0, 0, 0);
		assertEquals(earth.putPlanetOn(changedDate), earth.putPlanetOn(date), EPSILON);
	}

	@Test
	public void testEarthXCoordinate_aSecondLater() {
		period = Period.seconds(1);
		date = new DateTime(2000, 1, 1, 0, 0, 1);
		earth.putPlanetOn(INITIAL_DATE);
		double before = Math.abs(earth.calculateXAtCentralLocation(500));
		earth.putPlanetOn(date);
		double later = Math.abs(earth.calculateXAtCentralLocation(500));
		assertTrue(before < later);
	}

}
