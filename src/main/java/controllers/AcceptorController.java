package controllers;

public interface AcceptorController {

    void visit(StartController startController);

    void visit(PlayController playController);

    void visit(ResumeController resumeController);
    
}