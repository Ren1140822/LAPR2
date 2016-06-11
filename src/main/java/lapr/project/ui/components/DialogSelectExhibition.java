/**
 * Package location for UI concepts.
 */
package lapr.project.ui.components;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionCenter;
import lapr.project.ui.DefineStaffMemberUI;

/**
 * Represents a select exhibition dialog
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class DialogSelectExhibition<T extends JFrame> extends JDialog {

    /**
     * The exhibition center.
     */
    private final ExhibitionCenter exhibitionCenter;

    /**
     * Frame that calls this one.
     */
    private final T parentFrame;
    /**
     * Exhibitons list.
     */
    private final List<Exhibition> exhibitionList;
    /**
     * Table with the exhibitions.
     */
    private JTable exhibitionListJTable;
    /**
     * Select exhibition button.
     */
    private JButton btnSelectExhibition;
    /**
     * Window title.
     */
    private static final String TITLE = "Select exhibition";
    /**
     * Text for selecting exhibition.
     */
    private static final String SELECT_EXHIBITION = "Select exhibition";

    /**
     * Constructs a dialog to select a exhibition.
     *
     * @param parentFrame the parent frame
     * @param  exhibitionList the list of exhibition
     * @param  exhibitionCenter the exhibition center
     */
    public DialogSelectExhibition(T parentFrame, List<Exhibition> exhibitionList, ExhibitionCenter exhibitionCenter) {
        super(parentFrame, TITLE, true);
        
        this.exhibitionCenter = exhibitionCenter;
        
        this.parentFrame = parentFrame;
        this.exhibitionList = exhibitionList;
        
        createComponents();
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(parentFrame);
        setVisible(true);
    }

    /**
     * Creates  the GUI components.
     */
    private void createComponents() {
        JPanel p1 = createSelectExhibitionPanel();
        JScrollPane p2 = criarPainelListaExposicoes();
        JPanel p3 = criarPainelBotoes();
        
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
    }

    /**
     * Creates the north panel.
     *
     * @return north panel
     */
    private JPanel createSelectExhibitionPanel() {
        JLabel lbl = new JLabel(SELECT_EXHIBITION, JLabel.CENTER);
        
        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));
        final int MARGIN_SUPERIOR = 10, MARGIN_INFERIOR = 0;
        final int MARGIN_RIGHT = 0, MARGIN_LEFT = 0;
        p.setBorder(new EmptyBorder(MARGIN_SUPERIOR, MARGIN_LEFT,
                MARGIN_INFERIOR, MARGIN_RIGHT));
        
        p.add(lbl);
        
        return p;
    }

    /**
     * Creates the center panel
     *
     * @return the center panel
     */
    private JScrollPane criarPainelListaExposicoes() {
        exhibitionListJTable = new JTable(new ModelTableExhibitionsList(exhibitionList));
        exhibitionListJTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        exhibitionListJTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (exhibitionListJTable.getSelectedRow() >= 0) {
                    btnSelectExhibition.setEnabled(true);
                } else {
                    btnSelectExhibition.setEnabled(false);
                }
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(exhibitionListJTable);
        
        final int MARGIN_SUPERIOR = 20, MARGIN_INFERIOR = 20;
        final int MARGIN_RIGHT = 20, MARGIN_LEFT = 20;
        scrollPane.setBorder(BorderFactory.createEmptyBorder(MARGIN_SUPERIOR, MARGIN_LEFT,
                MARGIN_INFERIOR, MARGIN_RIGHT));
        
        return scrollPane;
    }

    /**
     * Creates the south panel.
     *
     * @return south panel
     */
    private JPanel criarPainelBotoes() {
        this.btnSelectExhibition = criarBotaoSelecionarExposicao();
        getRootPane().setDefaultButton(this.btnSelectExhibition);
        
        JButton btnCancel = createCancelButton();
        
        JPanel p = new JPanel(new FlowLayout());
        final int MARGIN_SUPERIOR = 10, MARGIN_INFERIOR = 0;
        final int MARGIN_RIGHT = 0, MARGIN_LEFT = 0;
        p.setBorder(new EmptyBorder(MARGIN_SUPERIOR, MARGIN_LEFT,
                MARGIN_INFERIOR, MARGIN_RIGHT));
        p.add(this.btnSelectExhibition);
        p.add(btnCancel);
        
        return p;
    }

    /**
     * Returns the cancel button
     *
     * @return the cancel button
     */
    private JButton createCancelButton() {
        
        JButton btn = new JButton("Cancel");
        btn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                dispose();
                //new LoginUI(centroExposicoes);
            }
        });
        return btn;
    }

    /**
     *Creates the select exhibition button.
     *
     * @return the button to select exhibitions
     */
    private JButton criarBotaoSelecionarExposicao() {
        JButton btn = new JButton("Select exhibition");
        btn.setEnabled(false);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //TODO: HAD TO CAST THIS SO I COULD USE THIS METHOD
                ((DefineStaffMemberUI) parentFrame).setExhibition(exhibitionList.get(exhibitionListJTable.getSelectedRow()));
                dispose();
            }
        });
        return btn;
    }
}
