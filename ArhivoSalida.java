package ProyectoHotel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ArhivoSalida {
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
    protected String campoPersona;
    protected String cadena;
    
    public ArhivoSalida() throws FileNotFoundException, IOException{
        FileReader lector = new FileReader("inicializar.in");
        BufferedReader BR= new BufferedReader(lector); 
        BR.readLine();
        cadena = BR.readLine();
        String[] campos = cadena.split(" ");
        diaActual = Integer.parseInt(campos[0]);
        mesActual = Integer.parseInt(campos[1]);
        annioActual = Integer.parseInt(campos[2]);
    }
    
    
    public void reservaciones() throws FileNotFoundException, IOException {
                
        FileReader lector = new FileReader("operaciones.in");
        try (BufferedReader BR = new BufferedReader(lector)) {
        while ((cadena = BR.readLine()) != null) {
        switch (cadena) {
            case "0":
                System.out.println("Sumar dia");
                break;
            case "1":
                 cadena = BR.readLine();
                String[] campos = cadena.split(" ");
                 try{
                    diaLlegada =Integer.parseInt(campos[0]);
                    mesLlegada =Integer.parseInt(campos[1]);
                    annioLlegada =Integer.parseInt(campos[2]);
                    diaSalida =Integer.parseInt(campos[3]);
                    mesSalida =Integer.parseInt(campos[4]); 
                    annioSalida =Integer.parseInt(campos[5]);
                }catch(Exception ex){}
                 
                cadena = BR.readLine();
                tipoHabitacion=cadena;
                cadena = BR.readLine();
                if (cadena.equals("1")){
                    cadena = BR.readLine();
                }else{
                            
                }   
                String[] campoPersona = cadena.split(" ");
                System.out.println("RESERVACIÓN--("+"dia"+"/"+"mes"+"/"+"año");
                System.out.println("    Titular: "+ campoPersona[1]);
                System.out.println("Habitación "+tipoHabitacion+" del "+campos[0]+"/"+campos[1]+"/"+campos[2]+" al " +campos[3]+"/"+campos[4]+"/"+campos[5]+ "7"+" dias");
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    case "4":
                        break;
                    case "5":
                        break;
                    case "6":
                        break;
                    case "7":
                        break;
                    default:
                        break;
                }
                System.out.println(cadena);
            }
        }
        

    }
    
    public void contabilidad(){
        
    }
     
    public void reportes(){
        
    }

}
