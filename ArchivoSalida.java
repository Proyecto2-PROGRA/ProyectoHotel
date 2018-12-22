package ProyectoHotel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ArchivoSalida {

    protected int personaEnHabitacion;
    protected int diaActual;
    protected int mesActual;
    protected int annioActual;
    protected int servicioSolicitado;
    protected int comidaRestaurant;
    protected float debeServicioSolicitado;
    protected float debeComidaRestaurant;
    protected String tipoHabitacion;
    protected String rutPersona;
    protected String cadena;
    protected SimpleDateFormat df;
    protected String fechaInicial;
    protected String fechaLlegada;
    protected String fechaSalida;
    protected String date;
    protected String[] campos;
    protected String[] campoPersona;
    protected String[] fechaActual;
    protected Date testDate;
    protected Date fechaLlegadaSuma;
    protected Date fechaSalidaSuma;
    protected Calendar fecha;
    protected String rut;
    protected int bandera;
    protected float SaldoActual;
    ArrayList a = new ArrayList();

    protected String SaldoInicial;
    protected double Nomina = 25000.00;

    public ArchivoSalida() throws FileNotFoundException, IOException {

        df = new SimpleDateFormat("dd/MM/yyyy");
        fecha = Calendar.getInstance();

        try {
            BufferedReader BR = new BufferedReader(new FileReader("inicializar.in"));
            BR.readLine();
            cadena = BR.readLine();
            String[] campos = cadena.split(" ");
            fechaInicial = (campos[0] + "/" + campos[1] + "/" + campos[2]);

            try {
                testDate = df.parse(fechaInicial);
                fecha.setTime(testDate);//FechaSumando

            } catch (Exception ex) {
            }
        } catch (Exception ex) {
        }
        contabilidad();
    }

    public void reservaciones() throws FileNotFoundException, IOException {
        FileWriter fichero = new FileWriter("reservaciones.out");

        try (BufferedReader BR = new BufferedReader(new FileReader("operaciones.in"))) {
            while ((cadena = BR.readLine()) != null) {
                switch (cadena) {

                    case "0":
                        fecha.add(Calendar.DAY_OF_WEEK, 1);

                        diaActual = fecha.get(Calendar.DAY_OF_MONTH);

                        if (diaActual == 16 || diaActual == 1) {

                            contabilidadNomina();
                        }

                        break;

                    case "1":
                        cadena = BR.readLine();
                        campos = cadena.split(" ");
                        try {
                            fechaLlegada = (campos[0] + "/" + campos[1] + "/" + campos[2]);
                            fechaSalida = (campos[3] + "/" + campos[4] + "/" + campos[5]);

                            try {
                                fechaLlegadaSuma = df.parse(fechaLlegada);
                                fechaSalidaSuma = df.parse(fechaSalida);
                            } catch (Exception ex) {
                            }
                        } catch (Exception ex) {
                        }

                        cadena = BR.readLine();
                        tipoHabitacion = cadena;
                        cadena = BR.readLine();
                        if (cadena.equals("1")) {
                            cadena = BR.readLine();
                        } else {
                            personaEnHabitacion = Integer.parseInt(cadena);
                            for (int i = 0; i < personaEnHabitacion; i++) {
                                campoPersona = cadena.split(" ");

                                if (campoPersona[0].equals("A")) {
                                    break;
                                }
                                cadena = BR.readLine();
                            }
                        }
                        campoPersona = cadena.split(" ");
                        int diasTotal = (int) ((fechaSalidaSuma.getTime() - fechaLlegadaSuma.getTime()) / 86400000);
                        fichero.append("RESERVACIÓN--(" + actualizarFecha()[0] + "/" + actualizarFecha()[1] + "/" + actualizarFecha()[2] + ")\n");
                        fichero.write("    Titular: " + cadena.split(" ")[1] + "\n");
                        fichero.write("    Habitación " + tipoHabitacion + " del " + fechaLlegada + " " + fechaSalida + " (" + diasTotal + " dias)" + "\n");
                        String var_1 = cadena.split(" ")[1];
                        a.add(var_1);
                        float var_5 = tipoDeHabitacion(tipoHabitacion, diasTotal);
                        a.add(var_5);

                        break;

                    case "2":
                        cadena = BR.readLine();
                        fichero.write("CANCELACIÓN--(" + actualizarFecha()[0] + "/" + actualizarFecha()[1] + "/" + actualizarFecha()[2] + " " + cadena.split(" ")[1] + ")\n");
                        fichero.write("    Titular: " + cadena.split(" ")[0] + "\n");
                        break;

                    case "3":
                        cadena = BR.readLine();
                        fichero.write("CHECK-IN-----(" + actualizarFecha()[0] + "/" + actualizarFecha()[1] + "/" + actualizarFecha()[2] + " " + cadena.split(" ")[1] + ")\n");
                        fichero.write("    Titular: " + cadena.split(" ")[0] + "\n");
                        fichero.write("    Habitación " + cadena.split(" ")[0] + "\n");
                        break;

                    case "4":
                        bandera = 0;
                        cadena = BR.readLine();
                        fichero.write("CHECK-OUT----(" + actualizarFecha()[0] + "/" + actualizarFecha()[1] + "/" + actualizarFecha()[2] + " " + cadena.split(" ")[1] + ")\n");
                        fichero.write("    Titular: " + cadena.split(" ")[0] + "\n");
                        rut = cadena.split(" ")[0];
                        float pago = 0;
                        for (int i = 0; i < a.size(); i++) {

                            if ((i % 2) == 0) {

                                if (rut.equals(a.get(i))) {
                                    i++;
                                    pago = (float) a.get(i);

                                } else {
                                    bandera = 0;
                                }
                            }

                        }

                        fichero.write("    Cancelo: " + pago + "\n");
                        contabilidadCheck_Out(pago);

                        break;

                    case "5":
                        cadena = BR.readLine();
                        comidaRestaurant = Integer.parseInt(cadena);
                        for (int i = 0; i < comidaRestaurant; i++) {
                            cadena = BR.readLine();
                            String[] campos = cadena.split(" ");
                            if (campos[0].equals("ESP_C")) {
                                debeComidaRestaurant += (float) 55.00;
                            } else if (campos[0].equals("LOM_M")) {
                                debeComidaRestaurant += (float) 71.50;
                            } else if (campos[0].equals("JUG_L")) {
                                debeComidaRestaurant += (float) 10.00;
                            } else if (campos[0].equals("MALTA")) {
                                debeComidaRestaurant += (float) 6.00;
                            }

                        }
                        contabilidadRestaurant(debeComidaRestaurant);
                        break;

                    case "6":
                        float servicioPor = 0;
                        bandera = 0;
                        cadena = BR.readLine();
                        System.out.println("Rut " + cadena);
                        rut = cadena;
                        cadena = BR.readLine();
                        servicioSolicitado = Integer.parseInt(cadena);

                        debeServicioSolicitado = (float) 50.00 * servicioSolicitado + debeServicioSolicitado;//Arreglar

                        servicioPor = (float) 50.00 * servicioSolicitado;
                        for (int i = 0; i < a.size(); i++) {
                            if ((i % 2) == 0) {
                                if (rut.equals(a.get(i))) {
                                    i++;
                                    Float var_2 = (Float) a.get(i);
                                    var_2 = var_2 + servicioPor;
                                    a.set(i, var_2);
                                } else {
                                    bandera = 0;
                                }
                            }

                        }
                        debeServicioSolicitado = (float) 50.00 * servicioSolicitado;
                        contabilidadServicios(debeServicioSolicitado);

                        break;
                    case "7":
                        break;

                    default:
                        break;
                }
            }
        }

        fichero.close();

    }

    public void contabilidad() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("inicializar.in"));
        SaldoInicial = br.readLine();
        SaldoActual = Float.parseFloat(SaldoInicial);

