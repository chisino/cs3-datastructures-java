/* Author: Artiom Dolghi
 * Due date: Feb 5, 2020
 * Purpose: The push() and pop() methods add and remove elements from an array
 * Credits: I did all of the work independently on my own
 */

class StackX
   {
   private int maxSize;        // size of stack array
   private long[] stackArray;
   private int top;            // top of stack
//--------------------------------------------------------------
   
   public StackX(int s)         // constructor
      {
      maxSize = s;             // set array size
      stackArray = new long[maxSize];  // create array
      top = -1;                // no items yet
      }
//--------------------------------------------------------------
   
   public void push(long j)    // put item on top of stack
      {
	  if (isFull()) {
		  long[] newArray = new long[maxSize * 2];
		  for (int i = 0;i < stackArray.length;i++) {
			  newArray[i] = stackArray[i];
		  }
		  stackArray = newArray;
	  }
	  
	  stackArray[++top] = j;
      }
//--------------------------------------------------------------
   
   public long pop()           // take item from top of stack
      {
	  if (top < (maxSize / 2) - 1) {
		  long[] newArray = new long[maxSize / 2];
		  for (int i = 0;i < stackArray.length;i++) {
			  newArray[i] = stackArray[i];
		  }
		  stackArray = newArray;
	  }
	  
      return stackArray[top--];
      }
//--------------------------------------------------------------
   
   public long peek()          // peek at top of stack
      {
      return stackArray[top];
      }
//--------------------------------------------------------------
   
   public boolean isEmpty()    // true if stack is empty
      {
      return (top == -1);
      }
//--------------------------------------------------------------
   
   public boolean isFull()     // true if stack is full
      {
      return (top == maxSize-1);
      }
//--------------------------------------------------------------
   
   public void display() {
     for (int i=top; i>=0; i--){
       System.out.print(stackArray[i]+" ");
     }
     System.out.println();
   }

//----------------------------------------------------------------
   
    public static void main(String[] args)
    {
      StackX theStack = new StackX(5);  // make new stack
      theStack.push(20);               // push items onto stack
      theStack.push(40);
      theStack.push(60);
      theStack.push(80);
      theStack.push(100);
      theStack.push(120);
      theStack.push(150);
      
      theStack.display();
      
      theStack.pop();               // pop out items
      theStack.pop();               // pop out items
      theStack.pop();               // pop out items
      theStack.pop();               // pop out items
      theStack.pop();               // pop out items
      theStack.pop();               // pop out items
    
      theStack.display();
      
    }  // end main()
}  // end class StackX