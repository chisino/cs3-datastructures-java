/* Author: Artiom Dolghi
 * Due date: Feb 5, 2020
 * Purpose: This program evaluates expressions in the infix format
 * Credits: I did all of the work independently on my own
 */

import java.util.*;

class InfixEvaluator {
  public double evaluateInfix(String s) {
	  
	  Stack<String> valStack = new Stack<String>();
	  Stack<String> oprStack = new Stack<String>();
	  
	  String[] tokens = s.split(" ");
	  
	  for (int i=0; i<tokens.length; i++) {
		  String token = tokens[i];
		  
		  if (!isOperator(token) && token != ("(") && token != ")") {
			  valStack.push(token);
		  } else if (token == "(") {
			  oprStack.push(token);
		  } else if (token == ")") {
			  while (oprStack.peek() != "(") {
				  String operator = oprStack.pop();
				  double operand1 = Double.parseDouble(valStack.pop());
				  double operand2 = Double.parseDouble(valStack.pop());
				  double result = 0;
				  
				  switch (operator) {
					case "+":
						result = operand2 + operand1;
						break;
					case "-":
						result = operand2 - operand1;
						break;
					case "*":
						result = operand2 * operand1;
						break;
					case "/":
						result = operand2 / operand1;
						break;
					case "^":
						result = Math.pow(operand2, operand1);
						break;
					default:
					}
				  
				  valStack.push(Double.toString(result));  
			  } 
			  oprStack.pop();
		  } else if (isOperator(token)) {
			  while (!oprStack.isEmpty() && precedence(oprStack.peek()) >= precedence(token)) {
				  String operator = oprStack.pop();
				  
				  double operand1 = Double.parseDouble(valStack.pop());
				  double operand2 = Double.parseDouble(valStack.pop());
				  double result = 0;
				  
				  switch (operator) {
					case "+":
						result = operand2 + operand1;
						break;
					case "-":
						result = operand2 - operand1;
						break;
					case "*":
						result = operand2 * operand1;
						break;
					case "/":
						result = operand2 / operand1;
						break;
					case "^":
						result = Math.pow(operand2, operand1);
						break;
					default:
					}
				  
				  valStack.push(Double.toString(result)); 
			  }
			  oprStack.push(token);
		  }
	  }
	  return Double.parseDouble(valStack.pop());
  }
  
  static int precedence(String token) {
      switch (token) {
          case "+":
          case "-":
              return 1;
          case "*":
          case "/":
              return 2;
          case "^":
              return 3;
      }
      return -1;
  }
  
  public boolean isOperator(String token) {
      return (token == "+" || token == "-" || token == "/"||token== "/" || token == "/");
  }
  
  public static void main(String[] args) throws Exception {
    InfixEvaluator infix = new InfixEvaluator();
    System.out.print("Please enter an arithmetic expression: ");
    Scanner input = new Scanner(System.in);
    String exp = input.nextLine();
    System.out.println("The result is: " + infix.evaluateInfix(exp));
    input.close();
  }
}