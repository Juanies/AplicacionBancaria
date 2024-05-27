package controlador;

import programa.*;
import vista.Dashboard;
import vista.NuevaFinanciacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class NuevaFinanciacionControlador implements ActionListener {
    private NuevaFinanciacion vista;

    public NuevaFinanciacionControlador(NuevaFinanciacion visita) throws IOException, ClassNotFoundException {
        this.vista = visita;
        vista.solicitar.addActionListener(this);
        vista.setCuentas();
        vista.volver.addActionListener(this);

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
            case "Volver":
                try {
                    Ventana.nuevaVentana(vista, new DashBoardControlador(new Dashboard()));
                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                break;
        }
    }

    public void solicitar() throws SQLException, IOException, ClassNotFoundException {

        double monto = Double.parseDouble(vista.getMontoFinanciado());
        String motivo = vista.getMotivoFinanciacion();
        String cuenta = vista.getCuenta();

        Cuenta cuentaUsuario = CuentaDAO.buscarCuentaPorNombre(cuenta, Util.con());
        Financiacion nueva = new Financiacion(cuentaUsuario.getId(), monto, motivo, false);
        FinanciacionDAO.nuevaFinanciacion(Util.con(), nueva);

    }
}
