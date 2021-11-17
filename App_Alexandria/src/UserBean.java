

public class UserBean {
    
	//==================================================================== Properties
    private String username;
    private String password;
    private Boolean admin;


	//==================================================================== Constructors
    public UserBean(String line) {
    	String[] parts = line.split("\t");
    	setPassword(parts[1]);
    	setUsername(parts[0]);
    	if(parts[2].equals("true")) {
    		setAdmin(true);
    	} else {
    		setAdmin(false);
    	}
    }

    public UserBean(String username, String password, boolean admin) {
        setUsername(username);
        setPassword(password);
        setAdmin(admin);
    }

    //==================================================================== Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
    //==================================================================== Methods
    @Override
    public String toString() {
        return "UserBean [username= " + username + ", password= " + password + "]";
    }



}
