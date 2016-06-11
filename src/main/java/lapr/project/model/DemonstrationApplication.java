/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.application.ApplicationInitialState;

/**
 * Represents an demonstration application
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Amaral 1151231
 */
@XmlRootElement
public class DemonstrationApplication implements Application, Conflictable, Assingnable, Decisable, Evaluable {

    /**
     * The title of the application.
     */
    @XmlAttribute
    private String title;

    /**
     * The list of keywords.
     */
      @XmlElementWrapper(name="Keywords List")
    @XmlElement(name="Keyword")
    private List<KeyWord> keywordsList;

    /**
     * The exhibitor.
     */
      @XmlElement
    private Exhibitor exhibitor;

    /**
     * The area asked by the company.
     */
      @XmlElement
    private float exhibitorArea;

    /**
     * The number of invitations asked for.
     */
      @XmlElement
    private int numberInvitations;

    /**
     * The list of products the company wishes to expose.
     */
        @XmlElementWrapper(name="Products List")
    @XmlElement(name="Products")
    private List<Product> productsList;

    /**
     * The evaluation lists of this application.
     */
        @XmlAnyElement
    private List<Evaluation> evaluationsList;

    /**
     * The state of the application.
     */
        @XmlAnyElement
    private ApplicationState currentState;

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
     * Creates an instance of demonstration application with its default values.
     */
    public DemonstrationApplication() {
        this.title = DEFAULT_TITLE;
        this.keywordsList = new ArrayList<>();
        this.exhibitor = new Exhibitor();
        this.exhibitorArea = DEFAULT_EXHIBITOR_AREA;
        this.numberInvitations = DEFAULT_NUMBER_INVITATION;
        this.productsList = new ArrayList<>();
        this.evaluationsList = new ArrayList<>();
        this.currentState = new ApplicationInitialState(this);
    }

    /**
     * Constructs an instance of exhibition application receivong its
     * parameters.
     *
     * @param title title for the application
     * @param keyWords keywords list
     * @param exhibitor exhibitor repnsible
     * @param exhibitorArea exhibition area
     * @param numberInvitations number of invites
     * @param productList products list
     * @param evaluationsList evaluations list
     * @param applicationState aplication current state
     */
    public DemonstrationApplication(String title, List<KeyWord> keyWords, Exhibitor exhibitor,
            float exhibitorArea, int numberInvitations,
            List<Product> productList, List<Evaluation> evaluationsList,
            ApplicationState applicationState) {
        this.title = title;
        this.keywordsList = new ArrayList<>(keyWords);
        this.exhibitor = new Exhibitor(exhibitor);
        this.exhibitorArea = exhibitorArea;
        this.numberInvitations = numberInvitations;
        this.productsList = new ArrayList(productList);
        this.evaluationsList = new ArrayList(evaluationsList);
        this.currentState = applicationState;

    }

    /**
     * Constructs an instance of demonstration application copying another
     * demonstration application.
     *
     * @param demonstrationApplication another demonstration application
     */
    public DemonstrationApplication(DemonstrationApplication demonstrationApplication) {
        this.title = demonstrationApplication.title;
        this.keywordsList = demonstrationApplication.keywordsList;
        this.exhibitor = demonstrationApplication.exhibitor;
        this.exhibitorArea = demonstrationApplication.exhibitorArea;
        this.numberInvitations = demonstrationApplication.numberInvitations;
        this.productsList = new ArrayList(demonstrationApplication.productsList);
        this.evaluationsList = new ArrayList(demonstrationApplication.evaluationsList);
        this.currentState = demonstrationApplication.currentState;
    }

    /**
     * Sets the application's title.
     *
     * @param title application's title
     */
    
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the exhibitor.
     *
     * @return exhibitor
     */
    @Override
    public Exhibitor getExhibitor() {
        return exhibitor;
    }

    /**
     * Gets the keywords list.
     *
     * @return keywords list
     */
    @Override
    public List<KeyWord> getKeywordsList() {
        return keywordsList;
    }

    /**
     * Sets the keywords list.
     *
     * @param keywordsList keywords list
     */
     
