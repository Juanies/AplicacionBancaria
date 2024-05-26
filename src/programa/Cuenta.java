package programa;

public class Cuenta {
    private int id;
    private int usuarioID;
    private double saldo;
    private String tipoCuenta;
    private String fechaCreacion;
    private String nombreCuenta;
    private double financiacion;

    public Cuenta(int id, int usuarioID, double saldo, String tipoCuenta, String fechaCreacion, String nombreCuenta, double financiacion) {
        this.id = id;
        this.usuarioID = usuarioID;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
        this.fechaCreacion = fechaCreacion;
        this.nombreCuenta = nombreCuenta;
        this.financiacion = financiacion;

    }

    public Cuenta(int id, int usuarioID, String tipoCuenta) {
        this.id = id;
        this.usuarioID = usuarioID;
        this.saldo = 0;
        this.tipoCuenta = tipoCuenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    public double getSaldo() {
        return saldo;
    }
    public double getFinanciacion() {
        return financiacion;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
