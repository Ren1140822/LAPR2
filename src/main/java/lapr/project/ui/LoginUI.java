/**
 * Package location for UI concepts.
 */
package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import lapr.project.controller.LoginController;
import lapr.project.model.ExhibitionCenter;
import lapr.project.utils.DefaultInstantiator;

/**
 * Represents a login UI
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class LoginUI extends JFrame {

    /**
     * The controller for login.
     */
    private final LoginController loginController;

    /**
     * The window title.
     */
    static final String WINDOW_TITLE = "Login";

    /**
     * The textfield size.
     */
    static final int TEXTFIELD_SIZE = 9;

    final static Dimension WINDOW_SIZE = new Dimension(550, 450);

    final static EmptyBorder PADDING_BORDER = new EmptyBorder(10,10,10,10);
    /**
     * Builds an instance of this class receiving an exhibition center as
     * parameter.
     *
     * @param exhibitionCenter the exhibition center
     */
    public LoginUI(ExhibitionCenter exhibitionCenter) {
        super(WINDOW_TITLE);
        loginController = new LoginController(exhibitionCenter);

        createComponents();

        this.setSize(WINDOW_SIZE);
        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void createComponents() {
        JPanel panelUser = createPanelUserName();
        JPanel panelPassword = createPanelPasswords();
        JPanel buttonsPanel = createButtonsPanel();
        add(panelUser, BorderLayout.NORTH);
        add(panelPassword, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

    }

    public JPanel createPanelUserName() {
        JPanel panel = new JPanel(new FlowLayout());
        Label label = new Label("Username: ");
        JTextField text = new JTextField(TEXTFIELD_SIZE);
        panel.add(label);
        panel.add(text);
        panel.setBorder(BorderFactory.createBevelBorder(2, Color.lightGray, Color.BLACK));
        return panel;
    }

    public JPanel createPanelPasswords() {
        JPanel panel = new JPanel(new FlowLayout());
        Label label = new Label("Password: ");
        JPasswordField text = new JPasswordField(TEXTFIELD_SIZE);
        panel.add(label);
        panel.add(text);
        panel.setBorder(BorderFactory.createBevelBorder(2, Color.lightGray, Color.BLACK));
        return panel;
    }

    public JPanel createButtonsPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));
        JButton buttonLogin = createLoginButton();
        JButton buttonRegister = createRegisterButton();
        panel.add(buttonLogin);
        panel.add(buttonRegister);
        panel.setBorder(PADDING_BORDER);
        return panel;
    }

    public JButton createLoginButton() {
        JButton button = new JButton("Login");
        button.addActionListener(new ActionListener() {
       
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: loginController
            }
        });
        return button;
    }

    public JButton createRegisterButton() {
        JButton button = new JButton("Register");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        return button;
    }
    
    public static void main(String[] args){
        ExhibitionCenter ex = DefaultInstantiator.createExhibitionCenter();
        LoginUI ui = new LoginUI(ex);
    }
}
