/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author IvoFerro
 */
public class StaffAttributionTest {

    private StaffAttribution staffAttribution;

    @Before
    public void setUp() {
        this.staffAttribution = new StaffAttribution();
    }

    /**
     * Test of isStaffMember method, of class StaffAttribution.
     */
    @Test
    public void testIsStaffMember() {
        System.out.println("isStaffMember");
        StaffMember staffMember = new StaffMember();
        assertTrue(this.staffAttribution.isStaffMember(staffMember));
    }

    /**
     * Test of equals method, of class StaffAttribution.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object otherObject = new StaffAttribution();
        assertTrue(this.staffAttribution.equals(otherObject));
    }

}
