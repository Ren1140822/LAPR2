/**
 * Package location for UI components classes.
 */
package lapr.project.ui.components;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import lapr.project.controller.EvaluateApplicationsController;
import lapr.project.model.Evaluable;
import lapr.project.model.Evaluation;
import lapr.project.model.ExhibitionApplication;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.StaffMember;
import lapr.project.ui.EvaluateApplicationUI;

/**
 * Dialog to evaluate an application info.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class DialogEvaluateApplication extends JDialog {

    /**
     * The parent's frame.
     */
    private JFrame parentFrame;

    /**
     * The controller to evaluate applications.
     */
    private EvaluateApplicationsController evaluateApplicationsController;
    
    /**
     * The evaluable.
     */
    private Evaluable evaluable;

    /**
     * The answers list.
     */
    List<JComboBox> answersList;

    /**
     * The window title.
     */
    private static final String WINDOW_TITLE = "Evaluate Application";

    /**
     * Padding border.
     */
    final static EmptyBorder PADDING_BORDER = new EmptyBorder(10, 10, 10, 10);

    /**
     * Creates a dialog to evaluate an evaluable.
     *
     * @param evaluable the evaluable
     * @param parentFrame parent's frame
     */
    public DialogEvaluateApplication(Evaluable evaluable, EvaluateApplicationsController evaluateApplicationsController, JFrame parentFrame) {
        super(parentFrame, WINDOW_TITLE, true);

        this.parentFrame = parentFrame;
        this.evaluateApplicationsController = evaluateApplicationsController;
        this.evaluable = evaluable;

        createComponents();

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(parentFrame);
        setVisible(true);
    }

    /**
     * Creates the UI components.
     */
    private void createComponents() {
        JPanel componentsPanel = new JPanel(new BorderLayout(10, 10));

        componentsPanel.add(createQuestionsAndAnswersLabel(), BorderLayout.CENTER);
        componentsPanel.add(createButtonsLabel(), BorderLayout.SOUTH);
        componentsPanel.setBorder(PADDING_BORDER);

        add(componentsPanel);
    }

    /**
     * Creates the questions and answers panel.
     *
     * @return questions and answers panel
     */
    private JPanel createQuestionsAndAnswersLabel() {

        Evaluation evaluation = new Evaluation();

        JPanel questionsAndAnswersPanel = new JPanel(new GridLayout(evaluation.getQuestionsList().size(), 1));

        List<JLabel> questionsJList = new ArrayList<>();
        answersList = new ArrayList<>();
        Integer possibleAnswers[] = {0, 1, 2, 3, 4, 5};

        for (String question : evaluation.getQuestionsList()) {
            questionsJList.add(new JLabel(String.format("Q: %s", question)));
            answersList.add(new JComboBox<Integer>(possibleAnswers));
        }

        for (int i = 0; i < questionsJList.size(); i++) {
            JPanel questionAnswersPanel = new JPanel();
            questionAnswersPanel.add(questionsJList.get(i));
            questionAnswersPanel.add(this.answersList.get(i));
            questionsAndAnswersPanel.add(questionAnswersPanel);

        }

        return questionsAndAnswersPanel;
    }

    /**
     * Creates the buttons label.
     *
     * @return buttons label
     */
    private JPanel createButtonsLabel() {
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2, 10, 0));

        buttonsPanel.add(createSubmitEvaluationButton());
        buttonsPanel.add(createCancelButton());

        return buttonsPanel;
    }

    /**
     * Creates the submit evaluation button.
     *
     * @return submit evaluation button
     */
    private JButton createSubmitEvaluationButton() {
        JButton submitEvaluationButton = new JButton("Submeter Avaliação");

        submitEvaluationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // TODO register evaluation
            }
        });

        return submitEvaluationButton;
    }

    /**
     * Creates the cancel button.
     *
     * @return cancel button
     */
    private JButton createCancelButton() {
        JButton cancelButton = new JButton("Cancel");

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        return cancelButton;
    }

    public static void main(String[] args) {
        new  DialogEvaluateApplication(new ExhibitionApplication(), new EvaluateApplicationsController(new ExhibitionCenter()), new EvaluateApplicationUI(new ExhibitionCenter(), new StaffMember()));
    }

}
