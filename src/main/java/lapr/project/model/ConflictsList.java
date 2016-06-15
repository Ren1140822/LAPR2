/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a conflicts list.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ConflictsList {

    /**
     * List of conflicts users.
     */
    @XmlElementWrapper(name = "conflicts_list")
    @XmlElement(name = "conflict")
    private List<Conflict> conflictsList;

    /**
     * Creates an instance of ConflictsList with its default values.
     */
    public ConflictsList() {
        this.conflictsList = new ArrayList<>();
    }

    /**
     * Creates an instance of ConflictsList receiving the list of conflicts
     *
     * @param conflictsList list of conflicts users
     */
    public ConflictsList(List<Conflict> conflictsList) {
        this.conflictsList = new ArrayList<>(conflictsList);
    }

    /**
     * Creates an instance of ConflictsList copying another conflicts list.
     *
     * @param conflictsList another conflicts list
     */
    public ConflictsList(ConflictsList conflictsList) {
        this.conflictsList = new ArrayList<>(conflictsList.conflictsList);
    }

    /**
     * Gets the list of conflicts.
     *
     * @return list of conflicts
     */
    public List<Conflict> getConflictsList() {
        return new ArrayList<>(conflictsList);
    }

    /**
     * Sets the list of conflicts.
     *
     * @param conflictsList list of conflicts
     */
    public void setConflictsList(List<Conflict> conflictsList) {
        this.conflictsList = new ArrayList<>(conflictsList);
    }

    /**
     * Return the textual representation of a conflicts list.
     *
     * @return the textual representation of a conflicts list
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("ConflictsList{");
        for (Conflict conflict : this.conflictsList) {
            s.append(String.format("%s%n", conflict));
        }
        s.append("}");
        return s.toString();
    }

    /**
     * Compares two ConflictsList objects.
     *
     * @param otherObject Object to compare
     * @return true if the objects are equals.
     */
    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        ConflictsList otherConflictsList = (ConflictsList) otherObject;

        return this.conflictsList.equals(otherConflictsList.conflictsList);
    }
}
