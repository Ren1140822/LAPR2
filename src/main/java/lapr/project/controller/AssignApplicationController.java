/**
 * Package location for Application Controllers concepts.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.Assingnable;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitionsRegister;
import lapr.project.model.MechanismsRegister;
import lapr.project.model.Organizer;
import lapr.project.model.StaffAttributionMechanism;
import lapr.project.model.StaffAttributionsList;
import lapr.project.model.Submittable;

/**
 * Represents the controller to assign applications.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class AssignApplicationController {

    /**
     * The exhibition center.
     */
    private final ExhibitionCenter exhibitionCenter;

    /**
     * The organizer.
     */
    private final Organizer organizer;

    /**
     * The submittable selected.
     */
    private Submittable selectedSubmittable;

    /**
     * The staff attributions list.
     */
    private StaffAttributionsList staffAttributionsList;
    
    /**
     * The mechanisms register
     */
    private MechanismsRegister mechanismsRegister;
    
    /**
     * The staff attribution mechanism
     */
    private StaffAttributionMechanism staffAttributionMechanism;

    /**
     * Constructs a AssignApplicationController Class.
     *
     * @param exhibitionCenter Exhibition Center
     * @param organizer Organizer
     *
     */
    public AssignApplicationController(ExhibitionCenter exhibitionCenter, Organizer organizer) {

        this.exhibitionCenter = exhibitionCenter;
        this.organizer = organizer;
    }

    /**
     * Obtain the Exhibition Center.
     *
     * @return the Exhibition Center
     */
    public ExhibitionCenter getExhibitionCenter() {
        return this.exhibitionCenter;
    }

    public List<Submittable> getSubmittablesInChangedConflictsByOrganizer(Organizer organizer) {
        ExhibitionsRegister exhibitionsRegister = this.exhibitionCenter.getExhibitionsRegister();
        return exhibitionsRegister.getSubmittablesInChangedConflictsByOrganizer(organizer);
    }

    public void setSubmittable(Submittable submittable) {
        this.selectedSubmittable = submittable;
        this.staffAttributionsList = this.selectedSubmittable.getStaffAttributionsList();
    }
    
    public List<StaffAttributionMechanism> getStaffAttributionMechanism(){
        this.mechanismsRegister = this.exhibitionCenter.getMechanismsRegister();
        return this.mechanismsRegister.getAttributionMechanismList();
    }
    
    public void setStaffAttributionMechanism(StaffAttributionMechanism staffAttributionMechanism){
        this.staffAttributionMechanism = staffAttributionMechanism;
    }
    
    public List<Assingnable> getAttributionsList(){
        return this.staffAttributionMechanism.toAssign(this.selectedSubmittable);
    }
    
    

}
