// Code to solve UVA Online Judge problem #11413

import java.util.Scanner;

//Remember to change class name to Main
public class uva_11413 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// Loop to look out for inputs/extra cases
		while (sc.hasNext()) {
			// Obtain the number of vessels
			int v = sc.nextInt();
			// Prepare an array to initial vessel values
			int[] vessels = new int[v];
						
			// Obtain number of containers
			int m = sc.nextInt();
			
			// Establishing a running total for a worst case scenario
			int sum = 0;
			
			// Initialize vessel array with their values
			for (int i = 0; i < v; i++) {
				vessels[i] = sc.nextInt();
				sum += vessels[i];
			}
			
			int l = 1;
			int u = sum;
			int cap = u + 1;
			
			while (l <= u) {
				int mid = (l + u) / 2;
				// Evaluate condition where vessels can be utilized at capacity
				if (evaluate(vessels, m, mid)) {
					// Mid is a legal value for capacity!
					cap = mid;
					u = mid - 1;
				} else {
					// Move the posts forward and keep looking
					l = mid + 1;
				}
			}
			System.out.println(cap);
		}
		sc.close();

	}
	
	// Method for determining whether or not a given guess capacity is valid
	public static boolean evaluate(int[] vessels, int cont, int guess) {
		int index = 0;
		int maxVolume = guess;
		
		while(index < vessels.length && cont > 0) {
			if (vessels[index] <= maxVolume) {
				// Vessel expended, remove total from maximum volume
				maxVolume -= vessels[index];
				index++;
			} else {
				// Reset the volume, a container has been "filled"
				maxVolume = guess;
				cont -= 1;
			}
		}
		
		return index == vessels.length;			
		}
		
}