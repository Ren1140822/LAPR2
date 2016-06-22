/**
 * Package location for Model concept tests.
 */
package lapr.project.model;

import lapr.project.model.demonstration.DemonstrationApplicationsDecidedState;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests a demonstration class.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class DemonstrationTest {

    
    
    @Before
    public void setUp() {
    }

    /**
     * Test of isApplicationsDecided method, of class Demonstration.
     */
    @Test
    public void testIsApplicationsDecided() {
        System.out.println("isApplicationsDecided");
        Demonstration instance = new Demonstration();
        instance.setCurrentState(new DemonstrationApplicationsDecidedState(instance));
        boolean result = instance.isApplicationsDecided();
        assertTrue(result);
    }
    
}
