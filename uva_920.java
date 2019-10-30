// Code to solve UVA Online Judge problem #920

import java.util.*;

public class uva_920 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Receive as input the number of test cases
        int c = sc.nextInt();

        // Handle all the test cases
        for (int i = 0; i < c; i++) {

            // Number of lines to be entered
            int lines = sc.nextInt();

            // Create a coordinate array where first index is a given line
            // and the [0] index = x-value, [1] index = y-value
            int[][] peaks = new int[lines][2];
            
            // Initialize coordinates given as input
            for (int j = 0; j < lines; j++) {

                // point x
                peaks[j][0] = sc.nextInt();

                // point y
                peaks[j][1] = sc.nextInt();
            }

            // Quick and easy way to sort the array
            // Credit: https://stackoverflow.com/a/39949208
            Arrays.sort(peaks, (a, b) -> Double.compare(a[0], b[0]));

            int maxHeight = 0;
            double sunshine = 0;

			// Increment backwards from maximum x-value to the origin
			// A lot easier to do this than figure out how to sort in descending...
			
            for (int k = peaks.length - 1; k >= 0; k--) {
				
				// Compare the current peak height to the stored maximum height
                if (peaks[k][1] > maxHeight) {
					/* 
					   If a new peak height is found, calculate the new sunshine
					   Sunshine evaluated as distance between current peak and the previous
					   Multiplied by the difference in peak height and the maximum height
					   Divided by the difference in peak height betweens the two peaks
					*/
                    sunshine += distance(peaks[k][0], peaks[k][1], peaks[k + 1][0], peaks[k + 1][1]) * (peaks[k][1] - maxHeight) / (peaks[k][1] - peaks[k + 1][1]);
                    
					// Set the new maximum height and continue as usual
					maxHeight = peaks[k][1];
                }

            }

			// Print out the total number of sunshine in the appropriate format
            System.out.println(String.format("%.2f", sunshine));


        }

        sc.close();

    }

	// Distance formula used to help calculate distance from peak to peak
    private static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2 - x1) ,2) + Math.pow((y2 - y1) ,2));
    }
}
