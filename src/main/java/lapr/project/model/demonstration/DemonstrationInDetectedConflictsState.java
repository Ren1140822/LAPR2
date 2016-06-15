/**
 * Package location for Model and concepts.
 */
package lapr.project.model.demonstration;

import lapr.project.model.Demonstration;
import lapr.project.model.DemonstrationState;

/**
 * Represents the detected conflicts state of a demonstration.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class DemonstrationInDetectedConflictsState implements DemonstrationState {
    
    /**
     * The demonstration to change state.
     */
    private final Demonstration demonstration;
    
    /**
     * Default constructor of an demonstration's detected conflicts state.
     *
     * @param demonstration Demonstration to change state
     */
    public DemonstrationInDetectedConflictsState(Demonstration demonstration) {

        this.demonstration = demonstration;
    }

    @Override
    public boolean isInicial() {
        return false;
    }
    
    @Override
    public boolean isDecided() {
        return false;
    }

    @Override
    public boolean setInDecided() {
        return false;
    }

    @Override
    public boolean isOpenedApplications() {
        return false;
    }

    @Override
    public boolean setOpenedApplications() {
        return false;
    }

    @Override
    public boolean isCLosedApplications() {
        return false;
    }

    @Override
    public boolean setClosedApplications() {
        return false;
    }

    @Override
    public boolean isDetectedConflicts() {
        return true;
    }

    @Override
    public boolean setDetectedConflicts() {
        return true;
    }

    @Override
    public boolean isChangedConflicts() {
        return false;
    }

    @Override
    public boolean setChangedConflicts() {
        if (validate()) {
            DemonstrationInChangedConflictsState newState = new DemonstrationInChangedConflictsState(demonstration);
            demonstration.setCurrentState(newState);
            return true;
        }
        return false;
    }

    @Override
    public boolean isApplicationsInEvaluation() {
        return false;
    }

    @Override
    public boolean setApplicationsInEvaluation() {
         return false;
    }

    @Override
    public boolean isApplicationsInDecisionPeriod() {
        return false;
    }

    @Override
    public boolean setApplicationsInDecisionPeriod() {
        return false;
    }

    @Override
    public boolean isApplicationsDecided() {
        return false;
    }

    @Override
    public boolean setApplicationsDecided() {
        return false;
    }

    @Override
    public boolean validate() {
        return (this.demonstration.getCurrentState().isDetectedConflicts());
    }
    
}
