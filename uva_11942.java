// Code to solve UVA Online Judge problem #11942

import java.util.Scanner;

public class uva_11942 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Receive the number of groups to process
		int gr = sc.nextInt();
		System.out.println("Lumberjacks:");
		
		// Loop through each group test case
		for (int i = 0; i < gr; i++) {
			// Establish an array to store each lumberjack
			int[] lumberjacks = new int[10];
			
			// Booleans to determine the status of the lumberjack group
			boolean ascending = true;
			boolean unordered = false;
			
			// Input the lengths of the lumberjacks' beards in the array
			for (int j = 0; j < lumberjacks.length; j++) {
				lumberjacks[j] = sc.nextInt();
			}
			
			if (!unordered) {
				// Determine if the orders is presumed to be ascending
				if (lumberjacks[0] > lumberjacks[9]) 
					ascending = false;

				if (ascending) {
					for (int k = 0; k < lumberjacks.length - 1; k++) {
						// If at any point a preceding value is greater than the next value, break
						if (lumberjacks[k] > lumberjacks[k+1]) {
							unordered = true;
							break;
						}
					}
				} else {
					for (int k = 0; k < lumberjacks.length - 1; k++) {
						// If at any point a preceding value is less than the next value, break
						if (lumberjacks[k] < lumberjacks[k+1]) {
							unordered = true;
							break;
						}
					}
				}
			} else {
				continue;
			}
			if (unordered) {
				System.out.println("Unordered");
			} else {
				System.out.println("Ordered");
			}
		}
		sc.close();
	}
}
