/*
 * Fornece classes para componentes do UI do centro de exposições.
 */
package lapr.project.ui.components;

import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.model.StaffAttributionMechanism;

/**
 * Modelo de comunicação para a lista de mecanismos.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class ModelListMechanisms extends AbstractListModel {

    /**
     * Lista de mecanismos.
     */
    private List<StaffAttributionMechanism> listaMecanismos;

    /**
     * Constrói uma instância de ModelListMecanismos.
     *
     * @param listaMecanismos lista de mecanismos
     */
    public ModelListMechanisms(List<StaffAttributionMechanism> listaMecanismos) {

        this.listaMecanismos = listaMecanismos;
    }

    /**
     * Obtém o número de elementos da lista.
     *
     * @return número de elementos
     */
    @Override
    public int getSize() {
        return this.listaMecanismos.size();
    }

    /**
     * Obtém o elemento da lista no índice indicado.
     *
     * @param index índice da lista
     * @return elemento da lista.
     */
    @Override
    public Object getElementAt(int index) {

        return this.listaMecanismos.get(index).getDescription();
    }

}
