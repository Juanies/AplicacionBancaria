package controlador;

import programa.*;
import vista.Dashboard;
import vista.LoginForm;
import vista.NewUser;
import vista.enviarDinero;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class nuevaTransaccionControlador implements ActionListener {
    private enviarDinero vista;

    public nuevaTransaccionControlador(enviarDinero visita) throws IOException, ClassNotFoundException {
        this.vista = visita;
        vista.enviarButton.addActionListener(this);
        vista.volverButton.addActionListener(this);
        vista.setCuentas();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Enviar":
                try {
                    nuevaTrans();
                } catch (SQLException | IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            case "Volver":
                try {
                    Ventana.nuevaVentana(vista, new DashBoardControlador(new Dashboard()));
                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                break;
        }
    }

    public void nuevaTrans() throws SQLException, IOException, ClassNotFoundException {


        String nombreCuentaOrigen = vista.getSelectedCuenta();
        int idCuentaDestino = vista.getidCuentaField();

        Cuenta cuentaOrigen = cuentaDAO.buscarCuentaPorNombre(nombreCuentaOrigen, Util.con());
        Cuenta cuentaDestino = cuentaDAO.buscarCuentaPorId(idCuentaDestino, Util.con());

        System.out.println("Cuenta de origen ID: " + cuentaOrigen.getId());
        System.out.println("Cuenta de destino ID: " + cuentaDestino.getId());

        TransaccionDAO.enviarDinero(cuentaOrigen, cuentaDestino, vista.getCantidad(), vista.getMotivo(), Util.con());

    }


}


