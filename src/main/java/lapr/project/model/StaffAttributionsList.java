/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an staff attributions list
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class StaffAttributionsList {

    /**
     * the list of staff attributions instances
     */
    private List<StaffAttribution> staffAttributionsList;

    /**
     * empty constructor of this class
     */
    public StaffAttributionsList() {
        staffAttributionsList = new ArrayList<>();
    }

    /**
     * constructor receiving a list of staff attribution as param.
     * 
     * @param staffAttributionsList Staff Attributions List 
     */
    public StaffAttributionsList(List<StaffAttribution> staffAttributionsList) {
        this.staffAttributionsList = new ArrayList(staffAttributionsList);
    }

    /**
     * constructor receiving a instance of this class as param
     * 
     * @param staffAttributionsList StaffAttributionList to copy
     */
    public StaffAttributionsList(StaffAttributionsList staffAttributionsList) {
        this.staffAttributionsList = new ArrayList(staffAttributionsList.staffAttributionsList);
    }

    /**
     * Obtain the list of staff attributions.
     * 
     * @return the list of staff attributions
     */
    public List<StaffAttribution> getStaffAttributionsList() {
        return this.staffAttributionsList;
    }

    /**
     * sets the staff attributions list.
     * 
     * @param staffAttributionsList staff attributions list to set
     */
    public void setStaffAttributionsList(List<StaffAttribution> staffAttributionsList) {
        this.staffAttributionsList = new ArrayList<>(staffAttributionsList);
    }
    
    public List<StaffAttribution> getStaffAtributionsApplicationsInEvaluationByStaff(StaffMember staffMember){
        List<StaffAttribution> staffAtributionsApplicationsInEvaluationBystaff = new ArrayList<>();
        
        //TODO fulfill the list with some logic
        
        return staffAtributionsApplicationsInEvaluationBystaff;
    }

    /**
     * Return the textual representation of a staff attribution list.
     *
     * @return the textual representation of a staff attribution list
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("StaffAttributionsList{");
        for (StaffAttribution staffAttribution : staffAttributionsList) {
            s.append(String.format("%s%n", staffAttribution));
        }
        s.append("}");
        return s.toString();
    }

    /**
     * Compares two StaffAttributionsList objects.
     *
     * @param otherObject Object to compare
     * @return true if the objects are equals.
     */
    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        StaffAttributionsList otherStaffAttributionsList = (StaffAttributionsList) otherObject;

        return this.staffAttributionsList.equals(otherStaffAttributionsList.staffAttributionsList);
    }
}
