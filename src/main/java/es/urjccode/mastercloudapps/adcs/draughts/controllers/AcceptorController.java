package es.urjccode.mastercloudapps.adcs.draughts.controllers;

public interface AcceptorController {

    void visit(StartController startController);

    void visit(PlayController playController);

    void visit(ResumeController resumeController);
    
}