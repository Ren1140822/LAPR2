/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.application;

import lapr.project.model.Application;
import lapr.project.model.ApplicationState;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class ApplicationInSubmissionState implements ApplicationState {
       /**
     * The application to be manipulated.
     */
    private final Application application;
    
    /**
     * Constructs a application initial state.
     * 
     * @param application application to be manipulated
     */
    public ApplicationInSubmissionState(Application application){
        this.application = application;
    }

    @Override
    public boolean isInitial() {
        return false;
    }
    
    @Override
    public boolean setInSubmission() {
      
        return false;
    }

    @Override
    public boolean isInSubmission() {
        return true;
    }

    @Override
    public boolean setRemoved() {
//         if (validate()) {
//             TODO:IMPLEMENT THE NEW CLASS
//            ApplicationRemovedState newState = new  ApplicationRemovedState(application);
//            application.setState(newState);
//            return true;
//        }
         return false;
    }

    @Override
    public boolean isRemoved() {
        return false;
    }

    @Override
    public boolean setInAttribution() {
        //         if (validate()) {
//             TODO:IMPLEMENT THE NEW CLASS
//            ApplicationInAttributionState newState = new  ApplicationInAttributionState(application);
//            application.setState(newState);
//            return true;
//        }
        return false;
    }

    @Override
    public boolean isInAttribtion() {
        return false;
    }

    @Override
    public boolean setInEvaluation() {
        return false;
    }

    @Override
    public boolean isInEvaluation() {
        return false;
    }

    @Override
    public boolean setNotEvaluated() {
        return false;
    }

    @Override
    public boolean isNotEvaluated() {
        return false;
    }

    @Override
    public boolean setInDecision() {
        return false;
    }

    @Override
    public boolean isInDecision() {
        return false;
    }

    @Override
    public boolean setAccepted() {
        return false;
    }

    @Override
    public boolean isAccepted() {
        return false;
    }

    @Override
    public boolean setDeclined() {
        return false;
    }

    @Override
    public boolean isDeclined() {
        return false;
    }

    @Override
    public boolean setAssignedStand() {
        return false;
    }

    @Override
    public boolean isAssignedStand() {
        return false;
    }

    @Override
    public boolean setConfirmedStand() {
        return false;
    }

    @Override
    public boolean isConfirmedStand() {
        return false;
    }

    @Override
    public boolean setNotConfirmedStand() {
        return false;
    }

    @Override
    public boolean isNotConfirmedStand() {
        return false;
    }

    @Override
    public boolean validate() {
        return application.isValid();
    }
    
}
