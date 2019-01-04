package ProyectoHotel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Ventana extends JFrame implements ActionListener {

    protected JLabel headerTitulo, textoAbrirArchivoInicializar, textoAbrirArchivoPrecio, textoCargaInteractiva,
            textoArchivoDeSalida, textoFechaLlegada, textoFechaSalida, textoTipoHabitacion, textoCantPersona, 
            textoCedulaCheckIn, textoHoraCheckIn, textoCedulaCheckOut, textoHoraCheckOut, textoDosPuntos, textoDosPuntosOut,
             textoCedulaCancelacion,  textoHoraCancelacion, textoDosPuntosCancelacion ;

    protected JButton botonUnoHeader, botonDosHeader, botonTresHeader, botonCuatroHeader, botonAbrirArchivoInicializar, 
            botonAbrirArchivoPrecio, ingresarReserva, ingresarCheckIn, ingresarCheckOut, botonEnviarCargaInteractiva, 
            botonReservacion, botonCheckIn, botonCheckOut, botonCancelacion, botonInicializar, botonOperaciones,ingresarCancelacion;
    protected JTextArea textArea;

    protected JPanel panelUno, panelDos, panelTres, panelCuatro, panelHeader, panelTitulo, panelMenuOperaciones, panelInicializar, panelOperaciones,
            panelReservacion, panelCheckIn, panelCheckOut, panelCancelacion;
    
    protected JTextField cajaDeTextoCargaInteractivo, diaLlegada, mesLlegada, anoLlegada, diaSalida, mesSalida, anoSalida, CedulaCheckIn, HoraCheckIn,
            CedulaCheckOut,HoraCheckOut, CedulaCancelacion;
    
    protected JComboBox comboTipoDeHabitacion ,comboHoraCheckIn, comboMinutoCheckIn, comboHoraCheckOut,comboMinutoCheckOut, comboCantidadDePersona,
            comboHoraCancelacion, comboMinutoCancelacion, comboAnoLlegada,comboDiaLlegada, comboMesLlegada,comboAnoSalida,comboDiaSalida,comboMesSalida;
    
    protected JScrollPane scroll;
    
    
    
    protected String[] minutosStrings={"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27",
        "28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59"};
    
    protected String[] horasStrings ={"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
    
    protected String[] diasStrings ={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28"};
    
    protected String[] mesStrings ={"mm","01","02","03","04","05","06","07","08","09","10","11","12"};
    
    protected String[] annioStrings ={"aaaa","2019","2020","2021","2022","2023"};
		
    
    

    public Color myColorLetra = Color.decode("#FFC300");
    public Color myColorHeader = Color.decode("#F8B500");
    public Color myColorBoton = Color.decode("#571845");
    public Color myColorBotonHeader = Color.decode("#393E46");
    public Color myColorBotonLetraHeader = Color.decode("#F8B500");
    public Color myColorFondo = Color.decode("#00ADB5");
    public Color myColorHeaderLetraTitulo = Color.decode("#F8B500");
    public Color myColorHeaderTitulo = Color.decode("#FC3C3C");

    public Ventana() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 500);
        setTitle("Mi Refugio");
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        MenuHeader();
    }

    public void MenuHeader() {
        panelHeader = new JPanel();
        panelHeader.setBackground(myColorHeader);
        panelHeader.setBounds(0, 0, 1000, 70);
        panelHeader.setLayout(null);

        //===============================
        panelUno = new JPanel();
        panelUno.setBackground(myColorFondo);
        panelUno.setBounds(0, 75, 1000, 400);
        panelUno.setLayout(null);
        panelUno.setVisible(true);

        panelDos = new JPanel();
        panelDos.setBackground(myColorFondo);
        panelDos.setBounds(0, 75, 1000, 400);
        panelDos.setLayout(null);
        panelDos.setVisible(false);

        panelTres = new JPanel();
        panelTres.setBounds(0, 75, 1000, 400);
        panelTres.setLayout(null);
        panelTres.setVisible(false);

        panelCuatro = new JPanel();
        panelCuatro.setBackground(myColorFondo);
        panelCuatro.setBounds(0, 75, 1000, 400);
        panelCuatro.setLayout(null);
        panelCuatro.setVisible(false);

        //=======================================
        panelTitulo = new JPanel();
        panelTitulo.setBackground(myColorHeaderTitulo);
        panelTitulo.setBounds(0, 0, 220, 100);
        panelTitulo.setLayout(null);

        headerTitulo = new JLabel("Mi Refugio");
        headerTitulo.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 30));
        headerTitulo.setBounds(10, 14, 210, 51);
        headerTitulo.setForeground(myColorHeaderLetraTitulo);

        //========================================
        botonUnoHeader = new JButton("Home");
        botonUnoHeader.setBounds(380, 15, 150, 40);
        botonUnoHeader.setForeground(myColorBotonLetraHeader);
        botonUnoHeader.setBackground(myColorBotonHeader);
        botonUnoHeader.addActionListener(this);

        botonDosHeader = new JButton("Abrir Archivos");
        botonDosHeader.setBounds(535, 15, 150, 40);
        botonDosHeader.setForeground(myColorBotonLetraHeader);
        botonDosHeader.setBackground(myColorBotonHeader);
        botonDosHeader.addActionListener(this);

        botonTresHeader = new JButton("Operaciones");
        botonTresHeader.setBounds(690, 15, 150, 40);
        botonTresHeader.setForeground(myColorBotonLetraHeader);
        botonTresHeader.setBackground(myColorBotonHeader);
        botonTresHeader.addActionListener(this);

        botonCuatroHeader = new JButton("archivo salida");
        botonCuatroHeader.setBounds(845, 15, 150, 40);
        botonCuatroHeader.setForeground(myColorBotonLetraHeader);
        botonCuatroHeader.setBackground(myColorBotonHeader);
        botonCuatroHeader.addActionListener(this);

        PanelPrincipal();
        PanelPrincipalDos();
        PanelPrincipalTres();
        PanelPrincipalCuatro();

        panelTitulo.add(headerTitulo);
        panelHeader.add(botonUnoHeader);
        panelHeader.add(botonDosHeader);
        panelHeader.add(botonTresHeader);
        panelHeader.add(botonCuatroHeader);

        panelHeader.add(panelTitulo);

        add(panelHeader);
        add(panelUno);
        add(panelDos);
        add(panelTres);
        add(panelCuatro);

    }

    public void PanelPrincipal() {
        //=============================

        //=============================
        textArea = new JTextArea();
        textArea.setBounds(10, 30, 330, 90);

        String texto = comprobar();

        textArea.setText(texto);

        panelUno.add(textArea);
        add(panelUno);
    }

    public void PanelPrincipalDos() {

        //===============================
        textoAbrirArchivoInicializar = new JLabel("Abrir Archivos Inicializar");
        textoAbrirArchivoInicializar.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
        textoAbrirArchivoInicializar.setBounds(10, 14, 281, 51);
        textoAbrirArchivoInicializar.setForeground(Color.WHITE);
        
        textoAbrirArchivoPrecio = new JLabel("Abrir Archivos Precio");
        textoAbrirArchivoPrecio.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
        textoAbrirArchivoPrecio.setBounds(10, 65, 221, 51);
        textoAbrirArchivoPrecio.setForeground(Color.WHITE);
        //===============================
        botonAbrirArchivoInicializar = new JButton("Abrir Archivo");
        botonAbrirArchivoInicializar.setBounds(845, 15, 150, 40);
        botonAbrirArchivoInicializar.setForeground(myColorBotonLetraHeader);
        botonAbrirArchivoInicializar.setBackground(myColorBotonHeader);
        botonAbrirArchivoInicializar.addActionListener(this);
        
        botonAbrirArchivoPrecio = new JButton("Abrir Archivo");
        botonAbrirArchivoPrecio.setBounds(845, 65, 150, 40);
        botonAbrirArchivoPrecio.setForeground(myColorBotonLetraHeader);
        botonAbrirArchivoPrecio.setBackground(myColorBotonHeader);
        //===============================
        textoCargaInteractiva = new JLabel("Carga Interactiva");
        textoCargaInteractiva.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
        textoCargaInteractiva.setBounds(10, 115, 221, 51);
        textoCargaInteractiva.setForeground(Color.WHITE);
        //===============================
        botonEnviarCargaInteractiva = new JButton("Enviar");
        botonEnviarCargaInteractiva.setBounds(845, 115, 150, 40);
        botonEnviarCargaInteractiva.setForeground(myColorBotonLetraHeader);
        botonEnviarCargaInteractiva.setBackground(myColorBotonHeader);

        //===============================
        cajaDeTextoCargaInteractivo = new JTextField("Pisos del hotel");
        cajaDeTextoCargaInteractivo.setBounds(625, 115, 220, 40);
        panelDos.add(cajaDeTextoCargaInteractivo);

        panelDos.add(botonEnviarCargaInteractiva);
        panelDos.add(botonAbrirArchivoInicializar);
        panelDos.add(botonAbrirArchivoPrecio);
        panelDos.add(textoAbrirArchivoInicializar);
        panelDos.add(textoAbrirArchivoPrecio);
        panelDos.add(textoCargaInteractiva);
        add(panelDos);
    }

    public void PanelPrincipalTres() {

        panelReservacion = new JPanel();
        panelReservacion.setBackground(myColorFondo);
        panelReservacion.setBounds(0, 0, 1000, 400);
        panelReservacion.setLayout(null);
        panelReservacion.setVisible(false);

        panelCheckIn = new JPanel();
        panelCheckIn.setBackground(myColorFondo);
        panelCheckIn.setBounds(0, 0, 1000, 400);
        panelCheckIn.setLayout(null);
        panelCheckIn.setVisible(false);

        panelCheckOut = new JPanel();
        panelCheckOut.setBackground(myColorFondo);
        panelCheckOut.setBounds(0, 0, 1000, 400);
        panelCheckOut.setLayout(null);
        panelCheckOut.setVisible(false);

        panelCancelacion = new JPanel();
        panelCancelacion.setBackground(myColorFondo);
        panelCancelacion.setBounds(0, 0, 1000, 400);
        panelCancelacion.setLayout(null);
        panelCancelacion.setVisible(false);

        //========================================
        panelMenuOperaciones = new JPanel();
        panelMenuOperaciones.setBackground(myColorHeaderTitulo);
        panelMenuOperaciones.setBounds(0, 0, 220, 400);
        panelMenuOperaciones.setLayout(null);
        panelTres.add(panelMenuOperaciones);

        //=====================================
        botonReservacion = new JButton("Reservaciones");
        botonReservacion.setBackground(myColorBotonHeader);
        botonReservacion.setForeground(myColorBotonLetraHeader);
        botonReservacion.setBounds(0, 0, 220, 40);
        botonReservacion.addActionListener(this);

        ingresarReserva = new JButton("INGRESAR RESERVA");
        ingresarReserva.setBackground(myColorBotonHeader);
        ingresarReserva.setForeground(myColorBotonLetraHeader);
        ingresarReserva.setBounds(500, 350, 200, 40);
        ingresarReserva.addActionListener(this);

        textoFechaLlegada = new JLabel("FECHA LLEGADA");
        textoFechaLlegada.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoFechaLlegada.setBounds(225, 10, 150, 40);
        textoFechaLlegada.setForeground(Color.WHITE);

        comboDiaLlegada = new JComboBox();
        comboDiaLlegada.addItem("dd");
        comboDiaLlegada.setBounds(370, 10, 70, 40);

        comboMesLlegada = new JComboBox();
        comboMesLlegada.addItem("mm");
        comboMesLlegada.setBounds(445, 10, 70, 40);
        comboMesLlegada.addActionListener(this);

        comboAnoLlegada = new JComboBox(annioStrings);
        comboAnoLlegada.setBounds(520, 10, 85, 40);
        comboAnoLlegada.addActionListener(this);
        //======================================
        textoFechaSalida = new JLabel("FECHA SALIDA");
        textoFechaSalida.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoFechaSalida.setBounds(630, 10, 150, 40);
        textoFechaSalida.setForeground(Color.WHITE);

        comboDiaSalida = new JComboBox(diasStrings);
        comboDiaSalida.setBounds(760, 10, 70, 40);

        comboMesSalida = new JComboBox(mesStrings);
        comboMesSalida.setBounds(835, 10, 70, 40);

        comboAnoSalida = new JComboBox(annioStrings);
        comboAnoSalida.setBounds(910, 10, 85, 40);

        textoTipoHabitacion = new JLabel("TIPO HABITACIÓN");
        textoTipoHabitacion.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoTipoHabitacion.setBounds(225, 60, 170, 40);
        textoTipoHabitacion.setForeground(Color.WHITE);
        
        comboTipoDeHabitacion = new JComboBox();    
        comboTipoDeHabitacion.addItem("Seleccione");
        comboTipoDeHabitacion.addItem("Individual");
        comboTipoDeHabitacion.addItem("Matrimonial");
        comboTipoDeHabitacion.addItem("Doble");
        comboTipoDeHabitacion.addItem("Cuádruple");
        comboTipoDeHabitacion.addItem("Suite");
        comboTipoDeHabitacion.setBounds(450,60,175,40);
        comboTipoDeHabitacion.addActionListener(this);
        
        

        textoCantPersona = new JLabel("NUMERO PERSONAS");
        textoCantPersona.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoCantPersona.setBounds(225, 110, 200, 40);
        textoCantPersona.setForeground(Color.WHITE);
        
        comboCantidadDePersona = new JComboBox();  
        comboCantidadDePersona.addItem("Seleccione");
        
        comboCantidadDePersona.setBounds(450,110,175,40);

        //======================================
        botonCheckIn = new JButton("Check-in");
        botonCheckIn.setBackground(myColorBotonHeader);
        botonCheckIn.setForeground(myColorBotonLetraHeader);
        botonCheckIn.setBounds(0, 45, 220, 40);
        botonCheckIn.addActionListener(this);

        textoCedulaCheckIn = new JLabel("INGRESE CEDULA");
        textoCedulaCheckIn.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoCedulaCheckIn.setBounds(225, 10, 200, 40);
        textoCedulaCheckIn.setForeground(Color.WHITE);

        CedulaCheckIn = new JTextField();
        CedulaCheckIn.setBounds(390, 10, 120, 40);

        textoHoraCheckIn = new JLabel("INGRESE HORA");
        textoHoraCheckIn.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoHoraCheckIn.setBounds(225, 50, 200, 40);
        textoHoraCheckIn.setForeground(Color.WHITE);

        
        
        comboHoraCheckIn = new JComboBox(horasStrings);
        comboHoraCheckIn.setBounds(450,60,45,40);
        comboHoraCheckIn.addActionListener(this);
        
        
        textoDosPuntos = new JLabel(":");
        textoDosPuntos.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoDosPuntos.setBounds(507, 60, 10, 40);
        textoDosPuntos.setForeground(Color.WHITE);
        
        
        
        comboMinutoCheckIn = new JComboBox(minutosStrings);    

        comboMinutoCheckIn.setBounds(525,60,45,40);
        comboMinutoCheckIn.addActionListener(this);
        
        
        
        
        

        ingresarCheckIn = new JButton("INGRESAR CHECK-IN");
        ingresarCheckIn.setBackground(myColorBotonHeader);
        ingresarCheckIn.setForeground(myColorBotonLetraHeader);
        ingresarCheckIn.setBounds(500, 350, 200, 40);
        ingresarCheckIn.addActionListener(this);

        //======================================
        botonCheckOut = new JButton("Check-out");
        botonCheckOut.setBackground(myColorBotonHeader);
        botonCheckOut.setForeground(myColorBotonLetraHeader);
        botonCheckOut.setBounds(0, 90, 220, 40);
        botonCheckOut.addActionListener(this);

        textoCedulaCheckOut = new JLabel("INGRESE CEDULA");
        textoCedulaCheckOut.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoCedulaCheckOut.setBounds(225, 10, 200, 40);
        textoCedulaCheckOut.setForeground(Color.WHITE);

        CedulaCheckOut = new JTextField();
        CedulaCheckOut.setBounds(390, 10, 120, 40);

        textoHoraCheckOut = new JLabel("INGRESE HORA");
        textoHoraCheckOut.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoHoraCheckOut.setBounds(225, 50, 200, 40);
        textoHoraCheckOut.setForeground(Color.WHITE);

        comboHoraCheckOut = new JComboBox(horasStrings);    
        comboHoraCheckOut.setBounds(450,60,45,40);
        comboHoraCheckOut.addActionListener(this);
        
        
        textoDosPuntosOut = new JLabel(":");
        textoDosPuntosOut.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoDosPuntosOut.setBounds(507, 60, 10, 40);
        textoDosPuntosOut.setForeground(Color.WHITE);
        
        
        
        comboMinutoCheckOut = new JComboBox(minutosStrings);    

        comboMinutoCheckOut.setBounds(525,60,45,40);
        comboMinutoCheckOut.addActionListener(this);

        ingresarCheckOut = new JButton("INGRESAR CHECK-OUT");
        ingresarCheckOut.setBackground(myColorBotonHeader);
        ingresarCheckOut.setForeground(myColorBotonLetraHeader);
        ingresarCheckOut.setBounds(500, 350, 200, 40);
        ingresarCheckOut.addActionListener(this);

        //======================================
        botonCancelacion = new JButton("Cancelación");
        botonCancelacion.setBackground(myColorBotonHeader);
        botonCancelacion.setForeground(myColorBotonLetraHeader);
        botonCancelacion.setBounds(0, 135, 220, 40);
        botonCancelacion.addActionListener(this);
        
        textoCedulaCancelacion = new JLabel("INGRESE CEDULA");
        textoCedulaCancelacion.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoCedulaCancelacion.setBounds(225, 10, 200, 40);
        textoCedulaCancelacion.setForeground(Color.WHITE);

        CedulaCancelacion = new JTextField();
        CedulaCancelacion.setBounds(390, 10, 120, 40);

        textoHoraCancelacion = new JLabel("INGRESE HORA");
        textoHoraCancelacion.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoHoraCancelacion.setBounds(225, 50, 200, 40);
        textoHoraCancelacion.setForeground(Color.WHITE);

        comboHoraCancelacion= new JComboBox(horasStrings);    
        comboHoraCancelacion.setBounds(450,60,45,40);
        comboHoraCancelacion.addActionListener(this);
        
        
        textoDosPuntosCancelacion = new JLabel(":");
        textoDosPuntosCancelacion.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoDosPuntosCancelacion.setBounds(507, 60, 10, 40);
        textoDosPuntosCancelacion.setForeground(Color.WHITE);
        
        
        
        comboMinutoCancelacion = new JComboBox(minutosStrings);    

        comboMinutoCancelacion.setBounds(525,60,45,40);
        comboMinutoCancelacion.addActionListener(this);

        ingresarCancelacion = new JButton("INGRESAR CANCELACIÓN");
        ingresarCancelacion.setBackground(myColorBotonHeader);
        ingresarCancelacion.setForeground(myColorBotonLetraHeader);
        ingresarCancelacion.setBounds(500, 350, 210, 40);
        ingresarCancelacion.addActionListener(this);
        
        

        
        
        
        //=======================================

        panelMenuOperaciones.add(botonCheckOut);
        panelMenuOperaciones.add(botonCheckIn);
        panelMenuOperaciones.add(botonReservacion);
        panelMenuOperaciones.add(botonCancelacion);

        panelTres.add(panelMenuOperaciones);

        panelTres.add(panelReservacion);
        panelTres.add(panelCheckIn);
        panelTres.add(panelCheckOut);
        panelTres.add(panelCancelacion);

        panelReservacion.add(ingresarReserva);
        panelReservacion.add(comboDiaLlegada);
        panelReservacion.add(comboAnoLlegada);
        panelReservacion.add(comboMesLlegada);
        panelReservacion.add(comboDiaSalida);
        panelReservacion.add(comboAnoSalida);
        panelReservacion.add(comboMesSalida);
        panelReservacion.add(textoFechaLlegada);
        panelReservacion.add(textoFechaSalida);
        panelReservacion.add(textoTipoHabitacion);
        panelReservacion.add(textoCantPersona);
        panelReservacion.add(comboTipoDeHabitacion);
        panelReservacion.add(comboCantidadDePersona);
         

        panelCheckIn.add(textoCedulaCheckIn);
        panelCheckIn.add(CedulaCheckIn);
        panelCheckIn.add(textoHoraCheckIn);
        panelCheckIn.add(ingresarCheckIn);
        panelCheckIn.add(comboHoraCheckIn);
        panelCheckIn.add(comboMinutoCheckIn);
        panelCheckIn.add(textoDosPuntos);

        panelCheckOut.add(textoCedulaCheckOut);
        panelCheckOut.add(CedulaCheckOut);
        panelCheckOut.add(textoHoraCheckOut);
        panelCheckOut.add(ingresarCheckOut);
        panelCheckOut.add(comboHoraCheckOut);
        panelCheckOut.add(comboMinutoCheckOut);
        panelCheckOut.add(textoDosPuntosOut);
        
        panelCancelacion.add(textoCedulaCancelacion);
        panelCancelacion.add(CedulaCancelacion);
        panelCancelacion.add(textoHoraCancelacion);
        panelCancelacion.add(ingresarCancelacion);
        panelCancelacion.add(comboHoraCancelacion);
        panelCancelacion.add(comboMinutoCancelacion);
        panelCancelacion.add(textoDosPuntosCancelacion);

        add(panelTres);

    }

    public void PanelPrincipalCuatro() {

       

        panelMenuOperaciones = new JPanel();
        panelMenuOperaciones.setBackground(myColorHeaderTitulo);
        panelMenuOperaciones.setBounds(0, 0, 220, 400);
        panelMenuOperaciones.setLayout(null);
        panelCuatro.add(panelMenuOperaciones);
        //========================================
        panelInicializar = new JPanel();
        panelInicializar.setBackground(myColorFondo);
        panelInicializar.setBounds(0, 0, 1000, 400);
        panelInicializar.setLayout(null);
        panelInicializar.setVisible(false);

        botonInicializar = new JButton("Inicializar");
        botonInicializar.setBackground(myColorBotonHeader);
        botonInicializar.setForeground(myColorBotonLetraHeader);
        botonInicializar.setBounds(0, 0, 220, 40);
        botonInicializar.addActionListener(this);


        textArea = new JTextArea();
        textArea.setBounds(225, 5, 770, 390);
        String texto;
        textArea.setEditable(false);
        scroll = new JScrollPane(textArea);
        scroll.setBounds(225, 5, 770, 390);
        panelCuatro.add(scroll);
        
        //=====================================
        panelOperaciones = new JPanel();
        panelOperaciones.setBackground(myColorFondo);
        panelOperaciones.setBounds(0, 0, 1000, 400);
        panelOperaciones.setLayout(null);
        panelOperaciones.setVisible(false);

        botonOperaciones = new JButton("Operaciones");
        botonOperaciones.setBackground(myColorBotonHeader);
        botonOperaciones.setForeground(myColorBotonLetraHeader);
        botonOperaciones.setBounds(0, 45, 220, 40);
        botonOperaciones.addActionListener(this);

        panelMenuOperaciones.add(botonInicializar);
        panelMenuOperaciones.add(botonOperaciones);
        panelCuatro.add(panelMenuOperaciones);

        panelCuatro.add(panelInicializar);
        panelCuatro.add(panelOperaciones);


        add(panelCuatro);
    }

    @Override

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == botonUnoHeader) {
            panelUno.setVisible(true);
            panelDos.setVisible(false);
            panelTres.setVisible(false);
            panelCuatro.setVisible(false);

        } else if (e.getSource() == botonDosHeader) {
            panelUno.setVisible(false);
            panelDos.setVisible(true);
            panelTres.setVisible(false);
            panelCuatro.setVisible(false);

        } else if (e.getSource() == botonTresHeader) {
            panelUno.setVisible(false);
            panelDos.setVisible(false);
            panelTres.setVisible(true);
            panelCuatro.setVisible(false);
        } else if (e.getSource() == botonCuatroHeader) {
            panelUno.setVisible(false);
            panelDos.setVisible(false);
            panelTres.setVisible(false);
            panelCuatro.setVisible(true);
        } else if (e.getSource() == botonReservacion) {
            panelReservacion.setVisible(true);
            panelCheckIn.setVisible(false);
            panelCheckOut.setVisible(false);
            panelCancelacion.setVisible(false);

        } else if (e.getSource() == botonCheckIn) {
            panelReservacion.setVisible(false);
            panelCheckIn.setVisible(true);
            panelCheckOut.setVisible(false);
            panelCancelacion.setVisible(false);

        } else if (e.getSource() == botonCheckOut) {
            panelReservacion.setVisible(false);
            panelCheckIn.setVisible(false);
            panelCheckOut.setVisible(true);
            panelCancelacion.setVisible(false);

        } else if (e.getSource() == botonCancelacion) {
            panelReservacion.setVisible(false);
            panelCheckIn.setVisible(false);
            panelCheckOut.setVisible(false);
            panelCancelacion.setVisible(true);

        } else if (e.getSource() == ingresarReserva) {

            
            try{
                String diaLlegadaDatoEntrada = diaLlegada.getText();
                int diaLlegadaDatoEntradaParseado = Integer.parseInt(diaLlegadaDatoEntrada);
                
                
                String mesLlegadaDatoEntrada = mesLlegada.getText();
                int mesLlegadaDatoEntradaParseado = Integer.parseInt(mesLlegadaDatoEntrada);
                
                String anoLlegadaDatoEntrada = anoLlegada.getText();
                int anoLlegadaDatoEntradaParseado = Integer.parseInt(anoLlegadaDatoEntrada);
            
                String diaSalidaDatoEntrada = diaSalida.getText();
                int diaSalidaDatoEntradaParseado = Integer.parseInt(diaSalidaDatoEntrada);
            
                String mesSalidaDatoEntrada = mesSalida.getText();
                int mesSalidaDatoEntradaParseado = Integer.parseInt(mesSalidaDatoEntrada);
                
                String anoSalidaDatoEntrada = anoSalida.getText();
                int anoSalidaDatoEntradaParseado = Integer.parseInt(anoSalidaDatoEntrada);
                
                if(diaLlegadaDatoEntradaParseado >=1 && diaLlegadaDatoEntradaParseado <=31 && diaSalidaDatoEntradaParseado>=0 &&diaSalidaDatoEntradaParseado<=31){
                    JOptionPane.showMessageDialog(null,"Dia Ingresado Correcto");
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Dia Ingresado erroneo");
                }
                
                if(mesLlegadaDatoEntradaParseado<=12&&mesSalidaDatoEntradaParseado<=12&&mesLlegadaDatoEntradaParseado>=1&&mesSalidaDatoEntradaParseado>=1){
                    JOptionPane.showMessageDialog(null,"Mes Ingresado correcto");
                }else{
                    JOptionPane.showMessageDialog(null,"Mes Ingresado erroneo");
                }
  
                
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Ha ocurrido un error");
            }
            

            panelUno.setVisible(false);
            panelDos.setVisible(false);
            panelTres.setVisible(true);
            panelCuatro.setVisible(false);
        } else if (e.getSource() == botonInicializar) {
            try {
                inicializar();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == botonOperaciones) {
            try {
                operaciones();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }


        }else if (e.getSource()==comboTipoDeHabitacion){
            if(comboTipoDeHabitacion.getSelectedIndex()==0){
                comboCantidadDePersona.removeAllItems();
                comboCantidadDePersona.addItem("0");
            }else if(comboTipoDeHabitacion.getSelectedIndex()==1){
                comboCantidadDePersona.removeAllItems();
                comboCantidadDePersona.addItem("1");
            }else if(comboTipoDeHabitacion.getSelectedIndex()==2){
                comboCantidadDePersona.removeAllItems();
                comboCantidadDePersona.addItem("1");
                comboCantidadDePersona.addItem("2");
            }else if(comboTipoDeHabitacion.getSelectedIndex()==3){
                comboCantidadDePersona.removeAllItems();
                comboCantidadDePersona.addItem("1");
                comboCantidadDePersona.addItem("2");
                comboCantidadDePersona.addItem("3");
            }else if(comboTipoDeHabitacion.getSelectedIndex()==4){
                comboCantidadDePersona.removeAllItems();
                comboCantidadDePersona.addItem("1");
                comboCantidadDePersona.addItem("2");
                comboCantidadDePersona.addItem("3");
                comboCantidadDePersona.addItem("4");
            }else if(comboTipoDeHabitacion.getSelectedIndex()==5){
                comboCantidadDePersona.removeAllItems();
                comboCantidadDePersona.addItem("1");
                comboCantidadDePersona.addItem("2");
                comboCantidadDePersona.addItem("3");
                comboCantidadDePersona.addItem("4");
                comboCantidadDePersona.addItem("5");
                comboCantidadDePersona.addItem("6");
                comboCantidadDePersona.addItem("7");
                comboCantidadDePersona.addItem("8");
                comboCantidadDePersona.addItem("9");
                comboCantidadDePersona.addItem("10");
            }
            comboCantidadDePersona.addActionListener(this);
            
        }else if(e.getSource()==comboCantidadDePersona){
            
            
        }else if(e.getSource()==comboAnoLlegada){
             if(comboAnoLlegada.getSelectedIndex()!=0){
                comboMesLlegada.removeAllItems();
                for(int i = 1; mesStrings.length >i ;i++ ){
                    
                    comboMesLlegada.addItem(mesStrings[i]);   
                }
            }
             
             else if(comboAnoLlegada.getSelectedIndex()==0){
                 comboMesLlegada.removeAllItems();
             }
            
  
            
            
        }else if(e.getSource()==comboMesLlegada){
            Integer varNum = Integer.parseInt(comboAnoLlegada.getSelectedItem().toString());
            varNum=varNum%4;
            System.out.println(varNum);
            if(comboMesLlegada.getSelectedIndex()==0){
                comboDiaLlegada.removeAllItems();
                comboDiaLlegada.addItem("aa");
            }else if(comboMesLlegada.getSelectedIndex()!=0){
                comboDiaLlegada.removeAllItems();
                for(int i = 0; diasStrings.length >i ;i++ ){
                    comboDiaLlegada.addItem(diasStrings[i]);   
                }
                if(varNum==0&&comboMesLlegada.getSelectedIndex()==2){
                    comboDiaLlegada.addItem("29");
                }
                 if(comboMesLlegada.getSelectedIndex()==4 ||comboMesLlegada.getSelectedIndex()==6||comboMesLlegada.getSelectedIndex()==9||
                    comboMesLlegada.getSelectedIndex()==11){
                    comboDiaLlegada.addItem("29");   
                    comboDiaLlegada.addItem("30");   
 
                }
                if(comboMesLlegada.getSelectedIndex()==1 ||comboMesLlegada.getSelectedIndex()==3||comboMesLlegada.getSelectedIndex()==5||
                    comboMesLlegada.getSelectedIndex()==7||comboMesLlegada.getSelectedIndex()==8||comboMesLlegada.getSelectedIndex()==10||
                    comboMesLlegada.getSelectedIndex()==12){
                    comboDiaLlegada.addItem("29");   
                    comboDiaLlegada.addItem("30");  
                    comboDiaLlegada.addItem("31");   
                }
            }

            
        }
        else if (e.getSource() == botonAbrirArchivoInicializar) {
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            //Creamos el filtro
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt", "in", "out");
            fc.setFileFilter(filtro);
            Component contentPane = null;

            //Abrimos la ventana, guardamos la opcion seleccionada por el usuario
            int seleccion = fc.showOpenDialog(contentPane);

            //Si el usuario, pincha en aceptar
            if (seleccion == JFileChooser.APPROVE_OPTION) {

                //Seleccionamos el fichero
                File fichero = fc.getSelectedFile();
                //Ecribe la ruta del fichero seleccionado en el campoTexto1 de texto
                //campoMostrar2.setText(fichero.getAbsolutePath());

                try (FileReader fr = new FileReader(fichero)) {
                    String cadena = "";
                    int valor = fr.read();
                    while (valor != -1) {
                        cadena = cadena + (char) valor;
                        valor = fr.read();
                    }
                    //campoMostrar2.setText(cadena);
                } catch (IOException e1) {

                }
            }
        }

    }

    public static String fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);

    }

    public String comprobar() {
        String sFichero = "inicializar.in";
        File fichero = new File(sFichero);

        String comprobacion, comprobacion2;

        if (fichero.exists()) {

            comprobacion = "El archivo " + sFichero + " si existe";
            botonDosHeader.setEnabled(false);
        } else {
            comprobacion = "\nEl archivo " + sFichero + " no existe";
        }
        String dFichero = "precios.in";
        File fichero2 = new File(dFichero);

        if (fichero2.exists()) {

            comprobacion2 = "\n\nEl archivo " + dFichero + " si existe";
        } else {
            comprobacion2 = "\n\nEl archivo " + dFichero + " no existe";
        }
        return comprobacion + comprobacion2;

    }

    public void inicializar() throws FileNotFoundException {
        try {
            FileReader lector = new FileReader("inicializar.in");
            BufferedReader BR = new BufferedReader(lector);
            String cadena;
            textArea.setText(" ");
            while ((cadena = BR.readLine()) != null) {
                textArea.append(cadena + "\n");
            }
            BR.close();

        } catch (IOException ex) {
        }

    }

    public void operaciones() throws FileNotFoundException {
        try {
            FileReader lector = new FileReader("operaciones.in");
            BufferedReader BR = new BufferedReader(lector);
            String cadena;
            textArea.setText(" ");
            while ((cadena = BR.readLine()) != null) {
                textArea.append(cadena + "\n");
            }
            BR.close();


        } catch (IOException ex) {
        }
    }
}
