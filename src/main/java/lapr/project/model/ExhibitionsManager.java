/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.io.Serializable;

/**
 * Represents a exhibitions manager.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ExhibitionsManager implements Actor, Serializable {

    /**
     * The user for the exhibition manager.
     */
    private User user;

    /**
     * Creates an instance of organizer with its default values.
     */
    public ExhibitionsManager() {
        user = new User();
    }

    /**
     * Creates an instance of exhibition manager receiving an user.
     *
     * @param user user the exhibition manager
     */
    public ExhibitionsManager(User user) {
        this.user = user;
    }

    /**
     * Creates an instance of exhibition manager copying another exhibition
     * manager.
     *
     * @param exhibitionsManager another exhibitionsManager
     */
    public ExhibitionsManager(ExhibitionsManager exhibitionsManager) {
        user = new User(exhibitionsManager.user);
    }

    /**
     * Gets the user of the exhibition manager.
     *
     * @return user of the exhibitionsManager
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user of the exposition manager
     *
     * @param user user of the exhibitionManager
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return String.format("ExhibitionManager{%n%s%n}", user);
    }
}
