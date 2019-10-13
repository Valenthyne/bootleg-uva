// Code to solve UVA Online Judge problem #628

import java.util.Scanner;

public class uva_628 {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Continue until no further integers are read
        while (sc.hasNextInt()) {

            // Formatting to avoid the dreaded "Presentation Error"
            System.out.println("--");

            // Receive amount of words to be processed
            int x = sc.nextInt();
            String[] words = new String[x];

            // Initialize array of words in order
            for (int i = 0; i < x; i++) {
                words[i] = sc.next();
            }

            // Receive amount of rules to be processed
            int y = sc.nextInt();

            // Prepare for processing each rule on the passwords
            for (int i = 0; i < y; i++) {
                String rule = sc.next();
                // Begin initial recursive call to begin generating passwords
                password(words, rule, "", 0);
            }

        }

        sc.close();

    }

    private static void password(String[] w, String r, String soFar, int x) {
        
        // Base case for recursive function
        if (x >= r.length()) {
            System.out.printf("%s\n", soFar);
            return;
        }
        
        if (r.charAt(x) == '#') {
            // Begin processing for word rule
            for (int i = 0; i < w.length; i++) {
                // Index of rule string incremeted by one; recursive condition
                password(w, r, soFar + w[i], x + 1);
            }
        } else if (r.charAt(x) == '0') {
            // Begin processing for digit rule (allowed 0 - 9)
            for (int i = 0; i < 10; i++) {
                // Index of rule string incremented by one; recursive condition
                password(w, r, soFar + i, x + 1);
            }
        }

    }
}