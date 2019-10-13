// Code to solve UVA Online Judge problem #924

import java.util.*;

public class uva_924 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numEmployees = sc.nextInt();

        sc.nextLine();

        int[][] friends = new int[numEmployees][15];

        for (int i = 0; i < numEmployees; i++) {
            String[] friendLine = sc.nextLine().split(" ");
            for (int j = 0; j < friendLine.length; j++) {
                friends[i][j] = Integer.parseInt(friendLine[j]);
            }

        }

        boolean[] discovered = new boolean[69];

        ArrayList<Integer> yesterday = new ArrayList<>();
        ArrayList<Integer> today = new ArrayList<>();

        int numTests = sc.nextInt();

        for (int i = 0; i < numTests; i++) {

            int m = 0;
            int d = 0;
            



            // Time to print the output for the given test case
            if (m == 0 && d == 0) {
                System.out.println("0");
            } else {
                System.out.println(m + " " + d);
            }
        }

        sc.close();
    }

}