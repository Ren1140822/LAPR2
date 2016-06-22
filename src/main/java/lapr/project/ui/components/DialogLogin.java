/**
 * Package location for UI components classes.
 */
package lapr.project.ui.components;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.User;

/**
 * Represents a dialog to login as.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class DialogLogin extends JDialog {

    /**
     * The parent JFrame.
     */
    private final JFrame parentFrame;

    /**
     * The user.
     */
    private final User user;

    /**
     * The choose text
     */
    private final String chooseText;

    /**
     * The ok button.
     */
    private JButton okButton;

    /**
     * The cancel button.
     */
    private JButton cancelButton;

    /**
     * Window title.
     */
    private static final String WINDOW_TITLE = "Login as";

    /**
     * The exhibitionsCenter.
     */
    private ExhibitionCenter exhibitionsCenter;

    /**
     * Padding border.
     */
    final static EmptyBorder PADDING_BORDER = new EmptyBorder(10, 10, 10, 10);

    public DialogLogin(JFrame parentFrame, User user, String chooseText) {
        super(parentFrame, WINDOW_TITLE, true);

        this.parentFrame = parentFrame;
        this.chooseText = chooseText;
        this.user = user;

        createComponents();

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(parentFrame);
        setVisible(true);
    }

    /**
     * Creates the UI components to this dialog.
     */
    private void createComponents() {
        JPanel componentsPanel = new JPanel(new BorderLayout(0, 10));
        componentsPanel.add(createChooseTextLabel(), BorderLayout.NORTH);
        componentsPanel.add(createComboPanel(), BorderLayout.CENTER);
        componentsPanel.add(createButtonsPanel(), BorderLayout.SOUTH);
        componentsPanel.setBorder(PADDING_BORDER);
        add(componentsPanel);
    }

    /**
     * Creates the top label with the text to choose a type of user to login.
     *
     * @return choose type of user JLabel
     */
    private JLabel createChooseTextLabel() {
        return new JLabel(this.chooseText, SwingConstants.CENTER);
    }

    private JPanel createComboPanel() {
        JPanel comboPanel = new JPanel(new BorderLayout(0, 10));

        comboPanel.add(createComboBox());

        return comboPanel;
    }

    /**
     * Create the buttons panel.
     *
     * @return buttons panel
     */
    private JPanel createButtonsPanel() {
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2, 10, 0));

        buttonsPanel.add(createOkButton());
        buttonsPanel.add(createCancelButton());

        return buttonsPanel;
    }

    /**
     * Creates the ok button.
     *
     * @return ok button
     */
    private JButton createOkButton() {
        JButton okButton = new JButton("Ok");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        return okButton;
    }

    /**
     * Creates the cancel button.
     *
     * @return cancel button
     */
    private JButton createCancelButton() {
        JButton cancelButton = new JButton("Cancel");

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        return cancelButton;
    }

    /**
     * Creates the combo box
     * 
     * @return the combo box 
     */
    private JComboBox createComboBox() {
        String[] userPossibilities = new String[]{"StaffMember", "Organizer",
            "ExhibitiorResponsible"};
        JComboBox<String> usersPossibilitiesListJcomboBox = new JComboBox<>(userPossibilities);
        return usersPossibilitiesListJcomboBox;
    }

}
