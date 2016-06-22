/**
 * Package location for Login Controller concepts.
 */
package lapr.project.controller;

import lapr.project.model.ExhibitionCenter;
import lapr.project.model.User;
import lapr.project.model.UsersRegister;

/**
 * Represents a login controller
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class LoginController {

    /**
     * The exhibitions center.
     */
    ExhibitionCenter exhibitionCenter;
    /**
     * The users register.
     */
    UsersRegister usersRegister;

    /**
     * Builds instance of this class receiving an exhibition center as param.
     * @param exhibitionCenter the exhibition center
     */
    public LoginController(ExhibitionCenter exhibitionCenter) {
        this.exhibitionCenter = exhibitionCenter;
    }
    
    /**
     * Verifies if the enter information belongs to a user.
     * @param userName the username
     * @param password the password
     * @return the user
     */
    public User verifyLogin(String userName,String password){
        usersRegister = this.exhibitionCenter.getUsersRegister();
        for(User user : usersRegister.getUsersList()){
            if(userName.equals(user.getUsername())&&password.equals(user.getPassword())){
                return user;
            }
        }
        return null;
    }

}
