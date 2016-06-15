/**
 * Package location for Model concepts.
 */
package lapr.project.model;

/**
 * Interface for removable applications.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public interface Removable {

    /**
     * Gets the current state of the application.
     *
     * @return application current state
     */
    ApplicationState getCurrentState();

    /**
     * set assignable in evaluation state
     * @return true or false if it set in removable state returns true, false otherwise
     */
    boolean setInRemovable();

    /**
     * Gets the assignable title.
     *
     * @return assignable's title
     */
    String getTitle();
    
    /**
     * Gets exhibitor responsible
     * @return the exhibitor responsible
     */
    ExhibitorResponsible getExhibitorResponsible();
}
