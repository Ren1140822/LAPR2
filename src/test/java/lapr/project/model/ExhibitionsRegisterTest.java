/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Daniel Goncalves <1151452@isep.ipp.pt>
 */
public class ExhibitionsRegisterTest {
    
    private ExhibitionsRegister exhibitionsRegister;
    
    public ExhibitionsRegisterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.exhibitionsRegister = new ExhibitionsRegister();
    }
    
    @After
    public void tearDown() {
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
    
}
