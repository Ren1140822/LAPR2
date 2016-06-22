/**
 * Package location for UI classes.
 */
package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
import lapr.project.controller.UpdateDetectedConflictsController;
import lapr.project.model.Application;
import lapr.project.model.Conflict;
import lapr.project.model.ConflictType;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.StaffMember;
import lapr.project.model.Submittable;
import lapr.project.model.exhibition.ExhibitionDetectedConflictsState;
import lapr.project.ui.components.DialogSelectable;
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
     * The remove conflicts button.
     */
    private JButton removeConflictsButton;

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

        final String chooseSubmittableText = "Which submittable do you wish to update the detected conflits?";
        DialogSelectable dialogSelectable = new DialogSelectable(this, this.submittablesList, chooseSubmittableText);
        Submittable selectedSubmittable = (Submittable) dialogSelectable.getSelectedItem();
        this.conflictsList = selectedSubmittable.getConflictListByStaffMember(staffMember);

        if (selectedSubmittable == null) {
            // TODO voltar à janela anterior.
            dispose();
        }

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
        componentsPanel.add(createConflictsListPanel(), BorderLayout.CENTER);
        componentsPanel.add(createButtonsPanel(), BorderLayout.SOUTH);
        componentsPanel.setBorder(PADDING_BORDER);
        add(componentsPanel);
    }

    /**
     * Creates the title label.
     *
     * @return title label
     */
    private JLabel createTitleLabel() {
        return new JLabel("Conflicts list:", SwingConstants.CENTER);
    }

    /**
     * Creates the conflicts types panel.
     *
     * @return the conflicts types panel
     */
    private JPanel createConflictsListPanel() {
        JPanel conflictsListPanel = new JPanel(new BorderLayout());

        this.conflictsJList = new JList();
        this.conflictsJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.conflictsJList.setModel(new ModelListSelectable(this.conflictsList));
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) this.conflictsJList.getCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);

        this.conflictsJList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                UpdateDetectedConflictsUI.this.removeConflictsButton
                        .setEnabled(!UpdateDetectedConflictsUI.this.conflictsJList.isSelectionEmpty());
            }
        });

        JScrollPane conflictsJScrollPane = new JScrollPane(this.conflictsJList);
        conflictsListPanel.add(conflictsJScrollPane, BorderLayout.CENTER);

        return conflictsListPanel;
    }

    /**
     * Creates the buttons panel.
     *
     * @return buttons panel
     */
    private JPanel createButtonsPanel() {
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        buttonsPanel.add(createAddNewConflictButton());
        buttonsPanel.add(createRemoveConflictButton());

        return buttonsPanel;
    }

    /**
     * Creates the add conflict button.
     *
     * @return add conflict button
     */
    private JButton createAddNewConflictButton() {
        JButton addNewConflictButton = new JButton("Add new conflict");

        addNewConflictButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }

        });

        return addNewConflictButton;
    }

    /**
     * Creates the remove button for conflicts.
     *
     * @return conflicts remove button
     */
    private JButton createRemoveConflictButton() {
        this.removeConflictsButton = new JButton("Remove Conflict");
        this.removeConflictsButton.setEnabled(false);

        this.removeConflictsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Conflict conflict = UpdateDetectedConflictsUI.this.conflictsList
                        .get(UpdateDetectedConflictsUI.this.conflictsJList.getSelectedIndex());
                UpdateDetectedConflictsUI.this.conflictsList.remove(conflict);
                UpdateDetectedConflictsUI.this.updateConflictsList();
                JOptionPane.showMessageDialog(UpdateDetectedConflictsUI.this,
                        "The conflict was successful removed!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);

            }
        });

        return this.removeConflictsButton;
    }

    /**
     * Refresh the conflicts list.
     */
    private void updateConflictsList() {
        this.conflictsJList.setModel(new ModelListSelectable(this.conflictsList));
    }

//    /**
//     * Creates the conflicts types panel.
//     *
//     * @return the conflicts types panel
//     */
//    private JPanel createSubmittablesPanel() {
//        JPanel submittablesListPanel = new JPanel(new BorderLayout());
//
//        this.submittablesJList = new JList();
//        this.submittablesJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        this.submittablesJList.setModel(new ModelListSelectable(this.submittablesList));
//        DefaultListCellRenderer renderer = (DefaultListCellRenderer) this.submittablesJList.getCellRenderer();
//        renderer.setHorizontalAlignment(JLabel.CENTER);
//
//        this.submittablesJList.addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent lse) {
//                UpdateDetectedConflictsUI.this.seeConflictsListButton.setEnabled(!UpdateDetectedConflictsUI.this.submittablesJList.isSelectionEmpty());
//                if (UpdateDetectedConflictsUI.this.submittablesJList.getSelectedIndex() >= 0) {
//                    UpdateDetectedConflictsUI.this.controller.setSubmittable(
//                            UpdateDetectedConflictsUI.this.submittablesList.get(
//                                    UpdateDetectedConflictsUI.this.submittablesJList.getSelectedIndex()));
//                }
//            }
//        });
//        JScrollPane submittablesJScrollPane = new JScrollPane(this.submittablesJList);
//        submittablesListPanel.add(submittablesJScrollPane, BorderLayout.CENTER);
//
//        return submittablesListPanel;
//    }
//    /**
//     * Creates the see application button.
//     *
//     * @return see application button
//     */
//    private JButton createSeeConflictsListButton() {
//        this.seeConflictsListButton = new JButton("See conflicts list");
//        this.seeConflictsListButton.setEnabled(false);
//
//        this.seeConflictsListButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                UpdateDetectedConflictsUI.this.conflictsJList = new JList();
//                UpdateDetectedConflictsUI.this.conflictsJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//                UpdateDetectedConflictsUI.this.conflictsJList.setModel(new ModelListSelectable(UpdateDetectedConflictsUI.this.submittablesList));
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

        ExhibitionCenter exhibitionCenter = DefaultInstantiator.createExhibitionCenter();
        StaffMember staffMember = exhibitionCenter.getExhibitionsRegister().getExhibitionsList()
                .get(0).getStaffList().getStaffList().get(0);
        exhibitionCenter.getExhibitionsRegister().getExhibitionsList().get(0)
                .setState(new ExhibitionDetectedConflictsState(exhibitionCenter
                                .getExhibitionsRegister().getExhibitionsList().get(0)));

        Application a = exhibitionCenter.getExhibitionsRegister().getExhibitionsList().get(0).getApplicationsList().getApplicationsList().get(0);
        ConflictType cta = new ConflictType("Histórico na empresa");
        ConflictType ctb = new ConflictType("Cunha");
        ConflictType ctc = new ConflictType("Amizade");
        Conflict ca = new Conflict(cta, staffMember, a);

        StaffMember staffMember2 = exhibitionCenter.getExhibitionsRegister().getExhibitionsList()
                .get(0).getStaffList().getStaffList().get(1);

        Conflict cb = new Conflict(cta, staffMember2, a);
        List<Conflict> conflictsList = new ArrayList();
        conflictsList.add(ca);
        conflictsList.add(cb);

        exhibitionCenter.getExhibitionsRegister().getExhibitionsList().get(0).getConflictsList().setConflictsList(conflictsList);

        new UpdateDetectedConflictsUI(exhibitionCenter, staffMember);
    }

}
