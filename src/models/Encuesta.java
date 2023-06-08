package models;

import java.util.ArrayList;
import java.util.Date;

public class Encuesta {
    private String descripcion;
    private Date fechaFinVigencia;
    
    private ArrayList<Pregunta> preguntas;
    
    //Metodos constructores
    public Encuesta() {
    }

    public Encuesta(String descripcion, Date fechaFinVigencia,ArrayList<Pregunta> preguntas) {
        this.descripcion = descripcion;
        this.fechaFinVigencia = fechaFinVigencia;
        this.preguntas = preguntas;
    }
    
    //Metodos de seteo
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaFinVigencia() {
        return fechaFinVigencia;
    }

    public void setFechaFinVigencia(Date fechaFinVigencia) {
        this.fechaFinVigencia = fechaFinVigencia;
    }

    public ArrayList<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(ArrayList<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    
    //Itera en todas las preguntas para saber si pertenecen a la encuesta
    public boolean esTuPregunta(Object pregunta){
        for (Object p : preguntas) {
            if (p == pregunta) {
                return true;
            }
        }
        return false;
        
    }
    
    //Imprime las preguntas de la encuesta
    public String mostrarPreguntas(){
        String preguntasString = "";
        for (Pregunta pregunta : this.preguntas){
            String preg =pregunta.getPregunta();
            preguntasString += preg + System.lineSeparator();
        }return preguntasString;
    }
    
    
 
}
