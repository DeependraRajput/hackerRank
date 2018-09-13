package hackerrank;

public class SwapCounter {
	public static void main(String[] args) {
		
		int[] arr = {1,3,4,6,7,8,9,2,5};
		long t = System.currentTimeMillis();
		minimumBribes(arr);
		t = System.currentTimeMillis() - t;
		System.out.println("Time taken ["+t+"] ms");
		
	}
	
    // Complete the minimumBribes function below.
    private static void minimumBribes(int[] q) {
        int bribeCount = 0;
        for(int i = 0, j = 1; i < q.length; i++, j++) {
            int bribed = 0;
            if(q[i] > j) {
                bribed= q[i] - j;
            } else if(i < (q.length - 1) && q[i] > q[i+1]) {
                bribed++;
            }
            if(bribed > 2) {
                System.out.println("Too chaotic");
                return;
            } else {
                bribeCount += bribed;
            }
        }
        System.out.println(bribeCount);
    }

}
