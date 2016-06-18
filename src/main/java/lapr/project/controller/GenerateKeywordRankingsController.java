/**
 * Package location for Application Controllers concepts.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.ExhibitionsManager;
import lapr.project.model.ExhibitionsRegister;
import lapr.project.model.Keyword;
import lapr.project.model.Submittable;

/**
 * Represents the controller to generate keyword rankings.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class GenerateKeywordRankingsController {

    /**
     * The exhibition center.
     */
    private final ExhibitionCenter exhibitionCenter;

    /**
     * The exhibitions manager logged in this session.
     */
    private final ExhibitionsManager exhibitionsManager;

    /**
     * The selected submittable.
     */
    private Submittable selectedSubmittable;

    /**
     * The accepted applications keywords ranking;
     */
    private List<Keyword> acceptedAppsKeywordsRanking;
    
    /**
     * The rejected applications keywords ranking;
     */
    private List<Keyword> rejectedAppsKeywordsRanking;

    /**
     * Constructs a GenerateKeywordRankingsController Class.
     *
     * @param exhibitionCenter Exhibition Center
     * @param exhibitionsManager Logged in exhibitions manager
     */
    public GenerateKeywordRankingsController(ExhibitionCenter exhibitionCenter, ExhibitionsManager exhibitionsManager) {
        this.exhibitionCenter = exhibitionCenter;
        this.exhibitionsManager = exhibitionsManager;
    }

    /**
     * Obtain the exhibition center.
     *
     * @return the exhibition center
     */
    public ExhibitionCenter getExhibitionCenter() {
        return exhibitionCenter;
    }

    /**
     * Obtain the selected submittable.
     * 
     * @return the selected submittable
     */
    public Submittable getSelectedSubmittable() {
        return selectedSubmittable;
    }

    /**
     * Set the selected submittable.
     * 
     * @param selectedSubmittable the selected submittable to set
     */
    public void setSelectedSubmittable(Submittable selectedSubmittable) {
        this.selectedSubmittable = selectedSubmittable;
    }

    /**
     * Obtain the accepted applications keywords ranking.
     * 
     * @return the accepted applications keywords ranking
     */
    public List<Keyword> getAcceptedAppsKeywordsRanking() {
        return acceptedAppsKeywordsRanking;
    }

    /**
     * Set the accepted applications keywords ranking.
     * 
     * @param acceptedAppsKeywordsRanking the accepted applications keywords ranking to set
     */
    public void setAcceptedAppsKeywordsRanking(List<Keyword> acceptedAppsKeywordsRanking) {
        this.acceptedAppsKeywordsRanking = acceptedAppsKeywordsRanking;
    }

    /**
     * Obtain the rejected applications keywords ranking.
     * 
     * @return the rejected applications keywords ranking
     */
    public List<Keyword> getRejectedAppsKeywordsRanking() {
        return rejectedAppsKeywordsRanking;
    }

    /**
     * Set the rejected applications keywords ranking.
     * 
     * @param rejectedAppsKeywordsRanking the rejected applications keywords ranking to set
     */
    public void setRejectedAppsKeywordsRanking(List<Keyword> rejectedAppsKeywordsRanking) {
        this.rejectedAppsKeywordsRanking = rejectedAppsKeywordsRanking;
    }

    public List<Submittable> getDecidedSubmittables() {
        
        ExhibitionsRegister exhibitionsRegister = exhibitionCenter.getExhibitionsRegister();
        
        return exhibitionsRegister.getDecidedSubmittables();
    }
}
