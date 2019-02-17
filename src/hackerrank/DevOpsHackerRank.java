package hackerrank;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DevOpsHackerRank {
	
	public static void main(String[] args) {
		
		System.out.println(oddNumbers(3,12));
	}

	/**
	 * Return al odd numbers between the given numbers inclusive.
	 * @param l
	 * @param r
	 * @return
	 */
    static List<Integer> oddNumbers(int l, int r) {
        List<Integer> result = new ArrayList<>();
        for(int i = (l%2!=0?l:l+1); i <= r; i += 2) {
            result.add(Integer.valueOf(i));
        }
        
        return result;
    }
    
    static void test() {
    	int arr[][] = new int[4][];
    	arr[0] = new int[1];
    	arr[1] = new int[2];
    	arr[2] = new int[3];
    	arr[3] = new int[4];
    	
    	int i, j, k=0;
    	for(i=0;i<4;i++) {
    		for(j=0;j<i+1;j++) {
    			arr[i][j] = k;
    			k++;
    		}
    	}
    	
    	for(i=0;i<4;i++) {
    		for(j=0;j<i+1;j++) {
    			System.out.print(" " + arr[i][j]);
    			k++;
    		}
    		System.out.println();
    	}
    }

    static List<String> sortDates(List<String> dates) {
    	DateFormat df = new SimpleDateFormat("dd MMM yyyy");
    	 return dates.stream().map(d->{
			try {
				return df.parse(d);
			} catch (ParseException e) {
				return null;
			}
		}).sorted((d, d2)-> d.compareTo(d2)).map(d->df.format(d)).collect(Collectors.toList());
    	
    }

    public static List<Long> maxMin(List<String> operations, List<Integer> x) {
    	// Write your code here
    	List<Long> product = new ArrayList<Long>();
    	List<Integer> numbers = new ArrayList<Integer>();
    	
    	int l=0;
    	for(int i=0; i< operations.size(); i++) {
    		if("push".equalsIgnoreCase(operations.get(i))) {
    			numbers.add(x.get(i)); l++;
    			product.add((long)(Collections.min(numbers) * (long)Collections.max(numbers)));
    		} else if("pop".equalsIgnoreCase(operations.get(i))) {
    			numbers.remove(l); l--;
    			product.add((long)(Collections.min(numbers) * (long)Collections.max(numbers)));
    		}
    	}
    	
    	return product;
    	

    }

}
