// Artiom Dolghi

package Final2020S;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/* Problem 2
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.  An input string is valid if:
 *     Open brackets must be closed by the same type of brackets.
 *     Open brackets must be closed in the correct order.
 *     For example:   input “()[]{}” is valid;  input “([)]” is invalid.
 */

public class ValidParenthesis {
	public static boolean isValid(String s){
		
		Map<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		
		Stack<Character> stack = new Stack<>();
		for (int i = 0;i < s.length();i++) {
			char ch = s.charAt(i);
			if (map.containsKey(ch)) {
				stack.push(ch);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
			}
			
			char target = stack.pop();
			if (!map.containsKey(target) || map.get(target) != ch) {
				return false;
			}
		}
		
		if (!stack.isEmpty()) {
			return false;
		}
		
		return true;

	}
	
	public static void main(String[] args){
		String s = "{{[]}}()";
		System.out.println("Valid?: " + isValid(s));
	}
}
