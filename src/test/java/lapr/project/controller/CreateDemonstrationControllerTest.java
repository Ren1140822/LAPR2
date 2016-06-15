/**
 * Package location for Apllication Controllers tests.
 */
package lapr.project.controller;

import lapr.project.model.Demonstration;
import lapr.project.model.Exhibition;
import lapr.project.model.Organizer;
import lapr.project.utils.DefaultInstantiator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests a createDemonstrationController.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class CreateDemonstrationControllerTest {

    /**
     * This Create Demonstration Controller.
     */
    private CreateDemonstrationController controller;

    @Before
    public void setUp() {

        this.controller = new CreateDemonstrationController(DefaultInstantiator.createExhibitionCenter(), new Organizer());

        Exhibition selectedExhibition = this.controller.getExhibitionCenter()
                .getExhibitionsRegister().getExhibitionsList().get(0);

        this.controller.setSelectedExhibition(selectedExhibition);
    }

    /**
     * Test of newDemonstration method, of class CreateDemonstrationController.
     */
    @Test
    public void testNewDemonstration() {
        System.out.println("newDemonstration");

        Demonstration expResult = new Demonstration();

        this.controller.newDemonstration();
        Demonstration result = this.controller.getDemonstration();

        assertEquals(expResult, result);
    }

}
