/**
 * Package location for Model and concepts.
 */
package lapr.project.model.exhibition;

import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionState;

/**
 * Represents the open applications state of a Exhibition.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ExhibitionOpenApplicationsState implements ExhibitionState {

    /**
     * The exhibition to change state.
     */
    private final Exhibition exhibition;

    /**
     * Default constructor of an exhibition's open applications state state.
     *
     * @param exhibition Exhibition to change state
     */
    public ExhibitionOpenApplicationsState(Exhibition exhibition) {

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
        return false;
    }

    @Override
    public boolean setStaffDefined() {
        return false;
    }

    @Override
    public boolean isStaffDefined() {
        return false;
    }

    @Override
    public boolean setDemonstrationsDefined() {
        return false;
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
        return true;
    }

    @Override
    public boolean setClosedApplications() {
        if (validate()) {
            this.exhibition.setState(new ExhibitionClosedApplicationsState(this.exhibition));
            return true;
        } else {
            return false;
        }
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

    @Override
    public boolean validate() {

        return true;
    }

  

}
