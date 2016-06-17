/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.util.List;

/**
 * Interface for decisable applications.
 * 
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public interface Decisable {
    
    /**
     * Returns true if the decisable is in decision.
     * @return true if decisable is in decision
     */
    public   boolean isInDecision();
    
    /**
     * Returns the list of evaluations of a decisable.
     * @return the evaluations list
     */
    public  List<Evaluation> getEvaluationsList();
}
