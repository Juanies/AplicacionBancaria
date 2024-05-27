package programa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TarjetaDAO {
    public static void crearTarjeta(Tarjeta tarjeta, Connection con) throws SQLException {
        String sql = "INSERT INTO tarjetas (cuentaID, tipoTarjeta, nombre) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, tarjeta.getCuentaID());
            stmt.setString(2, tarjeta.getTipoTarjeta());
            stmt.setString(3, tarjeta.getNombre());

            stmt.executeUpdate();
        }
    }

    public static ArrayList<Tarjeta> cogerTarjetas(int idCuenta, Connection con) throws SQLException {
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();

        String sql = "SELECT * FROM tarjetas WHERE cuentaID = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, idCuenta);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    tarjetas.add(new Tarjeta(
                            rs.getInt("id"),
                            rs.getInt("cuentaID"),
                            rs.getString("tipoTarjeta"),
                            rs.getString("nombre")
                    ));
                }
            }
        }

        return tarjetas;
    }

    public static ArrayList<Tarjeta> cogerTarjetasTodasCuentas(ArrayList<Cuenta> cuentas, Connection con) throws SQLException {
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();

        for (Cuenta cuenta : cuentas) {
            tarjetas.addAll(cogerTarjetas(cuenta.getId(), con));
        }

        for (Tarjeta tarjeta : tarjetas) {
            System.out.println(tarjeta.getNombre());
        }

        return tarjetas;
    }
}
