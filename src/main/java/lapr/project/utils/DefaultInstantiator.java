/**
 * Package location for Pure Fabrication util classes.
 */
package lapr.project.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

        // GENERAL
        
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
        
        User userBelmiro = new User("Belmiro Azevedo", "belmiroazevedo", "belmirazevedo@sonae.com", "321+Ewq");
        User userFabioSilva = new User("Fábio Silva", "fabiosilva", "fabiosilva@blip.pt", "Ewq+321");
        User userGoncaloQuadros = new User("Gonçalo Quadros", "gonacaloquadros", "goncaloquadros@critical.software.com", "432+Rew");
        
        ExhibitorResponsible exhibitorResponsibleSonae = new ExhibitorResponsible(userBelmiro);
        ExhibitorResponsible exhibitorResponsibleblip = new ExhibitorResponsible(userFabioSilva);
        ExhibitorResponsible exhibitorResponsibleCritical = new ExhibitorResponsible(userGoncaloQuadros);
        
        Product product1 = new Product("Projetor");
        Product product2 = new Product("Table");
        Product product3 = new Product("PC");
        Product product4 = new Product("Tale");
        Product product5 = new Product("MacBook");

        
        // Exhibition computer science
        
        List<Organizer> organizersComputerScience = new ArrayList<>();
        organizersComputerScience.add(organizerIvo);
        organizersComputerScience.add(organizerEric);
        OrganizersList organizersListComputerScience = new OrganizersList(organizersComputerScience);
        
        List<StaffMember> staffMembersComputerScience = new ArrayList<>();
        staffMembersComputerScience.add(staffMemberRenato);
        staffMembersComputerScience.add(staffMemberRicardo);
        StaffList staffListComputerScience = new StaffList(staffMembersComputerScience);
        
        Exhibition exhibitionComputerScience = new Exhibition("Computer Science", "Conferences about computer science.",
                new Date(2015, 7, 23), new Date(2015, 8, 11), new Date(2015, 6, 15),
                new Date(2015, 7, 5), new Date(2015, 7, 8), new Date(2015, 7, 15),
                new Place("H301"), staffListComputerScience, organizersListComputerScience,
                new ApplicationsList(), new DemonstrationsList(), new StaffAttributionsList());
        
        
        // Applications computer science
        
        List<Product> productListNodeJs = new ArrayList<>();
        productListNodeJs.add(product1);
        productListNodeJs.add(product2);
        
        ExhibitionApplication exhibitionApplicationNodeJs = new ExhibitionApplication("Node JS", exhibitorBlip, 105.3f, 
                30, productListNodeJs, new ArrayList<>(), 
                new ArrayList<>(), new ArrayList<>());
        
        
        // Applications computer science - Evaluations Node JS
        
        List<Integer> answerListNodeJs1 = new ArrayList<>();
        answerListNodeJs1.add(3);
        answerListNodeJs1.add(4);
        answerListNodeJs1.add(5);
        answerListNodeJs1.add(1);
        answerListNodeJs1.add(3);
        StaffAttribution staffAttributionNodeJs1 = new StaffAttribution(exhibitionApplicationNodeJs, staffMemberRenato);
        Evaluation evaluationNodeJs1 = new Evaluation(answerListNodeJs1, staffAttributionNodeJs1);
        
        List<Integer> answerListNodeJs2 = new ArrayList<>();
        answerListNodeJs2.add(2);
        answerListNodeJs2.add(3);
        answerListNodeJs2.add(4);
        answerListNodeJs2.add(2);
        answerListNodeJs2.add(2);
        StaffAttribution staffAttributionNodeJs2 = new StaffAttribution(exhibitionApplicationNodeJs, staffMemberRicardo);
        Evaluation evaluationNodeJs2 = new Evaluation(answerListNodeJs2, staffAttributionNodeJs2);
        
        List<Evaluation> evaluationsNodeJs = new ArrayList<>();
        evaluationsNodeJs.add(evaluationNodeJs1);
        evaluationsNodeJs.add(evaluationNodeJs2);

        exhibitionApplicationNodeJs.setEvaluationsList(evaluationsNodeJs);
        
        // Exhibition Center
        
        // TODO modify this
        ExhibitionCenter exhibitionCenter = new ExhibitionCenter();
        
        return exhibitionCenter;
    }
}
