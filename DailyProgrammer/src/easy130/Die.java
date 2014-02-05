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

import java.util.Random;

/**
 * A class to represent a die.
 * @author Andreas
 *
 */
public class Die {
	private int sides;
	private Random rand;
	
	/**
	 * Construct a die.
	 * @param sides the number of sides the die has.
	 */
	public Die(int sides) {
		this.sides = sides;
		this.rand = new Random();
	}
	
	/**
	 * Construct a die with a specified seed, allowing for deterministic behaviour.
	 * @param sides the number of sides the die has.
	 * @param seed the seed to use.
	 */
	public Die(int sides, long seed) {
		this.sides = sides;
		this.rand = new Random(seed);
	}
	
	/**
	 * Roll the die once.
	 * @return the number rolled.
	 */
	public int roll() {
		return rand.nextInt(sides) + 1;
	}
	
	/**
	 * Roll the die <code>times</code> times.
	 * @param times the number of times to roll the die.
	 * @return an int[] with length times containing all the rolls.
	 */
	public int[] rollMany(int times) {
		int[] rolls = new int[times];
		for(int i = 0; i < rolls.length; i++) {
			rolls[i] = roll();
		}
		return rolls;
	}
	
}
