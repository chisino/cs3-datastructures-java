/* Author: Artiom Dolghi
 * Due date: April 13, 2020
 * Purpose: The Min_PriorityQueue class uses the MinHeap class in its implementation
 * Credits: I did not work with anybody else on this assignment
 */

public class Min_PriorityQueue {
 // array in sorted order, from max at 0 to min at size-1
 private int maxSize;
 private MinHeap theHeap;
 private int nItems;
 // -------------------------------------------------------------

 public Min_PriorityQueue(int size) // constructor
 { 
	 maxSize = size;
	 theHeap = new MinHeap(maxSize);
	 nItems = 0;
 }

 // -------------------------------------------------------------
 public void insert(int item) // insert item
 { 
	 theHeap.insert(item);
 } // end insert()

 public int remove() // remove minimum item
 { 
	 MinHeap.Node removed = theHeap.remove();
	 return removed.getKey();
 }

 // -------------------------------------------------------------
 public int peek() // peek at minimum item
 { // YOUR CODES
	 MinHeap.Node removed = theHeap.remove();
	 theHeap.insert(removed.getKey());
	 
	 return removed.getKey();
 }

 // -------------------------------------------------------------
 public boolean isEmpty() // true if queue is empty
 {
	 return theHeap.isEmpty();
 }

 // -------------------------------------------------------------
 public boolean isFull() // true if queue is full
 {
	 return (nItems == maxSize);
 }

 public static void main(String[] args) {  
  Min_PriorityQueue thePQ = new Min_PriorityQueue(5);
  
  thePQ.insert(30);
  thePQ.insert(50);
  thePQ.insert(10);
  thePQ.insert(40);
  thePQ.insert(20);
  
  while (!thePQ.isEmpty()) {
   long item = thePQ.remove();
   System.out.print(item + " "); // 10, 20, 30, 40, 50
  }
  System.out.println("");
 } // end main()
}