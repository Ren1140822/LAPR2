/**
 * Package location for Model concept tests.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;

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

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        this.exhibitionsRegister = new ExhibitionsRegister();

        List<Organizer> organizerslist = new ArrayList<>();
        organizerslist.add(new Organizer(new User("Daniel", "daniell", "email@dd2", "password")));
        organizerslist.add(new Organizer(new User("Daniel2", "daniell2", "email@dd2", "password")));

        this.exhibition = new Exhibition("title", "description", new Date(2016, 2, 1), 
                new Date(2016, 3, 1), new Date(2016, 0, 10), new Date(2016, 0, 20), 
                new Date(2016, 1, 10), new Date(2016, 1, 20),
                new Place(), new StaffList(), new OrganizersList(organizerslist), 
                new ArrayList<Demonstration>(), new StaffAttributionsList());

    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of newExhibition method, of class ExhibitionsRegister.
     */
    @Test
    public void testNewExhibition() {
        System.out.println("newExhibition");
        Exhibition expResult = new Exhibition();
        Exhibition result = this.exhibitionsRegister.newExhibition();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSubmittablesByStaff method, of class ExhibitionsRegister.
     */
    @Test
    public void testGetSubmittablesByStaff() {
        System.out.println("getSubmittablesByStaff");

        StaffMember staffMember = new StaffMember();
        List<StaffMember> staffsList = new ArrayList<>();
        staffsList.add(staffMember);

        Exhibition firstExhibition = new Exhibition();
        Exhibition secondExhibition = new Exhibition();
        secondExhibition.setStaffList(new StaffList(staffsList));

        List<Exhibition> exhibitionsListTotal = new ArrayList();
        exhibitionsListTotal.add(firstExhibition);
        exhibitionsListTotal.add(secondExhibition);

        List<Exhibition> exhibitionsListExpected = new ArrayList();
        exhibitionsListExpected.add(secondExhibition);

        exhibitionsRegister.setExhibitionsList(exhibitionsListTotal);

        assertEquals(exhibitionsRegister.getSubmittablesByStaff(staffMember), exhibitionsListExpected);
    }

    /**
     * Test of registerExhibition method, of class ExhibitionsRegister,
     * registers the exhibition.
     */
    @Test
    public void testRegisterExhibition() {

        System.out.println("registerExhibition");
        this.exhibitionsRegister.registerExhibition(this.exhibition);
        List<Exhibition> expResult = new ArrayList<>();
        expResult.add(this.exhibition);
        
        List<Exhibition> result = this.exhibitionsRegister.getExhibitionsList();
        assertEquals(expResult, result);
    }

    /**
     * Test of registerExhibition method, of class ExhibitionsRegister, returns
     * true.
     */
    @Test
    public void testRegisterExhibitionReturnTrue() {

        System.out.println("registerExhibition");
        
        boolean result = exhibitionsRegister.registerExhibition(this.exhibition);
        assertTrue(result);
    }
    
// // TODO : Implement when states are all defined.
//    /**
//     * Test of getSubmittablesInChangedConflictsByOrganizer method, of class ExhibitionsRegister.
//     */
//    @Test
//    public void testGetSubmittablesInChangedConflictsByOrganizer() {
//        System.out.println("getSubmittablesInChangedConflictsByOrganizer");
//        Organizer organizer = null;
//        ExhibitionsRegister instance = new ExhibitionsRegister();
//        List<Submittable> expResult = null;
//        List<Submittable> result = instance.getSubmittablesInChangedConflictsByOrganizer(organizer);
//        assertEquals(expResult, result);
//       
//    }

    
    /**
     * Test of registerExhibition method, of class ExhibitionsRegister, returns
     * false.
     */
    @Test
    public void testRegisterExhibitionReturnFalse() {

        System.out.println("registerExhibition");
        boolean result = exhibitionsRegister.registerExhibition(new Exhibition());
        assertFalse(result);
    }
}
