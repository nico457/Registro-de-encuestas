
package models;

public class Estado {
    private String nombre;
    
    //Metodos constructores
    public Estado() {
    }

    public Estado(String nombre) {
        this.nombre = nombre;
    }

    //Metodos de seteo
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
