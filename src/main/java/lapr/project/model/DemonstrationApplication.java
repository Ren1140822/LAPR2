/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an demonstration application
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Amaral 1151231
 */
public class DemonstrationApplication {

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
     * the evaluation lists of this application
     */
    private List<DemonstrationEvaluation> applicationEvaluationsList;

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
    public DemonstrationApplication() {
        this.companyName = DEFAULT_COMPANY_NAME;
        this.companyAddress = DEFAULT_COMPANY_ADDRESS;
        this.companyCellphone = DEFAULT_COMPANY_CELLPHONE;
        this.exhibitorArea = DEFAULT_EXHIBITOR_AREA;
        this.numberInvitations = DEFAULT_NUMBER_INVITATION;
        this.productList = new ArrayList<Product>();
        this.applicationEvaluationsList = new ArrayList<DemonstrationEvaluation>();
    }

    /**
     * the constructor with parameters
     *
     * @param companyName
     * @param companyAddress
     * @param companyCellphone
     * @param exhibitorArea
     * @param numberInvitations
     * @param productList
     * @param applicationsList
     */
    public DemonstrationApplication(String companyName, String companyAddress, String companyCellphone, float exhibitorArea,
            int numberInvitations, List<Product> productList, List<DemonstrationApplication> applicationsList) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyCellphone = companyCellphone;
        this.exhibitorArea = exhibitorArea;
        this.numberInvitations = numberInvitations;
        this.productList = new ArrayList(productList);

        this.applicationEvaluationsList = new ArrayList(applicationsList);

    }

    /**
     * the copy constructor receiving instance of this class as parameter
     */
    public DemonstrationApplication(DemonstrationApplication exhApplication) {
        this.companyName = exhApplication.companyName;
        this.companyAddress = exhApplication.companyAddress;
        this.companyCellphone = exhApplication.companyCellphone;
        this.exhibitorArea = exhApplication.exhibitorArea;
        this.numberInvitations = exhApplication.numberInvitations;
        this.productList = new ArrayList(exhApplication.productList);
        this.applicationEvaluationsList = new ArrayList(exhApplication.applicationEvaluationsList);
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
     * @return the product list
     */
    public List<Product> getProductList() {
        return this.productList;
    }

    /**
     *
     * @return the applications list
     */
    public List<DemonstrationEvaluation> getApplicationEvaluationsList() {
        return this.applicationEvaluationsList;
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
     * @param productsList
     * @param productList sets the products list
     */
    public void setProductsList(List<Product> productsList) {
        this.productList = new ArrayList(productsList);
    }

    /**
     * @param applicationsList sets the applications list
     */
    public void setApplicationEvaluationsList(List<DemonstrationApplication> applicationsList) {
        this.applicationEvaluationsList = new ArrayList(applicationsList);
    }

    /**
     * Returns the textual interpretation of the objects and attributes of this
     * class
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("DemonstrationApplication{");
        s.append(String.format("%s%n", this.companyName));
        s.append(String.format("%s%n", this.companyAddress));
        s.append(String.format("%s%n", this.companyCellphone));
        s.append(String.format("%f%n", this.exhibitorArea));
        s.append(String.format("%d%n", this.numberInvitations));
        for (Product prod : productList) {
            s.append(String.format("%s%n", prod));
        }
        for (DemonstrationEvaluation appl : applicationEvaluationsList) {
            s.append(String.format("%s%n", appl));
        }
        s.append("}");
        return s.toString();
    }
}
