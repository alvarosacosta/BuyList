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
    
    public void add(Producto pr) {
        productos.add(pr);
    }
    
    public void remove(String name){
        for (Producto producto : productos) {
            if(producto.getName().equals(name)){
                productos.remove(producto);
                break;
            }
        }
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
