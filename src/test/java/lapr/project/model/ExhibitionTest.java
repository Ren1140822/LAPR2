/**
 * Package location for Model concept tests.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.exhibition.ExhibitionDecidedApplicationsState;
import lapr.project.utils.DefaultInstantiator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests a exhibition class.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ExhibitionTest {

    /**
     * Instance of Exhibition.
     */
    private Exhibition exhibition;

    /**
     * Exhibition center used for tests
     */
    private ExhibitionCenter exhibitionCenter;

    @Before
    public void setUp() {
        this.exhibitionCenter = DefaultInstantiator.createExhibitionCenter();
        this.exhibition = this.exhibitionCenter.getExhibitionsRegister().getExhibitionsList().get(0);
    }

    /**
     * Test of validate method, of class Exhibition, returns false.
     */
    @Test
    public void testValidateFalse() {
        System.out.println("validate");
        Exhibition instance = new Exhibition();
        boolean result = instance.validate();
        assertFalse(result);
    }

    /**
     * Test of validate method, of class Exhibition, returns true.
     */
    @Test
    public void testValidateTrue() {
        System.out.println("validate");
        assertTrue(this.exhibition.validate());
    }

    /**
     * Test of isApplicationsDecided method, of class Exhibition.
     */
    @Test
    public void testIsApplicationsDecided() {
        System.out.println("isApplicationsDecided");
        this.exhibition.setState(new ExhibitionDecidedApplicationsState(this.exhibition));
        assertTrue(this.exhibition.isApplicationsDecided());
    }

    // TODO
    //@Test
    public void testGetAcceptanceRate() {
        System.out.println("getAcceptanceRate");

        List<Application> applications = new ArrayList<>();

        ExhibitionApplication application1 = new ExhibitionApplication();
        application1.setDecision(new Decision("Out of context.", false));
        applications.add(application1);

        ExhibitionApplication application2 = new ExhibitionApplication();
        application2.setDecision(new Decision("Interested.", true));
        applications.add(application2);

        ExhibitionApplication application3 = new ExhibitionApplication();
        application3.setDecision(new Decision("Out of context.", false));
        applications.add(application3);

        ExhibitionApplication application4 = new ExhibitionApplication();
        application4.setDecision(new Decision("Interested.", true));
        applications.add(application4);

        this.exhibition.setApplicationsList(new ApplicationsList(applications));

        float expResult = 50f;
        float result = this.exhibition.getAcceptanceRate();

        assertEquals(expResult, result, 0.0002);
    }

    @Test
    public void testGetApplicationsAnalysis() {
        System.out.println("getApplicationsAnalysis");
        List<ApplicationAnalysis> expResult = new ArrayList<>();
        expResult.add(new ApplicationAnalysis(this.exhibition.getApplicationsList().getApplicationsList().get(0)));
        List<ApplicationAnalysis> result = this.exhibition.getApplicationsAnalysis();
        assertEquals(expResult, result);
    }
}
