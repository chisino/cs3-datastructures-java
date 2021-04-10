/* Author: Artiom Dolghi
 * Due date: April 13, 2020
 * Purpose: This program finds the number of Chihuahuas from the number of dogs
 * Credits: I did not work with anybody else on this assignment
 */

import java.util.HashMap;
import java.util.Scanner;

public class Chihuahua {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter a non-empty string representing the types of Chihuahua: ");
		String chihuahua = keyboard.next();
		
		System.out.print("Enter a non-empty string representing the types of dogs: ");
		String dogs = keyboard.next();
		
		keyboard.close();
		
		HashMap<Character, Integer> chihuahuasH = new HashMap<>();
		
		for (int i = 0;i < chihuahua.length(); i++) {
			chihuahuasH.put(chihuahua.charAt(i), 1);
		}
		
		int chiSum = 0;
		
		for (int i = 0;i < dogs.length(); i++) {
			if (chihuahuasH.containsKey(dogs.charAt(i))) {
				chiSum += 1;
			}
		}
		
		System.out.println("There are " + chiSum + " chihuahuas");

	}

}
