/* Author: Artiom Dolghi
 * Due date: Jan 21, 2020
 * Purpose: This program implements the merge() method in the OrdArray class
 * 			and tests it using two arrays in the main() method
 * Credits: I did all of the work independently and used "geeksforgeeks.org" as a reference
 */

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
   
   public static long[] merge(OrdArray arr, OrdArray arr2){
     
	  long[] mergeArr = new long[arr.nElems + arr2.nElems];
	   
	  int i = 0;
	  int j = 0;
	  int k = 0;
	  
	  while (i < arr.nElems && j < arr2.nElems) {
		  if (arr.a[i] < arr2.a[j]) {
			  mergeArr[k++] = arr.a[i++];
		  }
		  else {
			  mergeArr[k++] = arr2.a[j++];
		  }
	  }
	   
	  while (i < arr.nElems) {
		  mergeArr[k++] = arr.a[i++];
	  }
	  
	  while (j < arr2.nElems) {
		  mergeArr[k++] = arr2.a[j++];
	  }
	   
     return mergeArr;
   }
   
   public static void main(String[] args){
     
	  OrdArray arr1 = new OrdArray(7);
	  OrdArray arr2 = new OrdArray(6);
	  
	  arr1.insert(1);
	  arr1.insert(3);
	  arr1.insert(5);
	  arr1.insert(5);
	  arr1.insert(7);
	  arr1.insert(9);
	  arr1.insert(11);
	  // testing the example from the HW sheet
	  arr2.insert(2);
	  arr2.insert(4);
	  arr2.insert(6);
	  arr2.insert(8);
	  arr2.insert(10);
	  arr2.insert(10);
	  
	  long[] mergeArr = merge(arr1, arr2);
	  
	  System.out.println("The first ordered array is: ");
	  arr1.display();
	  
	  System.out.println("The second ordered array is: ");
	  arr2.display();
	  
	  System.out.println("The merged ordered array is: ");
	  
	  for (int i = 0;i < mergeArr.length;i++) {
		  System.out.print(mergeArr[i] + " ");
	  }
	   
   }
   
}  // end class OrdArray