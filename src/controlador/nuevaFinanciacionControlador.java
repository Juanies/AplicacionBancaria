package controlador;

import programa.*;
import vista.LoginForm;
import vista.NewUser;
import vista.nuevaFinanciacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class nuevaFinanciacionControlador implements ActionListener {
    private nuevaFinanciacion vista;

    public nuevaFinanciacionControlador(nuevaFinanciacion visita) throws IOException, ClassNotFoundException {
        this.vista = visita;
        vista.solicitar.addActionListener(this);
        vista.setCuentas();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Solicitar Financiación":
                try {
                    solicitar();
                } catch (SQLException | IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                break;
        }
    }

    public void solicitar() throws SQLException, IOException, ClassNotFoundException {

        double monto = Double.parseDouble(vista.getMontoFinanciado());
        String motivo = vista.getMotivoFinanciacion();
        String cuenta = vista.getCuenta();

        Cuenta cuentaUsuario = cuentaDAO.buscarCuentaPorNombre(cuenta, Util.con());
        Financiacion nueva = new Financiacion(cuentaUsuario.getId(), monto, motivo, false);
        FinanciacionDAO.nuevaFinanciacion(Util.con(), nueva);

    }
}
