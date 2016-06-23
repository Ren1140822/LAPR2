/**
 * Package location for UI classes.
 */
package lapr.project.ui;

import java.awt.Dimension;
import javax.swing.JFrame;
import lapr.project.model.Actor;
import lapr.project.model.ExhibitionCenter;
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

        createComponents();

        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setSize(WINDOW_DIMEMNSION);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createComponents() {

    }

    public static void main(String[] args) {
        ExhibitionCenter exhibitionCenter = DefaultInstantiator.createExhibitionCenter();
        Actor actor = exhibitionCenter.getExhibitionsRegister().getExhibitionsList().get(0).getOrganizersList().getOrganizersList().get(0);
        new DashboardUI(exhibitionCenter, actor);
    }
}
