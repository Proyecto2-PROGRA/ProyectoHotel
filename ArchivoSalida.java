package ProyectoHotel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
    protected String SaldoInicial;
    protected double Nomina=25000.00;

 public ArchivoSalida()  throws FileNotFoundException, IOException{
        df = new SimpleDateFormat("dd/MM/yyyy");
        fecha = Calendar.getInstance();
        try{
            BufferedReader BR = new BufferedReader (new FileReader ("inicializar.in"));
            BR.readLine();
            cadena = BR.readLine();
            String[] campos = cadena.split(" ");
            fechaInicial = (campos[0]+"/"+campos[1]+"/"+campos[2]);
            
            try{
                testDate=df.parse(fechaInicial);
                fecha.setTime(testDate);//FechaSumando
            }catch(Exception ex){}  
        }catch(Exception ex){}
    }
 
    public void reservaciones() throws FileNotFoundException, IOException {
        FileWriter fichero = new FileWriter("reservaciones.out");
        
        try (BufferedReader BR = new BufferedReader (new FileReader ("operaciones.in"))) {
        while ((cadena = BR.readLine()) != null) {
        switch (cadena) {
            
            case "0":
                fecha.add(Calendar.DAY_OF_WEEK, 1);
                
                break;
                
            case "1":
                cadena = BR.readLine();
                campos = cadena.split(" ");
                 try{
                    fechaLlegada = (campos[0]+"/"+campos[1]+"/"+campos[2]);
                    fechaSalida =(campos[3]+"/"+campos[4]+"/"+campos[5]);
                    
                    try{
                        fechaLlegadaSuma=df.parse(fechaLlegada);                        
                        fechaSalidaSuma=df.parse(fechaSalida);
                    }catch(Exception ex){}  
                }catch(Exception ex){}
                 
                cadena = BR.readLine();
                tipoHabitacion=cadena;
                cadena = BR.readLine();
                if (cadena.equals("1")){
                    cadena = BR.readLine();
                }else{
                   personaEnHabitacion=Integer.parseInt(cadena);
                   for(int i=0;i<personaEnHabitacion; i++){
                       campoPersona = cadena.split(" ");
                       cadena = BR.readLine();
                       if(campoPersona[0].equals("A")){
                           break;
                       }
                   }
                }   
                campoPersona = cadena.split(" ");
                int diasTotal =(int) ((fechaSalidaSuma.getTime()-fechaLlegadaSuma.getTime())/86400000);
                fichero.append("RESERVACIÓN--("+actualizarFecha()[0]+"/"+actualizarFecha()[1]+"/"+actualizarFecha()[2]+")\n");
                fichero.write("    Titular: "+ cadena.split(" ")[1]+"\n");
                fichero.write("    Habitación "+tipoHabitacion+" del "+fechaLlegada+" "+fechaSalida+ " ("+diasTotal+" dias)"+"\n");
                break;
                
            case "2":
                cadena = BR.readLine();
                fichero.write("CANCELACIÓN--("+actualizarFecha()[0]+"/"+actualizarFecha()[1]+"/"+actualizarFecha()[2]+" "+cadena.split(" ")[1]+")\n");
                fichero.write("    Titular: "+ cadena.split(" ")[0]+"\n");
                break;
                
            case "3":
                cadena = BR.readLine();
                fichero.write("CHECK-IN-----("+actualizarFecha()[0]+"/"+actualizarFecha()[1]+"/"+actualizarFecha()[2]+" "+cadena.split(" ")[1]+")\n");
                fichero.write("    Titular: "+ cadena.split(" ")[0]+"\n");
                fichero.write("    Habitación "+ cadena.split(" ")[0]+"\n");
                break;
                
            case "4":
                    cadena = BR.readLine();                    
                    fichero.write("CHECK-OUT----("+actualizarFecha()[0]+"/"+actualizarFecha()[1]+"/"+actualizarFecha()[2]+" "+cadena.split(" ")[1]+")\n");
                    fichero.write("    Titular: "+ cadena.split(" ")[0]+"\n");
                    fichero.write("    Cancelo: "+ cadena.split(" ")[1]+"\n");
                break;
                
            case "5":
                    cadena = BR.readLine();
                    comidaRestaurant=Integer.parseInt(cadena);
                    for(int i=0;i<comidaRestaurant;i++){
                        cadena= BR.readLine();
                        String[] campos = cadena.split(" ");
                        if(campos[0].equals("ESP_C")){
                            debeComidaRestaurant+=(float) 55.00;  
                        }else if(campos[0].equals("LOM_M")){
                            debeComidaRestaurant+=(float) 71.50;
                        }else if(campos[0].equals("JUG_L")){
                            debeComidaRestaurant+=(float) 10.00;
                        }else if(campos[0].equals("MALTA")){
                            debeComidaRestaurant+=(float) 6.00;  
                        }
                    }
                 break;
                 
            case "6":
                    cadena = BR.readLine();
                    System.out.println("Rut "+cadena);
                    cadena = BR.readLine();
                    servicioSolicitado = Integer.parseInt(cadena);
                    debeServicioSolicitado = (float) 50.00*servicioSolicitado;
                    
     
                break;
            case "7":
                break;
                
            default:
                break;
                }
            }
        }
        
        fichero.close();
        
        contabilidad(debeServicioSolicitado, debeComidaRestaurant);
        
    }
    
     public void contabilidad(float debeServicioSolicitado, float debeComidaRestaurant)throws IOException{
        
        BufferedReader br = new BufferedReader (new FileReader ("inicializar.in"));
        SaldoInicial = br.readLine();        
	float SaldoActual = Float.parseFloat(SaldoInicial);

            FileWriter fichero2 = new FileWriter("contabilidad.out");
            fichero2.append("FECHA      |DEBE           |HABER          |SALDO          |CONCEPTO\n");

            fichero2.append(fechaInicial+"      |" +SaldoInicial+"      |" + "      |" +SaldoActual + "      |" + "Saldo inicial\n");

            SaldoActual+=debeServicioSolicitado;
            fichero2.append(fechaInicial+"      |" +debeServicioSolicitado+"      |" + "      |" +SaldoActual + "      |" + "Servicios\n");

            SaldoActual+=debeComidaRestaurant;
            fichero2.append(fechaInicial+"      |" +debeComidaRestaurant+"      |" + "      |" +SaldoActual + "      |" + "Restaurant\n");
           
            SaldoActual-=Nomina;
            fichero2.append(fechaInicial+"      |" +"      |"+Nomina + "      |" +SaldoActual + "      |" + "Nomina\n");
                    

            fichero2.close();
       
    } 
     
    public void reportes(){
        
    }
    public String[] actualizarFecha(){
        String fechaActualizada;
        annioActual = fecha.get(Calendar.YEAR);
        mesActual = fecha.get(Calendar.MONTH)+1;
        diaActual = fecha.get(Calendar.DAY_OF_MONTH);
        
        fechaActualizada=diaActual+" "+mesActual+" "+annioActual;
        fechaActual = fechaActualizada.split(" ");
        return fechaActual;
    }
}
