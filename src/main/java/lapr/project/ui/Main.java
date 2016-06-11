package lapr.project.ui;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Demonstration;
import lapr.project.model.DemonstrationsList;
import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionApplication;
import lapr.project.model.StaffAttribution;
import lapr.project.model.StaffAttributionsList;

/**
 * @author Nuno Bettencourt <nmb@isep.ipp.pt> on 24/05/16.
 */
class Main {

	/**
	 * Private constructor to hide implicit public one.
	 */
	private Main(){

	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws Exception {

//		CalculatorExample calculatorExample = new CalculatorExample();
//		System.out.println(calculatorExample.sum(3, 5));
                                     Exhibition e = new Exhibition();
                                      
                                     ExhibitionApplication a = new ExhibitionApplication();
                                     List<ExhibitionApplication> listApp = new ArrayList();
                                     listApp.add(a);
                                  
                                     StaffAttributionsList staff = new StaffAttributionsList();
                                     StaffAttribution sf = new StaffAttribution();
                                     List<StaffAttribution> lstStaff = new ArrayList();
                                     lstStaff.add(sf);
                                      staff.setStaffAttributionsList(lstStaff);
                                     e.setStaffAttributionsList(staff);
                                     Demonstration b = new Demonstration();
                                     b.setStaffAttributionsList(staff);
                                     List<Demonstration> listDemos = new ArrayList();
                                     listDemos.add(b);
                                     DemonstrationsList demoList = new DemonstrationsList(listDemos);
                                     e.setDemonstrationsList(demoList);
                                     e.xmlexp();
                                    //ureg.xmlexp();
                               
	}

}
