/**
 * Package location for Model concept tests.
 */
package lapr.project.model;

import java.util.ArrayList;
import lapr.project.utils.DefaultInstantiator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests an application list.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ApplicationsListTest {

    /**
     * Exhibition center used int tests.
     */
    private ExhibitionCenter exhibitionCenter;

    /**
     * The application list.
     */
    private ApplicationsList applicationsList;

    @Before
    public void setUp() {
        this.exhibitionCenter = DefaultInstantiator.createExhibitionCenter();
        this.applicationsList = this.exhibitionCenter.getExhibitionsRegister().getExhibitionsList().get(0).getApplicationsList();
    }

    /**
     * Test of newExhibitionApplication method, of class ApplicationsList.
     */
    @Test
    public void testNewExhibitionApplication() {
        System.out.println("newExhibitionApplication");
        Application expResult = new ExhibitionApplication();
        Application result = this.applicationsList.newExhibitionApplication();
        assertEquals(expResult, result);
    }

    /**
     * Test of newDemonstrationApplication method, of class ApplicationsList.
     */
    @Test
    public void testNewDemonstrationApplication() {
        System.out.println("newDemonstrationApplication");
        Application expResult = new DemonstrationApplication();
        Application result = this.applicationsList.newDemonstrationApplication();
        assertEquals(expResult, result);
    }

    /**
     * Test of validateDemonstrationApplication method, of class
     * ApplicationsList.
     */
    @Test
    public void testValidateDemonstrationApplication() {
        System.out.println("validateDemonstrationApplication");
        Application application = new DemonstrationApplication();
        assertTrue(this.applicationsList.validateDemonstrationApplication(application));
    }

//    /**
//     * Test of registerDemonstrationApplication method, of class
//     * ApplicationsList.
//     */
//    @Test
//    public void testRegisterDemonstrationApplication() {
//        System.out.println("registerDemonstrationApplication");
//        Application application = new ExhibitionApplication();
//        ApplicationsList instance = new ApplicationsList();
//        instance.registerDemonstrationApplication(application);
//        assertTrue(instance.getApplicationsList().contains(application));
//    }
    /**
     * Test of getApplicationByExhibitorResponsible method, of class
     * ApplicationsList.
     */
    @Test
    public void testGetApplicationByExhibitorResponsible() {
        System.out.println("getApplicationByExhibitorResponsible");
        ExhibitorResponsible exhibitorResponsible = new ExhibitorResponsible(new User("Fábio Silva", "fabiosilva", "fabiosilva@blip.pt", "Ewq+321", new ArrayList<>()));
        Application expResult = this.applicationsList.getApplicationsList().get(0);
        Application result = this.applicationsList.getApplicationByExhibitorResponsible(exhibitorResponsible);
        assertEquals(expResult, result);
    }

    /**
     * Test of getEditableByExhibitorResponsible method, of class
     * ApplicationsList.
     */
    @Test
    public void testGetEditableByExhibitorResponsible() {
        System.out.println("getEditableByExhibitorResponsible");
        ExhibitorResponsible exhibitorResponsible = new ExhibitorResponsible(new User("Fábio Silva", "fabiosilva", "fabiosilva@blip.pt", "Ewq+321", new ArrayList<>()));
        Editable expResult = (Editable) this.applicationsList.getApplicationsList().get(0);
        Editable result = this.applicationsList.getEditableByExhibitorResponsible(exhibitorResponsible);
        assertEquals(expResult, result);

    }

    /**
     * Test of cloneEditable method, of class ApplicationsList.
     */
    @Test
    public void testCloneEditable() {
        System.out.println("cloneEditable");
        Editable editable = (Editable) this.applicationsList.getApplicationsList().get(0);
        Editable expResult = (Editable) this.applicationsList.getApplicationsList().get(0);
        Editable result = this.applicationsList.cloneEditable(editable);
        assertEquals(expResult, result);
    }

//    @Test
//    public void testValidateNewEditable() {
//        System.out.println("validateNewEditable");
//        Editable newEditable = (Editable)this.applicationsList.getApplicationsList().get(0);
//        Editable oldEditable = new ExhibitionApplication();
//        assertTrue(this.applicationsList.validateEditable(newEditable, oldEditable));
//    }
    
    /**
     * Test of modifyEditable method, of class ApplicationsList.
     */
    @Test
    public void testModifyEditable() {
        System.out.println("modifyEditable");
        Editable newEditable = (Editable) new ExhibitionApplication();
        Editable oldEditable = (Editable) this.applicationsList.getApplicationsList().get(0);
        assertTrue(this.applicationsList.modifyEditable(newEditable, oldEditable));
    }
    
    /**
     * Test of equals method, of class ApplicationsList.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object otherObject = this.exhibitionCenter.getExhibitionsRegister().getExhibitionsList().get(0).getApplicationsList();
        assertTrue(this.applicationsList.equals(otherObject));
    }

}
