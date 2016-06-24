/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a users register to store exhibition managers.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ExhibitionsManagerRegister implements Serializable {

    /**
     * The list of exhibitions managers.
     */
    List<ExhibitionsManager> exhibitionsManagerList;

    /**
     * The default constructor of this class.
     */
    public ExhibitionsManagerRegister() {
        exhibitionsManagerList = new ArrayList<>();
    }

    /**
     * Builds an instance of this class receiving a list of exhibitions manager
     * as parameter.
     *
     * @param exhibitionsManagerList the list of exhibitions manager
     */
    public ExhibitionsManagerRegister(List<ExhibitionsManager> exhibitionsManagerList) {
        this.exhibitionsManagerList = exhibitionsManagerList;
    }

    /**
     * Builds instance of this class receiving another instance of this class as
     * parameter.
     *
     * @param exhibitionsManagerRegister the other instance of this class
     */
    public ExhibitionsManagerRegister(ExhibitionsManagerRegister exhibitionsManagerRegister) {
        exhibitionsManagerList = exhibitionsManagerRegister.exhibitionsManagerList;
    }

    /**
     * Gets the exhibitions Manager list.
     *
     * @return the list of exhibitions manager
     */
    public List<ExhibitionsManager> getExhibitionsManagerList() {
        return exhibitionsManagerList;
    }

}
