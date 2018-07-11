package hackerrank;

import java.util.Arrays;

public class CountDuplicates {
	
	public static void main(String[] args) {

		int[] ar = { 4, 3, -1, -1 ,2,3,4};
		long a = System.currentTimeMillis();
		int v = countDuplicates(ar);
		a = System.currentTimeMillis() - a;
		System.out.println("Time taken: " + a + " ms and value is :" + v);
	}
	
	/**
	 * Count the number of duplicates in the array.
	 * @param numbers
	 * @return
	 */
	private static int countDuplicates(int[] numbers) {

		if (numbers.length == 0)
			return 0;

		Arrays.sort(numbers);

		int dupCount = 0;
		boolean dupContinued = false;
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] == numbers[i-1]) {
				if (!dupContinued) {
					dupCount++;
					dupContinued = true;
				}
			} else dupContinued = false;
		}

		return dupCount;
	}

}
