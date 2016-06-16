/**
 * Package location for Model concept tests.
 */
package lapr.project.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the conflict type class.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ConflictTypeTest {

    /**
     * The conflict type to be tested.
     */
    private ConflictType conflictType;

    /**
     * The conflict detection mechanism.
     */
    private ConflictDetectionMechanism conflictDetetionMechanism;

    @Before
    public void setUp() {
        this.conflictDetetionMechanism = new ConflictDetectionMechanism() {

            @Override
            public boolean detectConflict(StaffMember staffMember, Application application) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public String getDescription() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        this.conflictType = new ConflictType(conflictDetetionMechanism, "Tosta");
    }

    /**
     * Test of validate method, of class ConflictType.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        assertTrue(this.conflictType.validate());
    }

    /**
     * Test of equals method, of class ConflictType.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object otherObject = new ConflictType(conflictDetetionMechanism, "Tosta");
        assertTrue(this.conflictType.equals(otherObject));
    }

}
