package models;


public class RespuestaPosible {

    private String descripcion;
    private int valor;
    
    //Metodos constructores
    public RespuestaPosible() {
    }

    public RespuestaPosible(String descripcion, int valor) {
        this.descripcion = descripcion;
        this.valor = valor;
    }
    

    
    //Metodos de seteo
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

}
