package easy163;

import easy130.Die;

public class DiceDistribution {
	public static void main(String[] args) {
		Die die = new Die(6);
		
		int[][] results = new int[6][];
		
		for(int i = 0; i<6; i++) {
			results[i] = die.rollMany((int)Math.pow(10, i + 1));
		}
		
		System.out.println("# of Rolls 1s     2s     3s     4s     5s     6s");
		System.out.println("===================================================");
		
		
		for (int[] rolls : results) {
			System.out.println(processRolls(rolls));
		}
	}

	private static String processRolls(int[] rolls) {
		int[] count = new int[6];
		for (int i : rolls) {
			count[i-1]++;
		}
		double[] percentages = new double[6];
		for(int i = 0; i < 6; ++i) {
			percentages[i] = count[i]/(float)rolls.length;
		}
		
		String s = "" + rolls.length;
		int spaces = 11-s.length();
		for(int i = 0; i<spaces; ++i) {
			s+=" ";
		}
		for (double d : percentages) {
			s += String.format("%05.2f%% ", d*100);
		}
		return s;
	}
}
