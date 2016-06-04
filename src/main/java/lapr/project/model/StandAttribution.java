///**
// * Package location for Model concepts.
// */
//package lapr.project.model;
//
///**
// * Represents a Stand Attribution.
// * 
// * @author Daniel Gonçalves 1151452
// * @author Eric Amaral 1141570
// * @author Ivo Ferro 1151159
// * @author Renato Oliveira 1140822
// * @author Ricardo Correia 1151231
// */
//public class StandAttribution {
//    /**
//     * The standAttribution's stand.
//     */
//    private Stand stand;
//            
//    /**
//     * The standAttribution's staffMember.
//     */
//    private StaffMember staffMember;
//    
//    /**
//     * Default constructor of a standAttribution class.
//     */
//    public StandAttribution(){
//        this.stand = new Stand();
//        this.staffMember = new StaffMember();
//    }
//    
//    /**
//     * Constructor of a standAttribution class.
//     * 
//     * @param stand standAttribution's stand
//     * @param staffMember standAttribution's staffMember
//     */
//    public StandAttribution(Stand stand, StaffMember staffMember){
//        this.stand = new Stand(stand);
//        this.staffMember = new StaffMember(staffMember);
//    }
//    
//    /**
//     * Constructor that receives an instance of this class as parameter.
//     * 
//     * @param stand StandAttribution stand
//     * @param staffMember StandAttribution staffMember
//     */
//    public StandAttribution(StandAttribution standAttribution){
//        this.stand = new Stand(standAttribution.stand);
//        this.staffMember = new StaffMember(standAttribution.staffMember);
//    }
//    
//    /**
//     * Obtain the standAttribution's stand.
//     * 
//     * @return standAttribution stand
//     */
//    public Stand getStand(){
//        return this.stand;
//    }
//    
//    /**
//     * Set the staffApplication's stand.
//     * 
//     * @param stand the standAttribution stand to set
//     */
//    public void setStand(Stand stand){
//        this.stand = stand();
//    }
//    
//    /**
//     * Obtain the standAttribution's staffMember.
//     * 
//     * @return standAttribution staffMember
//     */
//    public StaffMember getStaffMember(){
//        return this.staffMember;
//    }
//    
//    /**
//     * Set the staffApplication's staffMember.
//     * 
//     * @param staffMember the standAttribution staffMember to set
//     */
//    public void setStaffMember(StaffMember staffMember){
//        this.staffMember = staffMember;
//    }
//    
//    /**
//     * Return the textual representation of a StandAttribution.
//     * 
//     * @return the textual representation of a StandAttribution
//     */
//    @Override
//    public String toString(){
//        return String.format("StandAttribution{%nstand=%s%nstaffMember=%s%n}", this.stand, this.staffMember);
//    }
//    
//    
//}
//
