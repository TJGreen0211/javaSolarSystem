package edu.bsu.cs222;


public class Sun {
	public static SunBuilder withSunX(double sunX) {
		return new SunBuilder(sunX);
	}

	public static final class SunBuilder {
		private double sunX;
		private double sunY;
		private double sunDiameter;

		private SunBuilder(double sunX) {
			this.sunX = sunX;
		}

		public SunBuilder sunY(double sunY) {
			this.sunY = sunY;
			return this;
		}

		public Sun andSunDiameter(double sunDiameter) {
			this.sunDiameter = sunDiameter;
			return new Sun(this);
		}

	}

	private double sunX;
	private double sunY;
	private double sunDiameter;

	private Sun(SunBuilder builder) {
		this.sunX = builder.sunX - builder.sunDiameter/2;
		this.sunY = builder.sunY - builder.sunDiameter/2;
		this.sunDiameter = builder.sunDiameter;
	}

	public double sunDiameter(){
		return sunDiameter;
	}
	
	public double sunX(){
		return sunX;
	}
	
	public double sunY(){
		return sunY;
	}

}
