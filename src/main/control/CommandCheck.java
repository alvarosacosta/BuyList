package main.control;

import main.model.Producto;
import main.view.Display;

public class CommandCheck implements Command{
    private final Display display;

    public CommandCheck(Display display) {
        this.display = display;
    }
    
    @Override
    public void execute() {
        for (Producto pr : display.getListO().getList()) {
            if(pr.getName().equals(display.getToCheck())){
                if(pr.isMarcado()){
                    pr.setCheck(false);
                } else{
                    pr.setCheck(true);
                }
            }
        }
    }
    
}
