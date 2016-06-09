/**
 * Package location for Application Controllers concepts.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitionsRegister;
import lapr.project.model.StaffMember;
import lapr.project.model.Submittable;

/**
 * Represents the controller to evaluate applications.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class EvaluateApplicationsController {

    /**
     * The exhibition center.
     */
    private final ExhibitionCenter exhibitionCenter;
    
    /**
     * The selected submittable.
     */
    private Submittable submittable;

    /**
     * Constructs a evaluate applications controller.
     *
     * @param exhibitionCenter Exhibition Center
     */
    public EvaluateApplicationsController(ExhibitionCenter exhibitionCenter) {

        this.exhibitionCenter = exhibitionCenter;
    }
    
    public List<Submittable> getSubmittablesByStaff(StaffMember staffMember){
        ExhibitionsRegister exhibitionsRegister = exhibitionCenter.getExhibitionsRegister();
        return exhibitionsRegister.getSubmittablesByStaff(staffMember); 
    }
    
    public void setSubmittable(Submittable submittable){
        this.submittable = submittable;
    }
}
