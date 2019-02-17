package hackerrank;

public class FindShortestSubStringInCircularString {
	
	/**
	 * Find the minimum length of substring required to build the target string from the source string in a circular pattern.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(shortestCircularSubstring("hackerrank", "krrnh"));

	}
	

    
    static int shortestCircularSubstring(String s, String t) {
    	
    	String test=s+s;
    	StringBuilder sb = new StringBuilder();
    	for(char c: t.toCharArray()) {
    		sb.append(c);
    	}
    	return -1;
    }

}
