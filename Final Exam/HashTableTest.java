// Artiom Dolghi

import java.util.HashMap;
import java.util.Map;

package Final2020S;

/* Problem 6
 * Try to write a HashTable application client (can either use the Java built-in Hashtable or HashMap class) 
 * to solve the following problem: 
 * Given a stream of inputting integers, 
 * find out and display those elements that appear in the array more than once. 
 * You are supposed to solve this problem in O(N), where N is the number of integers in the stream.
 */

public class HashTableTest {
	public static void checkElements(int[] arr){
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int val: arr) {
			if (map.containsKey(val)) {
				System.out.println(val);
			} else {
				map.put(val, 1);
			}
		}

	}
}
