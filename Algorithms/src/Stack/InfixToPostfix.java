package Stack;

import java.util.Stack;

public class InfixToPostfix {
	public static void main(String a[]) {
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(convertExpressionToPostfix(exp));
	}

	public static String convertExpressionToPostfix(String exp) {
		String result = new String();
		Stack<Character> stack = new Stack<Character>();

		String expression = exp.replaceAll("\\s+", "");

		for (Character ch : expression.toCharArray()) {
			if (Character.isLetterOrDigit(ch))
				result += ch;

			// If the scanned character is an '(', push it to the stack.
			else if (ch == '(')
				stack.push(ch);

			// If the scanned character is an ')', pop and output from the stack
			// until an '(' is encountered.
			else if (ch == ')') {
				while (!stack.isEmpty() && stack.peek() != '(')
					result += stack.pop();

				if (!stack.isEmpty() && stack.peek() != '(')
					return "Invalid Expression"; // invalid expression
				else
					stack.pop();
			} else // an operator is encountered
			{
				while (!stack.isEmpty() && Prec(ch) <= Prec(stack.peek()))
					result += stack.pop();
				stack.push(ch);
			}
		}

		// pop all the operators from the stack
		while (!stack.isEmpty())
			result += stack.pop();

		return result;
	}

	static int Prec(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		}
		return -1;
	}

}
