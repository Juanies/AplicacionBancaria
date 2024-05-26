package programa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Financiacion {
    private int id;
    private int cuentaID;
    private double cantidad;
    private String motivo;
    private Boolean aceptado;


    public Financiacion(int id, int cuentaID, double cantidad, String motivo, Boolean aceptado) {
        this.id = id;
        this.cuentaID = cuentaID;
        this.cantidad = cantidad;
        this.motivo = motivo;
        this.aceptado = aceptado;
    }


    public static ArrayList<Financiacion> cogerTodasFinanciacionCuentas(int id, Connection con){
        ArrayList<Cuenta> cuentas = cuentaDAO.cogerTodasCuentasUsuario(id, con);
        ArrayList<Financiacion> financiaciones = new ArrayList<>();

        for(Cuenta cuenta : cuentas){

            String sql = "SELECT * FROM financiacion WHERE cuentaID = ?";
            try(PreparedStatement stmt = con.prepareStatement(sql)){
                stmt.setInt(1, cuenta.getId());
                ResultSet rs = stmt.executeQuery();

                while (rs.next()){
                    int financiacionID = rs.getInt("id");
                    int cuentaid = rs.getInt("cuentaID");
                    double cantidadFinanciacion = rs.getDouble("cantidad");
                    String motivoFinanciacion = rs.getString("motivo");
                    Boolean estaAceptado = rs.getBoolean("aceptado");

                    Financiacion financiacion = new Financiacion(financiacionID, cuentaid, cantidadFinanciacion, motivoFinanciacion, estaAceptado);
                    if (financiacion.aceptado){
                        financiaciones.add(financiacion);
                    }
                }

            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return financiaciones;
    }

    public static double financiacionTotal(int id, Connection con){
        ArrayList<Financiacion> financiaciones = cogerTodasFinanciacionCuentas(id, con);
        double total = 0;

        for(Financiacion financiacion : financiaciones){
            total += financiacion.getCantidad();
        }

        return total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCuentaID() {
        return cuentaID;
    }

    public void setCuentaID(int cuentaID) {
        this.cuentaID = cuentaID;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
