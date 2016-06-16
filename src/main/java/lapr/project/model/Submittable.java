/**
 * Package location for Model concepts.
 */
package lapr.project.model;

/**
 * Interface for submittable applications.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public interface Submittable {

    /**
     * Returns the staff attributions list.
     *
     * @return staff attributions list
     */
    StaffAttributionsList getStaffAttributionsList();

    /**
     * Return the applications list.
     *
     * @return applications list
     */
    ApplicationsList getApplicationsList();

    /**
     * Returns the staff list
     *
     * @return staff list
     */
    StaffList getStaffList();

    /**
     * Obtain the conflicts list
     *
     * @return the conflicts list
     */
    ConflictsList getConflictsList();

    /**
     * Set staff attributions list
     *
     * @param staffAttributionsList the new staff attributions list
     */
    void setStaffAttributionsList(StaffAttributionsList staffAttributionsList);

    /**
     * Returns a short version info of the submittable.
     *
     * @return a short representation
     */
    public String getShortInfo();

    /**
     * Set submittable to InApplicationsInEvaluation state
     */
    public void setSubmittableInApplicationsInEvaluationState();

    /**
     * Set submittable to Detected Conflicts State.
     * 
     * @return true if submittable changes state to Detected Conflicts State
     */
    public boolean setInDetectedConflictsState();

    public String[] getInfo();

    /**
     * Remove a staff attribution.
     *
     * @param staffAttribution staff attribution
     * @return true if it is removed with successfull, false otherwise
     */
    public boolean removeAttribution(StaffAttribution staffAttribution);
}
