package ProyectoHotel;

import java.io.BufferedReader;
import java.io.FileReader;

public class ArhivoSalida {
    
    public void reservaciones(){
        
        String cadena="";
        try {
            FileReader lector = new FileReader("operaciones.in");
            BufferedReader BR = new BufferedReader(lector);
            while ((cadena = BR.readLine()) != null) {
                
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
