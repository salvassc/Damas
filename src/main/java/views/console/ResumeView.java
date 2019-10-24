package views.console;

import controllers.ResumeController;

class ResumeView {

    private ResumeController resumeController;

    ResumeView(ResumeController resumeController){
        this.resumeController = resumeController;
    }

    boolean interact(){
        return true;
    }
}