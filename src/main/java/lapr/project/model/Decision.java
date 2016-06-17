/**
 * Package location for Model concepts.
 */
package lapr.project.model;

/**
 * Interface for decisable applications.
 * 
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class Decision {
    
    /**
     * The justificative text of this decision.
     */
    private String justificativeText;
    
    /**
     * The boolean representing the state of this decision.
     */
    private boolean decision;
    
    /**
     * The justificative text by default.
     */
    private String DEFAULT_JUSTIFICATIVE_TEXT ="No text";
    
    /**
     * Constructs an instance of this class without parameters.
     */
    public Decision(){
        this.justificativeText=DEFAULT_JUSTIFICATIVE_TEXT;
        this.decision=false;
    }
    
    /**
     * Constructs instance of this class receiving justificative text and a boolean as parameters.
     * @param justificativeText the justificative text
     * @param decision the decision
     */
    public Decision(String justificativeText,boolean decision){
        this.justificativeText=justificativeText;
        this.decision=decision;
    }
    
    /**
     * Constructs an instance of this class receiving a decision as parameter.
     * @param decision the decision to copy
     */
    public Decision(Decision decision){
        this.justificativeText=decision.justificativeText;
        this.decision =decision.decision;
    }

    /**
     * Sets the justificative text.
     * @param justificativeText the text to show
     */
    public void setJustificativeText(String justificativeText) {
        this.justificativeText = justificativeText;
    }

    /**
     * Sets the decision.
     * @param decision the decision
     */
    public void setDecision(boolean decision) {
        this.decision = decision;
    }
    
    /**
     * Validates if attributes are in correct state.
     * @return true if all O.K.
     */
    public boolean validate(){
        return !this.justificativeText.isEmpty();
    }
    
}
