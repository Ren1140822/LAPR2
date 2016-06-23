/**
 * Package location for Application Controllers concepts.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.Record;
import lapr.project.model.StaffMemberAnalytic;
import lapr.project.model.StaffMemberAnalytic.ConfidenceIntervals;

/**
 * Represents the controller for a staff evaluations analysis.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class StaffEvaluationsAnalysisController {

    /**
     * The exhibitions center
     */
    private final ExhibitionCenter exhibitionCenter;

    /**
     * The staff evaluations analytics.
     */
    private List<StaffMemberAnalytic> analytics;

    /**
     * Constructs a Staff Evaluations Analysis Controller.
     *
     * @param exhibitionCenter the exhibitions center
     */
    public StaffEvaluationsAnalysisController(ExhibitionCenter exhibitionCenter) {

        this.exhibitionCenter = exhibitionCenter;
        this.analytics = new ArrayList<>();
    }

    /**
     * Calculates the staff evaluations analytics.
     *
     * @return a list with the staff evaluations analytics
     */
    public List<StaffMemberAnalytic> getStaffAnalyticsList() {

        Record record = this.exhibitionCenter.getRecord();

        this.analytics = record.calculateStaffAnalytics();

        return this.analytics;
    }

    /**
     * Updates all analytics warnings to true if the hypothesis test value is in
     * the critical region.
     *
     * @param confidenceIntervals The confidence interval selected
     */
    public void updateWarnings(ConfidenceIntervals confidenceIntervals) {
        for (StaffMemberAnalytic analytic : analytics) {
            analytic.updateWarning(confidenceIntervals);
        }
    }
}
