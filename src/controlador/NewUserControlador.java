package controlador;

import programa.Usuario;
import programa.UsuarioDAO;
import programa.Util;
import programa.Ventana;
import vista.NewUser;
import vista.OlvidarContraseña;
import vista.Problema;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class NewUserControlador implements ActionListener {
    private NewUser vista;

    public NewUserControlador(NewUser visita){
        this.vista = visita;
        vista.tipoDocumentoDropdown.addActionListener(this);
        vista.numeroDocumentoField.addActionListener(this);
        vista.usuarioField.addActionListener(this);
        vista.claveField.addActionListener(this);
        vista.registrarButton.addActionListener(this);
        vista.cancelarButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Registrar":
                try {
                    nuevoUsuario();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            case "Cancelar":
                try {
                    Ventana.nuevaVentana(vista, new ProblemaControlador(new Problema()));
                } catch ( ClassNotFoundException | IOException ex) {
                    throw new RuntimeException(ex);
                }
                break;
        }
    }

    public void nuevoUsuario() throws SQLException {
        Connection connection = Util.con();
        Usuario usuario = new Usuario(vista.getTipoDocumento(), vista.getDocumento(), vista.getUsuario(), vista.getClave() );

        UsuarioDAO.crearUsuario(usuario, connection);

        connection.close();
    }


}
