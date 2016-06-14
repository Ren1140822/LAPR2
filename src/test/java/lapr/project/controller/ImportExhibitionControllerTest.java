/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitionsManager;
import lapr.project.utils.DefaultInstantiator;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class ImportExhibitionControllerTest {

    ImportExhibitionController controller;
    ExhibitionCenter exhibitionCenter;

    public ImportExhibitionControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        exhibitionCenter = DefaultInstantiator.createExhibitionCenter();
        ExhibitionsManager manager = new ExhibitionsManager();
        controller = new ImportExhibitionController(manager, exhibitionCenter);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getExhibitionsRegister method, of class
     * ImportExhibitionController.
     */
//    @Test
//    public void testGetExhibitionsRegister() {
//        System.out.println("getExhibitionsRegister");
//        ImportExhibitionController instance = controller;
//      
//       ExhibitionCenter exhibitionCenterTest = DefaultInstantiator.createExhibitionCenter();
//        assertEquals(instance.getExhibitionsRegister(), exhibitionCenterTest.getExhibitionsRegister());
//       
//    }
    /**
     * Test of readExhibitionFromFile method, of class
     * ImportExhibitionController.
     */
//    @Test
//    public void testReadExhibitionFromFile() {
//        System.out.println("readExhibitionFromFile");
//        String filePath = "D:\\exhibition.xml";
//        ImportExhibitionController instance = controller;
//        instance.getExhibitionsRegister();
//        Exhibition exhibition = instance.readExhibitionFromFile(filePath);
//        Exhibition expectedExhibition = new Exhibition();
//        assertEquals(exhibition, expectedExhibition);
//
//    }

    /**
     * Test of registerExhibition method, of class ImportExhibitionController.
     */
//    @Test
//    public void testRegisterExhibition() {
//        System.out.println("registerExhibition");
//        Exhibition exhibition = null;
//        ImportExhibitionController instance = null;
//        instance.registerExhibition(exhibition);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
