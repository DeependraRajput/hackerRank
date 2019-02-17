package hackerrank;

public class MinimumOperations {
	
	/**
	 * Find the number of repeated substrings in the given strings.
	 * @param args
	 */
	public static void main(String[] args) {
		String[] words = {"ab", "aab", "abb", "abab", "abaaaaba"};
		int[] results = minimalOperations(words);
	
	}
	
    //Minimum operations for words no repeated characters. result = [0,1,1,0,2]
    static int[] minimalOperations(String[] words) {
        
        int[] result = new int[words.length];
        
        for(int i = 0; i < words.length; i++) {
        	char pch = '#';
        	result[i] = 0;
            for(char ch: words[i].toCharArray()) {
            	if(pch == ch) {
            		result[i]++;
            		pch = '#';
            	} else {
            		pch = ch;
            	}
            }
        }
                
        return result;
    }

}
