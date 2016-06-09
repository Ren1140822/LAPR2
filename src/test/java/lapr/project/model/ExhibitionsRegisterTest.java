/**
 * Package location for Model concept tests.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests a exhibitions register.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ExhibitionsRegisterTest {

    /**
     * Exhibition Register object.
     */
    private ExhibitionsRegister exhibitionsRegister;
    
    /**
     * Exhibition object.
     */
    private Exhibition exhibition;

    @Before
    public void setUp() {
        this.exhibitionsRegister = new ExhibitionsRegister();
        
        this.exhibition = new Exhibition("title", "description", new Date(2016, 0, 1), new Date(2016, 3, 1), new Date(2016, 0, 10), new Date(2016, 1, 1), new Date(2016, 1, 10), new Date(2016, 2, 1),
                new Place(), new StaffList(), new OrganizersList(), new ArrayList<Demonstration>(), new StaffAttributionsList());

    }

    /**
     * Test of newExhibition method, of class ExhibitionsRegister.
     */
    @Test
    public void testNewExhibition() {
        System.out.println("newExhibition");
        Exhibition expResult = new Exhibition();
        Exhibition result = exhibitionsRegister.newExhibition();
        assertEquals(expResult, result);
    }

    /**
     * Test of registerExhibition method, of class ExhibitionsRegister.
     */
    @Test
    public void testRegisterExhibition() {

        System.out.println("registerExhibition");
        boolean result = exhibitionsRegister.registerExhibition(this.exhibition);
        assertTrue(result);
    }
}
