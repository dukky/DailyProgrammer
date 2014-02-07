/*******************************************************************************
 * Copyright 2014 Andreas Holley
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package easy130;

import java.util.Scanner;

/**
 * A class to solve /r/dailyprogrammer challenge easy130
 * http://www.reddit.com/r/
 * dailyprogrammer/comments/1givnn/061713_challenge_130_easy_roll_the_dies/
 * 
 * Short description: Create a program to roll dies given Dice Notation
 * 
 * @author Andreas Holley
 * 
 */
public class Easy130 {
	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			while (true) {
				System.out.println("Enter the size of the die and the number of times you want to roll in the format '2d20':");
				String input = s.nextLine();

				if (input.equals("q")) {
					System.exit(0);
				}

				String[] splitInput = input.split("d");
				int times = Integer.parseInt(splitInput[0]);
				int size = Integer.parseInt(splitInput[1]);
				Die die = new Die(size);
				int[] rolls = die.rollMany(times);
				for (int i : rolls) {
					System.out.print(i + " ");
				}
				System.out.println("\n");
			}
		}
	}
}
