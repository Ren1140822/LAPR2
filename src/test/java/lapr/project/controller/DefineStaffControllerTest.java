/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.Organizer;
import lapr.project.model.StaffMember;
import lapr.project.model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ricardo
 */
public class DefineStaffControllerTest {
    ExhibitionCenter exhibitionCenter;
    DefineStaffController controller;
     Organizer organizer = new Organizer();
    public DefineStaffControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        exhibitionCenter= new ExhibitionCenter();
        controller= new DefineStaffController(organizer,exhibitionCenter);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getExhibitionList method, of class DefineStaffController.
     */
//    @Test
//    public void testGetExhibitionList() {
//        System.out.println("getExhibitionList");
//        List<Exhibition> listExpected= new ArrayList();
//        Exhibition ex = new Exhibition();
//         List<Organizer> listOrg = new ArrayList();
//         listOrg.add(organizer);
//        ex.getOrganizersList().setOrganizersList(listOrg);
//        
//        listExpected.add(new Exhibition());
//        DefineStaffController instance = controller;
//        
//        List<Exhibition> expResult = null;
//        List<Exhibition> result = instance.getExhibitionList(organizer);
//        assertEquals(expResult, result);
//   
//    }

    /**
     * Test of getUserList method, of class DefineStaffController.
     */
//    @Test
//    public void testGetUserList() {
//        System.out.println("getUserList");
//        DefineStaffController instance = null;
//        List<User> expResult = null;
//        List<User> result = instance.getUserList();
//        assertEquals(expResult, result);
//   
//    }

    /**
     * Test of newStaffMember method, of class DefineStaffController.
     */
//    @Test
//    public void testNewStaffMember() {
//        System.out.println("newStaffMember");
//        User user = new User();
//        DefineStaffController instance = controller;
//       
//        Exhibition ex = new Exhibition();
//        controller.setExhibition(ex);
//        StaffMember staffMember= new StaffMember(user);
//        assertEquals(staffMember, instance.newStaffMember(user));
//    }

    /**
     * Test of setExhibition method, of class DefineStaffController.
     */
//    @Test
//    public void testSetExhibition() {
//        System.out.println("setExhibition");
//        Exhibition exhibition = null;
//        DefineStaffController instance = null;
//        instance.setExhibition(exhibition);
//    
//    }

    /**
     * Test of addStaffMember method, of class DefineStaffController.
     */
//    @Test
//    public void testAddStaffMember() {
//        System.out.println("addStaffMember");
//        DefineStaffController instance = null;
//        instance.addStaffMember();
//    
//    }

    /**
     * Test of setDefinedStaffMember method, of class DefineStaffController.
     */
//    @Test
//    public void testSetDefinedStaffMember() {
//        System.out.println("setDefinedStaffMember");
//        Exhibition exhibition = null;
//        DefineStaffController instance = null;
//        boolean expResult = false;
//        boolean result = instance.setDefinedStaffMember(exhibition);
//        assertEquals(expResult, result);
//      
//    }
    
}
