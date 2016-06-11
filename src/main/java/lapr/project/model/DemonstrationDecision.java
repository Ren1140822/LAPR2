/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a decision to a demonstration application.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Amaral 1151231
 */
@XmlRootElement
public class DemonstrationDecision {

    /**
     * Demonstration application.
     */
    @XmlElement
    private DemonstrationApplication demonstrationApplication;

    /**
     * Decision to the demonstration application.
     */
    @XmlElement
    private boolean decision;

    /**
     * Default value for decision.
     */
    public static final boolean DEFAULT_DECISION = false;

    /**
     * Creates an instance of demonstration decision with its default values.
     */
    public DemonstrationDecision() {
        demonstrationApplication = new DemonstrationApplication();
        decision = DEFAULT_DECISION;
    }

    /**
     * Creates an instance of demonstration decision receiving an demonstration
     * application and a decision
     *
     * @param demonstrationApplication demonstration application
     * @param decision decision
     */
    public DemonstrationDecision(DemonstrationApplication demonstrationApplication, boolean decision) {
        this.demonstrationApplication = new DemonstrationApplication(demonstrationApplication);
        this.decision = decision;
    }

    /**
     * Creates an instance of demonstration decision copying another
     * demonstration decision.
     *
     * @param demonstrationDecision another demonstration decision
     */
    public DemonstrationDecision(DemonstrationDecision demonstrationDecision) {
        demonstrationApplication = new DemonstrationApplication(demonstrationDecision.demonstrationApplication);
        decision = demonstrationDecision.decision;
    }

    /**
     * Gets the demonstration application.
     *
     * @return demonstration application
     */
    public DemonstrationApplication getDemonstrationApplication() {
        return new DemonstrationApplication(demonstrationApplication);
    }

    /**
     * Sets the demonstration application.
     *
     * @param demonstrationApplication demonstration application
     */
  
    public void setDemonstrationApplication(DemonstrationApplication demonstrationApplication) {
        this.demonstrationApplication = new DemonstrationApplication(demonstrationApplication);
    }

    /**
     * Gets the demonstration decision.
     *
     * @return demonstration decision
     */
    public boolean getDecision() {
        return decision;
    }

    /**
     * Sets the demonstration decision.
     *
     * @param decision demonstration decision
     */
    
    public void setDecision(boolean decision) {
        this.decision = decision;
    }

    @Override
    public String toString() {
        return String.format("DemonstrationDecision{%n%s%n%s%n}", demonstrationApplication, decision);
    }

}
