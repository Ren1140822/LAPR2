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

}
