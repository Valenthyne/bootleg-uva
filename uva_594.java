// Code to solve UVA Online Judge problem #594

import java.util.Scanner;

public class uva_594 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNextInt()) {
			
			int num = sc.nextInt();
			// Converts the integer to binary and extends to 32-bits if necessary
			String bin = extend(Integer.toBinaryString(num));

			// Generate an array for the reversed-Endian binary string
			String[] arr = new String[4];
			
			int binIndex = 0;
			int arrIndex = 3;
			
			while (binIndex < bin.length()) {
				// Take the first substring and place it towards the end of the array
				// Effectively reversing the order of the strings
				arr[arrIndex] = bin.substring(binIndex, binIndex + 8);
				binIndex += 8;
				arrIndex--;
			}
			
			// Combine the array elements into a single string
			String binStr = arr[0] + arr[1] + arr[2] + arr[3];
			
			// Parse this binary string "unsigned" into a final value
			int value = Integer.parseUnsignedInt(binStr, 2);

			System.out.println(num + " converts to " + value);
			
		}
		
		sc.close();

	}
	
	// Method to extend binary string to 32-bits
	// Using 0's only due to unsigned parsing later
	public static String extend(String s) {
		int x = s.length();
		int rem = 32 - x;
		
		if (rem == 0)
			return s;
		
		String zeroes = "";
		
		while (rem > 0) {
			zeroes += "0";
			rem--;
		}
		
		return zeroes + s;

	}

}
