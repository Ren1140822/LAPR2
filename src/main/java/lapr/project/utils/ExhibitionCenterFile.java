/**
 * Package location for Pure Fabrication util classes.
 */
package lapr.project.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import lapr.project.model.ExhibitionCenter;

/**
 * Read and write the exhibition center data from a binary file.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ExhibitionCenterFile {

    /**
     * Name of the file.
     */
    public static final String NAME = "ExhibitionCenter.bin";

    /**
     * Read a binary file with the exhibition center and returns the exhibition
     * center.
     *
     * @param fileName name of the binary file
     * @return exhibition center
     */
    public static ExhibitionCenter read(String fileName) {
        ExhibitionCenter exhibitionCenter;
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(fileName));
            try {
                exhibitionCenter = (ExhibitionCenter) in.readObject();
            } finally {
                in.close();
            }
            return exhibitionCenter;
        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
    }

    /**
     * Saves the exhibition center data in a binary file.
     *
     * @param fileName name of the file to be saved
     * @param exhibitionCenter exhibition center
     * @return true if it is successful saved, false otherwise
     */
    public static boolean guardar(String fileName, ExhibitionCenter exhibitionCenter) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(fileName));
            try {
                out.writeObject(exhibitionCenter);
            } finally {
                out.close();
            }
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}
