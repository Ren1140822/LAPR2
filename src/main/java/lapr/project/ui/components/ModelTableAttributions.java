/**
 * Package location for UI components classes.
 */
package lapr.project.ui.components;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import lapr.project.model.StaffAttribution;

/**
 * Model of communication for attributions list
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ModelTableAttributions extends AbstractTableModel {

    /**
     * Nome das colunas da tabela.
     */
    private static final String[] COLUMNS_NAMES = {"Exhibitor Name", "Staff Member"};
    /**
     * Lista de atribuições
     */
    private final List<StaffAttribution> staffAttributionList;

    /**
     * Cria uma instâncida de ModeloTabelaAtribuicoes.
     *
     * @param staffAttributionList lista de atribuições
     */
    public ModelTableAttributions(List<StaffAttribution> staffAttributionList) {
        this.staffAttributionList = staffAttributionList;
    }

    /**
     * Devolve o número de linhas da tabela.
     *
     * @return número de linhas
     */
    @Override
    public int getRowCount() {
        return staffAttributionList.size();
    }

    /**
     * Devolve o número de colunas da tabela.
     *
     * @return número de colunas da tabela
     */
    @Override
    public int getColumnCount() {
        return COLUMNS_NAMES.length;
    }

    /**
     * Devolve o nome da coluna a partir do seu índice.
     *
     * @param column índica da coluna
     * @return nome da coluna
     */
    @Override
    public String getColumnName(int column) {
        return COLUMNS_NAMES[column];
    }

    /**
     * Devolve a descrição do elemento especificado.
     *
     * @param rowIndex índice da linha
     * @param columnIndex índice da coluna
     * @return descrição do elemento
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        return columnIndex == 0 ? staffAttributionList.get(rowIndex).getApplication().getTitle()
                : staffAttributionList.get(rowIndex).getStaffMember().getUser().getName();
    }

}
