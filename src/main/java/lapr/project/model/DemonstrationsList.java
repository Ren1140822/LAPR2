/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a demonstrations list.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class DemonstrationsList {

    /**
     * List of demonstrations.
     */
    private List<Demonstration> demonstrationList;

    /**
     * Creates an instance of DemonstrationsList with its default values.
     */
    public DemonstrationsList() {
        this.demonstrationList = new ArrayList<>();
    }

    /**
     * Creates an instance of DemonstrationsList receiving the list of
     * demonstrations
     *
     * @param demonstrationList list of demonstrations
     */
    public DemonstrationsList(List<Demonstration> demonstrationList) {
        this.demonstrationList = new ArrayList<>(demonstrationList);
    }

    /**
     * Creates an instance of DemonstrationsList copying another demonstrations
     * list.
     *
     * @param demonstrationList another demonstrations list
     */
    public DemonstrationsList(DemonstrationsList demonstrationList) {
        this.demonstrationList = new ArrayList<>(demonstrationList.demonstrationList);
    }

    /**
     * Gets the list of demonstrations.
     *
     * @return list of demonstrations
     */
    public List<Demonstration> getDemonstrationsList() {
        return new ArrayList<>(demonstrationList);
    }

    /**
     * Sets the list of demonstrations.
     *
     * @param demonstrationList list of demonstrations
     */
    public void setDemonstrationsList(List<Demonstration> demonstrationList) {
        this.demonstrationList = new ArrayList<>(demonstrationList);
    }

    /**
     * Gets the list of demonstrations in changed conflicts state
     * 
     * @return list of demonstrations in changed conflicts state
     */
    public List<Demonstration> getDemonstrationsListInChangedConflicts() {
        List<Demonstration> demonstrationsInChangedConflitctsStateList = new ArrayList<>();
        for (Demonstration demonstration : this.demonstrationList) {
            if (demonstration.getCurrentDemonstrationState().isChangedConflicts()) {
                demonstrationsInChangedConflitctsStateList.add(demonstration);
            }
        }
        return demonstrationsInChangedConflitctsStateList;
    }

    /**
     * Create a new demonstration object.
     *
     * @param description associated to the new demonstration
     * @return a new demonstration object
     */
    public Demonstration newDemonstration(String description) {

        return new Demonstration(description);
    }

    /**
     * Add & validate a demonstration to the list.
     *
     * @param demonstration the demonstration to validate
     * @return true if demonstration is sucessfully added.
     */
    public boolean addAndValidateDemonstration(Demonstration demonstration) {

        return (demonstration.validate() && validateDemonstration(demonstration)) ? addDemonstration(demonstration) : false;
    }

    /**
     * Validate if the list doesn't contain a demonstration.
     *
     * @param demonstration the demonstration to validate
     * @return true if list doesn't contain the demonstration
     */
    private boolean validateDemonstration(Demonstration demonstration) {

        return !this.demonstrationList.contains(demonstration);
    }

    /**
     * Add a demonstration to the list.
     *
     * @param demonstration the demonstration to add
     * @return true if demonstration is sucessfully added.
     */
    private boolean addDemonstration(Demonstration demonstration) {

        return this.demonstrationList.add(demonstration);
    }

    /**
     * Verify if a given demonstration is on the demonstration's list.
     *
     * @param demonstration demonstration to be verified
     * @return true if it is contained, false otherwise
     */
    public boolean isDemonstration(Demonstration demonstration) {
        return this.demonstrationList.contains(demonstration);
    }

    /**
     * Return the textual representation of a demonstrations list.
     *
     * @return the textual representation of a demonstrations list
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("DemonstrationList{");
        for (Demonstration demonstration : this.demonstrationList) {
            s.append(String.format("%s%n", demonstration));
        }
        s.append("}");
        return s.toString();
    }

    /**
     * Compares two OrganizersList objects.
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
        DemonstrationsList otherDemonstrationsList = (DemonstrationsList) otherObject;

        return this.demonstrationList.equals(otherDemonstrationsList.demonstrationList);
    }
}
