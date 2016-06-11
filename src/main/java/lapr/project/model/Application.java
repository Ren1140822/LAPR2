/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A markup interface for an application.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */

public interface Application {

    /**
     * Gets the evaluations list.
     *
     * @return evaluations list
     */
    List<Evaluation> getEvaluationsList();
    
    /**
     * Changes the state of the application.
     * 
     * @param newState new state to be active
     */
    void setState(ApplicationState newState);

    /**
     * Verify if an application is valid.
     * 
     * @return true if it is valid, false otherwise
     */
    public boolean isValid();
}
