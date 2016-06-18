/**
 * Package location for Application Controllers concepts.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.ExhibitionApplication;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitionsRegister;
import lapr.project.model.ExhibitorResponsible;

/**
 * Represents the controller to confirm stand.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ConfirmStandController {

    /**
     * The exhibition center.
     */
    private final ExhibitionCenter exhibitionCenter;

    /**
     * The exhibitor responsible logged in.
     */
    private final ExhibitorResponsible exhibitorResponsible;

    /**
     * Create an instance of confirm stand controller.
     *
     * @param exhibitionCenter the exhibition center
     * @param exhibitorResponsible the exhibitor responsible
     */
    public ConfirmStandController(ExhibitionCenter exhibitionCenter, ExhibitorResponsible exhibitorResponsible) {
        this.exhibitionCenter = exhibitionCenter;
        this.exhibitorResponsible = exhibitorResponsible;
    }

    /**
     * Gets the exhibition applications on assigned stand state by exhibitor
     * responsible.
     *
     * @return
     */
    public List<ExhibitionApplication> getExhibitionApplicationsByExhibitorResponsible() {
        ExhibitionsRegister exhibitionsRegister = this.exhibitionCenter.getExhibitionsRegister();
        return exhibitionsRegister.getExhibitionApplicationsAssignedStandByExhibitorResponsible(this.exhibitorResponsible);
    }
}
