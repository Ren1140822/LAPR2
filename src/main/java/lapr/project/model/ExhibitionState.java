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
 */
    public abstract boolean setExhibitionCreated();
/**
 * checks if current state is exhibition created.
 */
    public abstract boolean isExhibitionCreated();
/**
 * sets the exhibition state as staff member without demonstration.
 */
    public abstract boolean setExhibitionStaffMemberWithoutDemonstration();
/**
 * checks if current state is staff member without demonstration.
 */
 
    public abstract boolean isExhibitionStaffMemberWithoutDemonstration();
/**
 * sets the exhibition state as exhibition created.
 */
    public abstract boolean setExhibitionDemonstrationWithoutStaffMember();
/**
 * checks if current state is demonstration without staff member.
 */
    public abstract boolean isExhibitionDemonstrationWithoutStaffMember();
/**
 * sets the exhibition state as information complete.
 */
    public abstract boolean setExhibitionInformationComplete();
/**
 * checks if current state is information complete.
 */
    public abstract boolean isExhibitionInformationComplete();
/**
 * sets the exhibition state as open application.
 */
    public abstract boolean setExhibitionOpenApplication();
/**
 * checks if current state is open application.
 */
    public abstract boolean isExhibitionOpenApplication();
/**
 * sets the exhibition state as closed application.
 */
    public abstract boolean setExhibitionClosedApplication();
/**
 *checks if current state is  closed application.
 */
    public abstract boolean isExhibitionClosedApplication();
/**
 * sets the exhibition state as detected conflicts.
 */
    public abstract boolean setExhibitionDetectedConficts();
/**
 * checks if current state is detected conflicts.
 */
    public abstract boolean isExhibitionDetectedConficts();
/**
 * sets the exhibition state as  changed conflicts.
 */
    public abstract boolean setExhibitionChangedConflitcts();
/**
 * checks if current state is  changed conflicts.
 */
    public abstract boolean isExhibitionChangedConflitcts();
/**
 * sets the exhibition state as applications in evaluation.
 */
    public abstract boolean setExhibitionApplicationsInEvaluation();
/**
 * checks if current state is applications in evaluation.
 */
    public abstract boolean isExhibitionApplicationsInEvaluation();
/**
 * sets the exhibition state as application in decision period.
 */
    public abstract boolean setExhibitionApplicationInDecisionPeriod();
/**
 * checks if current state is application in decision period.
 */
    public abstract boolean isExhibitionApplicationInDecisionPeriod();
/**
 * sets the exhibition state as evaluated application.
 */
    public abstract boolean setExhibitionWithEvaluatedApplication();
/**
 * checks if current state is evaluated application.
 */
    public abstract boolean isExhibitionWithEvaluatedApplication();
/**
 * sets the exhibition state as  attributed stands without demonstration decided.
 */
    public abstract boolean setExhibitionWithAttributedStandsWithoutDemonstrationsDecided();
/**
 * checks if current state is  attributed stands without demonstration decided.
 */
    public abstract boolean isExhibitionWithAttributedStandsWithoutDemonstrationsDecided();
/**
 * sets the exhibition state as demonstration decided without attributed stands.
 */
    public abstract boolean setExhibitionDemonstrationsDecidedWithoutAttributedStands();
/**
 * checks if current state is demonstration decided without attributed stands.
 */
    public abstract boolean isExhibitionDemonstrationsDecidedWithoutAttributedStands();
/**
 * sets the exhibition state as demonstrations decided and attributed stands.
 */
    public abstract boolean setExhibitionWithDemonstrationsDecidedAndAttributedStands();
/**
 * checks if current state is  demonstrations decided and attributed stands.
 */
    public abstract boolean isExhibitionWithDemonstrationsDecidedAndAttributedStands();
/**
 * sets the exhibition state as open applications and demonstrations.
 */
    public abstract boolean setExhibitionWithOpenApplicationsAndDemonstrations();
/**
 * checks if current state is open applications and demonstrations.
 */
    public abstract boolean isExhibitionWithOpenApplicationsAndDemonstrations();
/**
 * sets the exhibition state as closed applications and demonstrations.
 */
    public abstract boolean setExhibitionWithClosedApplicationsAndDemonstations();
/**
 * checks if current state is closed applications and demonstrations.
 */
    public abstract boolean isExhibitionWithClosedApplicationsAndDemonstations();

}
