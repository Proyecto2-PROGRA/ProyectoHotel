package ProyectoHotel;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ArchivoSalida {
    protected int diaLlegada;
    protected int diaSalida;
    protected int mesLlegada;
    protected int mesSalida;
    protected int annioLlegada;
    protected int annioSalida;
    protected int personaEnHabitacion;
    protected int diaActual;
    protected int mesActual;
    protected int annioActual;
    protected String tipoHabitacion;
    protected String rutPersona;
    protected String cadena;
    protected SimpleDateFormat df;
    protected String fechaInicial;
    protected String date;
    protected Date testDate;
    protected Calendar fecha;
    protected String[] campos;
    protected String[] campoPersona;
    protected Integer servicioSolicitado;
    protected float debeServicioSolicitado;
    protected int comidaRestaurant;
    protected float debeComidaRestaurant;
 

 public ArchivoSalida()  throws FileNotFoundException, IOException{
        df = new SimpleDateFormat("dd/MM/yyyy");
        fecha = Calendar.getInstance();
        try{
            BufferedReader BR = new BufferedReader (new FileReader ("inicializar.in"));
            BR.readLine();
            cadena = BR.readLine();
            String[] campos = cadena.split(" ");
            diaActual = Integer.parseInt(campos[0]);
            mesActual = Integer.parseInt(campos[1]);
            annioActual = Integer.parseInt(campos[2]);
            fechaInicial = (campos[0]+"/"+campos[1]+"/"+campos[2]);
            
            try{
                testDate=df.parse(fechaInicial);
                fecha.setTime(testDate);//FechaSumando
                
                
               
                
            }catch(Exception ex){}
            
        }catch(Exception ex){}
        
        
    }
    
    
    public void reservaciones() throws FileNotFoundException, IOException {
                
        try (BufferedReader BR = new BufferedReader (new FileReader ("operaciones.in"))) {
        while ((cadena = BR.readLine()) != null) {
        switch (cadena) {
            case "0":
                fecha.add(Calendar.DAY_OF_WEEK, 1);
                break;
            case "1":
                               
                annioActual = fecha.get(Calendar.YEAR);
                mesActual = fecha.get(Calendar.MONTH)+1;
                diaActual = fecha.get(Calendar.DAY_OF_MONTH);
                
                cadena = BR.readLine();
                campos = cadena.split(" ");
                
                 try{
                    diaLlegada =Integer.parseInt(campos[0]);
                    mesLlegada =Integer.parseInt(campos[1]);
                    annioLlegada =Integer.parseInt(campos[2]);
                    diaSalida =Integer.parseInt(campos[3]);
                    mesSalida =Integer.parseInt(campos[4]); 
                    annioSalida =Integer.parseInt(campos[5]);
//Diferencia entre dias                    
//int dias=(int) ((fechaActual.getTime()-fechaUltimaSincro.getTime())/86400000);
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
                System.out.println("RESERVACIÓN--("+diaActual+"/"+mesActual+"/"+annioActual+")");
                System.out.println("    Titular: "+ campoPersona[1]);
                System.out.println("    Habitación "+tipoHabitacion+" del "+campos[0]+"/"+campos[1]+"/"+campos[2]+" al " +campos[3]+"/"+campos[4]+"/"+campos[5]+ "7"+" dias");
                break;
            case "2":
                annioActual = fecha.get(Calendar.YEAR);
                mesActual = fecha.get(Calendar.MONTH)+1;
                diaActual = fecha.get(Calendar.DAY_OF_MONTH);
                cadena = BR.readLine();
                campoPersona = cadena.split(" ");
                
                System.out.println("CANCELACIÓN--("+diaActual+"/"+mesActual+"/"+annioActual+" "+campoPersona[1]+")");
                System.out.println("    Titular: "+ campoPersona[0]);
                
                
                break;
            case "3":
                annioActual = fecha.get(Calendar.YEAR);
                mesActual = fecha.get(Calendar.MONTH)+1;
                diaActual = fecha.get(Calendar.DAY_OF_MONTH);
                cadena = BR.readLine();
                campoPersona = cadena.split(" ");
                    
                System.out.println("CHECK-IN-----("+diaActual+"/"+mesActual+"/"+annioActual+" "+campoPersona[1]+")");
                System.out.println("    Titular: "+ campoPersona[0]);
                System.out.println("    Habitación "+ campoPersona[1]);
                System.out.println(cadena);
                
                break;
                
            case "4":
                    annioActual = fecha.get(Calendar.YEAR);
                    mesActual = fecha.get(Calendar.MONTH)+1;
                    diaActual = fecha.get(Calendar.DAY_OF_MONTH);
                    cadena = BR.readLine();
                    campoPersona = cadena.split(" ");
                    
                    System.out.println("CHECK-OUT----("+diaActual+"/"+mesActual+"/"+annioActual+" "+campoPersona[1]+")");
                    System.out.println("    Titular: "+ campoPersona[0]);
                    System.out.println("    Cancelo: "+ campoPersona[1]);
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
                    System.out.println("leeeeeeeeeeeer "+debeComidaRestaurant);
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
        

    }
    
     public void contabilidad()throws IOException{
         /*
        int rut = 0;
        int otro = 0;
        float precio;
        String s1;
        String s2;
       
        BufferedReader br = new BufferedReader (new FileReader ("inicializar.in"));

        s1 = br.readLine();
        s2 = br.readLine();
        
        float saldo = Float.parseFloat(s1);
        saldo=saldo;
        
            System.out.println("FECHA      |DEBE           |HABER          |SALDO          |CONCEPTO");
            System.out.println (fechaInicial+" | " +s1+"     | " + "              |" +saldo + "       |" + "saldo inicial");
            System.out.println();

        try (BufferedReader br2 = new BufferedReader (new FileReader ("operaciones.in"))) {
            
            while ((cadena = br2.readLine()) != null) {
                switch (cadena) {
                    case "6":
                         cadena = br2.readLine();
                        String[] campos = cadena.split(" ");

                            try{
                               rut =Integer.parseInt(campos[0]);
                               cadena = br2.readLine();
                               otro = Integer.parseInt(cadena);
                               
                               
                               for(int i = 0; i<otro;i++){
                                   cadena=br2.readLine();
                                   
                                   campos = cadena.split(" ");
                                   
                                   if(campos[0].equals("CAM_A")){
                                       precio=(float) 50.00;
                                       System.out.println(precio);     
                                   }
                                   else if(cadena.equals("CAJ_F")){
                                       precio=(float) 50.00;
                                       System.out.println(precio);
                                   }
                               }
                           }catch(Exception ex){}                             
                cadena = br2.readLine();
                tipoHabitacion=cadena;
                cadena = br2.readLine();
                if (cadena.equals("1")){
                    cadena = br2.readLine();
                }else{
                            
                }   
                String[] campopersona = cadena.split(" ");
                        System.out.println(rut);                       
                        break;
                }
                
            }
        }*/
   } 
     
    public void reportes(){
        
    }

}
