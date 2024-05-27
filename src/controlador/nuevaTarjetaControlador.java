package controlador;

import programa.*;
import vista.Dashboard;
import vista.LoginForm;
import vista.NewUser;
import vista.nuevaTarjeta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class nuevaTarjetaControlador implements ActionListener {
    private nuevaTarjeta vista;

    public nuevaTarjetaControlador(nuevaTarjeta visita) throws IOException, ClassNotFoundException {
        this.vista = visita;
        vista.solicitar.addActionListener(this);
        vista.setCuentas();
        vista.volver.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Solicitar Tarjeta":
                try {
                    insertarTarjeta();
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

    public void insertarTarjeta() throws SQLException, IOException, ClassNotFoundException {
        Cuenta cuenta = cuentaDAO.buscarCuentaPorNombre(vista.getCuenta(), Util.con());

        Tarjeta tarjeta = new Tarjeta(cuenta.getId(), vista.getTipoTarjeta(), vista.getNombreTarjeta());
        TarjetaDAO.crearTarjeta(tarjeta, Util.con());

    }


}
