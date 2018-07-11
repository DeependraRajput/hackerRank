package hackerrank;

public class ConvertBase {
	
	public static void main(String[] args) {
		System.out.println(convert(11, 7));
		System.out.println(convertToBaseString(25, 14));
	}
	
	/**
	 * Approach one to keep result in numeric. Caveat is result should not be beyond 2147483647 (Long.MAX_VALUE). and base must be less than 10
	 * Lower the base, the bigger the result.
	 */
	private static long convert(int num, int base) {
		long result = 0;
		
		int p = 0;
		while(num > 0) {
			result = (long) ((num % base) * java.lang.Math.pow(10, p++) + result);
			num /= base;
		}
		
		return result;
	}
	
	/**
	 * Approach two to keep result in string to accommodate any string.
	 * Caveat, the base must be less than the charset defined. Or extend the charset.
	 */
	private static String convertToBaseString(int num, int base) {
		final char[] charset = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		StringBuilder sb = new StringBuilder();
		while(num > 0) {
			sb.append(charset[(int)num % base]);
			num /= base;
		}
		
		return sb.reverse().toString();
	}

}
