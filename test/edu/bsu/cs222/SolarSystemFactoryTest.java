package edu.bsu.cs222;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.bsu.cs222.SolarSystemFactory;

public class SolarSystemFactoryTest {
	SolarSystemFactory solarSystem;
	@Before
	public void setup() {
		solarSystem = SolarSystemFactory
				.centralLocationX(10).andCentralLocationY(10);
	}

	@Test
	public void testSize() {
		assertEquals(9, solarSystem.makeSolarSystem().size());
	}

}
