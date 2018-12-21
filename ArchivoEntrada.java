
package ProyectoHotel;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArchivoEntrada {
         
    public void inicializar() throws IOException {
        String cadena;
      FileReader f = new FileReader("inicializar.in");
        try (BufferedReader b = new BufferedReader(f)) {
            while((cadena = b.readLine())!=null) {
                System.out.println(cadena);
            } }
}
    public void precios() throws IOException {
        String cadena;
      FileReader f = new FileReader("precios.in");
        try (BufferedReader b = new BufferedReader(f)) {
            while((cadena = b.readLine())!=null) {
                System.out.println(cadena);
            } }
}
    public void operaciones()throws IOException {
        String cadena;
      FileReader f = new FileReader("operaciones.in");
        try (BufferedReader b = new BufferedReader(f)) {
            while((cadena = b.readLine())!=null) {
                System.out.println(cadena);
            } }
    
    }


 
 
}

