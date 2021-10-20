

/**
 * Functional interface of UserBean
 */
public interface UserDao {

    /**
     * User login method
     * Return true if login is successful, false if login fails
     */
    public abstract boolean isLognUser(UserBean user);

    /**
     * User registration method
     *
     * @param user
     * @return boolean Return true if registration is successful, false if registration fails
     */
    public abstract boolean registerUser(UserBean user);

}
