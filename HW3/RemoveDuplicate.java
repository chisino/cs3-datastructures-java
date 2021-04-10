/* Author: Artiom Dolghi
 * Due date: Feb 5, 2020
 * Purpose: This program removes adjacent duplicate characters from a string using a stack
 * Credits: I did all of the work independently on my own
 */

import java.util.*;

public class RemoveDuplicate {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String input = keyboard.next();
		
		String result = remove(input);
		
		System.out.print(result);
		
		keyboard.close();
	}
	
	public static String remove(String s) {
		
		Stack<Character> stack = new Stack<Character>();
		
		if (s.length() > 0) {
			char prev = s.charAt(0);
			stack.push(prev);
			for (int i = 1;i < s.length();i++) {
				char cur = s.charAt(i);
				if (cur != prev) {
					stack.push(cur);
					prev = cur;
				} else if (cur == prev) {
					stack.pop();
					if (!stack.isEmpty()) prev = stack.peek();
				}
			}
		}
		
		String result = stack.toString();
		
		result = result.replace("[", "").replace("]", "").replace(",","").replaceAll("\\s","");
		
		return result;
	}
}