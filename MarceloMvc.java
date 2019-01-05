
public class MarceloMvc {

    public static void main(String[] args) {
        Modelo m = new Modelo();
        Vista v =new Vista();
        Controlador c = new Controlador(m,v);
        c.iniciarVista();
    }
}
