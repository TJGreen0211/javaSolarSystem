package edu.bsu.cs222;

import org.joda.time.DateTime;
import org.joda.time.Duration;

public class Planet {
	public static PlanetBuilder withSemiMajorAxis(double semiMajorAxis) {
		return new PlanetBuilder(semiMajorAxis);
	}

	public static final class PlanetBuilder {
		private double semiMajorAxis;
		private double semiMinorAxis;
		private double diameter;
		private double initialAngle;
		private double orbitalPeriod;
		private String planetName;
		private String description;

		private PlanetBuilder(double semiMajorAxis) {
			this.semiMajorAxis = semiMajorAxis;
		}

		public PlanetBuilder andSemiMinorAxis(double semiMinorAxis) {
			this.semiMinorAxis = semiMinorAxis;
			return this;
		}

		public PlanetBuilder andDiameter(double diameter) {
			this.diameter = diameter;
			return this;
		}

		public PlanetBuilder andInitialAngle(double initialAngle) {
			this.initialAngle = initialAngle;
			return this;
		}

		public PlanetBuilder andOrbitalPeriod(double orbitalPeriod) {
			this.orbitalPeriod = orbitalPeriod;
			return this;
		}
		
		public PlanetBuilder andPlanetName(String planetName){
			this.planetName = planetName;
			return this;
		}
		
		public PlanetBuilder andPlanetDescription(String description){
			this.description = description;
			return this;
		}

		public Planet createPlanet() {
			return new Planet(this);
		}
	}

	private double semiMajorAxis;
	private double semiMinorAxis;
	private double diameter;
	private double initialRadians;
	private double orbitalPeriod;
	private double radians;
	private double planetX;
	private double planetY;
	private String planetName;
	private Duration duration;
	private String description;
	private  final static DateTime INITIAL_DATE = new DateTime(2000, 1, 1, 0, 0, 0);
	private final static double SECONDS_IN_A_DAY = 86400.0;

	private Planet(PlanetBuilder builder) {
		this.semiMajorAxis = builder.semiMajorAxis;
		this.semiMinorAxis = builder.semiMinorAxis;
		this.diameter = builder.diameter;
		this.initialRadians = Math.toRadians(builder.initialAngle);
		this.radians = this.initialRadians;
		this.orbitalPeriod = builder.orbitalPeriod;
		this.planetName = builder.planetName;
		this.description = builder.description;
	}

	public double putPlanetOn(DateTime dateTime) {
		initializeDuration(dateTime);
		return calculateRadians(dateTime);
	}
	
	public double planetDiameter(){
		return diameter;
	}

	public double calculateYAtCentralLocation(double centralLocationY) {
		planetY = centralLocationY + Math.sin(radians) * semiMinorAxis;
		return planetY;
	}

	public double calculateXAtCentralLocation(double centralLocationX) {
		planetX = centralLocationX + Math.cos(radians) * semiMajorAxis;
		return planetX;
	}

	private double calculateRadians(DateTime dateTime) {
		if (isInitialDate(dateTime)) {
			calculateRadiansOnInitialDate();
		} else {
			calculateRadiansNotOnInitialDate();
		}
		return radians;
	}

	private void calculateRadiansOnInitialDate() {
		radians = initialRadians;
	}

	private void calculateRadiansNotOnInitialDate() {
		double laps = ((duration.getStandardSeconds()) / (orbitalPeriod * SECONDS_IN_A_DAY));
		if (isMoreThanOrEqualOneLap(laps)) {
			radians = initialRadians + (2 * Math.PI * (laps - (long) laps));
		} else {
			radians = (2 * Math.PI * (double) (duration.getStandardSeconds() / SECONDS_IN_A_DAY))
					/ orbitalPeriod + initialRadians;
		}
	}

	private boolean isMoreThanOrEqualOneLap(double laps) {
		return laps > 1 || laps == 1 || laps < -1 || laps == -1;
	}

	private boolean isInitialDate(DateTime dateTime) {
		return duration.getStandardSeconds() == 0;
	}

	private void initializeDuration(DateTime dateTime) {
		duration = new Duration(INITIAL_DATE, dateTime);
	}

	public double semiMajorAxis() {
		return semiMajorAxis;
	}
	
	public double semiMinorAxis(){
		return semiMinorAxis;
	}
	
	public String planetName(){
		return planetName;
	}
	
	@Override
	public String toString(){
		return "Planet: "+ planetName +"\n\n"+description;
	}

}
