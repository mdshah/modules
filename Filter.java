

import java.util.LinkedList;
import java.util.List;

import org.jsoup.nodes.Document;

/**
 * Apply Filters to extract Courses 
 * @author Albert
 *
 */
public interface Filter {
	
	/**
	 * Apply filters based on some criteria
	 * @param d
	 * @return
	 */
	public List<Course> apply(Document d); 
}
