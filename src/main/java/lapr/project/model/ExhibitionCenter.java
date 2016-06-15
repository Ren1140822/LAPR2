/**
 * Package location for Model concepts.
 */
package lapr.project.model;

/**
 * Represents an exhibition center.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ExhibitionCenter {

    /**
     * Register for Exhibitions.
     */
    private ExhibitionsRegister exhibitionsRegister;

    /**
     * Register for users.
     */
    private UsersRegister usersRegister;

    /**
     * Register for resources.
     */
    private ResourcesRegister resourcesRegister;

    /**
     * Register for stands.
     */
    private StandsRegister standsRegister;

    /**
     * Register for mechanisms.
     */
    private MechanismsRegister mechanismsRegister;

    /**
     * Register for conflict types.
     */
    private ConflictTypesRegister conflictTypesRegister;

    /**
     * Creates an instance of exhibition center with its default values.
     */
    public ExhibitionCenter() {
        exhibitionsRegister = new ExhibitionsRegister();
        usersRegister = new UsersRegister();
        resourcesRegister = new ResourcesRegister();
        standsRegister = new StandsRegister();
        mechanismsRegister = new MechanismsRegister();
        conflictTypesRegister = new ConflictTypesRegister();
    }

    /**
     * Creates an instance of exhibition center receiving an exhibitions
     * register, an users register, a resources register, a stands register and
     * a mechanism register.
     *
     * @param exhibitionsRegister register for exhibitions
     * @param usersRegister register for users
     * @param resourcesRegister register for resourses
     * @param standsRegister register for stands
     * @param mechanismsRegister register for mechanisms
     * @param conflictTypesRegister register for conflict types
     */
    public ExhibitionCenter(ExhibitionsRegister exhibitionsRegister, UsersRegister usersRegister,
            ResourcesRegister resourcesRegister, StandsRegister standsRegister,
            MechanismsRegister mechanismsRegister, ConflictTypesRegister conflictTypesRegister) {
        this.exhibitionsRegister = new ExhibitionsRegister(exhibitionsRegister);
        this.usersRegister = new UsersRegister(usersRegister);
        this.resourcesRegister = new ResourcesRegister(resourcesRegister);
        this.standsRegister = new StandsRegister(standsRegister);
        this.mechanismsRegister = new MechanismsRegister(mechanismsRegister);
        this.conflictTypesRegister = new ConflictTypesRegister(conflictTypesRegister);
    }

    /**
     * Creates an instance of exhibition center copying another exhibition
     * center.
     *
     * @param exhibitionCenter another exhibition center
     */
    public ExhibitionCenter(ExhibitionCenter exhibitionCenter) {
        exhibitionsRegister = new ExhibitionsRegister(exhibitionCenter.exhibitionsRegister);
        usersRegister = new UsersRegister(exhibitionCenter.usersRegister);
        resourcesRegister = new ResourcesRegister(exhibitionCenter.resourcesRegister);
        standsRegister = new StandsRegister(exhibitionCenter.standsRegister);
        mechanismsRegister = new MechanismsRegister(exhibitionCenter.mechanismsRegister);
        conflictTypesRegister = new ConflictTypesRegister(exhibitionCenter.conflictTypesRegister);
    }

    /**
     * Gets the exhibitions register.
     *
     * @return exhibitions register
     */
    public ExhibitionsRegister getExhibitionsRegister() {
        return new ExhibitionsRegister(exhibitionsRegister);
    }

    /**
     * Sets the exhibitions register.
     *
     * @param exhibitionsRegister exhibitions register
     */
    public void setExhibitionsRegister(ExhibitionsRegister exhibitionsRegister) {
        this.exhibitionsRegister = new ExhibitionsRegister(exhibitionsRegister);
    }

    /**
     * Gets the users register.
     *
     * @return users register
     */
    public UsersRegister getUsersRegister() {
        return new UsersRegister(usersRegister);
    }

    /**
     * Sets the users register.
     *
     * @param usersRegister users register
     */
    public void setUsersRegister(UsersRegister usersRegister) {
        this.usersRegister = new UsersRegister(usersRegister);
    }

    /**
     * Gets the resources register.
     *
     * @return users register
     */
    public ResourcesRegister getResourcesRegister() {
        return new ResourcesRegister(resourcesRegister);
    }

    /**
     * Sets the resources register.
     *
     * @param resourcesRegister resources register
     */
    public void setResourcesRegister(ResourcesRegister resourcesRegister) {
        this.resourcesRegister = new ResourcesRegister(resourcesRegister);
    }

    /**
     * Gets the stands register.
     *
     * @return stands register
     */
    public StandsRegister getStandsRegister() {
        return new StandsRegister(standsRegister);
    }

    /**
     * Sets the stands register.
     *
     * @param standsRegister stands register
     */
    public void setStandsRegister(StandsRegister standsRegister) {
        this.standsRegister = new StandsRegister(standsRegister);
    }

    /**
     * Gets the mechanisms register.
     *
     * @return mechanisms register
     */
    public MechanismsRegister getMechanismsRegister() {
        return new MechanismsRegister(mechanismsRegister);
    }

    /**
     * Sets the mechanisms register.
     *
     * @param mechanismsRegister mechanisms register
     */
    public void setMechanismsRegister(MechanismsRegister mechanismsRegister) {
        this.mechanismsRegister = new MechanismsRegister(mechanismsRegister);
    }

    /**
     * Obtain the conflict types register.
     *
     * @return the conflict types register
     */
    public ConflictTypesRegister getConflictTypesRegister() {
        return this.conflictTypesRegister;
    }

    /**
     * Sets the conflict types register.
     *
     * @param conflictTypesRegister the conflict types register to set
     */
    public void setConflictTypesRegister(ConflictTypesRegister conflictTypesRegister) {
        this.conflictTypesRegister = new ConflictTypesRegister(conflictTypesRegister);
    }

    @Override
    public String toString() {
        return String.format("ExhibitionCenter{%n%s%n%s%n%s%n%s%n%s%n%s}", exhibitionsRegister,
                usersRegister, resourcesRegister, standsRegister,
                mechanismsRegister, conflictTypesRegister);
    }

    /**
     * Compares two ExhibitionCenters objects.
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
        ExhibitionCenter otherExhibitionCenter = (ExhibitionCenter) otherObject;

        return this.exhibitionsRegister.equals(otherExhibitionCenter.exhibitionsRegister); // TODO : Implement all equals related to ExhibitionCenter attributes

    }
}
