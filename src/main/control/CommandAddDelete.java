package main.control;

import main.model.Producto;
import main.view.Display;

public class CommandAddDelete implements Command {
    private final Display display;

    public CommandAddDelete(Display display) {
        this.display = display;
    }
    
    @Override
    public void execute() {
        boolean helper = true;
        String[] duo = display.getToAddDelete();
        
        for (Producto pr : display.getListO().getList()) {
            if(pr.getCategoria().equals(duo[0]) && pr.getName().equals(duo[1])){
                display.getListO().remove(duo[1]);
                helper = false;
                break;
            }
        }
        
        if(helper)
            display.getListO().add(new Producto(duo[0], duo[1]));
    }
    
}
