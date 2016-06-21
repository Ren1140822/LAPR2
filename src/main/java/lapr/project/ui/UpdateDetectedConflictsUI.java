/**
 * Package location for UI classes.
 */
package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
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
import lapr.project.controller.UpdateDetectedConflictsController;
import lapr.project.model.Application;
import lapr.project.model.Conflict;
import lapr.project.model.ConflictType;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.StaffMember;
import lapr.project.model.Submittable;
import lapr.project.model.exhibition.ExhibitionDetectedConflictsState;
import lapr.project.ui.components.ModelListSelectable;
import lapr.project.utils.DefaultInstantiator;

/**
 * Graphic user interface to define resources.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class UpdateDetectedConflictsUI extends JFrame {

    /**
     * The define conflicts types controller.
     */
    private final UpdateDetectedConflictsController controller;

    /**
     * The exhibition center.
     */
    private final ExhibitionCenter exhibitionCenter;

    /**
     * The staff member.
     */
    private final StaffMember staffMember;

    /**
     * The submittables list.
     */
    private List<Submittable> submittablesList;

    /**
     * The conflicts list.
     */
    private List<Conflict> conflictsList;

    /**
     * The applications list.
     */
    private List<Application> applicationsList;

    /**
     * The conflict types list.
     */
    private List<ConflictType> typeConflictsList;

    /**
     * The submittables JList.
     */
    private JList submittablesJList;

    /**
     * The conflicts JList.
     */
    private JList conflictsJList;

    /**
     * The applications JList.
     */
    private JList applicationsJList;

    /**
     * The conflict types JList.
     */
    private JList typeConflictsJList;

    /**
     * Remove conflict types button.
     */
    private JButton seeConflictsListButton;

    /**
     * Title for the window.
     */
    private static final String WINDOW_TITLE = "Update detected conflicts";

    /**
     * Window dimension.
     */
    private static final Dimension WINDOW_DIMEMNSION = new Dimension(600, 400);

    /**
     * Padding border.
     */
    final static EmptyBorder PADDING_BORDER = new EmptyBorder(10, 10, 10, 10);

    /**
     * Creates an instance of define conflicts types user interface.
     *
     * @param exhibitionCenter the exhibition center
     * @param staffMember the staff member
     */
    public UpdateDetectedConflictsUI(ExhibitionCenter exhibitionCenter, StaffMember staffMember) {
        super(WINDOW_TITLE);

        this.exhibitionCenter = exhibitionCenter;
        this.staffMember = staffMember;
        this.controller = new UpdateDetectedConflictsController(this.exhibitionCenter, this.staffMember);

        this.submittablesList = this.controller.getSubmittableListByStaffMember();

        createComponents();

        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setSize(WINDOW_DIMEMNSION);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    /**
     * Creates the UI components.
     */
    private void createComponents() {
        JPanel componentsPanel = new JPanel(new BorderLayout(10, 10));
        componentsPanel.add(createTitleLabel(), BorderLayout.NORTH);
        componentsPanel.add(createSubmittablesPanel(), BorderLayout.CENTER);
//        componentsPanel.add(createButtonsPanel(), BorderLayout.SOUTH);
        componentsPanel.setBorder(PADDING_BORDER);
        add(componentsPanel);
    }

    /**
     * Creates the title label.
     *
     * @return title label
     */
    private JLabel createTitleLabel() {
        return new JLabel("Submittables:", SwingConstants.CENTER);
    }

    /**
     * Creates the conflicts types panel.
     *
     * @return the conflicts types panel
     */
    private JPanel createSubmittablesPanel() {
        JPanel submittablesListPanel = new JPanel(new BorderLayout());

        this.submittablesJList = new JList();
        this.submittablesJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.submittablesJList.setModel(new ModelListSelectable(this.submittablesList));
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) this.submittablesJList.getCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);

        this.submittablesJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
//                UpdateDetectedConflictsUI.this.seeConflictsListButton.setEnabled(!UpdateDetectedConflictsUI.this.submittablesJList.isSelectionEmpty());
//                if (UpdateDetectedConflictsUI.this.submittablesJList.getSelectedIndex() >= 0) {
//                    UpdateDetectedConflictsUI.this.controller.setSubmittable(
//                            UpdateDetectedConflictsUI.this.submittablesList.get(
//                                    UpdateDetectedConflictsUI.this.submittablesJList.getSelectedIndex()));
//                }
            }
        });

        JScrollPane submittablesJScrollPane = new JScrollPane(this.submittablesJList);
        submittablesListPanel.add(submittablesJScrollPane, BorderLayout.CENTER);

        return submittablesListPanel;
    }

    /**
     * Creates the see application button.
     *
     * @return see application button
     */
