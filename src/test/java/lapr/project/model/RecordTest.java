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
