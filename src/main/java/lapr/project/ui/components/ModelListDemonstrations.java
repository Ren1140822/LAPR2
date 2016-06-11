/**
 * Package location for UI components classes.
 */
package lapr.project.ui.components;

import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.model.Demonstration;

/**
 * Model list for demonstrations.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ModelListDemonstrations extends AbstractListModel {

    /**
     * Demonstrations list.
     */
    private final List<Demonstration> demonstrationsList;

    /**
     * Constructs an instance of model list demonstartions.
     *
     * @param demonstrationsList demonstrations list
     */
    public ModelListDemonstrations(List<Demonstration> demonstrationsList) {
        this.demonstrationsList = demonstrationsList;
    }

    @Override
    public int getSize() {
        return demonstrationsList.size();
    }

    @Override
    public Object getElementAt(int i) {
        return demonstrationsList.get(i).getShortInfo();
    }

}
