/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.components;

import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.controller.ExhibitionApplicationController;
import lapr.project.model.Keyword;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class ModelKeywordsList extends AbstractListModel {
       /**
     * exhibition application controller.
     */
    private final ExhibitionApplicationController controller;
    /**
     * List of products.
     */
    private List<Keyword> keyWordList;

    /**
     * Contructs an instance of this class.
     *
     * @param controller controller of an exhibition application
     */
    public ModelKeywordsList( ExhibitionApplicationController controller) {

        this.controller = controller;
         this.keyWordList = controller.getKeyWordList();
    }

    /**
     * Obtains the number of elements in the list
     *
     * @return number of elements
     */
    @Override
    public int getSize() {

        return  this.keyWordList .size();
    }

    /**
     * Obtains the element in the index
     *
     * @param index  index of the list
     * @return the object
     */
    @Override
    public Object getElementAt(int index) {

        return this.keyWordList.get(index).getDescription();
    }

    /**
     * Adds a product to the list.
     *
     * @param designation the product designation
     * @return true if added sucessfully
     */
    public boolean addRow(String designation) {
        int rowCount = getSize();

        boolean keyWordAdded = this.controller.newKeyword(designation);

        if (keyWordAdded) {
            this.keyWordList  = this.controller.getKeyWordList();
            fireIntervalAdded(this, rowCount, rowCount);
        }
        return keyWordAdded;
    }

    /**
     * Removes a product in the selected index
     *
     * @param index the index
     * @return true if removed sucessfully
     */
    public boolean removeRow(int index) {

        String designation = (String) getElementAt(index);

       boolean keyWordRemoved = this.controller.newKeyword(designation);
        if (keyWordRemoved) {
          keyWordList = this.controller.getKeyWordList();
            fireIntervalRemoved(this, index, index);
        }
        return keyWordRemoved;
    }
}
