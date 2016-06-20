/**
 * Package location for UI concepts.
 */
package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import lapr.project.controller.AssignStandsController;
import lapr.project.model.Application;
import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionApplication;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.Organizer;
import lapr.project.model.Stand;
import lapr.project.model.Submittable;
import lapr.project.ui.components.DialogSelectable;
import lapr.project.model.application.ApplicationAcceptedState;
import lapr.project.model.exhibition.ExhibitionDecidedApplicationsState;
import lapr.project.ui.components.ModelListSelectable;
import lapr.project.utils.DefaultInstantiator;

/**
 * Represents an evaluation.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class AssignStandsUI extends JFrame {

    /**
     * The controller of exhibition importing mechanism.
     */
    private AssignStandsController assignStandsController;
    /**
     * The exhibition selected.
     */
    private Exhibition selectedExhibition;

    /**
     * The list of applications.
     */
    private List<ExhibitionApplication> applicationsList;

    /**
     * The list of stands.
     */
    private List<Stand> standsList;
    /**
     * Label size.
     */
    final Dimension LBL_SIZE = new Dimension(94, 16);
    /**
     * Window size.
     */
    final Dimension WINDOW_SIZE = new Dimension(1200, 600);
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

    public AssignStandsUI(Organizer organizer, ExhibitionCenter exhibitionCenter) {
        this.assignStandsController = new AssignStandsController(organizer, exhibitionCenter);
        this.setSize(WINDOW_SIZE);
        List<Submittable> submittableList = new ArrayList(assignStandsController.getExhibitionsListByOrganizerInApplicationsDecidedState(organizer));

        DialogSelectable dialogSelectable = new DialogSelectable(this, submittableList);

        this.selectedExhibition = (Exhibition) dialogSelectable.getSelectedItem();
        this.applicationsList = assignStandsController.getApplicationsList(selectedExhibition);
        this.standsList = assignStandsController.getStandsList();
        createComponents();
        this.setVisible(true);
    }

    public void createComponents() {
        JPanel panel = createPanelLists();
        add(panel, BorderLayout.CENTER);
    }

    public JPanel createPanelLists() {

        JPanel panel = new JPanel(new FlowLayout());
        JList listCandidaturas = createJListCandidaturas();
        //JList listStands = createJListStands();
        panel.add(listCandidaturas);
        //panel.add(listStands);
        return panel;
    }

    public JList createJListCandidaturas() {
        JList list = new JList();
        list.setModel(new ModelListSelectable(applicationsList));

        return list;
    }

    public JList createJListStands() {
        JList list = new JList();
        list.setModel(new ModelListSelectable(new ArrayList(applicationsList)));

        return list;
    }

    public static void main(String[] args) {
        ExhibitionCenter ex = DefaultInstantiator.createExhibitionCenter();
        Application application = ex.getExhibitionsRegister().getExhibitionsList().get(0).getApplicationsList().getApplicationsList().get(0);
        application.setState(new ApplicationAcceptedState(application));
        ex.getExhibitionsRegister().getExhibitionsList().get(0).setState(new ExhibitionDecidedApplicationsState(ex.getExhibitionsRegister().getExhibitionsList().get(0)));
        Organizer org = ex.getExhibitionsRegister().getExhibitionsList().get(0).getOrganizersList().getOrganizersList().get(0);
        AssignStandsUI assign = new AssignStandsUI(org, ex);
    }
}
