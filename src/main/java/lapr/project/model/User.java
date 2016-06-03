/**
 * Package location for Model concepts.
 */
package lapr.project.model;

/**
 * Represents a user.
 *
 * @author Daniel Goncalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class User {

    /**
     * The user's name.
     */
    private String name;

    /**
     * The user's username.
     */
    private String username;

    /**
     * The user's email.
     */
    private String email;

    /**
     * The user's password
     */
    // TODO: Implement password encryptation when stored.
    private String password;

    /**
     * The user's name by default.
     */
    private static final String DEFAULT_NAME = "no name";

    /**
     * The user's username by default.
     */
    private static final String DEFAULT_USERNAME = "username";

    /**
     * The user's email by default.
     */
    private static final String DEFAULT_EMAIL = "me@email.com";

    /**
     * The user's password by default.
     */
    private static final String DEFAULT_PASSWORD = "password";

    /**
     * Default constructor of a user class.
     */
    public User() {
        this.name = DEFAULT_NAME;
        this.username = DEFAULT_USERNAME;
        this.email = DEFAULT_EMAIL;
        this.password = DEFAULT_PASSWORD;
    }

    /**
     * Constructor of a user class.
     *
     * @param name user's name
     * @param username user's username
     * @param email user's email
     * @param password user's password
     */
    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    /**
     * Obtain the user's name.
     *
     * @return the user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the user's name.
     *
     * @param name the user's name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtain the user's username.
     *
     * @return the user's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the user's username.
     *
     * @param username the user's username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtain the user's email.
     *
     * @return the user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the user's email.
     *
     * @param email the user's email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtain the user's password.
     *
     * @return the user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the user's name.
     *
     * @param password the user's password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Return the textual representation of a user.
     *
     * @return the textual representation of a user
     */
    @Override
    public String toString() {
        return String.format("User{%nname=%s%nusername=%s%nemail=%s}", this.name, this.username, this.email);
    }
}
