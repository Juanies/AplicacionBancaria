package programa;

public class Transaccion {
    int id;
    int idorigen;
    int iddestino;
    double cantidad;
    int cuentaid;

    public Transaccion(int id, int idorigen, int iddestino, double cantidad, int cuentaid) {
        this.id = id;
        this.idorigen = idorigen;
        this.iddestino = iddestino;
        this.cantidad = cantidad;
        this.cuentaid = cuentaid;
    }

    public Transaccion(int idorigen, int iddestino, double cantidad, int cuentaid) {
        this.idorigen = idorigen;
        this.iddestino = iddestino;
        this.cantidad = cantidad;
        this.cuentaid = cuentaid;
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
