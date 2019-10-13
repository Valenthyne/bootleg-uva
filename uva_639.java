// Code to solve UVA Online Judge problem #639

import java.util.HashSet;
import java.util.Collections;
import java.util.Scanner;

public class uva_639 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// Cycling through the inputs
		while (sc.hasNext()) {
			
			int x = 0;
			
			// Dimensions of board to be stored
			if (sc.hasNextInt())
				x = sc.nextInt();
			
			// Marker to finish reading input
			if (x == 0) {
				break;
			}
			
			// Generate two-dimensional board array
			char[][] board = new char[x][x];
			
			sc.nextLine();
			
			// Initialize board according to input
			for (int i = 0; i < x; i++) {
			    String column = sc.nextLine();
				for (int j = 0; j < x; j++) {
					board[i][j] = column.charAt(j);
				}
			}
			
			// Generate history set to record rook values
			HashSet<Integer> history = new HashSet<>();

			// Base recursive call at position 0,0 and 0 total rooks
			search(board, history, 0, 0, 0);
			
			// Determine the maximum possible rooks from all outcomes
			if (history.isEmpty()) {
				// Takes care of annoying edge case where all X's present
				System.out.println("0");
			} else {
				System.out.println(Collections.max(history));
			}
			
		}
		
		sc.close();

	}

	private static void search(char[][] b, HashSet<Integer> history, int x, int y, Integer rooks) {
		
		// Main recursive method for finding the possibilities of rook formations given the board
		// Will dump the solutions into a hash set for the maximum to later be retrieved as the answer
		
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length; j++) {
				// Determine a legal testing location for rook placement
				if (b[i][j] == '.' && lineOfSight(b, i, j)) {
					// Place a rook at the lineOfSight empty location
					b[i][j] = 'R';
					// Total rooks found incremented by one
					rooks++;
					// Add the running total to the history
					history.add(rooks);
					// Recursively search down the board (vertically) for further potential LOS violations 
					search(b, history, i, j + 1, rooks);
					// Done checking this space; remove the rook
					b[i][j] = '.';
					// Decrement the rook count after removing it
					rooks--;
					}
				}
			}
		}
	
	private static boolean lineOfSight(char[][] b, int x, int y) {
		
		// This method searches down rows and columns to see if another rook has been planted
		// If so, then that would indicate an illegal move
		// Breaks out of a certain loop if a wall is found because rooks can't attack through walls
		
		for (int i = x - 1; i >= 0; i--) {
            if (b[i][y] == 'X')
              break;
            if (b[i][y] == 'R')
              return false;
          }
        
          for (int i = x + 1; i < b.length; i++) {
            if (b[i][y] == 'X')
              break;
            if (b[i][y] == 'R')
              return false;
          }
          
          for (int i = y - 1; i >= 0; i--) {
            if (b[x][i] == 'X')
              break;
            if (b[x][i] == 'R')
              return false;
          }
        
          for (int i = y + 1; i < b.length; i++) {
            if (b[x][i] == 'X')
              break;
            if (b[x][i] == 'R')
              return false;
          }


        return true;
	}

}
