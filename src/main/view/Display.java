package main.view;

import main.control.Command;
import main.model.Lista;

public interface Display {
    void display();
    void addCommand(String s, Command c);
    String getToCheck();
    String[] getToAddDelete();
    String getNewListType();
    Lista getListO();
    void addList(Lista lista);
}
