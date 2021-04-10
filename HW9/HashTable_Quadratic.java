/* Author: Artiom Dolghi
 * Due date: April 13, 2020
 * Purpose: The HashTable_Quadratic class is an implementation of a HashTable using strings
 * Credits: I did not work with anybody else on this assignment
 */

import java.io.*;
import java.util.*;

public class HashTable_Quadratic {
 private String[] hashArray; // array holds hash table
 private int arraySize;
 
 // -------------------------------------------------------------
 public HashTable_Quadratic(int size)       // constructor
   {
  arraySize = size;
  hashArray = new String[arraySize];
   }

 // -------------------------------------------------------------
 public void displayTable() {
  System.out.print("Table: ");
  for (int j = 0; j < arraySize; j++) {
   if (hashArray[j] != null)
    System.out.print(hashArray[j] + " ");
   else
    System.out.print("** ");
  }
  System.out.println("");
 }

 // -------------------------------------------------------------
 public int hashFunc(String key) {
	 
	 int sum = 0;
	 
	 for (int i = 0; i < key.length(); i++) {
		 sum += (int) key.charAt(i);
	 }
	 
     return sum % arraySize;
 }

 // -------------------------------------------------------------
 public void insert(String item) // insert a DataItem
 // (assumes table not full)
 {  
     int tmp = hashFunc(item);
     int i = tmp, h = 1;
     
     do
     {
         if (hashArray[i] == null)
         {
        	 hashArray[i] = item;
             return;
         } 
         i = (i + h * h++) % arraySize;            
     } while (i != tmp);       
 } // end insert()
  // -------------------------------------------------------------

 public String delete(String key) // delete a DataItem
 { 
	 for (int i = 0; i < hashArray.length; i++) {
		 if (hashArray[i] == key) {
			 String result = hashArray[i];
			 
			 hashArray[i] = null;
			 
			 return result;
		 }
	 }
	 
	 return null;
  
 } // end delete()
  // -------------------------------------------------------------

 public String find(String key) // find item with key
 { 
	 for (int i = 0; i < hashArray.length; i++) {
		 if (hashArray[i] == key) {
			 return hashArray[i];
		 }
	 }
	 
	 return null;
 }
 
 // -------------------------------------------------------------
 // end class HashTable
 
   public static void main(String[] args) throws IOException {
    int aKey, size, n, keysPerCell;
          
    //get the size of the HashTable
    Scanner console = new Scanner(System.in);
    System.out.print("Enter size of hash table: ");
    size = console.nextInt();
    
          //make the table
    HashTable_Quadratic table = new HashTable_Quadratic(size);
    table.insert("apple");
    table.insert("book");
    table.insert("car");
    table.insert("dog");
    table.insert("egg");
    table.insert("fish");
    table.insert("giraff");
    table.insert("horse");
    table.insert("ice");
    table.insert("jungle");
    
    // display the table
    table.displayTable();
   }
}