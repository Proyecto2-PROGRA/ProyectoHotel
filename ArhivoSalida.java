package ProyectoHotel;

import java.io.BufferedReader;
import java.io.FileReader;

public class ArhivoSalida {
    protected int diaLlegada;
    protected int diaSalida;
    protected int mesLlegada;
    protected int mesSalida;
    protected int annioLlegada;
    protected int annioSalida;
    
    public void reservaciones(){
        
        String cadena="";
        
        try {
            FileReader lector = new FileReader("operaciones.in");
            BufferedReader BR = new BufferedReader(lector);
            
            while ((cadena = BR.readLine()) != null) {
                
                if (cadena.equals("0")) {
                     System.out.println("Sumar dia");
                     
                } 
                else if (cadena.equals("1")) {
                    
                    cadena = BR.readLine();
                    String[] campos = cadena.split(" ");
                    diaLlegada =Integer.parseInt(campos[0]);
                    mesLlegada =Integer.parseInt(campos[1]);
                    annioLlegada =Integer.parseInt(campos[2]);
                    diaSalida =Integer.parseInt(campos[3]);
                    mesSalida =Integer.parseInt(campos[4]);
                    annioSalida =Integer.parseInt(campos[5]);
                    
                    
                    
                    System.out.println("RESERVACIÓN--("+"dia"+"/"+"mes"+"/"+"año");
                    System.out.println("    Títular: "+"rut");
                    System.out.println("Habitación "+"dobl"+" del "+"dia"+"/"+"mes"+"/"+"año"+" al" +"dia"+"/"+"mes"+"/"+"año"+ "7"+" dias");
                    
                    
                }
                else if (cadena.equals("2")) {
                     
                }
                else if (cadena.equals("3")) {
                     
                }else if (cadena.equals("4")) {
                     
                }else if (cadena.equals("5")) {
                     
                }else if (cadena.equals("6")) {
                     
                }else if (cadena.equals("7")) {
                     
                }
                System.out.println(cadena);
            }

            BR.close();
        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }
    
    public void contabilidad(){
        
    }
     
    public void reportes(){
        
    }

}
