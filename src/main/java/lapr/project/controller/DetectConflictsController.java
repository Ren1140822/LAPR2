/**
 * Package location for Apllication Controllers concepts.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.ConflictType;
import lapr.project.model.ExhibitionCenter;
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
     * Constructs a CreateExhibitionController Class.
     *
     * @param exhibitionCenter Exhibition Center
     * @param submittable Submittable which the timer was triggered
     */
    public DetectConflictsController(ExhibitionCenter exhibitionCenter, Submittable submittable) {
        this.exhibitionCenter = exhibitionCenter;
        this.submittable = submittable;
    }

    public List<ConflictType> getConflictTypesList() {
        return exhibitionCenter.getConflictTypesRegister().getConflictTypesList();
    }
}
