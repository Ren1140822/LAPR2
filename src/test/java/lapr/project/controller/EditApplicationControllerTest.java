/**
 * Package location for Apllication Controllers tests.
 */
package lapr.project.controller;

import java.util.ArrayList;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitorResponsible;
import lapr.project.model.User;
import lapr.project.utils.DefaultInstantiator;
import org.junit.Before;

/**
 * Tests an edit application controller class.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class EditApplicationControllerTest {

    /**
     * The exhibition center to be used in tests.
     */
    private ExhibitionCenter exhibitionCenter;

    /**
     * The exhibitor responsible to be used in tests.
     */
    private ExhibitorResponsible exhibitorResponsible;

    /**
     * The controller being tested.
     */
    private EditApplicationController editApplicationController;

    @Before
    public void setUp() {
        this.exhibitionCenter = DefaultInstantiator.createExhibitionCenter();
        this.exhibitorResponsible = new ExhibitorResponsible(new User("Fábio Silva", "fabiosilva", "fabiosilva@blip.pt", "Ewq+321", new ArrayList<>()));
        this.editApplicationController = new EditApplicationController(this.exhibitionCenter, this.exhibitorResponsible);
    }

//    /**
//     * Test of cloneEditable method, of class EditApplicationController.
//     */
//    @Test
//    public void testCloneEditable() {
//        System.out.println("cloneEditable");
//        Editable expResult = (Editable) this.exhibitionCenter.getExhibitionsRegister().getExhibitionsList().get(0).getApplicationsList().getApplicationsList().get(0);
//        assertEquals(expResult, this.editApplicationController.cloneEditable());
//    }
//
//    /**
//     * Test of validate method, of class EditApplicationController.
//     */
//    @Test
//    public void testValidate() {
//        System.out.println("validate");
//        Editable newEditable = new ExhibitionApplication();
//        assertTrue(this.editApplicationController.validate(newEditable));
//    }
//
//    /**
//     * Test of modifyEditable method, of class EditApplicationController.
//     */
//    @Test
//    public void testModifyEditable() {
//        System.out.println("modifyEditable");
//        this.editApplicationController.getSubmittablesByExhibitorResponsible();
//        this.editApplicationController.setSubmittable(this.exhibitionCenter.getExhibitionsRegister().getExhibitionsList().get(0));
//        this.editApplicationController.cloneEditable();
//        this.editApplicationController.validate(new ExhibitionApplication());
//        assertTrue(this.editApplicationController.modifyEditable());
//    }

}
