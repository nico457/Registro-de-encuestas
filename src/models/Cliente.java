
package models;


public class Cliente {
    private int dni;
    private String nombreCompleto;
    private String nroCelular;
    
    //Metodos constructores
    public Cliente() {
    }

    public Cliente(int dni, String nombreCompleto, String nroCelular) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.nroCelular = nroCelular;
    }
    
    //Metodos de seteo
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNroCelular() {
        return nroCelular;
    }

    public void setNroCelular(String nroCelular) {
        this.nroCelular = nroCelular;
    }
    
}
