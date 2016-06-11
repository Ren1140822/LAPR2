/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Represents a applications list
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
@XmlRootElement

public class ApplicationsList {

    /**
     * List of applications.
     */
    
    private List<Application> applicationsList;

    /**
     * A temporary exhibition application reference.
     */
    
    private ExhibitionApplication exhibitionApplication;

    /**
     * Creates an instance of ApplicationsList with its default values.
     */
    public ApplicationsList() {
        this.applicationsList = new ArrayList<>();
    }

    /**
     * Creates an instance of ApplicationsList receiving the list of
     * applications to an exhibition.
     *
     * @param ApplicationsList list of applications
     */
    public ApplicationsList(List<ExhibitionApplication> ApplicationsList) {
        this.applicationsList = new ArrayList<>(applicationsList);
    }

    /**
     * Creates an instance of ApplicationsList copying another list of
     * applications.
     *
     * @param applicationsList list of applications
     */
    public ApplicationsList(ApplicationsList applicationsList) {
        this.applicationsList = new ArrayList<>(applicationsList.applicationsList);
    }

    /**
     * Gets the list of applications.
     *
     * @return list of applications
     */
    @XmlTransient
    public List<Application> getApplicationsList() {
        return new ArrayList<>(this.applicationsList);
    }

    /**
     * Sets the list of applications.
     *
     * @param applicationsList list of applications
     */
    
    public void setApplicationsList(List<Application> applicationsList) {
        this.applicationsList = new ArrayList<>(applicationsList);
    }

    /**
     * Creates a new exhibition application.
     * @return the new exhibition application
     */
    public  ExhibitionApplication newExhibitionApplication() {
        this.exhibitionApplication = new ExhibitionApplication();
        return this.exhibitionApplication;
    }

   
    /**
     * Return the textual representation of a ApplicationsList.
     *
     * @return the textual representation of a ApplicatiosList
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("ExhibitionApplicationList{");
        for (Application application : this.applicationsList) {
            s.append(String.format("%s%n", application));
        }
        s.append("}");
        return s.toString();
    }

    /**
     * Compares two ApplicationsList objects.
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
        ApplicationsList otherApplicationsList = (ApplicationsList) otherObject;

        return this.applicationsList.equals(otherApplicationsList.applicationsList);
    }
}
