import java.util.LinkedList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class TableLengthFilter implements Filter {

	@Override
	public List<Course> apply(Document d) {
		List<Course> courseList = new LinkedList<Course>();
	
 		System.out.println("URL: " + u.getUrl());
		System.out.println("Title" + doc.title());
		// System.out.println("Body" + doc.body());
		// System.out.println("head" + doc.head());
		// System.out.println("nodeName" + doc.nodeName());
 		Elements links = doc.select("a[href]");
// 		Elements media = doc.select("[src]");
// 		Elements imports = doc.select("link[href]");
//		 print("\nMedia: (%d)", media.size());
//         for (Element src : media) {
//             if (src.tagName().equals("img"))
//                 print(" * %s: <%s> %sx%s (%s)",
//                         src.tagName(), src.attr("abs:src"), src.attr("width"), src.attr("height"),
//                         trim(src.attr("alt"), 20));
//             else
//                 print(" * %s: <%s>", src.tagName(), src.attr("abs:src"));
//         }

  //       print("\nImports: (%d)", imports.size());
  //       for (Element link : imports) {
  //           print(" * %s <%s> (%s)", link.tagName(),link.attr("abs:href"), link.attr("rel"));
  //       }
//
//   		print("\nLinks: (%d)", links.size());
//		 for (Element link : links) {
//		     print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
//		 }
		System.out.println("--------------------------------------------------");
		return courseList;
	}
	
}
