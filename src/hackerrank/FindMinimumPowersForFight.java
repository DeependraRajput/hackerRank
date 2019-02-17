package hackerrank;

import java.util.List;

public class FindMinimumPowersForFight {

	public static void main(String[] args) {

	}
	


	private static int minPowerRequired(List<Integer> powers) {
		int minPower = -1;
		int sum = 0;
		for (Integer i : powers) {
			sum += i;
			if (sum <= 0) {
				minPower += sum;
				sum = 0;
			}
		}
		return 0 - minPower;
	}


}



