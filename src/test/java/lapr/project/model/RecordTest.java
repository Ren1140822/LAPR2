/**
 * Package location for Model concept tests.
 */
package lapr.project.model;

import java.util.ArrayList;
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
        this.record = this.exhibitionCenter.getRecord();
    }

    /**
     * Test of calculateStaffAnalytics method, of class Record.
     */
    @Test
    public void testCalculateStaffAnalytics() {
        System.out.println("calculateStaffAnalytics");

        List<StaffMember> staff = new ArrayList<>();
        staff.add(new StaffMember(new User("Ivo Ferro", "ivoferro", "1151159@isep.ipp.pt", "123+Qwe", new ArrayList<>())));
        staff.add(new StaffMember(new User("Daniel Gonçalves", "danielgoncalves", "1151452@isep.ipp.pt", "Qwe+123", new ArrayList<>())));
        staff.add(new StaffMember(new User("Eric Amaral", "ericamaral", "1141570@isep.ipp.pt", "234+Wer", new ArrayList<>())));
        staff.add(new StaffMember(new User("Renato Oliveira", "renatooliveira", "1140822@isep.ipp.pt", "Wer+234", new ArrayList<>())));
        staff.add(new StaffMember(new User("Ricardo Correia", "ricardocorreia", "1151231", "123-Asd", new ArrayList<>())));

        List<Application> applications = new ArrayList<>();
        for (int i = 0; i < 35; i++) {
            applications.add(new ExhibitionApplication());
        }

        Float[][] matrix = {
            {1.8f, 2.9f, 3.8f, 3.8f, 2.4f, 0.9f, 4.4f, 4.6f, 0.7f, 3.3f, 0.9f, 3.8f, 4.3f, 0.6f, 3.1f, 1.2f, 4.3f, 1.4f, 1.4f, 3.5f, 3.0f, 3.0f, 2.7f, 2.7f, 2.1f, 4.3f, 4.8f, 3.9f, 2.1f, 0.8f, 2.2f, 3.5f, 1.5f, 4.3f, 3.2f},
            {3.7f, 1.0f, 0.5f, 0.8f, 4.1f, 2.3f, 0.8f, 4.8f, 1.0f, 2.1f, 0.9f, 4.7f, 2.2f, null, 1.4f, 2.0f, 2.2f, 2.7f, 2.0f, 1.0f, 3.0f, 4.4f, 1.3f, 0.5f, 5.0f, 0.4f, 1.7f, 0.6f, 2.1f, 3.6f, 2.2f, 1.0f, 1.7f, 0.8f, 3.3f},
            {1.1f, 3.9f, 3.6f, 0.3f, 0.4f, null, 0.8f, 1.9f, 4.3f, 1.8f, null, 1.6f, 1.8f, 3.4f, 2.2f, 0.3f, 1.4f, 4.0f, 3.2f, 3.7f, 1.1f, 3.9f, 3.9f, null, 4.4f, 1.1f, 3.0f, null, 3.0f, 3.1f, 2.3f, 0.0f, 4.8f, 5.0f, 3.8f},
            {3.6f, 2.9f, 0.8f, 0.8f, 2.7f, null, 2.3f, 3.0f, 4.1f, 4.2f, 4.6f, 0.5f, 0.7f, 2.5f, 2.6f, 4.1f, 2.9f, 4.8f, 4.2f, null, 4.9f, 4.8f, 0.2f, 2.3f, 1.0f, 0.9f, 0.0f, 0.5f, 5.0f, null, 1.0f, 1.8f, 1.8f, 2.3f, 1.8f},
            {4.5f, 3.6f, 4.8f, 4.6f, 1.1f, 1.6f, 1.5f, 1.1f, 2.6f, 2.1f, 0.6f, 3.0f, 3.9f, 3.0f, 4.6f, 2.2f, 1.9f, 2.7f, 0.4f, 1.8f, 2.7f, 3.8f, 1.4f, null, 1.2f, 0.5f, 3.5f, null, 3.0f, 2.2f, 0.1f, 1.1f, 1.8f, 2.6f, 1.4f}
        };
        Record testRecord = new Record(staff, applications, matrix);

        List<StaffMemberAnalytic> expResult = new ArrayList<>();
        expResult.add(new StaffMemberAnalytic(staff.get(0), 35, 2.78f, 1.14f, 2.03f, false));
        expResult.add(new StaffMemberAnalytic(staff.get(1), 34, 2.11f, 1.21f, 1.80f, false));
        expResult.add(new StaffMemberAnalytic(staff.get(2), 31, 2.55f, 1.30f, 1.83f, false));
        expResult.add(new StaffMemberAnalytic(staff.get(3), 32, 2.49f, 1.32f, 1.48f, false));
        expResult.add(new StaffMemberAnalytic(staff.get(4), 33, 2.33f, 1.10f, 1.76f, false));

        List<StaffMemberAnalytic> result = testRecord.calculateStaffAnalytics();
        assertEquals(expResult, result);
    }

//    /**
//     * Test of equals method, of class Record.
//     */
//    @Test
//    public void testEquals() {
//        System.out.println("equals");
//        Object otherObject = DefaultInstantiator.createExhibitionCenter().getRecord();
//        assertTrue(this.record.equals(otherObject));
//    }
    /**
     * Test of equals method, of class Record.
     */
    @Test
    public void testEqualsFalse() {
        System.out.println("equals - with different object");
        Object otherObject = new Record();
        assertFalse(this.record.equals(otherObject));
    }

//    /**
//     * Test of addEvaluation method, of class Record.
//     */
//    @Test // How can i test this without getters and setters? should this have an unit test?
//    public void testAddEvaluation() {
//        System.out.println("addEvaluation");
//        float average = 3.3F;
//        StaffMember staffMember = new StaffMember();
//        Application application = new ExhibitionApplication();
//        this.record.addEvaluation(average, staffMember, application);
//    }
}
