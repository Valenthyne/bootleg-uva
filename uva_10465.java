// Code to solve UVA Online Judge problem #10465

import java.util.Scanner;

public class uva_10465 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {

            // Setting up basic variables and structures
            int m = sc.nextInt();
            int n = sc.nextInt();
            int t = sc.nextInt();

            int[] memo = new int[10001];

            /*
                Memo list will consider subproblems where Homer only has 
				as many minutes as the index of the array
            */

            // Can't eat anything at zero-time
            memo[0] = 0;

            // Meat of the dynamic programming algorithm
            // From one minute up to t minutes
            for (int i = 1; i <= t; i++) {

                int krusty;
                int apu;

                // Considering the case of eating Krusty burgers in the time allotted
                if (i - m >= 0) {
                    krusty = memo[i - m];
                } else {
                    krusty = -1;
                }

                // Increment total Krusty Burger count
                if (krusty >= 0)
                    krusty++;

                // Considering the case of eating Apu burgers in the time allotted
                if (i - n >= 0) {
                    apu = memo[i - n];
                } else {
                    apu = -1;
                }

             // Increment total Apu Burger count
                if (apu >= 0)
                    apu++;

                // Compare which one is going to yield the most burger consumption by i minutes
                memo[i] = Math.max(krusty, apu);
            }

            // In the case where there was no extra time for drinking
            if (memo[t] != -1) {
                System.out.println(memo[t]);
            } else {
                // Have to find point at which drinking was required
                int i = t;
                while (memo[i] == -1) {
                    i--;
                }
                int drinkTime = t - i;
                
                // Print out maximum burgers and the remaining drink time
                System.out.println(memo[i] + " " + drinkTime);
            }

        }
        
        sc.close();

    }

}
