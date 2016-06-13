package lapr.project.ui;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionCenter;
import lapr.project.utils.DefaultInstantiator;

/**
 * @author Nuno Bettencourt <nmb@isep.ipp.pt> on 24/05/16.
 */
class Main {

    /**
     * Private constructor to hide implicit public one.
     */
    private Main() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

//		CalculatorExample calculatorExample = new CalculatorExample();
//		System.out.println(calculatorExample.sum(3, 5));
//                                     Exhibition e = new Exhibition();
//                                      
//                                     ExhibitionApplication a = new ExhibitionApplication();
//                                     List<ExhibitionApplication> listApp = new ArrayList();
//                                     listApp.add(a);
//                                  
//                                     StaffAttributionsList staff = new StaffAttributionsList();
//                                     StaffAttribution sf = new StaffAttribution();
//                                     List<StaffAttribution> lstStaff = new ArrayList();
//                                     lstStaff.add(sf);
//                                      staff.setStaffAttributionsList(lstStaff);
//                                     e.setStaffAttributionsList(staff);
//                                     Demonstration b = new Demonstration();
//                                     b.setStaffAttributionsList(staff);
//                                     List<Demonstration> listDemos = new ArrayList();
//                                     listDemos.add(b);
//                                     DemonstrationsList demoList = new DemonstrationsList(listDemos);
//                                     e.setDemonstrationsList(demoList);
//                                     e.xmlexp();
        //ureg.xmlexp();
        ExhibitionCenter exhibitionCenter = DefaultInstantiator.createExhibitionCenter();

        Exhibition exhibitionTest = exhibitionCenter.getExhibitionsRegister().getExhibitionsList().get(0);
        
        
        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(Exhibition.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to System.out
        File xmlFile = new File("exhibition.xml");

        m.marshal(exhibitionTest, System.out);

        m.marshal(exhibitionTest, xmlFile);

        JAXBContext jaxbContext = JAXBContext.newInstance(Exhibition.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        Exhibition exhibition = (Exhibition) jaxbUnmarshaller.unmarshal(xmlFile);

        System.out.println(exhibition.equals(exhibitionTest));
    }

}
