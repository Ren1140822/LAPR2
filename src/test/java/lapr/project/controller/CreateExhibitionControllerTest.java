/**
 * Package location for Apllication Controllers tests.
 */
package lapr.project.controller;

import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionCenter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests a CreateExhibitionController class.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class CreateExhibitionControllerTest {
    
    /**
     * Instance of CreateExhibitionController.
     */
    private CreateExhibitionController controller;
    
    public CreateExhibitionControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.controller = new CreateExhibitionController(new ExhibitionCenter());
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of newExhibition method, of class CreateExhibitionController.
     */
    @Test
    public void testNewExhibition() {
        System.out.println("newExhibition");
        Exhibition expResult = new Exhibition();
        this.controller.newExhibition();
        
        assertEquals(this.controller.getExhibition(), expResult);
    }
    
}
