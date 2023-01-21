package main.control;

import java.util.Collections;
import java.util.Comparator;
import main.model.Producto;
import main.view.Display;

public class CommandOrdCat implements Command {
    private final Display display;

    public CommandOrdCat(Display display) {
        this.display = display;
    }
    
    @Override
    public void execute() {
        Collections.sort(display.getListO().getList(), new Comparator<>(){
            
            @Override
            public int compare(Producto o1, Producto o2) {
                return o1.getCategoria().compareTo(o2.getCategoria());
            }
        });
    }
    
}
