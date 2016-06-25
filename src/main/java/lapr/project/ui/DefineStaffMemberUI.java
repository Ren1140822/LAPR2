/**
 * Package location for UI concepts.
 */
package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import lapr.project.controller.DefineStaffController;
import lapr.project.model.Demonstration;
import lapr.project.model.DemonstrationsList;
import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitionsRegister;
import lapr.project.model.Organizer;
import lapr.project.model.OrganizersList;
import lapr.project.model.User;
import lapr.project.model.UsersRegister;
import lapr.project.model.exhibition.ExhibitionOpenApplicationsState;
import lapr.project.ui.components.DialogSelectable;
import lapr.project.ui.components.ModelListSelectable;

/**
 * GUI for DefineStaffMember
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class DefineStaffMemberUI extends JFrame {

    /**
     * Exhibition Center.
     */
    private final ExhibitionCenter exhibitionCenter;

    /**
     * The controller of define staff member UC.
     */
    private final DefineStaffController defineStaffController;
    /**
     * The organizer.
     */
    private Organizer organizer;
    /**
     * The exhibition selected by UI.
     */
    private Exhibition selectedExhibition;
    /**
     * Label size.
     */
    final Dimension LBL_SIZE = new Dimension(94, 16);
    /**
     * Window size.
     */
    final Dimension WINDOW_SIZE = new Dimension(600, 600);
    /**
     * Field margins.
     */
    final int MARGIN_S_FIELD = 0, MARGIN_I_FIELD = 0,
            MARGIN_E_FIELD = 10, MARGIN_D_FIELD = 0;
    /**
     * Field width.
     */
    final int FIELD_TXT_WIDTH = 20, FIELD_NUM_HEIGHT = 6;
    /**
     * Empty border.
     */
    final static EmptyBorder PADDING_BORDER = new EmptyBorder(10, 10, 10, 10);
    /**
     * Scroll size.
     */
    final Dimension SCROLL_SIZE = new Dimension(300, 500);
    /**
     * Title for the window.
     */
    private static final String WINDOW_TITLE = "Define staff member";
    /**
     * The exhibition list.
     */
    private List<Exhibition> exhibitionList;
    /**
     * The users JList.
     */
    private JList jListUsers;
    /**
     * The users list.
     */
    private List<User> userList;

    public DefineStaffMemberUI(ExhibitionCenter exhibitionCenter, Organizer organizer) {
        super(WINDOW_TITLE);
        this.exhibitionCenter = exhibitionCenter;
        this.organizer = organizer;
        this.defineStaffController = new DefineStaffController(this.organizer, this.exhibitionCenter);
        this.exhibitionList = defineStaffController.getExhibitionList(this.organizer);
        DialogSelectable dialogSelectable = new DialogSelectable(this, this.exhibitionList);
        this.selectedExhibition = (Exhibition) dialogSelectable.getSelectedItem();

        if (this.selectedExhibition != null) {
            defineStaffController.setExhibition(selectedExhibition);
            createComponents();
            pack();
            setSize(WINDOW_SIZE);
            setMinimumSize(new Dimension(getWidth(), getHeight()));
            setLocationRelativeTo(null);
            setVisible(true);
        } else {
            dispose();
            new DashboardUI(exhibitionCenter, organizer);
        }
    }

    public void createComponents() {
        JPanel panelUsers = createPanelUsers();
        add(panelUsers, BorderLayout.WEST);
    }

    public JPanel createPanelUsers() {
        JPanel panelScroll = new JPanel(new GridLayout());
        panelScroll.setBorder(BorderFactory.createTitledBorder(PADDING_BORDER,
                "Users list", TitledBorder.LEFT, TitledBorder.TOP));

        this.userList = defineStaffController.getUserList();
        this.jListUsers = new JList(new ModelListSelectable(this.userList));
        this.jListUsers.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (jListUsers.getSelectedValue() != null) {
                    int response = JOptionPane.showConfirmDialog(rootPane, "Do you wish to define this user as Staff member?", "Define Staff member", JOptionPane.YES_NO_OPTION);
                    if (response == JOptionPane.YES_OPTION) {

                        response = JOptionPane.showConfirmDialog(rootPane, "User added as Staff Member. Do you wish to confirm?", "Define Staff member", JOptionPane.YES_NO_OPTION);
                        if (response == JOptionPane.YES_OPTION) {
                            JOptionPane.showConfirmDialog(rootPane, defineStaffController.addStaffMember() ? "Operation completed sucessfully." : "An error occured while performing this operation or this user is already a Staff Member.", "Confirm", JOptionPane.PLAIN_MESSAGE);
                            updateStaffList();
                        }
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JScrollPane scrollPane = new JScrollPane(jListUsers);
        scrollPane.setBorder(PADDING_BORDER);

        panelScroll.add(scrollPane);

        return panelScroll;
    }

    /**
     * Modifies the selected exhibition
     *
     * @param exhibition the new exhibition to set
     */
    public void setExhibition(Exhibition exhibition) {

        selectedExhibition = exhibition;
    }

    /**
     * Refresh the staff list.
     */
    private void updateStaffList() {
        this.userList = defineStaffController.getUserList();
        this.jListUsers.setModel(new ModelListSelectable(this.userList));
    }

    public static void main(String[] args) {
        ExhibitionCenter ex = new ExhibitionCenter();
        Exhibition a = new Exhibition();
        List<User> userlist = new ArrayList();
        User u = new User();
        userlist.add(u);
        UsersRegister userReg = new UsersRegister(userlist);
        ex.setUsersRegister(userReg);
        Organizer o = new Organizer();
        List<Organizer> list3 = new ArrayList();
        list3.add(o);
        OrganizersList orglist = new OrganizersList(list3);
        a.setOrganizersList(orglist);
        Demonstration a2 = new Demonstration();
        List<Demonstration> list2 = new ArrayList();
        list2.add(a2);
        DemonstrationsList demoList = new DemonstrationsList(list2);
        a.setDemonstrationsList(demoList);
        List<Exhibition> list = new ArrayList();
        a.setState(new ExhibitionOpenApplicationsState(a));
        list.add(a);
        ExhibitionsRegister exReg = new ExhibitionsRegister(list);
        ex.setExhibitionsRegister(exReg);

        DefineStaffMemberUI test = new DefineStaffMemberUI(ex, o);
    }

}
