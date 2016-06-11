/**
 * Package location for Apllication Controllers tests.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitionsRegister;
import lapr.project.model.Organizer;
import lapr.project.model.StaffAttributionsList;
import lapr.project.model.User;
import org.junit.Before;

/**
 * Tests a assigned application controller class.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class AssignApplicationControllerTest {

    AssignApplicationController controller;
    Organizer organizer;
    ExhibitionCenter exhibitionCenter;

    StaffAttributionsList staffAttributionList;

    @Before
    public void setUp() {
        exhibitionCenter = new ExhibitionCenter();

        Exhibition e1 = new Exhibition();
        List<Exhibition> le = new ArrayList<>();
        le.add(e1);
        ExhibitionsRegister er = new ExhibitionsRegister(le);
        exhibitionCenter.setExhibitionsRegister(er);

        // TODO : Instanciador por defeito
        organizer = new Organizer(new User("Eric", "username2", "email2", "password"));
        this.controller = new AssignApplicationController(exhibitionCenter, organizer);
    }

}
