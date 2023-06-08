package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.CSVManage;
import models.CambioEstado;
import models.Cliente;
import models.Encuesta;
import models.Estado;
import models.Llamada;
import models.Pregunta;
import models.RespuestaDeCliente;
import models.RespuestaPosible;
import models.Test;
import views.PantallaConsulta;

public class GestorConsulta implements ActionListener, MouseListener {
    
    //Declaracion de atributos
    private PantallaConsulta views;
    private Llamada seleccionDeLlamada;
    private Date fechaInicio;
    private Date fechaFin;
    private ArrayList<Llamada> llamadas;
    private ArrayList<Llamada> llamadasPeriodo;
    private DefaultTableModel model = new DefaultTableModel();
    private Test test = new Test();
    private ArrayList<Pregunta> preguntas;
    private ArrayList<Encuesta> encuestas;
    private Estado estadoActual;
    private Encuesta encuesta;
    
    //Constructor
    public GestorConsulta(PantallaConsulta views) {

        this.views = views;
        this.llamadas = test.llamadas;
        this.llamadasPeriodo = new ArrayList();
        this.preguntas = test.preguntas;
        this.encuestas = test.encuestas;
        this.views.btn_generar_csv.addActionListener(this);
        this.views.btn_confirmar.addActionListener(this);
        this.views.btn_cancelar.addActionListener(this);
        this.views.table_llamadas.addMouseListener(this);

    }
    
    //Eventos de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
	//Al tocar el boton confirmar muestra las llamadas de periodo en la tabla
        if (e.getSource() == views.btn_confirmar) {
            // Verificar si los campos están vacíos y si es así envia un mensaje
            if (views.cal_fecha_inicio.getCalendar() == null || views.cal_fecha_fin.getCalendar() == null) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha de inicio y una fecha fin");
            } else {
                //Si los campos no estan vacios procede
                cleanTable();
                this.fechaInicio = views.cal_fecha_inicio.getCalendar().getTime();
                this.fechaFin = views.cal_fecha_fin.getCalendar().getTime();
                this.buscarLlamadasConEncuestaEnviada();
            }
        
