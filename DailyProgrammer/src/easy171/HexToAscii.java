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
		
		Scanner s = new Scanner(System.in);
		
		while(true) {
			String image = s.nextLine();
			for (String line : image.split(" ")) {
				line = Integer.toBinaryString(Integer.parseInt(line, 16));
				for(int i = 0; i < 8-line.length(); ++i) {
					System.out.print(" ");
				}
				for (char c : line.toCharArray()) {
					if(c == '1') System.out.print("x");
					else System.out.print(" ");
				}
				System.out.println();
			}
		}
	}
	
}
