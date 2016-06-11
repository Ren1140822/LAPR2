/**
 * Package location for UI components classes.
 */
package lapr.project.ui.components;

import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.model.User;

/**
 * Model list for users.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ModelListUsers extends AbstractListModel {

    /**
     * The users list;
     */
    private final List<User> usersList;

    /**
     * Constructs a model list for user.
     * 
     * @param usersList users list
     */
    public ModelListUsers(List<User> usersList) {
        this.usersList = usersList;
    }

    
    @Override
    public int getSize() {
        return this.usersList.size();
    }

    @Override
    public Object getElementAt(int i) {
        return String.format("%s (%s)", this.usersList.get(i).getName(), this.usersList.get(i).getEmail());
    }
}
