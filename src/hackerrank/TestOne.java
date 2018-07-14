package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class TestOne {
	
	public static void main(String[] args) {
		
		long t = System.currentTimeMillis();
		
//		int[] numbers = {3, 88, 7, 63, 21, 47, 31, 13, 7};
//		int val = giveRemaining(numbers);
		
//		int[] numbers = {2, 3, 10, 2, 4, 8 , 1};
//		int val = maxDifference(numbers);
		
//		String[] operations = {"push","push","push","pop"};
//		int[] vals = {1,2,3,1}; 
//		
//		long results[] = maxMin(operations, vals);
		
//		String[] words = {"ab", "aab", "abb", "abab", "abaaaaba"};
//		int[] results = minimalOperations(words);
		
		int arr[] = {1, 2, 90, 10, 110, 90, 80, 70};
					
		int result = maxDiff(arr);
		
		t = System.currentTimeMillis() - t;
		System.out.printf("Time taken is : [%d] ms and the value is [%d]\n", t, result); //Arrays.toString(results));
	}
	
	private static int giveRemaining(int[] numbers) {
		int result = 0;
		
		for(int j = 0; j < numbers.length; j++) {
			int[] maxInds = {-1,-1};
			for(int i = 0; i < numbers.length; i++) {
				//Find the index of highest number
				if(maxInds[0] < 0 || numbers[maxInds[0]] < numbers[i]) {
					maxInds[0] = i; 
				}
				//Find the index of second highest number
				if(maxInds[1] < 0 || numbers[maxInds[1]] < numbers[i]) {
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
	
	//Lot of test cases timed out so check the solution.
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
	 * Single iteration max difference
	 * @param arr
	 * @param arr_size
	 * @return
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
	
    // Complete the maxMin function below.
    static long[] maxMin(String[] operations, int[] x) {
    	
    	long[] results = new long[operations.length];
    	
    	List<Integer> list = new ArrayList<Integer>(operations.length);
    	
    	for(int i = 0; i < operations.length; i++) {
    		switch (operations[i]) {
    			case "push": {list.add(x[i]); break;}				
    			case "pop": {list.remove(list.indexOf(x[i])); break;} //Value existence is guaranteed
    			default: break; //This will not occur as per the problem statement.
    		}
    		long min = list.get(0);
    		long max = list.get(0);
    		for(int n: list) {
    			if(min > n) min = n;
    			if(max < n) max = n;
    		}
    		results[i] = min * max;
    	}

    	return results;
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
