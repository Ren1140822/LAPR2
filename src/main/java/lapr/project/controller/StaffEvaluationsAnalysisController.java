/**
 * Package location for Application Controllers concepts.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.Record;
import lapr.project.model.StaffMemberAnalytic;

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
     * Constructs a Staff Evaluations Analysis Controller.
     *
     * @param exhibitionCenter the exhibitions center
     */
    public StaffEvaluationsAnalysisController(ExhibitionCenter exhibitionCenter) {

        this.exhibitionCenter = exhibitionCenter;
    }

    /**
     * Calculates the staff evaluations analytics.
     * 
     * @return a list with the staff evaluations analytics
     */
    public List<StaffMemberAnalytic> getStaffAnalyticsList() {
        
        Record record = this.exhibitionCenter.getRecord();
        
        return record.calculateStaffAnalytics();
    }
}
