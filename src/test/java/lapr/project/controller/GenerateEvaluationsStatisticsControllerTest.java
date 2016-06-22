/**
 * Package location for Apllication Controllers tests.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;
import lapr.project.model.Actor;
import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitionsManager;
import lapr.project.utils.DefaultInstantiator;
import static org.junit.Assert.assertEquals;
import org.junit.Before;

/**
 * Tests the classe generate evaluations statistics.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class GenerateEvaluationsStatisticsControllerTest {
    
    /**
     * The generate evaluations statistics controller to be tested
     */
    private GenerateEvaluationsStatisticsController generateEvaluationsStatisticsController;
    
    /**
     * The exhibition center to be used in tests.
     */
    private ExhibitionCenter exhibitionCenter;
    
    /**
     * The actor logged in.
     */
    private Actor actor;
    
    @Before
    public void setUp() {
        this.exhibitionCenter = DefaultInstantiator.createExhibitionCenter();
        this.actor = new ExhibitionsManager();
    }
    
    /**
     * Test of getAcceptanceRate method, of class GenerateEvaluationsStatisticsController.
     */
    // TODO
    //@Test
    public void testGetAcceptanceRate() {
        System.out.println("getAcceptanceRate");
        
        List<Pair<Exhibition, Float>> expResult = new ArrayList<>();
        expResult.add(new Pair<>(this.exhibitionCenter.getExhibitionsRegister().getExhibitionsList().get(0), 50f));
        List<Pair<Exhibition, Float>> result = this.generateEvaluationsStatisticsController.getAcceptanceRate();
        assertEquals(expResult, result);
    }
    
}
