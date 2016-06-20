/**
 * Package location for Application Controllers concepts.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitionsRegister;
import lapr.project.model.Organizer;

/**
 * Represents the controller to define demonstrations controller.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class DefineEfectiveDemosController {

    /**
     * The exhibition center.
     */
    private final ExhibitionCenter exhibitionCenter;

    /**
     * Constructs a DefineEfectiveDemosController Class.
     *
     * @param exhibitionCenter Exhibition Center
     */
    public DefineEfectiveDemosController(ExhibitionCenter exhibitionCenter) {

        this.exhibitionCenter = exhibitionCenter;
    }

    /**
     * Obtain the Exhibition Center.
     *
     * @return the Exhibition Center
     */
    public ExhibitionCenter getExhibitionCenter() {
        return this.exhibitionCenter;
    }

    /**
     * Get the exhibitions list with Applications Decided (and Demos in created
     * state) by Organizer.
     *
     * @param organizer the organizer to filter exhibitions
     * @return the exhibitions list with Applications Decided (and Demos in
     * created state) by Organizer
     */
    public List<Exhibition> getExhibitionsList(Organizer organizer) {

        ExhibitionsRegister exhibitionsRegister = exhibitionCenter.getExhibitionsRegister();

        return exhibitionsRegister.getExhibitionsAppsDecidedAndDemosCreated(organizer);
    }

}
