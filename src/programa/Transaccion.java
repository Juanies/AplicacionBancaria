package programa;

public class Transaccion {
    int id;
    int idorigen;
    int iddestino;
    double cantidad;
    String motivo;

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Transaccion(int id, int idorigen, int iddestino, double cantidad, String motivo) {
        this.id = id;
        this.idorigen = idorigen;
        this.iddestino = iddestino;
        this.cantidad = cantidad;
        this.motivo = motivo;
    }

    public Transaccion(int idorigen, int iddestino, double cantidad, String motivo) {
        this.idorigen = idorigen;
        this.iddestino = iddestino;
        this.cantidad = cantidad;
        this.motivo = motivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdorigen() {
        return idorigen;
    }

    public void setIdorigen(int idorigen) {
        this.idorigen = idorigen;
    }

    public int getIddestino() {
        return iddestino;
    }

    public void setIddestino(int iddestino) {
        this.iddestino = iddestino;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
}
