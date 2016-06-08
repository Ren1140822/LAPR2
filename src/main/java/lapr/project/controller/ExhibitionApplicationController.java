/**
 * Package location for Controller concepts.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitionsRegister;

/**
 * Represents the controller of exhibition application.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ExhibitionApplicationController {

    /**
     * The exhibition center of this instance.
     */
    private ExhibitionCenter exhibitonCenter;

    
    /**
     * The exhibitions register referering to this exhibition center
     */
    private ExhibitionsRegister exhibitionsRegister;
    
    
    /**
     * The list of exhibitions contained in this instance.
     */
    private List<Exhibition> exhibitionList;

    
    
    
    
    /**
     * Constructor receiving a ExhibitionCenter as parameter.
     *
     * @param exhibitionCenter the exhibition center received by parameter.
     */
    public ExhibitionApplicationController(ExhibitionCenter exhibitionCenter) {
        this.exhibitonCenter = exhibitionCenter;
    }

    /**
     * Gets the list of exhibitions contained in the ExhibitionCenter
     *
     * @return returns a new list containing the list of exhibitions 
     */
    public List<Exhibition> getExhibitionList() {
        this.exhibitionsRegister=exhibitonCenter.getExhibitionsRegister();
        this.exhibitionList = exhibitionsRegister.getExhibitionListWithApplicationInSubmittingState();
        return new ArrayList(exhibitionList);
    }
}
