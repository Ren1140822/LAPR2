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
    private List<Evaluation> evaluationsList;

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
        this.keyWordList = new ArrayList<KeyWord>();
        this.exhibitor = new Exhibitor();
        this.evaluationsList = new ArrayList<Evaluation>();
    }

    /**
     * the constructor with parameters
     */
    public ExhibitionApplication(float exhibitorArea, int numberInvitations, List<Product> productList, List<Demonstration> demonstrationsList, List<Evaluation> evaluationsList, List<KeyWord> keyWordList) {
        this.exhibitorArea = exhibitorArea;
        this.numberInvitations = numberInvitations;
        this.productList = new ArrayList(productList);
        this.demonstrationsList = new ArrayList(demonstrationsList);
        this.keyWordList = keyWordList;
        this.exhibitor = new Exhibitor();
        this.evaluationsList = new ArrayList(evaluationsList);

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
        this.evaluationsList = new ArrayList(exhibitionApplication.evaluationsList);
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
     * @return the evaluation list
     */
    public List<Evaluation> getApplicationEvaluationsList() {
        return this.evaluationsList;
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
     * @param evaluationsList sets the evaluation's list
     */
    public void setApplicationEvaluationsList(List<Evaluation> evaluationsList) {
        this.evaluationsList = new ArrayList(evaluationsList);
    }
/**
 * Sets exhibitor
 * @param exhibitor  the exhibitor to copy
 */
    public void setExhibitor(Exhibitor exhibitor) {
        this.exhibitor = exhibitor;
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
        return (this.exhibitor.equals(otherExhibitionApplication.exhibitor) && this.exhibitorArea == otherExhibitionApplication.exhibitorArea && this.numberInvitations == otherExhibitionApplication.numberInvitations && this.demonstrationsList.equals(otherExhibitionApplication.demonstrationsList) && this.productList.equals(otherExhibitionApplication.productList) && this.evaluationsList.equals(otherExhibitionApplication.evaluationsList) && this.keyWordList.equals(otherExhibitionApplication.keyWordList));

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
        for(Evaluation evaluation: evaluationsList){
            s.append(String.format("%s%n", evaluation));
        }
        for (KeyWord keyword : keyWordList) {
            s.append(String.format("%s%n", keyword));
        }
        s.append("}");
        return s.toString();
    }


/**
 * Returns a new evaluation.
 *
 * @return new evaluation
 */
@Override
        public Evaluation newEvaluation() {
        return new Evaluation();
    }

    /**
     * Validate if a evaluation is valid.
     *
     * @param evaluation evaluation to be validated
     * @return true if it is valid, false otherwise
     */
    @Override
        public boolean validateEvaluation(Evaluation evaluation
    ) {
        return !this.evaluationsList.contains(evaluation) && evaluation.validate();
    }

    /**
     * Register an evaluation.
     *
     * @param evaluation evaluation to be registered
     * @return true if it is registered with success, false otherwise
     */
    @Override
        public boolean registerEvaluation(Evaluation evaluation
    ) {
        return this.evaluationsList.add(evaluation);
    }
}
