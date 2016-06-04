/**
 * Package location for Model concepts.
 */
package lapr.project.model;

/**
 * Represents a product.
 * 
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class Product {
    
    /**
     * The product's designation.
     */
    private String designation;
    
    /**
     * The product's designation by default.
     */
    private static final String DEFAULT_DESIGNATION = "no designation";
    
    /**
     * Default constructor of a Product class.
     */
    public Product(){
        this.designation = DEFAULT_DESIGNATION;
    }
    
    /**
     * Constructor that receives an instance of this class as parameter.
     * 
     * @param designation product's designation 
     */
    public Product(String designation){
        this.designation = designation;              
    }
    
    /**
     * Obtain the product's designation.
     * 
     * @return  the product's designation
     */
    public String getDesignation(){
        return designation;
    }
    
    /**
     * Sets the product's designation.
     * 
     * @param designation the product's designation to set
     */
    public void setDesignation(String designation){
        this.designation = designation;
    }
    
    @Override
    public String toString(){
        return String.format("Product{%ndesignation=%s%n", this.designation);
    }
    
}
