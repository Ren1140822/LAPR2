/**
 * Package location for Model concept tests.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests a OrganizersList class.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class OrganizersListTest {

    private OrganizersList organizersList;
    private Organizer organizer;
    private User user;

    @Before
    public void setUp() {

        this.organizersList = new OrganizersList();
        this.user = new User("John Doe", "johndoe", "jdoe@email.com", "password");
        this.organizer = new Organizer(user);
    }

    /**
     * Test of newOrganizer method, of class OrganizersList.
     */
    @Test
    public void testNewOrganizer() {
        System.out.println("newOrganizer");
        Organizer expResult = new Organizer(this.user);
        Organizer result = this.organizersList.newOrganizer(this.user);
        assertEquals(expResult, result);
    }

    /**
     * Test if addAndValidateOrganizer method, of class OrganizersList, it adds
     * the organizer to the list & returns true when added to list.
     */
    @Test
    public void testAddAndValidateOrganizer() {
        System.out.println("addAndValidateOrganizer");
        List<Organizer> testList = new ArrayList<>();
        testList.add(this.organizer);

        OrganizersList expResult = new OrganizersList(testList);
        boolean result = this.organizersList.addAndValidateOrganizer(organizer);
        assertEquals(expResult, this.organizersList);
        assertTrue(result);
    }
}
