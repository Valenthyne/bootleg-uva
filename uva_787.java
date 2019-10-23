// Code to solve UVA Online Judge problem #787

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class uva_787 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BigInteger[][] memo = new BigInteger[200][2];

        while (sc.hasNext()) {
        // While loop for handling a single test case
        	
        	ArrayList<BigInteger> arrList = new ArrayList<>();
        	
        	
	        while (sc.hasNextInt()) {
	        
	            int n = sc.nextInt();
	            if (n == -999999) {
	                break;
	            }
	            if (n == 0) {
	            	arrList.add(BigInteger.ZERO);
	            } else {
	            arrList.add(BigInteger.valueOf(n));
	        	}
	
	        }
	        
	        BigInteger[] values = arrList.toArray(new BigInteger[arrList.size()]);
	        
	        memo[0][0] = values[0];
	        memo[0][1] = values[0];
	        
	        BigInteger prevMax = memo[0][0];
	        BigInteger prevMin = memo[0][1];
	        
	        for (int i = 1; i < arrList.size(); i++) {
		        BigInteger x = values[i];
		        	
		        if (x.compareTo(BigInteger.ZERO) == 1) {
		        	memo[i][0] = x.max(x.multiply(prevMax));
		        	memo[i][1] = x.min(x.multiply(prevMin));
		        }
		        
		        if (x.compareTo(BigInteger.ZERO) == -1) {
		        	memo[i][0] = memo[i - 1][0].max(x.max(x.multiply(prevMin)));
		        	memo[i][1] = memo[i - 1][1].min(x.min(x.multiply(prevMax)));
		        }
		        
		        if (x.compareTo(BigInteger.ZERO) == 0) {
		        	memo[i][0] = x.max(prevMax);
		        	memo[i][1] = BigInteger.ZERO;
		        }
		        		        
		        prevMax = memo[i][0];
		        prevMin = memo[i][1];
	        
	        }
	        int n = arrList.size();
	        System.out.println(memo[n - 1][0].max(memo[n - 1][1]));
        
    }
        sc.close();
    }
}