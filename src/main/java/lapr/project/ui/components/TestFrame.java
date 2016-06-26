/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import lapr.project.model.Application;
import lapr.project.model.ApplicationsList;
import lapr.project.model.Exhibition;
import lapr.project.model.ExhibitionApplication;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitionsRegister;
import lapr.project.model.Keyword;
import lapr.project.model.application.ApplicationAcceptedState;
import lapr.project.model.application.ApplicationAssignedStandState;
import lapr.project.model.application.ApplicationDeclinedState;
import lapr.project.model.exhibition.ExhibitionDecidedApplicationsState;
import lapr.project.utils.DefaultInstantiator;

/**
 *
 * @author Daniel Goncalves <1151452@isep.ipp.pt>
 */
public class TestFrame extends JFrame {

    public TestFrame(ExhibitionCenter exhibitionCenter) throws HeadlessException {
        super("TEST");

        setLayout(new BorderLayout());
//        add(new StaffEvaluationsAnalysisPanel(exhibitionCenter), BorderLayout.CENTER);
        add(new GenerateKeywordsRankingPanel(exhibitionCenter), BorderLayout.CENTER);

        pack();
//        setMinimumSize(new Dimension(getWidth(), 270));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {

        Keyword keyword1 = new Keyword("Keyword1");
        Keyword keyword2 = new Keyword("Keyword2");
        Keyword keyword3 = new Keyword("Keyword3");

        List<Keyword> keywordsList1 = new ArrayList<>();
        keywordsList1.add(keyword1);
        keywordsList1.add(keyword2);
        ExhibitionApplication application1 = new ExhibitionApplication();
        application1.setState(new ApplicationAcceptedState(application1));
        application1.setDecision(true, "test");
        application1.setKeywordsList(keywordsList1);

        List<Keyword> keywordsList2 = new ArrayList<>();
        keywordsList2.add(keyword1);
        keywordsList2.add(keyword2);
        keywordsList2.add(keyword3);
        ExhibitionApplication application2 = new ExhibitionApplication();
        application2.setState(new ApplicationAcceptedState(application2));
        application2.setDecision(true, "test");
        application2.setKeywordsList(keywordsList2);

        ExhibitionApplication application3 = new ExhibitionApplication();
        application3.setState(new ApplicationDeclinedState(application3));
        application3.setKeywordsList(keywordsList2);
        
        ExhibitionApplication application4 = new ExhibitionApplication();
        application4.setState(new ApplicationDeclinedState(application4));
        application4.setKeywordsList(keywordsList1);

        List<Application> applications = new ArrayList<>();
        applications.add(application1);
        applications.add(application2);
        applications.add(application3);
        ApplicationsList appsList = new ApplicationsList(applications);
        
        Exhibition exhibition = new Exhibition();
        exhibition.setTitle("Test1");
        exhibition.setState(new ExhibitionDecidedApplicationsState(exhibition));
        exhibition.setApplicationsList(appsList);

        Keyword keyword4 = new Keyword("Keyword4");
        Keyword keyword5 = new Keyword("Keyword5");
        Keyword keyword6 = new Keyword("Keyword6");

        List<Keyword> keywordsList3 = new ArrayList<>();
        keywordsList3.add(keyword4);
        keywordsList3.add(keyword5);
        keywordsList3.add(keyword6);
        ExhibitionApplication application5 = new ExhibitionApplication();
        application5.setState(new ApplicationAcceptedState(application5));
        application5.setDecision(true, "test");
        application5.setKeywordsList(keywordsList3);
        
        List<Application> applications2 = new ArrayList<>();
        applications2.add(application5);
        applications2.add(application4);
        applications2.add(application3);
        ApplicationsList appsList2 = new ApplicationsList(applications2);
        
        Exhibition exhibition2 = new Exhibition();
        exhibition2.setTitle("Test2");
        exhibition2.setState(new ExhibitionDecidedApplicationsState(exhibition2));
        exhibition2.setApplicationsList(appsList2);
        
        List<Exhibition> le = new ArrayList<>();
        le.add(exhibition);
        le.add(exhibition2);
        
        ExhibitionCenter ec = DefaultInstantiator.createExhibitionCenter();
        ec.setExhibitionsRegister(new ExhibitionsRegister(le));
        
        
        new TestFrame(ec);
    }
}
