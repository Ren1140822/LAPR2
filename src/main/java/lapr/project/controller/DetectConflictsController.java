/**
 * Package location for Apllication Controllers concepts.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.Application;
import lapr.project.model.Conflict;
import lapr.project.model.ConflictType;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.StaffMember;
import lapr.project.model.Submittable;

/**
 * Represents the controller to detect conflicts.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class DetectConflictsController {

    /**
     * The exhibition center.
     */
    private final ExhibitionCenter exhibitionCenter;

    /**
     * The submittable which the timer was triggered.
     */
    private final Submittable submittable;

    /**
     * Constructs a DetectConflictsController Class.
     *
     * @param exhibitionCenter Exhibition Center
     * @param submittable Submittable which the timer was triggered
     */
    public DetectConflictsController(ExhibitionCenter exhibitionCenter, Submittable submittable) {
        this.exhibitionCenter = exhibitionCenter;
        this.submittable = submittable;
    }

    /**
     * Obtain the conflict types list.
     *
     * @return the conflict types list
     */
    public List<ConflictType> getConflictTypesList() {
        return this.exhibitionCenter.getConflictTypesRegister().getConflictTypesList();
    }

    /**
     * Obtain the submittable applications list.
     *
     * @return the submittable applications list
     */
    public List<Application> getApplicationsList() {
        return this.submittable.getApplicationsList().getApplicationsList();
    }

    /**
     * Obtain the submittable staff list.
     *
     * @return the submittable staff list
     */
    public List<StaffMember> getStaffList() {
        return this.submittable.getStaffList().getStaffList();
    }

    /**
     * Obtain the submittable conflicts list.
     *
     * @return the submittable conflicts list
     */
    public List<Conflict> getConflictsList() {
        return this.submittable.getConflictsList().getConflictsList();
    }
}
