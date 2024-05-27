package programa;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransaccionDAO {

    public static boolean enviarDinero(Cuenta origen, Cuenta destino, double cantidad, String motivo, Connection con) throws SQLException {
        int idOrigen = origen.getId();
        int idDestino = destino.getId();
        boolean res = false;

        try {
            double saldoOrigen = verSaldo(idOrigen, con);
            double saldoDestino = verSaldo(idDestino, con);

            if (saldoOrigen > cantidad) {
                res = true;
                reducirSaldo(idOrigen, cantidad, con);
                aumentarSaldo(idDestino, cantidad, con);
                Transaccion transaccion = new Transaccion(idOrigen, idDestino, cantidad, motivo);
                subirTransaccion(transaccion, con);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    public static void subirTransaccion(Transaccion transaccion, Connection con) throws SQLException {
        String sql = "INSERT INTO transacciones (idorigen, iddestino, cantidad, motivo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, transaccion.getIdorigen());
            stmt.setInt(2, transaccion.getIddestino());
            stmt.setDouble(3, transaccion.getCantidad());
            stmt.setString(4, transaccion.getMotivo());
            stmt.executeUpdate();
        }
    }

    public static void reducirSaldo(int id, double cantidad, Connection con) throws SQLException {
        String actualizarSaldoSQL = "UPDATE cuenta SET saldo = saldo - ? WHERE id = ?";
        try (PreparedStatement stmt = con.prepareStatement(actualizarSaldoSQL)) {
            stmt.setDouble(1, cantidad);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }

    public static void aumentarSaldo(int id, double cantidad, Connection con) throws SQLException {
        String actualizarSaldoSQL = "UPDATE cuenta SET saldo = saldo + ? WHERE id = ?";
        try (PreparedStatement stmt = con.prepareStatement(actualizarSaldoSQL)) {
            stmt.setDouble(1, cantidad);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }

    public static double verSaldo(int id, Connection con) throws SQLException {
        String verificarSaldoSQL = "SELECT saldo FROM cuenta WHERE id = ?";
        double saldo = 0;
        try (PreparedStatement stmt = con.prepareStatement(verificarSaldoSQL)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                saldo = rs.getDouble("saldo");
            }
        }
        return saldo;
    }
}
