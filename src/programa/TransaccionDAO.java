package programa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TransaccionDAO {

    public static void crearTransaccion(Transaccion transaccion, Connection connection) throws SQLException {
        String sql = "INSERT INTO financiacion (idorigen, iddestino, cantidad, motivo, cuentaid) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, transaccion.getIdorigen());
            stmt.setInt(2, transaccion.getIddestino());
            stmt.setDouble(3, transaccion.getCantidad());
            stmt.setString(4, transaccion.getMotivo());
            stmt.setInt(5, transaccion.getCuentaid());

            stmt.executeUpdate();
        }
    }



}
