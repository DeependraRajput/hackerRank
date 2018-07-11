package hackerrank;

import java.util.Arrays;

public class MaxDuplicateNumbers {

	public static void main(String[] args) {

		int[] ar = { 8, 4, 5, 4, 8, 1, 21, 21, 21, 21, 21 };
		int v = maxDuplicates(ar);
		System.out.println(v);

	}

	/**
	 * Find the maximum number of duplicate numbers.
	 * @param numbers
	 * @return
	 */
	private static int maxDuplicates(int[] numbers) {

		if (numbers == null || numbers.length == 0) return 0;

		//Sort the numbers.
		Arrays.sort(numbers);
		
		int maxCount = 1;	//Initialize the largest count of duplicates to one.
		int count = 1;  //Initialize the occurrence count to one.
		for (int i = 1; i < numbers.length; i++) {
			//If the consecutive numbers are difference then reset occurrence count to one.
			if ((numbers[i] == numbers[i - 1])) count++;
			else count = 1;
			
			//If occurrence count is highest then store it.
			if (count > maxCount) maxCount = count;
		}

		return maxCount;
	}

}
