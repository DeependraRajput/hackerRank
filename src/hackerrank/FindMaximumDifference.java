package hackerrank;

public class FindMaximumDifference {
	
	/**
	 * Find maximum difference of pairs in an unsorted array of integers where the larger number is on higher index.
	 * Return -1 if no such pair.
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = {1, 2, 90, 10, 110, 90, 80, 70};
		
		int result = maxDiff(arr);
	}
	
	/**
	 * O(n^2) time complexity. expected answer
	 */
	private static int maxDifference(int[] a) {
		int result = -1;
		
		for(int i = 0; i < a.length - 1; i++) {
			for(int j = i + 1; j < a.length; j++) {
				int d = a[j] - a[i];
				if(d > result) result = d;
			}
		}
		return result;

    }
	
	/**
	 * O(n) time complexity - Single iteration max difference
	 */
	private static int maxDiff(int arr[]) {
		int maxDiff = arr[1] - arr[0];
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			int d = arr[i] - min;
			if(d > maxDiff) maxDiff = d;
			
			if (arr[i] < maxDiff) min = arr[i];
		}
		
		if(maxDiff < 0) maxDiff = -1;
		
		return maxDiff;
	}

}
