// Code to solve UVA Online Judge problem #924

import java.util.*;

public class uva_924 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numEmployees = sc.nextInt();

        sc.nextLine();

        int[][] friends = new int[numEmployees][];

        // Initializing employees friend's list
        for (int i = 0; i < numEmployees; i++) {
        	// Take input line and split it
            String[] friendLine = sc.nextLine().split(" ");
            
            // First value equals number of friends
            friends[i] = new int[Integer.parseInt(friendLine[0])];
            
            // Inputting each of the friends
            for (int j = 0; j < friends[i].length; j++) {
                friends[i][j] = Integer.parseInt(friendLine[j + 1]);
            }

        }

        int numTests = sc.nextInt();

        // Master loop for administering the test cases
        for (int test = 0; test < numTests; test++) {

        	// Initialize max boom and boom day integers
            int m = 0;
            int d = 0;
            
            // Employee to be selected for the given test case
            int emp = sc.nextInt();
            
            // Array of days and total reached employees
            int[][] days = new int[numEmployees + 1][2];
            
            // Determine if the employee can reach any one of the employee nodes
            for (int i = 0; i < numEmployees; i++) {
              
                // Determine if emp can reach any one of the other employees (itself excluded)
	            if (i != emp) {
	            	 bfs(friends, emp, i, days);
	     		}
             
            }

            // Cycle through days list to find the maximum boom and specific day
            for (int i = 0; i < days.length; i++) {

                if (days[i][1] > m){
                    m = days[i][1];
                    d = i + 1;
                }

        	  }
          

            // Time to print the output for the given test case
            if (m == 0 && d == 0) {
                System.out.println("0");
            } else {
                System.out.println(m + " " + d);
            }
        }

        sc.close();
    }

    private static void bfs(int[][] adj, int src, int dst, int[][] dayArr) {

        // Basic boiler-plate for BFS
        int[] queue = new int[adj.length];
        queue[0] = src;
        int head = 0;
        int tail = 1;

        // Discovery list for employees
        boolean[] disc = new boolean[adj.length];
        disc[src] = true;

        HashMap<Integer, Integer> prev = new HashMap<>();
        boolean success = false;

        // Actual BFS searching loop
        while (!success && head < tail) {
	        Integer u = queue[head++];
	        for (Integer v: adj[u]) {
	            if (disc[v] == false) {
	                queue[tail++] = v;
	                disc[v] = true;
	                prev.put(v, u);
	                if (v == dst) {
	                    success = true;
	                    break;
	                }
	            }
	        }
        }
        
        // If emp did reach the target employee
        if (success) {
        	int v = dst;
        	int days = 0;
        	while (v != src) {
        		int u = prev.get(v);
        		v = u;
        		days++;
        	}
            // Upon success, the total number employees reached is incremented
        	dayArr[days - 1][1]++;

        }

    }

}