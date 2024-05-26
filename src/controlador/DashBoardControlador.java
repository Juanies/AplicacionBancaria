package controlador;

import programa.Usuario;
import programa.UsuarioDAO;
import programa.Util;
import programa.cuentaDAO;
import vista.Dashboard;
import vista.LoginForm;
import vista.NewUser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class DashBoardControlador implements ActionListener {
    private Dashboard vista;

    public DashBoardControlador(Dashboard vista) throws IOException, ClassNotFoundException, SQLException {
        this.vista = vista;

        System.out.println(String.valueOf(cuentaDAO.saldoTodasCuentas(UsuarioDAO.getUsuarioActual().getId(), Util.con())));
        vista.setDineroTotalText(String.valueOf(cuentaDAO.saldoTodasCuentas(UsuarioDAO.getUsuarioActual().getId(), Util.con())));
        //vista.setFinanciacionTotalText(String.valueOf(cuentaDAO.financiacionTodasCuentas(UsuarioDAO.getUsuarioActual().getId(), Util.con())));
        vista.setSaludoText(UsuarioDAO.getUsuarioActual().getUsuario());
        vista.setUltimaConexion(UsuarioDAO.ultimaConexion(UsuarioDAO.getUsuarioActual().getId(), Util.con()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Entrar":
                break;
        }
    }





}