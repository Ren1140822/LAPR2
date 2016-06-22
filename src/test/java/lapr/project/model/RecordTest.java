/**
 * Package location for Model concept tests.
 */
package lapr.project.model;

import java.util.List;
import lapr.project.utils.DefaultInstantiator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests a record class.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class RecordTest {

    /**
     * The record to be tested.
     */
    Record record;

    /**
     * The exhibition center used for tests.
     */
    ExhibitionCenter exhibitionCenter;

    @Before
    public void setUp() {
        this.exhibitionCenter = DefaultInstantiator.createExhibitionCenter();
//        this.record = this.exhibitionCenter.getRecord();
    }

    /**
     * Test of calculateStaffAnalytics method, of class Record.
     */
//    @Test
    public void testCalculateStaffAnalytics() {
        System.out.println("calculateStaffAnalytics");
        Record instance = new Record();
        List<StaffMemberAnalytic> expResult = null;
        List<StaffMemberAnalytic> result = instance.calculateStaffAnalytics();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
