/**
 * Package location for Apllication Controllers concepts.
 */
package lapr.project.controller;

import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitionsRegister;

/**
 * Represents the controller to create exhibitions.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class CreateExhibitionController {

    /**
     * The exhibition center.
     */
    private final ExhibitionCenter exhibitionCenter;
    
    /**
     * The new exhibition object.
     */
    private Exhibition exhibition;
    
    /**
     * Constructs a CreateExhibitionController Class.
     * 
     * @param exhibitionCenter Exhibition Center
     */
    public CreateExhibitionController(ExhibitionCenter exhibitionCenter) {
        
        this.exhibitionCenter = exhibitionCenter;
    }
    
    /**
     * Creates a new exhibition object.
     */
    public void newExhibition() {
        
        ExhibitionsRegister exhibitionRegister = exhibitionCenter.getExhibitionsRegister();
        
        this.exhibition = exhibitionRegister.newExhibition();
    }
    
}
