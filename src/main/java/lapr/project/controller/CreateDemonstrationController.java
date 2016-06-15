/**
 * Package location for Application Controllers concepts.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.Demonstration;
import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitionsRegister;
import lapr.project.model.Organizer;

/**
 * Represents the controller to create a demonstration.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class CreateDemonstrationController {

    /**
     * The exhibition center.
     */
    private final ExhibitionCenter exhibitionCenter;

    /**
     * The organizer logged in this session.
     */
    private final Organizer organizer;

    /**
     * The selected exhibition.
     */
    private Exhibition exhibition;

    /**
     * The new demonstration
     */
    private Demonstration demonstration;

    /**
     * Constructs a CreateDemonstrationController Class.
     *
     * @param exhibitionCenter Exhibition Center
     * @param organizer Logged in organizer
     */
    public CreateDemonstrationController(ExhibitionCenter exhibitionCenter, Organizer organizer) {
        this.exhibitionCenter = exhibitionCenter;
        this.organizer = organizer;
    }

    public List<Exhibition> getExhibitionsList(Organizer organizer) {

        ExhibitionsRegister exhibitionsRegister = this.exhibitionCenter.getExhibitionsRegister();
        
        return exhibitionsRegister.getExhibitionsListWithoutDemosDefined(organizer);
    }
}
