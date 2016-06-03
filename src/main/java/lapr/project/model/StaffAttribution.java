///**
// * Package location for Model concepts.
// */
//package lapr.project.model;
//
///**
// * Represents a staff attribution.
// * 
// * @author Ricardo Correia 1151231
// */
//public class StaffAttribution {
//    
//    /**
//     * The staffAttribution's application.
//     */
//    private Application application;
//            
//    /**
//     * The staffAttribution's staffMember.
//     */
//    private StaffMember staffMember;
//    
//    /**
//     * Default constructor of a staffAttribution class.
//     */
//    public StaffAttribution(){
//        this.application = new Application();
//        this.staffMember = new StaffMember();
//    }
//    
//    /**
//     * Constructor of a staffApplication class.
//     * 
//     * @param application staffAttribution's application
//     * @param staffMember staffAttribution's staffMember
//     */
//    public StaffAttribution(Application application, StaffMember staffMember){
//        this.application = new Application(application);
//        this.staffMember = new StaffMember(staffMember);
//    }
//    
//    /**
//     * 
//     */
//    public StaffAttribution(StaffAttribution staffAttribution){
//        this.application = new Application(staffAttribution.application);
//        this.staffMember = new StaffMember(staffAttribution.staffMember);
//    }
//}
