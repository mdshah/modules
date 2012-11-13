package modules.HTMLparsing;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class URLGrabberFilter {
	public static void main(String[] args) throws IOException {
		String url="http://www.math.ucla.edu/ugrad/courses/";
		Document html = Jsoup.connect(url).get();
		Elements elements = html.select("a[href]");
		Set<String> courseURLs = new HashSet<String>();
		Pattern p = Pattern.compile(".",Pattern.CASE_INSENSITIVE);
		//		Matcher matcher = p.mat
		Set<String> ignoreTerms = new HashSet<String>();
		ignoreTerms.add("mailto");
		ignoreTerms.add("#");
		ignoreTerms.add("#top");

		for(Element e : elements) {
			String courseURL = e.attr("abs:href").toLowerCase();

			//use only urls that has course in it
			boolean pass = true;
			item: for(String ignore : ignoreTerms) {
				if(courseURL.contains(ignore)){
					pass=false;
					break item;
				}					
			}
			if(pass && courseURL.contains("course"))
				courseURLs.add(courseURL);


		}

		int count=0;
		for(String cUrl : courseURLs){
			System.out.println(cUrl);
		}
	}
}
