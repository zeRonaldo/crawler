package crawler;

import java.util.Set;
import crawler.SearchEngine;

public class ResearchGate {
	
	public static void getRGData(String name){
		String search = name +"+Research+gate";
		System.out.println("I'll Search Bing for :"+search);
		String linkRGPRofile = RGProfile(search);
		if(linkRGPRofile == null){
			System.out.println("Não foi encontrado um perfil no Research Gate para "+ name);
		}else{
			extractRGData(name);
		}
		
	}
	
	private static void extractRGData(String name) {
		// TODO Auto-generated method stub
		
	}

	public static String RGProfile(String search){
		//Get the list of links, using bing because bing found better results with Research Gate
		Set<String> links = SearchEngine.bingit(search);
		
		String rgProfile = null;
		
		for (String link : links){
			//if there is a link with researchgate.net/profile we got a match
			if(link.contains("researchgate.net/profile")){
				//count how many times / appears if >4 means the link is to a more specific part of the profile and we want the
				//general one wich is "https://researchgate.net/
				int count = 0;
				for( int i=0; i<link.length(); i++ ) {
				    if( link.charAt(i) == '/' ) {
				        count++;
				    } 
				}
				
					
				if (count > 4){
					String[] exploded = link.split("/");
					link= "";
					for(int i = 0; i <= 4; i++){
						link += exploded[i];
						if(i == 0){
							link += "/";
						}else if ((i > 0) && (i <4)){
							link += "/";
						}
					}
					rgProfile = link;
					return (rgProfile);
				}else{
					rgProfile = link;
					return (rgProfile);
				}
			}else{
				
			}
			
			return (rgProfile);
		
			
		}
		return ("0");
		
	}
	
	
}
