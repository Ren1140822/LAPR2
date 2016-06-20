/**
 * Package location for UI components classes.
 */
package lapr.project.ui.components;

import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.utils.Exportable;

/**
 * Model list for exportables.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ModelListExportables extends AbstractListModel {

    /**
     * Exportables list.
     */
    private final List<Exportable> exportablesList;

    /**
     * Constructs an instance of model list exportables.
     *
     * @param exportablesList exportables list
     */
    public ModelListExportables(List<Exportable> exportablesList) {
        this.exportablesList = exportablesList;
    }

    @Override
    public int getSize() {
        return this.exportablesList.size();
    }

    @Override
    public Object getElementAt(int i) {
        return this.exportablesList.get(i).getData();
    }
}
