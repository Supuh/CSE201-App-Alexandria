

public class UserBean {
    
	//==================================================================== Properties
    private String username;
    private String password;

    //==================================================================== Constructors
    public UserBean(String line) {
    	String[] parts = line.split("\t");
    	setPassword(parts[1]);
    	setUsername(parts[0]);
    }

    public UserBean(String username, String password) {
        setUsername(username);
        setPassword(password);
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

    //==================================================================== Methods
    @Override
    public String toString() {
        return "UserBean [username= " + username + ", password= " + password + "]";
    }



}
