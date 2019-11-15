package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.ResumeController;
import es.urjccode.mastercloudapps.adcs.draughts.utils.YesNoDialog;

class ResumeView extends SubView {
    
    private YesNoDialog yesNoDialog;

    ResumeView(){
        super();
        this.yesNoDialog = new YesNoDialog();
    }

    void interact(ResumeController resumeController) {
        assert resumeController != null;
        if (this.yesNoDialog.read(MessageView.MESSAGE_RESUME.getMessage())){
            resumeController.reset();
        } else {
            resumeController.next();
        }

    }

}
