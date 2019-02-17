package hackerrank;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReformateDates {

	public static void main(String[] args) {
		List<String> dates = Arrays.asList("14 Dec 2017", "2 Aug 2018", "3 Feb 2015");
		System.out.println(reformatDatesSort(dates));
		
		List<String> dates2 = Arrays.asList("14th Dec 2017", "2nd Aug 2018", "3rd Feb 2015");
		System.out.println(reformatDates(dates2));

	}

	/**
	 * Reform dates from 14th Dec 2018 to 2018-12-14.
	 * 
	 * @param dates
	 * @return
	 */
	private static List<String> reformatDates(List<String> dates) {
		DateFormat sdfInput = new SimpleDateFormat("dd MMM yyyy");
		DateFormat sdfOutput = new SimpleDateFormat("yyyy-MM-dd");
		return dates.stream().map(d -> {
			try {
				String t = d.replaceFirst("[a-z]{2}", ""); //Replace 14th to 14
				return sdfOutput.format(sdfInput.parse(t));
			} catch (ParseException e) {
				return null;
			}
		})
		.collect(Collectors.toList());
	}
	
	/**
	 * Reform dates from 14 Dec 2018 to 2018-12-14 and sort the list by chronological order.
	 * 
	 * @param dates
	 * @return
	 */
	private static List<String> reformatDatesSort(List<String> dates) {
		DateFormat sdfInput = new SimpleDateFormat("dd MMM yyyy");
		DateFormat sdfOutput = new SimpleDateFormat("yyyy-MM-dd");
		return dates.stream().map(d -> {
			try {
				return sdfInput.parse(d);  //Parse the strings to dates.
			} catch (ParseException e) {
				return null;
			}
		})
		.sorted((d1, d2) -> d1.compareTo(d2))	//Sort the dates in chronological ascending order.
		.map(d -> sdfOutput.format(d)) 	//Re-format the dates to output format.
		.collect(Collectors.toList());
	}

}
