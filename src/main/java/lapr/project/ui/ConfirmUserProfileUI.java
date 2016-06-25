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
import lapr.project.controller.ConfirmUserProfileController;
import lapr.project.model.ExhibitionCenter;
import lapr.project.ui.components.CustomMenuBar;
//import lapr.project.ui.components.DialogSeeUserProfile;
import lapr.project.ui.components.ModelListSelectable;

/**
 * Graphic user interface to create user profile.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
//public class ConfirmUserProfileUI extends JFrame {
//    
//    /**
//     * The confirm user profile controller.
//     */
//    private final ConfirmUserProfileController controller;
//    
//    /**
//     * The exhibition center.
//     */
//    private final ExhibitionCenter exhibitionCenter;
//    
//    /**
//     * The unconfirmed users list.
//     */
//    private List<unconfirmedUserProfilesList> unconfirmedUserProfilesList;
//    
//    /**
//     * Unconfirmed users JList.
//     */
//    private JList unconfirmedUserProfilesJList;
//    
//    /**
//     * See user profile button.
//     */
//    private JButton seeUserProfileButton;
//    
//    /**
//     * Confirm user profile button.
//     */
//    private JButton confirmUserProfileButton;
//    
//    /**
//     * Title for the window.
//     */
//    private static final String WINDOW_TITLE = "Confirm User Profile";
//    
//    /**
//     * Window dimension.
//     */
//    private static final Dimension WINDOW_DIMENSION = new Dimension(600, 400);
//    
//    /**
//     * Padding border.
//     */
//    final static EmptyBorder PADDING_BORDER = new EmptyBorder(10, 10, 10, 10);
//    
//    /**
//     * Creates an instance of confirm user profile user interface.
//     * 
//     * @param exhibitionCenter the exhibition center
//     */
//    public ConfirmUserProfileUI(ExhibitionCenter exhibitionCenter) {
//        super(WINDOW_TITLE);
//        
//        this.exhibitionCenter = exhibitionCenter;
//        this.controller = new ConfirmUserProfileController(this.exhibitionCenter);
//        
//        this.unconfirmedUserProfilesList = controller.getUnconfirmedUserProfilesList();
//        
//        CustomMenuBar customMenuBar = new CustomMenuBar(this.exhibitionCenter, this);
//        setJMenuBar(customMenuBar);
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                customMenuBar.exit();
//            }
//        });
//        
//        createComponents();
//
//        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//        pack();
//        setMinimumSize(new Dimension(getWidth(), getHeight()));
//        setSize(WINDOW_DIMENSION);
//        setLocationRelativeTo(null);
//        setVisible(true);       
//    }
//    
//    /**
//     * Creates the UI components.
//     */
//    private void createComponents() {
//        JPanel componentsPanel = new JPanel(new BorderLayout(10, 10));
//        componentsPanel.add(createTitleLabel(), BorderLayout.NORTH);
//        componentsPanel.add(createUnconfirmedUserProfilesListPanel(), BorderLayout.CENTER);
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
//        return new JLabel("Select an unconfirmed user to be confirmed:", SwingConstants.CENTER);
//    }
//    
//    /**
//     * Creates the unconfirmed user profile panel
//     * 
//     * @return user profile panel
//     */
//    private JPanel createUnconfirmedUserProfilesListPanel() {
//        JPanel unconfirmedUserProfilesListPanel = new JPanel(new BorderLayout());
//        
//        this.unconfirmedUserProfilesJList = new JList();
//        this.unconfirmedUserProfilesJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        this.unconfirmedUserProfilesJList.setModel(new ModelListSelectable(this.unconfirmedUserProfilesList));
//        
//        this.unconfirmedUserProfilesJList.addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent lse) {
//                ConfirmUserProfileUI.this.seeUserProfile.setEnabled(!ConfirmUserProfileUI.this.unconfirmedUserProfilesJList.isSelectionEmpty());
//                ConfirmUserProfileUI.this.confirmUserProfileButton.setEnabled(!ConfirmUserProfileUI.this.unconfirmedUserProfilesJList.isSelectionEmpty());
//                
//                if (ConfirmUserProfileUI.this.unconfirmedUserProfilesJList.getSelectedIndex() >= 0) {
//                    ConfirmUserProfileUI.this.controller.setUnconfirmedUserProfile(
//                            ConfirmUserProfileUI.this.unconfirmedUserProfilesList.get(
//                                    ConfirmUserProfileUI.this.unconfirmedUserProfilesJList.getSelectedIndex()));
//                }               
//            }      
//        });
//        
//        JScrollPane unconfirmedUserProfilesJScrollPane = new JScrollPane(this.unconfirmedUserProfilesJList);
//        unconfirmedUserProfilesListPanel.add(unconfirmedUserProfilesJScrollPane, BorderLayout.CENTER);
//        
//        return unconfirmedUserProfilesListPanel;
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
//        buttonsPanel.add(createSeeUserProfileButton());
//        buttonsPanel.add(createConfirmUserProfileButton());
//        buttonsPanel.add(createBackButton());
//        
//        return buttonsPanel;
//    }
//    
//    /**
//     * Creates the see user profile button.
//     * 
//     * @return see user profile button
//     */
//    private JButton createSeeUserProfileButton() {
//        this.seeUserProfileButton = new JButton("See user profile");
//        this.seeUserProfileButton.setEnabled(false);
//        
//        this.seeUserProfileButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new DialogSeeUserProfile(ConfirmUserProfileUI.this.unconfirmedUserProfilesList.get(
//                        ConfirmUserProfileUI.this.unconfirmedUserProfilesJList.getSelectedIndex()),
//                        ConfirmUserProfileUI.this);
//            }
//        });
//        
//        return this.seeUserProfileButton;
//    }
//    
//    /**
//     * Creates the confirm user profile button.
//     * 
//     * @return confirm user profile button
//     */
//    
//    private JButton createConfirmUserProfileButton() {
//        this.confirmUserProfileButton = new JButton("Confirm user profile");
//        this.confirmUserProfileButton.setEnabled(false);
//        
//        this.confirmUserProfileButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                String[] options = {"Yes, confirm user profile", "No, discard user profile"};
//                
//                int userProfileDecision = JOptionPane.showInternalConfirmDialog(ConfirmUserProfileUI.this,
//                        "Do you with to confirm the current user profile?",
//                        "Confirm user profile";
//                JOptionPane.YES_NO_OPTION,
//                JOptionPane.QUESTION_MESSAGE,
//                null, options,
//                options[0]);
//                
//                if(userProfileDecision == 0) { //accepted user profile
//                    ConfirmUserProfileUI.this.controller.confirmUser(true);
//                    ConfirmUserProfileUI.this.updateUnconfirmedUserProfiles();
//                } else if(userProfileDecision == 1) { //declined user profile
//                    ConfirmUserProfileUI.this.updateUnconfirmedUserProfiles();
//                }           
//            }
//        });
//        
//        return this.confirmUserProfileButton;
//    }
//    
//    /**
//     * Creates the back button.
//     * 
//     * @return back button
//     */
//    private JButton createBackButton() {
//        JButton backButton = new JButton("Back");
//
//        backButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dispose();
//            }
//        });
//
//        return backButton;
//    }
//    
//    /**
//     * Refresh the unconfirmed users list.
//     */
//    private void updateUnconfirmedUserProfiles() {
//        this.unconfirmedUserProfilesList = controller.getUnconfirmedUserProfilesList();
//        this.unconfirmedUserProfilesJList.setModel(new ModelListSelectable(this.unconfirmedUserProfilesList));
//    }
//    
//    /**
//     * main() for testing purposes.
//     * 
//     * @param args 
//     */
//    public static void main(String[] args) {
//        
//    }
//
//}