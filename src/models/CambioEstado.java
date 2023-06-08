
package models;

import java.util.ArrayList;
import java.util.Date;


public class CambioEstado {
    private Date fechaHoraInicio;
    private Estado estado;
    
    //Metodos constructores
    public CambioEstado() {
    }

    public CambioEstado(Date fechaHoraInicio, Estado estado) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.estado = estado;
    }

    //Metodos de seteo
    public Date getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(Date fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    
    //Busca el ultimo estado en ser asignado, comparando la fecha y hora de su inicio
    public boolean esUltimoEstado(ArrayList<CambioEstado> cambiosEstado){
        boolean bandera = false;
        for (CambioEstado cambioEstado:cambiosEstado){
             if(this.fechaHoraInicio.compareTo(cambioEstado.getFechaHoraInicio()) >= 0){
                 bandera = true;
             }else{
                 bandera = false;
             }
        }
       
        return bandera;
    }
    
    //Pregunta si el estado es "Iniciada"
    public boolean esIniciada(ArrayList<CambioEstado> cambiosEstado){
        boolean bandera = false;
        for (CambioEstado cambioEstado:cambiosEstado){
             if(this.fechaHoraInicio.compareTo(cambioEstado.getFechaHoraInicio()) <= 0){
                 bandera = true;
             }else{
                 bandera = false;
             }
        }
       
        return bandera;
    }
    
    
}
