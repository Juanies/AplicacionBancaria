package programa;

import java.sql.SQLException;
import java.util.ArrayList;

public class RecuperarContraseña {
    public static String recuperar(String documento, String usuario) throws SQLException {
        ArrayList<Usuario> usuarios = UsuarioDAO.obtenerTodosLosUsuarios(Util.con());
        String contraseña = "";

        for (Usuario usuarioo : usuarios) {
            if (usuarioo.getDocumento().equals(documento) && usuarioo.getUsuario().equals(usuario)) {
                contraseña = usuarioo.getClave();

                break;
            }
        }

        return contraseña;
    }
}
