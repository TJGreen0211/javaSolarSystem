package edu.bsu.cs222;

public class SolarSystemFactory {
	public static SolarSystemBuilder centralLocationX(double centralLocationX) {
		return new SolarSystemBuilder(centralLocationX);
	}

	public static final class SolarSystemBuilder {
		private double centralLocationX;
		private double centralLocationY;

		private SolarSystemBuilder(double centralLocationX) {
			this.centralLocationX = centralLocationX;
		}

		public SolarSystemFactory andCentralLocationY(double centralLocationY) {
			this.centralLocationY = centralLocationY;
			return new SolarSystemFactory(this);
		}
	}

	private double centralLocationX;
	private double centralLocationY;
	private StarSystem starSystem;

	private SolarSystemFactory(SolarSystemBuilder builder) {
		this.centralLocationX = builder.centralLocationX;
		this.centralLocationY = builder.centralLocationY;
		starSystem = StarSystem.creatStarSystem();
	}

	public StarSystem makeSolarSystem() {
		addSun();
		addMercury();
		addVenus();
		addEarth();
		addMars();
		addJupiter();
		addSaturn();
		addUranus();
		addNeptune();
		return starSystem;
	}

	private void addNeptune() {
		starSystem.addPlanet(Planet
				.withSemiMajorAxis(15950)
				.andSemiMinorAxis(15949.24)
				.andInitialAngle(60)
				.andOrbitalPeriod(60152)
				.andDiameter(243)
				.andPlanetName("neptune")
				.andPlanetDescription(
						"Mass: 102,410,000,000,000,000 billion kg (17.15x Earth)\n"
								+ "Equatorial Diameter: 49,528 km\n"
								+ "Polar Diameter: 48,682 km\n"
								+ "Equatorial Circumference: 155,600 km\n"
								+ "Known Moons: 14\n"
								+ "Notable Moons: Triton more info\n"
								+ "Known Rings: 5\n"
								+ "Orbit Distance: 4,498,396,441 km (30.10 AU)\n"
								+ "Orbit Period: 60,190.03 Earth days (164.79 Earth years)\n"
								+ "Surface Temperature: -201 °C\n"
								+ "Discover Date: September 23rd 1846")
				.createPlanet());
	}

	private void addUranus() {
		starSystem
				.addPlanet(Planet
						.withSemiMajorAxis(9510)
						.andSemiMinorAxis(9499.8)
						.andInitialAngle(75)
						.andOrbitalPeriod(30660)
						.andDiameter(180)
						.andPlanetName("uranus")
						.andPlanetDescription(
								"Mass: 86,810,300,000,000,000 billion kg (14.536 x Earth)"
										+ "\nEquatorial Diameter: 51,118 km"
										+ "\nPolar Diameter: 49,946 km"
										+ "\nEquatorial Circumference: 159,354 km"
										+ "\nKnown Moons: 27"
										+ "\nNotable Moons: Oberon, Titania, Miranda, Ariel & Umbriel"
										+ "\nKnown Rings: 13"
										+ "\nOrbit Distance: 2,870,658,186 km (19.22 AU)"
										+ "\nOrbit Period: 30,687.15 Earth days (84.02 Earth years)"
										+ "\nSurface Temperature: -197 °C"
										+ "\nFirst Record:March 13th 1781")
						.createPlanet());
	}

	private void addSaturn() {
		starSystem
				.addPlanet(Planet
						.withSemiMajorAxis(5960)
						.andSemiMinorAxis(5681)
						.andInitialAngle(150)
						.andOrbitalPeriod(10752.9)
						.andDiameter(270)
						.andPlanetName("saturn")
						.andPlanetDescription(
								"Mass: 568,319,000,000,000,000 billion kg (95.16 x Earth)\n"
										+ "Equatorial Diameter: 120,536 km\n"
										+ "Polar Diameter: 108,728 km\n"
										+ "Equatorial Circumference: 365,882 km\n"
										+ "Known Moons: 62\n"
										+ "Notable Moons: Titan, Rhea & Enceladus\n"
										+ "Know Rings 30+ (7 Groups)"
										+ "Orbit Distance: 1,426,666,422 km (9.58 AU)\n"
										+ "Orbit Period: 10,755.70 Earth days (29.45 Earth years)\n"
										+ "Surface Temperature: -139 °C\n"
										+ "First Record: 8th century BC")
						.createPlanet());
	}

