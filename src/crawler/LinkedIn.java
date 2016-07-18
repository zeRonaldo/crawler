package crawler;

import java.util.Set;
import crawler.SearchEngine;

public class LinkedIn {
	
	public static void getLIData(String name){
		String search = name +"+Linked+In";
		System.out.println("I'll Search Bing for :"+search);
		LIProfile(search);
		
	}
	
	public static String LIProfile(String search){
		//Get the list of links, 
		Set<String> links = SearchEngine.bingit(search);
		
		String liProfile = null;
		
		
		return (liProfile);
		
	}
	
	
}
