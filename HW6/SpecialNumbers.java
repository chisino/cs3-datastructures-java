/* Author: Artiom Dolghi
 * Due date: March 3, 2020
 * Purpose: The getSpecialNumbers method returns the amount of special numbers of length n
 * Credits: I did all of the work independently but consulted the slides
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SpecialNumbers {

	public static ArrayList<String> getSpecialNumbers(int n) {
		
		if (n == 0) return new ArrayList<String>(Arrays.asList("")); // base cases
	    if (n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));
	    
	    ArrayList<String> listNums = getSpecialNumbers(n - 2); // recursive call
	    ArrayList<String> result = new ArrayList<String>();
	    
	    for (int i = 0; i < listNums.size(); i++) {
	      String value = listNums.get(i);
	      result.add("1" + value + "1");
	      result.add("6" + value + "9");
	      result.add("8" + value + "8");
	      result.add("9" + value + "6");
	    }
	    
	    return result;
	}
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Please enter the length of the number: ");
		int len = console.nextInt();
		System.out.println(getSpecialNumbers(len));
		console.close();
	}
}
