/*
 * Fornece classes para componentes do UI do centro de exposições.
 */
package lapr.project.ui.components;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import lapr.project.model.StaffAttribution;

/**
 * Modelo de comunicação para a lista de atribuições.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class ModelTableAttributions extends AbstractTableModel {

    /**
     * Nome das colunas da tabela.
     */
    private static final String[] nomesColunas = {"Nome de Empresa", "FAE"};
    /**
     * Lista de atribuições
     */
    private final List<StaffAttribution> listaAtribuicoes;

    /**
     * Cria uma instâncida de ModeloTabelaAtribuicoes.
     *
     * @param listaAtribuicoes lista de atribuições
     */
    public ModelTableAttributions(List<StaffAttribution> listaAtribuicoes) {
        this.listaAtribuicoes = listaAtribuicoes;
    }

    /**
     * Devolve o número de linhas da tabela.
     *
     * @return número de linhas
     */
    @Override
    public int getRowCount() {
        return listaAtribuicoes.size();
    }

    /**
     * Devolve o número de colunas da tabela.
     *
     * @return número de colunas da tabela
     */
    @Override
    public int getColumnCount() {
        return nomesColunas.length;
    }

    /**
     * Devolve o nome da coluna a partir do seu índice.
     *
     * @param column índica da coluna
     * @return nome da coluna
     */
    @Override
    public String getColumnName(int column) {
        return nomesColunas[column];
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

        return columnIndex == 0 ? listaAtribuicoes.get(rowIndex).getApplication().getTitle()
                : listaAtribuicoes.get(rowIndex).getStaffMember().getUser().getName();
    }

}
