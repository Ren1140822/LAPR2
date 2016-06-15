/**
 * Package location for UI concepts.
 */
package lapr.project.ui;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import lapr.project.controller.AssignApplicationController;
import lapr.project.model.Application;
import lapr.project.model.ApplicationsList;
import lapr.project.model.Demonstration;
import lapr.project.model.DemonstrationApplication;
import lapr.project.model.DemonstrationsList;
import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionApplication;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitionsRegister;
import lapr.project.model.MechanismsRegister;
import lapr.project.model.Organizer;
import lapr.project.model.OrganizersList;
import lapr.project.model.StaffAttribution;
import lapr.project.model.StaffAttributionMechanism;
import lapr.project.model.StaffList;
import lapr.project.model.StaffMember;
import lapr.project.model.Submittable;
import lapr.project.model.User;
import lapr.project.model.demonstration.DemonstrationInChangedConflictsState;
import lapr.project.model.exhibition.ExhibitionChangedConflictsState;
import lapr.project.model.mechanisms.EquitableLoadMechanism;
import lapr.project.ui.components.DialogSelectSubmittable;
import lapr.project.ui.components.ModelListMechanisms;
import lapr.project.ui.components.ModelTableAttributions;

/**
 * Graphical interface for attributions(to assign) of applications.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class AssignApplicationUI extends JFrame{

    /**
     * Exhibitions Center.
     */
    private final ExhibitionCenter exhibitionsCenter;
    /**
     * Controller to assign applications.
     */
    private final AssignApplicationController controller;
    /**
     * Selected exhibition.
     */
    private Submittable exhibitionSelected;
    /**
     * List of staff attributions mechanism list.
     */
    private List<StaffAttributionMechanism> staffAttributionMechanismList;
    /**
     * List of staff attributions.
     */
    private List<StaffAttribution> staffAttributionList;

    /**
     * private JList jListMechanismsUI.
     */
    private JList jListMechanismsUI;
    /**
     * Botão para gerar mecanismos.
     */
    private JButton jbtnGenerate;
    /**
     * Tabela UI para expor as atribuições geradas.
     */
    private JTable jTableAttributionsUI;

    /**
     * Dimensão da janela.
     */
    final Dimension WINDOW_SIZE = new Dimension(800, 600);
    /**
     * Margens dos campos.
     */
    final int SUP_WINDOW_EDGE = 0, INF_WINDOW_EDGE = 0,
            LEFT_WINDOW_EDGE = 10, RIGHT_WINDOW_EDGE = 0;
    /**
     * Border vazio para criar insets.
     */
    final static EmptyBorder PADDING_BORDER = new EmptyBorder(10, 10, 10, 10);
    
    final  static String EXHIBITION_CENTER_TITLE = "Exhibitions Center";

    /**
     * Constroi uma instância de AtribuirCandidaturaUI.
     *
     * @param exhibitionsCenter Centro de Exposições
     * @param organizer Organizador que iniciou a sessão
     */
    public AssignApplicationUI(ExhibitionCenter exhibitionsCenter, Organizer organizer) {
        super(EXHIBITION_CENTER_TITLE);

        this.exhibitionsCenter = exhibitionsCenter;
        this.controller = new AssignApplicationController(exhibitionsCenter, organizer);

        List<Submittable> listaExposicoes = this.controller.getSubmittablesInChangedConflictsByOrganizer(organizer);
        new DialogSelectSubmittable(this, listaExposicoes, exhibitionsCenter);
        if (this.exhibitionSelected == null) {
            dispose();
        } else {

            this.controller.setSubmittable(this.exhibitionSelected);
            this.staffAttributionMechanismList = this.controller.getStaffAttributionMechanism();
            this.staffAttributionList = new ArrayList<>();

            createComponents();

            pack();
            setSize(WINDOW_SIZE);
            setMinimumSize(new Dimension(getWidth(), getHeight()));
            setLocationRelativeTo(null);
            setVisible(true);
        }

    }

    /**
     * Cria os componentes da janela.
     */
    private void createComponents() {

        setLayout(new BorderLayout(10, 20));
        add(createWestPanel(), BorderLayout.WEST);
        add(createEastPanel(), BorderLayout.CENTER);
        add(createJpanelBtnConfirm(), BorderLayout.SOUTH);
    }

    /**
     * Cria o painel com a lista de mecanismos e o botão gerar.
     *
     * @return o painel com a lista de mecanismos e o botão gerar
     */
    private JPanel createWestPanel() {

        JPanel jPanel = new JPanel(new BorderLayout(10, 10));
        jPanel.setBorder(PADDING_BORDER);

        JPanel pBtnGenerate = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pBtnGenerate.add(createBtnGenerate());

        jPanel.add(createMechanismsScrollPane(), BorderLayout.CENTER);
        jPanel.add(pBtnGenerate, BorderLayout.SOUTH);

        return jPanel;
    }

    /**
     * Cria o painel com a tabela de atribuições.
     *
     * @return o painel com a tabela de atribuições
     */
    private JPanel createEastPanel() {

        JPanel jPanel = new JPanel(new GridLayout());
        jPanel.setBorder(PADDING_BORDER);

        jPanel.add(createAttributionsScrollPane());
        return jPanel;
    }

    /**
     * cria o painel scroll que incorpora a lista de mecanismos.
     *
     * @return o painel scroll que incorpora a lista de mecanismos
     */
    private JPanel createMechanismsScrollPane() {

        JPanel jPanelScroll = new JPanel(new GridLayout());
        jPanelScroll.setBorder(BorderFactory.createTitledBorder(PADDING_BORDER,
                "Select the desired mechanism:", TitledBorder.LEFT, TitledBorder.TOP));

        this.jListMechanismsUI = new JList(new ModelListMechanisms(this.staffAttributionMechanismList));
        this.jListMechanismsUI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.jListMechanismsUI.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {

                jbtnGenerate.setEnabled((!jListMechanismsUI.isSelectionEmpty()));
            }
        });

        JScrollPane jScrollPane = new JScrollPane(this.jListMechanismsUI);
        jScrollPane.setBorder(PADDING_BORDER);

        jPanelScroll.add(jScrollPane);

        return jPanelScroll;
    }

    /**
     * cria o painel scroll que incorpora a tabela de atribuições.
     *
     * @return o painel scroll que incorpora a tabela de atribuições
     */
    private JPanel createAttributionsScrollPane() {

        JPanel jPanelScroll = new JPanel(new GridLayout());
        jPanelScroll.setBorder(BorderFactory.createTitledBorder(PADDING_BORDER,
                "Check the Assignments list:", TitledBorder.LEFT, TitledBorder.TOP));

        this.jTableAttributionsUI = new JTable();
        this.jTableAttributionsUI.setVisible(false);

        JScrollPane scrollPane = new JScrollPane(this.jTableAttributionsUI);
        scrollPane.setBorder(PADDING_BORDER);

        jPanelScroll.add(scrollPane);

        return jPanelScroll;
    }

    /**
     * Cria o botão gerar atribuições.
     *
     * @return o botão gerar atribuições
     */
    private JButton createBtnGenerate() {
        this.jbtnGenerate = new JButton("Generate Assignments(Attributions)");
        this.jbtnGenerate.setEnabled(false);
        this.jbtnGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = jListMechanismsUI.getSelectedIndex();
                controller.setStaffAttributionMechanism(staffAttributionMechanismList.get(row));
                staffAttributionList = controller.getAttributionsList();
                jTableAttributionsUI.setModel(new ModelTableAttributions(staffAttributionList));
                jTableAttributionsUI.setVisible(true);
            }
        });
        return this.jbtnGenerate;
    }

    /**
     * Cria o painel com os botões confirmar e cancelar.
     *
     * @return o painel com os botões confirmar e cancelar
     */
    private JPanel createJpanelBtnConfirm() {
        JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jPanel.add(createBtnConfirm());
        jPanel.add(createBtnCancel());

        return jPanel;
    }

    /**
     * Cria o botão confirmar.
     *
     * @return o botão confirmar
     */
    private JButton createBtnConfirm() {
        JButton btn = new JButton("Confirm");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (staffAttributionList.size() < 1) {
                        throw new IllegalArgumentException("You have to generate the assignments(attributions) first!.");
                    }

                    String message = "Do you confirm the assignments(attributions)?";
                    int confirm = JOptionPane.showConfirmDialog(rootPane, message);

                    if (confirm == JOptionPane.YES_OPTION) {
                        controller.staffAttributionsRegister(staffAttributionList);
                        dispose();
                        // TODO : Implement after use case is finished.

                    }

                } catch (IllegalArgumentException ex) {

                    JOptionPane.showMessageDialog(
                            rootPane,
                            ex.getMessage(),
                            "Assign Applications",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        return btn;
    }

    /**
     * Cria o botão cancelar.
     *
     * @return o botão cancelar
     */
    private JButton createBtnCancel() {

        JButton btn = new JButton("Cancel");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                // TODO : Implement after use case is finished.
            }
        });
        return btn;
    }

    /**
     * Modifica a exposição selecionada.
     *
     * @param exhibition exposição selecionada.
     */
    
    public void setExposicao(Submittable exhibition) {

        this.exhibitionSelected = exhibition;
    }
    
    public static void main(String[] args) {
        
        Organizer organizer = new Organizer(new Organizer(new User("Renato", "Paulinho", "pr@email.com", "password")));
        StaffMember staffMember1 = new StaffMember(new User("Daniel", "Dani", "Daniel@gmail.com", "password"));
        StaffMember staffMember2 = new StaffMember(new User("Eric", "Thor", "Eric@gmail.com", "password"));
        StaffMember staffMember3 = new StaffMember(new User("Ivo", "Ferro", "Ivo@gmail.com", "password"));
        List<StaffMember> staffMemberList = new ArrayList<>();
        staffMemberList.add(staffMember1);
        staffMemberList.add(staffMember2);
        staffMemberList.add(staffMember3);
        
        List<Application> exhibitionApplicationsList = new ArrayList();
        List<Application> demonstrationApplicationsList = new ArrayList();
        
        ExhibitionApplication exhibitionApplication1 = new ExhibitionApplication();
        exhibitionApplication1.setTitle("Dutch vegetables");
        ExhibitionApplication exhibitionApplication2 = new ExhibitionApplication();
        exhibitionApplication2.setTitle("Dutch ducks");
        ExhibitionApplication exhibitionApplication3 = new ExhibitionApplication();
        exhibitionApplication3.setTitle("Dutch flowers");
        
        exhibitionApplicationsList.add(exhibitionApplication1);
        exhibitionApplicationsList.add(exhibitionApplication2);
        exhibitionApplicationsList.add(exhibitionApplication3);
        
        DemonstrationApplication demonstrationApplication1 = new DemonstrationApplication();
        demonstrationApplication1.setTitle("Dutch vegetables");
        DemonstrationApplication demonstrationApplication2 = new DemonstrationApplication();
        demonstrationApplication1.setTitle("Dutch midget ducks");
        DemonstrationApplication demonstrationApplication3 = new DemonstrationApplication();
        demonstrationApplication1.setTitle("Dutch red flowers");
        
        demonstrationApplicationsList.add(demonstrationApplication1);
        demonstrationApplicationsList.add(demonstrationApplication2);
        demonstrationApplicationsList.add(demonstrationApplication3);
        
        ExhibitionCenter exhibitionCenter = new ExhibitionCenter();
        Exhibition exhibition = new Exhibition();
        exhibition.setTitle("Dutch stuff");
        
        List<StaffAttributionMechanism> attributionsList = new ArrayList<>();
        attributionsList.add(new EquitableLoadMechanism());
        MechanismsRegister mechanismsRegister = new MechanismsRegister(attributionsList);
        exhibitionCenter.setMechanismsRegister(mechanismsRegister);
        
        List<Organizer> organizersList = new ArrayList<>();
        organizersList.add(organizer);
        exhibition.setOrganizersList(new OrganizersList(organizersList));
        
        Demonstration demonstration = new Demonstration();
        demonstration.setStaffList(new StaffList(staffMemberList));
        demonstration.setCurrentState(new DemonstrationInChangedConflictsState(demonstration));
        List<Demonstration> demonstrationsList = new ArrayList();
        demonstrationsList.add(demonstration);
        DemonstrationsList demonstrationsRegister = new DemonstrationsList(demonstrationsList);
        exhibition.setDemonstrationsList(demonstrationsRegister);
        List<Exhibition> exhibitionsList = new ArrayList();
        exhibition.setState(new ExhibitionChangedConflictsState(exhibition));
        exhibition.setStaffList(new StaffList(staffMemberList));
        
        Exhibition exhibitionInNotCorrectState = new Exhibition();
        
        exhibition.setApplicationsList(new ApplicationsList(exhibitionApplicationsList));
        
        exhibitionsList.add(exhibition);
        exhibitionsList.add(exhibitionInNotCorrectState);
        ExhibitionsRegister exhibitionsRegister = new ExhibitionsRegister(exhibitionsList);
        exhibitionCenter.setExhibitionsRegister(exhibitionsRegister);
        
        new AssignApplicationUI(exhibitionCenter, organizer);
    }
}
