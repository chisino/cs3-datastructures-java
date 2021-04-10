/* Author: Artiom Dolghi
 * Due date: Feb 12, 2020
 * Purpose: This program calculates the moving average
 * Credits: I did not work with anybody else, but referenced programcreek.com for
 * 			part of the next() function
 */

import java.util.Scanner;

class MovingAverage {
	
	private double sum;
	private QueueX myQ = new QueueX();
	private int size;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        sum += val;
        myQ.insert(val);
        
        if (myQ.size() <= size) {
        	return sum / myQ.size();
        }
        
        sum -= myQ.remove();
        
        return sum / size;
    }
    
    public static void main(String[] args){
    	
      Scanner keyboard = new Scanner(System.in);
      
      System.out.print("Enter the size of the window: ");
      int wndSize = keyboard.nextInt();
      MovingAverage one = new MovingAverage(wndSize);
      
      for (int i = 0;i <= wndSize;i++) {
      
    	  System.out.print("Enter a number to be added: ");
    	  double result = one.next(keyboard.nextInt());
      
    	  System.out.print("The average after adding the number is " + result);
    	  
    	  if (i != wndSize) System.out.println(); //do not print an extra space
      }
      
      keyboard.close();
    }
}
