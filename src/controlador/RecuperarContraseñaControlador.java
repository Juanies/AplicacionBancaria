package controlador;

import programa.Ventana;
import programa.RecuperarContraseña;
import vista.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class RecuperarContraseñaControlador implements ActionListener {
    private OlvidarContraseña vista;

    public RecuperarContraseñaControlador(OlvidarContraseña visita){
        this.vista = visita;
        vista.cancelar.addActionListener(this);
        vista.recuperar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Cancelar":
                try {
                    Ventana.nuevaVentana(vista, new ProblemaControlador(new Problema()));
                } catch ( IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            case "Recuperar":
                try {
                    JOptionPane.showMessageDialog(null, RecuperarContraseña.recuperar(vista.getDocumento(), vista.getUsuario()));

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
        }
    }

}
