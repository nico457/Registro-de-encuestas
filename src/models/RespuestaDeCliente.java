
package models;

import java.util.Date;

public class RespuestaDeCliente {
    private Date fechaEncuesta;
    private RespuestaPosible respuestaSeleccionada;

    //Metodos constructores
    public RespuestaDeCliente() {
    }

    public RespuestaDeCliente(Date fechaEncuesta, RespuestaPosible respuestaSeleccionada) {
        this.fechaEncuesta = fechaEncuesta;
        this.respuestaSeleccionada = respuestaSeleccionada;
    }
    
    //Metodos de seteo
    public Date getFechaEncuesta() {
        return fechaEncuesta;
    }

    public void setFechaEncuesta(Date fechaEncuesta) {
        this.fechaEncuesta = fechaEncuesta;
    }

    public RespuestaPosible getRespuestaSeleccionada() {
        return respuestaSeleccionada;
    }

    public void setRespuestaSeleccionada(RespuestaPosible respuestaSeleccionada) {
        this.respuestaSeleccionada = respuestaSeleccionada;
    }

}
