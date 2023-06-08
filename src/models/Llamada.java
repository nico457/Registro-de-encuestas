package models;

import java.util.ArrayList;
import java.util.Date;
public class Llamada {
    private int id;
    private ArrayList<RespuestaDeCliente> respuestasDeCliente;
    private ArrayList<CambioEstado> cambiosEstado;
    private Cliente cliente;
    private int duracion;
    private boolean encuestaEnviada;
    
    
    //Metodos constructores
    public Llamada() {
    }

    public Llamada(int id,ArrayList<RespuestaDeCliente> respuestasDeCliente,ArrayList cambiosEstado,Cliente cliente,int duracion, boolean encuestaEnviada) {
        this.id = id;
        this.respuestasDeCliente = respuestasDeCliente;
        this.cambiosEstado = cambiosEstado;
        this.cliente = cliente;
        this.duracion = duracion;
        this.encuestaEnviada = encuestaEnviada;
        
    }
    
    //Metodos de seteo
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public ArrayList<RespuestaDeCliente> getRespuestasDeCliente() {
        return respuestasDeCliente;
    }

    public void setRespuestasDeCliente(ArrayList<RespuestaDeCliente> respuestasDeCliente) {
        this.respuestasDeCliente = respuestasDeCliente;
    }
    
    public void setEncuestaEnviada(boolean encuestaEnviada) {
        this.encuestaEnviada = encuestaEnviada;
    }

    public ArrayList<CambioEstado> getCambiosEstado() {
        return cambiosEstado;
    }

    public void setCambiosEstado(ArrayList<CambioEstado> cambiosEstado) {
        this.cambiosEstado = cambiosEstado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    //Consulta si esta llamada tiene una encuesta enviada (true or false)
    public boolean tieneEncuestaEnviada() {
        if (respuestasDeCliente != null) {
            this.encuestaEnviada = true;
            return true;
        } else {
            this.encuestaEnviada = false;
            return false;
        }
    }
    
    //Busca las llamadas iniciadas en el periodo comprendido entre las 2 fechas ingresadas por el usuario
    public boolean esDePeriodo(Date fechaInicio, Date fechaFin, Llamada llamada) {
        CambioEstado cambioEstadoInicial = null;
        for (CambioEstado cambioEstado : this.cambiosEstado) {
            if (cambioEstado.esIniciada(this.cambiosEstado)) {
                cambioEstadoInicial = cambioEstado;
            }
            
        }
        Date fecha = cambioEstadoInicial.getFechaHoraInicio();
        return fecha.compareTo(fechaInicio) >= 0 && fecha.compareTo(fechaFin) <= 0;

    }
    
    //Imprime las respuestas
    public String mostrarRespuestasSeleccionadas(){
        String respuestasClientesString = "";
        for (RespuestaDeCliente respuesta : this.respuestasDeCliente){
            String res =respuesta.getRespuestaSeleccionada().getDescripcion();
            respuestasClientesString += res + " \n ";
        }return respuestasClientesString;
    }

}
