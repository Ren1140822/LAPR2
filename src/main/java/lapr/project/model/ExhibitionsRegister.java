/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a exhibitions register
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ExhibitionsRegister {

    /**
     * exhibitions List of ExhibitionsRegister
     */
    private List<Exhibition> exhibitionsList;

    /**
     * Builds Exhibition Register instances with no params.
     *
     *
     */
    public ExhibitionsRegister() {
        this.exhibitionsList = new ArrayList<>();
    }

    /**
     * Builds Exhibition Register instances with arrayList of exhibitions as
     * param.
     *
     *
     * @param exhibitionsList exhibitions list
     */
    public ExhibitionsRegister(List<Exhibition> exhibitionsList) {
        this.exhibitionsList = new ArrayList<>(exhibitionsList);
    }

    /**
     * Builds Exhibition Register instances with arrayList of exhibitions as
     * param.
     *
     *
     * @param exhibitionRegister a instance of this class, copy constructor
     */
    public ExhibitionsRegister(ExhibitionsRegister exhibitionRegister) {
        this.exhibitionsList = new ArrayList<>(exhibitionRegister.exhibitionsList);
    }

    /**
     * Creates a new instance of a Exhibition.
     *
     * @return a new instance of a Exhibition
     */
    public Exhibition newExhibition() {

        return new Exhibition();
    }

    /**
     * Returns the whole exhibitions list referring to this instance.
     *
     * @return the list of exhibitions referring to this instance
     */
    public List<Exhibition> getExhibitionsList() {

        return new ArrayList(exhibitionsList);
    }

    /**
     * Sets the exhibitions list.
     *
     * @param exhibitionsList exhibitions list
     */
    public void setExhibitionsList(List<Exhibition> exhibitionsList) {
        this.exhibitionsList = new ArrayList(exhibitionsList);
    }

    /**
     * Validate if the list doesn't contain an exhibition.
     *
     * @param exhibition the exhibition to validate
     * @return true if list doesn't contain the exhibition
     */
    private boolean validateExhibition(Exhibition exhibition) {

        return !this.exhibitionsList.contains(exhibition);
    }

    /**
     * Add an exhibition to the list.
     *
     * @param exhibition the exhibition to add
     * @return true if the exhibition is sucessfully added.
     */
    private boolean addExhibition(Exhibition exhibition) {

        return this.exhibitionsList.add(exhibition);
    }

    /**
     * Register exhibition.
     *
     * @param exhibition Exhibition to add
     * @return true if exhibition is successfully added.
     */
    public boolean registerExhibition(Exhibition exhibition) {

        
        return (exhibition.setCreated() && validateExhibition(exhibition)) ? addExhibition(exhibition) : false;
    }

    /**
     * Gets the submittables filtering by a staff member.
     *
     * @param staffMember staff member to be filtered
     * @return the list of the staff member's submittables
     */
    public List<Submittable> getSubmittablesByStaff(StaffMember staffMember) {
        List<Submittable> submittableList = new ArrayList<>();

        for (Exhibition exhibition : exhibitionsList) {
            if (exhibition.getStaffList().isStaffMember(staffMember)) {
                submittableList.add(exhibition);
            }

            for (Demonstration demonstration : exhibition.getDemonstrationsList().getDemonstrationsList()) {
                if (demonstration.getStaffList().isStaffMember(staffMember)) {
                    submittableList.add(demonstration);
                }
            }
        }

        return submittableList;
    }

    /**
     * Gets the submittables filtering by an Organizer and InChangedConflicts state.
     *
     * @param organizer organizer to filter submittables
     * @return the list of the organizer's submittables which are
     * InChangedConflicts state
     */
    public List<Submittable> getSubmittablesInChangedConflictsByOrganizer(Organizer organizer) {
        List<Submittable> submittablesList = new ArrayList<>();

        for (Exhibition exhibition : exhibitionsList) {
            if ((exhibition.getOrganizersList().isOrganizer(organizer)) && (exhibition.getState().isChangedConflitcts())) {
                submittablesList.add(exhibition);
            }
            if (exhibition.getState().isApplicationsDecided()) {
                List<Demonstration> demoListInChangedConflicts = exhibition.getDemonstrationsList().getDemonstrationsListInChangedConflicts();
                submittablesList.addAll(demoListInChangedConflicts);
            }
        }
        return submittablesList;
    }

    /**
     * Returns the exhibitions list with application in submitting state.
     *
     * @return returns the exhibitions list with application in submitting state
     */
    public List<Exhibition> getExhibitionListWithApplicationInSubmittingState() {

        List<Exhibition> exhibitionListInRightState = new ArrayList();
        boolean validated;
        for (Exhibition exhibition : this.exhibitionsList) {

            validated = exhibition.getState().isOpenApplications();

            if (validated) {
                exhibitionListInRightState.add(exhibition);
            }
        }
        return exhibitionListInRightState;

    }

    /**
     * Returns the textual interpretation of the objects and attributes of this
     * class
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("ExhibitionsRegister{");
        for (Exhibition ex : exhibitionsList) {
            s.append(String.format("%s%n", ex));
        }
        s.append("}");
        return s.toString();
    }

}
