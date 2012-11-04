import java.util.ArrayList;
import java.util.List;

/**
 * Class for holding Module structure 
 * @author Manushi
 *
 */
public class Module {
	
	private String name;
	private List<Module> children; 
	
	public Module(String mod) {
		setName(mod);
		children = new ArrayList<Module>();
	}

	public void addChildren(Module child) {
		children.add(child);
	}
	
	public List<Module> getChildren() {
		return children;
	}

	public void setChildren(List<Module> children) {
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
