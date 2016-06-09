/**
 * Package location for Model concept tests.
 */
package lapr.project.model.exhibition;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lapr.project.model.Demonstration;
import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionState;
import lapr.project.model.Organizer;
import lapr.project.model.OrganizersList;
import lapr.project.model.Place;
import lapr.project.model.StaffAttributionsList;
import lapr.project.model.StaffList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests a CreateExhibitionController class.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ExhibitionInicialStateTest {

    private Exhibition exhibition;

    @Before
    public void setUp() {

        List<Organizer> organizerslist = new ArrayList<>();
        organizerslist.add(new Organizer());
        organizerslist.add(new Organizer());

        this.exhibition = new Exhibition("title", "description", new Date(2016, 0, 1),
                new Date(2016, 3, 1), new Date(2016, 0, 10), new Date(2016, 1, 1),
                new Date(2016, 1, 10), new Date(2016, 2, 1),
                new Place(), new StaffList(), new OrganizersList(organizerslist),
                new ArrayList<Demonstration>(), new StaffAttributionsList());
    }

    /**
     * Test of setCreated method, of class ExhibitionInicialState, returns
     * false.
     */
    @Test
    public void testSetCreatedReturnsFalse() {
        System.out.println("setCreated");
        Exhibition invalidExhibition = new Exhibition();
        ExhibitionInicialState instance = new ExhibitionInicialState(invalidExhibition);
        boolean result = instance.setCreated();
        assertFalse(result);
    }

    /**
     * Test of setCreated method, of class ExhibitionInicialState, returns true.
     */
    @Test
    public void testSetCreatedReturnsTrue() {
        System.out.println("setCreated");
        ExhibitionInicialState instance = new ExhibitionInicialState(this.exhibition);
        boolean result = instance.setCreated();
        assertTrue(result);
    }

    /**
     * Test of setCreated method, of class ExhibitionInicialState, changes state.
     */
    @Test
    public void testSetCreated() {
        System.out.println("setCreated");
        ExhibitionInicialState inicialState = new ExhibitionInicialState(this.exhibition);
        inicialState.setCreated();
        
        ExhibitionState result = this.exhibition.getState();
        assertTrue(result.isCreated());
    }
}
