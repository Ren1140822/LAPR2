/**
 * Package location for Application Controllers concepts.
 */
package lapr.project.controller;

import lapr.project.model.ConflictDetectionMechanism;
import lapr.project.model.ConflictType;
import lapr.project.model.ConflictTypesRegister;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitionsManager;

/**
 * Represents the controller to define type conflicts.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class DefineTypeConflictsController {

    /**
     * The exhibition center.
     */
    private final ExhibitionCenter exhibitionCenter;

    /**
     * THe exhibitions manager.
     */
    private final ExhibitionsManager exhibitionsManager;

    /**
     * The conflict type.
     */
    private ConflictType conflictType;

    /**
     * The conflictTypesRegister
     */
    private final ConflictTypesRegister conflictTypesRegister;

    /**
     * Constructs a DefineTypeConflictsController Class.
     *
     * @param exhibitionCenter Exhibition Center
     * @param exhibitionsManger Exhibitions Manager
     */
    public DefineTypeConflictsController(ExhibitionCenter exhibitionCenter, ExhibitionsManager exhibitionsManger) {

        this.exhibitionCenter = exhibitionCenter;
        this.exhibitionsManager = exhibitionsManger;
        this.conflictTypesRegister = this.exhibitionCenter.getConflictTypesRegister();
    }

    /**
     * Creates new conflict type and return the new conflict type
     *
     * @return the new conflict type created
     */
    public ConflictType newConflictType() {
        this.conflictType = this.conflictTypesRegister.newConflictType();
        return this.conflictType;
    }

    public boolean newConflictType(ConflictDetectionMechanism conflictDetectionMechanism, String descricao) {
        return (this.conflictTypesRegister.newConflictType() != null);

    }

    /**
     * Set the description to conflict type
     *
     * @param description the description passed as parameter to set to the
     * conflict type
     */
    public void setDataConflictType(String description) {
        this.conflictType.setDescription(description);
    }

    /**
     * It return true if the conflict type is validated, false otherwise
     *
     * @return return true if the conflict type is validated, false otherwise
     */
    public boolean validateData() {
        return (this.conflictType.validate() && this.conflictTypesRegister.validateTypeConflict(this.conflictType));
    }

    /**
     * Registers the new conflict type
     */
    public void registerTypeConflict() {
        this.conflictTypesRegister.registerTypeConflict(this.conflictType);
    }

}
