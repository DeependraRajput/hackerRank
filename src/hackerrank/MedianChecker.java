package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * HackerLand National Bank has a simple policy for warning clients about possible 
 * fraudulent account activity. If the amount spent by a client on a particular day 
 * is greater than or equal to  the client's median spending for a trailing number 
 * of days, they send the client a notification about potential fraud. The bank doesn't 
 * send the client any notifications until they have at least that trailing number of 
 * prior days' transaction data.
 * 
 * Given the number of trailing days  and a client's total daily expenditures for a 
 * period of  days, find and print the number of times the client will receive a 
 * notification over all  days.
 * 
 * For example,  and . On the first three days, they just collect spending data. At day,
 * we have trailing expenditures of . The median is  and the day's expenditure is. Because,
 * there will be a notice. The next day, our trailing expenditures are  and the 
 * expenditures are . This is less than  so no notice will be sent. Over the period,
 * there was one notice sent.
 * 
 * @author Deependra
 *
 */
public class MedianChecker {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int result = 0;
        boolean isEven = (d % 2 == 0);
        int mid = d / 2;
        
        if(expenditure.length > d) {
            for(int i = d, s = 0; i < expenditure.length; i++, s++) {
                Arrays.parallelSort(expenditure, s, i);
                double median = 0;
                if(isEven) {
                    median = (expenditure[s + mid] + expenditure[s + mid + 1]) / 2;
                } else {
                    median = expenditure[s + mid];
                }
                if(expenditure[d] >= 2 * median) result++;
            }   
        }
        
        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
