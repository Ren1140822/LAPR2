/**
 * Package location for UI classes.
 */
package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import lapr.project.controller.DefineStandController;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.Stand;
import lapr.project.ui.components.CustomMenuBar;
import lapr.project.ui.components.ModelListSelectable;

/**
 * Graphic user interface to define stands.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */

//public class DefineStandUI extends JFrame {
//    
//    /**
//     * The define stand controller.
//     */
//    private final DefineStandController controller;
//    
//    /**
//     * The exhibition center.
//     */
//    private final ExhibitionCenter exhibitionCenter;
//    
//    /**
//     * The stand list.
//     */
//    private List<Stand> standslist;
//    
//    /**
//     * Stands JList.
//     */
//    private JList standsJList;
//    
//    /**
//     * Remove stand button.
//     */
//    private JButton removeStandButton;
//    
//    /**
//     * Title for the window.
//     */
//    private static final String WINDOW_TITLE = "Define Stand";
//    
//    /**
//     * Window dimension.
//     */
//    private static final Dimension WINDOW_DIMENSION = new Dimension(600, 400);
//    
//    /**
//     * The padding border.
//     */
//    final static EmptyBorder PADDING_BORDER = new EmptyBorder(10, 10, 10, 10);
//    
//    /**
//     * Creates an instance of define stand user interface.
//     * 
//     * @param exhibitionCenter exhibition center
//     */
//    public DefineStandUI(ExhibitionCenter exhibitionCenter) {
//        super(WINDOW_TITLE);
//        
//        this.exhibitionCenter = exhibitionCenter;
//        this.controller = new DefineStandController(this.exhibitionCenter);
//        
//        this.standslist = this.controller.getStands();
//        
//        CustomMenuBar customMenuBar = new CustomMenuBar(this.exhibitionCenter, this);
//        setJMenuBar(customMenuBar);
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//        customMenuBar.exit();
//    }
//});
//
//setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//        
//        createComponents();
//        
//        pack();
//        setMinimumSize(new Dimension(getWidth(), getHeight()));
//        setSize(WINDOW_DIMENSION);
//        setLocationRelativeTo(null);
//        setVisible(true);
//        
//    }
//    
//    /**
//     * Creates the define stand UI components.
//     */
//    private void createComponents() {
//        JPanel componentsPanel = new JPanel(new BorderLayout(10, 10));
//        componentsPanel.add(createTitleLabel(), BorderLayout.NORTH);
//        componentsPanel.add(createStandPanel(), BorderLayout.CENTER);
//        componentsPanel.add(createButtonsPanel(), BorderLayout.SOUTH);
//        componentsPanel.setBorder(PADDING_BORDER);
//        add(componentsPanel);
//    }
//    
//    /**
//     * Creates the title label.
//     * 
//     * @return title label
//     */
//    private JLabel createTitleLabel() {
//        return new JLabel("Available Stands:", SwingConstants.CENTER);
//    }
//    
//    /**
//     * Creates the stand panel.
//     * 
//     * @return exhibition applications panel
//     */
//    private JPanel createStandPanel() {
//        JPanel exhibitionApplicationsListPanel = new JPanel(new BorderLayout());
//        
//        this.standsJList = new JList();
//        this.standsJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        this.standsJList.setModel(new ModelListSelectable(this.standslist));
//        DefaultListCellRenderer renderer = (DefaultListCellRenderer) this.standsJList.getCellRenderer();
//        renderer.setHorizontalAlignment(JLabel.CENTER);
//        
//        this.standsJList.addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent lse) {
//                DefineStandUI.this.removeStandButton.setEnabled(!DefineStandUI.this.standsJList.isSelectionEmpty());
//            }
//        });
//        
//        JScrollPane exhibitionApplicationsJScrollPane = new JScrollPane(this.standsJList);
//        exhibitionApplicationsListPanel.add(exhibitionApplicationsJScrollPane, BorderLayout.CENTER);
//        
//        return exhibitionApplicationsListPanel;
//    }
//    
//    /**
//     * Creates the buttons panel.
//     * 
//     * @return buttons panel
//     */
//    private JPanel createButtonsPanel() {
//        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
//        
//        buttonsPanel.add(createAddStandButton());
//        buttonsPanel.add(createRemoveResourceButton());
//        buttonsPanel.add(createBackButton());
//        
//        return buttonsPanel;
//    }
//    
//    /**
//     * Creates the add stands button.
//     * 
//     * @return add stands button
//     */
//    private JButton createAddStandButton() {
//        JButton addStandButton = new JButton("Add Stand");
//        
//        addStandButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                
//                String stand = JOptionPane.showInputDialog(DefineStandUI.this,
//                        "Insert the stand area:",
//                        "Add Stand",
//                        JOptionPane.QUESTION_MESSAGE);
//                
//                if (DefineStandUI.this.controller.newStand(stand) && stand != null) {
//                    
//                    DefineStandUI.this.controller.registerStand();
//                    DefineStandUI.this.updateStandsList();
//                }
//                
//                else if (stand != null) {
//                    
//                    JOptionPane.showMessageDialog(DefineResourceUI, e);
//                }
//            }
//        });
//        
//    }
//    
//    private JButton createRemoveResourceButton(){
// 
//       
//    }
//    
//    private JButton createBackButton() {
//        
//    }
//    
//    
//    
// }