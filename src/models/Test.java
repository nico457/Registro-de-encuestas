package models;

import java.util.ArrayList;
import java.util.Date;
public class Test {
        


        //Encuesta 1
        //Pregunta 1
        int v1 = 1;
        String d1 = "1";
        int v2 = 2;
        String d2 = "2";
        int v3 = 3;
        String d3 = "3";
        int v4 = 4;
        String d4 = "4";
        int v5 = 5;
        String d5 = "5";
        
        //Creacion de respuestas posibles
        RespuestaPosible res1 = new RespuestaPosible(d1, v1);
        RespuestaPosible res2 = new RespuestaPosible(d2, v2);
        RespuestaPosible res3 = new RespuestaPosible(d3, v3);
        RespuestaPosible res4 = new RespuestaPosible(d4, v4);
        RespuestaPosible res5 = new RespuestaPosible(d5, v5);

        ArrayList respuestasPosibles1 = new ArrayList();
        
        //Definicion de la descripcion de la pregunta 1
        String pregunta = "Como calificarías el servicio del 1 al 5?";
        //Creacion
        Pregunta preg1 = new Pregunta(pregunta, respuestasPosibles1);
        
        
        //Pregunta 2
        int v6 = 1;
        String d6 = "SI";
        int v7 = 2;
        String d7 = "NO";
        //Creacion de respuestas posibles
        RespuestaPosible res6 = new RespuestaPosible(d6, v6);
        RespuestaPosible res7 = new RespuestaPosible(d7, v7);
        
        ArrayList respuestasPosibles2 = new ArrayList();
        
        //Definicion de la descripcion de la pregunta 2
        String pregunta2 = "Volvería a utilizar el sistema?";
        //Creacion
        Pregunta preg2 = new Pregunta(pregunta2, respuestasPosibles2);
        
        
        //Asignamos las 2 preguntas a un array para asignar ese array a una encuesta
        public ArrayList preguntase1 = new ArrayList();
        
        //Definicion de la descripcion de la encuesta
        String descripcion = "Conformidad del servicio";
        //Definicion de la fechaFinVigencia de la encuesta
        Date fechaFinVigencia = new Date(123,3,3);
        //Creacion
        Encuesta encuesta1 = new Encuesta(descripcion, fechaFinVigencia, preguntase1);
        
        
        
        //ENCUESTA 2
        //Pregunta 1
        int v1e2 = 1;
        String d1e2 = "☆";
        int v2e2 = 2;
        String d2e2 = "☆☆";
        int v3e2 = 3;
        String d3e2 = "☆☆☆";
        int v4e2 = 4;
        String d4e2 = "☆☆☆☆";
        int v5e2 = 5;
        String d5e2 = "☆☆☆☆☆";
        
        //Creacion de respuestas posibles
        RespuestaPosible res1e2 = new RespuestaPosible(d1e2, v1e2);
        RespuestaPosible res2e2 = new RespuestaPosible(d2e2, v2e2);
        RespuestaPosible res3e2 = new RespuestaPosible(d3e2, v3e2);
        RespuestaPosible res4e2 = new RespuestaPosible(d4e2, v4e2);
        RespuestaPosible res5e2 = new RespuestaPosible(d5e2, v5e2);

        ArrayList respuestasPosibles1e2 = new ArrayList();

        //Definicion de la descripcion de la pregunta 1
        String preguntae2 = "Como calificarías la atención al cliente?";
        //Creacion
        Pregunta preg1e2 = new Pregunta(preguntae2, respuestasPosibles1e2);
        
        
        //Pregunta 2
        int v6e2 = 1;
        String d6e2 = "SI";
        int v7e2 = 2;
        String d7e2 = "NO";
        //Creacion de respuestas posibles
        RespuestaPosible res6e2 = new RespuestaPosible(d6e2, v6e2);
        RespuestaPosible res7e2 = new RespuestaPosible(d7e2, v7e2);
        
        ArrayList respuestasPosibles2e2 = new ArrayList();
        
        //Definicion de la descripcion de la pregunta 2
        String pregunta2e2 = "Pudo resolver su situación?";
        //Creacion
        Pregunta preg2e2 = new Pregunta(pregunta2e2, respuestasPosibles2e2);
        
        
        
        ArrayList preguntase2 = new ArrayList();

        //Definicion de la descripcion de la encuesta
        String descripcione2 = "Atención al cliente";
        //Definicion de la fechaFinVigencia de la encuesta
        Date fechaFinVigenciae2 = new Date(123,3,3);
        //Creacion
        Encuesta encuesta2 = new Encuesta(descripcione2, fechaFinVigenciae2, preguntase2);
        
