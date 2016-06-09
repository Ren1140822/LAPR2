/**
 * Package location for Controller concepts.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.ApplicationsList;
import lapr.project.model.Demonstration;
import lapr.project.model.DemonstrationsList;
import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionApplication;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitionsRegister;

/**
 * Represents the controller of exhibition application.
 *
 * @author Daniel GonÃ§alves 1151452
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
     * The class reference to applications list.
     */
    private ApplicationsList applicationList;

    /**
     * A temporary exhibition application reference.
     */
    private ExhibitionApplication exhibitionApplication;
    
 
    
    /**
     * Constructor receiving a ExhibitionCenter as parameter.
     *
     * @param exhibitionCenter the exhibition center received by parameter.
     */
    public ExhibitionApplicationController(ExhibitionCenter exhibitionCenter) {
        this.exhibitonCenter = exhibitionCenter;
    }

   /**
    * Gets this instance's exhibition application.
    * @return the exhibiton application
    */
    public ExhibitionApplication getExhibitionApplication() {
        return exhibitionApplication;
    }

    /**
     * Gets the list of exhibitions contained in the ExhibitionCenter
     *
     * @return returns a new list containing the list of exhibitions
     */
    public List<Exhibition> getExhibitionList() {
        this.exhibitionsRegister = exhibitonCenter.getExhibitionsRegister();
        this.exhibitionList = exhibitionsRegister.getExhibitionListWithApplicationInSubmittingState();
        return new ArrayList(exhibitionList);
    }

    /**
     * Creates a new Application.
     */
    public void newApplication(Exhibition exhibition) {
        this.applicationList = exhibition.getApplicationsList();
        this.exhibitionApplication= applicationList.newExhibitionApplication();
    }

    /**
     * Sets the data of the new application.
     */
    public void setData(String companyName, String companyAddress, String companyCellphone, float exhibitorArea, int numberInvitations) {
        this.exhibitionApplication.newExhibitor(companyName, companyAddress, companyCellphone);
        this.exhibitionApplication.setExhibitorArea(exhibitorArea);
        this.exhibitionApplication.setNumberInvitations(numberInvitations);
    }

    /**
     * Creates a new product.
     * @param designation the product designation
     */
    public void newProduct(String designation) {
     
        this.exhibitionApplication.newProduct(designation);
    }
    
    /**
     * Lists the demonstrations on a exhibition
     * @param exhibition the exhibition you want the demonstrations from
     * @return a copy of the demonstrations arraylist
     */
    public DemonstrationsList getDemonstrationsList(Exhibition exhibition){
        return new DemonstrationsList(exhibition.getDemonstrationsList());
    }
    
    /**
     * Adds a demonstration to this application.
     * @param demonstration the demonstration that is going to be added to the list on the application
     */
    public void newDemonstrationApplication(Demonstration demonstration){
        this.exhibitionApplication.newDemonstration(demonstration);
    }
    
    /**
     * Creates a new keyword and adds it to the list.
     * @param description the value for the keyword
     */
    public void newKeyword(String description){
        this.exhibitionApplication.newKeyword(description);
    }
    
    
    /**
     * Validates this exhibition application locally and globally.
     * @return true if all conditions to add the applications are fulfilled
     */
    public boolean validateExhibitionApplication(){
         return (this.exhibitionApplication.validateApplication()&&!this.applicationList.getApplicationsList().contains(this.exhibitionApplication));
        
    }
//     public boolean validateExhibitionApplication(){
//         if(this.exhibitionApplication.validateApplication()&&!this.applicationList.getApplicationsList().contains(this.exhibitionApplication)){
//             this.applicationList.getApplicationsList().add(exhibitionApplication);
//             return true;
//         }
//         return false;
//    }

}
