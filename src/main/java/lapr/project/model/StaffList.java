/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Represents a staff list.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class StaffList {

    /**
     * List of staff users.
     */
    @XmlElementWrapper(name = "staff_list")
    @XmlElement(name = "staff_member")
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

    /**
     * Creates a new instance of staff member.
     *
     * @return staffMember staff member
     */
    public StaffMember newStaffMember(User user) {
        StaffMember staffMember = new StaffMember();
        staffMember.setUser(user);
        staffMember.validate();
        return staffMember;
    }

    /**
     * Verify if a given staff member is on the staff member's list.
     *
     * @param staffMember staff member to be verified
     * @return true if it is contained, false otherwise
     */
    public boolean isStaffMember(StaffMember staffMember) {
        return this.staffList.contains(staffMember);
    }

    /**
     * Adds a staff member.
     *
     * @staffMember
     */
    public boolean addStaffMember(StaffMember staffMember) {
        return validadeStaffMember(staffMember);
    }

    /**
     * Validates a staff member.
     *
     * @return true if the staff list does not contain the staff member
     */
    public boolean validadeStaffMember(StaffMember staffMember) {
        if (!this.staffList.contains(staffMember)) {
            this.staffList.add(staffMember);
            return true;
        }
        return false;
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
