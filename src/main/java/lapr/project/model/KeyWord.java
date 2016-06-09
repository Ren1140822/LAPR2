/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Represents a KeyWord.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class KeyWord {

    /**
     * the description of this keyword
     */
    private String description;

    /**
     * default value of description
     */
    private static final String DEFAULT_DESCRIPTION = "No description";

    /**
     * TODO: CHECK WHAT THIS DOES
     */
    private static final String ROOT_ELEMENT_NAME = "keyword";
    /**
     * TODO: CHECK WHAT THIS DOES
     */
    private static final String VALUE_ELEMENT_NAME = "value";

    /**
     * Empty constructor.
     */
    public KeyWord() {
        this.description = DEFAULT_DESCRIPTION;
    }

    /**
     * Constructor with parameters.
     *
     * @param description the keyword to define.
     */
    public KeyWord(String description) {
        this.description = new String(description);
    }

    /**
     * Copy constructor receiving another KeyWord instance.
     *
     * @param k the instance of KeyWord to copy.
     */
    public KeyWord(KeyWord k) {
        this.description = new String(k.description);
    }

    /**
     * gets the string value of description
     */
    public String getDescription() {
        return new String(this.description);
    }

    /**
     * sets the value of description
     *
     * @param description the value to set.
     */
    public void setDescription(String description) {

        this.description = new String(description);
    }

    
    /**
     * Validates the keyword.
     * @return true if is valid
     */
    public boolean validate(){
        return !this.description.isEmpty();
    }
    
    
    
    
     /**
     * Equals method to check if two objects are the same.
     * @param otherObject the other object to compare to
     * @return true of equal
     */
    public boolean equals(Object otherObject){
           if (this == otherObject) {
            return true;
        }
        if (otherObject == null || this.getClass() != otherObject.getClass()) {
            return false;
        }
       KeyWord otherKeyword = (KeyWord)otherObject;
        return this.description.equals(otherKeyword.description);
    }
    
  
    
    
    /**
     * Returns the textual interpretation of the objects and attributes of this
     * class
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("KeyWord{");
        s.append(this.description);
        s.append("}");
        return s.toString();
    }

}
