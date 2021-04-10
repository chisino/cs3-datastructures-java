/* Author: Artiom Dolghi
 * Due date: April 13, 2020
 * Purpose: The Anagrams class groups anagrams together using a HashMap
 * Credits: I did not work with anybody else on this assignment
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {
	
	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) return false;
		
		Map<Character, Integer> map1 = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			if (!map1.containsKey(c1)) {
				map1.put(c1, 1);
			} else {
				map1.put(c1, map1.get(c1)+1);
			}
		}
		
		Map<Character, Integer> map2 = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			char c2 = t.charAt(i);
			if (!map2.containsKey(c2)) {
				map2.put(c2, 1);
			} else {
				map2.put(c2, map2.get(c2)+1);
			}
		}
		
		return map1.equals(map2);
	}
	
	public static ArrayList<ArrayList<String>> groupAnagrams(String[] strArr) {
        if (strArr.length == 0) return new ArrayList<>();
        
        Map<String, ArrayList<String> > result = new HashMap<String, ArrayList<String> >();
        
        for (String s : strArr) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if (!result.containsKey(key)) {
            	result.put(key, new ArrayList<>());
            }
            result.get(key).add(s);
        }
        return new ArrayList<>(result.values());
    }
	
	public static void main(String[] args) {
		String [] testArr = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		ArrayList<ArrayList<String>> result = groupAnagrams(testArr);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}

	}

}
