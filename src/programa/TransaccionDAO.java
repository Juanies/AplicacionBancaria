package programa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransaccionDAO {

    public static void crearTransaccion(Transaccion transaccion, Connection connection) throws SQLException {
        String sql = "INSERT INTO financiacion (idorigen, iddestino, cantidad) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, transaccion.getIdorigen());
            stmt.setInt(2, transaccion.getIddestino());
            stmt.setDouble(3, transaccion.getCantidad());

            stmt.executeUpdate();
        }
    }

}
