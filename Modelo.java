import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Modelo extends Vista {

    protected int bandera = 0, banderaRevision = 0;
    protected String varA, varB, varC, varD, varE, varF, varG, varH;

    public static String fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);
    }

    public void BuscarArchivo() {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt", "in", "out");
        fc.setFileFilter(filtro);
        Component contentPane = null;

        int seleccion = fc.showOpenDialog(contentPane);
        if (seleccion == JFileChooser.APPROVE_OPTION) {

            File fichero = fc.getSelectedFile();
            try (FileReader fr = new FileReader(fichero)) {
                String cadena = "";
                int valor = fr.read();
                while (valor != -1) {
                    cadena = cadena + (char) valor;
                    valor = fr.read();
                }
            } catch (IOException e1) {

            }
        }
    }

    public String comprobar() {
        String sFichero = "inicializar.in";
        File fichero = new File(sFichero);

        String comprobacion, comprobacion2;

        if (fichero.exists()) {
            comprobacion = "El archivo " + sFichero + " se cargo con el programa";
        } else {
            comprobacion = "\nEl archivo " + sFichero + " no se cargo con el programa";
        }
        String dFichero = "precios.in";
        File fichero2 = new File(dFichero);

        if (fichero2.exists()) {

            comprobacion2 = "\n\nEl archivo " + dFichero + " se cargo con el programa";

        } else {
            comprobacion2 = "\n\nEl archivo " + dFichero + " no se cargo con el programa";
        }
        return comprobacion + comprobacion2;
    }

    public void Inicializar_in() {
        String ValorHotel = "100250.00";
        try {
            FileWriter fichero = new FileWriter("inicializar.in");
            fichero.append(ValorHotel);
            fichero.write("\r\n");
            String anio = null;
            String mes;
            String dia;

            fichero.write("01" + " " + "01" + " " + "2019");
            fichero.append("\r\n");

            int NumeroPiso = (int) (Math.random() * 10) + 1;
            List<String>[] ListaTipoHabitacion = new List[NumeroPiso];

            String n_1 = Integer.toString(NumeroPiso);
            int cont = 0;

            for (int x = 0; x < NumeroPiso; x++) {
                int NumeroHabitaciones = (int) (Math.random() * 5) + 1;

                List<String> ListaHabitacion = new ArrayList<>();

                for (int i = 0; i < NumeroHabitaciones; i++) {
                    int TipoDeHabitacion = (int) (Math.random() * 5) + 1;
                    String Habitacion = Integer.toString(TipoDeHabitacion);

                    ListaHabitacion.add(Habitacion);
                    cont++;
                }
                ListaTipoHabitacion[x] = ListaHabitacion;
            }
            String contador = Integer.toString(cont);
            fichero.write(contador + " ");
            fichero.write(n_1);
            fichero.append("\r\n");

            for (int x = 0; x < NumeroPiso; x++) {
                List<String> LH = new ArrayList<>();

                fichero.write(ListaTipoHabitacion[x].size() + " ");

                LH.addAll(ListaTipoHabitacion[x]);

                for (int y = 0; y < ListaTipoHabitacion[x].size(); y++) {

                    String var = LH.get(y);

                    if (var.equals("1")) {
                        fichero.write("INDIV" + " ");

                    } else if (var.equals("2")) {
                        fichero.write("MATRI" + " ");

                    } else if (var.equals("3")) {
                        fichero.write("DOBLE" + " ");

                    } else if (var.equals("4")) {
                        fichero.write("CUADR" + " ");

                    } else if (var.equals("5")) {
                        fichero.write("SUITE" + " ");

                    }
                }
                fichero.append("\r\n");
            }

            fichero.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            FileReader lector = new FileReader("inicializar.in");
            BufferedReader BR = new BufferedReader(lector);
            String cadena;

            while ((cadena = BR.readLine()) != null) {
            }
            BR.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
