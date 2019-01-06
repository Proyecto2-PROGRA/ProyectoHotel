import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;

public class Controlador implements ActionListener {

    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;

        this.vista.botonUnoHeader.addActionListener(this);
        this.vista.botonDosHeader.addActionListener(this);
        this.vista.botonTresHeader.addActionListener(this);
        this.vista.botonCuatroHeader.addActionListener(this);
        this.vista.botonIniciaizarDos.addActionListener(this);
        this.vista.botonIngresarInicializar.addActionListener(this);
        this.vista.botonPreciosDos.addActionListener(this);
        this.vista.CampoTextoIndv.addActionListener(this);
        this.vista.CampoTextoDoble.addActionListener(this);
        this.vista.CampoTextoMatri.addActionListener(this);
        this.vista.CampoTextoCuadruple.addActionListener(this);
        this.vista.CampoTextoSuite.addActionListener(this);
        this.vista.comboCam_A.addActionListener(this);
        this.vista.comboCaj_F.addActionListener(this);
        this.vista.CampoTextoEsp_C.addActionListener(this);
        this.vista.CampoTextoLom_M.addActionListener(this);
        this.vista.CampoTextoJug_L.addActionListener(this);
        this.vista.CampoTextoMalta.addActionListener(this);
        this.vista.botonIngresarPrecios.addActionListener(this);
        this.vista.botonAbrirArchivoInicializar.addActionListener(this);
        this.vista.botonAbrirArchivoPrecio.addActionListener(this);
        this.vista.botonIniciaizarDos.addActionListener(this);
        this.vista.botonPreciosDos.addActionListener(this);
        this.vista.botonReservacion.addActionListener(this);
        this.vista.ingresarReserva.addActionListener(this);
        this.vista.comboDiaLlegada.addActionListener(this);
        this.vista.comboMesLlegada.addActionListener(this);
        this.vista.comboAnoLlegada.addActionListener(this);
        this.vista.comboDiaSalida.addActionListener(this);
        this.vista.comboMesSalida.addActionListener(this);
        this.vista.comboAnoSalida.addActionListener(this);
        this.vista.comboTipoDeHabitacion.addActionListener(this);
        this.vista.comboCantidadDePersona.addActionListener(this);
        this.vista.comboTipoEdad.addActionListener(this);
        this.vista.CedulaReserva.addActionListener(this);
        this.vista.nombreReserva.addActionListener(this);
        this.vista.apellidoReserva.addActionListener(this);
        this.vista.botonReservaCarga.addActionListener(this);
        this.vista.botonCheckIn.addActionListener(this);
        this.vista.CedulaCheckIn.addActionListener(this);
        this.vista.comboHoraCheckIn.addActionListener(this);
        this.vista.comboMinutoCheckIn.addActionListener(this);
        this.vista.ingresarCheckIn.addActionListener(this);
        this.vista.botonCheckOut.addActionListener(this);
        this.vista.comboHoraCheckOut.addActionListener(this);
        this.vista.comboMinutoCheckOut.addActionListener(this);
        this.vista.ingresarCheckOut.addActionListener(this);
        this.vista.botonCancelacion.addActionListener(this);
        this.vista.comboHoraCancelacion.addActionListener(this);
        this.vista.comboMinutoCancelacion.addActionListener(this);
        this.vista.ingresarCancelacion.addActionListener(this);
        this.vista.botonInicializar.addActionListener(this);
        this.vista.botonOperaciones.addActionListener(this);
        this.vista.botonReservaciones.addActionListener(this);

    }

    public void iniciarVista() {
        vista.setDefaultCloseOperation(EXIT_ON_CLOSE);
        vista.setSize(1000, 500);
        vista.setTitle("Mi Refugio");
        vista.setLayout(null);
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);
        vista.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.botonUnoHeader) {
            vista.panelUno.setVisible(true);
            vista.panelDos.setVisible(false);
            vista.panelTres.setVisible(false);
            vista.panelCuatro.setVisible(false);
            vista.panelColorTres.setVisible(false);

        } else if (e.getSource() == vista.botonIniciaizarDos) {
            vista.panelUno.setVisible(false);
            vista.panelDos.setVisible(true);
            vista.panelTres.setVisible(false);
            vista.panelCuatro.setVisible(false);
            modelo.Inicializar_in();
            JOptionPane.showMessageDialog(null, "El archivo inicializar se genero automaticamente");
            vista.panelDosExtra.setVisible(false);

        } else if (e.getSource() == vista.botonPreciosDos) {
            vista.panelUno.setVisible(false);
            vista.panelDos.setVisible(true);
            vista.panelTres.setVisible(false);
            vista.panelCuatro.setVisible(false);
            vista.panelPreciosDos.setVisible(true);
            vista.panelDosExtra.setVisible(false);

        } else if (e.getSource() == vista.botonDosHeader) {
            vista.panelUno.setVisible(false);
            vista.panelDos.setVisible(true);
            vista.panelTres.setVisible(false);
            vista.panelCuatro.setVisible(false);

            vista.panelColorTres.setVisible(false);

            vista.panelInicializarDos.setVisible(false);
            vista.panelPreciosDos.setVisible(false);
            vista.panelDosExtra.setVisible(true);

        } else if (e.getSource() == vista.botonTresHeader) {
            vista.panelUno.setVisible(false);
            vista.panelDos.setVisible(false);
            vista.panelTres.setVisible(true);
            vista.panelCuatro.setVisible(false);
            vista.panelColorTres.setVisible(true);

            vista.panelReservacion.setVisible(false);
            vista.panelCheckIn.setVisible(false);
            vista.panelCheckOut.setVisible(false);
            vista.panelCancelacion.setVisible(false);

        } else if (e.getSource() == vista.botonCuatroHeader) {
            vista.panelUno.setVisible(false);
            vista.panelDos.setVisible(false);
            vista.panelTres.setVisible(false);
            vista.panelCuatro.setVisible(true);
            vista.panelColorTres.setVisible(false);
        } else if (e.getSource() == vista.botonReservacion) {
            vista.panelReservacion.setVisible(true);
            vista.panelCheckIn.setVisible(false);
            vista.panelCheckOut.setVisible(false);
            vista.panelCancelacion.setVisible(false);
            vista.panelColorTres.setVisible(false);
        } else if (e.getSource() == vista.botonCheckIn) {
            vista.panelReservacion.setVisible(false);
            vista.panelCheckIn.setVisible(true);
            vista.panelCheckOut.setVisible(false);
            vista.panelCancelacion.setVisible(false);
            vista.panelColorTres.setVisible(false);

        } else if (e.getSource() == vista.botonCheckOut) {
            vista.panelReservacion.setVisible(false);
            vista.panelCheckIn.setVisible(false);
            vista.panelCheckOut.setVisible(true);
            vista.panelCancelacion.setVisible(false);
            vista.panelColorTres.setVisible(false);

        } else if (e.getSource() == vista.botonCancelacion) {
            vista.panelReservacion.setVisible(false);
            vista.panelCheckIn.setVisible(false);
            vista.panelCheckOut.setVisible(false);
            vista.panelCancelacion.setVisible(true);
            vista.panelColorTres.setVisible(false);

            //**************************************************************************
        } else if (e.getSource() == vista.ingresarCheckIn) {
            if (vista.CedulaCheckIn.getText().length() > 0) {

                try {
                    BufferedWriter BrReservaciones = new BufferedWriter(new FileWriter("reservaciones.out", true));
                    BufferedWriter BR = new BufferedWriter(new FileWriter("operaciones.in", true));
                    BR.write("3\n");
                    String varCheck = (vista.CedulaCheckIn.getText());
                    
                    BR.write(varCheck + " ");
                    
                    String varMinCheck = (vista.comboMinutoCheckIn.getSelectedItem().toString());
                    String varHoraCheck = (vista.comboHoraCheckIn.getSelectedItem().toString());
                    BR.write(varMinCheck + ":" + varHoraCheck + "\n");
                    
                    BrReservaciones.write("CHECK-IN-----(DD/MM/AAAA "+ varMinCheck + ":" + varHoraCheck +")\n");
                    BrReservaciones.write("  Titular: "+varCheck+"\n");
                    BrReservaciones.write("  Habitación: 001003\n");
                    BrReservaciones.close();
                    BR.close();
                } catch (Exception ex) {

                }
            }
        } else if (e.getSource() == vista.ingresarCheckOut) {
            if (vista.CedulaCheckOut.getText().length() > 0) {

                try {
                    BufferedWriter BrReservaciones = new BufferedWriter(new FileWriter("reservaciones.out", true));
                    BufferedWriter BR = new BufferedWriter(new FileWriter("operaciones.in", true));
                    BR.write("4\n");
                    String varCheck = (vista.CedulaCheckOut.getText());
                    BR.write(varCheck + " ");
                    String varMinCheck = (vista.comboMinutoCheckOut.getSelectedItem().toString());
                    String varHoraCheck = (vista.comboHoraCheckOut.getSelectedItem().toString());
                    BR.write(varMinCheck + ":" + varHoraCheck + "\n");
                    
                    BrReservaciones.write("CHECK-OUT----(DD/MM/AAAA "+ varMinCheck + ":" + varHoraCheck +")\n");
                    BrReservaciones.write("  Titular: "+varCheck+"\n");
                    BrReservaciones.write("  Habitación: 001003\n");
                    BrReservaciones.close();
                    BR.close();
                } catch (Exception ex) {

                }

            }

        } else if (e.getSource() == vista.ingresarCancelacion) {
            if (vista.CedulaCheckIn.getText().length() > 0) {

                try {
                    BufferedWriter BrReservaciones = new BufferedWriter(new FileWriter("reservaciones.out", true));
                    BufferedWriter BR = new BufferedWriter(new FileWriter("operaciones.in", true));
                    
                    BR.write("2\n");
                    String varCheck = (vista.CedulaCancelacion.getText());
                    BR.write(varCheck + " ");
                    String varMinCheck = (vista.comboMinutoCancelacion.getSelectedItem().toString());
                    String varHoraCheck = (vista.comboHoraCancelacion.getSelectedItem().toString());
                    BR.write(varMinCheck + ":" + varHoraCheck + "\n");
                    
                    BrReservaciones.write("CANCELACIÓN-----(DD/MM/AAAA "+ varMinCheck + ":" + varHoraCheck +")\n");
                    BrReservaciones.write("  Titular: "+varCheck+"\n");
                    BrReservaciones.write("  Habitación: 001003\n");
                    BrReservaciones.close();
                    BR.close();
                } catch (Exception ex) {

                }

            }

        } else if (e.getSource() == vista.ingresarReserva) {
            try {

                if ((Integer.parseInt(vista.comboAnoLlegada.getSelectedItem().toString())) == (Integer.parseInt(vista.comboAnoSalida.getSelectedItem().toString()))) {
                    if ((Integer.parseInt(vista.comboMesLlegada.getSelectedItem().toString())) == (Integer.parseInt(vista.comboMesSalida.getSelectedItem().toString()))) {
                        if ((Integer.parseInt(vista.comboDiaLlegada.getSelectedItem().toString())) < (Integer.parseInt(vista.comboDiaSalida.getSelectedItem().toString()))) {
                            JOptionPane.showMessageDialog(null, "Fecha Ingresada Corecta(dia)");

                            modelo.banderaRevision = 1;
                        } else {
                            JOptionPane.showMessageDialog(null, "Dia Ingresado Erroneo o menor a la esperado");

                            modelo.banderaRevision = 0;
                        }
                    } else if ((Integer.parseInt(vista.comboMesLlegada.getSelectedItem().toString())) < (Integer.parseInt(vista.comboMesSalida.getSelectedItem().toString()))) {
                        JOptionPane.showMessageDialog(null, "Fecha Ingresada Corecta(mes)");

                        modelo.banderaRevision = 1;
                    } else {
                        JOptionPane.showMessageDialog(null, "Mes Ingresado Erroneo o menor a lo esperado");

                        modelo.banderaRevision = 0;
                    }
                } else if ((Integer.parseInt(vista.comboMesLlegada.getSelectedItem().toString())) <= (Integer.parseInt(vista.comboMesSalida.getSelectedItem().toString()))) {
                    JOptionPane.showMessageDialog(null, "Fecha Ingresada Corecta(mes)");
                } else {
                    JOptionPane.showMessageDialog(null, "Mes Ingresado Erroneo o menor a lo esperado");
                }
                if ((Integer.parseInt(vista.comboAnoLlegada.getSelectedItem().toString())) < (Integer.parseInt(vista.comboAnoSalida.getSelectedItem().toString()))) {
                    JOptionPane.showMessageDialog(null, "Fecha Ingresada Corecta(año)");

                    modelo.banderaRevision = 1;
                } else {

                    JOptionPane.showMessageDialog(null, "Año Ingresado Erroneo o menor a lo esperado");

                    modelo.banderaRevision = 0;
                }
                if (vista.comboTipoDeHabitacion.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Ingrese una Opcion en tipo habitación");

                    modelo.banderaRevision = 0;
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error");

                modelo.banderaRevision = 0;
            }

            if (modelo.bandera == 789 && modelo.banderaRevision == 1) {
                try {

                    modelo.varF = (vista.comboDiaLlegada.getSelectedItem().toString()) + " " + (vista.comboMesLlegada.getSelectedItem().toString()) + " " + (vista.comboAnoLlegada.getSelectedItem().toString());
                    modelo.varG = (vista.comboDiaSalida.getSelectedItem().toString()) + " " + (vista.comboMesSalida.getSelectedItem().toString()) + " " + (vista.comboAnoSalida.getSelectedItem().toString());

                    BufferedWriter BR = new BufferedWriter(new FileWriter("operaciones.in", true));
                    BufferedWriter BrReservaciones = new BufferedWriter(new FileWriter("reservaciones.out", true));
                    
                    BR.write("1\n");
                    BR.write(modelo.varF + " " + modelo.varG + "\n");
                    BR.write(modelo.varH + "\n");
                    BR.write(modelo.varE + "\n");
                    
                    BrReservaciones.write("RESERVACIÓN--("+"DD"+"/"+"MM"+"/"+"AAAA"+")\n");
                    BrReservaciones.write(" Titular: ");
                    

                    BufferedReader br = new BufferedReader(new FileReader("operaciones.txt"));
                    String cadena;
                    int contador=0;
                    while ((cadena = br.readLine()) != null) {
                        contador++;
                        if (contador==1){
                            String[] contd= cadena.split(" ");
                            BrReservaciones.write(contd[1]);
                        }
                        BR.write(cadena + "\n");
                    }
                    BrReservaciones.write("\n  Habitación "+modelo.varH+" del "+modelo.varF+" al "+modelo.varG+"(DD dias)\n");

                    br.close();
                    BufferedWriter BREntro = new BufferedWriter(new FileWriter("operaciones.txt"));
                    BREntro.close();
                    BrReservaciones.close();
                    BR.close();

                } catch (Exception ex) {
                }

            }

        } else if (e.getSource() == vista.botonInicializar) {
            try {
                vista.inicializar();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else if (e.getSource() == vista.botonReservaciones) {
            try {
                vista.Reservaciones();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if (e.getSource() == vista.botonOperaciones) {
            try {
                vista.operaciones();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == vista.comboTipoDeHabitacion) {
            vista.comboCantidadDePersona.removeAllItems();
            modelo.bandera = 0;
            vista.botonReservaCarga.setEnabled(true);
            vista.ingresarReserva.setEnabled(false);
            if (vista.comboTipoDeHabitacion.getSelectedIndex() == 0) {
                vista.botonReservaCarga.setEnabled(false);
            } else if (vista.comboTipoDeHabitacion.getSelectedIndex() == 1) {
                vista.comboCantidadDePersona.addItem("1");
            } else if (vista.comboTipoDeHabitacion.getSelectedIndex() == 2) {
                vista.comboCantidadDePersona.addItem("1");
                vista.comboCantidadDePersona.addItem("2");
            } else if (vista.comboTipoDeHabitacion.getSelectedIndex() == 3) {
                vista.comboCantidadDePersona.addItem("1");
                vista.comboCantidadDePersona.addItem("2");
                vista.comboCantidadDePersona.addItem("3");
            } else if (vista.comboTipoDeHabitacion.getSelectedIndex() == 4) {
                vista.comboCantidadDePersona.addItem("1");
                vista.comboCantidadDePersona.addItem("2");
                vista.comboCantidadDePersona.addItem("3");
                vista.comboCantidadDePersona.addItem("4");

            } else if (vista.comboTipoDeHabitacion.getSelectedIndex() == 5) {
                vista.comboCantidadDePersona.addItem("1");
                vista.comboCantidadDePersona.addItem("2");
                vista.comboCantidadDePersona.addItem("3");
                vista.comboCantidadDePersona.addItem("4");
                vista.comboCantidadDePersona.addItem("5");
                vista.comboCantidadDePersona.addItem("6");
                vista.comboCantidadDePersona.addItem("7");
                vista.comboCantidadDePersona.addItem("8");
                vista.comboCantidadDePersona.addItem("9");
                vista.comboCantidadDePersona.addItem("10");
            }

        } else if (e.getSource() == vista.botonReservaCarga) {
            modelo.varH = (vista.comboTipoDeHabitacion.getSelectedItem().toString());
            modelo.varE = (vista.comboCantidadDePersona.getSelectedItem().toString());
            int a = 0, b = 0, c = 0, d = 0;
            if (((vista.CedulaReserva.getText()).length()) == 8 && vista.comboTipoEdad.getSelectedIndex() == 0) {
                try {
                    int var = Integer.parseInt((vista.CedulaReserva.getText()));

                    a = 1;
                    modelo.varA = vista.CedulaReserva.getText().toString();
                    modelo.varB = "A";
                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(null, "Cedula erronea");
                    a = 0;
                }

            } else if (vista.comboTipoEdad.getSelectedIndex() == 1) {
                a = 2;
                modelo.varA = " ";
                modelo.varB = "N";
            } else if (((vista.CedulaReserva.getText()).length()) != 8) {

                JOptionPane.showMessageDialog(null, "La cedula tiene que tener 8 digitos");
                a = 0;
            }

            if (((vista.nombreReserva.getText()).length()) > 2) {
                modelo.varC = vista.nombreReserva.getText().toString();
                b = 1;
            } else {
                JOptionPane.showMessageDialog(null, "Nombre muy corto");
                b = 0;
            }

            if ((vista.apellidoReserva.getText().length()) > 2) {
                modelo.varD = vista.apellidoReserva.getText().toString();
                d = 1;
            } else {
                JOptionPane.showMessageDialog(null, "Apellido muy corto");
                d = 0;
            }
            try {
                BufferedWriter BR = new BufferedWriter(new FileWriter("operaciones.txt", true));

                if (a == 1 && b == 1 && d == 1) {
                    modelo.bandera++;
                    BR.write(modelo.varB + " " + modelo.varA + " " + modelo.varC + " " + modelo.varD + "\n");

                } else if (a == 2 && b == 1 && d == 1) {
                    modelo.bandera++;
                    BR.write(modelo.varB + " " + modelo.varA + " " + modelo.varC + " " + modelo.varD + "\n");
                }

                BR.close();
            } catch (Exception ex) {
            }

            if ((modelo.bandera - 1) == vista.comboCantidadDePersona.getSelectedIndex()) {
                vista.botonReservaCarga.setEnabled(false);
                vista.ingresarReserva.setEnabled(true);
                modelo.bandera = 789;
            }

        } else if (e.getSource() == vista.comboAnoLlegada) {
            vista.comboMesLlegada.removeAllItems();
            for (int i = 1; vista.mesStrings.length > i; i++) {
                vista.comboMesLlegada.addItem(vista.mesStrings[i]);
                vista.comboDiaLlegada.addItem("29");
                vista.comboDiaLlegada.addItem("30");
                vista.comboDiaLlegada.addItem("31");
            }
        } else if (e.getSource() == vista.botonIngresarPrecios) {

            if (vista.CampoTextoIndv.getText().length() > 0) {
                if (vista.CampoTextoDoble.getText().length() > 0) {
                    if (vista.CampoTextoMatri.getText().length() > 0) {
                        if (vista.CampoTextoSuite.getText().length() > 0) {
                            if (vista.CampoTextoCuadruple.getText().length() > 0) {
                                if (vista.CampoTextoEsp_C.getText().length() > 0) {
                                    if (vista.CampoTextoLom_M.getText().length() > 0) {
                                        if (vista.CampoTextoJug_L.getText().length() > 0) {
                                            if (vista.CampoTextoMalta.getText().length() > 0) {
                                                if (vista.comboCam_A.getText().length() > 0) {
                                                    if (vista.comboCaj_F.getText().length() > 0) {
                                                        try {
                                                            BufferedWriter BR = new BufferedWriter(new FileWriter("precios.in"));
                                                            BR.write("INDIV " + vista.CampoTextoIndv.getText());
                                                            BR.write("\nDOBLE " + vista.CampoTextoDoble.getText());
                                                            BR.write("\nMATRI  " + vista.CampoTextoMatri.getText());
                                                            BR.write("\nCUADR " + vista.CampoTextoCuadruple.getText());
                                                            BR.write("\nSUITE " + vista.CampoTextoSuite.getText());
                                                            BR.write("\nCAM_A " + vista.comboCam_A.getText() + " Cama Adicional");
                                                            BR.write("\nCAM_F " + vista.comboCaj_F.getText() + " CajaFuerte");
                                                            BR.write("\nESP_C " + vista.CampoTextoEsp_C.getText() + " Espaguetis a la Carbonara");
                                                            BR.write("\nLOM_M " + vista.CampoTextoLom_M.getText() + " Lomito a la Mostaza");
                                                            BR.write("\nJUG_L " + vista.CampoTextoJug_L.getText() + " Jugo light");
                                                            BR.write("\nMALTA " + vista.CampoTextoMalta.getText() + " Malta");
                                                            BR.close();
                                                            JOptionPane.showMessageDialog(null, "Archivo creado exitosamente");
                                                        } catch (Exception ex) {
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
                }
            }

        } else if (e.getSource() == vista.comboMesLlegada) {
            Integer varNum = Integer.parseInt(vista.comboAnoLlegada.getSelectedItem().toString());
            varNum = varNum % 4;

            if (vista.comboMesLlegada.getSelectedIndex() != 0) {
                vista.comboDiaLlegada.removeAllItems();
                for (int i = 0; vista.diasStrings.length > i; i++) {
                    vista.comboDiaLlegada.addItem(vista.diasStrings[i]);
                }
                if (varNum == 0 && vista.comboMesLlegada.getSelectedIndex() == 1) {
                    vista.comboDiaLlegada.addItem("29");
                }
                if (vista.comboMesLlegada.getSelectedIndex() == 3 || vista.comboMesLlegada.getSelectedIndex() == 5 || vista.comboMesLlegada.getSelectedIndex() == 8
                        || vista.comboMesLlegada.getSelectedIndex() == 10) {
                    vista.comboDiaLlegada.addItem("29");
                    vista.comboDiaLlegada.addItem("30");
                }
                if (vista.comboMesLlegada.getSelectedIndex() == 0 || vista.comboMesLlegada.getSelectedIndex() == 2 || vista.comboMesLlegada.getSelectedIndex() == 4
                        || vista.comboMesLlegada.getSelectedIndex() == 6 || vista.comboMesLlegada.getSelectedIndex() == 7 || vista.comboMesLlegada.getSelectedIndex() == 9
                        || vista.comboMesLlegada.getSelectedIndex() == 11) {
                    vista.comboDiaLlegada.addItem("29");
                    vista.comboDiaLlegada.addItem("30");
                    vista.comboDiaLlegada.addItem("31");
                }
            }
        } else if (e.getSource() == vista.comboAnoSalida) {
            vista.comboMesSalida.removeAllItems();
            for (int i = 1; vista.mesStrings.length > i; i++) {
                vista.comboMesSalida.addItem(vista.mesStrings[i]);
                vista.comboDiaSalida.addItem("29");
                vista.comboDiaSalida.addItem("30");
                vista.comboDiaSalida.addItem("31");
            }
        } else if (e.getSource() == vista.comboMesSalida) {
            Integer varNum = Integer.parseInt(vista.comboAnoSalida.getSelectedItem().toString());
            varNum = varNum % 4;

            if (vista.comboMesSalida.getSelectedIndex() != 0) {
                vista.comboDiaSalida.removeAllItems();
                for (int i = 0; vista.diasStrings.length > i; i++) {
                    vista.comboDiaSalida.addItem(vista.diasStrings[i]);
                }
                if (varNum == 0 && vista.comboMesSalida.getSelectedIndex() == 1) {
                    vista.comboDiaSalida.addItem("29");
                }
                if (vista.comboMesSalida.getSelectedIndex() == 3 || vista.comboMesSalida.getSelectedIndex() == 5 || vista.comboMesSalida.getSelectedIndex() == 8
                        || vista.comboMesSalida.getSelectedIndex() == 10) {
                    vista.comboDiaSalida.addItem("29");
                    vista.comboDiaSalida.addItem("30");

                }
                if (vista.comboMesSalida.getSelectedIndex() == 0 || vista.comboMesSalida.getSelectedIndex() == 2 || vista.comboMesSalida.getSelectedIndex() == 4
                        || vista.comboMesSalida.getSelectedIndex() == 6 || vista.comboMesSalida.getSelectedIndex() == 7 || vista.comboMesSalida.getSelectedIndex() == 9
                        || vista.comboMesSalida.getSelectedIndex() == 11) {
                    vista.comboDiaSalida.addItem("29");
                    vista.comboDiaSalida.addItem("30");
                    vista.comboDiaSalida.addItem("31");
                }
            }
        } else if (e.getSource() == vista.botonAbrirArchivoInicializar) {

            modelo.BuscarArchivo();

        } else if (e.getSource() == vista.botonAbrirArchivoPrecio) {

            modelo.BuscarArchivo();

        }else if(e.getSource()== vista.botonReservaciones){
            
        }
    }

}
