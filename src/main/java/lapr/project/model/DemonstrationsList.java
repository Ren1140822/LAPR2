/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a demonstrations list.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
@XmlRootElement
public class DemonstrationsList {

    /**
     * List of demonstrations.
     */
    @XmlElementWrapper(name = "demonstrations_list")
    @XmlElement(name = "demonstration")
    private List<Demonstration> demonstrationList;

    /**
     * Demonstration's start date.
     */
    private Date startDate;

    /**
     * Demonstration's end date.
     */
    private Date endDate;

    /**
     * Demonstration's application submissions start date.
     */
    private Date subStartDate;

    /**
     * Demonstration's application submissions end date.
     */
    private Date subEndDate;

    /**
     * Demonstration's attribution conflicts resolution limit date.
     */
    private Date conflictLimitDate;

    /**
     * Demonstration's evaluations limite date.
     */
    private Date evaluationLimitDate;

    /**
     * Demonstration's default start date.
     */
    private static final Date DEFAULT_START_DATE = new Date(2016, 1, 1);

    /**
     * Demonstration's default end date.
     */
    private static final Date DEFAULT_END_DATE = new Date(2016, 1, 1);

    /**
     * Demonstration's default application submissions start date.
     */
    private static final Date DEFAULT_SUB_START_DATE = new Date(2016, 1, 1);

    /**
     * Demonstration's default application submissions end date.
     */
    private static final Date DEFAULT_SUB_END_DATE = new Date(2016, 1, 1);

    /**
     * Demonstration's default attribution conflicts resolution limit date.
     */
    private static final Date DEFAUL_CONFLICT_LIMITE_DATE = new Date(2016, 1, 1);

    /**
     * Demonstration's default evaluations limite date.
     */
    private static final Date DEFAUL_EVALUATION_LIMITE_DATE = new Date(2016, 1, 1);

    /**
     * Creates an instance of DemonstrationsList with its default values.
     */
    public DemonstrationsList() {
        this.demonstrationList = new ArrayList<>();
        this.startDate = DEFAULT_START_DATE;
        this.endDate = DEFAULT_END_DATE;
        this.subStartDate = DEFAULT_SUB_START_DATE;
        this.subEndDate = DEFAULT_SUB_END_DATE;
        this.conflictLimitDate = DEFAUL_CONFLICT_LIMITE_DATE;
        this.evaluationLimitDate = DEFAUL_EVALUATION_LIMITE_DATE;
    }

    /**
     * Creates an instance of DemonstrationsList receiving the list of
     * demonstrations
     *
     * @param demonstrationList list of demonstrations
     */
    public DemonstrationsList(List<Demonstration> demonstrationList) {
        this.demonstrationList = new ArrayList<>(demonstrationList);
        this.startDate = DEFAULT_START_DATE;
        this.endDate = DEFAULT_END_DATE;
        this.subStartDate = DEFAULT_SUB_START_DATE;
        this.subEndDate = DEFAULT_SUB_END_DATE;
        this.conflictLimitDate = DEFAUL_CONFLICT_LIMITE_DATE;
        this.evaluationLimitDate = DEFAUL_EVALUATION_LIMITE_DATE;
    }

    /**
     * Creates a demonstrations list receiving their attributes.
     *
     * @param demonstrationList demonstrations list
     * @param startDate start date
     * @param endDate end date
     * @param subStartDate application submissions sart date
     * @param subEndDate application submissions end date
     * @param conflictLimitDate conflict limite date
     * @param evaluationLimitDate evaluations limite date
     */
    public DemonstrationsList(List<Demonstration> demonstrationList, Date startDate, Date endDate, Date subStartDate, Date subEndDate, Date conflictLimitDate, Date evaluationLimitDate) {
        this.demonstrationList = demonstrationList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.subStartDate = subStartDate;
        this.subEndDate = subEndDate;
        this.conflictLimitDate = conflictLimitDate;
        this.evaluationLimitDate = evaluationLimitDate;
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
            if (demonstration.getCurrentState().isChangedConflicts()) {
                demonstrationsInChangedConflitctsStateList.add(demonstration);
            }
        }
        return demonstrationsInChangedConflitctsStateList;
    }
    
    /**
     * Returns the list of removables of this demonstration list filtered out by exhibitor responsible
     * @param exhibitorResponsible exhibitor responsible to filter removables
     * @return 
     */
    public List<Removable> getRetiraveis(ExhibitorResponsible exhibitorResponsible){
        List<Removable> removablesList = new ArrayList();
        List<Application> applicationsList = new ArrayList();
        Removable removable;
        for (Demonstration demonstration : this.demonstrationList) {
                    applicationsList = demonstration.getApplicationsList().getApplicationsList();
                    if (demonstration.getCurrentDemonstrationState().isOpenedApplications()) {
                        for (Application application : applicationsList) {
                            removable = (Removable) application;
                            if (removable.getExhibitorResponsible().equals(exhibitorResponsible)) {
                                removablesList.add(removable);
                            }
                        }
                    }
                }
        return removablesList;
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
     * Compares two DemonstrationsList objects.
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

        return this.demonstrationList.equals(otherDemonstrationsList.demonstrationList)
                && this.startDate.equals(otherDemonstrationsList.startDate)
                && this.endDate.equals(otherDemonstrationsList.endDate)
                && this.subStartDate.equals(otherDemonstrationsList.subStartDate)
                && this.subEndDate.equals(otherDemonstrationsList.subEndDate)
                && this.conflictLimitDate.equals(otherDemonstrationsList.conflictLimitDate)
                && this.evaluationLimitDate.equals(otherDemonstrationsList.evaluationLimitDate);
    }
}
