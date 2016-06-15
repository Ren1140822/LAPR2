/**
 * Package location for AssignStandsController concepts.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.ApplicationsList;
import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionApplication;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitionsRegister;
import lapr.project.model.Organizer;


/**
 * Represents a AssignStandsController
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class AssignStandsController {
    /**
     * The list of exhibitions of this organizer which are in evaluated state.
     */
    private List<Exhibition> exhibitionsListInApplicationDecidedState;
    
    /**
     * The exhibitions register.
     */
    private ExhibitionsRegister exhibitionsRegister;
    
    /**
     * The exhibition center.
     */
    private ExhibitionCenter exhibitionCenter;
    
    /**
     * The organizer.
     */
    private Organizer organizer;
    
    /**
     * The applications list class.
     */
    private ApplicationsList applicationsListClass;
    /**
     * The list of exhibition applications.
     */
    private List<ExhibitionApplication> applicationsList;
    
    /**
     * Builds instance of this class receiving organizer and exhibition center as parameters.
     * @param organizer the organizer
     * @param exhibitionCenter the exhibition center
     */
    public AssignStandsController(Organizer organizer,ExhibitionCenter exhibitionCenter)
    {
            this.organizer = organizer;
            this.exhibitionCenter = exhibitionCenter;
    }
    
    /**
     * Gets the list of exhibitions in the desired state.
     * @param organizer the organizer to check for
     * @return the exhibitions list
     */
    public List<Exhibition> getExhibitionsListByOrganizerInApplicationsDecidedState(Organizer organizer){
        this.exhibitionsRegister = exhibitionCenter.getExhibitionsRegister();
        this.exhibitionsListInApplicationDecidedState = exhibitionsRegister.getExhibitionsListWithApplicationsDecidedByOrganizer(organizer);
        return this.exhibitionsListInApplicationDecidedState;
    }
    
    
    /**
     * Gets the applications List in acceptedState.
     * @param exhibition the exhibitions to check the applications
     * @return the applicationsList
     */
    public List<ExhibitionApplication> getApplicationsList(Exhibition exhibition){
        this.applicationsListClass = exhibition.getApplicationsList();
        this.applicationsList = applicationsListClass.getApplicationsInAcceptedState();
        return this.applicationsList;
    }
}
