package programa;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Usuario implements Serializable {
    private int id;
    private String tipoInicio;
    private String documento;
    private String usuario;
    private String sesion;
    private String clave;

    private String creacion;


    public Usuario(int id, String tipoInicio, String documento, String usuario, String clave) {
        this.id = id;
        this.tipoInicio = tipoInicio;
        this.documento = documento;
        this.usuario = usuario;
        this.clave = clave;
        this.creacion = cogerfecha();

    }



    public Usuario(String tipoInicio, String documento, String usuario, String clave) {
        this.tipoInicio = tipoInicio;
        this.documento = documento;
        this.usuario = usuario;
        this.clave = clave;
        this.creacion = cogerfecha();
    }

    public String getSesion() {
        return sesion;
    }

    public void setSesion(String sesion) {
        this.sesion = sesion;
    }

    public String getCreacion() {
        return creacion;
    }

    public void setCreacion(String creacion) {
        this.creacion = creacion;
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

    public static String cogerfecha() {
        Date fechaActual = new Date();

        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fechaActual);

        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int anio = calendario.get(Calendar.YEAR);

        return hora + ":" + minutos + " " + dia + "-" + mes + "-" + anio;
    }

}