	private void addJupiter() {
		starSystem
				.addPlanet(Planet
						.withSemiMajorAxis(3400)
						.andSemiMinorAxis(3396.031)
						.andInitialAngle(145)
						.andOrbitalPeriod(4328.9)
						.andDiameter(360)
						.andPlanetName("jupiter")
						.andPlanetDescription(
								"Mass: 1,898,130,000,000,000,000 billion kg (317.83 x Earth)\n"
										+ "Equatorial Diameter: 142,984 km\n"
										+ "Polar Diameter: 133,709 km\n"
										+ "Equatorial Circumference: 439,264 km\n"
										+ "Known Moons: 67\n"
										+ "Notable Moons: Io, Europa, Ganymede, & Callisto\n"
										+ "Known Rings: 4\n"
										+ "Orbit Distance: 778,340,821 km (5.20 AU)\n"
										+ "Orbit Period: 4,332.82 Earth days (11.86 Earth years)\n"
										+ "Surface Temperature: -108°C"
										+ "First Record: 7th or 8th century BC")
						.createPlanet());
	}

	private void addMars() {
		starSystem
				.addPlanet(Planet
						.withSemiMajorAxis(1660)
						.andSemiMinorAxis(1652)
						.andInitialAngle(100)
						.andOrbitalPeriod(686.565)
						.andDiameter(39)
						.andPlanetName("mars")
						.andPlanetDescription(
								"Mass: 641,693,000,000,000 billion kg (0.107 x Earth)\n"
										+ "Equatorial Diameter: 6,805\n"
										+ "Polar Diameter: 6,755\n"
										+ "Equatorial Circumference: 21,297 km\n"
										+ "Known Moons: 2\n"
										+ "Notable Moons: Phobos & Deimos\n"
										+ "Orbit Distance: 227,943,824 km (1.38 AU)\n"
										+ "Orbit Period: 686.98 Earth days (1.88 Earth years)\n"
										+ "Surface Temperature: -87 to -5 °C\n"
										+ "First Record: 2nd millennium BC")
						.createPlanet());
	}

	private void addEarth() {
		starSystem.addPlanet(Planet
				.withSemiMajorAxis(1400)
				.andSemiMinorAxis(1399)
				.andInitialAngle(200)
				.andOrbitalPeriod(365)
				.andDiameter(77)
				.andPlanetName("earth")
				.andPlanetDescription(
						"Mass: 5,972,190,000,000,000 billion kg\n"
								+ "Equatorial Diameter: 12,756 km\n"
								+ "Polar Diameter: 12,714 km\n"
								+ "Equatorial Circumference: 40,030 km\n"
								+ "Known Moons: the Moon\n"
								+ "Notable Moons: none\n"
								+ "Orbit Distance: 149,598,262 km (1 AU)\n"
								+ "Orbit Period: 365.26 Earth days\n"
								+ "Surface Temperature: -88 to 58°C\n")
				.createPlanet());
	}

	private void addVenus() {
		starSystem.addPlanet(Planet
				.withSemiMajorAxis(1250)
				.andSemiMinorAxis(1249)
				.andInitialAngle(-88)
				.andOrbitalPeriod(224.7)
				.andDiameter(75)
				.andPlanetName("venus")
				.andPlanetDescription(
						"Mass: 4,867,320,000,000,000 billion kg (0.815 x Earth)\n"
								+ "Equatorial Diameter: 12,104 km\n"
								+ "Polar Diameter: 12,104 km\n"
								+ "Equatorial Circumference: 38,025 km\n"
								+ "Known Moons: none\n"
								+ "Notable Moons: none\n"
								+ "Orbit Distance: 108,209,475 km (0.73 AU)\n"
								+ "Orbit Period: 224.70 Earth days\n"
								+ "Surface Temperature: 462 °C\n"
								+ "First Record: 17th century BC")
				.createPlanet());
	}

	private void addMercury() {
		starSystem.addPlanet(Planet
				.withSemiMajorAxis(950)
				.andSemiMinorAxis(927.704)
				.andInitialAngle(-2)
				.andOrbitalPeriod(87.97)
				.andDiameter(24)
				.andPlanetName("mercury")
				.andPlanetDescription(
						"Mass: 330,104,000,000,000 billion kg (0.055 x Earth)"
								+ "\nEquatorial Diameter: 4,879"
								+ "\nPolar Diameter: 4,879"
								+ "\nEquatorial Circumference: 15,329 km"
								+ "\nKnown Moons: none"
								+ "\nNotable Moons: none"
								+ "\nOrbit Distance: 57,909,227 km (0.39 AU)"
								+ "\nOrbit Period: 87.97 Earth days"
								+ "\nSurface Temperature: -173 to 427°C"
								+ "\nFirst Record: 14th century BC")
				.createPlanet());
	}

	private void addSun() {
		starSystem.addSun(Sun.withSunX(centralLocationX).sunY(centralLocationY)
				.andSunDiameter(1200));
	}

}
