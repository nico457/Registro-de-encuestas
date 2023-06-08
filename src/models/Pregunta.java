package models;

import java.util.ArrayList;
public class Pregunta {

    private String pregunta;
    private ArrayList<RespuestaPosible> respuestasPosibles;

    //Metodos construtores
    public Pregunta() {
    }

    public Pregunta(String pregunta, ArrayList<RespuestaPosible> respuestasPosibles) {
        this.pregunta = pregunta;
        this.respuestasPosibles = respuestasPosibles;
    }
    
    //Metodos de seteo
    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public ArrayList getRespuestasPosibles() {
        return respuestasPosibles;
    }

    public void setRespuestasPosibles(ArrayList<RespuestaPosible> respuestasPosibles) {
        this.respuestasPosibles = respuestasPosibles;
    }

    //Itera en todas las respuestas posibles para saber si pertenecen a la pregunta
    public boolean esTuRespuesta(Object respuestaPosible) {
        for (Object r : respuestasPosibles) {
            if (r == respuestaPosible) {
                return true;
            }
        }
        return false;
    }

}
