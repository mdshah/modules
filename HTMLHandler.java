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
	
	public void setElementsBy(String className){
		elements = html.getElementsByClass(className);
	}
	
	public Elements getElements(){
		return elements;
	}
	public void printText(){
		for(Element courseInfo : elements) {
			Course course = new Course();
			course.setDesc(courseInfo.text());
			System.out.println("Text:" + courseInfo.text());
		}
	}
	
}
