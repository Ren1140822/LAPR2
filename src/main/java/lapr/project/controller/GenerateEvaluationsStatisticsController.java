/**
 * Package location for AssignStandsController concepts.
 */
package lapr.project.controller;

import java.util.List;
import javafx.util.Pair;
import lapr.project.model.Actor;
import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitionsManager;
import lapr.project.model.ExhibitionsRegister;
import lapr.project.model.Organizer;

/**
 * Controller to generate evaluations statistics
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class GenerateEvaluationsStatisticsController {

    /**
     * The exhibition center.
     */
    private final ExhibitionCenter exhibitionCenter;

    /**
     * The actor logged in.
     */
    private final Actor actor;

    /**
     * Constructs an instance of generate evaluations statistics controller.
     *
     * @param exhibitionCenter the exhibition center.
     * @param actor the actor.
     */
    public GenerateEvaluationsStatisticsController(ExhibitionCenter exhibitionCenter, Actor actor) {
        this.exhibitionCenter = exhibitionCenter;
        this.actor = actor;
    }

    /**
     * Gets te acceptance rate of each exhibition.
     *
     * @return list with acceptance rates in the form of a pair with the
     * exhibition and acceptance rate
     */
    public List<Pair<Exhibition, Float>> getAcceptanceRate() {
        ExhibitionsRegister exhibitionsRegister = this.exhibitionCenter.getExhibitionsRegister();
        List<Exhibition> exhibitions = null;

        if (this.actor instanceof ExhibitionsManager) {
            exhibitions = exhibitionsRegister.getDecidedExhibitions();
        } else if (this.actor instanceof Organizer) {
            exhibitions = exhibitionsRegister.getDecidedExhibitionsByOrganizer((Organizer) this.actor);
        }

        return exhibitionsRegister.getPairExhibitionAcceptanceRate(exhibitions);

    }
}
