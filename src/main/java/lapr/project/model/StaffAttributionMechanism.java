/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.util.List;

/**
 * Represents an interface of StaffAttributionMechanism
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public interface StaffAttributionMechanism {

    /**
     * Creates attributions list
     *
     * @param exhibition exhibition
     * @return returns list of attributions of the exhibition
     */
    List<StaffAttribution> getAttributionsList(Exhibition exhibition);
    
    /**
     * 
     * @param submittable
     * @return 
     */
    List<Assingnable> toAssign(Submittable submittable);

    /**
     * Gets the description of the mechanism
     *
     * @return mechanism's description
     */
    public String getDescription();
}
