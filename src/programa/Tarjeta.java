package programa;

public class Tarjeta {
    private int id;
    private int usuarioID;
    private int cuentaID;
    private String tipoTarjeta;

    // Constructor, getters y setters
    public Tarjeta(int id, int usuarioID, int cuentaID, String tipoTarjeta) {
        this.id = id;
        this.usuarioID = usuarioID;
        this.cuentaID = cuentaID;
        this.tipoTarjeta = tipoTarjeta;
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

    public int getCuentaID() {
        return cuentaID;
    }

    public void setCuentaID(int cuentaID) {
        this.cuentaID = cuentaID;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }
}
