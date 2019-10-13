// Code to solve UVA Online Judge problem #10878

import java.util.Scanner;

public class uva_10878 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// Continue until no more tape is being fed
		while (sc.hasNextLine()) {
			
			String str = sc.nextLine();
			String bin = "";
			
			// Skipping the beginning and end parts of the tape
			if (str.charAt(0) == '-') {
				continue;
			}
			
			char[] split = str.toCharArray();
			
			for (int i = 0; i < split.length; i++) {
				
				// Spaces -> 0's, o's -> 1's; all else ignored
				if (split[i] == ' ') {
					bin += "0";
				} else if (split[i] == 'o') {
					bin += "1";
				}
				
			}
			if (bin.length() != 0) {
				// Parses the value of the binary string
				int value = Integer.parseInt(bin, 2);
				
				// Looks up character equivalent of binary value
				System.out.print((char)value);
			}
			
		}
		
		sc.close();
		
	}

}
