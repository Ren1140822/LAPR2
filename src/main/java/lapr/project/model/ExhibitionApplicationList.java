/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an exhibition application list
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ExhibitionApplicationList {

    /**
     * List of applications to an exhibition
     */
    private List<ExhibitionApplication> exhibitionApplicationList;

    /**
     * Creates an instance of ExhibitionApplicationList with its default values.
     */
    public ExhibitionApplicationList() {
        this.exhibitionApplicationList = new ArrayList<>();
    }

    /**
     * Creates an instance of ExhibitionApplicationList receiving the list of
     * applications to an exhibition.
     *
     * @param exhibitionApplicationList list of applications to an exhibition
     */
    public ExhibitionApplicationList(List<ExhibitionApplication> exhibitionApplicationList) {
        this.exhibitionApplicationList = new ArrayList<>(exhibitionApplicationList);
    }

    /**
     * Creates an instance of ExhibitionApplicationList copying another list of
     * applications to an exhibition.
     *
     * @param exhibitionApplicationList list of applications to an exhibition
     */
    public ExhibitionApplicationList(ExhibitionApplicationList exhibitionApplicationList) {
        this.exhibitionApplicationList = new ArrayList<>(exhibitionApplicationList.exhibitionApplicationList);
    }

    /**
     * Gets the list of applications to an exhibition.
     *
     * @return list of applications to an exhibition
     */
    public List<ExhibitionApplication> getExhibitionApplicationList() {
        return new ArrayList<>(this.exhibitionApplicationList);
    }

    /**
     * Sets the list of applications to an exhibition.
     *
     * @param exhibitionApplicationList list of applications to an exhibition
     */
    public void setExhibitionApplicationList(List<ExhibitionApplication> exhibitionApplicationList) {
        this.exhibitionApplicationList = new ArrayList<>(exhibitionApplicationList);
    }

    /**
     * Return the textual representation of a DemonstrationApplicationList.
     *
     * @return the textual representation of a DemonstrationApplicationList
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("ExhibitionApplicationList{");
        for (ExhibitionApplication exhibitionApplication : this.exhibitionApplicationList) {
            s.append(String.format("%s%n", exhibitionApplication));
        }
        s.append("}");
        return s.toString();
    }

}
