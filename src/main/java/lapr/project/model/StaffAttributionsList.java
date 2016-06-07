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
     * the list of staff instances
     */
    private List<StaffMember> staffList;

    /**
     * empty constructor of this class
     */
    public StaffAttributionsList() {
        staffList = new ArrayList<>();
    }

    /**
     * constructor receiving a list of staff as param
     */
    public StaffAttributionsList(List<StaffMember> staffList) {
        this.staffList = new ArrayList(staffList);
    }

    /**
     * constructor receiving a instance of this class as param
     */
    public StaffAttributionsList(StaffAttributionsList staffAtt) {
        this.staffList = new ArrayList(staffAtt.staffList);
    }

    /**
     *
     * @return the list of staff of this instance
     */
    public List<StaffMember> getStaffList() {
        return this.staffList;
    }

    /**
     * sets the staff list
     */
    public void setStaffList(List<StaffMember> staffList) {
        this.staffList = new ArrayList<>(staffList);
    }

    /**
     * Returns the textual representation of the attributes of this class.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("StaffAttributionsList{");
        for (StaffMember staffMember : staffList) {
            s.append(String.format("%s%n", staffMember));
        }
        s.append("}");
        return s.toString();
    }
}
