package hackerrank;
/**
 * JAVA program for implementation of KMP pattern searching algorithm.
 * @author Deependra
 *
 */
public class KMPSearch {
	
	public static void main(String args[]) {
		String txt = "ABABDABACDABABCABAB";
		String pat = "ABABCABAB";
		search(pat, txt);
	}
	
	/**
	 * Search pattern in a string using KMP search in O(n+m) complexity.
	 * @param pat
	 * @param txt
	 */
	private static void search(String pat, String txt) {
		
		int M = pat.length();
		int N = txt.length();
		
		if(M>N) throw new IllegalArgumentException("Longer pattern sought in smaler text.");

		// create lps[] that will hold the longest prefix suffix values for pattern
		int lps[] = new int[M];

		// Preprocess the pattern (calculate lps[] array)
		computeLPSArray(pat, M, lps);

		int i = 0; // index for txt[]
		int j = 0; // index for pat[]
		while (i < N) {
			if (pat.charAt(j) == txt.charAt(i)) { 
				j++; i++;
			} else {
				if (j == 0)	i++; else j = lps[j - 1];
			}
			if (j == M) {
				System.out.println("Found pattern " + "at index " + (i - j));
				j = lps[j - 1];
			} 
		}
	}

	/**
	 * Compute the length of the previous longest prefix suffix.
	 * @param pat
	 * @param M
	 * @param lps
	 */
	private static void computeLPSArray(String pat, int M, int lps[]) {

		lps[0] = 0;

		int i = 0, j = 1;
		while (j < M) {
			if (pat.charAt(i) == pat.charAt(j)) {
				lps[j++] = ++i;
			} else {
				if (i == 0) lps[j++] = i; else i = lps[i - 1];
			}
		}
	}
}