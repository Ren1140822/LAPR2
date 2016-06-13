/**
 * Package location for UI components classes.
 */
package lapr.project.ui.components;

import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.model.Product;

/**
 * Model list for products.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ModelListProducts extends AbstractListModel {

    /**
     * Products list.
     */
    private final List<Product> productsList;

    /**
     * Constructs an instance of model list products.
     *
     * @param productsList products list
     */
    public ModelListProducts(List<Product> productsList) {
        this.productsList = productsList;
    }

    @Override
    public int getSize() {
        return this.productsList.size();
    }

    @Override
    public Object getElementAt(int i) {
        return this.productsList.get(i).getDesignation();
    }

}
