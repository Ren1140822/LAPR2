/**
 * Package location for UI classes.
 */
package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import lapr.project.model.Actor;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitionsManager;
import lapr.project.model.ExhibitorResponsible;
import lapr.project.model.Organizer;
import lapr.project.model.StaffMember;
import lapr.project.ui.components.CustomMenuBar;
import lapr.project.utils.DefaultInstantiator;

/**
 * Graphic user interface for dashboard.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class DashboardUI extends JFrame {

    /**
     * The exhibition center.
     */
    private ExhibitionCenter exhibitionCenter;

    /**
     * The actor logged in.
     */
    private Actor actor;

    /**
     * The JTabbedPane.
     */
    private JTabbedPane tabPane;

    /**
     * Title for the window.
     */
    private static final String WINDOW_TITLE = "Dashboard";

    /**
     * Window dimension.
     */
    private static final Dimension WINDOW_DIMEMNSION = new Dimension(600, 400);

    /**
     * Creates the dashboard user interface.
     *
     * @param exhibitionCenter exhibition center with data
     * @param actor actor logged in
     */
    public DashboardUI(ExhibitionCenter exhibitionCenter, Actor actor) {
        super(WINDOW_TITLE);

        this.exhibitionCenter = exhibitionCenter;
        this.actor = actor;

        setJMenuBar(new CustomMenuBar(this.exhibitionCenter, this));

        if (this.actor instanceof ExhibitionsManager || this.actor instanceof Organizer) {
            createComponentsAdmin();
        } else if (this.actor instanceof StaffMember || this.actor instanceof ExhibitorResponsible) {
            createComponents();
        }

        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setSize(WINDOW_DIMEMNSION);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createComponentsAdmin() {
        JPanel componentsPanel = new JPanel(new BorderLayout(0, 10));

        componentsPanel.add(createTabPane(), BorderLayout.CENTER);
        componentsPanel.add(createButtonsPanel(), BorderLayout.SOUTH);

        add(componentsPanel);
    }

    private JTabbedPane createTabPane() {
        this.tabPane = new JTabbedPane();

        if (this.actor instanceof ExhibitionsManager) {
            // TODO add the available panes
        } else if (this.actor instanceof Organizer) {
            // TODO add the available panes
        }

        return this.tabPane;
    }

    private JPanel createButtonsPanel() {
        JPanel buttonsPanel = new JPanel();
        
        // TODO
        
        return buttonsPanel;
    }

    private void createComponents() {
        JPanel componentsPanel = new JPanel();
        
        // TODO
        
        add(componentsPanel);
    }

    public static void main(String[] args) {
        ExhibitionCenter exhibitionCenter = DefaultInstantiator.createExhibitionCenter();
        Actor actor = exhibitionCenter.getExhibitionsRegister().getExhibitionsList().get(0).getOrganizersList().getOrganizersList().get(0);
        new DashboardUI(exhibitionCenter, actor);
    }
}