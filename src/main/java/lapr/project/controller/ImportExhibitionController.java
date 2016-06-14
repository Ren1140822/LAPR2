/**
 * Package location for Import Exhibition Controller concepts.
 */
package lapr.project.controller;

import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitionsManager;
import lapr.project.model.ExhibitionsRegister;

/**
 * Represents a exhibitions register
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

    /**
     * The exhibition manager.
     */
    private ExhibitionsManager exhibitionsManager;
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
        this.exhibitionsManager = exhibitionsManager;
    }

    /**
     * Gets the exhibitions register for this instance of exhibition center.
     */
    public  ExhibitionsRegister  getExhibitionsRegister() {
        this.exhibitionsRegister = this.exhibitionCenter.getExhibitionsRegister();
        return this.exhibitionsRegister;
     
    }

    /**
     * Reads a exhibition from a file.
     * @param filePath The file path on the system
     */
    public Exhibition readExhibitionFromFile(String filePath) {
            this.exhibition = this.exhibitionsRegister.importExhibitionByFileName(filePath);
            return this.exhibition;
    }
    
    /**
     * Registers the selected exhibition.
     * @param exhibition The exhibition to register
     */
    public void registerExhibition(Exhibition exhibition){
          this.exhibitionsRegister.registerImportedExhibition(exhibition);
      
    }

}
