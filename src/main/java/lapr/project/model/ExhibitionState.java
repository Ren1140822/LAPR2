/**
 * Package location for Model concepts.
 */
package lapr.project.model;

/**
 * Represents the ExhibitionState
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public interface ExhibitionState {

    /**
     * sets the exhibition state as exhibition created.
     * 
     */
    boolean setExhibitionCreated();

    /**
     * checks if current state is exhibition created.
     */
    boolean isExhibitionCreated();

    /**
     * sets the exhibition state as staff member without demonstration.
     */
    boolean setExhibitionStaffMemberWithoutDemonstration();

    /**
     * checks if current state is staff member without demonstration.
     */
    boolean isExhibitionStaffMemberWithoutDemonstration();

    /**
     * sets the exhibition state as exhibition created.
     */
    boolean setExhibitionDemonstrationWithoutStaffMember();

    /**
     * checks if current state is demonstration without staff member.
     */
    boolean isExhibitionDemonstrationWithoutStaffMember();

    /**
     * sets the exhibition state as information complete.
     */
    boolean setExhibitionInformationComplete();

    /**
     * checks if current state is information complete.
     */
    boolean isExhibitionInformationComplete();

    /**
     * sets the exhibition state as open application.
     */
    boolean setExhibitionOpenApplication();

    /**
     * checks if current state is open application.
     */
    boolean isExhibitionOpenApplication();

    /**
     * sets the exhibition state as closed application.
     */
    boolean setExhibitionClosedApplication();

    /**
     * checks if current state is closed application.
     */
    boolean isExhibitionClosedApplication();

    /**
     * sets the exhibition state as detected conflicts.
     */
    boolean setExhibitionDetectedConficts();

    /**
     * checks if current state is detected conflicts.
     */
    boolean isExhibitionDetectedConficts();

    /**
     * sets the exhibition state as changed conflicts.
     */
    boolean setExhibitionChangedConflitcts();

    /**
     * checks if current state is changed conflicts.
     */
    boolean isExhibitionChangedConflitcts();

    /**
     * sets the exhibition state as applications in evaluation.
     */
    boolean setExhibitionApplicationsInEvaluation();

    /**
     * checks if current state is applications in evaluation.
     */
    boolean isExhibitionApplicationsInEvaluation();

    /**
     * sets the exhibition state as application in decision period.
     */
    boolean setExhibitionApplicationInDecisionPeriod();

    /**
     * checks if current state is application in decision period.
     */
    boolean isExhibitionApplicationInDecisionPeriod();

    /**
     * sets the exhibition state as evaluated application.
     */
    boolean setExhibitionWithEvaluatedApplication();

    /**
     * checks if current state is evaluated application.
     */
    boolean isExhibitionWithEvaluatedApplication();

    /**
     * sets the exhibition state as attributed stands without demonstration
     * decided.
     */
    boolean setExhibitionWithAttributedStandsWithoutDemonstrationsDecided();

    /**
     * checks if current state is attributed stands without demonstration
     * decided.
     */
    boolean isExhibitionWithAttributedStandsWithoutDemonstrationsDecided();

    /**
     * sets the exhibition state as demonstration decided without attributed
     * stands.
     */
    boolean setExhibitionDemonstrationsDecidedWithoutAttributedStands();

    /**
     * checks if current state is demonstration decided without attributed
     * stands.
     */
    boolean isExhibitionDemonstrationsDecidedWithoutAttributedStands();

    /**
     * sets the exhibition state as demonstrations decided and attributed
     * stands.
     */
    boolean setExhibitionWithDemonstrationsDecidedAndAttributedStands();

    /**
     * checks if current state is demonstrations decided and attributed stands.
     */
    boolean isExhibitionWithDemonstrationsDecidedAndAttributedStands();

    /**
     * sets the exhibition state as open applications and demonstrations.
     */
    boolean setExhibitionWithOpenApplicationsAndDemonstrations();

    /**
     * checks if current state is open applications and demonstrations.
     */
    boolean isExhibitionWithOpenApplicationsAndDemonstrations();

    /**
     * sets the exhibition state as closed applications and demonstrations.
     */
    boolean setExhibitionWithClosedApplicationsAndDemonstations();

    /**
     * checks if current state is closed applications and demonstrations.
     */
    boolean isExhibitionWithClosedApplicationsAndDemonstations();

    /**
     * Validate if the the state gathers all necessary information to transit to
     * next state.
     *
     * @return true if the state gathers the information to transit, false
     * otherwise
     */
    boolean validate();
}
