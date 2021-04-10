/* Author: Artiom Dolghi
 * Due date: March 3, 2020
 * Purpose: The getStrings method returns all combinations of length k from a given set
 * Credits: I did all of the work independently - I looked at my SpecialNumbers code as well
 * 			as doing some algorithmic research for inspiration
 */

import java.util.*;

public class StringConstruction {
  public static ArrayList<String> getStrings(char[] chars, int k) {
	  return getStringsHelper(chars, "", k); 
  }
  
  public static ArrayList<String> getStringsHelper(char[] chars, String prefix, int k) {
	  
	  ArrayList<String> result = new ArrayList<String>();
	  
	  if (k == 0) {
		  System.out.println(prefix);
		  return new ArrayList<String>(Arrays.asList(""));
	  }
	  
	  for (int i = 0;i < chars.length;i++) {
		  String prefix2 = prefix + chars[i];
		  getStringsHelper(chars, prefix2, k-1); 
	  }
	  
	  return result;
  }
  
  public static void main(String[] args) {
    char[] chars = {'a', 'b'};
    int k = 3;
    
    ArrayList<String> result = getStrings(chars, k);
    
    for (int i = 0;i < result.size();i++) {
    	System.out.print(result.get(i));
    }
    
  }
}