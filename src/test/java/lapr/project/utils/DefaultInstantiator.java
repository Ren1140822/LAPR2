/**
 * Package location for Pure Fabrication util classes tests.
 */
package lapr.project.utils;

import java.util.Date;
import lapr.project.model.*;

/**
 * Util class to create instances to tests.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class DefaultInstantiator {

    public static ExhibitionCenter createExhibitionCenter() {

        User userIvo = new User("Ivo Ferro", "ivoferro", "1151159@isep.ipp.pt", "123+Qwe");
        User userDaniel = new User("Daniel Gonçalves", "danielgoncalves", "1151452@isep.ipp.pt", "Qwe+123");
        User userEric = new User("Eric Amaral", "ericamaral", "1141570@isep.ipp.pt", "234+Wer");
        User userRenato = new User("Renato Oliveira", "renatooliveira", "1140822@isep.ipp.pt", "Wer+234");
        User userRicardo = new User("Ricardo Correia", "ricardocorreia", "1151231", "123-Asd");

        ExhibitionsManager exhibitionsManager = new ExhibitionsManager(userDaniel);

        Organizer organizerIvo = new Organizer(userIvo);
        Organizer organizerEric = new Organizer(userEric);
        Organizer organizerRenato = new Organizer(userRenato);
        Organizer organizerRicardo = new Organizer(userRicardo);
        
        StaffMember staffMemberIvo = new StaffMember(userIvo);
        StaffMember staffMemberEric = new StaffMember(userEric);
        StaffMember staffMemberRenato = new StaffMember(userRenato);
        StaffMember staffMemberRicardo = new StaffMember(userRicardo);
        
        Exhibitor exhibitorSonae = new Exhibitor("Sonae", "trades@sonae.com", "912345678");
        Exhibitor exhibitorBlip = new Exhibitor("Blip", "marketing@blip.pt", "918765432");
        Exhibitor exhibitorCritical = new Exhibitor("Critical Software", "main@critical.software.com", "931245678");
        
//        Exhibition exhibitionComputerScience = new Exhibition("Computer Science", "Conferences about computer science.", 
//                new Date(2015, 7, 23), new Date(2015, 8, 11), new Date(2015, 6, 15),
//                new Date(2015, 7, 5), new Date(2015, 7, 8), new Date(2015, 7, 15), 
//                new Place("H301"), staffList, organizersList,
//                applicationList, demonstrationsList, staffAttributionsList);

        ExhibitionCenter exhibitionCenter = new ExhibitionCenter();
        return exhibitionCenter;
    }
}
