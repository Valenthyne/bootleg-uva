// Code to solve the UVA Online Judge probme #10684

import java.util.*;

public class uva_10684 {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);

    while (true) {
        int n = sc.nextInt();
        if (n == 0) 
            return;

        int[] a = new int[n];

        boolean pos = false;

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (a[i] > 0) {
                pos = true;
            } 
        }

        if (!pos) {
            System.out.println("Losing streak.");
            continue;
        }

        int[] memo = new int[n];

        memo[0] = a[0];

        int best = memo[0];

        for (int i = 1; i < n; i++) {
            if (memo[i - 1] <= 0) {
                memo[i] = a[i];
            } else {
                memo[i] = memo[i - 1] + a[i];
            }

            if (memo[i] > best) {
                best = memo[i];
            }
        }

        System.out.println("The maximum winning streak is " + best + ".");

    }

  }
  
}
