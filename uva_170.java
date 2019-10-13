// Code to solve UVA Online Judge problem #170

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class uva_170 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// Program will continue until pound sign is detected
		while (!(sc.hasNext("#"))) {
		
			String[] deck = new String[52];
			
			// Piles will be represented as 13 individual stack objects
			Stack<String>[] piles = new Stack[13];
			
			// Each pile is initialized
			for (int i = 0; i < 13; i++) {
				piles[i] = new Stack<String>();
			}
			
			
			for (int i = 0; i < 52; i++) {
					deck[i] = sc.next();
			}
			
			// Reversing the input of deck to their correct order
			Collections.reverse(Arrays.asList(deck));
		
			// Appropriately pushes each card into their respective pile
			// as indicated by the Clock Solitaire problem
			for (int i = 0; i < 52; i++) {
				piles[i % 13].push(deck[i]);
			}
			
			// Starting with the "King" pile
			int currentPile = 12;
			
			int cardCount = 0;
			String topCard = "";
			
			while (true) {
				// Game will end when the current pile is met
				if (piles[currentPile].isEmpty()) {
					break;
				}
				
				// Top card from current pile is revealed
				topCard = (String)piles[currentPile].peek();
				piles[currentPile].pop();
				
				// Pile is mapped to the top card rank value
				currentPile = rank(topCard);
				
				// Total cards revealed incremented
				cardCount++;
			
			}
	
			String cardCountStr = Integer.toString(cardCount);
			
			if (cardCount < 10) {
				cardCountStr = "0" + cardCount; 
			} 
			
			System.out.println(cardCountStr + "," + topCard);
			
		}
		
		sc.close();

	}
	
	public static int rank(String card) {
		
		String rank = Character.toString(card.charAt(0));
		
		switch (rank) {
		case "A":
			return 0;
		case "T":
			return 9;
		case "J":
			return 10;
		case "Q":
			return 11;
		case "K":
			return 12;
		default:
			// Protecting against off-by-one error
			return Integer.parseInt(rank) - 1;
		}
	}

}
