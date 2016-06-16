/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Represents a demonstration.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Demonstration implements Submittable {

    /**
     * Unique demoonstration ID.
     */
    @XmlAttribute
    private final String demonstrationID;

    /**
     * The title of the demonstration.
     */
    private String title;

    /**
     * The descriptive text of this demonstration.
     */
    private String description;

    /**
     * The place for the demonstration.
     */
    private Place place;

    /**
     * The demonstration's staff list.
     */
//    @XmlElementWrapper(name = "staff_list")
    private StaffList staffList;

    /**
     * Exhibition's organizers list.
     */
//    @XmlElementWrapper(name = "organizers_list")
    private OrganizersList organizersList;

    /**
     * The demonstration applications list
     */
//    @XmlElementWrapper(name = "applications_list")
    private ApplicationsList applicationsList;

    /**
     * The resources list.
     */
    @XmlElementWrapper(name = "resources_list")
    @XmlElement(name = "resource")
    private List<Resource> resourcesList;

    /**
     * Demonstration's staff attributions list.
     */
//    @XmlElementWrapper(name = "staff_attributions_list")
    private StaffAttributionsList staffAttributionsList;

    /**
     * Demonstration's conflicts list.
     */
    private ConflictsList conflictsList;

    /**
     * The demonstration current state.
     */
    @XmlTransient
    private DemonstrationState currentState;

    /**
     * A counter of demonstrations.
     */
    private static int demoCounter = 1;

    /**
     * Demonstration ID prefix.
     */
    private static final String ID_PREFIX = "Demonstration-";

    /**
     * Demonstration's default title.
     */
    private static final String DEFAULT_TITLE = "Untitled";

    /**
     * Demonstration's default description.
     */
    private static final String DEFAULT_DESCRIPTION = "No description.";

    /**
     * Empty constructor, assigns the default value to attributes
     */
    public Demonstration() {
        this.title = DEFAULT_TITLE;
        this.description = DEFAULT_DESCRIPTION;
        // TODO : Review to count demos per exhibition only. 
        this.demonstrationID = ID_PREFIX + demoCounter++;

        this.place = new Place();
        this.staffList = new StaffList();
        this.organizersList = new OrganizersList();
        this.applicationsList = new ApplicationsList();
        this.resourcesList = new ArrayList<>();
        this.staffAttributionsList = new StaffAttributionsList();
        this.conflictsList = new ConflictsList();
        //this.currentState = new DemonstrationInitialState(this);
    }

    /**
     * Creates a demonstration receiving the description.
     *
     * @param description demonstration's description
     */
    public Demonstration(String description) {
        this.title = DEFAULT_TITLE;
        this.description = description;
        this.demonstrationID = ID_PREFIX + demoCounter++;
        
        this.place = new Place();
        this.staffList = new StaffList();
        this.organizersList = new OrganizersList();
        this.applicationsList = new ApplicationsList();
        this.resourcesList = new ArrayList<>();
        this.staffAttributionsList = new StaffAttributionsList();
        this.conflictsList = new ConflictsList();
        //this.currentState = new DemonstrationInitialState(this);
    }

    /**
     * Creates an instance of demonstration receiving their attributes.
     *
     * @param title demonstration's title
     * @param description demonstrations's description
     * @param place demonstration's place
     * @param staffList staff list
     * @param organizersList organizers list
     * @param applicationsList applications list
     * @param resourcesList resources list
     * @param staffAttributionsList staff attributions list
     * @param conflictsList conficts list
     */
    public Demonstration(String title, String description, Place place, StaffList staffList,
            OrganizersList organizersList, ApplicationsList applicationsList, List<Resource> resourcesList,
            StaffAttributionsList staffAttributionsList, ConflictsList conflictsList) {
        this.title = title;
        this.description = description;
        this.demonstrationID = ID_PREFIX + demoCounter++;
        
        this.place = place;
        this.staffList = new StaffList(staffList);
        this.organizersList = new OrganizersList(organizersList);
        this.applicationsList = new ApplicationsList(applicationsList);
        this.resourcesList = new ArrayList<>(resourcesList);
        this.staffAttributionsList = new StaffAttributionsList(staffAttributionsList);
        this.conflictsList = new ConflictsList(conflictsList);
        //this.currentState = new DemonstationInitialState(this);
    }

    /**
     * Creates an instance of demonstration copying another demonstration.
     *
     * @param demonstration another demonstration
     */
    public Demonstration(Demonstration demonstration) {
        this.title = demonstration.title;
        this.description = demonstration.description;
        this.demonstrationID = ID_PREFIX + demoCounter++;
        
        this.place = demonstration.place;
        this.staffList = new StaffList(demonstration.staffList);
        this.organizersList = new OrganizersList(demonstration.organizersList);
        this.applicationsList = new ApplicationsList(demonstration.applicationsList);
        this.resourcesList = new ArrayList<>(demonstration.resourcesList);
        this.staffAttributionsList = new StaffAttributionsList(demonstration.staffAttributionsList);
        this.currentState = demonstration.currentState;
        this.conflictsList = new ConflictsList(demonstration.conflictsList);
    }

    /**
     * Gets the demonstration's title.
     *
     * @return demonstartion's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the demonstartion's title.
     *
     * @param title demonstration's title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * returns the current value of the descriptive text
     *
     * @return demonstration's description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * sets the current value of the descriptive text
     *
     * @param description demonstration's description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the demonstration's place.
     *
     * @return demonstration's place
     */
    public Place getPlace() {
        return place;
    }

    /**
     * Sets the demonstration's place.
     *
     * @param place demonstration's place
     */
    public void setPlace(Place place) {
        this.place = place;
    }

    /**
     * Gets the organizers list.
     *
     * @return organizers list
     */
    public OrganizersList getOrganizersList() {
        return organizersList;
    }

    /**
     * Sets the organizers list.
     *
     * @param organizersList organizers list
     */
    public void setOrganizersList(OrganizersList organizersList) {
        this.organizersList = organizersList;
    }

    /**
     * Gets the resources list.
     *
     * @return resources list
     */
    public List<Resource> getResourcesList() {
        return resourcesList;
    }

    /**
     * Sets the resources list.
     *
     * @param resourcesList resources list.
     */
    public void setResourcesList(List<Resource> resourcesList) {
        this.resourcesList = resourcesList;
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
     * Obtain the Demonstration's conflicts list.
     *
     * @return the Demonstration's conflicts list
     */
    @Override
    public ConflictsList getConflictsList() {
        return this.conflictsList;
    }

    /**
     * Set the Demonstration's conflicts list.
     *
     * @param conflictsList the Demonstration's conflicts list to set
     */
    public void setConflictsList(ConflictsList conflictsList) {
        this.conflictsList = new ConflictsList(conflictsList);
    }
    
    /**
     * Adds a resouce to the list if it doesn't already contain that resouce.
     * 
     * @param resource the resource to add
     * @return true if the resource is added
     */
    public boolean addResource(Resource resource) {
        
        return this.resourcesList.contains(resource) ? false : this.resourcesList.add(resource);
    }

    /**
     * Returns the current demonstration state.
     *
     * @return the actual state of the demonstration
     */
    public DemonstrationState getCurrentState() {
        return this.currentState;
    }

    /**
     * Sets the new demonstration state.
     *
     * @param currentState the new demonstration state
     */
    public void setCurrentState(DemonstrationState currentState) {
        this.currentState = currentState;
    }

    @Override
    public boolean setInDetectedConflictsState() {

        return this.currentState.setDetectedConflicts();
    }

    /**
     * Validates the demonstration.
     *
     * @return true if the description is valid, false otherwise
     */
    boolean validate() {
        return !this.description.isEmpty();
    }

    /**
     * Equals method to check if two objects are the same
     *
     * @param otherObject the demonstration to compare to
     * @return true if equal
     */
    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        Demonstration otherDemonstration = (Demonstration) otherObject;

        return this.description.equals(otherDemonstration.description)
                && this.place.equals(otherDemonstration.place)
                && this.organizersList.equals(otherDemonstration.organizersList)
                && this.staffList.equals(otherDemonstration.staffList)
                && this.applicationsList.equals(otherDemonstration.applicationsList)
                && this.resourcesList.equals(otherDemonstration.resourcesList)
                && this.staffAttributionsList.equals(otherDemonstration.staffAttributionsList);
    }

    /**
     * Returns the textual representation of the attributes of this class.
     *
     * @return demonstration's textual representation
     */
    @Override
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

    /**
     * @param applicationsList the applicationsList to set
     */
    public void setApplicationsList(ApplicationsList applicationsList) {
        this.applicationsList = applicationsList;
    }

    /**
     * Set the staff attributions list
     *
     * @param staffAttributionsList the news staff attributions list
     */
    @Override
    public void setStaffAttributionsList(StaffAttributionsList staffAttributionsList) {
        this.staffAttributionsList = new StaffAttributionsList(staffAttributionsList);
    }

    /**
     * Returns a short version info of the demonstration.
     *
     * @return a short representation
     */
    @Override
    public String getShortInfo() {
        return String.format("Demonstration: %s", this.description);

    }

    /**
     * Set the current demonstration state of the demonstration to
     * applicationsInEvaluation state
     */
    @Override
    public void setSubmittableInApplicationsInEvaluationState() {
        this.currentState.setApplicationsInEvaluation();
    }

    @Override
    public String[] getInfo() {
        String[] info = new String[2];
        info[0] = this.getShortInfo();
        //TODO info[1] = this.getStartDate().toString();
        info[1] = "por definir";
        //TODO info[2] = this.getEndDate().toString();
        info[2] = "por definir";
        return info;
    }

    @Override
    public boolean removeAttribution(StaffAttribution staffAttribution) {
        return this.staffAttributionsList.removeStaffAttribution(staffAttribution);

    }

}