//    private JButton createSeeConflictsListButton() {
//        this.seeConflictsListButton = new JButton("See conflicts list");
//        this.seeConflictsListButton.setEnabled(false);
//
//        this.seeConflictsListButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                UpdateDetectedConflictsUI.this.conflictsJList = new JList();
//                UpdateDetectedConflictsUI.this.conflictsJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//                UpdateDetectedConflictsUI.this.conflictsJList.setModel(new ModelListSubmittables(UpdateDetectedConflictsUI.this.submittablesList));
//                DefaultListCellRenderer renderer = (DefaultListCellRenderer) UpdateDetectedConflictsUI.this.submittablesJList.getCellRenderer();
//                renderer.setHorizontalAlignment(JLabel.CENTER);
//            }
//        });
//        return this.seeConflictsListButton;
//    }
    /**
     * Starting method for testing purposes.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
//        ExhibitionCenter ec = new ExhibitionCenter();
//        ConflictType cta = new ConflictType("Histórico na empresa");
//        ConflictType ctb = new ConflictType("Cunha");
//        ConflictType ctc = new ConflictType("Amizade");
//        List<ConflictType> ctList = new ArrayList();
//        ctList = ec.getConflictTypesRegister().getConflictTypesList();
//        ctList.add(cta);
//        ctList.add(ctb);
//        ctList.add(ctc);
//        ec.getConflictTypesRegister().setConflictTypesList(ctList);
//        Demonstration demonstration1 = new Demonstration();
//        demonstration1.setCurrentState(new DemonstrationApplicationsDecidedState(demonstration1));
//        List<Demonstration> demonsList1 = new ArrayList<>();
//        demonsList1.add(demonstration1);
//
//        User userEric = new User("Eric Amaral", "ericamaral", "1141570@isep.ipp.pt", "234+Wer", new ArrayList<>());
//        User userRenato = new User("Renato Oliveira", "renatooliveira", "1140822@isep.ipp.pt", "Wer+234", new ArrayList<>());
//        StaffMember staffMemberEric = new StaffMember(userEric);
//        StaffMember staffMemberRenato = new StaffMember(userRenato);
//        List<StaffMember> staffMembers = new ArrayList<>();
//        staffMembers.add(staffMemberEric);
//
//        Exhibition exhibition1 = new Exhibition();
//        exhibition1.setState(new ExhibitionDetectedConflictsState(exhibition1));
//        exhibition1.setDemonstrationsList(new DemonstrationsList(demonsList1));
//        Demonstration demonstration2 = new Demonstration();
//        demonstration2.setCurrentState(new DemonstrationChangedConflictsState(demonstration2));
//        List<Demonstration> demonsList2 = new ArrayList<>();
//        demonsList2.add(demonstration2);
//        Exhibition exhibition2 = new Exhibition();
//        exhibition2.setState(new ExhibitionDecidedApplicationsState(exhibition2));
//        exhibition2.setDemonstrationsList(new DemonstrationsList(demonsList2));
//        Exhibition exhibition3 = new Exhibition();
//        exhibition3.setState(new ExhibitionApplicationsInEvaluationState(exhibition3));
//        List<Exhibition> exhibitionsList = new ArrayList<>();
//        exhibitionsList.add(exhibition1);
//        exhibitionsList.add(exhibition2);
//        exhibitionsList.add(exhibition3);
//
//        exhibition1.getStaffList().getStaffList().addAll(staffMembers);
//
//        StaffMember sm = new StaffMember();
//
//        new UpdateDetectedConflictsUI(ec, staffMemberEric);

        ExhibitionCenter exhibitionCenter = DefaultInstantiator.createExhibitionCenter();
        StaffMember staffMember = exhibitionCenter.getExhibitionsRegister().getExhibitionsList()
                .get(0).getStaffList().getStaffList().get(0);
        exhibitionCenter.getExhibitionsRegister().getExhibitionsList().get(0)
                .setState(new ExhibitionDetectedConflictsState(exhibitionCenter
                                .getExhibitionsRegister().getExhibitionsList().get(0)));

        new UpdateDetectedConflictsUI(exhibitionCenter, staffMember);
    }

}
