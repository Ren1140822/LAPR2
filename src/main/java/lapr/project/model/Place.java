/**
 * Package location for Model concepts.
 */
package lapr.project.model;

/**
 * Represents a place.
 * 
 * @author Ricardo Correia 1151231
 */
public class Place {
    
    /** 
     * The place location.
     */
    private String location;
    
    /**
     * The place location by default.
     */
    private static final String DEFAULT_LOCATION = "default location";
    
    /**
     * Default constructor of a place class.
     */
    public Place(){
        this.location = DEFAULT_LOCATION;
    }
    
    /**
     * Constructor that receives an instance of this class as parameter.
     * 
     * @param location places location
     */
    public Place(String location){
        this.location = location;
    }
    
    /**
     * Obtain the places location.
     * 
     * @return places location
     */
    public String getLocation(){
        return location;
    }
    
    /**
     * Set the places location.
     * 
     * @param location the places location to set
     */
    public void setLocation(String location){
        this.location = location;
    }
    
    /**
     * Return the textual representation of a place.
     * 
     * @return the textual representation of a place
     */
    @Override
    public String toString(){
        return String.format("Place{%nlocation=%s%n", this.location);
    }
}
