/* Author: Artiom Dolghi
 * Due date: Jan 28, 2020
 * Purpose: The addTwo() method finds 2 values in an array that add up to the target value
 * Credits: I did all of the work independently on my own
 */

import java.util.Scanner;

public class OrdArray {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   
//-----------------------------------------------------------
   public OrdArray(int max) {          // constructor
     a = new long[max];             // create array
     nElems = 0;
   }
//-----------------------------------------------------------
   
   public int size() { 
     return nElems; 
   }
   //-----------------------------------------------------------
   
   public int find(long searchKey) {
     int lowerBound = 0;
     int upperBound = nElems-1;
     int curIn;
     
     while(true) {
       curIn = (lowerBound + upperBound ) / 2;
       if (a[curIn]==searchKey)
         return curIn;              // found it
       else if (lowerBound > upperBound)
         return nElems;             // can't find it
       else {                         // divide range
         if (a[curIn] < searchKey)
           lowerBound = curIn + 1; // it's in upper half
         else
           upperBound = curIn - 1; // it's in lower half
       }  // end else divide range
     }  // end while
   }  // end find()
   
   //-----------------------------------------------------------
   public void insert(long value) {   // put element into array
      int j;
      for (j=0; j<nElems; j++)        // find where it goes
        if (a[j] > value)            // (linear search)
        break;
      for (int k=nElems; k>j; k--)    // move bigger ones up
         a[k] = a[k-1];
      a[j] = value;                  // insert it
      nElems++;                      // increment size
   }  // end insert()
   
   //-----------------------------------------------------------
   public boolean delete(long value) {
      int j = find(value);
      if (j==nElems)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k=j; k<nElems; k++) // move bigger ones down
            a[k] = a[k+1];
         nElems--;                   // decrement size
         return true;
         }
      }  // end delete()
   
   //-----------------------------------------------------------
   public void display() {             // displays array contents
      for (int j=0; j<nElems; j++)       // for each element,
        System.out.print(a[j] + " ");  // display it
      System.out.println("");
   }
   //-----------------------------------------------------------
   
   public int[] addTwo(int target){
	  int[] result = new int[2];
	  int[] noVals = {-1,1};
	  
	  int i = 0;
	  int j = nElems - 1;
	  
	  while (i < j) {
	  if (a[i] + a[j] == target) {
		  result[0] = i;
    	  result[1] = j;
    	  
    	  return result;
      }
      else if (a[i] + a[j] < target) {
    	  i++;
      }
      else if (a[i] + a[j] > target) {
    	  j--;
      }
    		 
     }
	  
     return noVals;
   }
   
   public static void main(String[] args){
     // create an OrdArray object.
     int maxSize = 100;
     OrdArray arr1 = new OrdArray(maxSize);
     arr1.insert(0);
     arr1.insert(10);
     arr1.insert(5);
     arr1.insert(2);
     arr1.insert(12);
     arr1.insert(6);
     arr1.insert(7);
     arr1.insert(24);
     
     // Display the content of this OrdArray object
     System.out.print("The content of the array is: ");
     arr1.display();
     
     Scanner keyboard = new Scanner(System.in);
     
     System.out.print("Enter a target number: ");
     int target = keyboard.nextInt();
     keyboard.close();
     
     int[] addTwoRes = arr1.addTwo(target);
     
     System.out.print("The two elements that can add up to " + target + " are at indexes " + addTwoRes[0] + " and " + addTwoRes[1]);
     
   }
}  // end class OrdArray