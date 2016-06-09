/**
 * Package location for Model and concepts.
 */
package lapr.project.model.exhibition;

import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionState;

/**
 * Represents the state of exhibition closed application.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ExhibitionClosedApplicationState implements ExhibitionState {

    /**
     * This instance's exhibition
     */
    private Exhibition exhibition;

    /**
     * Constructor receiving exhibition as parameter.
     *
     * @param exhibition the exhibition received
     */
    public ExhibitionClosedApplicationState(Exhibition exhibition) {
        this.exhibition = new Exhibition(exhibition);
    }

    /**
     * Sets exhibiton created state
     *
     * @return if its possible to set this state
     */
    @Override
    public boolean setExhibitionCreated() {
        return false;
    }

    /**
     * Returns if the exhibition state is this state.
     *
     * @return true if this instance's state is this one
     */
    @Override
    public boolean isExhibitionCreated() {
        return false;
    }

    /**
     * Sets exhibiton staff member without demonstration state.
     *
     * @return if its possible to set this state
     */
    @Override
    public boolean setExhibitionStaffMemberWithoutDemonstration() {
        return false;
    }

    /**
     * Returns if the exhibition state is this state.
     *
     * @return true if this instance's state is this one
     */
    @Override
    public boolean isExhibitionStaffMemberWithoutDemonstration() {
        return false;
    }

    /**
     * Sets exhibition demonstration without staff member state.
     *
     * @return if its possible to set this state
     */
    @Override
    public boolean setExhibitionDemonstrationWithoutStaffMember() {
        return false;
    }

    /**
     * Returns if the exhibition state is this state.
     *
     * @return true if this instance's state is this one
     */
    @Override
    public boolean isExhibitionDemonstrationWithoutStaffMember() {
        return false;
    }

    /**
     * Sets exhibiton information complete state.
     *
     * @return if its possible to set this state
     */
    @Override
    public boolean setExhibitionInformationComplete() {
        return false;
    }

    /**
     * Returns if the exhibition state is this state.
     *
     * @return true if this instance's state is this one
     */
    @Override
    public boolean isExhibitionInformationComplete() {
        return false;
    }

    /**
     * Sets exhibiton open application state.
     *
     * @return if its possible to set this state
     */
    @Override
    public boolean setExhibitionOpenApplication() {

        return false;
    }

    /**
     * Returns if the exhibition state is this state.
     *
     * @return true if this instance's state is this one
     */
    @Override
    public boolean isExhibitionOpenApplication() {
        return false;
    }

    /**
     * Sets exhibiton closed application state.
     *
     * @return if its possible to set this state
     */
    @Override
    public boolean setExhibitionClosedApplication() {

        return false;
    }

    /**
     * Returns if the exhibition state is this state.
     *
     * @return true if this instance's state is this one
     */
    @Override
    public boolean isExhibitionClosedApplication() {
        return true;
    }

    /**
     * Sets exhibiton c detected conflicts state.
     *
     * @return if its possible to set this state
     */
    @Override
    public boolean setExhibitionDetectedConficts() {
        //TODO IMPLEMENTS THE NEXT STATE CHANGE
        return true;
    }

    /**
     * Returns if the exhibition state is this state.
     *
     * @return true if this instance's state is this one
     */
    @Override
    public boolean isExhibitionDetectedConficts() {
        return false;
    }

    /**
     * Sets exhibiton changed conflicts state.
     *
     * @return if its possible to set this state
     */
    @Override
    public boolean setExhibitionChangedConflitcts() {
        return false;
    }

    /**
     * Returns if the exhibition state is this state.
     *
     * @return true if this instance's state is this one
     */
    @Override
    public boolean isExhibitionChangedConflitcts() {
        return false;
    }

    /**
     * Sets exhibiton applications in evaluation state.
     *
     * @return if its possible to set this state
     */
    @Override
    public boolean setExhibitionApplicationsInEvaluation() {
        return false;
    }

    /**
     * Returns if the exhibition state is this state.
     *
     * @return true if this instance's state is this one
     */
    @Override
    public boolean isExhibitionApplicationsInEvaluation() {
        return false;
    }

    /**
     * Sets exhibiton application in decision period state
     *
     * @return if its possible to set this state
     */
    @Override
    public boolean setExhibitionApplicationInDecisionPeriod() {
        return false;
    }

    /**
     * Returns if the exhibition state is this state.
     *
     * @return true if this instance's state is this one
     */
    @Override
    public boolean isExhibitionApplicationInDecisionPeriod() {
        return false;
    }

    /**
     * Sets exhibiton with evaluated application state.
     *
     * @return if its possible to set this state
     */
    @Override
    public boolean setExhibitionWithEvaluatedApplication() {
        return false;
    }

    /**
     * Returns if the exhibition state is this state.
     *
     * @return true if this instance's state is this one
     */
    @Override
    public boolean isExhibitionWithEvaluatedApplication() {
        return false;
    }

    /**
     * Sets exhibiton with attributed stands without demonstrations decided
     * state.
     *
     * @return if its possible to set this state
     */
    @Override
    public boolean setExhibitionWithAttributedStandsWithoutDemonstrationsDecided() {
        return false;
    }

    /**
     * Returns if the exhibition state is this state.
     *
     * @return true if this instance's state is this one
     */
    @Override
    public boolean isExhibitionWithAttributedStandsWithoutDemonstrationsDecided() {
        return false;
    }

    /**
     * Sets exhibiton demonstration decided without attributed stands.
     *
     * @return if its possible to set this state
     */
    @Override
    public boolean setExhibitionDemonstrationsDecidedWithoutAttributedStands() {
        return false;
    }

    /**
     * Returns if the exhibition state is this state.
     *
     * @return true if this instance's state is this one
     */
    @Override
    public boolean isExhibitionDemonstrationsDecidedWithoutAttributedStands() {
        return false;
    }

    /**
     * Sets exhibiton with demonstrations decided and attributed stands
     *
     * @return if its possible to set this state
     */
    @Override
    public boolean setExhibitionWithDemonstrationsDecidedAndAttributedStands() {
        return false;
    }

    /**
     * Returns if the exhibition state is this state.
     *
     * @return true if this instance's state is this one
     */
    @Override
    public boolean isExhibitionWithDemonstrationsDecidedAndAttributedStands() {
        return false;
    }

    /**
     * Sets exhibiton with open applications and demonstrations
     *
     * @return if its possible to set this state
     */
    @Override
    public boolean setExhibitionWithOpenApplicationsAndDemonstrations() {
        return false;
    }

    /**
     * Returns if the exhibition state is this state.
     *
     * @return true if this instance's state is this one
     */
    @Override
    public boolean isExhibitionWithOpenApplicationsAndDemonstrations() {
        return false;
    }

    /**
     * Sets exhibiton with closed applications and demonstrations
     *
     * @return if its possible to set this state
     */
    @Override
    public boolean setExhibitionWithClosedApplicationsAndDemonstations() {
        return false;
    }

    /**
     * Returns if the exhibition state is this state.
     *
     * @return true if this instance's state is this one
     */
    @Override
    public boolean isExhibitionWithClosedApplicationsAndDemonstations() {
        return false;
    }

}
