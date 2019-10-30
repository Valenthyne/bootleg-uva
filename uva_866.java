// Code to solve UVA Online Judge problem #866

import java.util.Scanner;

public class uva_866 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();

        for (int test = 0; test < c; test++) {
        
            // Annoying presentation formatting
            if (test != 0) {
                System.out.println();
            }

            // Total number of lines for this particular case
            int lines = sc.nextInt();

            // Create a line array to store lines
            // First index is current line
            // Second index is x1, y1, x2, and y2 of endpoints

            int[][] linArr = new int[lines][4];
            
            // The minimum number of segments will be the initial number of lines
            int segs = lines;

            // Initialize array of lines
            for (int i = 0; i < lines; i++) {
                linArr[i][0] = sc.nextInt();
                linArr[i][1] = sc.nextInt();
                linArr[i][2] = sc.nextInt();
                linArr[i][3] = sc.nextInt();
            }

            // Main loop for line-to-line comparison
            for (int i = 0; i < lines; i++) {
                double x1 = linArr[i][0];
                double y1 = linArr[i][1];
                double x2 = linArr[i][2];
                double y2 = linArr[i][3];

                for (int j = 0; j < lines; j++) {
                    // Skips case where line is being compared to itself
                    if (i == j) 
                        continue;
                    
                    double x3 = linArr[j][0];
                    double y3 = linArr[j][1];
                    double x4 = linArr[j][2];
                    double y4 = linArr[j][3];

                    double[] pq = solve2x2(x1 - x2, x4 - x3, y1 - y2, y4 - y3, x4 - x2, y4 - y2);

                    if (pq != null) {
                        
                        // Case #1: Typical intersection of two lines
                        // Note: This only tests accurately for infinite lines                        
                        double p = pq[0];
                        double q = pq[1];

                        // Conditions to be met if line segments will intersect
                        boolean pA = (p <= 1 && p >= 0);
                        boolean qA = (q <= 1 && q >= 0);

                        // Segments do intersect, increment counter
                        if (pA && qA) {
                            segs += 1;
                        } 
                    } else if ((x3 - x1) * (y2 - y1) == (y3 - y1) * (x2 - x1)) {
                        
                        // Case #2: Intersections might occur along the same line
                        segs += 1;
                    } else {
                        // Case #3: Lines do not intersect and don't overlap; move along
                    }
                }
            }
            // Print out the total number of segments
            System.out.println(segs);
        }

        sc.close();

    }

    // Method borrowed entirely from the UVA #378 exercise; not my code
    private static double[] solve2x2(double a, double b, double c, double d, double e, double f) {
		double determinant = a * d - b * c;
		if (determinant == 0.0) {return null;}
		double[] ans = new double[2];

		ans[0] = (d * e - b * f) / determinant;
		ans[1] = (-c * e + a * f) / determinant;
		return ans;
	}

}