
package controlador;

import programa.*;
        import vista.*;

        import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import java.util.HashMap;

public class DashBoardControlador  implements ActionListener {
    private Dashboard vista;

    public DashBoardControlador(Dashboard vista) {
        this.vista = vista;
        vista.cambiar.addActionListener(this);
        try {
            setInformacionUsuario();
            setCuentas();
            setTarjetas();
            setPrestamos();
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

        for(JButton boton : vista.botones){
            boton.addActionListener(this);
        }

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Cambiar":
                try {
                    Ventana.nuevaVentana(vista, new LoginFormControlador(new LoginForm()));
                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            case "Nueva cuenta":
                try {
                    Ventana.nuevaVentana(vista, new NuevaCuentaControlador(new NuevaCuenta()));
                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            case "Nueva tarjeta":
                try {
                    Ventana.nuevaVentana(vista, new NuevaTarjetaControlador(new NuevaTarjeta()));
                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            case "Nueva financiación":
                try {
                    Ventana.nuevaVentana(vista, new NuevaFinanciacionControlador(new NuevaFinanciacion()));
                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            case "Enviar dinero":
                try {
                    Ventana.nuevaVentana(vista, new NuevaTransaccionControlador(new EnviarDinero()));
                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                break;
        }
    }

    public void setTarjetas() throws IOException, ClassNotFoundException, SQLException {
        Connection con = Util.con();
        int usuarioId = UsuarioDAO.getUsuarioActual().getId();

        ArrayList<Cuenta> cuentasUsuario = CuentaDAO.cogerTodasCuentasUsuario(usuarioId, con);
        ArrayList<Tarjeta> tarjetasUsuario = TarjetaDAO.cogerTarjetasTodasCuentas(cuentasUsuario, con);

        HashMap<Integer, Double> saldoPorCuenta = new HashMap<>();
        for (Cuenta cuenta : cuentasUsuario) {
            saldoPorCuenta.put(cuenta.getId(), cuenta.getSaldo());
        }
        vista.setTarjetas(tarjetasUsuario, saldoPorCuenta);
    }

    public void setPrestamos() throws IOException, ClassNotFoundException {
        vista.setFinanciacion(FinanciacionDAO.cogerTodasFinanciacionCuentas(UsuarioDAO.getUsuarioActual().getId(), Util.con()));
    }

    private void setInformacionUsuario() throws SQLException, IOException, ClassNotFoundException {
        vista.setSaludoText("Buenas tardes, " + UsuarioDAO.getUsuarioActual().getUsuario());
        vista.setUltimaConexion(UsuarioDAO.ultimaConexion(UsuarioDAO.getUsuarioActual().getId(), Util.con()));
    }

    private void setCuentas() throws SQLException, IOException, ClassNotFoundException {
        vista.setCuentas(CuentaDAO.cogerTodasCuentasUsuario(UsuarioDAO.getUsuarioActual().getId(), Util.con()));

        double saldoTotal = CuentaDAO.saldoTodasCuentas(UsuarioDAO.getUsuarioActual().getId(), Util.con());
        vista.setDineroTotalText(String.valueOf(saldoTotal));

        double financiacionTotal = FinanciacionDAO.financiacionTotal(UsuarioDAO.getUsuarioActual().getId(), Util.con());
        vista.setFinanciacionTotalText(String.valueOf(financiacionTotal));
    }



}
