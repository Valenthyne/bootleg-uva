// Code to solve UVA Online Judge problem #12015

import java.util.Scanner;

public class uva_12015 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Receive the amount of test cases to run
		int cases = sc.nextInt();
		
		// Array structures for both the sites and their rankings
		String[] sites = new String[10];
		int[] rankings = new int[10];
		
		// Loop through the amount of test cases
		for (int i = 0; i < cases; i++) {

			// Store value for max ranking
			int max = 0; 
			
			// Cycle through each of the ten lines
			for (int j = 0; j < 10; j++) {
				
				// Process each line into the respective arrays
				sites[j] = sc.next();
				rankings[j] = sc.nextInt();
				
				// Evaluate the new maximum ranking
				if (rankings[j] > max) {
					max = rankings[j];
				}
				
			}
			
			System.out.printf("Case #%d:\n", (i + 1));
			
			// Pretty basic way to determine which sites are the most relevant
			for (int k = 0; k < 10; k++) {
				if (rankings[k] == max) {
					System.out.println(sites[k]);
				}
			}
		}
		sc.close();
	}
}
