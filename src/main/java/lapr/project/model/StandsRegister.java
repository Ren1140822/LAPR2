/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a stands register to store stands.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Amaral 1151231
 */

public class StandsRegister {

    /**
     * List of stands.
     */
    private List<Stand> standsList;

    /**
     * Default constructor of a StandsRegister class.
     */
    public StandsRegister() {

        this.standsList = new ArrayList<>();
    }

    /**
     * Constructor of a StandsRegister class.
     *
     * @param standsList list of stands
     */
    public StandsRegister(List<Stand> standsList) {

        this.standsList = new ArrayList<>(standsList);
    }

    /**
     * Copy constructor of a StandsRegister class.
     *
     * @param standsRegister StandsRegister to copy
     */
    public StandsRegister(StandsRegister standsRegister) {

        this.standsList = new ArrayList<>(standsRegister.getStandsList());
    }

    /**
     * Obtain the stands list.
     *
     * @return the stands list
     */
    public List<Stand> getStandsList() {
        return new ArrayList<>(this.standsList);
    }

    /**
     * Set the stands list.
     *
     * @param standsList the stands list to set
     */
    
  
    public void setStandsList(List<Stand> standsList) {
        this.standsList = new ArrayList<>(standsList);
    }

    /**
     * Return the textual representation of a standsRegister.
     *
     * @return the textual representation of a standsRegister
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("StandsRegister{");
        for (Stand stand : this.standsList) {
            s.append(String.format("%s%n", stand));
        }
        s.append("}");
        return s.toString();
    }
}
