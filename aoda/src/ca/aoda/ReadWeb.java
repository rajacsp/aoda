package ca.aoda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ReadWeb {
	
	public static void main(String[] args){
		String title = "dog";
        String url =    "https://www.playolg.ca/content/olg/en/getting-started/whyplayolg.html";
        try {
            Document doc = Jsoup.connect(url).get();
            
            /*
            Elements img = doc.getElementsByTag("a");

            for (Element el : img) {
                String src1 = el.absUrl("imgurl");
                String src2 = el.absUrl("surl");
                System.out.println(src1 + " " + src2);      
            }
            */            
            //System.out.println(doc);
            
            List<String> links = new ArrayList<>();
            List<String> filteredlinks = new ArrayList<>();
            
            for (Element link : doc.select("a[href]")) {
                //System.out.println(link.attr("href"));
            	
            	String currentLink = link.attr("href"); 
            	
            	links.add(currentLink);            	
            	if(currentLink.startsWith("/content/") && currentLink.endsWith(".html")){
            		filteredlinks.add("https://www.playolg.ca"+currentLink);
            	}
            }
            
            
            for(String link:filteredlinks){
            	System.out.println(link);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
