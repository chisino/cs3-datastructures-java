/* Author: Artiom Dolghi
 * Due date: Feb 12, 2020
 * Purpose: This program uses a priority queue to find all such numbers that are less than or equal to N 
 * and that each can be expressed as the sum of two cubes in two different ways
 * Credits: I did all of the work independently
 */

import java.util.*;

public class Ramanujan {
    // A data type that encapsulates a pair of numbers (i, j) 
    // and the sum of their cubes, ie, i^3 + j^3.
    private static class Pair implements Comparable<Pair> {
        private int i;          // first element of the pair
        private int j;          // second element of the pair
        private int sumOfCubes; // i^3 + j^3

        // Construct a pair (i, j).
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
            sumOfCubes = i * i * i + j * j * j;
        }

        // Compare this pair to the other by sumOfCubes.
        public int compareTo(Pair other) {
            return sumOfCubes - other.sumOfCubes;
        }
        
        public String toString() { //method added to print out the pair
            return i + "^3 + " + j + "^3";
        }

    }

    public static void main(String[] args) throws Exception {
    	
    	Scanner keyboard = new Scanner(System.in);
    	System.out.print("Enter a number: ");
    	int n = keyboard.nextInt();
    	keyboard.close();
    	
    	PriorityQueue<Pair> pq = new PriorityQueue<Pair>(n);
    	
    	int i = 0;
        
        while (i < Math.cbrt(n)) {
        	pq.add(new Pair(i, i+1));
        	i++;
        }
        
        while (!pq.isEmpty()) {
        	Pair prev = pq.poll();
        	Pair curr = pq.peek();
        	
        	try {
        	
        		if (curr.compareTo(prev) == 0 && prev.sumOfCubes <= n) {
        			System.out.print(prev.sumOfCubes + " = " + prev + " = " + curr);
        			System.out.println();
        		}
        		
        	} catch (Exception e) {
        		break;
        	}
        	
        	if (curr.j < Math.cbrt(n)) {
        		pq.add(new Pair(curr.i,curr.j+1));
        	}
        }
    
    }
}
