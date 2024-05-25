package programa;

public class Financiacion {
    private int id;
    private int cuentaID;
    private double cantidad;
    private String motivo;

    public Financiacion(int id, int cuentaID, double cantidad, String motivo) {
        this.id = id;
        this.cuentaID = cuentaID;
        this.cantidad = cantidad;
        this.motivo = motivo;
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