        //ENCUESTA 3
         //Pregunta 1
        int v1e3 = 1;
        int v2e3 = 2;
        int v3e3 = 3;
        String d1e3 = "Entre 1 y 10 veces";
        String d2e3 = "Entre 10 y 20 veces";
        String d3e3 = "Más de 20 veces";
        //Creacion de respuestas posibles
        RespuestaPosible res1e3 = new RespuestaPosible(d1e3, v1e3);
        RespuestaPosible res2e3 = new RespuestaPosible(d2e3, v2e3);
        RespuestaPosible res3e3 = new RespuestaPosible(d3e3, v3e3);
        
        ArrayList respuestasPosibles1e3 = new ArrayList();
        
        //Definicion de la descripcion de la pregunta 1
        String preguntae3 = "¿Cuantas veces has tenido que contactar al servicio de atención al cliente en el último mes?";     
        //Creacion
        Pregunta preg1e3 = new Pregunta(preguntae3, respuestasPosibles1e3);
        
        //Pregunta 2
        int v4e3 = 1;
        String d4e3 = "1";
        int v5e3 = 2;
        String d5e3 = "2";
        int v6e3 = 3;
        String d6e3 = "3";
        int v7e3 = 4;
        String d7e3 = "4";
        int v8e3 = 5;
        String d8e3 = "5";
    
        //Creacion de respuestas posibles
        RespuestaPosible res4e3 = new RespuestaPosible(d4e3, v4e3);
        RespuestaPosible res5e3 = new RespuestaPosible(d5e3, v5e3);
        RespuestaPosible res6e3 = new RespuestaPosible(d6e3, v6e3);
        RespuestaPosible res7e3 = new RespuestaPosible(d7e3, v7e3);
        RespuestaPosible res8e3 = new RespuestaPosible(d8e3, v8e3);
        
        ArrayList respuestasPosibles2e3 = new ArrayList();
        //Definicion de la descripcion de la pregunta 2
        String preguntae4 = "¿Con qué frecuencia has experimentado demoras en la respuesta del servicio de atención al cliente en el último mes?(1-5)";
        //Creacion
        Pregunta preg2e3 = new Pregunta(preguntae4, respuestasPosibles2e3);
        
        public ArrayList preguntase3 = new ArrayList();
        
        //Definicion de la descripcion de la encuesta
        String descripcione3 = "Frecuencia de actividad";
        //Definicion de la fechaFinVigencia de la encuesta
        Date fechaFinVigenciae3 = new Date(123,9,3);
        //Creacion
        Encuesta encuesta3 = new Encuesta(descripcione3, fechaFinVigenciae3, preguntase3);
        
        
        
        //LLAMADA 1
        //Creacion del cliente
        Cliente cliente1 = new Cliente(32143536,"Nicolás","351214155"); 
        
        //Asignacion de valores a los atributos
        int duracion1 = 15;
        
        Estado enCurso = new Estado("En curso");
        Estado realizada = new Estado("realizada");
        
        Date fechaHoraInicio = new Date(122,3,1);
        Date fechaHoraInicio2 = new Date(122,3,3);
        CambioEstado cambioEstado1 = new CambioEstado(fechaHoraInicio,enCurso);  
        CambioEstado cambioEstado2 = new CambioEstado(fechaHoraInicio2,realizada);  
        ArrayList<CambioEstado> cambiosEstado1 = new ArrayList();


        Date fechaEncuesta = new Date(123,3,3);
        RespuestaDeCliente respuestapreg1 = new RespuestaDeCliente(fechaEncuesta,res3);
        RespuestaDeCliente respuestapreg2 = new RespuestaDeCliente(fechaEncuesta,res6);
        ArrayList respuestas = new ArrayList();

        //Creacion
        Llamada llamada1 = new Llamada(1,respuestas,cambiosEstado1,cliente1,duracion1,true);
        
        //LLAMADA 2
        //Creacion de cliente
        Cliente cliente2 = new Cliente(32535235,"Sebastián","3519832143");
        
        //Asignacion de valores a los atributos
        int duracion2 = 20;
        
        
        Date fechaHoraInicio1L2 = new Date(123,3,9);
        Date fechaHoraInicio2L2 = new Date(123,3,11);
        CambioEstado cambioEstado3 = new CambioEstado(fechaHoraInicio1L2,enCurso);  
        CambioEstado cambioEstado4 = new CambioEstado(fechaHoraInicio2L2,realizada);  
        ArrayList<CambioEstado> cambiosEstado2 = new ArrayList();

        
        Date fechaEncuesta2 = new Date(122,5,10);
        RespuestaDeCliente respuestapreg1_L2 = new RespuestaDeCliente(fechaEncuesta2,res5e2);
        RespuestaDeCliente respuestapreg2_L2 = new RespuestaDeCliente(fechaEncuesta2,res6e2);
        ArrayList respuestas2 = new ArrayList();

