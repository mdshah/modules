

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestJsoup {
	public static void main(String[] args) throws IOException {
		
		String site = "http://explorecourses.stanford.edu/CourseSearch/search?view=catalog&filter-coursestatus-Active=on&page=0&catalog=&q=central+menu&collapse=";
		HTMLHandler hl = new HTMLHandler(site);
		hl.setElementsBy("courseInfo");
		hl.printText();

		
		

	}
}
