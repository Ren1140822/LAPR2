/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a resource
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */

public class Resource {

    /**
     * The Resource's designation.
     */
    private String designation;

    /**
     * The Resource's designation by default.
     */
    private static final String DEFAULT_DESIGNATION = "no designation";

    /**
     * Default constructor of a Product class.
     */
    public Resource() {
        this.designation = DEFAULT_DESIGNATION;
    }

    /**
     * Constructor that receives an instance of this class as parameter.
     *
     * @param designation Resource's designation
     */
    public Resource(String designation) {
        this.designation = designation;
    }

    /**
     * Obtain the Resource's designation.
     *
     * @return the Resource's designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Sets the Resource's designation.
     *
     * @param designation the Resource's designation to set
     */
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return String.format("Resource{%ndesignation=%s%n", this.designation);
    }
}
