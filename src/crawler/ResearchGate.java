package crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import crawler.SearchEngine;

public class ResearchGate {
	
	public static void getRGData(String name){
		String search = name +"+Research+gate";
		System.out.println("I'll Search Bing for :"+search);
		String linkRGProfile = RGProfile(search);
		if(linkRGProfile == null){
			System.out.println("Não foi encontrado um perfil no Research Gate para "+ name);
		}else{
			extractRGData(linkRGProfile);
		}
		
	}
	
	private static void extractRGData(String profile) {
		// TODO Auto-generated method stub
		ArrayList<String> skills = new ArrayList<String>();
		ArrayList<String> keywords = new ArrayList<String>();
		
		
		
		try {
			Document doc = Jsoup
					.connect(profile).get();
			String institution = doc.select(".institution-name").text(); 
			System.out.println("Instituição: ");
			System.out.println("-"+institution);

			// Get Skills and topics
			doc = Jsoup
				.connect(profile+"/info").get();
			
			
			Elements skillsraw = doc.select("div.profile-skills li .ga-keyword-pill"); // a with href
			Elements topicsraw = doc.select("div.keyword-editor-teaser li .ga-keyword-pill"); // a with href
			
			System.out.println("Skills:");
			for (Element element : skillsraw) {
				skills.add(element.text());
			    System.out.println("-"+element.text());
			}
			
			System.out.println("Topics:");
			for (Element element : topicsraw) {
				keywords.add(element.text());
			    System.out.println("-"+element.text());
			}
			
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		
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
					System.out.println(rgProfile);
					return (rgProfile);
				}else{
					rgProfile = link;
					System.out.println(rgProfile);
					return (rgProfile);
				}
			}else{
				
			}
			System.out.println(rgProfile);
			return (rgProfile);
		
			
		}
		return ("0");
		
	}
	
	
}
