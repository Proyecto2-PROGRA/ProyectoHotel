
package ProyectoHotel;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        ArchivoEntrada a = new ArchivoEntrada();
        //System.out.println("\n ------------  INICIALIZAR.IN ------------ ");
        //a.inicializar();
        //System.out.println(" \n ------------ PRECIOS.IN ------------  ");
        //a.precios();
         //System.out.println(" \n ------------ OPERACIONES.IN ------------  ");
         //a.operaciones();
         ArchivoSalida s= new ArchivoSalida();
         //s.contabilidad();
         s.reservaciones();
         //s.actualizarFecha();
    }
    
}
