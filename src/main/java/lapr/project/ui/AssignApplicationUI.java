/*
 * Fornece as classe que controlam a interface gráfica.
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
 * Interface gráfica para a atribuição de candidaturas.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class AssignApplicationUI extends JFrame{

    /**
     * Exhibitions Center.
     */
    private final ExhibitionCenter centroExposicoes;
    /**
     * Controller da Atribuição de Candidaturas.
     */
    private final AssignApplicationController controller;
    /**
     * Exposição selecionada.
     */
    private Submittable exposicaoSelecionada;
    /**
     * Lista de mecanismos de atribuição.
     */
    private List<StaffAttributionMechanism> listaMecanismos;
    /**
     * Lista de atribuições.
     */
    private List<StaffAttribution> listaAtribuicoes;

    /**
     * Lista UI para expor a lista de mecanismos.
     */
    private JList listaMecanismosUI;
    /**
     * Botão para gerar mecanismos.
     */
    private JButton btnGerar;
    /**
     * Tabela UI para expor as atribuições geradas.
     */
    private JTable attributionsTableUI;

    /**
     * Dimensão da janela.
     */
    final Dimension JANELA_TAMANHO = new Dimension(800, 600);
    /**
     * Margens dos campos.
     */
    final int MARGEM_S_CAMPO = 0, MARGEM_I_CAMPO = 0,
            MARGEM_E_CAMPO = 10, MARGEM_D_CAMPO = 0;
    /**
     * Border vazio para criar insets.
     */
    final static EmptyBorder PADDING_BORDER = new EmptyBorder(10, 10, 10, 10);
    
    final  static String EXHIBITION_CENTER_TITLE = "Centro de Exposições";

    /**
     * Constroi uma instância de AtribuirCandidaturaUI.
     *
     * @param centroExposicoes Centro de Exposições
     * @param organizador Organizador que iniciou a sessão
     */
    public AssignApplicationUI(ExhibitionCenter centroExposicoes, Organizer organizador) {
        super(EXHIBITION_CENTER_TITLE);

        this.centroExposicoes = centroExposicoes;
        this.controller = new AssignApplicationController(centroExposicoes, organizador);

        List<Submittable> listaExposicoes = this.controller.getSubmittablesInChangedConflictsByOrganizer(organizador);
        new DialogSelectSubmittable(this, listaExposicoes, centroExposicoes);
        if (this.exposicaoSelecionada == null) {
            dispose();
        } else {

            this.controller.setSubmittable(this.exposicaoSelecionada);
            this.listaMecanismos = this.controller.getStaffAttributionMechanism();
            this.listaAtribuicoes = new ArrayList<>();

            criarComponentes();

            pack();
            setSize(JANELA_TAMANHO);
            setMinimumSize(new Dimension(getWidth(), getHeight()));
            setLocationRelativeTo(null);
            setVisible(true);
        }

    }

    /**
     * Cria os componentes da janela.
     */
    private void criarComponentes() {

        setLayout(new BorderLayout(10, 20));
        add(criarPainelOeste(), BorderLayout.WEST);
        add(criarPainelEste(), BorderLayout.CENTER);
        add(criarPainelBotoesConfirmar(), BorderLayout.SOUTH);
    }

    /**
     * Cria o painel com a lista de mecanismos e o botão gerar.
     *
     * @return o painel com a lista de mecanismos e o botão gerar
     */
    private JPanel criarPainelOeste() {

        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(PADDING_BORDER);

        JPanel pBotaoGerar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pBotaoGerar.add(criarBotaoGerar());

        painel.add(criarScrollPaneMecanismos(), BorderLayout.CENTER);
        painel.add(pBotaoGerar, BorderLayout.SOUTH);

        return painel;
    }

    /**
     * Cria o painel com a tabela de atribuições.
     *
     * @return o painel com a tabela de atribuições
     */
    private JPanel criarPainelEste() {

        JPanel painel = new JPanel(new GridLayout());
        painel.setBorder(PADDING_BORDER);

        painel.add(criarScrollPaneAtribuicoes());
        return painel;
    }

    /**
     * cria o painel scroll que incorpora a lista de mecanismos.
     *
     * @return o painel scroll que incorpora a lista de mecanismos
     */
    private JPanel criarScrollPaneMecanismos() {

        JPanel painelScroll = new JPanel(new GridLayout());
        painelScroll.setBorder(BorderFactory.createTitledBorder(PADDING_BORDER,
                "Escolha o mecanismo pretendido:", TitledBorder.LEFT, TitledBorder.TOP));

        this.listaMecanismosUI = new JList(new ModelListMechanisms(this.listaMecanismos));
        this.listaMecanismosUI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.listaMecanismosUI.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {

                btnGerar.setEnabled((!listaMecanismosUI.isSelectionEmpty()));
            }
        });

        JScrollPane scrollPane = new JScrollPane(this.listaMecanismosUI);
        scrollPane.setBorder(PADDING_BORDER);

        painelScroll.add(scrollPane);

        return painelScroll;
    }

    /**
     * cria o painel scroll que incorpora a tabela de atribuições.
     *
     * @return o painel scroll que incorpora a tabela de atribuições
     */
    private JPanel criarScrollPaneAtribuicoes() {

        JPanel painelScroll = new JPanel(new GridLayout());
        painelScroll.setBorder(BorderFactory.createTitledBorder(PADDING_BORDER,
                "Verifique a lista de Atribuições:", TitledBorder.LEFT, TitledBorder.TOP));

        this.attributionsTableUI = new JTable();
        this.attributionsTableUI.setVisible(false);

        JScrollPane scrollPane = new JScrollPane(this.attributionsTableUI);
        scrollPane.setBorder(PADDING_BORDER);

        painelScroll.add(scrollPane);

        return painelScroll;
    }

    /**
     * Cria o botão gerar atribuições.
     *
     * @return o botão gerar atribuições
     */
    private JButton criarBotaoGerar() {
        this.btnGerar = new JButton("Gerar Atribuições");
        this.btnGerar.setEnabled(false);
        this.btnGerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = listaMecanismosUI.getSelectedIndex();
                controller.setStaffAttributionMechanism(listaMecanismos.get(row));
                listaAtribuicoes = controller.getAttributionsList();
                attributionsTableUI.setModel(new ModelTableAttributions(listaAtribuicoes));
                attributionsTableUI.setVisible(true);
            }
        });
        return this.btnGerar;
    }

    /**
     * Cria o painel com os botões confirmar e cancelar.
     *
     * @return o painel com os botões confirmar e cancelar
     */
    private JPanel criarPainelBotoesConfirmar() {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p.add(criarBotaoConfirmar());
        p.add(criarBotaoCancelar());

        return p;
    }

    /**
     * Cria o botão confirmar.
     *
     * @return o botão confirmar
     */
    private JButton criarBotaoConfirmar() {
        JButton btn = new JButton("Confirmar");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (listaAtribuicoes.size() < 1) {
                        throw new IllegalArgumentException("Tem de gerar as atribuições primeiro.");
                    }

                    String message = "Confirma as atribuições?";
                    int confirma = JOptionPane.showConfirmDialog(rootPane, message);

                    if (confirma == JOptionPane.YES_OPTION) {
                        controller.staffAttributionsRegister(listaAtribuicoes);
                        dispose();
                        // TODO : Implement after use case is finished.

                    }

                } catch (IllegalArgumentException ex) {

                    JOptionPane.showMessageDialog(
                            rootPane,
                            ex.getMessage(),
                            "Atribuir Candidaturas",
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
    private JButton criarBotaoCancelar() {

        JButton btn = new JButton("Cancelar");
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
     * @param exposicao exposição selecionada.
     */
    
    public void setExposicao(Submittable exposicao) {

        this.exposicaoSelecionada = exposicao;
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
        MechanismsRegister mr = new MechanismsRegister(attributionsList);
        exhibitionCenter.setMechanismsRegister(mr);
        
        List<Organizer> organizersList = new ArrayList<>();
        organizersList.add(organizer);
        exhibition.setOrganizersList(new OrganizersList(organizersList));
        
        Demonstration demonstration = new Demonstration();
        demonstration.setStaffList(new StaffList(staffMemberList));
        demonstration.setCurrentDemonstrationState(new DemonstrationInChangedConflictsState(demonstration));
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
        ExhibitionsRegister exReg = new ExhibitionsRegister(exhibitionsList);
        exhibitionCenter.setExhibitionsRegister(exReg);
        
        new AssignApplicationUI(exhibitionCenter, organizer);
    }
}
