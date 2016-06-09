/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a organizers list.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class OrganizersList {

    /**
     * List of organizer users.
     */
    private List<Organizer> organizersList;

    /**
     * Creates an instance of OrganizersList with its default values.
     */
    public OrganizersList() {
        organizersList = new ArrayList<>();
    }

    /**
     * Creates an instance of OrganizersList receiving the list of organizers
     * users.
     *
     * @param organizersList list of organizers users
     */
    public OrganizersList(List<Organizer> organizersList) {
        this.organizersList = new ArrayList<>(organizersList);
    }

    /**
     * Creates an instance of OrganizersList copying another organizers list.
     *
     * @param organizersList another organizers list
     */
    public OrganizersList(OrganizersList organizersList) {
        this.organizersList = new ArrayList<>(organizersList.organizersList);
    }

    /**
     * Gets the list of organizers.
     *
     * @return list of organizers
     */
    public List<Organizer> getOrganizersList() {
        return new ArrayList<>(organizersList);
    }

    /**
     * Sets the list of organizers.
     *
     * @param organizersList list of organizers
     */
    public void setOrganizersList(List<Organizer> organizersList) {
        this.organizersList = new ArrayList<>(organizersList);
    }
    
    /**
     * Create a new organizer object.
     * 
     * @param user associated to the new organizer
     * @return a new organizer object
     */
    public Organizer newOrganizer(User user) {
        
        return new Organizer(user);
    }

    /**
     * Add & validate an organizer to the list.
     *
     * @param organizer the organizer to validate
     * @return true if the organizer is sucessfully added.
     */
    public boolean addAndValidateOrganizer(Organizer organizer) {

        return (organizer.validate() && validateOrganizer(organizer)) ? addOrganizer(organizer) : false;
    }

    /**
     * Validate if the list doesn't contain an organizer.
     *
     * @param organizer the organizer to validate
     * @return true if list doesn't contain the organizer
     */
    private boolean validateOrganizer(Organizer organizer) {

        return !this.organizersList.contains(organizer);
    }

    /**
     * Add an organizer to the list.
     *
     * @param organizer the organizer to add
     * @return true if the organizer is sucessfully added.
     */
    private boolean addOrganizer(Organizer organizer) {

        return this.organizersList.add(organizer);
    }

    /**
     * Return the textual representation of a organizers list.
     *
     * @return the textual representation of a organizers list
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("OrganizersList{");
        for (Organizer organizer : organizersList) {
            s.append(String.format("%s%n", organizer));
        }
        s.append("}");
        return s.toString();
    }

    /**
     * Compares two OrganizersList objects.
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
        OrganizersList otherOrgsList = (OrganizersList) otherObject;

        return this.organizersList.equals(otherOrgsList.organizersList);
    }
}
