import java.util.Scanner;

/* Author: Artiom Dolghi
 * Due date: Jan 21, 2020
 * Purpose: This program computes and displays the volume for a given ellipsoid
 * Credits: I did all of the work independently on my own
 */

public class ellipsoid_volume {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter the value for the first axis: ");
		double a = keyboard.nextDouble();
		
		System.out.print("Enter the value for the second axis: ");
		double b = keyboard.nextDouble();
		
		System.out.print("Enter the value for the third axis: ");
		double c = keyboard.nextDouble();
		
		keyboard.close();
		
		double volume = (4.0/3.0) * Math.PI * a * b * c;
		
		System.out.printf("The volume of the ellipsoid with axes %.1f, %.1f, and %.1f is %.2f", a, b , c, volume);
		
	}

}
