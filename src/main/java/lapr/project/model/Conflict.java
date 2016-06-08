/**
 * Package location for Model concepts.
 */
package lapr.project.model;

/**
 * Represents a conflict.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class Conflict {

    /**
     * The type of the conflict.
     */
    private ConflictType conflictType;

    /**
     * The staff member which conflicts with.
     */
    private StaffMember staffMember;

    /**
     * Where the conflict occurs.
     */
    private Conflictable conflictable;

    /**
     * Constructs a conflict with its default values.
     */
    public Conflict() {
        this.conflictType = new ConflictType();
        this.staffMember = new StaffMember();
        // TODO when a concrete conflictable is created, assign to conflictable default value in this constructor.
        //this.conflictable = new ExhibitionApplication();
    }

    /**
     * Constructs a conflict receiving a conflict type, a staff member and a
     * conflictable.
     *
     * @param conflictType conflict type
     * @param staffMember staff member
     * @param conflictable conflictable
     */
    public Conflict(ConflictType conflictType, StaffMember staffMember, Conflictable conflictable) {
        this.conflictType = new ConflictType(conflictType);
        this.staffMember = new StaffMember(staffMember);
        this.conflictable = conflictable;
    }

    /**
     * Constructs a conflict copying another conflict.
     *
     * @param conflict another conflict
     */
    public Conflict(Conflict conflict) {
        this.conflictType = new ConflictType(conflict.conflictType);
        this.conflictable = conflict.conflictable;
    }

    /**
     * Gets the conflict type.
     *
     * @return conflict type
     */
    public ConflictType getConflictType() {
        return new ConflictType(conflictType);
    }

    /**
     * Sets the conflict type.
     *
     * @param conflictType conflictType
     */
    public void setConflictType(ConflictType conflictType) {
        this.conflictType = new ConflictType(conflictType);
    }

    /**
     * Gets the staff member.
     *
     * @return staff member
     */
    public StaffMember getStaffMember() {
        return new StaffMember(staffMember);
    }

    /**
     * Sets the staff member.
     *
     * @param staffMember staff member
     */
    public void setStaffMember(StaffMember staffMember) {
        this.staffMember = new StaffMember(staffMember);
    }

    /**
     * Gets the conflictable.
     *
     * @return conflictable
     */
    public Conflictable getConflictable() {
        return conflictable;
    }

    /**
     * Sets the conflictable.
     *
     * @param conflictable conflictable
     */
    public void setConflictable(Conflictable conflictable) {
        this.conflictable = conflictable;
    }

    /**
     * Returns a textual representation for the conflict.
     *
     * @return textual representation for the conflict
     */
    @Override
    public String toString() {
        return String.format("Conflict{conflictType=%s;conflictable=%s}", this.conflictType, this.conflictable);
    }

    /**
     * Compares if this object is equal to otherObject.
     *
     * @param otherObject other object to compare with
     * @return true if it repreents the same object, false otherwise
     */
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || this.getClass() != otherObject.getClass()) {
            return false;
        }
        Conflict otherConflict = (Conflict) otherObject;

        return this.conflictType.equals(otherConflict.conflictType) && this.staffMember.equals(otherConflict.staffMember) && this.conflictable.equals(otherConflict.conflictable);
    }

}
