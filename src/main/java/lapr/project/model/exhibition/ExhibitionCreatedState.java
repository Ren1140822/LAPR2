/**
 * Package location for Model and concepts.
 */
package lapr.project.model.exhibition;

import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionState;

/**
 * Represents the created state of a exhibition.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ExhibitionCreatedState implements ExhibitionState {

    /**
     * The exhibition to change state.
     */
    private final Exhibition exhibition;

    /**
     * Default constructor of an exhibition's created state.
     *
     * @param exhibition Exhibition to change state
     */
    public ExhibitionCreatedState(Exhibition exhibition) {

        this.exhibition = exhibition;
    }

    @Override
    public boolean isInicial() {
        return false;
    }

    @Override
    public boolean setCreated() {

        return false;
    }

    @Override
    public boolean isCreated() {
        return true;
    }

    @Override
    public boolean setStaffDefined() {

        if (validate()) {
            // TODO : Implement next state
//            this.exhibition.setState(this);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isStaffDefined() {
        return false;
    }

    @Override
    public boolean setDemonstrationsDefined() {

        if (validateDemos()) {
            // TODO : Implement next state
//            this.exhibition.setState(this);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isDemonstrationsDefined() {
        return false;
    }

    @Override
    public boolean setOpenApplication() {
        return false;
    }

    @Override
    public boolean isOpenApplications() {
        return false;
    }

    @Override
    public boolean setClosedApplications() {
        return false;
    }

    @Override
    public boolean isClosedApplications() {
        return false;
    }

    @Override
    public boolean setDetectedConficts() {
        return false;
    }

    @Override
    public boolean isDetectedConficts() {
        return false;
    }

    @Override
    public boolean setChangedConflitcts() {
        return false;
    }

    @Override
    public boolean isChangedConflitcts() {
        return false;
    }

    @Override
    public boolean setApplicationsInEvaluation() {
        return false;
    }

    @Override
    public boolean isApplicationsInEvaluation() {
        return false;
    }

    @Override
    public boolean setApplicationsInDecision() {
        return false;
    }

    @Override
    public boolean isApplicationsInDecision() {
        return false;
    }

    @Override
    public boolean setApplicationsDecided() {
        return false;
    }

    @Override
    public boolean isApplicationsDecided() {
        return false;
    }

    /**
     * Validates if at least one staff member is defined.
     *
     * @return true if staff is defined.
     */
    @Override
    public boolean validate() {

        // Verifies if at least one Staff Member is defined.
        return !this.exhibition.getStaffList().getStaffList().isEmpty();
    }

    /**
     * Validates if at least one demonstration is defined.
     *
     * @return true if staff is defined.
     */
    public boolean validateDemos() {

        // Verifies if at least one Staff Member is defined.
        return !this.exhibition.getDemonstrationsList().getDemonstrationsList().isEmpty();
    }
}
