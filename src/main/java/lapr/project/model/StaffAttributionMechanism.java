/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import com.sun.xml.internal.bind.AnyTypeAdapter;
import java.util.List;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Represents an interface of StaffAttributionMechanism
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
  @XmlJavaTypeAdapter(AnyTypeAdapter.class)
public interface StaffAttributionMechanism {

    
    
    /**
     * Creates attributions list
     * 
     * @param submittable
     * @return attributionsList
     */
    List<StaffAttribution> toAssign(Submittable submittable);

    /**
     * Gets the description of the mechanism
     *
     * @return mechanism's description
     */
    String getDescription();
}
