/**
 * Package location for UI classes.
 */
package lapr.project.ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import lapr.project.controller.CreateUserProfileController;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.User;
import lapr.project.model.UsersRegister;

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
    private JTextField texttFieldName;
    
    /**
     * Username textfield component.
     */
    private JTextField textFieldUsername;
    
    /**
     * Email textfield component.
     */
    private JTextField textFieldEmail;
    
    /**
     * Password textfield component.
     */
    private JTextField textFieldPassword;
    
    /**
     * Users JList component.
     */
    private JList userJList;
    
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
        
        // Create a new exhibition
        this.controller.newUser();
        
        setLayout(new GridLayout(1, 2));
     //   createComponents();
        
        pack();
     //   setsize(WINDOW_DIMENSION);
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    
}
