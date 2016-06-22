/**
 * Package location for Model concepts.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.Organizer;
import lapr.project.model.StaffMember;
import lapr.project.model.User;
import lapr.project.utils.DefaultInstantiator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the define staff controller.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class DefineStaffControllerTest {
    ExhibitionCenter exhibitionCenter;
    DefineStaffController controller;
    Exhibition exhibition;
    
    public DefineStaffControllerTest() {
    }
    
    @Before
    public void setUp() {
        exhibitionCenter = DefaultInstantiator.createExhibitionCenter();
        exhibition = exhibitionCenter.getExhibitionsRegister().getExhibitionsList().get(0);
        controller = new DefineStaffController(exhibition.getOrganizersList().getOrganizersList().get(0), exhibitionCenter);
    }

    @Test
    public void testNewStaffMember() {
        System.out.println("testNewStaffMember");
        //Arrange
        controller.setExhibition(exhibition);
        User user = exhibitionCenter.getUsersRegister().getUser("ricardocorreia");
        //Act
        boolean result = controller.newStaffMember(user);
        //Assert
        assertTrue(result);
    }
    
    @Test
    public void testAddStaffMember() {
        System.out.println("testAddStaffMember");
        //Arrange
        controller.setExhibition(exhibition);
        User user = exhibitionCenter.getUsersRegister().getUser("ricardocorreia");
        //Act
        controller.newStaffMember(user);
        controller.addStaffMember();
        //Assert
        assertTrue(exhibition.getStaffList().isStaffMember(user.getUsername()));
    }
    
}