        //Creacion
        Llamada llamada2 = new Llamada(2,respuestas2,cambiosEstado2,cliente2,duracion2,true);
        public ArrayList llamadas = new ArrayList();
        public ArrayList encuestas = new ArrayList();
        public ArrayList<Pregunta> preguntas = new ArrayList();
        
        //LLAMADA 3
        //Asignacion de valores a los atributos
        int duracion3 = 30;
        Date fechaHoraInicio1L3 = new Date(123,9,9);
        Date fechaHoraInicio2L3 = new Date(123,9,11);
        CambioEstado cambioEstado5 = new CambioEstado(fechaHoraInicio1L3,enCurso);  
        CambioEstado cambioEstado6 = new CambioEstado(fechaHoraInicio2L3,realizada); 
        ArrayList<CambioEstado> cambiosEstado3 = new ArrayList();
        
        Date fechaEncuesta3 = new Date(123,9,13);
        RespuestaDeCliente respuestapreg1_L3 = new RespuestaDeCliente(fechaEncuesta3,res2e3);
        RespuestaDeCliente respuestapreg2_L3 = new RespuestaDeCliente(fechaEncuesta3,res7e3);
        ArrayList respuestas3 = new ArrayList();
        
        //Creacion
        Llamada llamada3 = new Llamada(3,respuestas3,cambiosEstado3,cliente1,duracion3,true);

    public Test() {
        
        //ENCUESTA 1
        respuestasPosibles1.add(res1);
        respuestasPosibles1.add(res2);
        respuestasPosibles1.add(res3);
        respuestasPosibles1.add(res4);
        respuestasPosibles1.add(res5);
        
        respuestasPosibles2.add(res6);
        respuestasPosibles2.add(res7);
        
        preguntase1.add(preg1);
        preguntase1.add(preg2);

        //ENCUESTA 2
 
        respuestasPosibles1e2.add(res1e2);
        respuestasPosibles1e2.add(res2e2);
        respuestasPosibles1e2.add(res3e2);
        respuestasPosibles1e2.add(res4e2);
        respuestasPosibles1e2.add(res5e2);
        
        respuestasPosibles2e2.add(res6e2);
        respuestasPosibles2e2.add(res7e2);
        
        preguntase2.add(preg1e2);
        preguntase2.add(preg2e2);
        
        //ENCUESTA 3
        respuestasPosibles1e3.add(res1e3);
        respuestasPosibles1e3.add(res2e3);
        respuestasPosibles1e3.add(res3e3);
        
        respuestasPosibles2e3.add(res4e3);
        respuestasPosibles2e3.add(res5e3);
        respuestasPosibles2e3.add(res6e3);
        respuestasPosibles2e3.add(res7e3);
        respuestasPosibles2e3.add(res8e3);
        
        preguntase3.add(preg1e3);
        preguntase3.add(preg2e3);
        
        
        
        //LLAMADA 1
        cambiosEstado1.add(cambioEstado1);
        cambiosEstado1.add(cambioEstado2);
        
        respuestas.add(respuestapreg1);
        respuestas.add(respuestapreg2);
        
        //LLAMADA 2
        cambiosEstado2.add(cambioEstado3);
        cambiosEstado2.add(cambioEstado4);
        
        respuestas2.add(respuestapreg1_L2);
        respuestas2.add(respuestapreg2_L2);
        
        //LLAMADA 3
        cambiosEstado3.add(cambioEstado5);
        cambiosEstado3.add(cambioEstado6);
        
        respuestas3.add(respuestapreg1_L3);
        respuestas3.add(respuestapreg2_L3);
        
        //llamadas
        llamadas.add(llamada1);
        llamadas.add(llamada2);
        llamadas.add(llamada3);
        
        //encuestas
        encuestas.add(encuesta1);
        encuestas.add(encuesta2);
        encuestas.add(encuesta3);
        
        //preguntas
        preguntas.add(preg1);
        preguntas.add(preg2);
        preguntas.add(preg1e2);
        preguntas.add(preg2e2);
        preguntas.add(preg1e3);
        preguntas.add(preg2e3);
        

    }
 
}

