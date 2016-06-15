/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a conflict types register to store conflict types.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */

public class ConflictTypesRegister {

    /**
     * List of conflict types.
     */
    private List<ConflictType> conflictTypesList;

    /**
     * Default constructor of a ConflictTypesRegister class.
     */
    public ConflictTypesRegister() {

        this.conflictTypesList = new ArrayList<>();
    }

    /**
     * Constructor of a ConflictTypesRegister class.
     *
     * @param conflictTypesList list of conflict types
     */
    public ConflictTypesRegister(List<ConflictType> conflictTypesList) {

        this.conflictTypesList = new ArrayList<>(conflictTypesList);
    }

    /**
     * Copy constructor of a ConflictTypesRegister class.
     *
     * @param conflictTypesRegister ConflictTypesRegister to copy
     */
    public ConflictTypesRegister(ConflictTypesRegister conflictTypesRegister) {

        this.conflictTypesList = new ArrayList<>(conflictTypesRegister.conflictTypesList);
    }

    /**
     * Obtain the conflict types list.
     *
     * @return the conflict types list
     */
    public List<ConflictType> getConflictTypesList() {
        return new ArrayList<>(this.conflictTypesList);
    }

    /**
     * Set the conflict types list.
     *
     * @param conflictTypesList the conflict types list to set
     */
    
  
    public void setConflictTypesList(List<ConflictType> conflictTypesList) {
        this.conflictTypesList = new ArrayList<>(conflictTypesList);
    }

    /**
     * Return the textual representation of a conflictTypesRegister.
     *
     * @return the textual representation of a conflictTypesRegister
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("ConflictTypesRegister{");
        for (ConflictType conflictType : this.conflictTypesList) {
            s.append(String.format("%s%n", conflictType));
        }
        s.append("}");
        return s.toString();
    }
}
