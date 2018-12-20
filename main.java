
package ProyectoHotel;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        ArchivoEntrada a = new ArchivoEntrada();
        System.out.println("\n ------------  INICIALIZAR.IN ------------ ");
        a.inicializar();
        System.out.println(" \n ------------ PRECIOS.IN ------------  ");
        a.precios();
    }
    
}
