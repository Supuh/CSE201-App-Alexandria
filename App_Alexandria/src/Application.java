//The base application
public class Application implements Comparable<Application>{

	private String name, description, origin, version, storehl;
	private double price;


	/////////////////////////////Platforms is an issue
	//Constructor
	public Application(String ln) {
		String[] parts = ln.split("\t");
		setName(parts[0]);
		setDescription(parts[1]);
		setOrigin(parts[2]);
		//setPlatform(parts[6]);
		setVersion(parts[3]);
		setStorehl(parts[4]);
		///////double lol
		setPrice(Integer.parseInt(parts[5]));
	}
	
	@Override
	public int compareTo(Application o) {
		// TODO Auto-generated method stub
		return name.compareTo(o.name);
	}

	
	public String toString() {
		return (name + " - " + description + " - " + origin + " - " + version + " - " + storehl + " - " + price + " - " + "Platforms");
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
}
