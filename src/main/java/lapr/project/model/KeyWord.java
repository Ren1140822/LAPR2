/**
 * Package location for Model concepts.
 */
package lapr.project.model;

/**
 * Represents a KeyWord.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class KeyWord {

    /**
     * the description of this keyword
     */
    private String description;

    /**
     * default value of description
     */
    private static final String DEFAULT_DESCRIPTION = "No description";

    /**
     * Empty constructor.
     */
    public KeyWord() {
        this.description = DEFAULT_DESCRIPTION;
    }

    /**
     * Constructor with parameters.
     *
     * @param description the keyword to define.
     */
    public KeyWord(String description) {
        this.description = new String(description);
    }

    /**
     * Copy constructor receiving another KeyWord instance.
     * @param k the instance of KeyWord to copy.
     */
    public KeyWord(KeyWord k) {
        this.description = new String(k.description);
    }

    /**
     * gets the string value of description
     */
    public String getDescription() {
        return new String(this.description);
    }

    /**
     * sets the value of description
     * @param description the value to set.
     */
    public void setDescription(String description) {

        this.description = new String(description);
    }

    /**
     * Returns the textual interpretation of the objects and attributes of this
     * class
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("KeyWord{");
        s.append(this.description);
        s.append("}");
        return s.toString();
    }

}
