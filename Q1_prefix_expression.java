// a prefix expression.
import java.io.*;
import java.util.*;

class prefix_expression {
	static Boolean isOp(char c)
	{
		//Checks if the Operator is a digit
		// if not its a expression
		if (c >= 48 && c <= 57)
			return true;
		else
			return false;
	}
	static double evalPrefix(String val)
	{
	    //creating the stach
		Stack<Double> Stack = new Stack<Double>();
		for (int i = val.length() - 1; i >= 0; i--) {
			// puch to stack
			// subtract 48 to see if the val is a operation or digit
			
			if (isOp(val.charAt(i)))
				Stack.push((double)(val.charAt(i) - 48));
			else {
				// Operator ex:"+ - * /" encountered
				// Pop two elements from Stack
				double num1 = Stack.peek();
				Stack.pop();
				double num2 = Stack.peek();
				Stack.pop();

				// evaluat num1 and num2 using the switch case 
				switch (val.charAt(i)) {
				case '+':
					Stack.push(num1 + num2);
					break;
				case '-':
					Stack.push(num1 - num2);
					break;
				case '*':
					Stack.push(num1 * num2);
					break;
				case '/':
					Stack.push(num1 / num2);
					break;
				}
			}
		}
		return Stack.peek();
	}

	public static void main(String[] args)
	{
	    //input for the prefix
		String val = "+*926";
		//output of the prefix
		System.out.println(evalPrefix(val));
	}
}

