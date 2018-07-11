package hackerrank;

import java.util.Arrays;
import java.util.List;

public class SortAsBinary {
	
	public static void main(String[] args) {
		List<Integer> input = Arrays.asList(1, 5, 76, 3, 2, 4, 8, 15, 31, 63, 3 , 7, 9);
		
		System.out.println(rearrange(input));
	}
	
	private static List<Integer> rearrange(List<Integer> elements) {

		elements.sort((i1, i2) -> {
			if(i1 == null && i2 == null) return 0;
			
			if(i1 == null) i1 = 0;
			if(i2 == null) i2 = 0;
			
			int one1 = countMethodOne(i1);	//Alternatively using first method
			int one2 = countMethodTwo(i2);	//Alternatively using second method
			
			return (one1 == one2)? i1-i2: one1-one2;
		});

		return elements;
		
    }
	
	/**
	 * First method. Takes ~20000 ms on Long.MAX_VALUE for 100_000_000 times
	 * @param s
	 * @return
	 */
	private static int countMethodOne(long n) {
		String s = Long.toBinaryString(n);
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
		    if (s.charAt(i) == '1') {
		        count++;
		    }
		}
		return count;
	}
	
	/**
	 * Second method. Takes ~28000 ms on Long.MAX_VALUE for 100_000_000 times
	 * @param s
	 * @return
	 */
	private static int countMethodTwo(long n) {
		int count = 0;
		while(n > 0) {
			count+=n%2;
			n/=2;
		}
		return count;
	}

}
