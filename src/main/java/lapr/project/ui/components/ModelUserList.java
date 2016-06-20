/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.components;

import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.controller.DefineStaffController;
import lapr.project.model.User;


/**
 * Model list for products.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ModelUserList extends AbstractListModel {

    /**
     * exhibition application controller.
     */
    private final DefineStaffController controller;
    /**
     * List of products.
     */
    private List<User> usersList;

    /**
     * Contructs an instance of this class.
     *
     * @param controller controller of an exhibition application
     */
    public ModelUserList(DefineStaffController controller) {

        this.controller = controller;
        this.usersList = this.controller.getUserList();
    }

    /**
     * Obtains the number of elements in the list
     *
     * @return number of elements
     */
    @Override
    public int getSize() {

        return this.usersList.size();
    }

    /**
     * Obtains the element in the index
     *
     * @param index index of the list
     * @return the object
     */
    @Override
    public Object getElementAt(int index) {

        return   this.usersList.get(index);
    }

    /**
     * Adds a product to the list.
     *
     * @param designation the product designation
     * @return true if added sucessfully
     */
    public boolean addRow(Object obj) {
        int rowCount = getSize();
        User user = (User)obj;
        boolean staffAdded = this.controller.newStaffMember(user);

        if (staffAdded) {
           this.usersList= this.controller.getUserList();
            fireIntervalAdded(this, rowCount, rowCount);
        }
        return  staffAdded;
    }

    /**
     * Removes a product in the selected index
     *
     * @param index the index
     * @return true if removed sucessfully
     */
//    public boolean removeRow(int index) {
//
//        String designation = (String) getElementAt(index);
//
//        boolean productRemoved = this.controller.
//        if (productRemoved) {
//            productsList = this.controller.getProductsList();
//            fireIntervalRemoved(this, index, index);
//        }
//        return productRemoved;
//    }
}
