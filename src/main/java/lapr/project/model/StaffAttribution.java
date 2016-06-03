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
//     * Constructor of a staffAttribution class.
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
//     * Constructor that receives an instance of this class as parameter.
//     * 
//     * @param application StaffAttribution application
//     * @param staffMember StaffAttribution staffMember
//     */
//    public StaffAttribution(StaffAttribution staffAttribution){
//        this.application = new Application(staffAttribution.application);
//        this.staffMember = new StaffMember(staffAttribution.staffMember);
//    }
//    
//    /**
//     * Obtain the staffAttribution's application.
//     * 
//     * @return staffAttribution application
//     */
//    public Application getApplication(){
//        return this.application;
//    }
//    
//    /**
//     * Set the staffApplication's application.
//     * 
//     * @param application the staffAttribution application to set
//     */
//    public void setApplication(Application application){
//        this.application = application();
//    }
//    
//    /**
//     * Obtain the staffAttribution's staffMember.
//     * 
//     * @return staffAttribution staffMember
//     */
//    public StaffMember getStaffMember(){
//        return this.staffMember;
//    }
//    
//    /**
//     * Set the staffApplication's staffMember.
//     * 
//     * @param staffMember the staffAttribution staffMember to set
//     */
//    public void setStaffMember(StaffMember staffMember){
//        this.staffMember = staffMember;
//    }
//    
//    /**
//     * Return the textual representation of a StaffAttribution.
//     * 
//     * @return the textual representation of a StaffAttribution
//     */
//    @Override
//    public String toString(){
//        return String.format("StaffAttribution{%napplication=%s%nstaffMember=%s%n}", this.application, this.staffMember);
//    }
//    
//    
//}
