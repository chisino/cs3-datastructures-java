/* Author: Artiom Dolghi
 * Due date: Feb 12, 2020
 * Purpose: This program prints the order of elimination in the Josephus problem
 * Credits: I did not work with anybody else, but referenced Princeton
 */

import java.util.*;

class Josephus {
  public void getJosephus(int N, int M){
    QueueX myQ = new QueueX(N);
    
    for (int i = 0;i < N;i++) {
    	myQ.insert(i);
    }
    
    while (!myQ.isEmpty()) {
    	for (int i = 0;i < M-1;i++) {
    		long val = myQ.remove();
    		myQ.insert(val);
    	}
    	System.out.print(myQ.remove() + " ");
    }
    System.out.println();
  }
  
  public static void main(String[] args) throws Exception {
    Josephus josephus = new Josephus();
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter a number for N indicating the total number of people: ");
    int N = input.nextInt();
    System.out.print("Please enter a number for M indicating the Mth person to be eliminated: ");
    int M = input.nextInt();
    input.close();
    josephus.getJosephus(N, M);
  }
}