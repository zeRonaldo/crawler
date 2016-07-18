package crawler;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SearchEngine {

  private static Pattern patternDomainName;
  private Matcher matcher;
  private static final String DOMAIN_NAME_PATTERN 
	= "([a-zA-Z0-9]([a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,6}";
  static {
	patternDomainName = Pattern.compile(DOMAIN_NAME_PATTERN);
  }
  
  public static Set<String> bingit(String name){

		SearchEngine obj = new SearchEngine();
		Set<String> result = obj.getDataFromBing(name);
		
		
		return result;
  }
	
  public static Set<String> googleIt(String name) {

	SearchEngine obj = new SearchEngine();
	Set<String> result = obj.getDataFromGoogle(name);
	for(String temp : result){
		System.out.println(temp);
	}
	System.out.println(result.size());
	return result;
  }

  public String getDomainName(String url){
		
	String domainName = "";
	matcher = patternDomainName.matcher(url);
	if (matcher.find()) {
		domainName = matcher.group(0).toLowerCase().trim();
	}
	return domainName;
		
  }
	
  private Set<String> getDataFromGoogle(String query) {
		
	Set<String> result = new HashSet<String>();	
	String request = "https://www.google.com/search?q=" + query + "&num=20";
	System.out.println("Sending request..." + request);
		
	try {

		// need http protocol, set this as a Google bot agent :)
		Document doc = Jsoup
			.connect(request)
			.userAgent(
			  "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)")
			.timeout(5000).get();

		// get all links
		Elements links = doc.select("a[href]");
		for (Element link : links) {

			String temp = link.attr("href");		
			if(temp.startsWith("/url?q=")){
                                //use regex to get domain name
				result.add(temp);
			}

		}

	} catch (IOException e) {
		e.printStackTrace();
	}
		
	return result;
  }

  private Set<String> getDataFromBing(String query) {
		
		Set<String> result = new HashSet<String>();	
		String request = "https://www.bing.com/search?q=" + query ;
		System.out.println("Sending request..." + request);
			
		try {

			Document doc = Jsoup.connect(request).get();
			//System.out.println(doc.toString());
			// get all links
			Elements links = doc.select("a[href]");
			for (Element link : links) {

				String temp = link.attr("href");		
				if(temp.startsWith("http")){
	                                //use regex to get domain name
					if(temp.startsWith("http://go.microsoft.com")){
						
					}else{
						result.add(temp);
					}
				}

			}
			

		} catch (IOException e) {
			e.printStackTrace();
		}
			
		return result;
	  }

}