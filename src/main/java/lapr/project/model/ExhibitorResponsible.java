/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 * Represents an exhibitor responsible
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Amaral 1151231
 */
public class ExhibitorResponsible {
    
/**
 * the instance of user in this class
 */
    private User user;
    
      /**
     * Builds instances of ExhibitorResponsible with no params.
     */
      public ExhibitorResponsible(){
        this.user=new User();
    }
   
    
    
      /**
     * Builds instances of ExhibitorResponsible receiving an ExhibitorResponsible as param.
     */
//    public ExhibitorResponsible(ExhibitorResponsible exhibitor){
//        this.user = new User(exhibitor.user);
//    }
    
    
    /**
     * Builds instances of ExhibitorResponsible receiving an user as param.
     */
//    public ExhibitorResponsible(User user){
//        this.user=new User(user);
//    }
    
    
    /**
     * returns this instance of user.
     */
    public User getUser(){
        return this.user;
    }
    
    /**
     * sets the current value of this user
     */
//    public void setUSer(User u){
//        this.user = new User(u);
//    }
    
    /**
     * Returns the textual representation of the attributes of this class.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("ExhibitorResponsible{");

        s.append(String.format("%s%n", this.user));

        s.append("}");
        return s.toString();
    }
}
