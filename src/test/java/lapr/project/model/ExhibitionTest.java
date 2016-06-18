/**
 * Package location for Model concept tests.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lapr.project.model.exhibition.ExhibitionDecidedApplicationsState;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests a exhibition class.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ExhibitionTest {

    /**
     * Instance of Exhibition.
     */
    private Exhibition exhibition;

    @Before
    public void setUp() {

        this.exhibition = new Exhibition("title", "description", new Date(2016, 2, 1), new Date(2016, 3, 1), new Date(2016, 0, 10), new Date(2016, 0, 20), new Date(2016, 1, 10), new Date(2016, 1, 20),
                new Place(), new StaffList(), new OrganizersList(), new ApplicationsList(), new DemonstrationsList(), new StaffAttributionsList(),
                new ConflictsList());
    }

    /**
     * Test of validate method, of class Exhibition, returns false.
     */
    @Test
    public void testValidateFalse() {
        System.out.println("validate");
        Exhibition instance = new Exhibition();
        boolean result = instance.validate();
        assertFalse(result);
    }

    /**
     * Test of validate method, of class Exhibition, returns true.
     */
    @Test
    public void testValidateTrue() {
        System.out.println("validate");

        List<Organizer> organizersList = new ArrayList<>();
        organizersList.add(new Organizer());
        organizersList.add(new Organizer());
        this.exhibition.setOrganizersList(new OrganizersList(organizersList));

        boolean result = this.exhibition.validate();
        assertTrue(result);
    }

    /**
     * Test of isApplicationsDecided method, of class Exhibition.
     */
    @Test
    public void testIsApplicationsDecided() {
        System.out.println("isApplicationsDecided");
        Exhibition instance = new Exhibition();
        instance.setState(new ExhibitionDecidedApplicationsState(instance));
        boolean result = instance.isApplicationsDecided();
        assertTrue(result);
    }
}
