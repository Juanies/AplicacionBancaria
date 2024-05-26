package vista;

import programa.Financiacion;
import programa.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class nuevaFinanciacionDAO {
    public static ArrayList<Financiacion> obtenerTodosFinanciacion(Connection connection) throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM financiacion";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Financiacion financiacion = new financiacion(
                        rs.getInt("id"),
                        rs.getString("cuentaID"),
                        rs.getString("cantidad"),
                        rs.getString("motivo"),
                        rs.getString("aceptado")
                );
                usuario.setId(rs.getInt("id"));
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

}
