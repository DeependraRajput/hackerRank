package hackerrank;

import java.util.Stack;

public class PrefixToPostfix {
	
	public static void main(String[] args) {
		System.out.println(prefixToPostfix("*+AB-CD"));
	}
	

	private static String prefixToPostfix(String prefix) {

			Stack<String> s = new Stack<String>();
			char[] chArr = prefix.toCharArray();
			for (int i = prefix.length() - 1; i >= 0; i--) {  //Read the characters from the back and keep pushing in the stack.
				char c = chArr[i];
				if (c == '+' || c == '-' || c == '*' || c == '/') { //Whenever reach an operator pop last two strings from stack and reverse the orders.
					s.push(s.pop() + s.pop() + c);
				} else {  //From backward, keep pushing the operands
					s.push(String.valueOf(c));
				}
				System.out.println(s);
			}
		return s.pop();
	}

}
