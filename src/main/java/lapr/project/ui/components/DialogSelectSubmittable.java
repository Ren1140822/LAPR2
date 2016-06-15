/**
 * Package location for UI components classes.
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
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.Submittable;
import lapr.project.ui.AssignApplicationUI;

/**
 * Represents a select submittable dialog
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 * @param <T> type of the frame that calls this one
 */
public class DialogSelectSubmittable<T extends JFrame> extends JDialog {

    /**
     * The exhibition center.
     */
    private final ExhibitionCenter exhibitionCenter;

    /**
     * Frame that calls this one.
     */
    private final T parentFrame;
    /**
     * Submittables list.
     */
    private final List<Submittable> submittabelsList;
    /**
     * Table with the submittables.
     */
    private JTable submittablesListJTable;
    /**
     * Select submittable button.
     */
    private JButton btnSelectSubmittable;
    /**
     * Window title.
     */
    private static final String TITLE = "Select submittable";
    /**
     * Text for selecting submittable.
     */
    private static final String SELECT_SUBMITTABLE = "Select submittable";

    /**
     * Constructs a dialog to select a submittable.
     *
     * @param parentFrame the parent frame
     * @param  submittablesList the list of submittables
     * @param  exhibitionCenter the exhibition center
     */
    public DialogSelectSubmittable(T parentFrame, List<Submittable> submittablesList, ExhibitionCenter exhibitionCenter) {
        super(parentFrame, TITLE, true);
        
        this.exhibitionCenter = exhibitionCenter;      
        this.parentFrame = parentFrame;
        this.submittabelsList = submittablesList;
        
        createComponents();
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(parentFrame);
        setVisible(true);
    }

    /**
     * Creates the GUI components.
     */
    private void createComponents() {
        JPanel jPanel1 = createSelectSubmittablePanel();
        JScrollPane jScrollPane2 = createJscrollPaneSubmittablesList();
        JPanel jPanel3 = createJpanelBtns();
        
        add(jPanel1, BorderLayout.NORTH);
        add(jScrollPane2, BorderLayout.CENTER);
        add(jPanel3, BorderLayout.SOUTH);
    }

    /**
     * Creates the north panel.
     *
     * @return north panel
     */
    private JPanel createSelectSubmittablePanel() {
        JLabel jLabel = new JLabel(SELECT_SUBMITTABLE, JLabel.CENTER);
        
        JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        final int MARGIN_SUPERIOR = 10, MARGIN_INFERIOR = 0;
        final int MARGIN_RIGHT = 0, MARGIN_LEFT = 0;
        jPanel.setBorder(new EmptyBorder(MARGIN_SUPERIOR, MARGIN_LEFT,
                MARGIN_INFERIOR, MARGIN_RIGHT));
        
        jPanel.add(jLabel);
        
        return jPanel;
    }

    /**
     * Creates the center panel
     *
     * @return the center panel
     */
    private JScrollPane createJscrollPaneSubmittablesList() {
        submittablesListJTable = new JTable(new ModelTableSubmittablesList(submittabelsList));
        submittablesListJTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        submittablesListJTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (submittablesListJTable.getSelectedRow() >= 0) {
                    btnSelectSubmittable.setEnabled(true);
                } else {
                    btnSelectSubmittable.setEnabled(false);
                }
            }
        });
        
        JScrollPane jScrollPane = new JScrollPane(submittablesListJTable);
        
        final int MARGIN_SUPERIOR = 20, MARGIN_INFERIOR = 20;
        final int MARGIN_RIGHT = 20, MARGIN_LEFT = 20;
        jScrollPane.setBorder(BorderFactory.createEmptyBorder(MARGIN_SUPERIOR, MARGIN_LEFT,
                MARGIN_INFERIOR, MARGIN_RIGHT));
        
        return jScrollPane;
    }

    /**
     * Creates the south panel.
     *
     * @return south panel
     */
    private JPanel createJpanelBtns() {
        this.btnSelectSubmittable = createBtnSelectSubmittable();
        getRootPane().setDefaultButton(this.btnSelectSubmittable);
        
        JButton btnCancel = createCancelButton();
        
        JPanel jPanel = new JPanel(new FlowLayout());
        final int MARGIN_SUPERIOR = 10, MARGIN_INFERIOR = 0;
        final int MARGIN_RIGHT = 0, MARGIN_LEFT = 0;
        jPanel.setBorder(new EmptyBorder(MARGIN_SUPERIOR, MARGIN_LEFT,
                MARGIN_INFERIOR, MARGIN_RIGHT));
        jPanel.add(this.btnSelectSubmittable);
        jPanel.add(btnCancel);
        
        return jPanel;
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
     *Creates the select submittable button.
     *
     * @return the button to select submittables
     */
    private JButton createBtnSelectSubmittable() {
        JButton btn = new JButton("Select submittable");
        btn.setEnabled(false);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //TODO: HAD TO CAST THIS SO I COULD USE THIS METHOD NEED TO FIND A BETTER WAY TO FIND OUT WHICH CLASS INSTANTIATES THIS
                //
                ((AssignApplicationUI) parentFrame).setSubmittable(submittabelsList.get(submittablesListJTable.getSelectedRow()));
                dispose();
            }
        });
        return btn;
    }
}
