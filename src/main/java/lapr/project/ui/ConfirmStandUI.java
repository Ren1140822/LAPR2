/**
 * Package location for UI classes.
 */
package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import lapr.project.controller.ConfirmStandController;
import lapr.project.model.ExhibitionApplication;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitorResponsible;
import lapr.project.ui.components.DialogSeeApplication;
import lapr.project.ui.components.ModelListExhibitionApplications;
import lapr.project.utils.DefaultInstantiator;

/**
 * Graphic user interface to confirm stands.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ConfirmStandUI extends JFrame {

    /**
     * The define stand controller.
     */
    private final ConfirmStandController controller;

    /**
     * The logged exhibitor responsible.
     */
    private final ExhibitorResponsible exhibitorResponsible;

    /**
     * The exhibition center.
     */
    private final ExhibitionCenter exhibitionCenter;

    /**
     * The exhibition applications list.
     */
    private List<ExhibitionApplication> exhibitionApplicationsList;

    /**
     * Exhibition applications JList.
     */
    private JList exhibitionApplicationsJList;

    /**
     * See application button.
     */
    private JButton seeApplicationButton;

    /**
     * Evaluate application button.
     */
    private JButton decideStandButon;

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
     * Creates an instance of define stand user interface.
     *
     * @param exhibitionCenter the exhibition center
     * @param exhibitorResponsible the exhibitor responsible logged in
     */
    public ConfirmStandUI(ExhibitionCenter exhibitionCenter, ExhibitorResponsible exhibitorResponsible) {
        super(WINDOW_TITLE);

        this.exhibitionCenter = exhibitionCenter;
        this.exhibitorResponsible = exhibitorResponsible;
        this.controller = new ConfirmStandController(this.exhibitionCenter, this.exhibitorResponsible);

        this.exhibitionApplicationsList = controller.getExhibitionApplicationsByExhibitorResponsible();

        createComponents();

        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setSize(WINDOW_DIMEMNSION);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Creates the UI components.
     */
    private void createComponents() {
        JPanel componentsPanel = new JPanel(new BorderLayout(10, 10));
        componentsPanel.add(createTitleLabel(), BorderLayout.NORTH);
        componentsPanel.add(createExhibitionApplicationsListPanel(), BorderLayout.CENTER);
        componentsPanel.add(createButtonsPanel(), BorderLayout.SOUTH);
        componentsPanel.setBorder(PADDING_BORDER);
        add(componentsPanel);
    }

    /**
     * Creates the title label.
     *
     * @return title label
     */
    private JLabel createTitleLabel() {
        return new JLabel("Select an application to confirm the stand:", SwingConstants.CENTER);
    }

    /**
     * Creates the exhibition applications panel.
     *
     * @return exhibition applications panel
     */
    private JPanel createExhibitionApplicationsListPanel() {
        JPanel exhibitionApplicationsListPanel = new JPanel(new BorderLayout());

        this.exhibitionApplicationsJList = new JList();
        this.exhibitionApplicationsJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.exhibitionApplicationsJList.setModel(new ModelListExhibitionApplications(this.exhibitionApplicationsList));

        this.exhibitionApplicationsJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        JScrollPane exhibitionApplicationsJScrollPane = new JScrollPane(this.exhibitionApplicationsJList);
        exhibitionApplicationsListPanel.add(exhibitionApplicationsJScrollPane, BorderLayout.CENTER);

        return exhibitionApplicationsListPanel;
    }

    /**
     * Creates the buttons panel.
     *
     * @return buttons panel
     */
    private JPanel createButtonsPanel() {
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        buttonsPanel.add(createSeeApplicationButton());
        buttonsPanel.add(createConfirmStandButton());
        buttonsPanel.add(createBackButton());

        return buttonsPanel;
    }

    /**
     * Creates the see application button.
     *
     * @return see application button
     */
    private JButton createSeeApplicationButton() {
        this.seeApplicationButton = new JButton("See Application");
        this.seeApplicationButton.setEnabled(false);

        this.seeApplicationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO validate
                new DialogSeeApplication(ConfirmStandUI.this.exhibitionApplicationsList
                        .get(ConfirmStandUI.this.exhibitionApplicationsJList.getSelectedIndex()),
                        ConfirmStandUI.this);
            }
        });

        return this.seeApplicationButton;
    }

    /**
     * Creates the confirm stand button.
     *
     * @return confirm stand button
     */
    private JButton createConfirmStandButton() {
        this.decideStandButon = new JButton("Decide Application");
        this.decideStandButon.setEnabled(false);

        this.decideStandButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        return this.decideStandButon;
    }

    /**
     * Creates the back button.
     *
     * @return back button
     */
    private JButton createBackButton() {
        JButton backButton = new JButton("Back");

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                // TODO go to the last naviagble window
            }
        });

        return backButton;
    }

    /**
     * Starting method for testing purposes.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        ExhibitionCenter ec = DefaultInstantiator.createExhibitionCenter();
        ExhibitorResponsible er = ((ExhibitionApplication) ec.getExhibitionsRegister().getExhibitionsList().get(0).getApplicationsList().getApplicationsList().get(0)).getExhibitor().getExhibitorResponsible();
        new ConfirmStandUI(ec, er);
    }
}
