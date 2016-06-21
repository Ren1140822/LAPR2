/**
 * Package location for Model concepts.
 */
package lapr.project.model;

/**
 * Represents a staff member evaluations analytic compared to all staff.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class StaffMemberAnalytic {

    /**
     * The related staff member.
     */
    private StaffMember staffMember;

    /**
     * The number of applications evaluated.
     */
    private int numApplications;

    /**
     * The average value of all staff member's evaluations.
     */
    private float evaluationsAverage;

    /**
     * The average value of deviations.
     */
    private float deviationsAverage;

    /**
     * Value obtain by the hypothesis test.
     */
    private float hypothesisTestValue;

    /**
     * Warning if hypothesis test value is over the critical region.
     */
    private boolean warning;

    /**
     * The default number of applications evaluated.
     */
    private static final int DEFAULT_NUM_APPLICATIONS = 0;

    /**
     * The default average value of all staff member's evaluations.
     */
    private static final float DEFAULT_EVALUATIONS_AVG = 0.0f;

    /**
     * The default average value of deviations.
     */
    private static final float DEFAULT_DEVIATIONS_AVG = 0.0f;

    /**
     * Value default obtain by the hypothesis test.
     */
    private static final float DEFAULT_HYPOTHESIS_TEST_VALUE = 0.0f;

    /**
     * Warning default if hypothesis test value is over the critical region.
     */
    private static final boolean DEFAULT_WARNING = false;

    /**
     * Default constructor of a StaffMemberAnalytic.
     */
    public StaffMemberAnalytic() {

        this.staffMember = new StaffMember();
        this.numApplications = DEFAULT_NUM_APPLICATIONS;
        this.evaluationsAverage = DEFAULT_EVALUATIONS_AVG;
        this.deviationsAverage = DEFAULT_DEVIATIONS_AVG;
        this.hypothesisTestValue = DEFAULT_HYPOTHESIS_TEST_VALUE;
        this.warning = DEFAULT_WARNING;
    }

    /**
     * Constructor of a StaffMemberAnalytic class recieving its attributes by
     * parameters.
     *
     * @param staffMember the staff member
     * @param numApps number of applications evaluated
     * @param evaluationsAvg the average value of the evaluations
     * @param deviationsAvg the average of the deviations
     * @param hypothesisValue the hypothesis test value
     * @param warning true if in critical region, false otherwise
     */
    public StaffMemberAnalytic(StaffMember staffMember, int numApps,
            float evaluationsAvg, float deviationsAvg, float hypothesisValue,
            boolean warning) {

        this.staffMember = staffMember;
        this.numApplications = numApps;
        this.evaluationsAverage = evaluationsAvg;
        this.deviationsAverage = deviationsAvg;
        this.hypothesisTestValue = hypothesisValue;
        this.warning = warning;
    }

    /**
     * Copy Contructor of a StaffMemberAnalytic.
     *
     * @param analytic the staff member analytic to copy
     */
    public StaffMemberAnalytic(StaffMemberAnalytic analytic) {

        this.staffMember = analytic.staffMember;
        this.numApplications = analytic.numApplications;
        this.evaluationsAverage = analytic.evaluationsAverage;
        this.deviationsAverage = analytic.deviationsAverage;
        this.hypothesisTestValue = analytic.hypothesisTestValue;
        this.warning = analytic.warning;
    }

    /**
     * Obtain the related staff member.
     *
     * @return the related staff member
     */
    public StaffMember getStaffMember() {
        return staffMember;
    }

    /**
     * Set the related staff member.
     *
     * @param staffMember the staff member to set
     */
    public void setStaffMember(StaffMember staffMember) {
        this.staffMember = staffMember;
    }

    /**
     * Obtain the number of applications.
     *
     * @return the number of applications
     */
    public int getNumApplications() {
        return numApplications;
    }

    /**
     * Set the number of applications
     *
     * @param numApplications the number of applications to set
     */
    public void setNumApplications(int numApplications) {
        this.numApplications = numApplications;
    }

    /**
     * Obtain the average value of the staff members evaluations.
     *
     * @return the average value of the staff members evaluations
     */
    public float getEvaluationsAverage() {
        return evaluationsAverage;
    }

    /**
     * Set the average value of the staff members evaluations.
     *
     * @param evaluationsAverage the average value of the staff members
     * evaluations to set
     */
    public void setEvaluationsAverage(float evaluationsAverage) {
        this.evaluationsAverage = evaluationsAverage;
    }

    /**
     * Obtain the average value of the deviations.
     *
     * @return the average value of the deviations
     */
    public float getDeviationsAverage() {
        return deviationsAverage;
    }

    /**
     * Set the average value of the deviations.
     *
     * @param deviationsAverage the average value of the deviations to set
     */
    public void setDeviationsAverage(float deviationsAverage) {
        this.deviationsAverage = deviationsAverage;
    }

    /**
     * Obtain the hypothesis test value.
     *
     * @return the hypothesis test value
     */
    public float getHypothesisTestValue() {
        return hypothesisTestValue;
    }

    /**
     * Set the hypothesis test value.
     *
     * @param hypothesisTestValue the hypothesis test value to set
     */
    public void setHypothesisTestValue(float hypothesisTestValue) {
        this.hypothesisTestValue = hypothesisTestValue;
    }

    /**
     * Verify if the hypothesis test value is over the critical region.
     *
     * @return true if the hypothesis test value is over the critical region
     */
    public boolean isWarning() {
        return warning;
    }

    /**
     * Set the hypothesis test value is over the critical region.
     * 
     * @param warning the warning to set
     */
    public void setWarning(boolean warning) {
        this.warning = warning;
    }

}