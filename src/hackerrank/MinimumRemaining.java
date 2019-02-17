package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumRemaining {

	public static void main(String[] args) {
		
		Integer[] numbers = {3, 88, 7, 63, 21, 47, 31, 13, 7};
		int val = minRemaining(Arrays.asList(numbers));
	}
	
	//The expected answer in hacker-rank but times out for 3 test large test cases.
	private static int minRemaining(List<Integer> a) {
		
		int l = a.size()-1;
		int sl = l -1;
		for(int i = 0; i < a.size(); i++) {
			System.out.println(a);
			Collections.sort(a);
			int diff = a.get(l) - a.get(sl);
			a.set(l, diff);
			a.set(sl, 0);
		}
		return a.get(l);
	}
	
	private static int giveRemaining(int[] n) {
		
		List<Integer> a = new ArrayList<Integer>();
		Integer[] numbers = new Integer[a.size()];
		a.toArray(numbers);
		
		int result = 0;
		
		for(int j = 0; j < numbers.length; j++) {
			int[] maxInds = {-1,-1};
			for(int i = 0; i < numbers.length; i++) {
				//Find the index of highest number
				if(maxInds[0] < 0 || numbers[maxInds[0]] < numbers[i].intValue()) {
					maxInds[0] = i; 
				}
				//Find the index of second highest number
				if(maxInds[1] < 0 || numbers[maxInds[1]] < numbers[i].intValue()) {
					if(i != maxInds[0]) {
						maxInds[1] = i; 
					}
				}
			}
			numbers[maxInds[0]] = numbers[maxInds[0]] - numbers[maxInds[1]];
			numbers[maxInds[1]] = 0;
		}
		
		return result;
		
	}
}
