// Code to solve UVA Online Judge problem #10282

import java.util.Scanner;
import java.util.HashMap;

public class uva_10282 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		HashMap<String, String> map = new HashMap<>();
		
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			if (s.equals(""))
				break;
			String[] arr = s.split(" ");
			map.put(arr[1], arr[0]);
		}
		
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			if (s.equals(""))
				break;
			if (map.containsKey(s)) {
				System.out.println(map.get(s));
			} else {
				System.out.println("eh");
			}
		}

		sc.close();
	}

}
