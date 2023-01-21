package main.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import main.control.Command;
import main.model.Lista;

public class DisplayTerminal implements Display {
    
    private ArrayList<Lista> listas = new ArrayList<>();
    private Map<String, Command> commands = new HashMap<>();
    private Scanner sc = new Scanner(System.in);
    private Lista listaO;
    
    private String newListType;
    private String toCheck;
    private String[] toAddDelete = new String[2];
    
    @Override
    public void addCommand(String sr, Command cm){
        commands.put(sr, cm);
    }
    
    @Override
    public String getNewListType(){
        return newListType;
    }
    
    @Override
    public Lista getListO(){
        return listaO;
    }
    
    @Override
    public String getToCheck(){
        return toCheck;
    }
    
    @Override
    public String[] getToAddDelete(){
        return toAddDelete;
    }
    
    @Override
    public void addList(Lista lista) {
        this.listas.add(lista);
    }
    
    @Override
    public void display() {
        System.out.println("Escribe: "
                + "\n \"Crear\":        Si quieres crear una lista de la compra."
                + "\n \"Ver\":          Si quieres ver una lista de la compra.");
        
        String line = sc.nextLine();
        
        if(line.equals("Crear")){
            showCrear();
            
        } else if(line.equals("Ver")){
            showVer();
            
        } else {
            System.out.println("No es un comando valido.\n");
            
            display();
        }
        
    }

    private void showCrear() {
        System.out.print("Escribe el nombre del tipo de la lista: ");
        
        newListType = sc.nextLine();
        commands.get("Creador").execute();
        
        System.out.println("Hecho!\n");
        display();
        
    }

    private void showVer() {
        showAllListsNames();
        
        String line = sc.nextLine();
        this.listaO = getList(line);
        
        if(listaO == null){
            System.out.println("No existe esa lista.\n");
            display();
        }
        
        showListConf();
        
    }
    
    private void showListConf() {
        System.out.println(listaO.toString());
        
        System.out.println("Escribe: "
                + "\n \"Editar\":        Si quieres añadir o borrar un producto."
                + "\n \"Marcas\":        Si quieres marcar o desmarcar un producto de la lista."
                + "\n \"AaZ\":           Si quieres ordenar la lista alfabeticamente, por nombre de producto."
                + "\n \"Categoria\":     Si quieres ordenar la lista por categoria de producto."
                + "\n \"Exit\":          Volver al menu principal.");
        
        switch(sc.nextLine()){
            case "Editar":
                edita();
                break;
                
            case "Marcas":
                marca();
                break;
                
            case "AaZ":
                commands.get("AaZ").execute();
                System.out.println("Hecho!\n");
                break;
                
            case "Categoria":
                commands.get("Categoria").execute();
                System.out.println("Hecho!\n");
                break;
                
            case "Exit":
                System.out.println("");
                display();
                break;
                        
            case default:
                System.out.println("No es un comando valido.\n");
                break;
                
        }
        
        showListConf();
        
    }
    
    private void edita() {
        System.out.println(listaO.toString());
        
        System.out.print("Escribe la categoria del producto que quieras añadir o quitar: ");
        this.toAddDelete[0] = sc.nextLine();
        
        System.out.print("Escribe el nombre del producto que quieras añadir o quitar: ");
        this.toAddDelete[1] = sc.nextLine();
        
        commands.get("Editor").execute();
        
        System.out.println("Hecho!\n");
    }

    private void marca() {
        System.out.println(listaO.toString());
        
        System.out.print("Escribe el nombre del producto que quieras marcar o desmarcar: ");
        
        toCheck = sc.nextLine();
        commands.get("Marcador").execute();
        
        System.out.println("Hecho!\n");
    }
    
    private void showAllListsNames() {
        System.out.println("Elige la lista que quieras ver: ");
        for (Lista lista : listas) {
            System.out.println(lista.getType());
        }
    }
    
    private Lista getList(String n) {
        for (Lista lista : listas) {
            if(lista.getType().equals(n)){
                return lista;
            }
        }
        
        return null;
    }

    
}
