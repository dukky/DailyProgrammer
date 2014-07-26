package easy166b;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double mass = s.nextDouble();
		int numPlanets = s.nextInt();
		List<Planet> planets = new ArrayList<>(numPlanets);
		s.nextLine();
		for(int i = 0; i < numPlanets; ++i) {
			String line = s.nextLine();
			String[] split = line.split(",");
			planets.add(new Planet(split[0], Double.parseDouble(split[1]), Double.parseDouble(split[2])));
		}
		
		System.out.println();
		
		for (Planet planet : planets) {
			System.out.format("%s: %.3f%n", planet, planet.getForceInfoAtSurface(mass));
		}
		
		s.close();
		
	}
}
