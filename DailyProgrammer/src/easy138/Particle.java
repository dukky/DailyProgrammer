package easy138;

import java.util.Scanner;

/**
 * 
 * A class to solve /r/dailyprogrammer challenge Easy #138
 * http://www.reddit.com/r/dailyprogrammer/comments/1ml669/091713_challenge_138_easy_repulsionforce/
 * 
 * Short description: Create a program to calculate the repulsion force between two particles using
 * a simplified coulomb's law: Force = (Particle 1's mass x Particle 2's mass) / Distance^2
 * 
 * @author Andreas Holley
 *
 */
public class Particle {
	
	private double mass;
	private double xPos;
	private double yPos;
	
	public Particle(double mass, double xPos, double yPos) {
		super();
		this.mass = mass;
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public double calculateRepulsionForce(Particle p) {
		return  (this.getMass() * p.getMass()) / Math.pow(calculateDistance(p), 2);
	}
	
	public double calculateDistance(Particle p) {
		double deltaX = this.getxPos() - p.getxPos();
		double deltaY = this.getyPos() - p.getyPos();
		return Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public double getxPos() {
		return xPos;
	}

	public void setxPos(double xPos) {
		this.xPos = xPos;
	}

	public double getyPos() {
		return yPos;
	}

	public void setyPos(double yPos) {
		this.yPos = yPos;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Particle p1 = new Particle(s.nextDouble(), s.nextDouble(), s.nextDouble());
		s.nextLine();
		Particle p2 = new Particle(s.nextDouble(), s.nextDouble(), s.nextDouble());
		System.out.println(p1.calculateRepulsionForce(p2));
		s.close();
	}
	
	
}
