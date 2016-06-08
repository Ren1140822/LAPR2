/**
 * Package location for Test concepts.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitionsRegister;
import lapr.project.model.exhibition.ExhibitionClosedApplicationState;
import lapr.project.model.exhibition.ExhibitionOpenApplicationState;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Represents the ExhibitionApplicationController test class.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ExhibitionApplicationControllerTest {

    private ExhibitionApplicationController controller;
    private ExhibitionCenter exhibitionCenter;

    public ExhibitionApplicationControllerTest() {
        
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        
        this.exhibitionCenter = new ExhibitionCenter();
        this.controller = new ExhibitionApplicationController(exhibitionCenter);
        Exhibition exhibition1 = new Exhibition();
        exhibition1.setCurrentExhibitionState(new ExhibitionOpenApplicationState(exhibition1));
        Exhibition exhibition2 = new Exhibition();
        exhibition2.setCurrentExhibitionState(new ExhibitionClosedApplicationState(exhibition2));
        List<Exhibition> exhibitionList = new ArrayList<>();
        exhibitionList.add(exhibition1);
        exhibitionList.add(exhibition2);
        ExhibitionsRegister exhibitionRegister = new ExhibitionsRegister(exhibitionList);
        exhibitionCenter.setExhibitionsRegister(exhibitionRegister);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getExhibitionList method, of class
     * ExhibitionApplicationController.
     */
    @Test
    public void testGetExhibitionList() {
        System.out.println("getExhibitionList");
        List<Exhibition> expResult = new ArrayList<>();
        Exhibition exhibition1 = new Exhibition();
        exhibition1.setCurrentExhibitionState(new ExhibitionOpenApplicationState(exhibition1));
        expResult.add(exhibition1);
        
        List<Exhibition> result = this.controller.getExhibitionList();
        
        assertEquals(expResult, result);
    }

}