        //Boton cancelar, limpia los campos
        } else if (e.getSource() == views.btn_cancelar) {
            views.btn_generar_csv.setEnabled(false);
            cleanTable();
            cleanFields();
            views.cal_fecha_inicio.setDate(null);
            views.cal_fecha_fin.setDate(null);
            
        //Genera el CSV
        } else if (e.getSource() == views.btn_generar_csv) {
            CSVManage csvManager = new CSVManage("archivo.csv");
            csvManager.writeCSV(this.seleccionDeLlamada, this.estadoActual, this.encuesta, this.encuesta.getPreguntas());
        }
    }
    
    //Itera entre todas las llamadas y acumula las llamadas iniciadas, con 
    //el atributo tieneEncuestaEnviada = true y que pertenezcan al periodo seleccionado
    public void buscarLlamadasConEncuestaEnviada() {
        for (int i = 0; i < this.llamadas.size(); i++) {
            if (this.llamadas.get(i).esDePeriodo(this.fechaInicio, this.fechaFin, this.llamadas.get(i))
                    && this.llamadas.get(i).tieneEncuestaEnviada()) {
                this.llamadasPeriodo.add(this.llamadas.get(i));

            }
        }
        if (!this.llamadasPeriodo.isEmpty()) {
            model = (DefaultTableModel) views.table_llamadas.getModel();
            Object[] row = new Object[2];
            CambioEstado cambioActual = null;
            //Busca las llamadas con estado Iniciada
            for (int i = 0; i < this.llamadasPeriodo.size(); i++) {
                ArrayList<CambioEstado> cambiosEstado = this.llamadasPeriodo.get(i).getCambiosEstado();
                for (CambioEstado cambio : cambiosEstado) {
                    if (cambio.esIniciada(cambiosEstado)) {
                        cambioActual = cambio;
                    }
                }
                //Mostramos la ID y la fecha y hora de inicio de la llamada
                int id = this.llamadasPeriodo.get(i).getId();
                SimpleDateFormat ff = new SimpleDateFormat("dd/MM/yyyy");
                String fechaString = ff.format(cambioActual.getFechaHoraInicio());
                row[0] = id;
                row[1] = fechaString;
                model.addRow(row);

            }

        } else {
            JOptionPane.showMessageDialog(null, "No hay llamadas en ese período");
        }
    }
    
    //Metodo para mostrar datos de llamada una vez que es seleccionada
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == views.table_llamadas) {
            views.btn_generar_csv.setEnabled(true);
            cleanFields();
            int row = views.table_llamadas.rowAtPoint(e.getPoint());

            int sel = (int) views.table_llamadas.getValueAt(row, 0);
            ObtenerDatosLlamada(sel);

        }
    }
    
    //Itera en las llamadas previamente seleccionadas y obtiene sus datos
    public void ObtenerDatosLlamada(int sel) {
        for (int i = 0; i < this.llamadasPeriodo.size(); i++) {
            if (this.llamadasPeriodo.get(i).getId() == sel) {
                this.seleccionDeLlamada = llamadasPeriodo.get(i);

            }
        }
        //Buscamos el nombre del cliente y la duracion de la llamada seleccionada
        Cliente cliente = this.seleccionDeLlamada.getCliente();
        String nombreCliente = cliente.getNombreCompleto();
        //Obtenemos el estado de la llamada
        ArrayList<CambioEstado> cambiosEstado = this.seleccionDeLlamada.getCambiosEstado();
        for (CambioEstado cambioEstado : cambiosEstado) {
            if (cambioEstado.esUltimoEstado(cambiosEstado)) {
                this.estadoActual = cambioEstado.getEstado();
            }
        }
        int duracion = this.seleccionDeLlamada.getDuracion();
        //Mostramos los datos
        views.txt_cliente.setText(nombreCliente);
        views.txt_estado.setText(estadoActual.getNombre());
        views.txt_duracion.setText(String.valueOf(duracion));
        

        obtenerDatosEncuesta();

    }

    //Buscamos la informacion de la encuesta y la mostramos en pantalla
    public void obtenerDatosEncuesta() {
        Pregunta preguntaDeRespuesta = buscarPregunta();
        this.encuesta = buscarEncuesta(preguntaDeRespuesta);

        String preguntas = this.encuesta.mostrarPreguntas();
        String respuestasSel = this.seleccionDeLlamada.mostrarRespuestasSeleccionadas();
        views.txt_respuestas_seleccionadas.setText(respuestasSel);
        views.txt_descripcion_preguntas.setText(preguntas);
        views.txt_descripcion_encuesta.setText(this.encuesta.getDescripcion());
    }

    //Itera en las respuestas del cliente, por cada iteracion itera en todas las preguntas 
    //y compara si la respuesta del cliente pertenece a una de esas preguntas
    public Pregunta buscarPregunta() {
        ArrayList<RespuestaDeCliente> respuestasCliente = this.seleccionDeLlamada.getRespuestasDeCliente();
        for (RespuestaDeCliente respuesta : respuestasCliente) {
            RespuestaPosible respuestaSeleccionada = respuesta.getRespuestaSeleccionada();
            for (Pregunta pregunta : preguntas) {
                if (pregunta.esTuRespuesta(respuestaSeleccionada)) {
                    return pregunta;
                }

            }
        }
        return null;

    }

    //Itera en las encuestas y consulta si la pregunta que enviamos por parametro pertenece a una de esas encuestas
    public Encuesta buscarEncuesta(Pregunta pregunta) {
        for (Encuesta encuesta : encuestas) {
            if (encuesta.esTuPregunta(pregunta)) {
                return encuesta;

            }
        }
        return null;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    //Limpiar campos
    public void cleanFields() {
        views.txt_cliente.setText("");
        views.txt_estado.setText("");
        views.txt_duracion.setText("");
        views.txt_respuestas_seleccionadas.setText("");
        views.txt_descripcion_preguntas.setText("");
        views.txt_descripcion_encuesta.setText("");

    }
    //Limpiar tabla
    public void cleanTable() {
        DefaultTableModel model = (DefaultTableModel) views.table_llamadas.getModel();
        model.setRowCount(0);
        llamadasPeriodo.clear();

    }

}
