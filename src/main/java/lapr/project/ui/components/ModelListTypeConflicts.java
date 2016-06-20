/**
 * Package location for UI components classes.
 */
package lapr.project.ui.components;

import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.model.ConflictType;

/**
 * Model list for conflicts types.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ModelListTypeConflicts extends AbstractListModel {

    /**
     * The resources list.
     */
    private final List<ConflictType> conflictsTypesList;

    /**
     * Creates an instance of model conflicts types list receiving the
     * conflictsTypesList.
     *
     * @param conflictsTypesList the new conflicts types list
     */
    public ModelListTypeConflicts(List<ConflictType> conflictsTypesList) {
        this.conflictsTypesList = conflictsTypesList;
    }

    @Override
    public int getSize() {
        return this.conflictsTypesList.size();
    }

    @Override
    public Object getElementAt(int i) {
        return this.conflictsTypesList.get(i).getDescription();
    }

}
