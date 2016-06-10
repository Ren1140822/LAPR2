/**
 * Package location for UI components classes.
 */
package lapr.project.ui.components;

import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.model.Submittable;

/**
 * Model list for submittables.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ModelListSubmittables extends AbstractListModel {

    /**
     * The submittables list;
     */
    private final List<Submittable> submittablesList;

    /**
     * Constructs a model list for submittables.
     * 
     * @param submittablesList submittables list
     */
    public ModelListSubmittables(List<Submittable> submittablesList) {
        this.submittablesList = submittablesList;
    }

    
    @Override
    public int getSize() {
        return this.submittablesList.size();
    }

    @Override
    public Object getElementAt(int i) {
        return this.submittablesList.get(i).getShortInfo();
    }
}
