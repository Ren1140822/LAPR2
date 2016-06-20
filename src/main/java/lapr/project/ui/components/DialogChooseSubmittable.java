/**
 * Package location for UI components classes.
 */
package lapr.project.ui.components;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import lapr.project.model.Submittable;

/**
 * Represents a dialog to choose a submittable.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class DialogChooseSubmittable extends JDialog {

    /**
     * The parent JFrame.
     */
    private final JFrame parentFrame;

    /**
     * The selected submittable.
     */
    private Submittable selectedSubmittable;

    /**
     * The submittables list.
     */
    private final List<Submittable> submittablesList;

    /**
     * The submittables JList.
     */
    private JList<Submittable> submittablesJList;

    /**
     * The select submittable button.
     */
    private JButton selectSubmittableButton;

    /**
     * Text to be shown on the top of the list.
     */
    private final String chooseSubmittableText;

    /**
     * Window title.
     */
    private static final String WINDOW_TITLE = "Choose Submittable";

    /**
     * Default text to be shown on the top of the list.
     */
    private static final String DEFAULT_CHOOSE_SUBMITTABLE_TEXT = "Please choose a submittable from the list:";

    /**
     * Padding border.
     */
    final static EmptyBorder PADDING_BORDER = new EmptyBorder(10, 10, 10, 10);

    /**
     * Creates an instance of choose submittable dialog.
     *
     * @param parentFrame parent JFrame
     * @param submittablesList submittables list
     */
    public DialogChooseSubmittable(JFrame parentFrame, List<Submittable> submittablesList) {
        super(parentFrame, WINDOW_TITLE, true);

        this.parentFrame = parentFrame;
        this.submittablesList = submittablesList;
        this.chooseSubmittableText = DEFAULT_CHOOSE_SUBMITTABLE_TEXT;

        createComponents();

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(parentFrame);
        setVisible(true);
    }

    /**
     * Creates an instance of choose submittable dialog.
     *
     * @param parentFrame parent JFrame
     * @param submittablesList submittables list
     * @param chooseSubmittableText text to be shown on the top of the list
     */
    public DialogChooseSubmittable(JFrame parentFrame, List<Submittable> submittablesList, String chooseSubmittableText) {
        super(parentFrame, WINDOW_TITLE, true);

        this.parentFrame = parentFrame;
        this.submittablesList = submittablesList;
        this.chooseSubmittableText = chooseSubmittableText;

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
        componentsPanel.add(createChooseSubmittableTextLabel(), BorderLayout.NORTH);
        componentsPanel.add(createSubmittablesListPanel(), BorderLayout.CENTER);
        componentsPanel.add(createButtonsPanel(), BorderLayout.SOUTH);
        componentsPanel.setBorder(PADDING_BORDER);
        add(componentsPanel);
    }

    /**
     * Creates the top label with the text to choose a submittable.
     *
     * @return choose submittable JLabel
     */
    private JLabel createChooseSubmittableTextLabel() {
        return new JLabel(this.chooseSubmittableText, SwingConstants.CENTER);
    }

    /**
     * Creates the submittables list panel
     *
     * @return submittables list panel
     */
    private Component createSubmittablesListPanel() {
        JPanel submittablesListPanel = new JPanel(new BorderLayout());

        this.submittablesJList = new JList();
        this.submittablesJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.submittablesJList.setModel(new ModelListSubmittables(this.submittablesList));

        this.submittablesJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                DialogChooseSubmittable.this.selectSubmittableButton.setEnabled(!DialogChooseSubmittable.this.submittablesJList.isSelectionEmpty());
            }
        });

        JScrollPane submittablesJScrollPane = new JScrollPane(this.submittablesJList);
        submittablesListPanel.add(submittablesJScrollPane, BorderLayout.CENTER);

        return submittablesListPanel;
    }

    /**
     * Creates the buttons panel.
     *
     * @return buttons panel
     */
    private Component createButtonsPanel() {
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        buttonsPanel.add(createSelectSubmittableButton());
        buttonsPanel.add(createCancelButton());

        return buttonsPanel;
    }

    /**
     * Creates the select submittable button.
     *
     * @return select submittable button
     */
    private JButton createSelectSubmittableButton() {
        this.selectSubmittableButton = new JButton("Select");
        this.selectSubmittableButton.setEnabled(false);

        this.selectSubmittableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogChooseSubmittable.this.selectedSubmittable = DialogChooseSubmittable.this.submittablesList
                        .get(DialogChooseSubmittable.this.submittablesJList.getSelectedIndex());
                dispose();
            }
        });

        return this.selectSubmittableButton;
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
                DialogChooseSubmittable.this.selectedSubmittable = null;
                dispose();
            }
        });

        return cancelButton;
    }
    
    /**
     * Gets the selected submitable.
     * 
     * @return selected submittable
     */
    public Submittable getSelectedSubmitable() {
        return this.selectedSubmittable;
    }
}
