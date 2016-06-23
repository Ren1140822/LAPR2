/**
 * Package location for UI classes.
 */
package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import lapr.project.controller.CreateUserProfileController;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.User;
import lapr.project.model.UsersRegister;
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
public class CreateUserProfileUI extends JFrame {
    
    /**
     * The create user profile controller.
     */
    private final CreateUserProfileController controller;
    
    /**
     * The exhibition center.
     */
    private final ExhibitionCenter exhibitionCenter;
    
    /**
     * The user.
     */
    private User user;
    
    /**
     * The users register.
     */
    private UsersRegister usersRegister;
    
    /**
     * The users list
     */
    private List<User> usersList;
    
    /**
     * Name textfield component.
     */
    private JTextField textFieldName;
    
    /**
     * Username textfield component.
     */
    private JTextField textFieldUsername;
    
    /**
     * Email textfield component.
     */
    private JTextField textFieldEmail;
    
    /**
     * Password passwordfield component.
     */
    private JPasswordField passwordFieldPassword;
    
    /**
     * ConfirmPassword passwordfield component.
     */
    private JPasswordField passwordFieldConfirmPassword;
    
    /**
     * Users JList component.
     */
    private JList usersJList;
    
    /**
     * Remove a user button.
     */
    private JButton removeUserButton;
    
    /**
     * Title for the window.
     */
    private static final String WINDOW_TITLE = "Create Exhibition";
    
    /**
     * Window dimension.
     */
    private static final Dimension WINDOW_DIMENSION = new Dimension(800, 300);
    
    /**
     * Padding border.
     */
    final static EmptyBorder PADDING_BORDER = new EmptyBorder(10, 10, 10, 10);
    
    /**
     * Field Top Margin.
     */
    final int FIELD_TOP_MARGIN = 0;

    /**
     * Field Bottom Margin.
     */
    final int FIELD_BOTTOM_MARGIN = 0;

    /**
     * Field Left Margin.
     */
    final int FIELD_LEFT_MARGIN = 10;

    /**
     * Field Right Margin.
     */
    final int FIELD_RIGHT_MARGIN = 0;

    /**
     * Field Width.
     */
    final int FIELD_WIDTH = 20;
    
    /**
     *  Constructs of a Create User Profile UI Class.
     * 
     * @param exhibitionCenter the exhibition center
     */
    public CreateUserProfileUI(ExhibitionCenter exhibitionCenter) {
        super(WINDOW_TITLE);
        
        this.exhibitionCenter = exhibitionCenter;
        this.controller = new CreateUserProfileController(exhibitionCenter);
        
        // Create a new user
        this.controller.newUser();
        
        setLayout(new GridLayout(1, 2));
        createComponents();
        
        pack();
        setSize(WINDOW_DIMENSION);
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    /**
     * Create the UI components.
     */
    private void createComponents() {
        
        add(createSetUserDataPanel());
        add(createUserRelatedUsersPanel());
    }
    
    /**
     * Create Panel with fields to set the user's data.
     * 
     * @return Panel with fields to set the exhibition's data
     */
    public JPanel createSetUserDataPanel() {
        
        JLabel nameLabel = new JLabel("Name:", JLabel.RIGHT);
        JLabel usernameLabel = new JLabel("Username:", JLabel.RIGHT);
        JLabel emailLabel = new JLabel("Email:", JLabel.RIGHT);
        JLabel passwordLabel = new JLabel("Password:", JLabel.RIGHT);
        JLabel confirmPasswordLabel = new JLabel("ConfirmPassword:", JLabel.RIGHT);
        
        textFieldName = new JTextField(FIELD_WIDTH);
        textFieldUsername = new JTextField(FIELD_WIDTH);
        textFieldEmail = new JTextField(FIELD_WIDTH);
        passwordFieldPassword = new JPasswordField(FIELD_WIDTH);
        passwordFieldConfirmPassword = new JPasswordField(FIELD_WIDTH);
        
        // Set the main panel
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        
        // Align horizontally
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(nameLabel)
                        .addComponent(usernameLabel)
                        .addComponent(emailLabel)
                        .addComponent(passwordLabel)
                        .addComponent(confirmPasswordLabel)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(textFieldName)
                        .addComponent(textFieldUsername)
                        .addComponent(textFieldEmail)
                        .addComponent(passwordFieldPassword)
                        .addComponent(passwordFieldConfirmPassword)
                )
        );
        
        // Align vertically
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(nameLabel)
                        .addComponent(textFieldName))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(usernameLabel)
                        .addComponent(textFieldUsername)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(emailLabel)
                        .addComponent(textFieldEmail))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(passwordLabel)
                        .addComponent(passwordFieldPassword)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(confirmPasswordLabel)
                        .addComponent(passwordFieldConfirmPassword)
                )
        );
    
        return panel;
        
    }
    
    /**
     * Create scroll panel for related users list.
     * 
     * @return scroll panel for related users list
     */
    public JPanel createUserRelatedUsersPanel() {
        
        JPanel panel = new JPanel(new BorderLayout());
        
        JPanel listPanel = new JPanel(new GridLayout());
        listPanel.setBorder(BorderFactory.createTitledBorder(PADDING_BORDER,
                "Select Related Users:", TitledBorder.LEFT, TitledBorder.TOP));
        
        ModelListSelectable usersModel = new ModelListSelectable(controller.getUsersRegister().getUsersList());
        usersJList = new JList(usersModel);
        
        usersJList.addListSelectionListener(new ListSelectionListener() {
         
            @Override
            public void valueChanged(ListSelectionEvent e) {
                removeUserButton.setEnabled(!usersJList.isSelectionEmpty());
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(usersJList);
        scrollPane.setBorder(PADDING_BORDER);
        listPanel.setMaximumSize(scrollPane.getMinimumSize());
        listPanel.add(scrollPane);
        
        panel.add(listPanel, BorderLayout.NORTH);
        panel.add(createAddAndRemoveButtons(), BorderLayout.CENTER);
        
        return panel;
        
    }
        
    /**
     * Create panel with add and remove related users buttons.
     * 
     * @return panel with add and remove related users buttons
     */
    private JPanel createAddAndRemoveButtons() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
    //    panel.add(createAddRelatedUserButton());
    //    panel.add(createRemoveRelatedUserButton());
        
        return panel;    
    }
    
    /**
     * Create remove related user button.
     * 
     * @return remove related user button
     */
    
}
