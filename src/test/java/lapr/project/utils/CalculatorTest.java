/**
 * Package location for Pure Fabrication util classes tests.
 */
package lapr.project.utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the classe Calculator.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class CalculatorTest {
    
    @Before
    public void setUp() {
    }

    /**
     * Test of calculateVectorAverage method, of class Calculator.
     */
    @Test
    public void testCalculateVectorAverage() {
        System.out.println("calculateVectorAverage");
        Float[] vector = {2.50f, 2.20f, null, 3.30f};
        float expResult = 2.67f;
        float result = Calculator.calculateVectorAverage(vector);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of calculateMatrixAverage method, of class Calculator.
     */
    @Test
    public void testCalculateMatrixAverage() {
        System.out.println("calculateMatrixAverage");
        Float[][] matrix = {    {2.50f, 2.20f, null, 3.30f},
                                {3.50f, 2.20f, null, 5.30f},
                                {2.50f, 3.20f, null, 3.30f}
                                                            };
        float expResult = 3.11f;
        float result = Calculator.calculateMatrixAverage(matrix);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of calculateDeviation method, of class Calculator.
     */
    @Test
    public void testCalculateDeviation() {
        System.out.println("calculateDeviation");
        float value = 30.80f;
        float average = 35.40f;
        float expResult = 4.60f;
        float result = Calculator.calculateDeviation(value, average);
        assertEquals(expResult, result, 0.01);
    }
    
}
