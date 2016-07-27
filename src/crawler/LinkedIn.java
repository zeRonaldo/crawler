package crawler;

import java.util.Set;

public class LinkedIn {
	
	public static void getLIData(String name){
		String search = name +"+LinkedIn";
		
		System.out.println("I'll Search Bing for :"+ name);
		LIProfile(search );	
	}
	
	
	public static String LIProfile(String search){
		//Get the list of links, 
		Set<String> links = SearchEngine.bingit(search);
		
		String liProfile = null;
		
		for (String link : links){
			
			if((link.contains("linkedin.com/in/")) /*&& (link.contains("firstname"))*/){
				System.out.println(link);
			}
			
		}
		return ("0");
		
	}
	
	
}
