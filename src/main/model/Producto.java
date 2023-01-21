package main.model;

public class Producto {

    private String categoria;
    private String name;
    private boolean marcado = false;

    public Producto(String categoria, String name) {
        this.categoria = categoria;
        this.name = name;
    }    
    
    public String getCategoria() {
        return categoria;
    }

    public String getName() {
        return name;
    }

    public boolean isMarcado() {
        return marcado;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setCheck(Boolean bool) {
        this.marcado = bool;
    }
    
    @Override
    public String toString(){
        String result = "Categoria: " + categoria + " | Nombre: " + name;
        
        if(marcado){
            result += " | X";
        }
        
        return result;
    }
    
}

