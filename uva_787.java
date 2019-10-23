// Code to solve UVA Online Judge problem #787

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class uva_787 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*
         * Creating a two-dimensional memo list where the rows 
         * will consist of sub-problems that are subsequences
         * including up to the i-th digit
         */
        
        BigInteger[][] memo = new BigInteger[1024][2];

        while (sc.hasNextInt()) {
        
        	// Using an array list to take input because this problem is a pain
        	ArrayList<BigInteger> arrList = new ArrayList<>();
                	
        	// Read through the input
	        while (true) {
	            int n = sc.nextInt();
	            
	            // Edge case where input can be -999999
	            if (arrList.size() == 0 && n == -999999) {
	            	sc.close();
	            	return;
	            }
	            
	            // Cease reading this case upon -999999
	            if (n == -999999) {
	                break;
	            }
	            
	            // Accounting for case where n is zero
	            if (n == 0) {
	            	arrList.add(BigInteger.ZERO);
	            } else {
	            	arrList.add(BigInteger.valueOf(n));
	        	}
	
	        }
	        
	        // Convert array list to an array for better efficiency
	        BigInteger[] values = arrList.toArray(new BigInteger[arrList.size()]);
	        
	        // Initialize memo list by only considering the first input value
	        memo[0][0] = values[0];
			memo[0][1] = values[0];
			
			// Progressive count for non-null memo list values
			int count = 1;
	        
			// Previous max and min values to be used for comparison
	        BigInteger prevMax = memo[0][0];
	        BigInteger prevMin = memo[0][1];
	        
	        // Parse through all the input digits
	        for (int i = 1; i < arrList.size(); i++) {
		        BigInteger x = values[i];
		        	
		        // Case where x is a positive integer
		        if (x.compareTo(BigInteger.ZERO) == 1) {
		        	memo[i][0] = x.max(x.multiply(prevMax));
		        	memo[i][1] = x.min(x.multiply(prevMin));
		        }
		        
		        // Case where x is a negative integer
		        if (x.compareTo(BigInteger.ZERO) == -1) {
					memo[i][0] = x.max(x.multiply(prevMin));
					memo[i][1] = x.min(x.multiply(prevMax));
		        }
		        
		        // Case where x is zero
		        if (x.compareTo(BigInteger.ZERO) == 0) {
		        	memo[i][0] = BigInteger.ZERO;
		        	memo[i][1] = BigInteger.ZERO;
		        }
		       
		        // Update previous max and min for next comparison
		        prevMax = memo[i][0];
				prevMin = memo[i][1];
				
				// Increment total count of memo list
				count++;
	        
	        }
			
	        // Start comparisons through all of the memo list
			BigInteger max = memo[0][0];

			for (int i = 0; i < count; i++) {
				// End of registered values found
				if (memo[i][0] == null)
					break;
				
				// New maximum is found
				if (memo[i][0].compareTo(max) == 1) {
					max = memo[i][0];
				}
			}

	        System.out.println(max);
        
        }
        
        sc.close();
	}
	
}