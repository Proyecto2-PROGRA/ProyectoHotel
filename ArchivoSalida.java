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
    protected int reportes;
    protected int BanderaCancelacion;
    protected int BanderaEfectivo;
    protected int BanderaAdulto;
    protected int BanderaNiño;
    protected String rut;
    protected int bandera;
    protected float SaldoActual;
    ArrayList a = new ArrayList();
    ArrayList fechasCancelar = new ArrayList();
    ArrayList fechasReservar = new ArrayList();
    ArrayList  listAdultos = new ArrayList();
    ArrayList  listninnios = new ArrayList();
    ArrayList  listCama = new ArrayList();
    ArrayList  listTransferencia = new ArrayList();
    ArrayList  listCajaFuerte = new ArrayList();
    ArrayList  listHabitacionOcupada = new ArrayList();
    ArrayList  listHabitacionLibre = new ArrayList();
    ArrayList  listConMayorUso = new ArrayList();

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
                        fechasReservar.add(fechaLlegada);
                        float var_5 = tipoDeHabitacion(tipoHabitacion, diasTotal);
                        a.add(var_5);


                        BanderaEfectivo++;

                        String var_1 = cadena.split(" ")[1];
                        a.add(var_1);
                        float var_5 = tipoDeHabitacion(tipoHabitacion, diasTotal);
                        a.add(var_5);


                        break;

                    case "2":
                        cadena = BR.readLine();
                        fichero.write("CANCELACIÓN--(" + actualizarFecha()[0] + "/" + actualizarFecha()[1] + "/" + actualizarFecha()[2] + " " + cadena.split(" ")[1] + ")\n");
                        fichero.write("    Titular: " + cadena.split(" ")[0] + "\n");
                        String Can = (String) actualizarFecha()[0] + "/" + actualizarFecha()[1] + "/" + actualizarFecha()[2] ;
                        fechasCancelar.add(Can);

                        BanderaCancelacion++;


                        String Can = (String) actualizarFecha()[0] + "/" + actualizarFecha()[1] + "/" + actualizarFecha()[2] ;
                        

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

                        cadena = BR.readLine();
                        campos = cadena.split(" ");
                        if(campos[0].equals("CAM_A")){
                            listCama.add(actualizarFecha() );
                        }else{
                            listCajaFuerte.add(actualizarFecha());
                        }


                        debeServicioSolicitado = (float) 50.00 * servicioSolicitado;
                        contabilidadServicios(debeServicioSolicitado);

                        break;
                    case "7":

                        cadena = BR.readLine();
                        System.out.println(cadena);
                        reportes = Integer.parseInt(cadena);
                        for (int i = 0; i < reportes; i++) {
                            cadena = BR.readLine();
                            String[] campos = cadena.split(" ");
                            switch (campos[0]) {
                                case "a":
                                    //System.out.println(campos[0]+" "+campos[1]+" "+campos[2]+" "+campos[3]+" "+campos[4]+" "+campos[5]+" "+campos[6]+" "+BanderaCancelacion );
                                    fichero.write("Del" + " " + campos[1] + " " + campos[2] + " " + campos[3] + " " + "al" + " " + campos[4] + " " + campos[5] + " " + campos[6] + "      " + BanderaCancelacion + "       " + "RESERVACIONES CANCELADAS");
                                    break;
                                case "b":
                                    //System.out.println(campos[0]+" "+campos[1]+" "+campos[2]+" "+campos[3]+" "+campos[4]+" "+campos[5]+" "+campos[6]+" "+BanderaEfectivo);
                                    fichero.write("Del" + " " + campos[1] + " " + campos[2] + " " + campos[3] + " " + "al" + " " + campos[4] + " " + campos[5] + " " + campos[6] + "      " + BanderaEfectivo + "       " + "RESERVACIONES EFECTIVAS");
                                    break;
                                case "c":
                                    //System.out.println(campos[0]+" "+campos[1]+" "+campos[2]+" "+campos[3]+" "+campos[4]+" "+campos[5]+" "+campos[6]+" "+" nºAdultos: "+BanderaAdulto+" nºNiños:" +BanderaNiño);
                                    fichero.write("Del" + " " + campos[1] + " " + campos[2] + " " + campos[3] + " " + "al" + " " + campos[4] + " " + campos[5] + " " + campos[6] + "      " + "Adultos Atendidos: " + BanderaAdulto + "\n"
                                            + "                                     " + "Niños Atendidos:" + BanderaNiño);
                                    break;
                                case "d":
                                    System.out.println("Del" + " " + campos[1] + " " + campos[2] + " " + campos[3] + " " + "al" + " " + campos[4] + " " + campos[5] + " " + campos[6] + "      " + BanderaEfectivo + "       " + "INGRESOS POR CAMAS ADICIONALES");
                                    fichero.write("Del" + " " + campos[1] + " " + campos[2] + " " + campos[3] + " " + "al" + " " + campos[4] + " " + campos[5] + " " + campos[6] + "      " + BanderaEfectivo + "       " + "INGRESOS POR CAMAS ADICIONALES");
                                    break;
                                case "e":
                                    System.out.println("Del" + " " + campos[1] + " " + campos[2] + " " + campos[3] + " " + "al" + " " + campos[4] + " " + campos[5] + " " + campos[6] + "      " + BanderaEfectivo + "       " + "PISO CON MAYOR USO");
                                    fichero.write("Del" + " " + campos[1] + " " + campos[2] + " " + campos[3] + " " + "al" + " " + campos[4] + " " + campos[5] + " " + campos[6] + "      " + BanderaEfectivo + "       " + "PISO CON MAYOR USO");
                                    break;
                                case "f":
                                    System.out.println("Del" + " " + campos[1] + " " + campos[2] + " " + campos[3] + " " + "al" + " " + campos[4] + " " + campos[5] + " " + campos[6] + "      " + BanderaEfectivo + "       " + "TRANSFERENCIAS TOTALES");
                                    fichero.write("Del" + " " + campos[1] + " " + campos[2] + " " + campos[3] + " " + "al" + " " + campos[4] + " " + campos[5] + " " + campos[6] + "      " + BanderaEfectivo + "       " + "TRANSFERENCIAS TOTALES");
                                    break;
                                case "g":
                                    System.out.println("Del" + " " + campos[1] + " " + campos[2] + " " + campos[3] + " " + "al" + " " + campos[4] + " " + campos[5] + " " + campos[6] + "      " + BanderaEfectivo + "       " + "INGRESOS POR USO DE CAJA FUERTE");
                                    fichero.write("Del" + " " + campos[1] + " " + campos[2] + " " + campos[3] + " " + "al" + " " + campos[4] + " " + campos[5] + " " + campos[6] + "      " + BanderaEfectivo + "       " + "INGRESOS POR USO DE CAFA FUERTE");
                                    break;
                                case "h":
                                    System.out.println("Del" + " " + campos[1] + " " + campos[2] + " " + campos[3] + " " + "al" + " " + campos[4] + " " + campos[5] + " " + campos[6] + "      " + BanderaEfectivo + "       " + "%DE OCUPACION DIARIA");
                                    fichero.write("Del" + " " + campos[1] + " " + campos[2] + " " + campos[3] + " " + "al" + " " + campos[4] + " " + campos[5] + " " + campos[6] + "      " + BanderaEfectivo + "       " + "%PDE OCUPACION DIARIA");
                                    break;
                                case "i":
                                    System.out.println("Del" + " " + campos[1] + " " + campos[2] + " " + campos[3] + " " + "al" + " " + campos[4] + " " + campos[5] + " " + campos[6] + "      " + BanderaEfectivo + "       " + "PROMEDIO DE OCUPACION DIARIA");
                                    fichero.write("Del" + " " + campos[1] + " " + campos[2] + " " + campos[3] + " " + "al" + " " + campos[4] + " " + campos[5] + " " + campos[6] + "      " + BanderaEfectivo + "       " + "PROMEDIO DE OCUPACION DIARIA");
                                    break;
                                //System.out.println("Al"+" "+campos[4]+" "+campos[5]+" "+campos[6]);
                                //fichero.write("Al"+" "+campos[4]+" "+campos[5]+" "+campos[6]);
                                case "j":
                                    break;
                                //System.out.println("Al"+" "+campos[4]+" "+campos[5]+" "+campos[6]);
                                //fichero.write("Al"+" "+campos[4]+" "+campos[5]+" "+campos[6]);
                                case "k":
                                    break;
                                //System.out.println("Al"+" "+campos[4]+" "+campos[5]+" "+campos[6]);
                                //fichero.write("Al"+" "+campos[4]+" "+campos[5]+" "+campos[6]);
                                case "l":
                                    break;
                                default:
                                    break;
                            }
                        }

                        break;

                    default:
                        break;
                }
            }

        }
    }


    public void contabilidad() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("inicializar.in"));
        SaldoInicial = br.readLine();
        SaldoActual = Float.parseFloat(SaldoInicial);

        FileWriter fichero = new FileWriter("contabilidad.out");
        fichero.append("FECHA      |DEBE           |HABER          |SALDO          |CONCEPTO\n");

        fichero.close();

    }

    public void contabilidadServicios(float debeServicioSolicitado) throws IOException {
        FileWriter fichero = new FileWriter("contabilidad.out", true);
        SaldoActual += debeServicioSolicitado;
        fichero.append(actualizarFecha()[0] + "/" + actualizarFecha()[1] + "/" + actualizarFecha()[2] + "  |           " + debeServicioSolicitado + "|" + "               |       " + SaldoActual + "|" + "Servicios\n");

        fichero.close();
    }

    public void contabilidadRestaurant(float debeComidaRestaurant) throws IOException {
        FileWriter fichero = new FileWriter("contabilidad.out", true);
        SaldoActual += debeComidaRestaurant;
        fichero.append(actualizarFecha()[0] + "/" + actualizarFecha()[1] + "/" + actualizarFecha()[2] + "  |          " + debeComidaRestaurant + "|         " + "      |       " + SaldoActual + "|" + "Restaurant\n");

        fichero.close();
    }

    public void contabilidadNomina() throws IOException {
        FileWriter fichero = new FileWriter("contabilidad.out", true);
        SaldoActual -= Nomina;
        fichero.append(actualizarFecha()[0] + "/" + actualizarFecha()[1] + "/" + actualizarFecha()[2] + "  |        " + "       |        " + Nomina + "|        " + SaldoActual + "|" + "Nomina\n");

        fichero.close();
    }

    public void contabilidadCheck_Out(float pago) throws IOException {
        FileWriter fichero = new FileWriter("contabilidad.out", true);
        SaldoActual += pago;
        fichero.append(actualizarFecha()[0] + "/" + actualizarFecha()[1] + "/" + actualizarFecha()[2] + "  |          " + pago + "|               " + "|        " + SaldoActual + "|" + "Check-Out\n");

        fichero.close();
    }

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
        switch (Habitacion) {
            case "INDIV":
                b = (float) 150.00 * dias;
                break;
            case "DOBLE":
                b = (float) 200.00 * dias;
                break;
            case "MATRI":
                b = (float) 180.00 * dias;
                break;
            case "CUADR":
                b = (float) 380.00 * dias;
                break;
            default:
                b = (float) 900.00 * dias;
                break;
        }
        return b;
    }

 
}
