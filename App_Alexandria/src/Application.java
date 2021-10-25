//The base application
import java.util.ArrayList;
public class Application implements Comparable<Application>{

	private String name, description, origin, version, storehl;
	private double price;
	private ArrayList<String> platforms;
	private  int platsize;

	/////////////////////////////Platforms is an issue
	//Constructor You will need everything for it to work except for platforms
	public Application(String ln) {
		String[] parts = ln.split("\t");
		setName(parts[0]);
		setDescription(parts[1]);
		setOrigin(parts[2]);
		setVersion(parts[3]);
		setStorehl(parts[4]);
		setPrice(Double.parseDouble(parts[5]));
		setPlatforms(new ArrayList<>());
		setPlatsize(0);
		
//		platforms.add(parts[6]);
		for(int i = 6; i < parts.length ; i++) {
			platforms.add(parts[i]);
			platsize++;
		}
	}

	@Override
	public int compareTo(Application o) {
		return name.compareTo(o.name);
	}

	
	public String toString() {
		return (name + " - " + description + " - " + origin + " - " + version + " - " + storehl + " - " + price + " - " + this.platforms);
	}
	
	
	
	
	///////Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getStorehl() {
		return storehl;
	}

	public void setStorehl(String storehl) {
		this.storehl = storehl;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public ArrayList<String> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(ArrayList<String> platforms) {
		this.platforms = platforms;
	}

	public int getPlatsize() {
		return platsize;
	}

	public void setPlatsize(int platsize) {
		this.platsize = platsize;
	}
}
