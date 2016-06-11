/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import com.sun.xml.internal.bind.AnyTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Interface for the conflictable applications.
 * 
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
 @XmlJavaTypeAdapter(AnyTypeAdapter.class)
public interface Conflictable {
    
}
