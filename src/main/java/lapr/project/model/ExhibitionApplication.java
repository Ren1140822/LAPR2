/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an exhibition application
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ExhibitionApplication implements Application, Conflictable, Assingnable, Decisable, Evaluable {

    /**
     * the company name of this application
     */
    private String companyName;
    /**
     * the address of the company
     */
    private String companyAddress;
    /**
     * the cellphone of the company
     */
    private String companyCellphone;
    /**
     * the areain float asked by the company
     */
    private float exhibitorArea;
    /**
     * the number of invitations asked for
     */
    private int numberInvitations;
    /**
     * the list of products the company wishes to expose
     */
    private List<Product> productList;
    /**
     * the list of demonstrations the company wishes to participate
     */
    private List<Demonstration> demonstrationsList;
    /**
     * the evaluation lists of this application
     */
    private List<ExhibitionEvaluation> applicationEvaluationsList;

    /**
     * This instance's exhibitor.
     */
    private Exhibitor exhibitor;

    /**
     * the list of keywords.
     */
    private List<KeyWord> keyWordList;

    /**
     * the default area in float asked by the company
     */
    private float DEFAULT_EXHIBITOR_AREA = 100.0f;
    /**
     * the default number of invitations asked for
     */
    private int DEFAULT_NUMBER_INVITATION = 10;

    /**
     * the default constructor with no params
     */
    public ExhibitionApplication() {

        this.exhibitorArea = DEFAULT_EXHIBITOR_AREA;
        this.numberInvitations = DEFAULT_NUMBER_INVITATION;
        this.productList = new ArrayList<Product>();
        this.demonstrationsList = new ArrayList<Demonstration>();
        this.applicationEvaluationsList = new ArrayList<ExhibitionEvaluation>();
        this.keyWordList = new ArrayList<KeyWord>();
        this.exhibitor = new Exhibitor();
    }

    /**
     * the constructor with parameters
     */
    public ExhibitionApplication(float exhibitorArea, int numberInvitations, List<Product> productList, List<Demonstration> demonstrationsList, List<ExhibitionEvaluation> applicationsList, List<KeyWord> keyWordList) {

        this.exhibitorArea = exhibitorArea;
        this.numberInvitations = numberInvitations;
        this.productList = new ArrayList(productList);
        this.demonstrationsList = new ArrayList(demonstrationsList);
        this.applicationEvaluationsList = new ArrayList(applicationsList);
        this.keyWordList = keyWordList;
        this.exhibitor = new Exhibitor();
    }

    /**
     * the copy constructor receiving instance of this class as parameter
     *
     * @param exhApplication
     */
    public ExhibitionApplication(ExhibitionApplication exhibitionApplication) {
        this.exhibitorArea = exhibitionApplication.exhibitorArea;
        this.numberInvitations = exhibitionApplication.numberInvitations;
        this.productList = new ArrayList(exhibitionApplication.productList);
        this.demonstrationsList = new ArrayList(exhibitionApplication.demonstrationsList);
        this.applicationEvaluationsList = new ArrayList(exhibitionApplication.applicationEvaluationsList);
        this.keyWordList = new ArrayList(exhibitionApplication.keyWordList);
        this.exhibitor = new Exhibitor();
    }

    /**
     *
     * @return the exhibitor's area
     */
    public float getExhibitorArea() {
        return this.exhibitorArea;
    }

    /**
     *
     * @return the number of invitations
     */
    public int getNumberInvitations() {
        return this.numberInvitations;
    }

    /**
     *
     * @return the demonstrationList
     */
    public List<Demonstration> getDemonstrationsList() {
        return this.demonstrationsList;
    }

    /**
     *
     * @return the product list
     */
    public List<Product> getProductList() {
        return this.productList;
    }

    /**
     *
     * @return the applications list
     */
    public List<ExhibitionEvaluation> getApplicationEvaluationsList() {
        return this.applicationEvaluationsList;
    }

    /**
     *
     * @param exhibitorArea sets exhibitor area
     */
    public void setExhibitorArea(float exhibitorArea) {
        this.exhibitorArea = exhibitorArea;
    }

    /**
     *
     * @param numberInvitations sets number of invitations
     */
    public void setNumberInvitations(int numberInvitations) {
        this.numberInvitations = numberInvitations;
    }

    /**
     *
     * @param demonstrationsList sets the demonstration list
     */
    public void setDemonstrationsList(List<Demonstration> demonstrationsList) {
        this.demonstrationsList = new ArrayList(demonstrationsList);
    }

    /**
     * @param productList sets the products list
     */
    public void setProductsList(List<Product> productsList) {
        this.productList = new ArrayList(productsList);
    }

    /**
     * @param applicationEvaluationsList sets the applications list
     */
    public void setApplicationEvaluationsList(List<ExhibitionEvaluation> applicationEvaluationsList) {
        this.applicationEvaluationsList = new ArrayList(applicationEvaluationsList);
    }

    /**
     * Creates a new Exhibitor.
     */
    public void newExhibitor(String companyName, String companyAddress, String companyCellphone) {
        this.exhibitor = new Exhibitor();
        this.exhibitor.setName(companyName);
        this.exhibitor.setAddress(companyAddress);
        this.exhibitor.setMobileNumber(companyName);
    }

    /**
     * Equals method to verify if two objects are equal.
     *
     * @param otherExhibitionApplication the other exhibition application to
     * compare to
     * @return true if equal
     */
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || this.getClass() != otherObject.getClass()) {
            return false;
        }
        ExhibitionApplication otherExhibitionApplication = (ExhibitionApplication) otherObject;
        return (this.exhibitor.equals(otherExhibitionApplication.exhibitor) && this.exhibitorArea == otherExhibitionApplication.exhibitorArea && this.numberInvitations == otherExhibitionApplication.numberInvitations && this.demonstrationsList.equals(otherExhibitionApplication.demonstrationsList) && this.productList.equals(otherExhibitionApplication.productList) && this.applicationEvaluationsList.equals(otherExhibitionApplication.applicationEvaluationsList) && this.keyWordList.equals(otherExhibitionApplication.keyWordList));

    }

    /**
     * Returns the textual interpretation of the objects and attributes of this
     * class
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("ExhibitionApplication{");
        s.append(String.format("%s%n", this.exhibitor));
        s.append(String.format("%f%n", this.exhibitorArea));
        s.append(String.format("%d%n", this.numberInvitations));
        for (Demonstration demonstration : demonstrationsList) {
            s.append(String.format("%s%n", demonstration));
        }
        for (Product product : productList) {
            s.append(String.format("%s%n", product));
        }
        for (ExhibitionEvaluation applicationEvaluationsList : applicationEvaluationsList) {
            s.append(String.format("%s%n", applicationEvaluationsList));
        }
        for (KeyWord keyword : keyWordList) {
            s.append(String.format("%s%n", keyword));
        }
        s.append("}");
        return s.toString();
    }
}
