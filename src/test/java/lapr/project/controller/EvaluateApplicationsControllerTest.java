/**
 * Package location for Apllication Controllers tests.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitionsRegister;
import lapr.project.model.StaffList;
import lapr.project.model.StaffMember;
import lapr.project.model.Submittable;
import lapr.project.model.User;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests a evaluate application controller class.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class EvaluateApplicationsControllerTest {

    /**
     * The exhibition center to be used in tests.
     */
    private ExhibitionCenter exhibitionCenter;

    /**
     * The evaluate applications controller to be tested.
     */
    private EvaluateApplicationsController evaluateApplicationsController;

    @Before
    public void setUp() {
        this.exhibitionCenter = new ExhibitionCenter();

        StaffMember staffMember1 = new StaffMember(new User("Ivo Ferro", "ivoferro", "ivoferro@isep.pt", "123+qwe", new ArrayList<>(),""));
        StaffMember staffMember2 = new StaffMember(new User("Daniel Gonçalves", "daniel", "daniel@isep.pt", "qwe+123", new ArrayList<>(),""));

        List<StaffMember> staffMembers = new ArrayList<>();
        staffMembers.add(staffMember1);
        staffMembers.add(staffMember2);
        StaffList staffList = new StaffList(staffMembers);

        Exhibition exhibition1 = new Exhibition();
        exhibition1.setStaffList(staffList);

        Exhibition exhibition2 = new Exhibition();

        List<Exhibition> exhibitions = new ArrayList<>();
        exhibitions.add(exhibition1);
        exhibitions.add(exhibition2);

        ExhibitionsRegister exhibitionsRegister = new ExhibitionsRegister(exhibitions);

        this.exhibitionCenter.setExhibitionsRegister(exhibitionsRegister);

        this.evaluateApplicationsController = new EvaluateApplicationsController(exhibitionCenter);
    }

    /**
     * Test of getSubmittablesByStaff method, of class
     * EvaluateApplicationsController.
     */
    @Test
    public void testGetSubmittablesByStaff() {
        System.out.println("getSubmittablesByStaff");

        StaffMember staffMember1 = new StaffMember(new User("Ivo Ferro", "ivoferro", "ivoferro@isep.pt", "123+qwe", new ArrayList<>(),""));
        StaffMember staffMember2 = new StaffMember(new User("Daniel Gonçalves", "daniel", "daniel@isep.pt", "qwe+123", new ArrayList<>(),""));

        List<StaffMember> staffMembers = new ArrayList<>();
        staffMembers.add(staffMember1);
        staffMembers.add(staffMember2);
        StaffList staffList = new StaffList(staffMembers);

        Exhibition exhibition = new Exhibition();
        exhibition.setStaffList(staffList);

        List<Submittable> expResult = new ArrayList<>();
        expResult.add(exhibition);

        List<Submittable> result = evaluateApplicationsController.getSubmittablesByStaff(staffMember1);

        assertEquals(expResult, result);
    }

}
