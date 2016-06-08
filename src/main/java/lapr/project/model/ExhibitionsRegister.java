/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a exhibitions register
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ExhibitionsRegister {

    /**
     * exhibitions List of ExhibitionsRegister
     */
    private List<Exhibition> exhibitionsList;

    /**
     * Builds Exhibition Register instances with no params.
     *
     *
     */
    public ExhibitionsRegister() {
        this.exhibitionsList = new ArrayList<>();
    }

    /**
     * Builds Exhibition Register instances with arrayList of exhibitions as
     * param.
     *
     *
     * @param exhibitionsList exhibitions list
     */
    public ExhibitionsRegister(List<Exhibition> exhibitionsList) {
        this.exhibitionsList = new ArrayList<>(exhibitionsList);
    }

    /**
     * Builds Exhibition Register instances with arrayList of exhibitions as
     * param.
     *
     *
     * @param exhibitionRegister a instance of this class, copy constructor
     */
    public ExhibitionsRegister(ExhibitionsRegister exhibitionRegister) {
        this.exhibitionsList = new ArrayList<>(exhibitionRegister.exhibitionsList);
    }
    
    /**
     * Creates a new instance of a Exhibition.
     * 
     * @return a new instance of a Exhibition
     */
    public Exhibition newExhibition() {
        
        return new Exhibition();
    }

  
    
    /**
     * Returns the whole exhibitions list referring to this instance.
     * @return the list of exhibitions referring to this instance
     */
    public List<Exhibition> getExhibitionList(){
        return new ArrayList(exhibitionsList);
    }
    
    
    
    
    /**
     * Returns the exhibitions list with application in submitting state.
     * @return returns the exhibitions list with application in submitting state
     */
    public List<Exhibition>getExhibitionListWithApplicationInSubmittingState(){
        
         List<Exhibition> exhibitionListInRightState = new ArrayList();
         boolean validated;
         for(Exhibition exhibition : this.exhibitionsList){
          
             validated= exhibition.getCurrentExhibitionState().isExhibitionOpenApplication();
        
             if(validated){
                 exhibitionListInRightState.add(exhibition);
             }
         }
         return exhibitionListInRightState;
         
    }
    
    
    
    
    
    
    
    
    /**
     * Returns the textual interpretation of the objects and attributes of this
     * class
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("ExhibitionsRegister{");
        for (Exhibition ex : exhibitionsList) {
            s.append(String.format("%s%n", ex));
        }
        s.append("}");
        return s.toString();
    }

}
