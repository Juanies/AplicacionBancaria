public class Cuenta {
    private int id;
    private int usuarioID;
    private double saldo;

    public Cuenta(int id, int usuarioID, double saldo) {
        this.id = id;
        this.usuarioID = usuarioID;
        this.saldo = saldo;
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

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
