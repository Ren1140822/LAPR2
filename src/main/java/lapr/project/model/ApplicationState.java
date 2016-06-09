/**
 * Package location for Model concepts.
 */
package lapr.project.model;

/**
 * Represents the application state.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public interface ApplicationState {

    /**
     * Verify if the current application state is initial state.
     * 
     * @return true if the application state is initial state, false otherwise
     */
    boolean isInitial();

    /**
     * Changes the current application state to in submission state.
     * 
     * @return true if the state is changed to in submission state, false otherwise
     */
    boolean setInSubmission();

    /**
     * Verify if the current application state is in submission state.1
     * 
     * @return true if the application state is in submission state, false otherwise
     */
    boolean isInSubmission();

    /**
     * Changes the current application state to removed state.
     * 
     * @return true if the state is changed to removed state, false otherwise
     */
    boolean setRemoved();

    /**
     * Verify if the current application state is removed state.
     * 
     * @return true if the application state is removed state, false otherwise
     */
    boolean isRemoved();

    /**
     * Changes the current application state to in attribution state.
     * 
     * @return true if the state is changed to in attribution state, false otherwise
     */
    boolean setInAttribution();

    /**
     * Verify if the current application state is in attribution state.
     * 
     * @return true if the application state is in attribution state, false otherwise
     */
    boolean isInAttribtion();

    /**
     * Changes the current application state to in evaluation state.
     * 
     * @return true if the state is changed to in evaluation state, false otherwise
     */
    boolean setInEvaluation();

    /**
     * Verify if the current application state is in evaluation state.
     * 
     * @return true if the application state is in evaluation state, false otherwise
     */
    boolean isInEvaluation();

    /**
     * Changes the current application state to not evaluated state.
     * 
     * @return true if the state is changed to not evaluated state, false otherwise
     */
    boolean setNotEvaluated();

    /**
     * Verify if the current application state is not evaluated state.
     * 
     * @return true if the application state is not evaluated state, false otherwise
     */
    boolean isNotEvaluated();

    /**
     * Changes the current application state to evaluated state.
     * 
     * @return true if the state is changed to evaluated state, false otherwise
     */
    boolean setEvaluated();

    /**
     * Verify if the current application state is evaluated state.
     * 
     * @return true if the application state is evaluated state, false otherwise
     */
    boolean isEvaluated();

    /**
     * Changes the current application state to accepted state.
     * 
     * @return true if the state is changed to accepeted state, false otherwise
     */
    boolean setAccepted();

    /**
     * Verify if the current application state is accepted state.
     * 
     * @return true if the application state is accepted state, false otherwise
     */
    boolean isAccepted();

    /**
     * Changes the current application state to declined state.
     * 
     * @return true if the state is changed to declined state, false otherwise
     */
    boolean setDeclined();

    /**
     * Verify if the current application state is declined state.
     * 
     * @return true if the application state is declined state, false otherwise
     */
    boolean isDeclined();
    
    /**
     * Validate if the the state gathers all necessary information to transit to
     * next state.
     *
     * @return true if the state gathers the information to transit, false
     * otherwise
     */
    boolean validate();
}
