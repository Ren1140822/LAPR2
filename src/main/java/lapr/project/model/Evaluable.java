/**
 * Package location for Model concepts.
 */
package lapr.project.model;

/**
 * Interface for ebaluable applications.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public interface Evaluable {

    /**
     * Returns a new evaluation.
     *
     * @return new evaluation
     */
    Evaluation newEvaluation();

    /**
     * Validate if a evaluation is valid.
     *
     * @param evaluation evaluation to be validated
     * @return true if it is valid, false otherwise
     */
    boolean validateEvaluation(Evaluation evaluation);

    /**
     * Register an evaluation.
     *
     * @param evaluation evaluation to be registered
     * @return true if it is registered with success, false otherwise
     */
    boolean registerEvaluation(Evaluation evaluation);
}
