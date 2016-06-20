/**
 * Package location for UI concepts.
 */
package lapr.project.ui.components;


import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.controller.ExhibitionApplicationController;
import lapr.project.model.Product;

/**
 * Represents a model for a product List
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ModelProductList extends AbstractListModel {

   
    /**
     * List of products.
     */
    private List<Product> productsList;

    /**
     * Contructs an instance of this class.
     *
     * @param controller controller of an exhibition application
     */
    public ModelProductList( List<Product> productsList) {

    
         this.productsList = productsList;
    }

    /**
     * Obtains the number of elements in the list
     *
     * @return number of elements
     */
    @Override
    public int getSize() {

        return this.productsList .size();
    }

    /**
     * Obtains the element in the index
     *
     * @param index  index of the list
     * @return the object
     */
    @Override
    public Object getElementAt(int index) {

        return this.productsList .get(index).getDesignation();
    }

    /**
     * Adds a product to the list.
     *
     * @param designation the product designation
     * @return true if added sucessfully
     */
    public boolean addRow(boolean addedProduct, String designation,List<Product> productList) {
        int rowCount = getSize();

      

        if (addedProduct) {
           productsList  =productList;
            fireIntervalAdded(this, rowCount, rowCount);
        }
        return addedProduct;
    }

    /**
     * Removes a product in the selected index
     *
     * @param index the index
     * @return true if removed sucessfully
     */
    public boolean removeRow(int index,boolean productRemovedd,List<Product>productList) {

       

        boolean productRemoved =productRemovedd;
        if (productRemoved) {
          productsList  = productList;
            fireIntervalRemoved(this, index, index);
        }
        return productRemoved;
    }
}
