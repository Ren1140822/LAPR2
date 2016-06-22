/**
 * Package location for UI classes.
 */
package lapr.project.ui;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import lapr.project.controller.CreateExhibitionController;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitionsManager;
import lapr.project.model.Organizer;
import lapr.project.model.Place;
import lapr.project.model.User;
import lapr.project.ui.components.ModelListSelectable;

/**
 * Graphic user interface to create exhibitions.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class CreateExhibitionUI extends JFrame {

    /**
     * The controller to create exhibitions.
     */
    private final CreateExhibitionController controller;

    /**
     * The exhibitions center.
     */
    private final ExhibitionCenter exhibitionCenter;

    /**
     * The logged exhibition manager.
     */
    private final ExhibitionsManager exhibitionsManager;

    private List<User> usersList;

    /**
     * Title Textfield component.
     */
    private JTextField txtFieldTitle;

    /**
     * Description Textfield component.
     */
    private JTextField txtFieldDescription;

    /**
     * Place Textfield component.
     */
    private JTextField txtFieldPlace;

    /**
     * Start Date Picker.
     */
    private JDateChooser startDatePicker;

    /**
     * End Date Picker.
     */
    private JDateChooser endDatePicker;

    /**
     * Open Applications Date Picker.
     */
    private JDateChooser openAppsDatePicker;

    /**
     * Close Applications Date Picker.
     */
    private JDateChooser closeAppsDatePicker;

    /**
     * Conflicts Limite Date Picker.
     */
    private JDateChooser conflictsLimitDatePicker;

    /**
     * Evaluations Limite Date Picker.
     */
    private JDateChooser evaluationsLimitDatePicker;

    /**
     * Placeholder date.
     */
    private static final Date PLACEHOLDER_DATE = new Date();

    /**
     * Users JList component.
     */
    private JList usersJList;

    /**
     * Title for the window.
     */
    private static final String WINDOW_TITLE = "Create Exhibiton";

    /**
     * Window dimension.
     */
    private static final Dimension WINDOW_DIMEMNSION = new Dimension(800, 400);

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
     * Constructor of a Create Exhibition UI Class.
     *
     * @param exhibitionCenter the exhibition center
     * @param exhibitionsManager the exhibitions manager logged in
     */
    public CreateExhibitionUI(ExhibitionCenter exhibitionCenter, ExhibitionsManager exhibitionsManager) {
        super(WINDOW_TITLE);

        this.exhibitionCenter = exhibitionCenter;
        this.exhibitionsManager = exhibitionsManager;
        this.controller = new CreateExhibitionController(exhibitionCenter);

        // Create a new exhibition
        this.controller.newExhibition();

        setLayout(new GridLayout(1, 2));
        createComponents();

        pack();
        setSize(WINDOW_DIMEMNSION);
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Create the UI components.
     */
    private void createComponents() {

        add(createSetDataPanel());
        add(createUserListAndButtonsPanel());
    }

    /**
     * Create Panel with fields to set exhibition's data.
     *
     * @return Panel with fields to set exhibition's data
     */
    public JPanel createSetDataPanel() {

        JLabel titleLbl = new JLabel("Title:", JLabel.RIGHT);
        JLabel descriptionLbl = new JLabel("Description:", JLabel.RIGHT);
        JLabel placeLbl = new JLabel("Location:", JLabel.RIGHT);
        JLabel startDateLbl = new JLabel("Start Date:", JLabel.RIGHT);
        JLabel endDateLbl = new JLabel("End Date:", JLabel.RIGHT);
        JLabel openAppsDateLbl = new JLabel("Open Applications Date:", JLabel.RIGHT);
        JLabel closedAppsDateLbl = new JLabel("Close Applications Date:", JLabel.RIGHT);
        JLabel conflictsDateLbl = new JLabel("Conflicts Limit Date:", JLabel.RIGHT);
        JLabel evaluationsDateLbl = new JLabel("Evaluations Limit Date:", JLabel.RIGHT);

        txtFieldTitle = new JTextField(FIELD_WIDTH);
        txtFieldDescription = new JTextField(FIELD_WIDTH);
        txtFieldPlace = new JTextField(FIELD_WIDTH);
        startDatePicker = new JDateChooser(PLACEHOLDER_DATE);
        endDatePicker = new JDateChooser(PLACEHOLDER_DATE);
        openAppsDatePicker = new JDateChooser(PLACEHOLDER_DATE);
        closeAppsDatePicker = new JDateChooser(PLACEHOLDER_DATE);
        conflictsLimitDatePicker = new JDateChooser(PLACEHOLDER_DATE);
        evaluationsLimitDatePicker = new JDateChooser(PLACEHOLDER_DATE);

        // Set date pickers in a panel 
        JPanel startDatePanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0));
        startDatePanel.setSize(txtFieldDescription.getSize());
        startDatePanel.add(startDatePicker);
        JPanel endDatePanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0));
        endDatePanel.add(endDatePicker);
        JPanel openAppsDatePanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0));
        openAppsDatePanel.add(openAppsDatePicker);
        JPanel closedAppsDatePanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0));
        closedAppsDatePanel.add(closeAppsDatePicker);
        JPanel conflictsLimitDatePanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0));
        conflictsLimitDatePanel.add(conflictsLimitDatePicker);
        JPanel evaluationsLimitDatePanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0));
        evaluationsLimitDatePanel.add(evaluationsLimitDatePicker);

        // Set main panel
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateContainerGaps(true);

        // Align horizontally
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(titleLbl)
                        .addComponent(descriptionLbl)
                        .addComponent(placeLbl)
                        .addComponent(startDateLbl)
                        .addComponent(endDateLbl)
                        .addComponent(openAppsDateLbl)
                        .addComponent(closedAppsDateLbl)
                        .addComponent(conflictsDateLbl)
                        .addComponent(evaluationsDateLbl)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(txtFieldTitle)
                        .addComponent(txtFieldDescription)
                        .addComponent(txtFieldPlace)
                        .addComponent(startDatePanel)
                        .addComponent(endDatePanel)
                        .addComponent(openAppsDatePanel)
                        .addComponent(closedAppsDatePanel)
                        .addComponent(conflictsLimitDatePanel)
                        .addComponent(evaluationsLimitDatePanel)
                )
        );

        // Align horizontally
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(titleLbl)
                        .addComponent(txtFieldTitle))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(descriptionLbl)
                        .addComponent(txtFieldDescription)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(placeLbl)
                        .addComponent(txtFieldPlace))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(startDateLbl)
                        .addComponent(startDatePanel)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(endDateLbl)
                        .addComponent(endDatePanel)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(openAppsDateLbl)
                        .addComponent(openAppsDatePanel)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(closedAppsDateLbl)
                        .addComponent(closedAppsDatePanel)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(conflictsDateLbl)
                        .addComponent(conflictsLimitDatePanel)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(evaluationsDateLbl)
                        .addComponent(evaluationsLimitDatePanel)
                )
        );

        return panel;
    }

    /**
     * Create scroll panel for users list.
     *
     * @return scroll panel for users list
     */
    public JPanel createUsersListScrollPanel() {

        JPanel panel = new JPanel(new GridLayout());
        panel.setBorder(BorderFactory.createTitledBorder(PADDING_BORDER,
                "Select Organizers:", TitledBorder.LEFT, TitledBorder.TOP));

        // TODO: Testing
        List testList = new ArrayList();
        testList.add(new User("Daniel", "username1", "email@s1", "password", new ArrayList<>()));
        testList.add(new User("Ivo", "username2", "email@s2", "password", new ArrayList<>()));
        testList.add(new User("Eric", "username3", "email@s3", "password", new ArrayList<>()));
        testList.add(new User("Renato", "username4", "email@s4", "password", new ArrayList<>()));
        testList.add(new User("Ricardo", "username5", "email@s5", "password", new ArrayList<>()));
        usersList = testList;
        // End

//        usersList = controller.getUsersList();
        ModelListSelectable usersModel = new ModelListSelectable(usersList);
        usersJList = new JList(usersModel);

        JScrollPane scrollPane = new JScrollPane(usersJList);
        scrollPane.setBorder(PADDING_BORDER);
        panel.setMinimumSize(scrollPane.getMinimumSize());
        panel.add(scrollPane);

        return panel;
    }

    /**
     * Create panel with users list & confirmation buttons.
     *
     * @return panel with users list & confirmation buttons
     */
    private JPanel createUserListAndButtonsPanel() {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(PADDING_BORDER);

        panel.add(createUsersListScrollPanel(), BorderLayout.NORTH);
        panel.add(createConfirmButtons(), BorderLayout.SOUTH);

        return panel;
    }

    /**
     * Create panel with confirm & cancel buttons.
     *
     * @return panel with confirm & cancel buttons
     */
    private JPanel createConfirmButtons() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        panel.add(createConfirmButton());
        panel.add(createCancelButton());

        return panel;
    }

    /**
     * Create Confirm Button.
     *
     * @return Confirm Button
     */
    private JButton createConfirmButton() {

        JButton confirmBtn = new JButton("Confirm");
        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String title = txtFieldTitle.getText();
                    String description = txtFieldDescription.getText();
                    Place place = new Place(description);
                    Date startDate = startDatePicker.getDate();
                    Date endDate = endDatePicker.getDate();
                    Date openAppsDate = openAppsDatePicker.getDate();
                    Date closedAppsDate = closeAppsDatePicker.getDate();
                    Date conflictsDate = conflictsLimitDatePicker.getDate();
                    Date evaluationsDate = evaluationsLimitDatePicker.getDate();

                    controller.setData(title, description, place, startDate, endDate, openAppsDate, closedAppsDate, conflictsDate, evaluationsDate);

                    int[] selectIndexs = usersJList.getSelectedIndices();
                    if (selectIndexs.length < 2) {
                        throw new IllegalArgumentException("Select at least 2 Organizers please.");
                    }
                    for (int index : selectIndexs) {
                        User selectedUser = usersList.get(index);
                        boolean newOrganizer = controller.newOrganizer(selectedUser);
                        if (!newOrganizer) {
                            throw new IllegalArgumentException(selectedUser.getName() + " is already a organizer of the list.");
                        }
                    }

                    if (!controller.validateExhibition()) {
                        throw new IllegalArgumentException("Invalid Data, please verify");
                    }
                    String data = String.format("Title: %s%n"
                            + "Description: %s%n"
                            + "Start Date: %s%n"
                            + "End Date: %s%n"
                            + "Open Applications Date: %s%n"
                            + "Closed Applications Date: %s%n"
                            + "Conflicts Limit Date: %s%n"
                            + "Evaluations Limit Date: %s%n%n%n",
                            controller.getExhibition().getTitle(), controller.getExhibition().getDescription(),
                            controller.getExhibition().getStartDate(), controller.getExhibition().getEndDate(),
                            controller.getExhibition().getSubStartDate(), controller.getExhibition().getSubEndDate(),
                            controller.getExhibition().getConflictLimitDate(), controller.getExhibition().getEvaluationLimitDate());

                    String question = "/n/nPlease confirm the new exibition?";

                    StringBuilder message = new StringBuilder();
                    message.append("New Exhibition/n/n");
                    message.append(data);
                    message.append("/nOrganizers:/n");
                    for (Organizer organizer : controller.getExhibition().getOrganizersList().getOrganizersList()) {
                        message.append(String.format("%s%n", organizer.getUser().getName()));
                    }
                    message.append(question);

                    int confirma = JOptionPane.showConfirmDialog(rootPane, message);

                    if (confirma == JOptionPane.YES_OPTION) {
                        controller.registerExhibition();
//                        dispose();
                        // TODO:
                    }
                } catch (IllegalArgumentException ex) {

                    JOptionPane.showMessageDialog(
                            rootPane,
                            ex.getMessage(),
                            "Invalid Data",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        return confirmBtn;
    }

    /**
     * Create Cancel Button.
     *
     * @return o botão cancelar
     */
    private JButton createCancelButton() {

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

//                dispose();
                // TODO
            }
        });
        return cancelBtn;
    }

    /**
     * Starting method for testing purposes, later wil be removed.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        ExhibitionCenter ec = new ExhibitionCenter();
        ExhibitionsManager em = new ExhibitionsManager();
        new CreateExhibitionUI(ec, em);
    }
}
