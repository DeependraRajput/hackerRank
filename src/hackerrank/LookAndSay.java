package hackerrank;

public class LookAndSay {
	
	public static void main(String[] args) {
		
		String text = "122333";
		int count = 5;
		
		while(count --> 0) {
			System.out.println("Count: " + count + " Text: " + text);
			text = lookAndSay(text);
		}
	}
	
	/**
	 * Look the number and say the count of numbers.
	 * @param string
	 * @return
	 */
	private static String lookAndSay(String string) {
		
		if(string == null || string.isEmpty()) return "";
		
		char[] str = string.toCharArray();

		StringBuilder sb = new StringBuilder();
		int charCount = 1; //Initialize the char count as one for the first one.
		char ch = str[0];
		for (int i = 1; i < str.length; i++) {
			//If the same char is repeated then increase char count.
			if (ch == str[i])
				charCount++;
			else {
				//If new character then write the count and the character in result.
				sb.append(charCount).append(ch);
				ch = str[i];
				charCount = 1;
			}
		}
		//Add the last the character and count.
		sb.append(charCount).append(ch);
		return sb.toString();
	}

}
