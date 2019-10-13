// Code to solve UVA Online Judge problem #514

import java.util.Scanner;
import java.util.Stack;

public class uva_514 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// Master while loop to parse through each of the inputs
		while (true) {
			int count = sc.nextInt();
			
			// Second 0 is entered, concluding the program altogether
			if (count == 0)
				break;
		
			boolean finished = false;
		
			// Still inputs to be read and a block has not been completed yet
			while (sc.hasNextInt() && !finished) {
				
				Stack<Integer> stack = new Stack<>();

				// Prepare an array to store knowledge of the trains
				int[] trains = new int[count];
				init(trains);
				
				// Prepare an array to receive the input permutation
				int[] perm = new int[count];
				
				for (int i = 0; i < perm.length; i++) {
					perm[i] = sc.nextInt();
					
					// Condition to terminate the loop if 0 is reached
					if (perm[i] == 0) {
						finished = true;
						break;
					}
				}
				
				// Another condition to break out if the block is completed
				if (finished)
					break;
				
				int index = 0;
				
				// For loop to handle the simulation problem
				for (int i = 1; i <= count; i++) {
					// Continuously push trains onto the stack to check for validity of permutation
					stack.push(i);
					
					while (!stack.isEmpty()) {
						// Top of stack is a valid train in the permutation array
						if (stack.peek() == perm[index]) {
							stack.pop();
							// Continue indexing to go through the rest of the permutations
							index++;
						} else {
							// Continue the process of pushing trains for evaluation
							break;
						}
					}
				}
				
				
				if (stack.isEmpty()) {
					// All trains have departed; permutation was successful
					System.out.println("Yes");
				} else {
					// Certain trains still left behind
					System.out.println("No");
				}
				
			}
			System.out.println();
		}
		sc.close();

	}
	
	// Method to initialize array
	public static void init(int[] t) {
		for (int i = 0; i < t.length; i++) {
			t[i] = i + 1;
		}
	}

}
