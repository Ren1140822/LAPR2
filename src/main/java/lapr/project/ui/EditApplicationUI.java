/**
 * Package location for UI classes.
 */
package lapr.project.ui;

import java.awt.Dimension;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import lapr.project.controller.EditApplicationController;
import lapr.project.model.Editable;
import lapr.project.model.ExhibitionApplication;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitorResponsible;
import lapr.project.model.Submittable;
import lapr.project.model.application.ApplicationInSubmissionState;
import lapr.project.ui.components.DialogChooseSubmittable;
import lapr.project.utils.DefaultInstantiator;

/**
 * Graphic user interface to edit applications.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class EditApplicationUI extends JFrame {

    /**
     * The edit application controller.
     */
    private final EditApplicationController controller;

    /**
     * The logged exhibitor responsible.
     */
    private final ExhibitorResponsible exhibitorResponsible;

    /**
     * The exhibition center.
     */
    private final ExhibitionCenter exhibitionCenter;

    /**
     * The submttables list.
     */
    private List<Submittable> submittablesList;

    /**
     * The applicaiton to be edited.
     */
    private Editable editable;

    /**
     * Title for the window.
     */
    private static final String WINDOW_TITLE = "Confirm Stand";

    /**
     * Window dimension.
     */
    private static final Dimension WINDOW_DIMEMNSION = new Dimension(600, 400);

    /**
     * Padding border.
     */
    final static EmptyBorder PADDING_BORDER = new EmptyBorder(10, 10, 10, 10);

    /**
     * Creates an instance of edit application user interface.
     *
     * @param exhibitionCenter the exhibition center
     * @param exhibitorResponsible the exhibitor responsible logged in
     */
    public EditApplicationUI(ExhibitionCenter exhibitionCenter, ExhibitorResponsible exhibitorResponsible) {
        super(WINDOW_TITLE);

        this.exhibitionCenter = exhibitionCenter;
        this.exhibitorResponsible = exhibitorResponsible;
        this.controller = new EditApplicationController(this.exhibitionCenter, this.exhibitorResponsible);

        this.submittablesList = this.controller.getSubmittablesByExhibitorResponsible();

        final String chooseSubmittableText = "Which exhibition/demonstration you wish to edit the application?";
        DialogChooseSubmittable dialogChooseSubmittable = new DialogChooseSubmittable(this, this.submittablesList, chooseSubmittableText);
        Submittable selectedSubmittable = dialogChooseSubmittable.getSelectedSubmitable();
        
        if (selectedSubmittable == null) {
            // TODO voltar à janela anterior.
            dispose();
        }
        
        this.controller.setSubmittable(selectedSubmittable);
        this.editable = this.controller.cloneEditable();
        
    }

    /**
     * Starting method for testing purposes.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        ExhibitionCenter ec = DefaultInstantiator.createExhibitionCenter();
        ExhibitorResponsible er = ((ExhibitionApplication) ec.getExhibitionsRegister().getExhibitionsList().get(0).getApplicationsList().getApplicationsList().get(0)).getExhibitor().getExhibitorResponsible();
        ((ExhibitionApplication) ec.getExhibitionsRegister().getExhibitionsList().get(0).getApplicationsList().getApplicationsList()
                .get(0)).setState(new ApplicationInSubmissionState(ec.getExhibitionsRegister().getExhibitionsList().get(0)
                .getApplicationsList().getApplicationsList().get(0)));
        new EditApplicationUI(ec, er);
    }

}
