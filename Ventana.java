package ProyectoHotel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ventana extends JFrame implements ActionListener{
    protected JLabel headerTitulo, textoAbrirArchivo, textoCargaInteractiva, textoArchivoDeSalida;
    protected JButton botonUnoHeader, botonDosHeader, botonTresHeader, botonCuatroHeader, botonCincoHeader, abrirArchivo;
    protected JButton botonEnviarCargaInteractiva, botonReservacion, botonCheckIn, botonCheckOut, botonCancelacion;
    protected JTextArea textArea;
    protected JPanel panelUno, panelDos, panelTres, panelCuatro, panelHeader, panelTitulo, panelMenuOperaciones;
    protected JPanel panelReservacion, panelCheckIn, panelCheckOut, panelCancelacion;
    protected JTextField cajaDeTextoCargaInteractivo;
    

    
    public Color myColorLetra = Color.decode("#FFC300");
    public Color myColorHeader = Color.decode("#F8B500");
    public Color myColorBoton = Color.decode("#571845");
    public Color myColorBotonHeader = Color.decode("#393E46");
    public Color myColorBotonLetraHeader = Color.decode("#F8B500");
    public Color myColorFondo = Color.decode("#00ADB5");
    public Color myColorHeaderLetraTitulo = Color.decode("#F8B500");
    public Color myColorHeaderTitulo = Color.decode("#FC3C3C");
    
    public Ventana(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 500);
        setTitle("Mi Refugio");
        setLayout(null);
        setLocationRelativeTo(null);
        MenuHeader();
    }
    
    
    public void MenuHeader(){
        panelHeader = new JPanel();
        panelHeader.setBackground(myColorHeader);
        panelHeader.setBounds(0,0,1000,70);
        panelHeader.setLayout(null);
        
        //===============================
        panelUno = new JPanel();
        panelUno.setBackground(myColorFondo);
        panelUno.setBounds( 0, 75, 1000, 400);
        panelUno.setLayout(null);
        panelUno.setVisible(true);
        
         panelDos = new JPanel();
        panelDos.setBackground(myColorFondo);
        panelDos.setBounds( 0, 75, 1000, 400);
        panelDos.setLayout(null);
        panelDos.setVisible(false);
        
        panelTres = new JPanel();
        panelTres.setBounds( 0, 75, 1000, 400);
        panelTres.setLayout(null);
        panelTres.setVisible(false);
        
        panelCuatro = new JPanel();
        panelCuatro.setBackground(myColorFondo);
        panelCuatro.setBounds( 0, 75, 1000, 400);
        panelCuatro.setLayout(null);
        panelCuatro.setVisible(false);
        
        
        //=======================================
        
        panelTitulo = new JPanel();
        panelTitulo.setBackground(myColorHeaderTitulo);
        panelTitulo.setBounds(0,0,220,100);
        panelTitulo.setLayout(null);
        
        headerTitulo = new JLabel("Mi Refugio");
        headerTitulo.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 30));
        headerTitulo.setBounds(10, 14, 210 ,51);
        headerTitulo.setForeground(myColorHeaderLetraTitulo);
        
        
        //========================================
   
        botonUnoHeader = new JButton("Home");
        botonUnoHeader.setBounds(475, 15, 100, 40);
        botonUnoHeader.setForeground(myColorBotonLetraHeader);
        botonUnoHeader.setBackground(myColorBotonHeader);
        botonUnoHeader.addActionListener(this);
        
        botonDosHeader = new JButton("Panel 2");
        botonDosHeader.setBounds(580, 15, 100, 40);
        botonDosHeader.setForeground(myColorBotonLetraHeader);
        botonDosHeader.setBackground(myColorBotonHeader);
        botonDosHeader.addActionListener(this);
        
        botonTresHeader = new JButton("Panel 3");
        botonTresHeader.setBounds(685, 15, 100, 40);
        botonTresHeader.setForeground(myColorBotonLetraHeader);
        botonTresHeader.setBackground(myColorBotonHeader);
        botonTresHeader.addActionListener(this);
        
        botonCuatroHeader = new JButton("Panel 4");
        botonCuatroHeader.setBounds(790, 15, 100, 40);
        botonCuatroHeader.setForeground(myColorBotonLetraHeader);
        botonCuatroHeader.setBackground(myColorBotonHeader);
        botonCuatroHeader.addActionListener(this);
        
        botonCincoHeader = new JButton("Panel 5");
        botonCincoHeader.setBounds(895, 15, 100, 40);
        botonCincoHeader.setForeground(myColorBotonLetraHeader);
        botonCincoHeader.setBackground(myColorBotonHeader);
        botonCincoHeader.addActionListener(this);
        
        PanelPrincipal();
        PanelPrincipalDos();
        PanelPrincipalTres();
        PanelPrincipalCuatro();
        
        
        
        
        
        panelTitulo.add(headerTitulo);
        panelHeader.add(botonUnoHeader);
        panelHeader.add(botonDosHeader);
        panelHeader.add(botonTresHeader);
        panelHeader.add(botonCuatroHeader);
        panelHeader.add(botonCincoHeader);
        panelHeader.add(panelTitulo);
        
        add(panelHeader);
        add(panelUno);
        add(panelDos);
        add(panelTres);
        add(panelCuatro);
        

        
    }
    
    public void PanelPrincipal(){
        //=============================
        
        //=============================
        textArea = new JTextArea();
        textArea.setBounds(10, 117,350, 181);
        
        String texto = "andkandjknsajkndsjnkjands";
        
        textArea.setText(texto);
        
        
        panelUno.add(textArea);
        add(panelUno);
    }
    
    public void PanelPrincipalDos(){
 
        //===============================
        
        textoAbrirArchivo = new JLabel("Abrir Archivos");
        textoAbrirArchivo.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
        textoAbrirArchivo.setBounds(10, 14, 221 ,51);
        textoAbrirArchivo.setForeground(Color.WHITE);
        //===============================
        abrirArchivo = new JButton("Abrir Archivo");
        abrirArchivo.setBounds(845, 15, 150, 40);
        abrirArchivo.setForeground(myColorBotonLetraHeader);
        abrirArchivo.setBackground(myColorBotonHeader);
        //===============================
        textoCargaInteractiva = new JLabel("Carga Interactiva");
        textoCargaInteractiva.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
        textoCargaInteractiva.setBounds(10, 100, 221 ,51);
        textoCargaInteractiva.setForeground(Color.WHITE);
        //===============================
        botonEnviarCargaInteractiva = new JButton("Enviar");       
        botonEnviarCargaInteractiva.setBounds(855, 100, 150, 40);
        botonEnviarCargaInteractiva.setForeground(myColorBotonLetraHeader);
        botonEnviarCargaInteractiva.setBackground(myColorBotonHeader);
                
        //===============================
        cajaDeTextoCargaInteractivo = new JTextField("Pisos del hotel");
        cajaDeTextoCargaInteractivo.setBounds(635,100,220,40);
        panelDos.add(cajaDeTextoCargaInteractivo);
        
        panelDos.add(botonEnviarCargaInteractiva);
        panelDos.add(abrirArchivo);
        panelDos.add(textoAbrirArchivo);
        panelDos.add(textoCargaInteractiva);
        add(panelDos);
    }
    
    public void PanelPrincipalTres(){
        
        
        panelReservacion = new JPanel();
        panelReservacion.setBackground(myColorFondo);
        panelReservacion.setBounds( 0, 0, 1000, 400);
        panelReservacion.setLayout(null);
        panelReservacion.setVisible(false);
        
        panelCheckIn = new JPanel();
        panelCheckIn.setBackground(myColorFondo);
        panelCheckIn.setBounds( 0, 0, 1000, 400);
        panelCheckIn.setLayout(null);
        panelCheckIn.setVisible(false);
        
        panelCheckOut = new JPanel();
        panelCheckOut .setBackground(myColorFondo);
        panelCheckOut .setBounds( 0, 0, 1000, 400);
        panelCheckOut .setLayout(null);
        panelCheckOut .setVisible(false);
        
        panelCancelacion = new JPanel();
        panelCancelacion.setBackground(myColorFondo);
        panelCancelacion.setBounds( 0, 0, 1000, 400);
        panelCancelacion.setLayout(null);
        panelCancelacion.setVisible(false);
        
        //========================================
        
        
        panelMenuOperaciones = new JPanel();
        panelMenuOperaciones.setBackground(myColorHeaderTitulo);
        panelMenuOperaciones.setBounds( 0, 0, 220, 400);
        panelMenuOperaciones.setLayout(null);
        panelTres.add(panelMenuOperaciones);
        
        //=====================================
        
        botonReservacion = new JButton("Reservaciones");
        botonReservacion.setBackground(myColorBotonHeader);
        botonReservacion.setForeground(myColorBotonLetraHeader);
        botonReservacion.setBounds(0, 0, 220, 40);
        botonReservacion.addActionListener(this);
        
        
        //======================================
        botonCheckIn = new JButton("Check-in");
        botonCheckIn.setBackground(myColorBotonHeader);
        botonCheckIn.setForeground(myColorBotonLetraHeader);
        botonCheckIn.setBounds(0, 45, 220, 40);
        botonCheckIn.addActionListener(this);
        
        //======================================
        botonCheckOut = new JButton("Check-out");
        botonCheckOut.setBackground(myColorBotonHeader);
        botonCheckOut.setForeground(myColorBotonLetraHeader);
        botonCheckOut.setBounds(0, 90, 220, 40);
        botonCheckOut.addActionListener(this);
        
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
        add(panelTres);
    }
    
     public void PanelPrincipalCuatro(){
        textoArchivoDeSalida = new JLabel("Archivos de salida");
        textoArchivoDeSalida.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
        textoArchivoDeSalida.setBounds(400, 14, 221 ,51);
        textoArchivoDeSalida.setForeground(Color.WHITE);
        
        panelCuatro.add(textoArchivoDeSalida);
        add(panelTres);
     }
     
    
     @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==botonUnoHeader){
            panelUno.setVisible(true);
            panelDos.setVisible(false);
            panelTres.setVisible(false);
            panelCuatro.setVisible(false);

        }
        else if(e.getSource()==botonDosHeader){
            panelUno.setVisible(false);
            panelDos.setVisible(true);
            panelTres.setVisible(false);
            panelCuatro.setVisible(false);

        }
        else if(e.getSource()==botonTresHeader){
            panelUno.setVisible(false);
            panelDos.setVisible(false);
            panelTres.setVisible(true);
            panelCuatro.setVisible(false);
        }
        else if(e.getSource()==botonCuatroHeader){
            panelUno.setVisible(false);
            panelDos.setVisible(false);
            panelTres.setVisible(false);
            panelCuatro.setVisible(true);
        }
        else if(e.getSource()==botonReservacion){
            panelReservacion.setVisible(true);
            panelCheckIn.setVisible(false);
            panelCheckOut.setVisible(false);
            panelCancelacion.setVisible(false);
        
        }
        else if(e.getSource()==botonCheckIn){
            panelReservacion.setVisible(false);
            panelCheckIn.setVisible(true);
            panelCheckOut.setVisible(false);
            panelCancelacion.setVisible(false);
        
        }
        else if(e.getSource()==botonCheckOut){
            panelReservacion.setVisible(false);
            panelCheckIn.setVisible(false);
            panelCheckOut.setVisible(true);
            panelCancelacion.setVisible(false);
        
        }
        else if(e.getSource()==botonCancelacion){
            panelReservacion.setVisible(false);
            panelCheckIn.setVisible(false);
            panelCheckOut.setVisible(false);
            panelCancelacion.setVisible(true);
        
        }
    }
}
