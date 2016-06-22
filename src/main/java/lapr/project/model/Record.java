/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.util.ArrayList;
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
    private List<StaffMember> staffList;

    /**
     * List of all applications evaluated (for all exhibitions).
     */
    private List<Application> applicationsList;

    /**
     * Matrix with evaluations from a Staff Member to Application (Each line is
     * a Staff Member each column is a Application) eg. | A1 | A2 | A3 S1 | 2,3
     * | 3,4 | N/A S2 | 3,6 | 4,2 | 3,2
     */
    private float[][] evaluationsMatrix;

    /**
     * Default constructor of a Record.
     */
    public Record() {

        this.staffList = new ArrayList<>();
        this.applicationsList = new ArrayList<>();
        this.evaluationsMatrix = new float[0][0];
    }

    /**
     * Constructor of a Record class recieving its attributes by parameters.
     *
     * @param staffList the staff list
     * @param applicationsList applications list
     * @param evaluationsMatrix evaluations matrix
     */
    public Record(List<StaffMember> staffList, List<Application> applicationsList, float[][] evaluationsMatrix) {

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
                && this.evaluationsMatrix.equals(otherRecord.evaluationsMatrix);
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

        float[][] matriz = {
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

        Record r = new Record(ls, la, matriz);
        System.out.println(r);
    }
}
