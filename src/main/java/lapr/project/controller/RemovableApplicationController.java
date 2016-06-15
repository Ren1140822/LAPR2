/**
 * Package location for Application Controllers concepts.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitorResponsible;
import lapr.project.model.Removable;

/**
 * Represents the controller to remove applications.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class RemovableApplicationController {
    /**
     * The exhibition center.
     */
    private final ExhibitionCenter exhibitionCenter;
    
    /**
     * The exhibitor responsible
     */
    private final ExhibitorResponsible exhibitorResponsible;

    /**
     * Contructs a RemovableApplicationController class.
     * @param exhibitionCenter Exhibition Center
     * @param exhibitorResponsible exhibitor responsible
     */
    public RemovableApplicationController(ExhibitionCenter exhibitionCenter, ExhibitorResponsible exhibitorResponsible) {
        this.exhibitionCenter = exhibitionCenter;
        this.exhibitorResponsible = exhibitorResponsible;
    }
    
    /**
     * Gets the removables filtering by an exhibitor responsible and filtering by exhibition states(ExhibitionOpenApplicationsState and/or 
     * @param exhibitorResponsible
     * @return 
     */
    public List<Removable> getRemovables(ExhibitorResponsible exhibitorResponsible){
        return this.exhibitionCenter.getExhibitionsRegister().getRemovables(exhibitorResponsible);
    }
    
    /**
     * It sets removable state to the removable received from the parameter
     * @param removable the removable to set the removable state
     * @return 
     */
    public boolean remove(Removable removable){
        return removable.setInRemovable();
    }
    
    
}
