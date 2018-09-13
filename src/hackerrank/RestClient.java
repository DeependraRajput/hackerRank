package hackerrank;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RestClient {
	
	   public static void main(String[] args) throws IOException{
//	        Scanner in = new Scanner(System.in);
//	        final String fileName = System.getenv("OUTPUT_PATH");
//	        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
//	        String[] res;
//	        String _substr;
//	        try {
//	            _substr = in.nextLine();
//	        } catch (Exception e) {
//	            _substr = null;
//	        }
		   
		   String _substr = "spiderman";
		   
	        
	        String[] res = getMovieTitles(_substr);
	        for(int res_i=0; res_i < res.length; res_i++) {
	            System.out.println(String.valueOf(res[res_i]));
	        }
	    }

	/*
	 * Complete the function below.
	 */
	
	static String[] getMovieTitles(String substr) {
		
		List<String> allTitles = new ArrayList<String>();
		
		try {
			MovieServiceReponse response = getMovieDetails(substr, null);
			
			response.getData().forEach(s->allTitles.add(s.getTitle()));
			int pageToFetch = response.total_pages + 1;
				while (pageToFetch --> 2) {
					response = getMovieDetails(substr, pageToFetch);
					response.getData().forEach(s->allTitles.add(s.getTitle()));
				}
		} catch (Exception e) {
		}
		
		if(!allTitles.isEmpty()) Collections.sort(allTitles);
	
		String[] result = new String[allTitles.size()];
		result = allTitles.toArray(result);
		return result;
	}
	
	private static MovieServiceReponse getMovieDetails(String title, Integer pageNumber) throws Exception {
	
		String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + title;
		
		if(pageNumber != null) {
			url = url + "&page=" + pageNumber;
		}
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
	
		int responseCode = con.getResponseCode();
		MovieServiceReponse response = null;
		if(responseCode == 200) {
			InputStreamReader in = new InputStreamReader(con.getInputStream());
			//response = //new Gson().fromJson(in, MovieServiceReponse.class);
			//in.close();
		}
		return response;
	}
	
	static class MovieServiceReponse {
		private int page;
		private int per_page;
		private int total;
		private int total_pages;
		private List<MovieDetails> data;
		public int getPage() {
			return page;
		}
		public void setPage(int page) {
			this.page = page;
		}
		public int getPer_page() {
			return per_page;
		}
		public void setPer_page(int per_page) {
			this.per_page = per_page;
		}
		public int getTotal() {
			return total;
		}
		public void setTotal(int total) {
			this.total = total;
		}
		public int getTotal_pages() {
			return total_pages;
		}
		public void setTotal_pages(int total_pages) {
			this.total_pages = total_pages;
		}
		public List<MovieDetails> getData() {
			return data;
		}
		public void setData(List<MovieDetails> data) {
			this.data = data;
		}
	}
	
	static class MovieDetails {
	    private String Poster;
	    private String Title;
	    private String Type;
	    private int Year;
	    private String imdbID;
		public String getPoster() {
			return Poster;
		}
		public void setPoster(String poster) {
			Poster = poster;
		}
		public String getTitle() {
			return Title;
		}
		public void setTitle(String title) {
			Title = title;
		}
		public String getType() {
			return Type;
		}
		public void setType(String type) {
			Type = type;
		}
		public int getYear() {
			return Year;
		}
		public void setYear(int year) {
			Year = year;
		}
		public String getImdbID() {
			return imdbID;
		}
		public void setImdbID(String imdbID) {
			this.imdbID = imdbID;
		}
	}



}
