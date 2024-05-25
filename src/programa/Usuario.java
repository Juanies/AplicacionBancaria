package programa;

public class Usuario {
    private int id;
    private String tipoInicio;
    private String documento;
    private String usuario;
    private String clave;

    public Usuario(int id, String tipoInicio, String documento, String usuario, String clave) {
        this.id = id;
        this.tipoInicio = tipoInicio;
        this.documento = documento;
        this.usuario = usuario;
        this.clave = clave;
    }

    public Usuario(String tipoInicio, String documento, String usuario, String clave) {
        this.id = id;
        this.tipoInicio = tipoInicio;
        this.documento = documento;
        this.usuario = usuario;
        this.clave = clave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoInicio() {
        return tipoInicio;
    }

    public void setTipoInicio(String tipoInicio) {
        this.tipoInicio = tipoInicio;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
