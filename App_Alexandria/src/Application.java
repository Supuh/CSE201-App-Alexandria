//The base application
import java.util.ArrayList;
public class Application implements Comparable<Application>{

	//==================================================================== Properties
	private String name, description, origin, version, storehl;
	private double price;
	private int likes, platIndex;
	private ArrayList<String> platforms;
	private  int platsize;

	//==================================================================== Constructor
	public Application(String ln) {
		this(ln, false);
	}
	
	public Application(String ln, boolean likeCount) {
		String[] parts = ln.split("\t");
		setName(parts[0]);
		setDescription(parts[1]);
		setOrigin(parts[2]);
		setVersion(parts[3]);
		setStorehl(parts[4]);
		setPrice(Double.parseDouble(parts[5]));
		if (likeCount) {
			setLikes(Integer.parseInt(parts[6]));
			platIndex = 7;
		} else {
			setLikes(0);
			platIndex = 6;
		}
		setPlatforms(new ArrayList<>());
		platsize = 0;
		
//		platforms.add(parts[6]);
		for(int i = platIndex; i < parts.length ; i++) {
			platforms.add(parts[i]);
			platsize++;
		}
	}

	//==================================================================== Methods
	@Override
	public int compareTo(Application o) {
		return name.compareTo(o.name);
	}

	
	public String toString() {
		return (name + " - " + description + " - " + origin + " - " + version + " - " + storehl + " - " + price + " - " + this.platforms);
	}
	
	
	
	
	//==================================================================== Getters and Setters
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
	
	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
		if (this.likes < 0) {
			this.likes = 0;
		}
	}
	
	public ArrayList<String> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(ArrayList<String> platforms) {
		this.platforms = platforms;
		this.platsize = platforms.size();
	}

	public int getPlatsize() {
		return platsize;
	}
}
