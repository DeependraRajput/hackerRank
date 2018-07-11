package hackerrank;

public class ConvertBase {
	
	private static final String CHARSET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static void main(String[] args) {
		long origNum = Long.MAX_VALUE;
		int base = 2;
		String otherBase = convertToBaseString(origNum, base);
		System.out.println("Number in base [" + base + "] is [" + otherBase + "]");
		long backNum = convertFromBaseString(otherBase, base);
		System.out.println("Original number in decimal [" + origNum + "] Converted number in decimal [" + backNum + "]");
		
	}
	
	/**
	 * Convert the long number in decimal to the given base in String type.
	 * @param num
	 * @param base
	 * @return
	 */
	private static String convertToBaseString(long num, int base) {
		checkBase(base);
		StringBuilder sb = new StringBuilder();
		while(num > 0) {
			sb.append(CHARSET.charAt((int)(num % base)));
			num /= base;
		}
		
		return sb.reverse().toString();
	}
	
	/**
	 * Convert the String number in the given base to decimal in long type.
	 * @param numStr
	 * @param base
	 * @return
	 */
	private static long convertFromBaseString(String numStr, int base) {
		checkBase(base);
		
		long result = 0;
		for(char c: numStr.toCharArray()) {
			result = result*base + CHARSET.indexOf(c);
		}
		
		return result;
	}
	
	/**
	 * Check if the base is supported by the given character set.
	 * @param base
	 */
	private static void checkBase(int base) {
		if(base > CHARSET.length()) throw new IllegalArgumentException("Base too large than support");
	}
	
	
	/**
	 * JUST SAMPLE: Approach one to keep result in numeric. 
	 * Caveat is result should not be beyond 2147483647 (Long.MAX_VALUE) and base must be less than 10.
	 * Lower the base, the bigger the result.
	 */
//	private static long convertDecimalToOtherBase(int num, int base) {
//		long result = 0;
//		
//		int p = 0;
//		while(num > 0) {
//			result = (long) ((num % base) * java.lang.Math.pow(10, p++) + result);
//			num /= base;
//		}
//		
//		return result;
//	}

}
