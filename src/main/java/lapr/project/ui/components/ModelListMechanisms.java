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
     * Lista de mecanismos.
     */
    private List<StaffAttributionMechanism> staffAttributionsMechanismsList;

    /**
     * Constrói uma instância de ModelListMecanismos.
     *
     * @param staffAttributionsMechanismsList lista de mecanismos
     */
    public ModelListMechanisms(List<StaffAttributionMechanism> staffAttributionsMechanismsList) {

        this.staffAttributionsMechanismsList = staffAttributionsMechanismsList;
    }

    /**
     * Obtém o número de elementos da lista.
     *
     * @return número de elementos
     */
    @Override
    public int getSize() {
        return this.staffAttributionsMechanismsList.size();
    }

    /**
     * Obtém o elemento da lista no índice indicado.
     *
     * @param index índice da lista
     * @return elemento da lista.
     */
    @Override
    public Object getElementAt(int index) {

        return this.staffAttributionsMechanismsList.get(index).getDescription();
    }

}
