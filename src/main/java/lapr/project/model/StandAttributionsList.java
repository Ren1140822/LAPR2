/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a stand attributions list to store stand attributions.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class StandAttributionsList implements Serializable {

    /**
     * List of stand attributions.
     */
    private List<StandAttribution> standAttributionsList;

    /**
     * Default constructor of a Stand Attributions List class.
     */
    public StandAttributionsList() {
        this.standAttributionsList = new ArrayList<>();
    }

    /**
     * Constructor of a Stand Attributions List class.
     *
     * @param standAttributionsList List of stand attributions
     */
    public StandAttributionsList(List<StandAttribution> standAttributionsList) {
        this.standAttributionsList = new ArrayList<>(standAttributionsList);
    }

    /**
     * Copy Constructor of a StandAttributionsList.
     *
     * @param standAttributionsList StandAttributionsList to copy
     */
    public StandAttributionsList(StandAttributionsList standAttributionsList) {
        this.standAttributionsList = new ArrayList<>(standAttributionsList.getStandAttributionsList());
    }

    /**
     * Obtain the stand attributions list.
     *
     * @return the stand attributions list
     */
    public List<StandAttribution> getStandAttributionsList() {
        return new ArrayList<StandAttribution>(this.standAttributionsList);
    }

    /**
     * Set the stand attributions list.
     *
     * @param standAttributionsList the stand attributions list to set
     */
    public void setStandAttributionsList(List<StandAttribution> standAttributionsList) {
        this.standAttributionsList = new ArrayList<StandAttribution>(standAttributionsList);
    }

    /**
     * Return the textual representation of a standsAttributionsList.
     *
     * @return the textual representation of a standsAttributionsList
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("StandsAttributionsList{");
        for (StandAttribution standAttribution : this.standAttributionsList) {
            s.append(String.format("%s%n", standAttribution));
        }
        s.append("}");
        return s.toString();
    }
}
