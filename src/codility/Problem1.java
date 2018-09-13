package codility;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class Problem1 {
	public static void main(String[] args) {
		int[] numbers = {1, 4,5};
		
		
		int result = solution(numbers);
		System.out.println(result);
	}
	
	
	private static int giveMissing(int[] numbers) {
		
		int n = numbers.length;
		
		boolean flags[] = new boolean[n+1];
		
		for(int i: numbers) {
			if(i <= n && i > 0) flags[i] = true;
		}
		
		int m = n + 1;
		for(int i = 1; i <= n; i++) {
			if(!flags[i]) {m = i; break;}
		}
		return m;
	}
	
	
//	private static int countBets(int n, int k) {
//		
//		//int rounds = 0;
//		//while (k )
//	}
	
	private static int solution(int[] A) {
		
		BigInteger n = BigInteger.ZERO;
		for(int i: A) {
			n = n.setBit(i);
		}
		n = n.multiply(BigInteger.valueOf(3L));
		
		return n.bitCount();
	}

	
}
