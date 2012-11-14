package modules.HTMLparsing;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import modules.entities.Course;
import modules.entities.Course.Builder;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class URLGrabberFilter {
	public static void main(String[] args) throws IOException {
		String url="http://www.math.ucla.edu/ugrad/courses/";
		
		List<String> docList = getListOfValidURLs(url);
		System.out.println(docList.size());
		for(String s : docList)
			System.out.println(s);
		

	}

	public static List<String> getListOfValidURLs(String url) throws IOException{
		Document startPageHtml = Jsoup.connect(url).get();
		Elements elements = startPageHtml.select("a[href]");
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

		List<String> docList = new LinkedList<String>();
		for(String s : courseURLs){
			try {
				Document candidatePage;
				candidatePage = Jsoup.connect(s).get();
				docList.add(s);
				// ...
			} catch (UnknownHostException e) {
				System.err.println("Unknown host");
			} catch (HttpStatusException e){
				System.err.println("HttpStatusException");
			}
		}
		return docList;
	}
	public static List<String> getListOfValidURLs(Document startPageHtml) throws IOException{
		Elements elements = startPageHtml.select("a[href]");
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

		List<String> docList = new LinkedList<String>();
		for(String s : courseURLs){
			try {
				Document candidatePage;
				candidatePage = Jsoup.connect(s).get();
				docList.add(s);
				// ...
			} catch (UnknownHostException e) {
				System.err.println("Unknown host");
			} catch (HttpStatusException e){
				System.err.println("HttpStatusException");
			}
		}
		return docList;
	}
	

}
