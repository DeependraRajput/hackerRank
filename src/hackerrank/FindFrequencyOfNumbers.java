package hackerrank;

public class FindFrequencyOfNumbers {
	
	public static void main(String[] args) {
		System.out.println(frequency("1226#24#"));
	}
	
	private static int[] frequency(String s){
		int[] output = new int[26];
		
		char[] chArr = s.toCharArray();
		int i=0;
		while(i<chArr.length-1) {
			int num = 0;
			int count = 0;
			boolean term = false;
			if((int)chArr[i] < 9) {
				if((int)chArr[i+1] < 9) {
					//num = (10* (int)chArr[i]) 
				}
			}
		}
		
		return output;
	}

}
