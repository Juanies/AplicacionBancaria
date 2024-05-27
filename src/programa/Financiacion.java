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
    private Boolean rechazado;

    public Financiacion(int cuentaID, double cantidad, String motivo, Boolean aceptado, Boolean rechazado) {
        this.cuentaID = cuentaID;
        this.cantidad = cantidad;
        this.motivo = motivo;
        this.aceptado = aceptado;
        this.rechazado = rechazado;
    }

    public Boolean getRechazado() {
        return rechazado;
    }

    public void setRechazado(Boolean rechazado) {
        this.rechazado = rechazado;
    }

    public Financiacion(int id, int cuentaID, double cantidad, String motivo, Boolean aceptado, Boolean rechazado) {
        this.id = id;
        this.cuentaID = cuentaID;
        this.cantidad = cantidad;
        this.motivo = motivo;
        this.aceptado = aceptado;
        this.rechazado = rechazado;
    }


    public Boolean getAceptado() {
        return aceptado;
    }

    public void setAceptado(Boolean aceptado) {
        this.aceptado = aceptado;
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
