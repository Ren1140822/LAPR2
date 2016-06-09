/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.application.ApplicationInitialState;

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
     * The state of the application.
     */
    private ApplicationState currentState;

    /**
     * the default company name of this application
     */
    private String DEFAULT_COMPANY_NAME = "No name";
    /**
     * the default address of the company
     */
    private String DEFAULT_COMPANY_ADDRESS = "No address";
    /**
     * the cellphone of the company
     */
    private String DEFAULT_COMPANY_CELLPHONE = "No cellphone";
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
        this.companyName = DEFAULT_COMPANY_NAME;
        this.companyAddress = DEFAULT_COMPANY_ADDRESS;
        this.companyCellphone = DEFAULT_COMPANY_CELLPHONE;
        this.exhibitorArea = DEFAULT_EXHIBITOR_AREA;
        this.numberInvitations = DEFAULT_NUMBER_INVITATION;
        this.productList = new ArrayList<Product>();
        this.demonstrationsList = new ArrayList<Demonstration>();
        this.evaluationsList = new ArrayList<Evaluation>();
        this.currentState = new ApplicationInitialState(this);
    }

    /**
     * the constructor with parameters
     */
    public ExhibitionApplication(String companyName, String companyAddress, String companyCellphone, float exhibitorArea,
            int numberInvitations, List<Product> productList, List<Demonstration> demonstrationsList, List<Evaluation> evaluationsList, ApplicationState applicationState) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyCellphone = companyCellphone;
        this.exhibitorArea = exhibitorArea;
        this.numberInvitations = numberInvitations;
        this.productList = new ArrayList(productList);
        this.demonstrationsList = new ArrayList(demonstrationsList);
        this.evaluationsList = new ArrayList(evaluationsList);
        this.currentState = applicationState;

    }

    /**
     * the copy constructor receiving instance of this class as parameter
     *
     * @param exhApplication
     */
    public ExhibitionApplication(ExhibitionApplication exhApplication) {
        this.companyName = exhApplication.companyName;
        this.companyAddress = exhApplication.companyAddress;
        this.companyCellphone = exhApplication.companyCellphone;
        this.exhibitorArea = exhApplication.exhibitorArea;
        this.numberInvitations = exhApplication.numberInvitations;
        this.productList = new ArrayList(exhApplication.productList);
        this.demonstrationsList = new ArrayList(exhApplication.demonstrationsList);
        this.evaluationsList = new ArrayList(exhApplication.evaluationsList);
        this.currentState = exhApplication.currentState;
    }

    /**
     *
     * @return the company name
     */
    public String getCompanyName() {
        return this.companyName;
    }

    /**
     *
     * @return the company address
     */
    public String getCompanyAddress() {
        return this.companyAddress;
    }

    /**
     *
     * @return the company cellphone
     */
    public String getCompanyCellphone() {
        return this.companyCellphone;
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
    public List<Evaluation> getEvaluationsList() {
        return this.evaluationsList;
    }

    /**
     *
     * @param companyName sets the company name
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     *
     * @param companyAddress sets company address
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    /**
     *
     * @param companyCellphone sets company cellphone
     */
    public void setCompanyCellphone(String companyCellphone) {
        this.companyCellphone = companyCellphone;
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
    public void setEvaluationsList(List<Evaluation> evaluationsList) {
        this.evaluationsList = new ArrayList(evaluationsList);
    }

    /**
     * Returns the textual interpretation of the objects and attributes of this
     * class
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("ExhibitionApplication{");
        s.append(String.format("%s%n", this.companyName));
        s.append(String.format("%s%n", this.companyAddress));
        s.append(String.format("%s%n", this.companyCellphone));
        s.append(String.format("%f%n", this.exhibitorArea));
        s.append(String.format("%d%n", this.numberInvitations));
        for (Demonstration demo : demonstrationsList) {
            s.append(String.format("%s%n", demo));
        }
        for (Product prod : productList) {
            s.append(String.format("%s%n", prod));
        }
        for (Evaluation ev : evaluationsList) {
            s.append(String.format("%s%n", ev));
        }
        s.append("}");
        return s.toString();
    }

    /**
     * Compares if this object is equal to otherObject.
     *
     * @param otherObject other object to compare with
     * @return true if it repreents the same object, false otherwise
     */
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || this.getClass() != otherObject.getClass()) {
            return false;
        }
        ExhibitionApplication otherExhibitionApplication = (ExhibitionApplication) otherObject;

        return this.companyName.equals(otherExhibitionApplication.companyName) && this.companyCellphone.equals(otherExhibitionApplication.companyCellphone)
                && this.companyAddress.equals(otherExhibitionApplication.companyAddress) && this.demonstrationsList.equals(otherExhibitionApplication.demonstrationsList)
                && this.evaluationsList.equals(otherExhibitionApplication.evaluationsList) && this.productList.equals(otherExhibitionApplication.productList)
                && this.exhibitorArea == otherExhibitionApplication.exhibitorArea && this.numberInvitations == otherExhibitionApplication.numberInvitations;
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
    public boolean validateEvaluation(Evaluation evaluation) {
        return !this.evaluationsList.contains(evaluation) && evaluation.validate();
    }

    /**
     * Register an evaluation.
     *
     * @param evaluation evaluation to be registered
     * @return true if it is registered with success, false otherwise
     */
    @Override
    public boolean registerEvaluation(Evaluation evaluation) {
        return this.evaluationsList.add(evaluation);
    }

    @Override
    public void setState(ApplicationState newState) {
        this.currentState = newState;
    }

    @Override
    public boolean isValid() {
        //TODO review this
        return this.companyAddress != null && this.companyCellphone != null
                && this.companyName != null && this.currentState != null
                && this.demonstrationsList != null && this.evaluationsList != null
                && this.exhibitorArea > 0 && this.numberInvitations > 0
                && this.productList != null;
    }
}
