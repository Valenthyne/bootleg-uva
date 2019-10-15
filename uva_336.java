// Code to solve UVA Online Judge problem #336

import java.util.*;

public class uva_336 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean input = true;
        int cases = 0;

        while (true) {
            int pairs = sc.nextInt();

            if (pairs == 0)
                break;

            HashMap<Integer, ArrayList<Integer>> c = init(pairs, sc);

            input = true;
                        
            while (input) {
                int start = sc.nextInt(); 
                int ttl = sc.nextInt();
                int nodesUnreachable = 0;
        
                if (start == 0 && ttl == 0) {
                    input = false;
                    break;
                }
                
                cases++;

                if (!c.keySet().contains(start)) {
                    nodesUnreachable = c.keySet().size();

                } else {
                for (Integer i : c.keySet()) {

                    nodesUnreachable += bfs(c, start, i, ttl);
        
                }
                }
        
                System.out.println("Case " + cases + ": " + nodesUnreachable + " nodes not reachable from node " + start + " with TTL = " + ttl + ".");
            }
        }

        sc.close();

    }

    private static int bfs(HashMap<Integer, ArrayList<Integer>> adj, int src, int dst, int ttl) {

        if (ttl == 0) {

            if (src == dst) {

                return 0;

            } else {

                return 1;

            }

        }

        if (adj.isEmpty())
            return 0;


        if (src == dst) {
            return 0;
        }

        Integer[] queue = new Integer[adj.size()];
        queue[0] = src;
        int head = 0;
        int tail = 1;

        HashSet<Integer> disc = new HashSet<>();
        disc.add(src);

        HashMap<Integer, Integer> prev = new HashMap<>();

        boolean success = false;

        while (!success && head < tail) {
            int u = queue[head++];
            for (Integer v: adj.get(u)) {
                if (!disc.contains(v)) {
                    queue[tail++] = v;
                    disc.add(v);
                    prev.put(v, u);
                    if (v == dst) {
                        success = true;
                        break;
                    }
                }
            }

        }
        
        int len = 0;
        
        if (success) {
        	len = 0;
        	int v = dst;
        	while (v != src) {
        		int u = prev.get(v);
        		v = u;
        		len++;
        	}
        } else {
            return 1;
        }

        if (len > ttl) {
            return 1;
        } else {
            return 0;
        }

    }

    private static HashMap<Integer, ArrayList<Integer>> init(int pairs, Scanner sc) {

        HashMap<Integer, ArrayList<Integer>> c = new HashMap<>();

        for (int i = 0; i < pairs; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();

            if (c.containsKey(n1)) {
                c.get(n1).add(n2);
            } else {
                ArrayList<Integer> x = new ArrayList<Integer>();
                x.add(n2);
                c.put(n1, x);
            }

            if (c.containsKey(n2)) {
                c.get(n2).add(n1);
            } else {
                ArrayList<Integer> x = new ArrayList<Integer>();
                x.add(n1);
                c.put(n2, x);
            }

        }

        return c;


    }

}