import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class HTMLHandler {
	
	Document html;
	Elements elements;
	
	public HTMLHandler(String site) throws IOException{
		html = Jsoup.connect(site).get();
	}
	
	public HTMLHandler() {
	}
	public void setElementsBy(String className){
		elements = html.getElementsByClass(className);
	}
	
	public Elements getElements(){
		return elements;
	}
	
	public static Document getHTMLfromFile(File aFile) throws FileNotFoundException {
		StringBuilder contents = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader(aFile));
		try {
			String line = null;
			while(( line = br.readLine()) != null ){
				contents.append(line);
			}
		} catch(IOException ex){
			ex.printStackTrace();
		}
		return Jsoup.parse(contents.toString());
	}
}
