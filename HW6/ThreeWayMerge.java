/* Author: Artiom Dolghi
 * Due date: March 3, 2020
 * Purpose: The ThreeWayMerge class/method sorts an array using 3 way merge sort
 * Credits: I did all of the work independently - I used the regular 2 way merge class that
 * 			was from one of the slides as a base for this class
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ThreeWayMerge {
	
	private long[] theArray;          // ref to array theArray
	private int nElems;               // number of data items
	//-----------------------------------------------------------
	public ThreeWayMerge(int max)            // constructor
		{
	    theArray = new long[max];      // create array
	    nElems = 0;
	    }
	//-----------------------------------------------------------
	public void insert(long value)    // put element into array
	    {
	    theArray[nElems] = value;      // insert it
	    nElems++;                      // increment size
	    }
	//-----------------------------------------------------------
	public void display()             // displays array contents
	    {
	    for(int j = 0; j < nElems; j++)    // for each element,
	       System.out.print(theArray[j] + " ");  // display it
	    System.out.println("");
	    }
	//-----------------------------------------------------------
	public void mergeSort()           // called by main()
	    {                              // provides workspace
	    long[] workSpace = new long[nElems];
	    
	    for (int i = 0; i < nElems; i++) 
            workSpace[i] = theArray[i]; 
	    
	    recMergeSort(workSpace, 0, nElems-1);
	    
	    }
	//-----------------------------------------------------------
	private void recMergeSort(long[] workSpace, int lowerBound, int upperBound)
	    {
	    if (upperBound - lowerBound < 2) return;
	    
	    int mid1 = lowerBound + ((upperBound - lowerBound) / 3); //splitting into thirds
	    int mid2 = lowerBound + 2 * ((upperBound - lowerBound) / 3) + 1;
	                                              
	    recMergeSort(workSpace, lowerBound, mid1);
	    recMergeSort(workSpace, mid1, mid2);
	    recMergeSort(workSpace, mid2, upperBound);
	                                              
	    merge(workSpace, lowerBound, mid1, mid2, upperBound);  
	    }  
	//-----------------------------------------------------------
	private void merge(long[] workSpace, int lowerBound, int mid1, int mid2, int upperBound)
	    {
	    int i = lowerBound;
	    int j = mid1;
	    int k = mid2;
	    int l = lowerBound;      

	    while (i < mid1 && j < mid2 && k < upperBound) {
	    	if (theArray[i] < theArray[j]) {
	    		if (theArray[i] < theArray[k]) 
	    			workSpace[l++] = theArray[i++];
	    		else
	    			workSpace[l++] = theArray[k++];
	    	}
	    	else {
	    		if (theArray[j] < theArray[k])
	    			workSpace[l++] = theArray[j++];
	    		else
	    			workSpace[l++] = theArray[k++];
	    	}
	    }

	    while (i < mid1 && j < mid2) {
	    	if (theArray[i] < theArray[j])
	    		workSpace[l++] = theArray[i++];
	    	else
	    		workSpace[l++] = theArray[j++];
	    }

	    while (i < mid1 && k < upperBound) {
	        if (theArray[i] < theArray[k])
	        	workSpace[l++] = theArray[i++];
	        else
	        	workSpace[l++] = theArray[k++];	        
	    }
	    
	    while (i < mid1)
	    	workSpace[l++] = theArray[i++];
	    
	    while (j < mid2)
	    	workSpace[l++] = theArray[j++];
	    
	    for (j = 0; j < nElems; j++)
	         theArray[j] = workSpace[j];
	   
	}
	////////////////////////////////////////////////////////////////

	public static void main(String[] args) throws Exception
		{
		
		File file = new File("src/largeW.txt");
		
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		
		FileWriter myWriter = new FileWriter("src/largeWResults.txt");
		
		String s; 
		while ((s = br.readLine()) != null) { // writing to the file
			ThreeWayMerge arr;
			arr = new ThreeWayMerge(s.length());
			for (int i = 0;i < s.length();i++) {
				arr.insert(Character.getNumericValue(s.charAt(i)));
			}
			arr.mergeSort();
			for (int i = 0;i < arr.nElems;i++) {
				myWriter.write(arr.theArray[i] + " ");
			}
			myWriter.write("\n");
		} 
		
		br.close();
		myWriter.close();
		
	    int maxSize = 100;    // testing on smaller array
	    ThreeWayMerge arr;
	    arr = new ThreeWayMerge(maxSize); 

	    arr.insert(64);               
	    arr.insert(21);
	    arr.insert(33);
	    arr.insert(70);
	    arr.insert(12);
	    arr.insert(85);
	    arr.insert(44);
	    arr.insert(3);
	    arr.insert(99);
	    arr.insert(108);

	    arr.display();                 

	    arr.mergeSort();               

	    arr.display();                 
	    }
	
}
