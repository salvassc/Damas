package views;

import controllers.ResumeController;
import utils.YesNoDialog;

class ResumeView {

    void interact(ResumeController resumeController){
        resumeController.resume(new YesNoDialog().read(MessageView.RESUME.getMessage()));
    }
}