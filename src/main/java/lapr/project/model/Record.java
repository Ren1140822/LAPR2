/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents the recods of all application's evaluations.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class Record {

    /**
     * A list of staff that has already evaluated at least one application.
     */
    private final List<StaffMember> staffList;

    /**
     * List of all applications evaluated (for all exhibitions).
     */
    private final List<Application> applicationsList;

    /**
     * Matrix with evaluations from a Staff Member to Application (Each line is
     * a Staff Member each column is a Application) eg. | A1 | A2 | A3 S1 | 2,3
     * | 3,4 | N/A S2 | 3,6 | 4,2 | 3,2
     */
    private Float[][] evaluationsMatrix;

    /**
     * Default constructor of a Record.
     */
    public Record() {

        this.staffList = new ArrayList<>();
        this.applicationsList = new ArrayList<>();
        this.evaluationsMatrix = new Float[0][0];
    }

    /**
     * Constructor of a Record class recieving its attributes by parameters.
     *
     * @param staffList the staff list
     * @param applicationsList applications list
     * @param evaluationsMatrix evaluations matrix
     */
    public Record(List<StaffMember> staffList, List<Application> applicationsList, Float[][] evaluationsMatrix) {

        this.staffList = new ArrayList<>(staffList);
        this.applicationsList = new ArrayList<>(applicationsList);
        this.evaluationsMatrix = evaluationsMatrix.clone();
    }

    /**
     * Copy Contructor of a Record.
     *
     * @param record the record to copy
     */
    public Record(Record record) {

        this.staffList = new ArrayList<>(record.staffList);
        this.applicationsList = new ArrayList<>(record.applicationsList);
        this.evaluationsMatrix = record.evaluationsMatrix.clone();
    }

    /**
     * Return the textual representation of the record.
     *
     * @return the textual representation of the record
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Record{\n\t\t|");
        for (Application application : this.applicationsList) {
            s.append(String.format("%-5s\t|", application.getDisplayInfo()));
        }
        s.append("\n");
        for (int i = 0; i < evaluationsMatrix.length; i++) {
            s.append(String.format("%-10s\t|", staffList.get(i).getUser().getUsername()));
            for (int j = 0; j < evaluationsMatrix[i].length; j++) {
                s.append(String.format("%-10.2f\t|", evaluationsMatrix[i][j]));
            }
            s.append("\n");
        }
        s.append("\n}");
        return s.toString();
    }

    /**
     * Compares two record objects.
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
        Record otherRecord = (Record) otherObject;

        return this.applicationsList.equals(otherRecord.applicationsList)
                && this.staffList.equals(otherRecord.staffList)
                && Arrays.equals(this.evaluationsMatrix, otherRecord.evaluationsMatrix);
    }
    
    /**
     * Add a given evaluation to the evaluations matrix.
     * 
     * @param average average of the evaluation to be added
     * @param staffMember staff member which evaluate the application
     * @param application evaluated application
     */
    public void addEvaluation(float average, StaffMember staffMember, Application application) {
        int row; // Staff Member
        int column; // Application
        
        // gets the staff row
        if (this.staffList.contains(staffMember)) {
            row = this.staffList.indexOf(staffMember);
        }else{
            this.staffList.add(staffMember);
            row = this.staffList.indexOf(staffMember);
        }
        
        // gets the application row
        if (this.applicationsList.contains(application)) {
            column = this.applicationsList.indexOf(application);
        }else{
            this.applicationsList.add(application);
            column = this.applicationsList.indexOf(application);
        }
        
        updateEvaluationsMatrix(average, row, column);
        
    }

    /**
     * Updates the evaluation matrix.
     * 
     * @param average average of the evaluation to be added
     * @param row staff member which evaluate the application
     * @param column evaluated application
     */
    private void updateEvaluationsMatrix(float average, int row, int column) {
        if (this.evaluationsMatrix.length < row+1 || this.evaluationsMatrix[0].length < column+1) { // update the matrix sixe
            Float[][] newEvaluationsMatrix = new Float[row+1][column+1];
            for (int i = 0; i < this.evaluationsMatrix.length; i++) {
                for (int j = 0; j < this.evaluationsMatrix[0].length; j++) {
                    
                    newEvaluationsMatrix[i][j] = this.evaluationsMatrix[i][j];
                    
                }
            }
            newEvaluationsMatrix[row][column] = average;
            this.evaluationsMatrix = newEvaluationsMatrix;
        } else{
            this.evaluationsMatrix[row][column] = average;
        }
    }

    public static void main(String[] args) {

        List<StaffMember> ls = new ArrayList<>(10);
        ls.add(new StaffMember());
        ls.add(new StaffMember());
        ls.add(new StaffMember());
        ls.add(new StaffMember());
        ls.add(new StaffMember());
        ls.add(new StaffMember());
        ls.add(new StaffMember());
        ls.add(new StaffMember());
        ls.add(new StaffMember());
        ls.add(new StaffMember());

        List<Application> la = new ArrayList<>(10);
        la.add(new ExhibitionApplication());
        la.add(new ExhibitionApplication());
        la.add(new ExhibitionApplication());
        la.add(new ExhibitionApplication());
        la.add(new ExhibitionApplication());
        la.add(new ExhibitionApplication());
        la.add(new ExhibitionApplication());
        la.add(new ExhibitionApplication());
        la.add(new ExhibitionApplication());
        la.add(new ExhibitionApplication());

        float[][] matrixPrimitive = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}};
        
        Float[][] matrix = new Float[matrixPrimitive.length][matrixPrimitive[0].length];
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = matrixPrimitive[i][j];
            }
        }

        Record r = new Record(ls, la, matrix);
        System.out.println(r);
    }
}