<<<<<<< HEAD

            FileWriter fichero = new FileWriter("contabilidad.out");
            fichero.append("FECHA      |DEBE           |HABER          |SALDO          |CONCEPTO\n");

            fichero.append(fechaInicial+"      |" +SaldoInicial+"      |" + "      |" +SaldoActual + "      |" + "Saldo inicial\n");

            SaldoActual+=debeServicioSolicitado;
            fichero.append(fechaInicial+"      |" +debeServicioSolicitado+"      |" + "      |" +SaldoActual + "      |" + "Servicios\n");

            SaldoActual+=debeComidaRestaurant;
            fichero.append(fechaInicial+"      |" +debeComidaRestaurant+"      |" + "      |" +SaldoActual + "      |" + "Restaurant\n");
           
            
                    

            fichero.close();
       
    } 
     public void contabilidadNomina() throws IOException{
         
         FileWriter fichero = new FileWriter("contabilidad.out", true);
         
         SaldoActual-=Nomina;
         fichero.append(actualizarFecha()[0]+"/"+actualizarFecha()[1]+"/"+actualizarFecha()[2]+"      |" +"      |"+Nomina + "      |" +SaldoActual + "      |" + "Nomina\n");
         

         System.out.println("Hola");
     }
     
     
    public void reportes() throws IOException{
        
=======
>>>>>>> ccd29b21c4a10fbdf205a87047e0b7e5c31498e3
        FileWriter fichero = new FileWriter("contabilidad.out");
        fichero.append("FECHA      |DEBE           |HABER          |SALDO          |CONCEPTO\n");

        fichero.close();

    }

    public void contabilidadServicios(float debeServicioSolicitado) throws IOException {
        FileWriter fichero = new FileWriter("contabilidad.out", true);
        SaldoActual += debeServicioSolicitado;
        fichero.append(actualizarFecha()[0] + "/" + actualizarFecha()[1] + "/" + actualizarFecha()[2] + "      |" + debeServicioSolicitado + "      |" + "      |" + SaldoActual + "      |" + "Servicios\n");
        fichero.close();
    }

    public void contabilidadRestaurant(float debeComidaRestaurant) throws IOException {
        FileWriter fichero = new FileWriter("contabilidad.out", true);
        SaldoActual += debeComidaRestaurant;
        fichero.append(actualizarFecha()[0] + "/" + actualizarFecha()[1] + "/" + actualizarFecha()[2] + "      |" + debeComidaRestaurant + "      |" + "      |" + SaldoActual + "      |" + "Restaurant\n");

        fichero.close();
    }

    /**
     *
     * @throws IOException
     */

