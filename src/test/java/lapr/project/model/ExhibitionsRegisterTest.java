/**
 * Package location for Model concept tests.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

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

    @Before
    public void setUp() {
        this.exhibitionsRegister = new ExhibitionsRegister();
    }

    /**
     * Test of newExhibition method, of class ExhibitionsRegister.
     */
    @Test
    public void testNewExhibition() {
        System.out.println("newExhibition");
        Exhibition expResult = new Exhibition();
        Exhibition result = exhibitionsRegister.newExhibition();
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

}
