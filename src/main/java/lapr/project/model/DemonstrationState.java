/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import com.sun.xml.internal.bind.AnyTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Represents the application state.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
 @XmlJavaTypeAdapter(AnyTypeAdapter.class)
public interface DemonstrationState {

    /**
     * Verify if the current demonstration state is decided state.
     * 
     * @return true if the demonstration state is decided state, false otherwise
     */
    boolean isDecided();

    /**
     * Changes the current demonstration state to decided state.
     * 
     * @return true if the state is changed to decided state, false otherwise
     */
    boolean setInDecided();

    /**
     * Verify if the current demonstration state is in opened applications state.
     * 
     * @return true if the demonstration state is in opened applications state, false otherwise
     */
    boolean isOpenedApplications();

    /**
     * Changes the current demonstration state to OpenedApplications state.
     * 
     * @return true if the state is changed to OpenedApplications state, false otherwise
     */
    boolean setOpenedApplications();

    /**
     * Verify if the current demonstration state is CLosedApplications state.
     * 
     * @return true if the demonstration state is CLosedApplications state, false otherwise
     */
    boolean isCLosedApplications();

    /**
     * Changes the current demonstration state to ClosedApplications state.
     * 
     * @return true if the state is changed to ClosedApplications state, false otherwise
     */
    boolean setClosedApplications();

    /**
     * Verify if the current demonstration state is DetectedConflicts state.
     * 
     * @return true if the demonstration state is in DetectedConflicts state, false otherwise
     */
    boolean isDetectedConflicts();

    /**
     * Changes the current demonstration state to in DetectedConflicts state.
     * 
     * @return true if the state is changed to in DetectedConflicts state, false otherwise
     */
    boolean setDetectedConflicts();

    /**
     * Verify if the current demonstration state is in ChangedConflicts state.
     * 
     * @return true if the demonstration state is in ChangedConflicts state, false otherwise
     */
    boolean isChangedConflicts();

    /**
     * Changes the current demonstration state to ChangedConflicts state.
     * 
     * @return true if the state is changed to ChangedConflicts state, false otherwise
     */
    boolean setChangedConflicts();

    /**
     * Verify if the current application state is ApplicationsInEvaluation state.
     * 
     * @return true if the demonstration state is ApplicationsInEvaluation state, false otherwise
     */
    boolean isApplicationsInEvaluation();

    /**
     * Changes the current demonstration state to ApplicationsInEvaluation state.
     * 
     * @return true if the state is changed to ApplicationsInEvaluation state, false otherwise
     */
    boolean setApplicationsInEvaluation();

    /**
     * Verify if the current demonstration state is InDecisionPeriod state.
     * 
     * @return true if the demonstration state is InDecisionPeriod state, false otherwise
     */
    boolean isApplicationsInDecisionPeriod();

    /**
     * Changes the current demonstration state to InDecisionPeriod state.
     * 
     * @return true if the state is changed to  InDecisionPeriod state, false otherwise
     */
    boolean setApplicationsInDecisionPeriod();
    
    /**
     * Verify if the current demonstration state is isApplicationsDecided state.
     * 
     * @return true if the demonstration state is isApplicationsDecided state, false otherwise
     */
    boolean isApplicationsDecided();

    /**
     * Changes the current demonstration state to isApplicationsDecided state.
     * 
     * @return true if the state is changed to isApplicationsDecided state, false otherwise
     */
    boolean setApplicationsDecided();

    boolean validate();
}
