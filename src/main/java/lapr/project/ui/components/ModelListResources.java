/**
 * Package location for UI components classes.
 */
package lapr.project.ui.components;

import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.model.Resource;

/**
 * Model list for products.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ModelListResources extends AbstractListModel {

    /**
     * The resources list.
     */
    private final List<Resource> resourcesList;

    /**
     * Creates an instance of model list resources receiving the resources list.
     *
     * @param resourcesList resources list
     */
    public ModelListResources(List<Resource> resourcesList) {
        this.resourcesList = resourcesList;
    }

    @Override
    public int getSize() {
        return this.resourcesList.size();
    }

    @Override
    public Object getElementAt(int i) {
        return this.resourcesList.get(i).getDesignation();
    }

}
