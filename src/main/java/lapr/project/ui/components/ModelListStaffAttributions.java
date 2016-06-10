/**
 * Package location for UI components classes.
 */
package lapr.project.ui.components;

import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.model.StaffAttribution;

/**
 * Model list for staff attributions.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ModelListStaffAttributions extends AbstractListModel {

    /**
     * The submittables list;
     */
    private final List<StaffAttribution> staffAttributionsList;

    /**
     * Constructs a model list for staff attributions.
     *
     * @param staffAttributionsList staff attributions
     */
    public ModelListStaffAttributions(List<StaffAttribution> staffAttributionsList) {
        this.staffAttributionsList = staffAttributionsList;
    }

    @Override
    public int getSize() {
        return this.staffAttributionsList.size();
    }

    @Override
    public Object getElementAt(int i) {
        return this.staffAttributionsList.get(i).getApplication().getTitle();
    }
}
