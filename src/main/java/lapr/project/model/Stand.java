/**
 * Package location for Model concepts.
 */
package lapr.project.model;

/**
 * Represents a stands register to store stands.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Amaral 1151231
 */
public class Stand {

    /**
     * Stand's unique number identification.
     */
    private int numberID;

    /**
     * Stand's area.
     */
    private float area;

    /**
     * Stand's number ID counter.
     */
    private static int NUMBER_ID_COUNTER = 0;

    /**
     * Stand's default area.
     */
    private static final float DEFAULT_AREA = 0.0f;

    /**
     * Default constructor of a Stand class.
     */
    public Stand() {
        this.area = DEFAULT_AREA;
        this.numberID = ++NUMBER_ID_COUNTER;
    }

    /**
     * Constructor of a Stand class.
     *
     * @param area Area of the stand.
     */
    public Stand(float area) {
        this.area = area;
        this.numberID = ++NUMBER_ID_COUNTER;
    }

    /**
     * Copy constructor of a Stand class.
     *
     * @param stand Stand to copy
     */
    public Stand(Stand stand) {
        this.area = stand.area;
        this.numberID = ++NUMBER_ID_COUNTER;
    }

    /**
     * Obtain the stand's number ID.
     *
     * @return the stand's number ID
     */
    public int getNumberID() {
        return numberID;
    }

    /**
     * Set the stand's number ID.
     *
     * @param numberID the stand's number ID to set
     */
    public void setNumberID(int numberID) {
        this.numberID = numberID;
    }

    /**
     * Obtain the stand's area.
     *
     * @return the stand's area
     */
    public float getArea() {
        return area;
    }

    /**
     * Set the stand's area.
     *
     * @param area the stand's area to set
     */
    public void setArea(float area) {
        this.area = area;
    }

    /**
     * Return the textual representation of a stand.
     *
     * @return the textual representation of a stand
     */
    @Override
    public String toString() {
        return String.format("Stand{%nnumberID=%d%narea=%.1f}", this.numberID, this.area);
    }

}