<<<<<<< HEAD

    
=======
    public void contabilidadCheck_Out(float pago) throws IOException {
        FileWriter fichero = new FileWriter("contabilidad.out", true);
        SaldoActual += pago;
        fichero.append(actualizarFecha()[0] + "/" + actualizarFecha()[1] + "/" + actualizarFecha()[2] + "      |" + pago + "      |" + "      |" + SaldoActual + "      |" + "Check-Out\n");

        fichero.close();
    }
>>>>>>> ccd29b21c4a10fbdf205a87047e0b7e5c31498e3

    public String[] actualizarFecha() {
        String fechaActualizada;
        annioActual = fecha.get(Calendar.YEAR);
        mesActual = fecha.get(Calendar.MONTH) + 1;
        diaActual = fecha.get(Calendar.DAY_OF_MONTH);

        fechaActualizada = diaActual + " " + mesActual + " " + annioActual;
        fechaActual = fechaActualizada.split(" ");
        return fechaActual;
    }

    public Float tipoDeHabitacion(String Habitacion, Integer dias) {
        float b = 0;
        if (Habitacion.equals("INDIV")) {
            b = (float) 150.00 * dias;
        } else if (Habitacion.equals("DOBLE")) {
            b = (float) 200.00 * dias;
        } else if (Habitacion.equals("MATRI")) {
            b = (float) 180.00 * dias;
        } else if (Habitacion.equals("CUADR")) {
            b = (float) 380.00 * dias;
        } else {
            b = (float) 900.00 * dias;
        }
        return b;
    }
}
