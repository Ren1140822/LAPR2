/**
 * Package location for the Exhibiton timertasks & related classes.
 */
package lapr.project.model.exhibition.timers;

import java.util.TimerTask;
import lapr.project.model.Exhibition;

/**
 * Represents the timertask to change state to closed applications.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ChangeToClosedApplications extends TimerTask {

    /**
     * Exhibiton wich preformes the task.
     */
    private final Exhibition exhibition;

    /**
     * Constructor of the timer task.
     * 
     * @param exhibition Exhibiton wich preformes the task.
     */
    public ChangeToClosedApplications(Exhibition exhibition) {

        this.exhibition = exhibition;
    }

    /**
     * Task that is preformed once the timer is triggered.
     */
    @Override
    public void run() {
        
        this.exhibition.setClosedApplications();
    }

}
