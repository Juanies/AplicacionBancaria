package programa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CuentaDAO {
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
        String sql = "SELECT * FROM cuenta WHERE usuarioID = ?";
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

                Cuenta cuenta = new Cuenta(cuentaId, usuarioid, saldo, tipoCuenta, fechaCreacion, nombreCuenta);
                cuentas.add(cuenta);
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cuentas;
    }

    public static Cuenta buscarCuentaPorNombre(String nombre, Connection con){
        Cuenta cuenta = null;
        String sql = "SELECT * FROM cuenta WHERE nombreCuenta = ?";
        try(PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                int cuentaId = rs.getInt("id");
                int usuarioid = rs.getInt("usuarioID");
                double saldo = rs.getDouble("saldo");
                String tipoCuenta = rs.getString("tipoCuenta");
                String fechaCreacion = rs.getString("fechaCreacion");
                String nombreCuenta = rs.getString("nombreCuenta");

                cuenta = new Cuenta(cuentaId, usuarioid, saldo, tipoCuenta, fechaCreacion, nombreCuenta);

            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cuenta;
    }
    public static double saldoTodasCuentas(int id, Connection con){
        ArrayList<Cuenta> cuentas = cogerTodasCuentasUsuario(id, con);
        double saldo = 0;

        for(Cuenta cuenta : cuentas){
            saldo += cuenta.getSaldo();
        }

        return  saldo;
    }

    public static double dineroCuenta(int id, Connection con){
        Cuenta cuenta = null;
        String sql = "SELECT * FROM cuenta WHERE id = ?";
        double saldo = 0;
        try(PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                 saldo = rs.getDouble("saldo");

            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return saldo;
    }


    public static Cuenta buscarCuentaPorId(int id, Connection con){
        Cuenta cuenta = null;
        String sql = "SELECT * FROM cuenta WHERE id = ?";
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

                cuenta = new Cuenta(cuentaId, usuarioid, saldo, tipoCuenta, fechaCreacion, nombreCuenta);

            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cuenta;
    }




}
