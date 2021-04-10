/* Author: Artiom Dolghi
 * Due date: Feb 12, 2020
 * Purpose: This program sorts a QueueX object using Selection Sort
 * Credits: I did not work with anybody else, but referenced GeeksforGeeks
 * 			for splitting the sorting into multiple functions
 */

public class SortQueue {
	
	public static int findMinIndex(QueueX myQ, int sortIndex) { 
		
		int minIndex = -1; 
		long min = Long.MAX_VALUE; //make sure that nothing is greater than the min initially
		int size = myQ.size(); 
		for (int i = 0; i < size; i++) { 

			long current = myQ.remove(); 

			if (current <= min && i <= sortIndex) 
			{ 
				minIndex = i; 
				min = current; 
			} 
			myQ.insert(current);  
		} 
		return minIndex; 
	} 

	public static void minToRear(QueueX myQ, int minIndex) { 
		
	long min = 0;  
	int size = myQ.size(); 
	for (int i = 0; i < size; i++) { 
		long current = myQ.peekFront(); 
		myQ.remove(); 
		if (i != minIndex) 
			myQ.insert(current); 
		else
			min = current; 
	} 
	myQ.insert(min); 
	} 
	
	public static void selectionSortQ(QueueX myQ) {
		
		for(int i = 1; i <= myQ.size(); i++) {
		int minIndex = findMinIndex(myQ, myQ.size() - i); 
		minToRear(myQ, minIndex); 
		} 
    }
    
    public static void main(String args[]) {
        QueueX myQ= new QueueX(6);
        myQ.insert(4);
        myQ.insert(1);
        myQ.insert(5);
        myQ.insert(2);
        myQ.insert(1);
        myQ.insert(3);
        myQ.display();
        System.out.println();
        selectionSortQ(myQ);
        myQ.display();
    }
}