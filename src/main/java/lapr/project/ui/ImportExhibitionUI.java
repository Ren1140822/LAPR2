/**
 * Package location for UI concepts.
 */
package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import lapr.project.controller.ImportExhibitionController;
import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitionsManager;
import lapr.project.utils.DefaultInstantiator;

/**
 * Represents an evaluation.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ImportExhibitionUI extends JFrame {

    /**
     * The controller of exhibition importing mechanism.
     */
    private ImportExhibitionController importExhibitionController;
    /**
     * The exhibition selected.
     */
    private Exhibition selectedExhibition;

    /**
     * Label size.
     */
    final Dimension LBL_SIZE = new Dimension(94, 16);
    /**
     * Window size.
     */
    final Dimension WINDOW_SIZE = new Dimension(1200, 600);
    /**
     * Field margins.
     */
    final int MARGIN_S_FIELD = 0, MARGIN_I_FIELD = 0,
            MARGIN_E_FIELD = 10, MARGIN_D_FIELD = 0;
    /**
     * Field width.
     */
    final int FIELD_TXT_WIDTH = 20, FIELD_NUM_HEIGHT = 6;
    /**
     * Empty border.
     */
    final static EmptyBorder PADDING_BORDER = new EmptyBorder(10, 10, 10, 10);
    /**
     * Scroll size.
     */
    final Dimension SCROLL_SIZE = new Dimension(300, 500);

    public ImportExhibitionUI(ExhibitionsManager manager, ExhibitionCenter exhibitionCenter) {
        this.importExhibitionController = new ImportExhibitionController(manager, exhibitionCenter);
        this.setSize(WINDOW_SIZE);
        createComponents();
        this.setVisible(true);
    }

    public void createComponents() {
        JMenuBar menu = createJMenuBar();
        add(menu, BorderLayout.NORTH);
    }

    public JMenuBar createJMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = createJMenu();
        menuBar.add(menu);
        return menuBar;
    }

    public JMenu createJMenu() {
        JMenu menu = new JMenu("File");
        JMenuItem itemMenu = createJMenuItemImport();
        menu.add(itemMenu);
        return menu;

    }

    public JMenuItem createJMenuItemImport() {
        JMenuItem itemMenu = new JMenuItem("Import exhibition from XML");
        itemMenu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(rootPane);
                if (result == JFileChooser.APPROVE_OPTION) {
                    if (importExhibitionController.readExhibitionFromFile(fileChooser.getSelectedFile().getAbsolutePath())) {
                        result = JOptionPane.showConfirmDialog(rootPane, "Exhibition imported sucessfully. Do you wish to register it on the system?", "Sucess", JOptionPane.YES_NO_OPTION);
                        if (result == JOptionPane.YES_OPTION) {
                            selectedExhibition = importExhibitionController.getExhibition();
                            if(importExhibitionController.registerExhibition(selectedExhibition)){
                                 JOptionPane.showConfirmDialog(rootPane, "Exhibition registered sucessfully!", "Sucess",JOptionPane.PLAIN_MESSAGE);
                            }
                        }
                    }
                }
            }
        });
        return itemMenu;
    }
    
    

    public static void main(String[] args) {
        ExhibitionCenter exhibitionCenter = DefaultInstantiator.createExhibitionCenter();
        ExhibitionsManager manager = new ExhibitionsManager();
        ImportExhibitionUI test = new ImportExhibitionUI(manager, exhibitionCenter);
    }
}
