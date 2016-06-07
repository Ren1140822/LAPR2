/**
 * Package location for Model concepts.
 */
package lapr.project.model;

/**
 * Represents an ExhibitionEvaluation
 *F
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ExhibitionEvaluation {

    /**
     * The ExhibitionEvaluation´s decision.
     */
    private boolean decision;
    /**
     * The ExhibitionEvaluation´s txtJustification.
     */
    private String txtJustification;
    /**
     * The ExhibitionEvaluation´s attribution.
     */
    private StaffAttribution attribution;

    /**
     * The decision of exhibitionEvaluation by default.
     */
    private static final boolean DECISION = false;

    /**
     * The justification of exhibitionEvaluation by default.
     */
    private static final String TXT_JUSTIFICATION = "txtJustification";

    /**
     * The attribution exhibitionEvaluation by default.
     */
    private static final StaffAttribution ATTRIBUTION = new StaffAttribution();

    /**
     * Default constructor of a ExhibitionEvaluation class.
     */
    public ExhibitionEvaluation() {
        this.decision = DECISION;
        this.txtJustification = TXT_JUSTIFICATION;
        this.attribution = ATTRIBUTION;
    }

    /**
     * Constructor of a ExhibitionEvaluation class.
     *
     * @param decision
     * @param txtJustification
     * @param attribution
     */
    public ExhibitionEvaluation(boolean decision, String txtJustification, StaffAttribution attribution) {
        this.decision = decision;
        this.txtJustification = txtJustification;
        this.attribution = attribution;
    }

    /**
     * Constructor of a ExhibitionEvaluation class copying another instance of
     * ExhibitionEvaluation class.
     *
     * @param exhibitionEvaluation
     */
    public ExhibitionEvaluation(ExhibitionEvaluation exhibitionEvaluation) {
        this.decision = exhibitionEvaluation.decision;
        this.txtJustification = exhibitionEvaluation.txtJustification;
        this.attribution = exhibitionEvaluation.attribution;
    }

    /**
     * Obtain the ExhibitionEvaluation's decision.
     *
     * @return the ExhibitionEvaluation's decision
     */
    public boolean isDecision() {
        return decision;
    }

    /**
     * Obtain the ExhibitionEvaluation's justification.
     *
     * @return the ExhibitionEvaluation's txtJustification
     */
    public String getTxtJustification() {
        return txtJustification;
    }

    /**
     * Obtain the ExhibitionEvaluation's attribution.
     *
     * @return the ExhibitionEvaluation's attribution
     */
    public StaffAttribution getAttribution() {
        return attribution;
    }

    /**
     * Set the ExhibitionEvaluation's name.
     *
     * @param decision the ExhibitionEvaluation's decision to set
     */
    public void setDecision(boolean decision) {
        this.decision = decision;
    }

    /**
     * Set the ExhibitionEvaluation's justification text.
     *
     * @param txtJustification the ExhibitionEvaluation's justification to set
     */
    public void setTxtJustification(String txtJustification) {
        this.txtJustification = txtJustification;
    }

    /**
     * Set the ExhibitionEvaluation's attribution text.
     *
     * @param attribution the ExhibitionEvaluation's attribution to set
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
        return String.format("ExhibitionEvaluation{%njustification=%s %ndecision=%s %nattribution number=%s}", this.txtJustification, this.decision, this.attribution);
    }

}
