/**
 * Package location for UI components classes.
 */
package lapr.project.ui.components;

import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.model.StaffAttributionMechanism;

/**
 * Model of communication for mechanisms list
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ModelListMechanisms extends AbstractListModel {

    /**
     * List of staff attributions mechanisms.
     */
    private final List<StaffAttributionMechanism> staffAttributionsMechanismsList;

    /**
     * Builds up an instance of ModelListMechanisms.
     *
     * @param staffAttributionsMechanismsList List of staff attributions mechanisms.
     */
    public ModelListMechanisms(List<StaffAttributionMechanism> staffAttributionsMechanismsList) {

        this.staffAttributionsMechanismsList = staffAttributionsMechanismsList;
    }

    /**
     * Gets the number of elements of the list
     *
     * @return number of elements
     */
    @Override
    public int getSize() {
        return this.staffAttributionsMechanismsList.size();
    }

    /**
     * Gets the list element at the specified index.
     *
     * @param index index of the list
     * @return an element of the list.
     */
    @Override
    public Object getElementAt(int index) {

        return this.staffAttributionsMechanismsList.get(index).getDescription();
    }

}
