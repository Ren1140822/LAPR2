/**
 * Package location for Model concept tests.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lapr.project.model.exhibition.ExhibitionCreatedState;
import lapr.project.model.exhibition.ExhibitionStaffWithoutDemosState;
import lapr.project.utils.DefaultInstantiator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
     * Exhibition Center.
     */
    private ExhibitionCenter exhibitionCenter;
    
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
        
        this.exhibitionCenter = DefaultInstantiator.createExhibitionCenter();
        
        this.exhibitionsRegister = new ExhibitionsRegister();

        List<Organizer> organizerslist = new ArrayList<>();
        organizerslist.add(new Organizer(new User("Daniel", "daniell", "email@dd2", "password", new ArrayList<>())));
        organizerslist.add(new Organizer(new User("Daniel2", "daniell2", "email@dd2", "password", new ArrayList<>())));

        this.exhibition = new Exhibition("title", "description", new Date(2016, 2, 1),
                new Date(2016, 3, 1), new Date(2016, 0, 10), new Date(2016, 0, 20),
                new Date(2016, 1, 10), new Date(2016, 1, 20),
                new Place(), new StaffList(), new OrganizersList(organizerslist),
                new ApplicationsList(), new DemonstrationsList(),
                new StaffAttributionsList(), new ConflictsList());

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
     * Get the exhibitions list without Demonstrations defined by Organizer.
     *
     * @param organizer the organizer to filter exhibitions
     * @return the exhibition list without Demonstrations defined by Organizer
     */
    /**
     * Test of getGetExhibitionsListWithoutDemosDefined method, of class
     * ExhibitionsRegister.
     */
    @Test
    public void testGetExhibitionsListWithoutDemosDefined() {

        System.out.println("getExhibitionsListWithoutDemosDefined");
        
        Organizer organizer = new Organizer(new User("Daniel", "daniel", "email@dd", "password", new ArrayList<>()));
        
        Exhibition filteredExhibition1 = new Exhibition();
        filteredExhibition1.getOrganizersList().addAndValidateOrganizer(organizer);
        filteredExhibition1.setState(new ExhibitionCreatedState(filteredExhibition1));
        
        Exhibition filteredExhibition2 = new Exhibition();
        filteredExhibition2.getOrganizersList().addAndValidateOrganizer(organizer);
        filteredExhibition2.setState(new ExhibitionStaffWithoutDemosState(filteredExhibition2));
        
        Exhibition notFilteredExhibition = new Exhibition();
        
        List<Exhibition> exhibitionsList = new ArrayList<>();
        exhibitionsList.add(filteredExhibition1);
        exhibitionsList.add(filteredExhibition2);
        exhibitionsList.add(notFilteredExhibition);
        this.exhibitionCenter.setExhibitionsRegister(new ExhibitionsRegister(exhibitionsList));
        
        ExhibitionsRegister instance = this.exhibitionCenter.getExhibitionsRegister();
        
        exhibitionsList.remove(notFilteredExhibition);
        List<Exhibition> expResult = exhibitionsList;
        List<Exhibition> result = instance.getExhibitionsListWithoutDemosDefined(organizer);
        assertEquals(expResult, result);
       
    }
}
