package easy171;

import java.util.Scanner;

/**
 * Class to convert an image represented in hex format to an acsii art image.
 * Done for http://www.reddit.com/r/dailyprogrammer/comments/2ao99p/7142014_challenge_171_easy_hex_to_8x8_bitmap/
 * 
 * @author Andreas
 *
 */
public class HexToAscii {
	
	public static void main(String[] args) {
		
		try(Scanner s = new Scanner(System.in)) {
			
			while(true) {
				String image = s.nextLine();
				for (String line : image.split(" ")) {
					System.out.println(String.format("%8s", Integer.toBinaryString(Integer.parseInt(line, 16))).replace('0', ' ').replace('1', 'x'));
				}
			}
		
		}
	}	
}
