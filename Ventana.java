package ProyectoHotel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Ventana extends JFrame implements ActionListener {

    protected JLabel headerTitulo, textoAbrirArchivo, textoCargaInteractiva,
            textoArchivoDeSalida, textoFechaLlegada, textoFechaSalida,
            textoTipoHabitacion, textoCantPersona, textoCedulaCheckIn, textoHoraCheckIn,textoCedulaCheckOut,textoHoraCheckOut;

    protected JButton botonUnoHeader, botonDosHeader, botonTresHeader, botonCuatroHeader, abrirArchivo, ingresarReserva, ingresarCheckIn,ingresarCheckOut;
    protected JButton botonEnviarCargaInteractiva, botonReservacion, botonCheckIn, botonCheckOut, botonCancelacion;
    protected JTextArea textArea;
    protected JPanel panelUno, panelDos, panelTres, panelCuatro, panelHeader, panelTitulo, panelMenuOperaciones;
    protected JPanel panelReservacion, panelCheckIn, panelCheckOut, panelCancelacion;
    protected JTextField cajaDeTextoCargaInteractivo, diaLlegada, mesLlegada, anoLlegada, diaSalida, mesSalida, anoSalida, CedulaCheckIn, HoraCheckIn,CedulaCheckOut,HoraCheckOut;
    
    protected JComboBox comboTipoDeHabitacion = new JComboBox();
    protected JComboBox comboCantidadDePersona = new JComboBox();
    
    
		
    
    
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
        textoAbrirArchivo = new JLabel("Abrir Archivos");
        textoAbrirArchivo.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
        textoAbrirArchivo.setBounds(10, 14, 221, 51);
        textoAbrirArchivo.setForeground(Color.WHITE);
        //===============================
        abrirArchivo = new JButton("Abrir Archivo");
        abrirArchivo.setBounds(845, 15, 150, 40);
        abrirArchivo.setForeground(myColorBotonLetraHeader);
        abrirArchivo.setBackground(myColorBotonHeader);
        abrirArchivo.addActionListener(this);
        //===============================
        textoCargaInteractiva = new JLabel("Carga Interactiva");
        textoCargaInteractiva.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
        textoCargaInteractiva.setBounds(10, 100, 221, 51);
        textoCargaInteractiva.setForeground(Color.WHITE);
        //===============================
        botonEnviarCargaInteractiva = new JButton("Enviar");
        botonEnviarCargaInteractiva.setBounds(855, 100, 150, 40);
        botonEnviarCargaInteractiva.setForeground(myColorBotonLetraHeader);
        botonEnviarCargaInteractiva.setBackground(myColorBotonHeader);

        //===============================
        cajaDeTextoCargaInteractivo = new JTextField("Pisos del hotel");
        cajaDeTextoCargaInteractivo.setBounds(635, 100, 220, 40);
        panelDos.add(cajaDeTextoCargaInteractivo);

        panelDos.add(botonEnviarCargaInteractiva);
        panelDos.add(abrirArchivo);
        panelDos.add(textoAbrirArchivo);
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

        ingresarReserva = new JButton("Ingresar reserva");
        ingresarReserva.setBackground(myColorBotonHeader);
        ingresarReserva.setForeground(myColorBotonLetraHeader);
        ingresarReserva.setBounds(500, 350, 200, 40);
        ingresarReserva.addActionListener(this);

        textoFechaLlegada = new JLabel("FECHA LLEGADA");
        textoFechaLlegada.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoFechaLlegada.setBounds(225, 10, 150, 40);
        textoFechaLlegada.setForeground(Color.WHITE);

        diaLlegada = new JTextField();
        diaLlegada.setBounds(380, 10, 30, 40);

        mesLlegada = new JTextField();
        mesLlegada.setBounds(410, 10, 30, 40);

        anoLlegada = new JTextField();
        anoLlegada.setBounds(440, 10, 50, 40);
        //======================================
        textoFechaSalida = new JLabel("FECHA SALIDA");
        textoFechaSalida.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        textoFechaSalida.setBounds(500, 10, 150, 40);
        textoFechaSalida.setForeground(Color.WHITE);

        diaSalida = new JTextField();
        diaSalida.setBounds(650, 10, 30, 40);

        mesSalida = new JTextField();
        mesSalida.setBounds(680, 10, 30, 40);

        anoSalida = new JTextField();
        anoSalida.setBounds(710, 10, 50, 40);

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

        HoraCheckIn = new JTextField();
        HoraCheckIn.setBounds(390, 50, 120, 40);
        
        
        
        
        

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

        HoraCheckOut = new JTextField();
        HoraCheckOut.setBounds(390, 50, 120, 40);

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
        panelReservacion.add(diaLlegada);
        panelReservacion.add(anoLlegada);
        panelReservacion.add(mesLlegada);
        panelReservacion.add(diaSalida);
        panelReservacion.add(anoSalida);
        panelReservacion.add(mesSalida);
        panelReservacion.add(textoFechaLlegada);
        panelReservacion.add(textoFechaSalida);
        panelReservacion.add(textoTipoHabitacion);
        panelReservacion.add(textoCantPersona);
        panelReservacion.add(comboTipoDeHabitacion);
        panelReservacion.add(comboCantidadDePersona);
         

        panelCheckIn.add(textoCedulaCheckIn);
        panelCheckIn.add(CedulaCheckIn);
        panelCheckIn.add(textoHoraCheckIn);
        panelCheckIn.add(HoraCheckIn);
        panelCheckIn.add(ingresarCheckIn);
        
        panelCheckOut.add(textoCedulaCheckOut);
        panelCheckOut.add(CedulaCheckOut);
        panelCheckOut.add(textoHoraCheckOut);
        panelCheckOut.add(HoraCheckOut);
        panelCheckOut.add(ingresarCheckOut);
        
        add(panelTres);

    }

    public void PanelPrincipalCuatro() {
        textoArchivoDeSalida = new JLabel("Archivos de salida");
        textoArchivoDeSalida.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
        textoArchivoDeSalida.setBounds(400, 14, 221, 51);
        textoArchivoDeSalida.setForeground(Color.WHITE);
        
        panelCuatro.add(textoArchivoDeSalida);
        add(panelTres);
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
            

        }else if (e.getSource()==comboTipoDeHabitacion){
            if(comboTipoDeHabitacion.getSelectedIndex()==1){
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
            
            
        }
        else if (e.getSource() == abrirArchivo) {
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            //Creamos el filtro
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt","in","out");
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
    
    
    public String comprobar(){
        String sFichero = "inicializar.in";
        File fichero = new File(sFichero);
        
        String comprobacion,comprobacion2;

        if (fichero.exists()){
            
            comprobacion="El archivo " + sFichero + " si existe";
            botonDosHeader.setEnabled(false);
        }
        else{
            comprobacion="\nEl archivo " + sFichero + " no existe";
        }
        String dFichero = "precios.in";
        File fichero2 = new File(dFichero);
        
            if(fichero2.exists()){

                comprobacion2="\n\nEl archivo " + dFichero + " si existe";
                botonTresHeader.setEnabled(false);
            }
                else{
                comprobacion2="\n\nEl archivo " + dFichero +" no existe";
                        }
        return comprobacion + comprobacion2;
      
    
    }

}
