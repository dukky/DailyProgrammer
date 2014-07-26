package easy166b;

public class Planet {
	
	public final static double G = 6.67 * Math.pow(10, -11);
	
	private String name;
	private double mass;

	private double radius;
	
	public Planet(String name, double radius, double density) {
		this.name = name;
		this.radius = radius;
		this.mass = calculateMass(radius, density);
	}

	private static double calculateMass(double radius, double density) {
		return 4.0/3.0 * Math.PI * Math.pow(radius, 3) * density;
	}
	
	public double getForceInfoAtSurface(double otherMass) {
		return getForceInfo(otherMass, this.radius);
	}
	
	public double getForceInfo(double otherMass, double distance) {
		return G * ((mass * otherMass)/Math.pow(distance, 2));
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	
	
}
