/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a demonstration application list
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class DemonstrationApplicationList {

    /**
     * List of applications to a demonstration
     */
    private List<DemonstrationApplication> demonstrationApplicationList;

    /**
     * Creates an instance of DemonstrationApplicationList with its default
     * values.
     */
    public DemonstrationApplicationList() {
        this.demonstrationApplicationList = new ArrayList<>();
    }

    /**
     * Creates an instance of DemonstrationApplicationList receiving the list of
     * applications to a demonstration.
     *
     * @param demonstrationApplicationList list of applications to a
     * demonstration
     */
    public DemonstrationApplicationList(List<DemonstrationApplication> demonstrationApplicationList) {
        this.demonstrationApplicationList = new ArrayList<>(demonstrationApplicationList);
    }

    /**
     * Creates an instance of DemonstrationApplicationList copying another list
     * of applications to a demonstration.
     *
     * @param demonstrationApplicationList list of applications to a
     * demonstration
     */
    public DemonstrationApplicationList(DemonstrationApplicationList demonstrationApplicationList) {
        this.demonstrationApplicationList = demonstrationApplicationList.demonstrationApplicationList;
    }

    /**
     * Gets the list of applications to a demonstration.
     *
     * @return list of applications to a demonstration
     */
    public List<DemonstrationApplication> getDemonstrationApplicationList() {
        return new ArrayList<>(this.demonstrationApplicationList);
    }

    /**
     * Sets the list of applications to a demonstration.
     *
     * @param demonstrationApplicationList list of applications to a
     * demonstration
     */
    public void setDemonstrationApplicationList(List<DemonstrationApplication> demonstrationApplicationList) {
        this.demonstrationApplicationList = new ArrayList<>(demonstrationApplicationList);
    }

    /**
     * Return the textual representation of a DemonstrationApplicationList.
     *
     * @return the textual representation of a DemonstrationApplicationList
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("DemonstrationApplicationList{");
        for (DemonstrationApplication demonstrationApplication : this.demonstrationApplicationList) {
            s.append(String.format("%s%n", demonstrationApplication));
        }
        s.append("}");
        return s.toString();
    }
}
