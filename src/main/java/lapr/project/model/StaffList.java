/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a staff list.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class StaffList {

    /**
     * List of staff users.
     */
    private List<StaffMember> staffList;

    /**
     * Creates an instance of StaffList with its default values.
     */
    public StaffList() {
        staffList = new ArrayList<>();
    }

    /**
     * Creates an instance of StaffList receiving the list of staff users.
     *
     * @param staffList list of staff users
     */
    public StaffList(List<StaffMember> staffList) {
        this.staffList = new ArrayList<>(staffList);
    }

    /**
     * Creates an instance of StaffList copying another staff list.
     *
     * @param staffList another staff list
     */
    public StaffList(StaffList staffList) {
        this.staffList = new ArrayList<>(staffList.staffList);
    }

    /**
     * Gets the list of staff.
     *
     * @return list of staff
     */
    public List<StaffMember> getStaffList() {
        return new ArrayList<>(staffList);
    }

    /**
     * Sets the list of staff.
     *
     * @param staffList list of staff
     */
    public void setStaffList(List<StaffMember> staffList) {
        this.staffList = new ArrayList<>(staffList);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("StaffList{");
        for (StaffMember staffMember : staffList) {
            s.append(String.format("%s%n", staffMember));
        }
        s.append("}");
        return s.toString();
    }

    /**
     * Compares two StaffList objects.
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
        StaffList otherStaffList = (StaffList) otherObject;

        return this.staffList.equals(otherStaffList.staffList);
    }

}
