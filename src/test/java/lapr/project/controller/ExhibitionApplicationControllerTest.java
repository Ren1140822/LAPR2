/**
 * Package location for Test concepts.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lapr.project.model.Demonstration;
import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.OrganizersList;
import lapr.project.model.Place;
import lapr.project.model.StaffAttributionsList;
import lapr.project.model.StaffList;
import lapr.project.model.exhibition.ExhibitionOpenApplicationState;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Represents the ExhibitionState.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ExhibitionApplicationControllerTest {

    private ExhibitionApplicationController exhibitionApplicationController;
    private ExhibitionCenter exhibitionCenter;
    private    Exhibition exhibition;

    public ExhibitionApplicationControllerTest() {
        this.exhibitionCenter = new ExhibitionCenter();
        this.exhibitionApplicationController = new ExhibitionApplicationController(exhibitionCenter);
        testGetExhibitionList();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Date startDate = new Date(2016, 5, 23);
        Date endDate = new Date(2016, 6, 23);
        Date subStartDate = new Date(2016, 5, 22);
        Date subEndDate = new Date(2016, 6, 22);
        Place place = new Place("PlaceTest");
        StaffList staffList = new StaffList();
        OrganizersList organizersList = new OrganizersList();
        List<Demonstration> demonstrationList = new ArrayList();
        StaffAttributionsList staffAttributionList = new StaffAttributionsList();
       exhibition = new Exhibition("TitleTest","DescriptionTest",startDate,endDate,subStartDate,subEndDate,place,staffList,organizersList,demonstrationList,staffAttributionList);
        exhibition.setCurrentExhibitionState(new ExhibitionOpenApplicationState(exhibition));
        exhibitionCenter.getExhibitionsRegister().getExhibitionList().add(exhibition);
         Exhibition exhibitionDifferentState = new Exhibition(exhibition);
         exhibitionDifferentState.setCurrentExhibitionState(null);
          exhibitionCenter.getExhibitionsRegister().getExhibitionList().add(exhibitionDifferentState);
        
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
        ExhibitionApplicationController instance = exhibitionApplicationController;
        List<Exhibition> expResult = new ArrayList<Exhibition>();
        expResult.add(new Exhibition(exhibition));//change the memory reference
        List<Exhibition> result = instance.getExhibitionList();
        assertArrayEquals(expResult.toArray(), result.toArray());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
