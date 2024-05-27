package programa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FinanciacionDAO {


    public static ArrayList<Financiacion> cogerTodasFinanciacionCuentas(int id, Connection con) {
        ArrayList<Cuenta> cuentas = CuentaDAO.cogerTodasCuentasUsuario(id, con);
        ArrayList<Financiacion> financiaciones = new ArrayList<>();

        for (Cuenta cuenta : cuentas) {

            String sql = "SELECT * FROM financiacion WHERE cuentaID = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, cuenta.getId());
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    int financiacionID = rs.getInt("id");
                    int cuentaid = rs.getInt("cuentaID");
                    double cantidadFinanciacion = rs.getDouble("cantidad");
                    String motivoFinanciacion = rs.getString("motivo");
                    Boolean estaAceptado = rs.getBoolean("aceptado");

                    Financiacion financiacion = new Financiacion(financiacionID, cuentaid, cantidadFinanciacion, motivoFinanciacion, estaAceptado);
                    if (financiacion.getAceptado()) {
                        financiaciones.add(financiacion);
                    }
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return financiaciones;
    }

    public static double financiacionTotal(int id, Connection con) {
        ArrayList<Financiacion> financiaciones = cogerTodasFinanciacionCuentas(id, con);
        double total = 0;

        for (Financiacion financiacion : financiaciones) {
            total += financiacion.getCantidad();
        }

        return total;
    }

    public static void nuevaFinanciacion(Connection con, Financiacion financiacion) {
        String sql = "INSERT INTO financiacion (cuentaID, cantidad, motivo, aceptado) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, financiacion.getCuentaID());
            stmt.setDouble(2, financiacion.getCantidad());
            stmt.setString(3, financiacion.getMotivo());
            stmt.setBoolean(4, financiacion.getAceptado());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}