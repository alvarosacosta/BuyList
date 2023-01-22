package main.model;

import java.util.ArrayList;

public class Lista {

    private String type;
    private ArrayList<Producto> productos = new ArrayList <>();

    public Lista(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public ArrayList<Producto> getList(){
        return productos;
    }
    
    @Override
    public String toString(){
        String result = "Tipo de lista: " + type + "\n";
        
        for (Producto producto : productos) {
            result += producto.toString() + "\n";
        }
        
        return result;
    }
    
}
