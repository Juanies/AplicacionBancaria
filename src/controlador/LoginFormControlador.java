package controlador;

import programa.Usuario;
import programa.UsuarioDAO;
import programa.Util;
import programa.Ventana;
import vista.Dashboard;
import vista.LoginForm;
import vista.NewUser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginFormControlador implements ActionListener {
    private LoginForm vista;

    public LoginFormControlador(LoginForm visita){
        this.vista = visita;
        vista.tipoDocumentoDropdown.addActionListener(this);
        vista.numeroDocumentoField.addActionListener(this);
        vista.claveField.addActionListener(this);
        vista.entrar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Entrar":
                try {
                    loginForm();
                } catch (SQLException | IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                break;
        }
    }

    public void loginForm() throws SQLException, IOException, ClassNotFoundException {
        ArrayList<Usuario> usuarios = UsuarioDAO.obtenerTodosLosUsuarios(Util.con());
        for(Usuario  usuario : usuarios){
            if (usuario.getDocumento().equals(vista.getDocumento()) && usuario.getTipoInicio().equals(vista.getTipoDocumento()) && usuario.getClave().equals(vista.getClave())){
                UsuarioDAO.setUsuarioActual(usuario);
                UsuarioDAO.actualizarSesion(usuario, Util.con());
                Ventana.nuevaVentana(vista, new DashBoardControlador(new Dashboard()));
            }else if (vista.getTipoDocumento().equals("Usuario") && usuario.getUsuario().equals(vista.getDocumento()) && usuario.getClave().equals(vista.getClave())){
                UsuarioDAO.setUsuarioActual(usuario);
                UsuarioDAO.actualizarSesion(usuario, Util.con());
                Ventana.nuevaVentana(vista, new DashBoardControlador(new Dashboard()));
            }else{
                System.out.println("Fallo");
            }
        }

    }


}
