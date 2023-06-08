package models;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CSVManage {
    private String archivo;
    public CSVManage(String archivo) {
        this.archivo = archivo;
    }

    public void writeCSV(Llamada llamada,Estado estado,Encuesta encuesta, ArrayList<Pregunta> preguntas) {
        try {
            FileWriter fileWriter = new FileWriter(this.archivo);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.println("CLIENTE, " +  " ESTADO ACTUAL, " + " DURACION");
            printWriter.println(llamada.getCliente().getNombreCompleto() + ", " + estado.getNombre() + ", " + llamada.getDuracion() );
            printWriter.println("");
            for (int i = 0; i< preguntas.size(); i++) {
                 printWriter.println("PREGUNTA");
                 printWriter.println( preguntas.get(i).getPregunta());
                 ArrayList<RespuestaDeCliente> respuestasDeCliente= llamada.getRespuestasDeCliente();
                 for (int j = 0; j < respuestasDeCliente.size()-1; j++) {
                     String seleccionada = respuestasDeCliente.get(i).getRespuestaSeleccionada().getDescripcion();
                     printWriter.println("");
                     printWriter.println("RESPUESTA");
                     printWriter.println(seleccionada);
                    
                }
                 printWriter.println("========================================================");
            }
            printWriter.flush();
            printWriter.close();
            // Abrir el archivo generado
            File file = new File(this.archivo);
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al generar el CSV");
            System.out.println(e);
        }
    }

}
