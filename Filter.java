

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import opennlp.tools.util.InvalidFormatException;

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
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 */
	public List<Course> apply(Document d) throws InvalidFormatException, IOException; 
}
