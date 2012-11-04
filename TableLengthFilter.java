import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class TableLengthFilter implements Filter {

	@Override
	public List<Course> apply(Document d) {
		List<Course> courseList = new LinkedList();
		// System.out.println("Body" + doc.body());
		// System.out.println("head" + doc.head());
		// System.out.println("nodeName" + doc.nodeName())
 		Elements table = d.select("tr");
 		for(Element e : table){
 			if(e.text().length()> 50){
// 				System.out.println("ELEMENT: " + e.text());
	          	Course c = new Course();
	          	c.setDesc(e.text());
	          	courseList.add(c);
 			}
 			
 		}
		System.out.println("--------------------------------------------------");
		return courseList;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		TableLengthFilter filter= new TableLengthFilter();
		HTMLHandler htmlHd = new HTMLHandler();
		ReadTextFile txtHd = new ReadTextFile();
//		System.out.println(doc);
		File htmlDir = new File("html");
		
		for(File f : htmlDir.listFiles()){
			Document doc = HTMLHandler.getHTMLfromFile(f);
			filter.apply(doc);
		}
		
	
		
		
	}
	
}
