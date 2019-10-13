// Code to solve UVA Online Judge problem #10611

import java.util.Scanner;

public class uva_10611 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// Obtain the number of ladies to evaluate and their subsequent heights
		int count = sc.nextInt();
		int[] ladies = new int[count];
		
		// Initialize the array of lady heights
		for (int i = 0; i < count; i++) {
			ladies[i] = sc.nextInt();
		}
		
		// Obtain number of queries and the chimp's heights
		int queries = sc.nextInt();
		int[] heights = new int[queries];
		
		// Begin loop for each query case
		for (int i = 0; i < queries; i++) {
			heights[i] = sc.nextInt();
			
			// I'm sure there was a way to do this without splitting
			// the methods, but this is what I managed to get working.
			
			// Run binary search on values taller than the chimp, find the shortest
			int shorterLady = binSrcIfShorter(ladies, heights[i]);
			
			// Run binary search on values shorter than the chimp, find the tallest
			int tallerLady = binSrcIfTaller(ladies, heights[i]);
						
			
			// If height of lady is zero, no legal shorter chimp was found
			if (shorterLady == 0) {
				System.out.print("X ");
			} else {
				System.out.print(shorterLady + " ");
			}
			
			// If height of lady is zero, no legal taller chimp was found
			if (tallerLady == 0) {
				System.out.printf("X\n");
			} else {
				System.out.print(tallerLady + "\n");
			}


		}
				
		sc.close();
		
	}
	
	// Method to be used to search all chimps smaller than the target
	public static int binSrcIfShorter(int[] ladies, int test) {
		int l = 0;
		int u = ladies.length - 1;
		int maxHeight = 0;
		
		while (l <= u) {
			int m = (l + u) / 2;
			if (ladies[m] < test) {
				l = m + 1;
				maxHeight = ladies[m];
			} else {
				u = m - 1;
			}
		}
		return maxHeight;
	}
	
	// Method to be used to search all chimps taller than the target
	public static int binSrcIfTaller(int[] ladies, int test) {
		int l = 0;
		int u = ladies.length - 1;
		int minHeight = 0;
		
		while (l <= u) {
			int m = (l + u) / 2;
			if (ladies[m] > test) {
				u = m - 1;
				minHeight = ladies[m];
			} else {
				l = m + 1;
			}
		}
		return minHeight;
	}

}