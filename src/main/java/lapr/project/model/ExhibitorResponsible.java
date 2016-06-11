/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents an exhibitor responsible
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
@XmlRootElement
public class ExhibitorResponsible {

    /**
     * the instance of user in this class
     */
    @XmlElement
    private User user;

    /**
     * Builds instances of ExhibitorResponsible with no params.
     */
    public ExhibitorResponsible() {
        this.user = new User();
    }

    /**
     * Builds instances of ExhibitorResponsible receiving an
     * ExhibitorResponsible as param.
     */
    public ExhibitorResponsible(ExhibitorResponsible exhibitor) {
        this.user = new User(exhibitor.user);
    }

    /**
     * Builds instances of ExhibitorResponsible receiving an user as param.
     */
    public ExhibitorResponsible(User user) {
        this.user = new User(user);
    }

    /**
     * returns this instance of user.
     */
    public User getUser() {
        return this.user;
    }

    /**
     * sets the current value of this user
     */
    
    public void setUSer(User u) {
        this.user = new User(u);
    }

    /**
     * Returns the textual representation of the attributes of this class.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("ExhibitorResponsible{");

        s.append(String.format("%s%n", this.user));

        s.append("}");
        return s.toString();
    }
}
