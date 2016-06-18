/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.ExhibitionCenter;
import lapr.project.model.Stand;
import lapr.project.model.StandsRegister;

/**
 * Represents the controller to define stand.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class DefineStandController {
    
    /**
     * The exhibition center.
     */
    private final ExhibitionCenter exhibitionCenter;
    
    /**
     * The stand register.
     */
    private StandsRegister standsRegister;
    
    /**
     * The stand to be defined.
     */
    private Stand stand;
    
    /**
     * Constructs a define stand controller.
     * 
     * @param exhibitionCenter exhibition center
     */
    public DefineStandController(ExhibitionCenter exhibitionCenter) {
        this.exhibitionCenter = exhibitionCenter;
    }
    
    /**
     * Creates a new stand with a description, validating the stand.
     * 
     * @param area area for the stand
     * @param description description for the stand
     * @return true if the stand is valid, false otherwise
     */
    public boolean newStand(float area, String description) {
        this.standsRegister = this.exhibitionCenter.getStandsRegister();
        this.stand = this.standsRegister.newStand(area, description);
        return this.stand.validate();
    }
    
    /**
     * Register a stand
     * 
     * @return true if it successful registered, and false otherwise
     */
    public boolean registerStand() {
        return this.standsRegister.registerStand(this.stand);
    }
    
    
}
