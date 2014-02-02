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
package easy141;

import java.util.Scanner;

/**
 * A class to solve /r/dailyprogammer challenge Easy #141
 * http://www.reddit.com/r
 * /dailyprogrammer/comments/1qwkdz/111113_challenge_141_easy_checksums/
 * 
 * Short description: Create a program to calculate checksums using the
 * Fletcher16 algorithm.
 * 
 * @author Andreas Holley
 * 
 */
public class Fletcher16 {

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			System.out.println("Enter the number of lines, followed by the input:");
			int numLines = s.nextInt();
			s.nextLine();
			short[] checksums = new short[numLines];
			for (int i = 0; i < numLines; ++i) {
				checksums[i] = checksum(s.nextLine());
			}
			for (int i = 0; i < numLines; ++i) {
				System.out.println((i + 1) + " " + Integer.toHexString(checksums[i] & 0xffff).toUpperCase());
			}
		}
	}

	public static short checksum(String line) {
		byte[] bytes = line.getBytes();
		short sum1 = 0;
		short sum2 = 0;
		for (int i = 0; i < bytes.length; ++i) {
			sum1 = (short) ((sum1 + bytes[i]) % 255);
			sum2 = (short) ((sum2 + sum1) % 255);

		}
		return (short) ((sum2 << 8) | sum1);
	}

}
