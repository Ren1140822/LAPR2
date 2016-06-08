/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author IvoFerro
 */
public class EvaluationTest {
    
    /**
     * The instance to be tested.
     */
    private Evaluation instance;
    
    @Before
    public void setUp() {
        List<Integer> answers = new ArrayList<>();
        answers.add(5);
        answers.add(3);
        answers.add(4);
        answers.add(1);
        answers.add(3);
        instance = new Evaluation(answers, new StaffAttribution());
    }

    /**
     * Test of validate method, of class Evaluation.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        assertTrue(instance.validate());
    }
    
    /**
     * Test of validate method with an invalida instance.
     */
    @Test
    public void testValidateWithInvalidValue() {
        System.out.println("validate");
        List<Integer> answers = new ArrayList<>();
        answers.add(5);
        answers.add(3);
        answers.add(4);
        answers.add(1);
        Evaluation invalidInstance = new Evaluation(answers, new StaffAttribution());
        assertFalse(invalidInstance.validate());
    }
    
}
