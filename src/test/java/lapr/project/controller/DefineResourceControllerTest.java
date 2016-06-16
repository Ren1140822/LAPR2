/**
 * Package location for Model concept tests.
 */
package lapr.project.controller;

import lapr.project.model.Resource;
import lapr.project.utils.DefaultInstantiator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the define resource controller.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class DefineResourceControllerTest {

    /**
     * The controller to be tested.
     */
    private DefineResourceController defineResourceController;
    
    /**
     * resource for testes.
     */
    private Resource resource;
    
    @Before
    public void setUp() {
        this.defineResourceController = new DefineResourceController(DefaultInstantiator.createExhibitionCenter());
        this.resource = new Resource("Grass");
    }

    /**
     * Test of newResource method, of class DefineResourceController.
     */
    @Test
    public void testNewResource() {
        System.out.println("newResource");
        String description = "Grass";
        assertTrue(this.defineResourceController.newResource(description));
    }

    /**
     * Test of registerResource method, of class DefineResourceController.
     */
    @Test
    public void testRegisterResource() {
        System.out.println("registerResource");
        String description = "Grass";
        this.defineResourceController.newResource(description);
        assertTrue(this.defineResourceController.registerResource());
    }

}
