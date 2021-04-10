import java.util.Scanner;

/* Author: Artiom Dolghi
 * Due date: Jan 21, 2020
 * Purpose: This program computes and displays the amount of money in a bank account
 * 			after a certain amount of years
 * Credits: I did all of the work independently on my own
 */

public class compound_interest {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter the amount of principal: ");
		double principal = keyboard.nextDouble();
		
		System.out.print("Enter the annual interest rate percentage: ");
		double intRate = keyboard.nextDouble() / 100.0; //converting from percent to decimal
		
		System.out.print("Enter the number of times per year that the interest is compounded: ");
		double perYear = keyboard.nextDouble();
		
		System.out.print("Enter the number of years the account will be left to earn interest: ");
		double yearsLeft = keyboard.nextDouble();
		
		keyboard.close();
		
		double amount = principal * Math.pow(1 + (intRate/perYear), perYear * yearsLeft);
		
		System.out.printf("The amount of the money in the account after the specified number of years would be %.2f", amount);
		
	}

}
