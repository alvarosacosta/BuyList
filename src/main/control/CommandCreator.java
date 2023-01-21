package main.control;

import main.model.Lista;
import main.view.Display;

public class CommandCreator implements Command {
    private final Display display;

    public CommandCreator(Display display) {
        this.display = display;
    }
    
    @Override
    public void execute() {
        display.addList(new Lista(display.getNewListType()));
    }
    
}
