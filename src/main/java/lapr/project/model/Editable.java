/**
 * Package location for Model concepts.
 */
package lapr.project.model;

/**
 * Interface for editable applications.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public interface Editable {

    /**
     * Verify is a given exhibitor responsivle is the exhibitor responsible of
     * the editable.
     *
     * @param exhibitorResponsible exhibitor responsible
     * @return true if he/she is the exhibitor responsible, false otherwise
     */
    boolean isExhibitorResponsible(ExhibitorResponsible exhibitorResponsible);
    
    /**
     * Verify if the editable is in submission state.
     * 
     * @return true if it is on submission state, false otherwise
     */
    boolean isInSubmission();
    
    /**
     * Validate if this editable is valid.
     * 
     * @return true if it is valid, false otherwise
     */
    boolean validate();
}
