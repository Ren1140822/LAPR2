/**
 * Package location for Model and  concepts.
 */
package lapr.project.model.exhibition;

import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionState;
/**
 * Represents the ExhibitionState.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ExhibitionOpenApplicationState implements ExhibitionState  {

    /**
     * This instance's exhibition
     */
    private Exhibition exhibition;
    
    /**
     * Constructor receiving exhibition as parameter.
     * @param exhibition the exhibition received
     */
    public ExhibitionOpenApplicationState(Exhibition exhibition){
        this.exhibition = new Exhibition(exhibition);
    }
    
    
    @Override
    public boolean setExhibitionCreated() {
       return false;
    }

    @Override
    public boolean isExhibitionCreated() {
        return false;
    }

    @Override
    public boolean setExhibitionStaffMemberWithoutDemonstration() {
         return false;
    }

    @Override
    public boolean isExhibitionStaffMemberWithoutDemonstration() {
         return false;
    }

    @Override
    public boolean setExhibitionDemonstrationWithoutStaffMember() {
        return false;
    }

    @Override
    public boolean isExhibitionDemonstrationWithoutStaffMember() {
        return false;
    }

    @Override
    public boolean setExhibitionInformationComplete() {
       return false;
    }

    @Override
    public boolean isExhibitionInformationComplete() {
      return false;
    }

    @Override
    public boolean setExhibitionOpenApplication() {
        
       return false;
    }

    @Override
    public boolean isExhibitionOpenApplication() {
        return true;
    }

    @Override
    public boolean setExhibitionClosedApplication() {
     //TODO: IMPLEMENT THE NEW STATE CODE
        return true;
    }

    @Override
    public boolean isExhibitionClosedApplication() {
        return false;
    }

    @Override
    public boolean setExhibitionDetectedConficts() {
        return false;
    }

    @Override
    public boolean isExhibitionDetectedConficts() {
        return false;
    }

    @Override
    public boolean setExhibitionChangedConflitcts() {
       return false;
    }

    @Override
    public boolean isExhibitionChangedConflitcts() {
         return false;
    }

    @Override
    public boolean setExhibitionApplicationsInEvaluation() {
        return false;
    }

    @Override
    public boolean isExhibitionApplicationsInEvaluation() {
       return false;
    }

    @Override
    public boolean setExhibitionApplicationInDecisionPeriod() {
        return false;
    }

    @Override
    public boolean isExhibitionApplicationInDecisionPeriod() {
        return false;
    }

    @Override
    public boolean setExhibitionWithEvaluatedApplication() {
        return false;
    }

    @Override
    public boolean isExhibitionWithEvaluatedApplication() {
        return false;
    }

    @Override
    public boolean setExhibitionWithAttributedStandsWithoutDemonstrationsDecided() {
        return false;
    }

    @Override
    public boolean isExhibitionWithAttributedStandsWithoutDemonstrationsDecided() {
        return false;
    }

    @Override
    public boolean setExhibitionDemonstrationsDecidedWithoutAttributedStands() {
        return false;
    }

    @Override
    public boolean isExhibitionDemonstrationsDecidedWithoutAttributedStands() {
      return false;
    }

    @Override
    public boolean setExhibitionWithDemonstrationsDecidedAndAttributedStands() {
      return false;
    }

    @Override
    public boolean isExhibitionWithDemonstrationsDecidedAndAttributedStands() {
      return false;
    }

    @Override
    public boolean setExhibitionWithOpenApplicationsAndDemonstrations() {
      return false;
    }

    @Override
    public boolean isExhibitionWithOpenApplicationsAndDemonstrations() {
      return false;
    }

    @Override
    public boolean setExhibitionWithClosedApplicationsAndDemonstations() {
      return false;
    }

    @Override
    public boolean isExhibitionWithClosedApplicationsAndDemonstations() {
      return false;
    }
    
}
