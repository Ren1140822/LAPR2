/**
 * Package location for Model concepts.
 */
package lapr.project.model;

/**
 * Represents a demonstration.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Amaral 1151231
 */
public class Demonstration implements Submittable {

    /**
     * the descriptive text of this demonstration
     */
    private String description;

    /**
     * the demonstration's staff list.
     */
    private StaffList staffList;

    /**
     * Demonstration's staff attributions list.
     */
    private StaffAttributionsList staffAttributionsList;
    
    /**
     * The demonstration current state.
     */
    private DemonstrationState currentDemonstrationState;
    
    /**
     * The demonstration applications list
     */
    private ApplicationsList applicationsList;

    /**
     * the default value of the descriptive text ( when using no args
     * constructor)
     */
    private static final String DEFAULT_DESCRIPTION = "No description.";

    /**
     * empty constructor, assigns the default value to attributes
     */
    public Demonstration() {
        this.description = DEFAULT_DESCRIPTION;
    }

    /**
     * builds instance of demonstration with a string as param
     */
    public Demonstration(String descriptiveText) {
        this.description = descriptiveText;
    }

    /**
     * Builds instance of demonstration using another demonstration as copy
     */
    public Demonstration(Demonstration d) {
        this.description = new String(d.description);
    }

    /**
     * returns the current value of the descriptive text
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * sets the current value of the descriptive text
     */
    public void setDescription(String text) {
        this.description = text;
    }

    /**
     * Gets the staff list.
     *
     * @return staff list
     */
    @Override
    public StaffList getStaffList() {
        return staffList;
    }

    /**
     * Sets the staff list.
     *
     * @param staffList staff list
     */
    public void setStaffList(StaffList staffList) {
        this.staffList = staffList;
    }
    
    /**
     * Returns the current demonstration state.
     *
     * @return the actual state of the demonstration
     */
    public DemonstrationState getCurrentDemonstrationState() {
        return this.currentDemonstrationState;
    }

    /**
     * Sets the new demonstration state.
     *
     * @param currentDemonstrationState the new demonstration state
     */
    public void setCurrentDemonstrationState(DemonstrationState currentDemonstrationState) {
        this.currentDemonstrationState = currentDemonstrationState;
    }
    
     /**
     *  Validates the demonstration.
     * 
     * @return true if the description is valid, false otherwise
     */
    boolean validate() {
        return !this.description.isEmpty();
    }

    /**
     * Equals method to check if two objects are the same
     * @param otherObject the demonstration to compare to
     * @return true if equal
     */
    public boolean equals(Object otherObject){
        
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        Demonstration otherDemonstration = (Demonstration)otherObject;
        return (this.description.equals(otherDemonstration.description));
    }
    /**
     * Returns the textual representation of the attributes of this class.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Demonstration{");

        s.append(String.format("%s%n", this.description));

        s.append("}");
        return s.toString();
    }

    /**
     * Returns the staff attribtions list.
     *
     * @return staff attribtions list
     */
    @Override
    public StaffAttributionsList getStaffAttributionsList() {
        return new StaffAttributionsList(this.staffAttributionsList);
    }

    /**
     * Returns the applications list of the demonstration.
     * 
     * @return applications list.
     */
    @Override
    public ApplicationsList getApplicationsList() {
        return new ApplicationsList(this.applicationsList);
    }

}
