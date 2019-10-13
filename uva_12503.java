// Code to solve UVA Online Judge problem #12503

import java.util.Scanner;

public class uva_12503 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tests = sc.nextInt();
		
		for (int i = 0; i < tests; i++) {
			
			int instr = sc.nextInt();
			int pos = 0;
			int[] record = new int[instr + 1];
			
			sc.nextLine();
			
			for (int j = 0; j < instr; j++) {
				
				String directive = sc.nextLine();
				directive.trim();
				
				switch (directive) {
					case "LEFT":
						pos -= 1;
						break;
					case "RIGHT":
						pos += 1;
						record[j + 1] = 1;
						break;
					default:
						String[] split = directive.split(" ");
						// Trim off in the case of extra spacing
						if ((record[Integer.parseInt(split[2].trim())]) == 0) {
							// Old value: 1 -> go to the left
							pos -= 1;
						} else {
							// Old value: 1 -> go to the right
							pos += 1;
							// Update record to having been a "right" move
							record[j + 1] = 1;
						}
						break;
				
				}
			
			}
			
			System.out.println(pos);
	
		}
		
		sc.close();

	}

}
