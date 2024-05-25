package programa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {



    public static void crearUsuario(Usuario usuario, Connection connection) throws SQLException {
        String sql = "INSERT INTO usuario (tipo_incio, documento, usuario, clave) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getTipoInicio());
            stmt.setString(2, usuario.getDocumento());
            stmt.setString(3, usuario.getUsuario());
            stmt.setString(4, usuario.getClave());
            stmt.executeUpdate();
        }
    }

    public static Usuario obtenerUsuario(int id, Connection connection) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                        rs.getString("tipo_inicio"),
                        rs.getString("documento"),
                        rs.getString("usuario"),
                        rs.getString("clave")
                );
            }
        }
        return null;
    }

    public static ArrayList<Usuario> obtenerTodosLosUsuarios(Connection connection) throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getString("tipo_incio"),
                        rs.getString("documento"),
                        rs.getString("usuario"),
                        rs.getString("clave")
                );
                usuario.setId(rs.getInt("id"));
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    public static void actualizarUsuario(Usuario usuario, Connection connection) throws SQLException {
        String sql = "UPDATE usuario SET tipo_inicio = ?, documento = ?, usuario = ?, clave = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getTipoInicio());
            stmt.setString(2, usuario.getDocumento());
            stmt.setString(3, usuario.getUsuario());
            stmt.setString(4, usuario.getClave());
            stmt.setInt(5, usuario.getId());
            stmt.executeUpdate();
        }
    }

    public static void borrarUsuario(int id, Connection connection) throws SQLException {
        String sql = "DELETE FROM usuario WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
