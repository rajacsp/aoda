package ca.aoda;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ReadWeb {
	
	private static final String STARTING_PAGE = "https://www.playolg.ca/content/olg/en.html";
	
	public static void main(String[] args){		
        String url =    STARTING_PAGE;
        Set<String> set = new LinkedHashSet<String>();
        
        set = getPageLinks(url, set);
        
        for(String link:set){
        	System.out.println(link);
        }
        
        System.out.println(set.size());
	}
	
	private static Set<String> getPageLinks(String url, Set<String> set){
		try {
            Document doc = Jsoup.connect(url).get();
            
            for (Element link : doc.select("a[href]")) {
            	
            	String currentLink = link.attr("href");            	
            	            	
            	if(currentLink.startsWith("/content/") && currentLink.endsWith(".html")){
            		//filteredlinks.add("https://www.playolg.ca"+currentLink);
            		
            		String currentLinkFull = "https://www.playolg.ca"+currentLink;
            		set.add(currentLinkFull);
            		
            		if(!set.contains(currentLinkFull)){
            			//System.out.println(currentLinkFull);            		
            			getPageLinks(currentLinkFull, set);
            		}
            	}
            }
        } catch (IOException e) {
            //e.printStackTrace();
        	System.err.println("Error : "+e.getMessage());
        }
		
		return set;
	}
	
	// find img tab without alt
	
	// W616 The 'language' attribute is obsolete:
	
	// 
}
