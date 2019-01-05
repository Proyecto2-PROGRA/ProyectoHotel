package ProyectoHotel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
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
            textoCedulaCancelacion, textoHoraCancelacion, textoDosPuntosCancelacion, textoSaldoInicial, textoFechaInicial, textoPisos,
            textoMostrarInicial, TextoHabitaciones, textoIndv, textoDoble, textoMatri, textoCuadruple, textoSuite, textoCam_A, textoCaj_F, TextoHabitaciones2,
            textoEsp_C, textoLom_M, textoJug_L, textoMalta, TextoHabitaciones3, textoMostrarInicial2;

    protected JButton botonUnoHeader, botonDosHeader, botonTresHeader, botonCuatroHeader, botonAbrirArchivoInicializar,
            botonAbrirArchivoPrecio, ingresarReserva, ingresarCheckIn, ingresarCheckOut, botonEnviarCargaInteractiva,
            botonReservacion, botonCheckIn, botonCheckOut, botonCancelacion, botonInicializar, botonOperaciones, ingresarCancelacion,
            botonReservaCarga, botonIniciaizarDos, botonPreciosDos, botonIngresarInicializar, botonIngresarPrecios;
    ;
    protected JTextArea textArea, textArea2, textArea3;

    protected JPanel panelUno, panelDos, panelTres, panelCuatro, panelHeader, panelTitulo, panelMenuOperaciones, panelInicializar, panelOperaciones,
            panelReservacion, panelCheckIn, panelCheckOut, panelCancelacion, panelAgregarUsuario, panelColorTres, panelInicializarDos, panelDosExtra, panelPreciosDos;
    ;

    protected JTextField cajaDeTextoCargaInteractivo, diaLlegada, mesLlegada, anoLlegada, diaSalida, mesSalida, anoSalida, CedulaCheckIn, HoraCheckIn,
            CedulaCheckOut, HoraCheckOut, CedulaCancelacion, CedulaReserva, nombreReserva, apellidoReserva, CampoTextoPisos, CampoTextoIndv, CampoTextoDoble, CampoTextoMatri,
            CampoTextoCuadruple, CampoTextoSuite, CampoTextoEsp_C, CampoTextoLom_M, CampoTextoJug_L, CampoTextoMalta, TextoSaldoInicial,
            comboCam_A,comboCaj_F;

    protected JComboBox comboTipoDeHabitacion, comboHoraCheckIn, comboMinutoCheckIn, comboHoraCheckOut, comboMinutoCheckOut, comboCantidadDePersona,
            comboHoraCancelacion, comboMinutoCancelacion, comboAnoLlegada, comboDiaLlegada, comboMesLlegada, comboAnoSalida, comboDiaSalida, comboMesSalida,
            comboTipoEdad;
    protected JScrollPane scroll, scroll2, scroll3;

    
    protected int bandera=0, banderaRevision=0;
    protected String varA,varB,varC,varD,varE,varF,varG,varH;
    
    
    
    protected String[] minutosStrings={"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27",
        "28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59"};
    
    protected String[] horasStrings ={"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
    
    protected String[] diasStrings ={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28"};
    
    protected String[] mesStrings ={"mm","01","02","03","04","05","06","07","08","09","10","11","12"};
    
    protected String[] annioStrings ={"2019","2020","2021","2022","2023"};

    protected String[] SeleccionSiNo = {"No", "Si"};

    public Color myColorLetra = Color.decode("#FFC300");
    public Color myColorHeader = Color.decode("#00010D");
    public Color myColorBoton = Color.decode("#FFF4FF");
    public Color myColorBotonHeader = Color.decode("#FFF4FF");
    public Color myColorBotonLetraHeader = Color.decode("#1F2226");//letra
    public Color myColorFondo = Color.decode("#383D45");//fondo
    public Color myColorHeaderLetraTitulo = Color.decode("#FFF4FF");//letra header
    public Color myColorHeaderTitulo = Color.decode("#383D45");//color mi refugio header

    public class Imagen extends javax.swing.JPanel {

        public Imagen() {
            this.setBounds(0, 0, 1000, 410);
        }

        public void paint(Graphics grafico) {
            Dimension height = getSize();

            ImageIcon Img = new ImageIcon(getClass().getResource("portada.jpg"));

            grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);

            setOpaque(false);
            super.paintComponent(grafico);
        }
    }
    public Ventana() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 500);
        
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
        panelUno.setBounds(0, 70, 1000, 410);

        panelUno.setLayout(null);
        panelUno.setVisible(true);

        panelDos = new JPanel();
        panelDos.setBackground(myColorFondo);
        panelDos.setBounds(0, 70, 1000, 420);
        panelDos.setLayout(null);
        panelDos.setVisible(false);

        panelTres = new JPanel();
        panelTres.setBounds(0, 70, 1000, 420);
        panelTres.setLayout(null);
        panelTres.setVisible(false);

        panelCuatro = new JPanel();
        panelCuatro.setBackground(myColorFondo);
        panelCuatro.setBounds(0, 70, 1000, 420);
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
        botonUnoHeader = new JButton("Inicio");
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

        botonCuatroHeader = new JButton("Archivo salida");
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
        textArea = new JTextArea();
        textArea.setBounds(10, 30, 330, 90);

        String texto = comprobar();

        textArea.setText(texto);
        textArea.setEditable(false);

        panelUno.add(textArea);
        Imagen Imagen = new Imagen();
        panelUno.add(Imagen);
        panelUno.repaint();
        add(panelUno);
    }

    public void PanelPrincipalDos() {
        //todo contenido panel iniciar
        panelInicializarDos = new JPanel();
        panelInicializarDos.setBackground(myColorHeaderTitulo);
        panelInicializarDos.setBounds(0, 0, 1000, 400);
        panelInicializarDos.setLayout(null);
        panelInicializarDos.setVisible(false);

        botonIniciaizarDos = new JButton("Inicializar");
        botonIniciaizarDos.setBackground(myColorBotonHeader);
        botonIniciaizarDos.setForeground(myColorBotonLetraHeader);
        botonIniciaizarDos.setBounds(200, 160, 220, 60);
       
        botonIniciaizarDos.addActionListener(this);

        textoSaldoInicial = new JLabel("Saldo Inicial:");
        textoSaldoInicial.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoSaldoInicial.setBounds(20, 60, 200, 40);
        textoSaldoInicial.setForeground(Color.WHITE);

        TextoSaldoInicial = new JTextField();
        TextoSaldoInicial.setBounds(130, 60, 130, 40);

        textoFechaInicial = new JLabel("Fecha Actual Agregada Automaticamente");
        textoFechaInicial.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoFechaInicial.setBounds(20, 10, 450, 40);
        textoFechaInicial.setForeground(Color.WHITE);

        textoMostrarInicial = new JLabel("Inicializar.in  Generado:");
        textoMostrarInicial.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoMostrarInicial.setBounds(500, 5, 450, 40);
        textoMostrarInicial.setForeground(Color.WHITE);

        textoPisos = new JLabel("Número Pisos:");
        textoPisos.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoPisos.setBounds(20, 110, 200, 40);
        textoPisos.setForeground(Color.WHITE);

        CampoTextoPisos = new JTextField();
        CampoTextoPisos.setBounds(140, 110, 120, 40);

        botonIngresarInicializar = new JButton("Ingresar");
        botonIngresarInicializar.setBackground(myColorBotonHeader);
        botonIngresarInicializar.setForeground(myColorBotonLetraHeader);
        botonIngresarInicializar.setBounds(50, 180, 100, 40);
        botonIngresarInicializar.addActionListener(this);

        textArea2 = new JTextArea();
        String texto;
        textArea2.setEditable(false);
        scroll2 = new JScrollPane(textArea2);
        scroll2.setBounds(450, 40, 300, 400);
        panelInicializarDos.add(scroll2);

        //===============================
        //todo contenido panel precio
        panelPreciosDos = new JPanel();
        panelPreciosDos.setBackground(myColorHeaderTitulo);
        panelPreciosDos.setBounds(0, 0, 1000, 400);
        panelPreciosDos.setLayout(null);
        panelPreciosDos.setVisible(false);

        botonPreciosDos = new JButton("Precios");
        botonPreciosDos.setBackground(myColorBotonHeader);
        botonPreciosDos.setForeground(myColorBotonLetraHeader);
        botonPreciosDos.setBounds(530, 160, 220, 60);
        botonPreciosDos.addActionListener(this);

        //inicializar precios habitaciones
        TextoHabitaciones = new JLabel("-> Precios Habitaciones <-");
        TextoHabitaciones.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        TextoHabitaciones.setBounds(20, 5, 230, 40);
        TextoHabitaciones.setForeground(Color.WHITE);

        textoIndv = new JLabel("Individual: ");
        textoIndv.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoIndv.setBounds(20, 40, 200, 30);
        textoIndv.setForeground(Color.WHITE);

        CampoTextoIndv = new JTextField();
        CampoTextoIndv.setBounds(110, 40, 120, 30);
        CampoTextoIndv.addActionListener(this);

        textoDoble = new JLabel("Doble: ");
        textoDoble.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoDoble.setBounds(20, 70, 200, 30);
        textoDoble.setForeground(Color.WHITE);

        CampoTextoDoble = new JTextField();
        CampoTextoDoble.setBounds(110, 70, 120, 30);
        CampoTextoDoble.addActionListener(this);
        
        textoMatri = new JLabel("Matri: ");
        textoMatri.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoMatri.setBounds(20, 100, 200, 30);
        textoMatri.setForeground(Color.WHITE);

        CampoTextoMatri = new JTextField();
        CampoTextoMatri.setBounds(110, 100, 120, 30);
        CampoTextoMatri.addActionListener(this);

        textoCuadruple = new JLabel("Cuadruple: ");
        textoCuadruple.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoCuadruple.setBounds(20, 130, 200, 30);
        textoCuadruple.setForeground(Color.WHITE);

        CampoTextoCuadruple = new JTextField();
        CampoTextoCuadruple.setBounds(110, 130, 120, 30);
        CampoTextoCuadruple.addActionListener(this);

        textoSuite = new JLabel("Suite: ");
        textoSuite.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoSuite.setBounds(20, 160, 200, 30);
        textoSuite.setForeground(Color.WHITE);

        CampoTextoSuite = new JTextField();
        CampoTextoSuite.setBounds(110, 160, 120, 30);
        CampoTextoSuite.addActionListener(this);

        //inicializar precio servicios
        TextoHabitaciones2 = new JLabel("-> Precios Servicios <-");
        TextoHabitaciones2.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        TextoHabitaciones2.setBounds(20, 210, 200, 40);
        TextoHabitaciones2.setForeground(Color.WHITE);

        textoCam_A = new JLabel("Cama Adicional: ");//CAM_A
        textoCam_A.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoCam_A.setBounds(20, 260, 200, 30);
        textoCam_A.setForeground(Color.WHITE);

        comboCam_A = new JTextField();
        comboCam_A.setBounds(160, 260, 100, 40);
        comboCam_A.addActionListener(this);

        textoCaj_F = new JLabel("Caja fuerte: ");//CAJ_F
        textoCaj_F.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoCaj_F.setBounds(20, 290, 200, 30);
        textoCaj_F.setForeground(Color.WHITE);

        comboCaj_F = new JTextField();
        comboCaj_F.setBounds(160, 290, 100, 40);
        comboCaj_F.addActionListener(this);

        //inicializar precios restaurant
        TextoHabitaciones3 = new JLabel("-> Precios Restaurant <-");
        TextoHabitaciones3.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        TextoHabitaciones3.setBounds(280, 5, 230, 40);
        TextoHabitaciones3.setForeground(Color.WHITE);

        textoEsp_C = new JLabel("Esp_C: ");//ESP_C
        textoEsp_C.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoEsp_C.setBounds(260, 40, 200, 30);
        textoEsp_C.setForeground(Color.WHITE);

        CampoTextoEsp_C = new JTextField();
        CampoTextoEsp_C.setBounds(360, 40, 120, 30);
        CampoTextoEsp_C.addActionListener(this);

        textoLom_M = new JLabel("LOM_M: ");//
        textoLom_M.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoLom_M.setBounds(260, 70, 200, 30);
        textoLom_M.setForeground(Color.WHITE);

        CampoTextoLom_M = new JTextField();
        CampoTextoLom_M.setBounds(360, 70, 120, 30);
        CampoTextoLom_M.addActionListener(this);

        textoJug_L = new JLabel("JUG_L: ");//JUG_L
        textoJug_L.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoJug_L.setBounds(260, 100, 200, 30);
        textoJug_L.setForeground(Color.WHITE);

        CampoTextoJug_L = new JTextField();
        CampoTextoJug_L.setBounds(360, 100, 120, 30);
         CampoTextoJug_L.addActionListener(this);
        
        textoMalta = new JLabel("MALTA: ");//MALTA
        textoMalta.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoMalta.setBounds(260, 130, 200, 30);
        textoMalta.setForeground(Color.WHITE);

        CampoTextoMalta = new JTextField();
        CampoTextoMalta.setBounds(360, 130, 120, 30);
        CampoTextoMalta.addActionListener(this);
        
        botonIngresarPrecios = new JButton("Ingresar");   //boton ingresar precios
        botonIngresarPrecios.setBackground(myColorBotonHeader);
        botonIngresarPrecios.setForeground(myColorBotonLetraHeader);
        botonIngresarPrecios.setBounds(330, 250, 150, 70);
        botonIngresarPrecios.addActionListener(this);

        textoMostrarInicial2 = new JLabel("");
        textoMostrarInicial2.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoMostrarInicial2.setBounds(680, 5, 450, 40);
        textoMostrarInicial2.setForeground(Color.WHITE);



        //panel extra 
        panelDosExtra = new JPanel();
        panelDosExtra.setBackground(myColorHeaderTitulo);
        panelDosExtra.setBounds(0, 0, 1000, 400);
        panelDosExtra.setLayout(null);
        panelDosExtra.setVisible(false);

        //===============================
        //texto menu principal 2
        textoAbrirArchivoInicializar = new JLabel("Abrir Archivos Inicializar.in");
        textoAbrirArchivoInicializar.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
        textoAbrirArchivoInicializar.setBounds(10, 14, 281, 51);
        textoAbrirArchivoInicializar.setForeground(Color.WHITE);

        textoAbrirArchivoPrecio = new JLabel("Abrir Archivos Precio.in");
        textoAbrirArchivoPrecio.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
        textoAbrirArchivoPrecio.setBounds(10, 65, 281, 51);
        textoAbrirArchivoPrecio.setForeground(Color.WHITE);

        //- - - - - //botones menu principal 2
        botonAbrirArchivoInicializar = new JButton("Abrir Archivo");
        botonAbrirArchivoInicializar.setBounds(300, 25, 150, 40);
        botonAbrirArchivoInicializar.setForeground(myColorBotonLetraHeader);
        botonAbrirArchivoInicializar.setBackground(myColorBotonHeader);
        botonAbrirArchivoInicializar.addActionListener(this);

        botonAbrirArchivoPrecio = new JButton("Abrir Archivo");
        botonAbrirArchivoPrecio.setBounds(300, 75, 150, 40);
        botonAbrirArchivoPrecio.setForeground(myColorBotonLetraHeader);
        botonAbrirArchivoPrecio.setBackground(myColorBotonHeader);
        botonAbrirArchivoPrecio.addActionListener(this);

        //- - - - -
        textoCargaInteractiva = new JLabel("Carga Interactiva");
        textoCargaInteractiva.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
        textoCargaInteractiva.setBounds(10, 150, 221, 51);
        textoCargaInteractiva.setForeground(Color.WHITE);
        //===============================
        //panel extra
        panelDosExtra.add(botonAbrirArchivoInicializar);
        panelDosExtra.add(botonAbrirArchivoPrecio);
        panelDosExtra.add(textoAbrirArchivoInicializar);
        panelDosExtra.add(textoAbrirArchivoPrecio);
        panelDosExtra.add(textoCargaInteractiva);

        panelDosExtra.add(botonIniciaizarDos);
        panelDosExtra.add(botonPreciosDos);
        panelDos.add(panelDosExtra);

        //===============================
        //action listener botones
        botonIniciaizarDos.addActionListener(this);
        botonPreciosDos.addActionListener(this);

        //===============================
        //agregar a panel inicializar
        panelInicializarDos.add(textoSaldoInicial);
        panelInicializarDos.add(TextoSaldoInicial);
        panelInicializarDos.add(textoFechaInicial);
        panelInicializarDos.add(textoPisos);
        panelInicializarDos.add(CampoTextoPisos);
        panelInicializarDos.add(botonIngresarInicializar);
        panelInicializarDos.add(textoMostrarInicial);
        //=============================== 
        //agregar a panel precios    

        panelPreciosDos.add(TextoHabitaciones);
        panelPreciosDos.add(textoIndv);
        panelPreciosDos.add(CampoTextoIndv);
        panelPreciosDos.add(textoDoble);
        panelPreciosDos.add(CampoTextoDoble);
        panelPreciosDos.add(textoMatri);
        panelPreciosDos.add(CampoTextoMatri);
        panelPreciosDos.add(textoCuadruple);
        panelPreciosDos.add(CampoTextoCuadruple);
        panelPreciosDos.add(textoSuite);
        panelPreciosDos.add(CampoTextoSuite);
        panelPreciosDos.add(TextoHabitaciones2);
        panelPreciosDos.add(TextoHabitaciones3);
        panelPreciosDos.add(textoEsp_C);
        panelPreciosDos.add(CampoTextoEsp_C);
        panelPreciosDos.add(textoLom_M);
        panelPreciosDos.add(CampoTextoLom_M);
        panelPreciosDos.add(textoJug_L);
        panelPreciosDos.add(CampoTextoJug_L);
        panelPreciosDos.add(textoMalta);
        panelPreciosDos.add(CampoTextoMalta);
        panelPreciosDos.add(textoCam_A);
        panelPreciosDos.add(comboCam_A);
        panelPreciosDos.add(textoCaj_F);
        panelPreciosDos.add(comboCaj_F);
        panelPreciosDos.add(botonIngresarPrecios);
        panelPreciosDos.add(botonIngresarPrecios);
        panelPreciosDos.add(textoMostrarInicial2);

        panelDos.add(panelInicializarDos);
        panelDos.add(panelPreciosDos);
        add(panelDos);
    }

    public void PanelPrincipalTres() {

        panelColorTres = new JPanel();
        panelColorTres.setBackground(myColorFondo);
        panelColorTres.setBounds(0, 0, 1000, 420);
        panelColorTres.setLayout(null);
        panelColorTres.setVisible(true);

        panelReservacion = new JPanel();
        panelReservacion.setBackground(myColorFondo);
        panelReservacion.setBounds(0, 0, 1000, 420);
        panelReservacion.setLayout(null);
        panelReservacion.setVisible(false);

        panelCheckIn = new JPanel();
        panelCheckIn.setBackground(myColorFondo);
        panelCheckIn.setBounds(0, 0, 1000, 420);
        panelCheckIn.setLayout(null);
        panelCheckIn.setVisible(false);

        panelCheckOut = new JPanel();
        panelCheckOut.setBackground(myColorFondo);
        panelCheckOut.setBounds(0, 0, 1000, 420);
        panelCheckOut.setLayout(null);
        panelCheckOut.setVisible(false);

        panelCancelacion = new JPanel();
        panelCancelacion.setBackground(myColorFondo);
        panelCancelacion.setBounds(0, 0, 1000, 420);
        panelCancelacion.setLayout(null);
        panelCancelacion.setVisible(false);

        //========================================
        panelAgregarUsuario = new JPanel();
        panelAgregarUsuario.setBackground(Color.red);
        panelAgregarUsuario.setBounds(225, 170, 770, 180);
        panelAgregarUsuario.setVisible(true);
        panelAgregarUsuario.setLayout(null);

        //=========================================
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
        ingresarReserva.setEnabled(false);
        ingresarReserva.addActionListener(this);

        textoFechaLlegada = new JLabel("FECHA LLEGADA");
        textoFechaLlegada.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoFechaLlegada.setBounds(225, 10, 150, 40);
        textoFechaLlegada.setForeground(Color.WHITE);

        comboDiaLlegada = new JComboBox();
        comboDiaLlegada.addItem("dd");
        comboDiaLlegada.setBounds(370, 10, 70, 40);
        comboDiaLlegada.addActionListener(this);

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

        comboDiaSalida = new JComboBox();
        comboDiaSalida.addItem("dd");
        comboDiaSalida.setBounds(760, 10, 70, 40);
        comboDiaSalida.addActionListener(this);

        comboMesSalida = new JComboBox();
        comboMesSalida.addItem("mm");
        comboMesSalida.setBounds(835, 10, 70, 40);
        comboMesSalida.addActionListener(this);

        comboAnoSalida = new JComboBox(annioStrings);
        comboAnoSalida.setBounds(910, 10, 85, 40);
        comboAnoSalida.addActionListener(this);

        textoTipoHabitacion = new JLabel("TIPO HABITACIÓN");
        textoTipoHabitacion.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoTipoHabitacion.setBounds(225, 60, 170, 40);
        textoTipoHabitacion.setForeground(Color.WHITE);

        comboTipoDeHabitacion = new JComboBox();
        comboTipoDeHabitacion.addItem("Seleccione");
        comboTipoDeHabitacion.addItem("INDIV");
        comboTipoDeHabitacion.addItem("DOBLE");
        comboTipoDeHabitacion.addItem("MATRI");
        comboTipoDeHabitacion.addItem("CUADR");
        comboTipoDeHabitacion.addItem("SUITE");
        comboTipoDeHabitacion.setBounds(450, 60, 175, 40);
        comboTipoDeHabitacion.addActionListener(this);

        textoCantPersona = new JLabel("NUMERO PERSONAS");
        textoCantPersona.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoCantPersona.setBounds(225, 110, 200, 40);
        textoCantPersona.setForeground(Color.WHITE);

        comboCantidadDePersona = new JComboBox();
        comboCantidadDePersona.addItem("Seleccione");
        comboCantidadDePersona.setBounds(450, 110, 175, 40);
        comboCantidadDePersona.addActionListener(this);

        comboTipoEdad = new JComboBox();
        comboTipoEdad.addItem("A");
        comboTipoEdad.addItem("N");
        comboTipoEdad.setBounds(230, 170, 60, 40);
        comboTipoEdad.addActionListener(this);

        CedulaReserva = new JTextField("Cedula");
        CedulaReserva.setBounds(300, 170, 120, 40);
        CedulaReserva.addActionListener(this);

        nombreReserva = new JTextField("Nombre");
        nombreReserva.setBounds(430, 170, 120, 40);
        nombreReserva.addActionListener(this);

        apellidoReserva = new JTextField("Apellido");
        apellidoReserva.setBounds(560, 170, 120, 40);
        apellidoReserva.addActionListener(this);

        botonReservaCarga = new JButton("Agregar");
        botonReservaCarga.setBounds(690, 170, 100, 40);
        botonReservaCarga.setForeground(myColorBotonLetraHeader);
        botonReservaCarga.setBackground(myColorBotonHeader);
        botonReservaCarga.setEnabled(false);
        botonReservaCarga.addActionListener(this);

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
        CedulaCheckIn.addActionListener(this);

        textoHoraCheckIn = new JLabel("INGRESE HORA");
        textoHoraCheckIn.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoHoraCheckIn.setBounds(225, 50, 200, 40);
        textoHoraCheckIn.setForeground(Color.WHITE);

        comboHoraCheckIn = new JComboBox(horasStrings);
        comboHoraCheckIn.setBounds(450, 60, 45, 40);
        comboHoraCheckIn.addActionListener(this);

        textoDosPuntos = new JLabel(":");
        textoDosPuntos.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoDosPuntos.setBounds(507, 60, 10, 40);
        textoDosPuntos.setForeground(Color.WHITE);

        comboMinutoCheckIn = new JComboBox(minutosStrings);

        comboMinutoCheckIn.setBounds(525, 60, 45, 40);
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
        comboHoraCheckOut.setBounds(450, 60, 45, 40);
        comboHoraCheckOut.addActionListener(this);

        textoDosPuntosOut = new JLabel(":");
        textoDosPuntosOut.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoDosPuntosOut.setBounds(507, 60, 10, 40);
        textoDosPuntosOut.setForeground(Color.WHITE);

        comboMinutoCheckOut = new JComboBox(minutosStrings);

        comboMinutoCheckOut.setBounds(525, 60, 45, 40);
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

        comboHoraCancelacion = new JComboBox(horasStrings);
        comboHoraCancelacion.setBounds(450, 60, 45, 40);
        comboHoraCancelacion.addActionListener(this);

        textoDosPuntosCancelacion = new JLabel(":");
        textoDosPuntosCancelacion.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoDosPuntosCancelacion.setBounds(507, 60, 10, 40);
        textoDosPuntosCancelacion.setForeground(Color.WHITE);

        comboMinutoCancelacion = new JComboBox(minutosStrings);

        comboMinutoCancelacion.setBounds(525, 60, 45, 40);
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
        panelTres.add(panelColorTres);
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
        panelReservacion.add(comboTipoEdad);
        panelReservacion.add(CedulaReserva);
        panelReservacion.add(nombreReserva);
        panelReservacion.add(apellidoReserva);
        panelReservacion.add(botonReservaCarga);

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
        String texto;
        textArea.setEditable(false);
        scroll = new JScrollPane(textArea);
        scroll.setBounds(225, 0, 770, 410);
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
            panelColorTres.setVisible(false);

        } else if (e.getSource() == botonIniciaizarDos) {
            panelUno.setVisible(false);
            panelDos.setVisible(true);
            panelTres.setVisible(false);
            panelCuatro.setVisible(false);
            Inicializar_in();
             JOptionPane.showMessageDialog(null, "El archivo inicializar se genero automaticamente");
            panelDosExtra.setVisible(false);
            

        } else if (e.getSource() == botonPreciosDos) {
            panelUno.setVisible(false);
            panelDos.setVisible(true);
            panelTres.setVisible(false);
            panelCuatro.setVisible(false);
            panelPreciosDos.setVisible(true);
            panelDosExtra.setVisible(false);

        } else if (e.getSource() == botonDosHeader) {
            panelUno.setVisible(false);
            panelDos.setVisible(true);
            panelTres.setVisible(false);
            panelCuatro.setVisible(false);

            panelColorTres.setVisible(false);

            panelInicializarDos.setVisible(false);
            panelPreciosDos.setVisible(false);
            panelDosExtra.setVisible(true);

        } else if (e.getSource() == botonTresHeader) {
            panelUno.setVisible(false);
            panelDos.setVisible(false);
            panelTres.setVisible(true);
            panelCuatro.setVisible(false);
            panelColorTres.setVisible(true);

            panelReservacion.setVisible(false);
            panelCheckIn.setVisible(false);
            panelCheckOut.setVisible(false);
            panelCancelacion.setVisible(false);

        } else if (e.getSource() == botonCuatroHeader) {
            panelUno.setVisible(false);
            panelDos.setVisible(false);
            panelTres.setVisible(false);
            panelCuatro.setVisible(true);
            panelColorTres.setVisible(false);
        } else if (e.getSource() == botonReservacion) {
            panelReservacion.setVisible(true);
            panelCheckIn.setVisible(false);
            panelCheckOut.setVisible(false);
            panelCancelacion.setVisible(false);
            panelColorTres.setVisible(false);
        } else if (e.getSource() == botonCheckIn) {
            panelReservacion.setVisible(false);
            panelCheckIn.setVisible(true);
            panelCheckOut.setVisible(false);
            panelCancelacion.setVisible(false);
            panelColorTres.setVisible(false);

        } else if (e.getSource() == botonCheckOut) {
            panelReservacion.setVisible(false);
            panelCheckIn.setVisible(false);
            panelCheckOut.setVisible(true);
            panelCancelacion.setVisible(false);
            panelColorTres.setVisible(false);

        } else if (e.getSource() == botonCancelacion) {
            panelReservacion.setVisible(false);
            panelCheckIn.setVisible(false);
            panelCheckOut.setVisible(false);
            panelCancelacion.setVisible(true);
            panelColorTres.setVisible(false);
        }else if(e.getSource()==ingresarCheckIn){
            if(CedulaCheckIn.getText().length()>0){
   
                         try{
                            BufferedWriter BR = new BufferedWriter(new FileWriter("operaciones.in",true));
                            BR.write("\n3\n");
                            String varCheck=(CedulaCheckIn.getText());
                            BR.write(varCheck+" ");
                            String varMinCheck=(comboMinutoCheckIn.getSelectedItem().toString());
                            String varHoraCheck=(comboHoraCheckIn.getSelectedItem().toString());
                            BR.write(varMinCheck+":"+varHoraCheck+"\n");
                            BR.close();
                         }catch(Exception ex){
                             
                         }                                                             
            }
        }else if(e.getSource()==ingresarCheckOut){
            if(CedulaCheckOut.getText().length()>0){
   
                         try{
                            BufferedWriter BR = new BufferedWriter(new FileWriter("operaciones.in",true));
                            BR.write("\n4\n");
                            String varCheck=(CedulaCheckOut.getText());
                            BR.write(varCheck+" ");
                            String varMinCheck=(comboMinutoCheckOut.getSelectedItem().toString());
                            String varHoraCheck=(comboHoraCheckOut.getSelectedItem().toString());
                            BR.write(varMinCheck+":"+varHoraCheck+"\n");
                            BR.close();
                         }catch(Exception ex){
                             
                         }                               
                                                        
                                                        
                
            }
                                                    
            
        }else if(e.getSource()==ingresarCancelacion){
            if(CedulaCheckIn.getText().length()>0){
   
                         try{
                            BufferedWriter BR = new BufferedWriter(new FileWriter("operaciones.in",true));
                            BR.write("\n2\n");
                            String varCheck=(CedulaCancelacion.getText());
                            BR.write(varCheck+" ");
                            String varMinCheck=(comboMinutoCancelacion.getSelectedItem().toString());
                            String varHoraCheck=(comboHoraCancelacion.getSelectedItem().toString());
                            BR.write(varMinCheck+":"+varHoraCheck+"\n");
                            BR.close();
                         }catch(Exception ex){
                             
                         }                               
                                                        
                                                        
                
            }
                                                    
            
        }   
        
        
        else if (e.getSource() == ingresarReserva) {
            try {


                if((Integer.parseInt(comboAnoLlegada.getSelectedItem().toString())) == (Integer.parseInt(comboAnoSalida.getSelectedItem().toString())) ){
                        if((Integer.parseInt(comboMesLlegada.getSelectedItem().toString())) == (Integer.parseInt(comboMesSalida.getSelectedItem().toString())) ){
                                if((Integer.parseInt(comboDiaLlegada.getSelectedItem().toString())) < (Integer.parseInt(comboDiaSalida.getSelectedItem().toString())) ){
                                     JOptionPane.showMessageDialog(null, "Fecha Ingresada Corecta(dia)");
                
                                     
                                     banderaRevision=1;
                                }else{
                                    JOptionPane.showMessageDialog(null, "Dia Ingresado Erroneo o menor a la esperado");
      
                                    banderaRevision=0;
                                }
                        }else if((Integer.parseInt(comboMesLlegada.getSelectedItem().toString())) <(Integer.parseInt(comboMesSalida.getSelectedItem().toString())) ){
                             JOptionPane.showMessageDialog(null, "Fecha Ingresada Corecta(mes)");
              
                             
                             banderaRevision=1;
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Mes Ingresado Erroneo o menor a lo esperado");
           
                            banderaRevision=0;
                        }
                    } else if ((Integer.parseInt(comboMesLlegada.getSelectedItem().toString())) <= (Integer.parseInt(comboMesSalida.getSelectedItem().toString()))) {
                        JOptionPane.showMessageDialog(null, "Fecha Ingresada Corecta(mes)");
                    } else {
                        JOptionPane.showMessageDialog(null, "Mes Ingresado Erroneo o menor a lo esperado");
                    }
                  if ((Integer.parseInt(comboAnoLlegada.getSelectedItem().toString())) < (Integer.parseInt(comboAnoSalida.getSelectedItem().toString()))) {
                    JOptionPane.showMessageDialog(null, "Fecha Ingresada Corecta(año)");

  
                    banderaRevision=1;
                }
                else{

                    JOptionPane.showMessageDialog(null, "Año Ingresado Erroneo o menor a lo esperado");
          
                    banderaRevision=0;
                }
                if (comboTipoDeHabitacion.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Ingrese una Opcion en tipo habitación");
           
                    banderaRevision=0;
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
   
                banderaRevision=0;
            }


            if(bandera==789 &&banderaRevision==1){
                try{
                    
                    varF = (comboDiaLlegada.getSelectedItem().toString())+" "+(comboMesLlegada.getSelectedItem().toString())+" "+(comboAnoLlegada.getSelectedItem().toString());
                    varG =(comboDiaSalida.getSelectedItem().toString())+" "+(comboMesSalida.getSelectedItem().toString())+" "+(comboAnoSalida.getSelectedItem().toString());
                    

                    BufferedWriter BR = new BufferedWriter(new FileWriter("operaciones.in",true));
                    BR.write("1\n");
                    BR.write(varF + " "+ varG+"\n");
                    BR.write(varH+"\n");
                    BR.write(varE+"\n");
                    
                    BufferedReader br =new BufferedReader(new FileReader("operaciones.txt"));
                    String cadena;
                    while((cadena=br.readLine())!=null){
                        BR.write(cadena+"\n");
                    }
 
                    br.close();
     
                    BR.close();
                    
                }catch(Exception ex){}
                
            }

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
        } else if (e.getSource() == comboTipoDeHabitacion) {
            comboCantidadDePersona.removeAllItems();
            bandera = 0;
            System.out.println("Entre");
            botonReservaCarga.setEnabled(true);
            ingresarReserva.setEnabled(false);
            if (comboTipoDeHabitacion.getSelectedIndex() == 0) {
                botonReservaCarga.setEnabled(false);
            } else if (comboTipoDeHabitacion.getSelectedIndex() == 1) {
                comboCantidadDePersona.addItem("1");
            } else if (comboTipoDeHabitacion.getSelectedIndex() == 2) {
                comboCantidadDePersona.addItem("1");
                comboCantidadDePersona.addItem("2");
            } else if (comboTipoDeHabitacion.getSelectedIndex() == 3) {
                comboCantidadDePersona.addItem("1");
                comboCantidadDePersona.addItem("2");
                comboCantidadDePersona.addItem("3");
            } else if (comboTipoDeHabitacion.getSelectedIndex() == 4) {
                comboCantidadDePersona.addItem("1");
                comboCantidadDePersona.addItem("2");
                comboCantidadDePersona.addItem("3");
                comboCantidadDePersona.addItem("4");

            } else if (comboTipoDeHabitacion.getSelectedIndex() == 5) {
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

        }else if(e.getSource()==botonReservaCarga){
            varH= (comboTipoDeHabitacion.getSelectedItem().toString());
            varE= (comboCantidadDePersona.getSelectedItem().toString());
                int a = 0,b=0,c=0,d=0;
                if(((CedulaReserva.getText()).length())==8&&comboTipoEdad.getSelectedIndex()==0){
                            try{
                                int var = Integer.parseInt((CedulaReserva.getText()));
                                
                                a=1;
                                 varA=CedulaReserva.getText().toString();
                                 varB="A";
                            }catch (Exception ex){
                                    
                                    JOptionPane.showMessageDialog(null, "Cedula erronea");
                                    a=0;
                                }
                                
                }else if(comboTipoEdad.getSelectedIndex()==1){
                    a=2;
                    varA=" ";
                    varB="N";
                }else if(((CedulaReserva.getText()).length())!=8){
                    
                    
                                JOptionPane.showMessageDialog(null, "La cedula tiene que tener 8 digitos");
                                a=0;
                            }
                            
                            if(((nombreReserva.getText()).length())>2){
                                varC = nombreReserva.getText().toString();
                               b=1;
                            }else{
                                JOptionPane.showMessageDialog(null, "Nombre muy corto");
                                b=0;
                            }
                            
                            if((apellidoReserva.getText().length())>2){
                                varD = apellidoReserva.getText().toString();
                                d=1;
                            }else{
                                JOptionPane.showMessageDialog(null, "Apellido muy corto");
                                d=0;
                            }
                            try{
                                 BufferedWriter BR = new BufferedWriter(new FileWriter("operaciones.txt",true));
                                 
                                 if(a==1&&b==1&&d==1){
                                    bandera++;
                                     BR.write(varB+" "+varA+" "+varC+" "+varD+"\n");
                                
                            }else if(a==2&&b==1&&d==1){
                                bandera++;
                                BR.write(varB+" "+varA+" "+varC+" "+varD+"\n");
                            }
                    
                                 BR.close();
                            }catch(Exception ex){}
                            
                            
                            if((bandera-1)==comboCantidadDePersona.getSelectedIndex()){
                                botonReservaCarga.setEnabled(false);
                                ingresarReserva.setEnabled(true);
                                bandera =789;
                            }
                            
        } else if (e.getSource() == comboAnoLlegada) {
            comboMesLlegada.removeAllItems();
            for (int i = 1; mesStrings.length > i; i++) {
                comboMesLlegada.addItem(mesStrings[i]);
                comboDiaLlegada.addItem("29");
                comboDiaLlegada.addItem("30");
                comboDiaLlegada.addItem("31");
            }
        }else if(e.getSource() == botonIngresarPrecios){
            
                
  
                  if(CampoTextoIndv.getText().length()>0){
                      if(CampoTextoDoble.getText().length()>0){
                           if(CampoTextoMatri.getText().length()>0){
                               if(CampoTextoSuite.getText().length()>0){
                               if(CampoTextoCuadruple.getText().length()>0){
                                   if(CampoTextoEsp_C.getText().length()>0){
                                        if(CampoTextoLom_M.getText().length()>0){
                                            if(CampoTextoJug_L.getText().length()>0){
                                                if(CampoTextoMalta.getText().length()>0){
                                                    if(comboCam_A.getText().length()>0){
                                                        if(comboCaj_F.getText().length()>0){
                                                            try{
                                                                BufferedWriter BR = new BufferedWriter(new FileWriter("precios.in"));
                                                                BR.write("INDIV "+CampoTextoIndv.getText());
                                                                BR.write("\nDOBLE "+CampoTextoDoble.getText());
                                                                BR.write("\nMATRI  "+CampoTextoMatri.getText());
                                                                BR.write("\nCUADR "+CampoTextoCuadruple.getText());
                                                                BR.write("\nSUITE "+CampoTextoSuite.getText());
                                                                BR.write("\nCAM_A "+comboCam_A.getText()+" Cama Adicional");
                                                                BR.write("\nCAM_F "+comboCaj_F.getText()+" CajaFuerte");
                                                                BR.write("\nESP_C "+CampoTextoEsp_C.getText()+" Espaguetis a la Carbonara");
                                                                BR.write("\nLOM_M "+CampoTextoLom_M.getText()+" Lomito a la Mostaza");
                                                                BR.write("\nJUG_L "+CampoTextoJug_L.getText()+" Jugo light");
                                                                BR.write("\nMALTA "+CampoTextoMalta.getText()+" Malta");
                                                                BR.close();
                                                                JOptionPane.showMessageDialog(null, "Archivo creado exitosamente");
                                                            }catch(Exception ex){
                                                            JOptionPane.showMessageDialog(null, "Hubo un error");
                                                            }
                                                            
                                                            
                                                            
                                                            
                                                        }
                                                    }
                                                    
                                                }
                                            }
                                        }
                                   }
                               }
                               }
                           }
                  }}
                  
                    
                    
                    
                                 
                                    
                                         
                                             
        } 
        
        else if (e.getSource() == comboMesLlegada) {
            Integer varNum = Integer.parseInt(comboAnoLlegada.getSelectedItem().toString());
            varNum = varNum % 4;

            if (comboMesLlegada.getSelectedIndex() != 0) {
                comboDiaLlegada.removeAllItems();
                for (int i = 0; diasStrings.length > i; i++) {
                    comboDiaLlegada.addItem(diasStrings[i]);
                }
                if (varNum == 0 && comboMesLlegada.getSelectedIndex() == 1) {
                    comboDiaLlegada.addItem("29");
                }
                if (comboMesLlegada.getSelectedIndex() == 3 || comboMesLlegada.getSelectedIndex() == 5 || comboMesLlegada.getSelectedIndex() == 8
                        || comboMesLlegada.getSelectedIndex() == 10) {
                    comboDiaLlegada.addItem("29");
                    comboDiaLlegada.addItem("30");
                }
                if (comboMesLlegada.getSelectedIndex() == 0 || comboMesLlegada.getSelectedIndex() == 2 || comboMesLlegada.getSelectedIndex() == 4
                        || comboMesLlegada.getSelectedIndex() == 6 || comboMesLlegada.getSelectedIndex() == 7 || comboMesLlegada.getSelectedIndex() == 9
                        || comboMesLlegada.getSelectedIndex() == 11) {
                    comboDiaLlegada.addItem("29");
                    comboDiaLlegada.addItem("30");
                    comboDiaLlegada.addItem("31");
                }
            }
        } else if (e.getSource() == comboAnoSalida) {
            comboMesSalida.removeAllItems();
            for (int i = 1; mesStrings.length > i; i++) {
                comboMesSalida.addItem(mesStrings[i]);
                comboDiaSalida.addItem("29");
                comboDiaSalida.addItem("30");
                comboDiaSalida.addItem("31");
            }
        } else if (e.getSource() == comboMesSalida) {
            Integer varNum = Integer.parseInt(comboAnoSalida.getSelectedItem().toString());
            varNum = varNum % 4;

            if (comboMesSalida.getSelectedIndex() != 0) {
                comboDiaSalida.removeAllItems();
                for (int i = 0; diasStrings.length > i; i++) {
                    comboDiaSalida.addItem(diasStrings[i]);
                }
                if (varNum == 0 && comboMesSalida.getSelectedIndex() == 1) {
                    comboDiaSalida.addItem("29");
                }
                if (comboMesSalida.getSelectedIndex() == 3 || comboMesSalida.getSelectedIndex() == 5 || comboMesSalida.getSelectedIndex() == 8
                        || comboMesSalida.getSelectedIndex() == 10) {
                    comboDiaSalida.addItem("29");
                    comboDiaSalida.addItem("30");

                }
                if (comboMesSalida.getSelectedIndex() == 0 || comboMesSalida.getSelectedIndex() == 2 || comboMesSalida.getSelectedIndex() == 4
                        || comboMesSalida.getSelectedIndex() == 6 || comboMesSalida.getSelectedIndex() == 7 || comboMesSalida.getSelectedIndex() == 9
                        || comboMesSalida.getSelectedIndex() == 11) {
                    comboDiaSalida.addItem("29");
                    comboDiaSalida.addItem("30");
                    comboDiaSalida.addItem("31");
                }
            }
        } else if (e.getSource() == botonAbrirArchivoInicializar) {

            BuscarArchivo();

        } else if (e.getSource() == botonAbrirArchivoPrecio) {

            BuscarArchivo();

        }
    }
    public static String fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);
    }
    
    public void BuscarArchivo() {
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
    public String comprobar() {
        String sFichero = "inicializar.in";
        File fichero = new File(sFichero);

        String comprobacion, comprobacion2;

        if (fichero.exists()) {

            comprobacion = "El archivo " + sFichero + " si existe";
            botonAbrirArchivoInicializar.setEnabled(false);
            
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
    public void Inicializar_in() {
        try {
            FileWriter fichero = new FileWriter("Reservar.csv", true);
            fichero.write("NombreTitular;ApellidoTitular;RutTitular;NombreAcompanante;ApellidoAcompanante;RutAcompanante;Grupo;FechaEntrada;FechaSalida;Hora\n");
            fichero.close();
        } catch (IOException ex) {
        }

        String ValorHotel = "100250.00";
        try {
            FileWriter fichero = new FileWriter("inicializar.in");
            fichero.append(ValorHotel);
            fichero.write("\r\n");
            String anio = null;
            String mes;
            String dia;

            fichero.write("01" + " " + "01" + " " + "2019");
            fichero.append("\r\n");

            int NumeroPiso = (int) (Math.random() * 10) + 1;
            List<String>[] ListaTipoHabitacion = new List[NumeroPiso];

            String n_1 = Integer.toString(NumeroPiso);
            int cont = 0;

            for (int x = 0; x < NumeroPiso; x++) {
                int NumeroHabitaciones = (int) (Math.random() * 5) + 1;

                List<String> ListaHabitacion = new ArrayList<>();

                for (int i = 0; i < NumeroHabitaciones; i++) {
                    int TipoDeHabitacion = (int) (Math.random() * 5) + 1;
                    String Habitacion = Integer.toString(TipoDeHabitacion);

                    ListaHabitacion.add(Habitacion);
                    cont++;

                }
                ListaTipoHabitacion[x] = ListaHabitacion;

            }
            String contador = Integer.toString(cont);
            fichero.write(contador + " ");
            fichero.write(n_1);
            fichero.append("\r\n");

            for (int x = 0; x < NumeroPiso; x++) {
                List<String> LH = new ArrayList<>();

                fichero.write(ListaTipoHabitacion[x].size() + " ");

                LH.addAll(ListaTipoHabitacion[x]);

                for (int y = 0; y < ListaTipoHabitacion[x].size(); y++) {

                    String var = LH.get(y);

                    if (var.equals("1")) {
                        fichero.write("INDIV" + " ");

                    } else if (var.equals("2")) {
                        fichero.write("MATRI" + " ");

                    } else if (var.equals("3")) {
                        fichero.write("DOBLE" + " ");

                    } else if (var.equals("4")) {
                        fichero.write("CUADR" + " ");

                    } else if (var.equals("5")) {
                        fichero.write("SUITE" + " ");

                    }
                }
                fichero.append("\r\n");

            }

            fichero.close();

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        try {
            FileReader lector = new FileReader("inicializar.in.txt");
            BufferedReader BR = new BufferedReader(lector);
            String cadena;

            while ((cadena = BR.readLine()) != null) {

            }

            BR.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
