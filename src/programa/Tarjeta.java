package programa;

public class Tarjeta {
    private int id;
    private int cuentaID;
    private String tipoTarjeta;
    private String nombre;


    public int getId() {
        return id;
    }

    public Tarjeta(int id, int cuentaID, String tipoTarjeta, String nombre) {
        this.id = id;
        this.cuentaID = cuentaID;
        this.tipoTarjeta = tipoTarjeta;
        this.nombre = nombre;
    }

    public Tarjeta(int cuentaID, String tipoTarjeta, String nombre) {
        this.cuentaID = cuentaID;
        this.tipoTarjeta = tipoTarjeta;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }
}
