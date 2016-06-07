/**
 * Package location for Model concepts.
 */
package lapr.project.model;

/**
 * Represents an DemonstrationEvaluation
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class DemonstrationEvaluation {

    /**
     * The DemonstrationEvaluation´s decision.
     */
    private boolean decision;
    /**
     * The DemonstrationEvaluation´s txtJustification.
     */
    private String txtJustification;
    /**
     * The DemonstrationEvaluation´s attribution.
     */
    private StaffAttribution attribution;

    /**
     * The decision of DemonstrationEvaluation by default.
     */
    private static final boolean DECISION = false;

    /**
     * The justification of DemonstrationEvaluation by default.
     */
    private static final String TXT_JUSTIFICATION = "txtJustification";

    /**
     * The attribution DemonstrationEvaluation by default.
     */
    private static final StaffAttribution ATTRIBUTION = new StaffAttribution();

    /**
     * Default constructor of a DemonstrationEvaluation class.
     */
    public DemonstrationEvaluation() {
        this.decision = DECISION;
        this.txtJustification = TXT_JUSTIFICATION;
        this.attribution = ATTRIBUTION;
    }

    /**
     * Constructor of a DemonstrationEvaluation class.
     *
     * @param decision
     * @param txtJustification
     * @param attribution
     */
    public DemonstrationEvaluation(boolean decision, String txtJustification, StaffAttribution attribution) {
        this.decision = decision;
        this.txtJustification = txtJustification;
        this.attribution = attribution;
    }

    /**
     * Constructor of a DemonstrationEvaluation class copying another instance
     * of ExhibitionEvaluation class.
     *
     * @param demonstrationEvaluation
     */
    public DemonstrationEvaluation(DemonstrationEvaluation demonstrationEvaluation) {
        this.decision = demonstrationEvaluation.decision;
        this.txtJustification = demonstrationEvaluation.txtJustification;
        this.attribution = demonstrationEvaluation.attribution;
    }

    /**
     * Obtain the DemonstrationEvaluation's decision.
     *
     * @return the DemonstrationEvaluation's decision
     */
    public boolean isDecision() {
        return decision;
    }

    /**
     * Obtain the DemonstrationEvaluation's justification.
     *
     * @return the DemonstrationEvaluation's txtJustification
     */
    public String getTxtJustification() {
        return txtJustification;
    }

    /**
     * Obtain the DemonstrationEvaluation's attribution.
     *
     * @return the DemonstrationEvaluation's attribution
     */
    public StaffAttribution getAttribution() {
        return attribution;
    }

    /**
     * Set the DemonstrationEvaluation's name.
     *
     * @param decision the DemonstrationEvaluation's decision to set
     */
    public void setDecision(boolean decision) {
        this.decision = decision;
    }

    /**
     * Set the DemonstrationEvaluation's justification text.
     *
     * @param txtJustification the DemonstrationEvaluation's justification to
     * set
     */
    public void setTxtJustification(String txtJustification) {
        this.txtJustification = txtJustification;
    }

    /**
     * Set the DemonstrationEvaluation's attribution text.
     *
     * @param attribution the DemonstrationEvaluation's attribution to set
     */
    public void setAttribution(StaffAttribution attribution) {
        this.attribution = attribution;
    }

    /**
     * Return the textual representation of an ExhibitionEvaluation.
     *
     * @return the textual representation of an ExhibitionEvaluation
     */
    @Override
    public String toString() {
        return String.format("DemonstrationEvaluation{%njustification=%s %ndecision=%s %nattribution number=%s}", this.txtJustification, this.decision, this.attribution);
    }
}
