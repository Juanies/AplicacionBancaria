package programa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class cuentaDAO {
    public static void crearCuenta(int id, String tipoCuenta, String nombreCuenta, Connection con) throws SQLException {
        String sql = "INSERT INTO cuenta (usuarioID, saldo, tipoCuenta, fechaCreacion, nombreCuenta) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setDouble(2, 0);
            stmt.setString(3, tipoCuenta);
            stmt.setString(4, Usuario.cogerfecha());
            stmt.setString(5, nombreCuenta);

            stmt.executeUpdate();
        }
    }

    public static ArrayList<Cuenta> cogerTodasCuentasUsuario(int id, Connection con){
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        String sql = "SELECT * FROM financiacion WHERE cuentaID = ?";
        try(PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                int cuentaId = rs.getInt("id");
                int usuarioid = rs.getInt("usuarioID");
                double saldo = rs.getDouble("saldo");
                String tipoCuenta = rs.getString("tipoCuenta");
                String fechaCreacion = rs.getString("fechaCreacion");
                String nombreCuenta = rs.getString("nombreCuenta");
                double financiacion = rs.getDouble("financiacion");

                Cuenta cuenta = new Cuenta(cuentaId, usuarioid, saldo, tipoCuenta, fechaCreacion, nombreCuenta, financiacion);
                cuentas.add(cuenta);
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cuentas;
    }

    public static double saldoTodasCuentas(int id, Connection con){
        ArrayList<Cuenta> cuentas = cogerTodasCuentasUsuario(id, con);
        double saldo = 0;

        for(Cuenta cuenta : cuentas){
            saldo += cuenta.getSaldo();
        }

        return  saldo;
    }


}