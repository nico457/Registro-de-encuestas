package models;

import java.util.ArrayList;
import java.util.Scanner;

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
    
    //Metodo usado para la busqueda de respuestas, para esTuPregunta
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RespuestaPosible otraRespuesta = (RespuestaPosible) obj;
        return this.valor == otraRespuesta.valor && this.descripcion.equals(otraRespuesta.descripcion);
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
