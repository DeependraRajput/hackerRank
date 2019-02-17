package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumMinimumProduct {
	
	public static void main(String[] args) {
		
		String[] operations = {"push","push","push","pop"};
		int[] vals = {1,2,3,1}; 
		
		long results[] = maxMin(operations, vals);
		
		System.out.println(Arrays.asList(results));
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

}
