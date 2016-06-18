/**
 * Package location for Import Exhibition Controller concepts.
 */
package lapr.project.controller;

import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitionsManager;
import lapr.project.model.ExhibitionsRegister;

/**
 * Represents a import exhibitions controller.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ImportExhibitionController {

    /**
     * The exhibition center.
     */
    private ExhibitionCenter exhibitionCenter;

//    /**
//     * The exhibition manager.
//     */
//    private ExhibitionsManager exhibitionsManager;
    /**
     * The exhibitions Register.
     */
    private ExhibitionsRegister exhibitionsRegister;

    /**
     * Temporary exhibition variable.
     */
    private Exhibition exhibition;

    /**
     * Builds instance of this class receiving an exhibitions manager and
     * exhibition center as parameters.
     *
     * @param exhibitionsManager the exhibitions manager
     * @param exhibitionCenter the exhibition center
     */
    public ImportExhibitionController(ExhibitionsManager exhibitionsManager, ExhibitionCenter exhibitionCenter) {
        this.exhibitionCenter = exhibitionCenter;
//        this.exhibitionsManager = exhibitionsManager;
    }

    /**
     * Gets the exhibitions register for this instance of exhibition center.
     */
    private void getExhibitionsRegister() {
        this.exhibitionsRegister = this.exhibitionCenter.getExhibitionsRegister();

    }

    /**
     * Reads a exhibition from a file.
     *
     * @param filePath The file path on the system
     */
    public boolean readExhibitionFromFile(String filePath) {
        getExhibitionsRegister();
        this.exhibition = this.exhibitionsRegister.importByFileName(filePath);
        return exhibition != null;
    }

    /**
     * Registers the selected exhibition.
     *
     * @param exhibition The exhibition to register
     */
    public boolean registerExhibition(Exhibition exhibition) {
        return this.exhibitionsRegister.registerImportedExhibition(exhibition);

    }

    /**
     * Gets current exhibition
     *
     * @return this exhibition
     */
    public Exhibition getExhibition() {
        return exhibition;
    }

}
