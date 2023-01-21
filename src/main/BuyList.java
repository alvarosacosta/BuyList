
/*
    Diseñar una aplicación para gestionar listas de la compra. 
    La aplicación debe permitir crear diferentes listas: supermercado, asadero, libros. 
    Se debe poder editar una lista para marcar/desmarcar, añadir o quitar productos. 
    La lista debe poderse ordenar alfabéticamente o por categoría del producto. 
    Representar el diseño en UML e implementar la arquitectura en Java.
*/

package main;

import main.control.*;
import main.view.*;

public class BuyList {

    public static void main(String[] args) {
        Display display = new DisplayTerminal();
        
        display.addCommand("Categoria", new CommandOrdCat(display));
        display.addCommand("AaZ", new CommandOrdAlf(display));
        display.addCommand("Creador", new CommandCreator(display));
        display.addCommand("Editor", new CommandAddDelete(display));
        display.addCommand("Marcador", new CommandCheck(display));
        
        display.display();
    }
    
}
