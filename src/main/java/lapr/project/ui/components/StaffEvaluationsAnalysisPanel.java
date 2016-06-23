/**
 * Package location for UI components classes.
 */
package lapr.project.ui.components;

import javax.swing.JTable;
import lapr.project.controller.StaffEvaluationsAnalysisController;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.StaffMember;

/**
 * Represents a panel with the staff evaluations analysis.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class StaffEvaluationsAnalysisPanel {

    /**
     * The staff evaluations analysis controller.
     */
    private StaffEvaluationsAnalysisController controller;
    
    /**
     * Output Table with staff evaluations analytics. 
     */
    private JTable analyticsTable;
    
    /**
     * Constructor of a panel with the staff evaluations analysis.
     *
     * @param exhibitionCenter the exhibition center
     */
    public StaffEvaluationsAnalysisPanel(ExhibitionCenter exhibitionCenter) {
        
        controller = new StaffEvaluationsAnalysisController(exhibitionCenter);
    }

}
