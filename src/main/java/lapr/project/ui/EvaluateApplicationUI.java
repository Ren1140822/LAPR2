/**
 * Package location for UI classes.
 */
package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
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
import lapr.project.controller.EvaluateApplicationsController;
import lapr.project.model.Evaluable;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.StaffAttribution;
import lapr.project.model.StaffMember;
import lapr.project.model.Submittable;
import lapr.project.model.application.ApplicationInEvaluationState;
import lapr.project.ui.components.DialogEvaluateApplication;
import lapr.project.ui.components.DialogSeeApplication;
import lapr.project.ui.components.ModelListStaffAttributions;
import lapr.project.ui.components.ModelListSubmittables;
import lapr.project.utils.DefaultInstantiator;

/**
 * Graphic user interface to evaluate applications.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class EvaluateApplicationUI extends JFrame {

    /**
     * The controller to evaluate applications.
     */
    private final EvaluateApplicationsController controller;

    /**
     * The exhibition center.
     */
    private final ExhibitionCenter exhibitionCenter;

    /**
     * The logged staff member.
     */
    private final StaffMember staffMember;

    /**
     * The evaluable.
     */
    private Evaluable evaluable;

    /**
     * The submittables list.
     */
    private final List<Submittable> submittablesList;

    /**
     * The staff attributions list.
     */
    private List<StaffAttribution> staffAttributionsList;

    /**
     * Submittables JList component.
     */
    private JList submittablesJList;

    /**
     * Staff attributions JList component.
     */
    private JList staffAttributionsJList;

    /**
     * See application button.
     */
    private JButton seeApplicationButton;

    /**
     * Evaluate application button.
     */
    private JButton evaluateApplicationButton;

    /**
     * Title for the window.
     */
    private static final String WINDOW_TITLE = "Evaluate applications";

    /**
     * Window dimension.
     */
    private static final Dimension WINDOW_DIMEMNSION = new Dimension(600, 400);

    /**
     * Padding border.
     */
    final static EmptyBorder PADDING_BORDER = new EmptyBorder(10, 10, 10, 10);

    /**
     * Creates an instance of evalute application UI receiving a exhibition
     * center and a staff member.
     *
     * @param exhibitionCenter the exhibition center
     * @param staffMember the staff member logged in
     */
    public EvaluateApplicationUI(ExhibitionCenter exhibitionCenter, StaffMember staffMember) {
        super(WINDOW_TITLE);

        this.exhibitionCenter = exhibitionCenter;
        this.staffMember = staffMember;

        this.controller = new EvaluateApplicationsController(this.exhibitionCenter);
        this.submittablesList = this.controller.getSubmittablesByStaff(staffMember);

        createComponents();

        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setSize(WINDOW_DIMEMNSION);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Create the UI components.
     */
    private void createComponents() {
        JPanel componentsPanel = new JPanel(new BorderLayout(10, 10));
        componentsPanel.add(createListsPanel(), BorderLayout.CENTER);
        componentsPanel.add(createButtonsPanel(), BorderLayout.SOUTH);
        componentsPanel.setBorder(PADDING_BORDER);
        add(componentsPanel);
    }

    /**
     * Create the lists panel.
     *
     * @return lists panel
     */
    private JPanel createListsPanel() {
        JPanel listsPanel = new JPanel(new GridLayout(1, 2, 10, 0));

        listsPanel.add(createSubmittablesPanel());
        listsPanel.add(createStaffAttributionsPanel());

        return listsPanel;
    }

    /**
     * Creates the submittables panel.
     *
     * @return submittables panel
     */
    private JPanel createSubmittablesPanel() {
        JPanel SubmittablesPanel = new JPanel(new BorderLayout(10, 10));

        JLabel titleLabel = new JLabel("Select a submittable:", SwingConstants.CENTER);
        this.submittablesJList = new JList();
        this.submittablesJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.submittablesJList.setModel(new ModelListSubmittables(this.submittablesList));

        this.submittablesJList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (submittablesJList.getSelectedIndex() >= 0) {
                    // TODO verify
                    Submittable selectedSubmittable = submittablesList.get(submittablesJList.getSelectedIndex());
                    EvaluateApplicationUI.this.controller.setSubmittable(selectedSubmittable);
                    EvaluateApplicationUI.this.staffAttributionsList = EvaluateApplicationUI.this.controller.getAttributionsByStaff(EvaluateApplicationUI.this.staffMember);
                    EvaluateApplicationUI.this.staffAttributionsJList.setModel(new ModelListStaffAttributions(EvaluateApplicationUI.this.staffAttributionsList));
                } else {
                    // TODO verify
                    EvaluateApplicationUI.this.staffAttributionsList = new ArrayList<>();
                    EvaluateApplicationUI.this.staffAttributionsJList.setModel(new ModelListStaffAttributions(EvaluateApplicationUI.this.staffAttributionsList));
                }
            }
        });

        JScrollPane submittablesJScroll = new JScrollPane(this.submittablesJList);

        SubmittablesPanel.add(titleLabel, BorderLayout.NORTH);
        SubmittablesPanel.add(submittablesJScroll, BorderLayout.CENTER);

        return SubmittablesPanel;
    }

    /**
     * Create the staff attributions panel.
     *
     * @return staff attributions panel
     */
    private JPanel createStaffAttributionsPanel() {
        JPanel staffAttributionsPanel = new JPanel(new BorderLayout(10, 10));

        JLabel titleLabel = new JLabel("Select an attribution:", SwingConstants.CENTER);
        this.staffAttributionsJList = new JList();
        this.staffAttributionsJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.staffAttributionsJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // TODO enable butons
                EvaluateApplicationUI.this.seeApplicationButton.setEnabled(!EvaluateApplicationUI.this.staffAttributionsJList.isSelectionEmpty());
                EvaluateApplicationUI.this.evaluateApplicationButton.setEnabled(!EvaluateApplicationUI.this.staffAttributionsJList.isSelectionEmpty());

                if (submittablesJList.getSelectedIndex() >= 0) {
                    evaluable = controller.getEvaluableByAttribution(staffAttributionsList.get(staffAttributionsJList.getSelectedIndex()));
                }
            }
        });

        JScrollPane staffAtributtionsJScroll = new JScrollPane(this.staffAttributionsJList);

        staffAttributionsPanel.add(titleLabel, BorderLayout.NORTH);
        staffAttributionsPanel.add(staffAtributtionsJScroll, BorderLayout.CENTER);

        return staffAttributionsPanel;
    }

    /**
     * Create the buttons panel.
     *
     * @return buttons panel
     */
    private JPanel createButtonsPanel() {
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 3, 10, 0));

        buttonsPanel.add(createSeeApplicationButton());
        buttonsPanel.add(createEvaluateApplicationButton());
        buttonsPanel.add(createExitButton());

        return buttonsPanel;
    }

    /**
     * Creates the see application button.
     *
     * @return see application button
     */
    private JButton createSeeApplicationButton() {
        this.seeApplicationButton = new JButton("See Application");
        this.seeApplicationButton.setEnabled(false);

        this.seeApplicationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO open the see application dialog
                new DialogSeeApplication(EvaluateApplicationUI.this.evaluable, EvaluateApplicationUI.this);
            }
        });

        return this.seeApplicationButton;
    }

    /**
     * Creates the evaluate application button.
     *
     * @return evaluate application button
     */
    private JButton createEvaluateApplicationButton() {
        this.evaluateApplicationButton = new JButton("Evaluate Application");
        this.evaluateApplicationButton.setEnabled(false);

        this.evaluateApplicationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO open the evaluate application dialog
                new DialogEvaluateApplication(evaluable, controller, EvaluateApplicationUI.this);
            }
        });

        return evaluateApplicationButton;
    }

    /**
     * Creates the exit button.
     *
     * @return exit button
     */
    private JButton createExitButton() {
        JButton exitButton = new JButton("Sair");

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                // TODO go to the last naviagble window
            }
        });

        return exitButton;
    }

    public void updateStaffAtributionsList() {
        this.staffAttributionsList = controller.getAttributionsByStaff(staffMember);
        this.staffAttributionsJList.setModel(new ModelListStaffAttributions(EvaluateApplicationUI.this.staffAttributionsList));
    }

    /**
     * Starting method for testing purposes, later wil be removed.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        ExhibitionCenter ec = DefaultInstantiator.createExhibitionCenter();
        ec.getExhibitionsRegister().getExhibitionsList().get(0).getApplicationsList().getApplicationsList().get(0)
                .setState(new ApplicationInEvaluationState(ec.getExhibitionsRegister().getExhibitionsList().get(0).getApplicationsList().getApplicationsList().get(0)));
        StaffMember sm = ec.getExhibitionsRegister().getExhibitionsList().get(0).getStaffList().getStaffList().get(0);
        new EvaluateApplicationUI(ec, sm);
    }
}
