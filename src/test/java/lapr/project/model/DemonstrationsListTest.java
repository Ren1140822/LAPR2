/**
 * Package location for Model concept tests.
 */
package lapr.project.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests a demonstrations list.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class DemonstrationsListTest {

    /**
     * Demonstrations List.
     */
    private DemonstrationsList demonstrationsList;

    @Before
    public void setUp() {
        
        this.demonstrationsList = new DemonstrationsList();
    }

    /**
     * Test of newDemonstration method, of class DemonstrationsList.
     */
    @Test
    public void testNewDemonstration_0args() {
        System.out.println("newDemonstration");
        Demonstration expResult = new Demonstration();
        Demonstration result = this.demonstrationsList.newDemonstration();
        assertEquals(expResult, result);
    }

}
