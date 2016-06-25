/*
 * Fornece classes para componentes do UI do centro de exposições.
 */
package lapr.project.ui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitionsManager;
import lapr.project.model.ExhibitorResponsible;
import lapr.project.model.Organizer;
import lapr.project.model.StaffMember;
import lapr.project.model.User;
import lapr.project.ui.*;

/**
 * Class to generate buttons.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class UseCaseButtonsGenerator {

    /**
     * Creates a button to the use case 1.
     *
     * @param exhibitionCenter exhibition center
     * @param exhibitionsManager exhibitions manager logged in
     * @return use case 1 button
     */
    public static JButton generateUseCase1Button(ExhibitionCenter exhibitionCenter, ExhibitionsManager exhibitionsManager) {
        JButton useCase1Button = new JButton("Create Exhibition");

        useCase1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new CreateExhibitionUI(exhibitionCenter);
            }
        });

        return useCase1Button;
    }

    /**
     * Creates a button to the use case 2.
     *
     * @param exhibitionCenter exhibition center
     * @param organizer organizer logged in
     * @return use case 2 button
     */
    public static JButton generateUseCase2Button(ExhibitionCenter exhibitionCenter, Organizer organizer) {
        JButton useCase2Button = new JButton("Define Staff Member");

        useCase2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new DefineStaffMemberUI(exhibitionCenter, organizer);
            }
        });

        return useCase2Button;
    }

    /**
     * Creates a button to the use case 3.
     *
     * @param exhibitionCenter exhibition center
     * @param organizer organizer logged in
     * @return use case 3 button
     */
    public static JButton generateUseCase3Button(ExhibitionCenter exhibitionCenter, Organizer organizer) {
        JButton useCase3Button = new JButton("Assign Applications");

        useCase3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new AssignApplicationUI(exhibitionCenter, organizer);
            }
        });

        return useCase3Button;
    }

    /**
     * Creates a button to the use case 4.
     *
     * @param exhibitionCenter exhibition center
     * @param staffMember staff member logged in
     * @return use case 4 button
     */
    public static JButton generateUseCase4Button(ExhibitionCenter exhibitionCenter, StaffMember staffMember) {
        JButton useCase4Button = new JButton("Create Exhibition");

        useCase4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new EvaluateApplicationUI(exhibitionCenter, staffMember);
            }
        });

        return useCase4Button;
    }

    /**
     * Creates a button to the use case 5.
     *
     * @param exhibitionCenter exhibition center
     * @param exhibitorResponsible exhibitor responsible
     * @return use case 5 button
     */
    public static JButton generateUseCase5Button(ExhibitionCenter exhibitionCenter, ExhibitorResponsible exhibitorResponsible) {
        JButton useCase5Button = new JButton("Create Exhibition");

        useCase5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new ExhibitionApplicationUI(exhibitorResponsible, exhibitionCenter);
            }
        });

        return useCase5Button;
    }

    /**
     * Creates a button to the use case 7.
     *
     * @param exhibitionCenter exhibition center
     * @param exhibitionsManager exhibitions manager
     * @return use case 7 button
     */
    public static JButton generateUseCase7Button(ExhibitionCenter exhibitionCenter, ExhibitionsManager exhibitionsManager) {
        JButton useCase7Button = new JButton("Confirm User");

        useCase7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // TODO implement UC7
                //new ConfirmUser(exhibitionCenter, exhibitionsManager);
            }
        });

        return useCase7Button;
    }

    /**
     * Creates a button to the use case 8.
     *
     * @param exhibitionCenter exhibition center
     * @param organizer organizer logged in
     * @return use case 8 button
     */
    public static JButton generateUseCase8Button(ExhibitionCenter exhibitionCenter, Organizer organizer) {
        JButton useCase8Button = new JButton("Define Staff Member");

        useCase8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new CreateDemonstrationUI(exhibitionCenter, organizer);
            }
        });

        return useCase8Button;
    }

    /**
     * Creates a button to the use case 9.
     *
     * @param exhibitionCenter exhibition center
     * @param exhibitionsManager exhibitions manager logged in
     * @return use case 9 button
     */
    public static JButton generateUseCase9Button(ExhibitionCenter exhibitionCenter, ExhibitionsManager exhibitionsManager) {
        JButton useCase9Button = new JButton("Define Resources");

        useCase9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new DefineResourceUI(exhibitionCenter);
            }
        });

        return useCase9Button;
    }

    /**
     * Creates a button to the use case 10.
     *
     * @param exhibitionCenter exhibition center
     * @param user the user logged in
     * @return use case 10 button
     */
    public static JButton generateUseCase10Button(ExhibitionCenter exhibitionCenter, User user) {
        JButton useCase10Button = new JButton("Modify User Profile");

        useCase10Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // TODO implement UC10
                //new ModifyUserProfileUI(exhibitionCenter, user);
            }
        });

        return useCase10Button;
    }

    /**
     * Creates a button to the use case 11.
     *
     * @param exhibitionCenter exhibition center
     * @param exhibitorResponsible exhibitor responsible
     * @return use case 11 button
     */
    public static JButton generateUseCase11Button(ExhibitionCenter exhibitionCenter, ExhibitorResponsible exhibitorResponsible) {
        JButton useCase11Button = new JButton("Edit Application");

        useCase11Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new EditApplicationUI(exhibitionCenter, exhibitorResponsible);
            }
        });

        return useCase11Button;
    }

    /**
     * Creates a button to the use case 12.
     *
     * @param exhibitionCenter exhibition center
     * @param exhibitionsManager exhibitions manager logged in
     * @return use case 12 button
     */
    public static JButton generateUseCase12Button(ExhibitionCenter exhibitionCenter, ExhibitionsManager exhibitionsManager) {
        JButton useCase12Button = new JButton("Define Type Conflicts");

        useCase12Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new DefineTypeConflictsUI(exhibitionCenter, exhibitionsManager);
            }
        });

        return useCase12Button;
    }

    /**
     * Creates a button to the use case 14.
     *
     * @param exhibitionCenter exhibition center
     * @param staffMember staff member logged in
     * @return use case 14 button
     */
    public static JButton generateUseCase14Button(ExhibitionCenter exhibitionCenter, StaffMember staffMember) {
        JButton useCase14Button = new JButton("Update Detected Conflicts");

        useCase14Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new UpdateDetectedConflictsUI(exhibitionCenter, staffMember);
            }
        });

        return useCase14Button;
    }

    /**
     * Creates a button to the use case 15.
     *
     * @param exhibitionCenter exhibition center
     * @param organizer organizer logged in
     * @return use case 15 button
     */
    public static JButton generateUseCase15Button(ExhibitionCenter exhibitionCenter, Organizer organizer) {
        JButton useCase3Button = new JButton("Assign Stands");

        useCase3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new AssignStandsUI(organizer, exhibitionCenter);
            }
        });

        return useCase3Button;
    }

    /**
     * Creates a button to the use case 16.
     *
     * @param exhibitionCenter exhibition center
     * @param exhibitorResponsible exhibitor responsible
     * @return use case 16 button
     */
    public static JButton generateUseCase16Button(ExhibitionCenter exhibitionCenter, ExhibitorResponsible exhibitorResponsible) {
        JButton useCase16Button = new JButton("Confirm Stand");

        useCase16Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new ConfirmStandUI(exhibitionCenter, exhibitorResponsible);
            }
        });

        return useCase16Button;
    }

    /**
     * Creates a button to the use case 17.
     *
     * @param exhibitionCenter exhibition center
     * @param organizer organizer logged in
     * @return use case 17 button
     */
    public static JButton generateUseCase17Button(ExhibitionCenter exhibitionCenter, Organizer organizer) {
        JButton useCase7Button = new JButton("Decide Application");

        useCase7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new DecideApplicationUI(organizer, exhibitionCenter);
            }
        });

        return useCase7Button;
    }

    /**
     * Creates a button to the use case 18.
     *
     * @param exhibitionCenter exhibition center
     * @param exhibitorResponsible exhibitor responsible
     * @return use case 18 button
     */
    public static JButton generateUseCase18Button(ExhibitionCenter exhibitionCenter, ExhibitorResponsible exhibitorResponsible) {
        JButton useCase18Button = new JButton("Remove Application");

        useCase18Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new RemoveApplicationUI(exhibitionCenter, exhibitorResponsible);
            }
        });

        return useCase18Button;
    }

    /**
     * Creates a button to the use case 19.
     *
     * @param exhibitionCenter exhibition center
     * @param exhibitorResponsible exhibitor responsible
     * @return use case 19 button
     */
    public static JButton generateUseCase19Button(ExhibitionCenter exhibitionCenter, ExhibitorResponsible exhibitorResponsible) {
        JButton useCase19Button = new JButton("Create Demonstration Application");

        useCase19Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new DemonstrationApplication(exhibitorResponsible, exhibitionCenter);
            }
        });

        return useCase19Button;
    }

    /**
     * Creates a button to the use case 20.
     *
     * @param exhibitionCenter exhibition center
     * @param organizer organizer logged in
     * @return use case 20 button
     */
    public static JButton generateUseCase20Button(ExhibitionCenter exhibitionCenter, Organizer organizer) {
        JButton useCase20Button = new JButton("Decide Demonstration");

        useCase20Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new DefineEffectiveDemonstrationsUI(exhibitionCenter, organizer);
            }
        });

        return useCase20Button;
    }

    /**
     * Creates a button to the use case 21.
     *
     * @param exhibitionCenter exhibition center
     * @param organizer organizer logged in
     * @return use case 21 button
     */
    public static JButton generateUseCase21Button(ExhibitionCenter exhibitionCenter, Organizer organizer) {
        JButton useCase21Button = new JButton("Show Removed Applications");

        useCase21Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // TODO implement UC21
                //new ShowRemovedApplicationsUI(exhibitionCenter, organizer);
            }
        });

        return useCase21Button;
    }

    /**
     * Creates a button to the use case 22.
     *
     * @param exhibitionCenter exhibition center
     * @param exhibitionsManager exhibitions manager logged in
     * @return use case 22 button
     */
    public static JButton generateUseCase22Button(ExhibitionCenter exhibitionCenter, ExhibitionsManager exhibitionsManager) {
        JButton useCase22Button = new JButton("Define Stand");

        useCase22Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // TODO implement UC22
                //new DefineStand(exhibitionCenter, exhibitionsManager);
            }
        });

        return useCase22Button;
    }

    /**
     * Creates a button to the use case 23.
     *
     * @param exhibitionCenter exhibition center
     * @param organizer organizer logged in
     * @return use case 23 button
     */
    public static JButton generateUseCase23Button(ExhibitionCenter exhibitionCenter, Organizer organizer) {
        JButton useCase23Button = new JButton("Import Exhibition");

        useCase23Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // TODO change the actor for UC23 to organizer
                //new ImportExhibitionUI(organizer, exhibitionCenter);
            }
        });

        return useCase23Button;
    }

    /**
     * Creates a button to the use case 24.
     *
     * @param exhibitionCenter exhibition center
     * @param organizer organizer logged in
     * @return use case 24 button
     */
    public static JButton generateUseCase24Button(ExhibitionCenter exhibitionCenter, Organizer organizer) {
        JButton useCase24Button = new JButton("Export Exhibition");

        useCase24Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // TODO verify, isn't the exhibitor manager the actor?
                new ExportExhibitionUI(exhibitionCenter, organizer);
            }
        });

        return useCase24Button;
    }
}
