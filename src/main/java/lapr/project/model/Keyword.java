/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a KeyWord.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Keyword implements Selectable {

    /**
     * the description of this keyword
     */
    @XmlAttribute
    private String description;

    /**
     * default value of description
     */
    private static final String DEFAULT_DESCRIPTION = "No description";

    /**
     * Empty constructor.
     */
    public Keyword() {
        this.description = DEFAULT_DESCRIPTION;
    }

    /**
     * Constructor with parameters.
     *
     * @param description the keyword to define.
     */
    public Keyword(String description) {
        this.description = new String(description);
    }

    /**
     * Copy constructor receiving another KeyWord instance.
     *
     * @param k the instance of KeyWord to copy.
     */
    public Keyword(Keyword k) {
        this.description = new String(k.description);
    }

    /**
     * gets the string value of description
     */
    public String getDescription() {
        return new String(this.description);
    }

    /**
     * sets the value of description
     *
     * @param description the value to set.
     */
    public void setDescription(String description) {

        this.description = new String(description);
    }

    /**
     * Validates the keyword.
     *
     * @return true if is valid
     */
    public boolean validate() {
        return !this.description.isEmpty();
    }

    /**
     * Equals method to check if two objects are the same.
     *
     * @param otherObject the other object to compare to
     * @return true of equal
     */
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || this.getClass() != otherObject.getClass()) {
            return false;
        }
        Keyword otherKeyword = (Keyword) otherObject;
        return this.description.equals(otherKeyword.description);
    }

    /**
     * Returns the textual interpretation of the objects and attributes of this
     * class
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("KeyWord{");
        s.append(this.description);
        s.append("}");
        return s.toString();
    }

    @Override
    public String getDisplayInfo() {
        return this.getDescription();
    }

}
