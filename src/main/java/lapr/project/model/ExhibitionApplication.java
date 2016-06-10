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
     * The title of the application.
     */
    private String title;

    /**
     * The exhibitor.
     */
    private Exhibitor exhibitor;

    /**
     * The area asked by the company.
     */
    private float exhibitorArea;

    /**
     * The number of invitations asked for.
     */
    private int numberInvitations;

    /**
     * The list of products the company wishes to expose.
     */
    private List<Product> productList;

    /**
     * The list of demonstrations the company wishes to participate.
     */
    private List<Demonstration> demonstrationsList;

    /**
     * The evaluation lists of this application.
     */
    private List<Evaluation> evaluationsList;

    /**
     * The state of the application.
     */
    private ApplicationState currentState;

    /**
     * The list of keywords.
     */
    private List<KeyWord> keyWordList;

    /**
     * The default title.
     */
    private static final String DEFAULT_TITLE = "No Title";
    /**
     * The default area in float asked by the company.
     */
    private static final float DEFAULT_EXHIBITOR_AREA = 100.0f;
    /**
     * The default number of invitations asked for.
     */
    private static final int DEFAULT_NUMBER_INVITATION = 10;

    /**
     * Creates an instance of exhibition application with its default values.
     */
    public ExhibitionApplication() {
        this.title = DEFAULT_TITLE;
        this.exhibitor = new Exhibitor();
        this.exhibitorArea = DEFAULT_EXHIBITOR_AREA;
        this.numberInvitations = DEFAULT_NUMBER_INVITATION;
        this.productList = new ArrayList<>();
        this.demonstrationsList = new ArrayList<>();
        this.keyWordList = new ArrayList<>();
        this.evaluationsList = new ArrayList<>();
        this.currentState = new ApplicationInitialState(this);
    }

    /**
     * Constructs an instance of exhibition application receivong its
     * parameters.
     *
     * @param title title for the application
     * @param exhibitor exhibitor repnsible
     * @param exhibitorArea exhibition area
     * @param numberInvitations number of invites
     * @param productList products list
     * @param demonstrationsList demonstrations list
     * @param evaluationsList evaluations list
     * @param keyWordList keywords list
     * @param applicationState aplication current state
     */
    public ExhibitionApplication(String title, Exhibitor exhibitor,
            float exhibitorArea, int numberInvitations,
            List<Product> productList, List<Demonstration> demonstrationsList,
            List<Evaluation> evaluationsList, List<KeyWord> keyWordList,
            ApplicationState applicationState) {
        this.title = title;
        this.exhibitor = new Exhibitor(exhibitor);
        this.exhibitorArea = exhibitorArea;
        this.numberInvitations = numberInvitations;
        this.productList = new ArrayList(productList);
        this.demonstrationsList = new ArrayList(demonstrationsList);
        this.keyWordList = keyWordList;
        this.evaluationsList = new ArrayList(evaluationsList);
        this.currentState = applicationState;

    }

    /**
     * Creates an instance of exhibition application copying another exhibition
     * application.
     *
     * @param exhibitionApplication another exhibition application
     */
    public ExhibitionApplication(ExhibitionApplication exhibitionApplication) {
        this.title = exhibitionApplication.title;
        this.exhibitor = exhibitionApplication.exhibitor;
        this.exhibitorArea = exhibitionApplication.exhibitorArea;
        this.numberInvitations = exhibitionApplication.numberInvitations;
        this.productList = new ArrayList(exhibitionApplication.productList);
        this.demonstrationsList = new ArrayList(exhibitionApplication.demonstrationsList);
        this.evaluationsList = new ArrayList(exhibitionApplication.evaluationsList);
        this.keyWordList = new ArrayList(exhibitionApplication.keyWordList);
        this.currentState = exhibitionApplication.currentState;
    }

    /**
     * Gets the title of the application.
     *
     * @return title of the application
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the application.
     *
     * @param title title of the application
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the exhibitor area.
     *
     * @return the exhibitor's area
     */
    public float getExhibitorArea() {
        return this.exhibitorArea;
    }

    /**
     * Returns number of invites.
     *
     * @return the number of invitations
     */
    public int getNumberInvitations() {
        return this.numberInvitations;
    }

    /**
     * Returns list of demonstrations.
     *
     * @return the demonstrationList
     */
    public List<Demonstration> getDemonstrationsList() {
        return this.demonstrationsList;
    }

    /**
     * Gets the current state of the application.
     *
     * @return the application state
     */
    @Override
    public ApplicationState getCurrentState() {
        return currentState;
    }

    /**
     * Returns the product list.
     *
     * @return the product list
     */
    public List<Product> getProductList() {
        return this.productList;
    }

    /**
     * Returns the evaluation list.
     *
     * @return the evaluation list
     */
    @Override
    public List<Evaluation> getEvaluationsList() {
        return this.evaluationsList;
    }

    /**
     * Returns the list of keywords.
     *
     * @return the list of keywords
     */
    public List<KeyWord> getKeyWordList() {
        return keyWordList;
    }

    /**
     * Sets the area of the exhibitor.
     *
     * @param exhibitorArea sets exhibitor area
     */
    public void setExhibitorArea(float exhibitorArea) {
        this.exhibitorArea = exhibitorArea;
    }

    /**
     * Sets the number of invitations.
     *
     * @param numberInvitations number of invitations
     */
    public void setNumberInvitations(int numberInvitations) {
        this.numberInvitations = numberInvitations;
    }

    /**
     * Sets the list of demonstrations.
     *
     * @param demonstrationsList the demonstration list
     */
    public void setDemonstrationsList(List<Demonstration> demonstrationsList) {
        this.demonstrationsList = new ArrayList(demonstrationsList);
    }

    /**
     * Sets the products list.
     *
     * @param productsList procucts list
     */
    public void setProductsList(List<Product> productsList) {
        this.productList = new ArrayList(productsList);
    }

    /**
     * Sets the evaluations list.
     *
     * @param evaluationsList the evaluation's list
     */
    public void setEvaluationsList(List<Evaluation> evaluationsList) {
        this.evaluationsList = new ArrayList(evaluationsList);
    }

    /**
     * Sets the exhibitor.
     *
     * @param exhibitor the exhibitor
     */
    public void setExhibitor(Exhibitor exhibitor) {
        this.exhibitor = exhibitor;
    }

    /**
     * Creates a new Exhibitor.
     *
     * @param companyName the company name
     * @param companyAddress the company address
     * @param companyCellphone the company cellphone
     */
    public void newExhibitor(String companyName, String companyAddress, String companyCellphone) {
        this.exhibitor = new Exhibitor();
        this.exhibitor.setName(companyName);
        this.exhibitor.setAddress(companyAddress);
        this.exhibitor.setMobileNumber(companyName);
    }

    /**
     * Creates new product.
     *
     * @param designation the product name
     * @return true if product is added
     */
    public boolean newProduct(String designation) {
        Product product = new Product();
        product.setDesignation(designation);

        if (product.validate()) {
            productList.add(product);
            return true;

        }
        return false;
    }

    /**
     * Remove a product.
     *
     * @param designation prduct designation
     * @return true if it is successfull removed, false otherwise
     */
    public boolean removeProduct(String designation) {
        for (Product p : productList) {
            if (p.getDesignation().equals(designation)) {
                return productList.remove(p);
            }
        }
        return false;
    }

    /**
     * Adds a demonstration to the list if it doenst contain it
     *
     * @param demonstration the demonstration going to be added to the list
     */
    public void newDemonstration(Demonstration demonstration) {
        if (!validateDemonstration(demonstration)) {
            this.demonstrationsList.add(demonstration);
        }
    }

    /**
     * Creates a new Keyword and adds it to the list
     *
     * @param description the value of the keyword
     */
    public void newKeyword(String description) {
        KeyWord keyWord = new KeyWord(description);
        keyWord.validate();
        keyWordList.add(keyWord);
    }

    /**
     * Checks if this demonstration is already on the list
     *
     * @param demonstration the demonstration to check if exists on current list
     * @return true the list already has this object
     */
    public boolean validateDemonstration(Demonstration demonstration) {
        return (this.demonstrationsList.contains(demonstration));
    }

    /**
     * Validates if the mininum parameters are filled with data
     *
     * @return true if all O.K.
     */
    public boolean validateApplication() {
        return (this.exhibitor.validate() && this.demonstrationsList.isEmpty() && this.productList.isEmpty() && this.keyWordList.size() > 1 && this.keyWordList.size() <= 5 && this.numberInvitations > 0 && this.exhibitorArea > 0);
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

    /**
     * Sets the state of the application.
     *
     * @param newState the new state to set
     */
    @Override
    public void setState(ApplicationState newState) {
        this.currentState = newState;
    }

    /**
     * Checks if all conditions are valid to change state
     *
     * @return true if all is valid
     */
    @Override
    public boolean isValid() {

        return this.currentState != null && validateApplication();
    }

    /**
     * Equals method to verify if two objects are equal.
     *
     * @param otherObject the other exhibition application to compare to
     * @return true if equal
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
        return (this.title.equals(otherExhibitionApplication.title) && this.exhibitor.equals(otherExhibitionApplication.exhibitor)
                && this.exhibitorArea == otherExhibitionApplication.exhibitorArea
                && this.numberInvitations == otherExhibitionApplication.numberInvitations
                && this.demonstrationsList.equals(otherExhibitionApplication.demonstrationsList)
                && this.productList.equals(otherExhibitionApplication.productList)
                && this.evaluationsList.equals(otherExhibitionApplication.evaluationsList)
                && this.keyWordList.equals(otherExhibitionApplication.keyWordList));

    }

    /**
     * Returns the textual interpretation of the objects and attributes of this
     * class
     *
     * @return textual representation for this object
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("ExhibitionApplication{");
        s.append(String.format("%s%n", this.title));
        s.append(String.format("%s%n", this.exhibitor));
        s.append(String.format("%f%n", this.exhibitorArea));
        s.append(String.format("%d%n", this.numberInvitations));
        for (Demonstration demonstration : demonstrationsList) {
            s.append(String.format("%s%n", demonstration));
        }
        for (Product product : productList) {
            s.append(String.format("%s%n", product));
        }
        for (Evaluation evaluation : evaluationsList) {
            s.append(String.format("%s%n", evaluation));
        }
        for (KeyWord keyword : keyWordList) {
            s.append(String.format("%s%n", keyword));
        }
        s.append("}");
        return s.toString();
    }

    /**
     * Set exbibition application inEvaluationState
     */
    @Override
    public void setInEvaluation() {
        this.currentState.setInEvaluation();
    }

}
