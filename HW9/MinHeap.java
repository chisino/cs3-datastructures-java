/* Author: Artiom Dolghi
 * Due date: April 13, 2020
 * Purpose: The MinHeap class is an implementation of a min heap using a node array
 * Credits: I did not work with anybody else on this assignment
 */

public class MinHeap {
   private Node[] heapArray;
   private int maxSize;           // size of array
   private int currentSize;       // number of nodes in array
   
   public static class Node {
     private int iData;             // data item (key)
     
     public Node(int key)           // constructor
     { iData = key; }
     
     public int getKey()
     { return iData; }
     
     public void setKey(int id)
     { iData = id; }
   }
   // -------------------------------------------------------------
   
   public MinHeap(int mx)            // constructor
   {
     maxSize = mx;
     currentSize = 0;
     heapArray = new Node[maxSize];  // create array
   }
   
// -------------------------------------------------------------
   public boolean isEmpty()
   { return currentSize==0; }

// -------------------------------------------------------------
   public boolean insert(int key)
   {
	   if (currentSize==maxSize) return false;    
	   Node newNode = new Node(key); 
	   heapArray[currentSize] = newNode; 
	   trickleUp(currentSize++);    
	   return true;
   }
// -------------------------------------------------------------
   public void trickleUp(int index) {
	   int parent = (index-1) / 2;    
	   Node bottom = heapArray[index];    
	   while(index > 0 && heapArray[parent].getKey() < bottom.getKey() ) {
		   heapArray[index] = heapArray[parent];       
		   index = parent;      
		   parent = (parent-1) / 2;    
	   } 
	   heapArray[index] = bottom; 
   }
   
// -------------------------------------------------------------
   public Node remove()           // delete item with max key. Return the reference to the deleted node.
   {                           // (assumes non-empty list)
	   Node root = heapArray[0]; 
	   heapArray[0] = heapArray[--currentSize]; 
	   trickleDown(0);    
	   return root;
   }
// -------------------------------------------------------------
   public void trickleDown(int index) {
	   int largerChild;    
	   Node top = heapArray[index];
	   
	   while (index < currentSize/2) {
		   int leftChild = 2*index+1; 
		   int rightChild = leftChild+1;       
		   if (rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey() ) {
			   largerChild = rightChild; 
		   }     
		   else {
			   largerChild = leftChild;
		   }      
		   if (top.getKey() >= heapArray[largerChild].getKey() ) break;
		   heapArray[index] = heapArray[largerChild];       
		   index = largerChild;   
	   }
	   heapArray[index] = top;
   }
// -------------------------------------------------------------
   public void displayHeap()
      {
      System.out.print("heapArray: ");    // array format
      for(int m=0; m<currentSize; m++)
         if(heapArray[m] != null)
            System.out.print( heapArray[m].getKey() + " ");
         else
            System.out.print( "-- ");
      System.out.println();
                                          // heap format
      int nBlanks = 32;
      int itemsPerRow = 1;
      int column = 0;
      int j = 0;                          // current item
      String dots = "...............................";
      System.out.println(dots+dots);      // dotted top line
      
      while(currentSize > 0)              // for each heap item
      {
        if(column == 0)                  // first item in row?
          for(int k=0; k<nBlanks; k++)  // preceding blanks
          System.out.print(' ');
                                          // display item
        System.out.print(heapArray[j].getKey());
        
        if(++j == currentSize)           // done?
            break;
        
        if(++column==itemsPerRow)        // end of row?
        {
          nBlanks /= 2;                 // half the blanks
          itemsPerRow *= 2;             // twice the items
          column = 0;                   // start over on
          System.out.println();         //    new row
        }
        else                             // next item on row
          for(int k=0; k<nBlanks*2-2; k++)
          System.out.print(' ');     // interim blanks
      }  // end for
      System.out.println("\n"+dots+dots); // dotted bottom line
   }  // end displayHeap()
   
   public static void main(String[] args) throws Exception {
     MinHeap theHeap = new MinHeap(31);  // make a Heap; max size 31
     
     theHeap.insert(70);           // insert 10 items
     theHeap.insert(40);
     theHeap.insert(50);
     theHeap.insert(20);
     theHeap.insert(60);
     theHeap.insert(100);
     theHeap.insert(80);
     theHeap.insert(30);
     theHeap.insert(10);
     theHeap.insert(90);

     while (!theHeap.isEmpty()) {
       Node node = theHeap.remove();
       System.out.println(node.getKey());
     }
    
   }  // end main()
}