/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Resources Register.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ResourcesRegister {

    /**
     * resources List of ResourcesRegister
     */
    private List<Resource> resourcesList;

    /**
     * Creates an instance of ResourceRegister with its default values.
     */
    public ResourcesRegister() {
        resourcesList = new ArrayList<>();
    }

    /**
     * Creates an instance of ResourcesRegister receiving a list of resources.
     *
     * @param resourcesList list of resources
     */
    public ResourcesRegister(List<Resource> resourcesList) {
        this.resourcesList = new ArrayList<>(resourcesList);
    }

    /**
     * Creates an instance of ResourcesRegister copying another resources
     * register.
     *
     * @param resourcesList another resource register
     */
    public ResourcesRegister(ResourcesRegister resourcesRegister) {
        this.resourcesList = new ArrayList<>(resourcesRegister.resourcesList);
    }

    /**
     * Gets the resources list.
     *
     * @return List of resources
     */
    public List<Resource> getResourcesList() {
        return new ArrayList<>(resourcesList);
    }

    /**
     * Sets the resources list.
     *
     * @param resourcesList list of resources
     */
    public void setResourcesList(List<Resource> resourcesList) {
        this.resourcesList = new ArrayList<>(resourcesList);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("ResourcesRegister{");
        for (Resource resource : resourcesList) {
            s.append(String.format("%s%n", resource));
        }
        s.append("}");
        return s.toString();
    }

}
