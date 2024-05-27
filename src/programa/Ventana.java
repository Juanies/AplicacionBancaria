package programa;


import javax.swing.*;
import java.io.IOException;


public class Ventana {
    public static <T> T nuevaVentana(JFrame viejaVista, T nuevaVista) throws IOException, ClassNotFoundException {
        T nuevoObjeto = null;
        viejaVista.dispose();


        nuevoObjeto = nuevaVista;

        return nuevoObjeto;
    }

}
