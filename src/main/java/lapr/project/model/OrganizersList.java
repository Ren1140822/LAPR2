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
    public OrganizersList(){
        organizersList = new ArrayList<>();
    }
    
    /**
     * Creates an instance of OrganizersList receiving the list of organizers users.
     * 
     * @param organizersList list of organizers users
     */
    public OrganizersList(List<Organizer> organizersList){
        this.organizersList = new ArrayList<>(organizersList);
    }
    
    /**
     * Creates an instance of OrganizersList copying another organizers list.
     * 
     * @param organizersList another organizers list
     */
    public OrganizersList(OrganizersList organizersList){
        this.organizersList = new ArrayList<>(organizersList.organizersList);
    }
    
    /**
     * Gets the list of organizers.
     * 
     * @return list of organizers
     */
    public List<Organizer> getOrganizersList(){
        return new ArrayList<>(organizersList);
    }
    
    /**
     * Sets the list of organizers.
     * 
     * @param organizersList list of organizers
     */
    public void setOrganizersList(List<Organizer> organizerList){
        this.organizersList = new ArrayList<>(organizersList);
    }
    
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("OrganizersList{");
        for (Organizer organizer : organizersList){
            s.append(String.format("%s%n", organizer));
        }
        s.append("}");
        return s.toString();
    }
    
    
    
}
