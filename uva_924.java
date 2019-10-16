// Code to solve UVA Online Judge problem #924

import java.util.*;

public class uva_924 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int empCount = sc.nextInt();

        sc.nextLine();

        int[][] friends = new int[empCount][];

        // Initializing employees friend's list
        for (int i = 0; i < empCount; i++) {

            int friendCount = sc.nextInt();
            friends[i] = new int[friendCount];

            for (int j = 0; j < friendCount; j++) {
                friends[i][j] = sc.nextInt();

            }
        }

        int testCount = sc.nextInt();

        // Master loop for administering the test cases
        for (int t = 0; t < testCount; t++) {

            // Employee to be selected for the given test case
            int emp = sc.nextInt();
            
            // Array of days and total reached employees
            int[] days = new int[empCount + 1];
            
            // Determine if the employee can reach any one of the employee nodes
              
            bfs(friends, emp, days);

        }

        sc.close();
    }

    private static void bfs(int[][] adj, int start, int[] dayCounter) {

        // Basic boiler-plate for BFS
        int[] queue = new int[adj.length];
        queue[0] = start;
        int head = 0;
        int tail = 1;

        // Discovery list for employees
        boolean[] discovered = new boolean[adj.length];
        discovered[start] = true;

        // Initialize array to track distances from start node for each employee (by index)
        int[] distanceFromStart = new int[adj.length];

        int max = 0;
        int day = 0;

        // Actual BFS searching loop
        while (head < tail) {
            int u = queue[head++];
	        for (int v: adj[u]) {
	            if (discovered[v] == false) {
	                queue[tail++] = v;
                    discovered[v] = true;
                    // Total distance is previous node's distance + 1
                    distanceFromStart[v] = distanceFromStart[u] + 1;
                    // Same distance for multiple nodes means they were told on the same day;
                    dayCounter[distanceFromStart[v]]++;
	            }
            }
	        
            // Move backwards from dayCounter so that the "first" day can ultimately be discovered
            for (int k = dayCounter.length - 1; k >= 0; k--) {
            	if (dayCounter[k] != 0 && dayCounter[k] > max) {
            		max = dayCounter[k];
            		day = k;
            	}
            }
            
        }
        
        // Output formatting
        if (max == 0 && day == 0) {
        	System.out.println("0");
        } else {
            System.out.println(max + " " + day);
        }
        
        }

}