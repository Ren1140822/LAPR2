/**
 * Package location for UI components classes.
 */
package lapr.project.ui.components;

import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.model.ExhibitionApplication;

/**
 * Model list for products.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ModelListExhibitionApplications extends AbstractListModel {

    /**
     * Exhibition applications list.
     */
    private final List<ExhibitionApplication> exhibitionApplicationsList;

    /**
     * Constructs an instance of model list exhibition applications.
     *
     * @param exhibitionApplicationsList exhibition applications list
     */
    public ModelListExhibitionApplications(List<ExhibitionApplication> exhibitionApplicationsList) {
        this.exhibitionApplicationsList = exhibitionApplicationsList;
    }

    @Override
    public int getSize() {
        return this.exhibitionApplicationsList.size();
    }

    @Override
    public Object getElementAt(int i) {
        return this.exhibitionApplicationsList.get(i).getTitle();
    }

}
