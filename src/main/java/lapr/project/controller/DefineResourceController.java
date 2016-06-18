/**
 * Package location for Application Controllers concepts.
 */
package lapr.project.controller;

import lapr.project.model.ExhibitionCenter;
import lapr.project.model.Resource;
import lapr.project.model.ResourcesRegister;

/**
 * Represents the controller to define resource.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class DefineResourceController {

    /**
     * The exhibition center.
     */
    private final ExhibitionCenter exhibitionCenter;

    /**
     * the resources register.
     */
    private ResourcesRegister resourcesRegister;

    /**
     * The resource to be defined.
     */
    private Resource resource;

    /**
     * Constructs a define resource controller.
     *
     * @param exhibitionCenter exhibition center
     */
    public DefineResourceController(ExhibitionCenter exhibitionCenter) {
        this.exhibitionCenter = exhibitionCenter;
    }

    /**
     * Creates a new resource with a description, validating the resource.
     *
     * @param description description for the resource
     * @return true if the resource is valid, false otherwise
     */
    public boolean newResource(String description) {
        this.resourcesRegister = this.exhibitionCenter.getResourcesRegister();
        this.resource = this.resourcesRegister.newResource();
        return this.resourcesRegister.validateResource(this.resource);
    }

    /**
     * Register a resource.
     *
     * @return true if it is successful registered, false otherwise
     */
    public boolean registerResource() {
        return this.resourcesRegister.registerResource(this.resource);
    }
}
