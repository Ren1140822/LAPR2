/**
 * Package location for Model concepts.
 */
package lapr.project.model;

/**
 * Represents a demonstration.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Amaral 1151231
 */
public class Demonstration {

    /**
     * the descriptive text of this demonstration
     */
    private String descriptiveText;
    /**
     * the default value of the descriptive text ( when using no args
     * constructor)
     */
    private static final String DESCRIPTIVE_TEXT_BY_DEFAULT = "No description.";

    /**
     * empty constructor, assigns the default value to attributes
     */
    public Demonstration() {
        this.descriptiveText = DESCRIPTIVE_TEXT_BY_DEFAULT;
    }

    /**
     * builds instance of demonstration with a string as param
     */
    public Demonstration(String descriptiveText) {
        this.descriptiveText = descriptiveText;
    }

    /**
     * Builds instance of demonstration using another demonstration as copy
     */
    public Demonstration(Demonstration d) {
        this.descriptiveText = new String(d.descriptiveText);
    }

    /**
     * returns the current value of the descriptive text
     */
    public String getDescriptiveText() {
        return this.descriptiveText;
    }

    /**
     * sets the current value of the descriptive text
     */
    public void setDescriptiveText(String text) {
        this.descriptiveText = text;
    }

    /**
     * Returns the textual representation of the attributes of this class.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Demonstration{");

        s.append(String.format("%s%n", this.descriptiveText));

        s.append("}");
        return s.toString();
    }
}
