package controlador;

import programa.Ventana;
import vista.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ProblemaControlador implements ActionListener {
    private Problema vista;

    public ProblemaControlador(Problema visita){
        this.vista = visita;
        vista.botonPanelIzquierdo.addActionListener(this);
        vista.botonPanelDerecho.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Recuperar Clave":
                try {
                    Ventana.nuevaVentana(vista, new RecuperarContraseñaControlador(new OlvidarContraseña()));
                } catch ( IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            case "Alta en el servicio":
                try {
                    Ventana.nuevaVentana(vista, new NewUserControlador(new NewUser()));
                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
        }
    }

}
