/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Represents an Exhibition.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class Exhibition {

    /**
     * Exhibition's title.
     */
    private String title;

    /**
     * Exhibition's description.
     */
    private String description;

    /**
     * Exhibition's start date.
     */
    private Date startDate;

    /**
     * Exhibition's end date.
     */
    private Date endDate;

    /**
     * Exhibition's application submissions start date.
     */
    private Date subStartDate;

    /**
     * Exhibition's application submissions end date.
     */
    private Date subEndDate;

    /**
     * Exhibition's location.
     */
    private Place place;

    /**
     * Exhibition's staff list.
     */
    private StaffList staffList;

    /**
     * Exhibition's organizers list.
     */
    private OrganizersList organizersList;

    /**
     * Exhibition's applications list.
     */
    private ApplicationsList applicationsList;

    /**
     * Exhibition's demonstrations list.
     */
    private List<Demonstration> demonstrationsList;

    /**
     * Exhibition's staff attributions list.
     */
    private StaffAttributionsList staffAttributionsList;

    /**
     * Exhibition's default title.
     */
    private static final String DEFAULT_TITLE = "no title";

    /**
     * Exhibition's default description.
     */
    private static final String DEFAULT_DESCRIPTION = "no description";

    /**
     * Exhibition's default start date.
     */
    private static final Date DEFAULT_START_DATE = new Date(2016, 1, 1);

    /**
     * Exhibition's default end date.
     */
    private static final Date DEFAULT_END_DATE = new Date(2016, 1, 1);

    /**
     * Exhibition's default application submissions start date.
     */
    private static final Date DEFAULT_SUB_START_DATE = new Date(2016, 1, 1);

    /**
     * Exhibition's default application submissions end date.
     */
    private static final Date DEFAULT_SUB_END_DATE = new Date(2016, 1, 1);

    /**
     * Exhibition's default location.
     */
    private static final Place DEFAULT_PLACE = new Place();

    /**
     * Default constructor of a Exhibition class.
     */
    public Exhibition() {
        this.title = DEFAULT_TITLE;
        this.description = DEFAULT_DESCRIPTION;
        this.startDate = DEFAULT_START_DATE;
        this.endDate = DEFAULT_END_DATE;
        this.subStartDate = DEFAULT_SUB_START_DATE;
        this.subEndDate = DEFAULT_SUB_END_DATE;
        this.place = DEFAULT_PLACE;
        this.staffList = new StaffList();
        this.organizersList = new OrganizersList();
        this.applicationsList = new ApplicationsList();
        this.demonstrationsList = new ArrayList<>();
        this.staffAttributionsList = new StaffAttributionsList();

        // TODO : Develop State functionality
    }

    /**
     * Constructor of a Exhibition class.
     *
     * @param title Exhibition's title
     * @param description Exhibition's description
     * @param startDate Exhibition's start date
     * @param endDate Exhibition's end date
     * @param subStartDate Exhibition's application submissions sart date
     * @param subEndDate Exhibition's application submissions end date
     * @param place Exhibition's location
     * @param staffList Exhibition's staff list
     * @param organizersList Exhibition's organizers list
     * @param demonstrationsList Exhibition's demonstrations list
     * @param staffAttributionsList Exhibition's staff attributions list
     */
    public Exhibition(String title, String description, Date startDate, Date endDate, Date subStartDate, Date subEndDate, Place place, StaffList staffList, OrganizersList organizersList, List<Demonstration> demonstrationsList, StaffAttributionsList staffAttributionsList) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.subStartDate = subStartDate;
        this.subEndDate = subEndDate;
        this.place = place;
        // TODO: Once all classes are setup modify construction of lists using composition.
        this.staffList = staffList;
        this.organizersList = organizersList;
        this.demonstrationsList = new ArrayList<>(demonstrationsList);
        this.staffAttributionsList = staffAttributionsList;
    }

    /**
     * Copy Constructor of a Exhibition.
     *
     * @param exhibition Exhibition to copy
     */
    public Exhibition(Exhibition exhibition) {
        this.title = exhibition.title;
        this.description = exhibition.description;
        this.startDate = exhibition.startDate;
        this.endDate = exhibition.endDate;
        this.subStartDate = exhibition.subStartDate;
        this.subEndDate = exhibition.subEndDate;
        this.place = exhibition.place;
        // TODO: Once all classes are setup modify construction of lists using composition.
        this.staffList = exhibition.staffList;
        this.organizersList = exhibition.organizersList;
        this.demonstrationsList = new ArrayList<>(exhibition.getDemonstrationsList());
        this.staffAttributionsList = exhibition.staffAttributionsList;
    }

    /**
     * Obtain the Exhibition's title.
     *
     * @return the Exhibition's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the Exhibition's title.
     *
     * @param title the Exhibition's title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Obtain the Exhibition's description.
     *
     * @return the Exhibition's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the Exhibition's description.
     *
     * @param description the Exhibition's description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtain the Exhibition's start date.
     *
     * @return the Exhibition's start date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Set the Exhibition's start date.
     *
     * @param startDate the Exhibition's start date to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Obtain the Exhibition's end date.
     *
     * @return the Exhibition's end date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Set the Exhibition's end date.
     *
     * @param endDate the Exhibition's end date to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Obtain the Exhibition's application submissions start date.
     *
     * @return the Exhibition's application submissions start date
     */
    public Date getSubStartDate() {
        return subStartDate;
    }

    /**
     * Set the Exhibition's application submissions start date.
     *
     * @param subStartDate the Exhibition's application submissions start date
     * to set
     */
    public void setSubStartDate(Date subStartDate) {
        this.subStartDate = subStartDate;
    }

    /**
     * Obtain the Exhibition's application submissions end date.
     *
     * @return the Exhibition's application submissions start date
     */
    public Date getSubEndDate() {
        return subEndDate;
    }

    /**
     * Set the Exhibition's application submissions end date.
     *
     * @param subEndDate the Exhibition's application submissions end date to
     * set
     */
    public void setSubEndDate(Date subEndDate) {
        this.subEndDate = subEndDate;
    }

    /**
     * Obtain the Exhibition's place.
     *
     * @return the Exhibition's place
     */
    public Place getPlace() {
        return place;
    }

    /**
     * Set the Exhibition's place.
     *
     * @param place the Exhibition's place to set
     */
    public void setPlace(Place place) {
        this.place = place;
    }

    /**
     * Obtain the Exhibition's staff list.
     *
     * @return the Exhibition's staff list
     */
    public StaffList getStaffList() {
        return staffList;
    }

    /**
     * Set the Exhibition's staff list.
     *
     * @param staffList the Exhibition's staff list to set
     */
    public void setStaffList(StaffList staffList) {
        this.staffList = staffList;
    }

    /**
     * Obtain the Exhibition's organizers list.
     *
     * @return the Exhibition's organizers list
     */
    public OrganizersList getOrganizersList() {
        return organizersList;
    }

    /**
     * Set the Exhibition's organizers list.
     *
     * @param organizersList the Exhibition's organizers list to set
     */
    public void setOrganizersList(OrganizersList organizersList) {
        this.organizersList = organizersList;
    }

    /**
     * Obtain the Exhibition's applications list.
     *
     * @return the Exhibition's applications list
     */
    public ApplicationsList getApplicationsList() {
        return applicationsList;
    }

    /**
     * Set the Exhibition's applications list.
     *
     * @param applicationsList the Exhibition's applications list to set
     */
    public void setApplicationsList(ApplicationsList applicationsList) {
        this.applicationsList = applicationsList;
    }

    /**
     * Obtain the Exhibition's demonstrations list.
     *
     * @return the Exhibition's demonstrations list
     */
    public List<Demonstration> getDemonstrationsList() {
        return demonstrationsList;
    }

    /**
     * Set the Exhibition's demonstrations list.
     *
     * @param demonstrationsList the Exhibition's demonstrations list to set
     */
    public void setDemonstrationsList(List<Demonstration> demonstrationsList) {
        this.demonstrationsList = demonstrationsList;
    }

    /**
     * Obtain the Exhibition's staff attributions list.
     *
     * @return the Exhibition's staff attributions list
     */
    public StaffAttributionsList getStaffAttributionsList() {
        return staffAttributionsList;
    }

    /**
     * Set the Exhibition's staff attributions list.
     *
     * @param staffAttributionsList the Exhibition's staff attributions list to
     * set
     */
    public void setStaffAttributionsList(StaffAttributionsList staffAttributionsList) {
        this.staffAttributionsList = staffAttributionsList;
    }

    /**
     * Return the textual representation of a exhibition.
     *
     * @return the textual representation of a exhibition
     */
    @Override
    public String toString() {

        return String.format("Exhibition{%ntitle=%s%ndescription=%s%n"
                + "startDate=%s%n"
                + "endDate=%s%n"
                + "subStartDate=%s%n"
                + "subEndDate=%s%n"
                + "place=%s%n"
                + "staffList=%s%n"
                + "organizersList=%s%n"
                + "applicationsList=%s%n"
                + "demonstrationsList=%s%n"
                + "staffAttributionsList=%s%n}",
                this.title, this.description, this.startDate, this.endDate, this.subStartDate,
                this.subEndDate, this.place, this.staffList, this.organizersList, this.applicationsList,
                this.demonstrationsList, this.staffAttributionsList);
    }

    /**
     * Compares two Exhibition objects.
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
        Exhibition otherExhibition = (Exhibition) otherObject;

        return this.title.equals(otherExhibition.title)
                && this.description.equals(otherExhibition.description)
                && this.startDate.equals(otherExhibition.startDate)
                && this.endDate.equals(otherExhibition.endDate)
                && this.subStartDate.equals(otherExhibition.subStartDate)
                && this.subEndDate.equals(otherExhibition.subEndDate)
                && this.place.equals(otherExhibition.place)
                && this.organizersList.equals(otherExhibition.organizersList)
                && this.staffList.equals(otherExhibition.staffList)
                && this.applicationsList.equals(otherExhibition.applicationsList)
                // TODO: Update to class demonstrations list
                && this.demonstrationsList.equals(otherExhibition.demonstrationsList)
                && this.staffAttributionsList.equals(otherExhibition.staffAttributionsList);
    }
}
