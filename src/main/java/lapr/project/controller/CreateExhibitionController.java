/**
 * Package location for Apllication Controllers concepts.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitionsRegister;
import lapr.project.model.User;
import lapr.project.model.UsersRegister;

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
        
        ExhibitionsRegister exhibitionRegister = getExhibitionCenter().getExhibitionsRegister();
        
        this.exhibition = exhibitionRegister.newExhibition();
    }

    /**
     * Obtain the Exhibition Center.
     * 
     * @return the Exhibition Center
     */
    public ExhibitionCenter getExhibitionCenter() {
        return this.exhibitionCenter;
    }

    /**
     * Obtain the new Exhibition.
     * 
     * @return the Exhibition
     */
    public Exhibition getExhibition() {
        return this.exhibition;
    }
    
    /**
     * Obtain users list.
     * 
     * @return users list
     */
    public List<User> getUsersList() {
        
        UsersRegister usersRegister = exhibitionCenter.getUsersRegister();
        
        return usersRegister.getUsersList();
    }
    
}