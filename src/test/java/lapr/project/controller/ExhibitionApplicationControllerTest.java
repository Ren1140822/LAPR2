/**
 * Package location for Test concepts.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Demonstration;
import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionApplication;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitionsRegister;
import lapr.project.model.Exhibitor;
import lapr.project.model.KeyWord;
import lapr.project.model.Product;
import lapr.project.model.exhibition.ExhibitionClosedApplicationsState;
import lapr.project.model.exhibition.ExhibitionOpenApplicationsState;
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
        exhibition1.setState(new ExhibitionOpenApplicationsState(exhibition1));
        Exhibition exhibition2 = new Exhibition();
        exhibition2.setState(new ExhibitionClosedApplicationsState(exhibition2));
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
     * Test of getExhibitionsList method, of class
     * ExhibitionApplicationController.
     */
    @Test
    public void testGetExhibitionList() {
        System.out.println("getExhibitionList");
        List<Exhibition> expResult = new ArrayList<>();
        Exhibition exhibition1 = new Exhibition();
        exhibition1.setState(new ExhibitionOpenApplicationsState(exhibition1));
        expResult.add(exhibition1);

        List<Exhibition> result = this.controller.getExhibitionList();

        assertEquals(expResult, result);
    }

    /**
     * Test of newApplication method, of class ExhibitionApplicationController.
     */
    @Test
    public void testNewApplication() {
        System.out.println("newApplication");
        Exhibition exhibition = new Exhibition();
        ExhibitionApplicationController instance = controller;
        instance.newApplication(exhibition);
        ExhibitionApplication defaultExhibition = new ExhibitionApplication();
        assertEquals(instance.getExhibitionApplication(), defaultExhibition);
    }

    /**
     * Test of setData method, of class ExhibitionApplicationController.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        String companyName = "Test";
        String companyAddress = "Test";
        String companyCellphone = "Test";
        float exhibitorArea = 0.0F;
        int numberInvitations = 0;
        ExhibitionApplicationController instance = controller;
        Exhibition exhibition = new Exhibition();
        instance.newApplication(exhibition);
        instance.setData(companyName, companyAddress, companyCellphone, exhibitorArea, numberInvitations);
        ExhibitionApplication defaultExhibitionApplication = new ExhibitionApplication();
        defaultExhibitionApplication.setExhibitorArea(exhibitorArea);
        defaultExhibitionApplication.setNumberInvitations(numberInvitations);
        defaultExhibitionApplication.setExhibitor(new Exhibitor(companyName, companyAddress, companyCellphone));
        assertEquals(instance.getExhibitionApplication(), defaultExhibitionApplication);
    }

    /**
     * Test of newProduct method, of class ExhibitionApplicationController.
     */
    @Test
    public void testNewProduct() {
        System.out.println("newProduct");
        String designation = "test";
        ExhibitionApplicationController instance = controller;
        Exhibition exhibition = new Exhibition();
        instance.newApplication(exhibition);
        instance.newProduct(designation);
        Product result = instance.getExhibitionApplication().getProductList().get(0);
        Product productExpected = new Product(designation);
        assertEquals(result, productExpected);

    }

    /**
     * Test of newDemonstrationApplication method, of class
     * ExhibitionApplicationController.
     */
    @Test
    public void testNewDemonstrationApplication() {
        System.out.println("newDemonstrationApplication");
        Demonstration demonstration = new Demonstration();
        ExhibitionApplicationController instance = controller;
        Exhibition exhibition = new Exhibition();
        instance.newApplication(exhibition);
        instance.newDemonstrationApplication(demonstration);
        Demonstration instanceDemonstration = instance.getExhibitionApplication().getDemonstrationsList().get(0);
        instance.getExhibitionApplication().getDemonstrationsList().add(new Demonstration(demonstration));
        assertEquals(instanceDemonstration, instance.getExhibitionApplication().getDemonstrationsList().get(1));

    }

    /**
     * Test of newKeyword method, of class ExhibitionApplicationController.
     */
    @Test
    public void testNewKeyword() {
        System.out.println("newKeyword");
        String description = "Test";
        ExhibitionApplicationController instance = controller;
        Exhibition exhibition = new Exhibition();
        instance.newApplication(exhibition);
        instance.newKeyword(description);
        KeyWord keyword = new KeyWord(description);
        assertEquals(instance.getExhibitionApplication().getKeyWordList().get(0), keyword);
    }

    /**
     * Test of validateExhibitionApplication method, of class
     * ExhibitionApplicationController.
     */
    @Test
    public void testValidateExhibitionApplication() {
        System.out.println("validateExhibitionApplication");
        ExhibitionApplicationController instance = controller;
        Exhibition exhibition = new Exhibition();
        instance.newApplication(exhibition);
        String companyName = "Test";
        String companyAddress = "Test";
        String companyCellphone = "Test";
        float exhibitorArea = 0.0F;
        int numberInvitations = 0;
        instance.setData(companyName, companyAddress, companyCellphone, exhibitorArea, numberInvitations);
        instance.newApplication(exhibition);
        instance.newKeyword("test");
        instance.newKeyword("test2");
     
        boolean result = instance.validateExhibitionApplication();
        assertTrue(result);

    }
      /**
     * Test of validateExhibitionApplication method, of class
     * ExhibitionApplicationController.
     */
    @Test
    public void testValidateExhibitionApplication2() {
        System.out.println("validateExhibitionApplication");
        ExhibitionApplicationController instance = controller;
        Exhibition exhibition = new Exhibition();
        instance.newApplication(exhibition);
        String companyName = "Test";
        String companyAddress = "Test";
        String companyCellphone = "Test";
        float exhibitorArea = 0.0F;
        int numberInvitations = 0;
        instance.setData(companyName, companyAddress, companyCellphone, exhibitorArea, numberInvitations);
        instance.newApplication(exhibition);
        instance.newKeyword("test");
       //ONLY ONE KEYWORD
     
        boolean result = instance.validateExhibitionApplication();
        assertFalse(result);

    }

}
