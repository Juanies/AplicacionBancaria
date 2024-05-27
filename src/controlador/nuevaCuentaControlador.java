package controlador;

import programa.UsuarioDAO;
import programa.Util;
import programa.Ventana;
import programa.cuentaDAO;
import vista.Dashboard;
import vista.NuevaCuenta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class nuevaCuentaControlador implements ActionListener {
    private NuevaCuenta vista;

    public nuevaCuentaControlador(NuevaCuenta vista){
        this.vista = vista;
        vista.crear.addActionListener(this);
        vista.volver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Crear Cuenta":
                try {
                    crearCuenta();
                } catch (IOException | ClassNotFoundException | SQLException ex) {
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

    public void crearCuenta() throws IOException, ClassNotFoundException, SQLException {
        String tipoCuenta = vista.gettipoCuenta();
        String nombreCuenta = vista.getCuentaNombre();
        int idUsuarioActual = UsuarioDAO.getUsuarioActual().getId();

        cuentaDAO.crearCuenta(idUsuarioActual, tipoCuenta, nombreCuenta, Util.con());

    }


}