    public void setKeywordsList(List<KeyWord> keywordsList) {
        this.keywordsList = keywordsList;
    }

    /**
     * Sets the exhibitor.
     *
     * @param exhibitor exhibitor
     */
    
    public void setExhibitor(Exhibitor exhibitor) {
        this.exhibitor = exhibitor;
    }

    /**
     * Gets the exhibition area.
     *
     * @return the exhibition's area
     */
    public float getExhibitorArea() {
        return this.exhibitorArea;
    }

    /**
     * Gets the number of invitations.
     *
     * @return the number of invitations
     */
    @Override
    public int getNumberInvitations() {
        return this.numberInvitations;
    }

    /**
     * Gets the procuts list.
     *
     * @return the product's list
     */
    @Override
    public List<Product> getProductsList() {
        return this.productsList;
    }

    /**
     * Gets the evaluations list.
     *
     * @return the evaluations list
     */
    @Override
    public List<Evaluation> getEvaluationsList() {
        return this.evaluationsList;
    }

    /**
     * Sets the exhibition's area.
     *
     * @param exhibitorArea sets exhibitor area
     */
   
    public void setExhibitorArea(float exhibitorArea) {
        this.exhibitorArea = exhibitorArea;
    }

    /**
     * Sets the number of invitations.
     *
     * @param numberInvitations sets number of invitations
     */
   
    public void setNumberInvitations(int numberInvitations) {
        this.numberInvitations = numberInvitations;
    }

    /**
     * Sets the products list.
     *
     * @param productsList products list
     */
    
    public void setProductsList(List<Product> productsList) {
        this.productsList = new ArrayList(productsList);
    }

    /**
     * Sets the application evaluations list.
     *
     * @param applicationsList the applications list
     */
    
    public void setApplicationEvaluationsList(List<DemonstrationApplication> applicationsList) {
        this.evaluationsList = new ArrayList(applicationsList);
    }

    /**
     * Returns the textual interpretation of the objects and attributes of this
     * class
     *
     * @return textual representation of this application
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("DemonstrationApplication{");
        s.append(String.format("%f%n", this.title));
        s.append(String.format("%f%n", this.exhibitor));
        s.append(String.format("%f%n", this.exhibitorArea));
        s.append(String.format("%d%n", this.numberInvitations));
        for (Product prod : productsList) {
            s.append(String.format("%s%n", prod));
        }
        for (Evaluation appl : evaluationsList) {
            s.append(String.format("%s%n", appl));
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
        DemonstrationApplication otherDemonstrationApplication = (DemonstrationApplication) otherObject;

        return this.title.equals(otherDemonstrationApplication.title) && this.exhibitor.equals(otherDemonstrationApplication.exhibitor)
                && this.evaluationsList.equals(otherDemonstrationApplication.evaluationsList)
                && this.productsList.equals(otherDemonstrationApplication.productsList) && this.exhibitorArea == otherDemonstrationApplication.exhibitorArea
                && this.numberInvitations == otherDemonstrationApplication.numberInvitations;
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

    /**
     * Gets the application current state.
     *
     * @return application current state
     */
    @Override
    public ApplicationState getCurrentState() {
        return currentState;
    }

    /**
     * Sets the application current state.
     *
     * @param newState new stateto be setted
     */
    @Override
    public void setState(ApplicationState newState) {
        this.currentState = newState;
    }

    /**
     * Verify if this demonstation is valid.
     *
     * @return true if it is valid, false otherwise
     */
    @Override
    public boolean isValid() {
        //TODO review this
        return this.title != null && this.exhibitor != null
                && this.currentState != null && this.evaluationsList != null
                && this.exhibitorArea > 0 && this.numberInvitations > 0
                && this.productsList != null;
    }

    /**
     * Set the current state of the demonstration application to
     * inEvaluationState
     */
    @Override
    public void setInEvaluation() {
        this.currentState.setInEvaluation();
    }

    /**
     * Gets the demonstation application title.
     *
     * @return title of the demonstration application
     */
    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public float getArea() {
        return this.exhibitorArea;
    }

}
