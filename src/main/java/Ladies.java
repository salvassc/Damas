import controllers.Controller;
import controllers.Logic;
import views.View;
import views.ConsoleView;

class Ladies {

    private Logic logic;
    private View view;
    

    protected Ladies(){
        this.logic = new Logic();
        this.view = this.createView();
    }

    private void play() {
        Controller controller;
        do{
            controller = this.logic.getController();
            if(controller != null){
                this.view.interact(controller);
            }
        }while(controller != null);
    }

    private View createView(){
        return new ConsoleView();
    }

    public static void main(String[] args) {
       new Ladies().play();
    }

    
}