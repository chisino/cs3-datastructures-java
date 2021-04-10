/* Author: Artiom Dolghi
 * Due date: Jan 28, 2020
 * Purpose: The sort() method uses OddEvenSort to sort an array
 * Credits: I did all of the work independently on my own
 */

import java.util.*;

class OddEvenSort {
  public static void sort(int[] arr){
	  
	  int temp = 0;
	  
	  boolean check = false;
	  
	  while (!check) {
		  check = true;
    
		  for (int j = 1;j < arr.length - 1;j += 2) { //odd pairs
			  if (arr[j] > arr[j+1]) {
				  temp = arr[j];
				  arr[j] = arr[j+1];
				  arr[j+1] = temp;
				  check = false;
			  }
		  }
	  
		  for (int j = 0;j < arr.length - 1;j += 2) { //even pairs
			  if (arr[j] > arr[j+1]) {
				  temp = arr[j];
				  arr[j] = arr[j+1];
				  arr[j+1] = temp;
				  check = false;
			  }
		  }
	  
	  }
	  
  }
  
  public static void main(String[] args){
    int[] arr0 = {};
    System.out.println("The original array is:");
    System.out.println(Arrays.toString(arr0));
    System.out.println("After sorting, the array is:");
    sort(arr0);
    System.out.println(Arrays.toString(arr0) + "\n");
    
    int[] arr1 = {-1, 0, 100, 20, 0, 0, -2, 10, 12};
    System.out.println("The original array is:");
    System.out.println(Arrays.toString(arr1));
    System.out.println("After sorting, the array is:");
    sort(arr1);
    System.out.println(Arrays.toString(arr1) + "\n");
    
    int[] arr2 = {20, 18, 16, 14, 12, 10, 8, 6, 4, 2, 0};
    System.out.println("The original array is:");
    System.out.println(Arrays.toString(arr2));
    System.out.println("After sorting, the array is:");
    sort(arr2);
    System.out.println(Arrays.toString(arr2) + "\n");
    
    int[] arr3 = {3, 4, 0, 5, 9, 20, 15, 14, 17, 24, 56, 0, 0, 1};
    System.out.println("The original array is:");
    System.out.println(Arrays.toString(arr3));
    System.out.println("After sorting, the array is:");
    sort(arr3);
    System.out.println(Arrays.toString(arr3) + "\n");
  }
}