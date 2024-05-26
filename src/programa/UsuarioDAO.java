package programa;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public static File getFicheroUsuarioActual(){
        return new File("src/datos/usuarioActual.dat");
    }

    public static void insertarUsuarioActual(){

    }

    public static void crearUsuario(Usuario usuario, Connection connection) throws SQLException {
        String sql = "INSERT INTO usuario (tipo_incio, documento, usuario, clave, fechaCreacion) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getTipoInicio());
            stmt.setString(2, usuario.getDocumento());
            stmt.setString(3, usuario.getUsuario());
            stmt.setString(4, usuario.getClave());
            stmt.setString(5, usuario.getCreacion());

            stmt.executeUpdate();
        }
    }

    public static void actualizarSesion(Usuario usuario, Connection con) throws SQLException {
        String sql = "UPDATE usuario SET fechaSesion = ? WHERE id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, Usuario.cogerfecha());
            stmt.setInt(2, usuario.getId());
            stmt.executeUpdate();
        }
    }



    public static Usuario obtenerUsuario(int id, Connection connection) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                        rs.getString("tipo_inicio"),
                        rs.getString("documento"),
                        rs.getString("usuario"),
                        rs.getString("clave")
                );
            }
        }
        return null;
    }

    public static ArrayList<Usuario> obtenerTodosLosUsuarios(Connection connection) throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getString("tipo_incio"),
                        rs.getString("documento"),
                        rs.getString("usuario"),
                        rs.getString("clave")
                );
                usuario.setId(rs.getInt("id"));
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    public static void actualizarUsuario(Usuario usuario, Connection connection) throws SQLException {
        String sql = "UPDATE usuario SET tipo_inicio = ?, documento = ?, usuario = ?, clave = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getTipoInicio());
            stmt.setString(2, usuario.getDocumento());
            stmt.setString(3, usuario.getUsuario());
            stmt.setString(4, usuario.getClave());
            stmt.setInt(5, usuario.getId());
            stmt.executeUpdate();
        }
    }

    public static void borrarUsuario(int id, Connection connection) throws SQLException {
        String sql = "DELETE FROM usuario WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public static void setUsuarioActual(Usuario usuario) throws IOException, ClassNotFoundException {
        insertarDatos(usuario, getFicheroUsuarioActual());
    }

    public static Usuario getUsuarioActual() throws IOException, ClassNotFoundException {
        return leerDatos(getFicheroUsuarioActual()).get(0);
    }

    public static ArrayList<Usuario> leerDatos(File file) throws IOException, ClassNotFoundException {

        ArrayList<Usuario> datos = new ArrayList<>();

        if (file.length() > 0) {

            FileInputStream fin = new FileInputStream(file);
            ObjectInputStream ofin = new ObjectInputStream(fin);

            while (fin.available() > 0) {
                Usuario equipo = (Usuario) ofin.readObject();
                datos.add(equipo);
            }
        }

        return datos;
    }

    public static void insertarDatos(Usuario dato, File fichero) throws IOException, ClassNotFoundException, IOException {
        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(fichero));

        oout.writeObject(dato);

        oout.close();

    }

    public static String ultimaConexion(int id, Connection connection) {
        String sql = "SELECT fechaCreacion FROM usuario WHERE id = ?";
        String conexion = "";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                conexion = rs.getString("fechaCreacion");
                System.out.println(conexion + " uwu");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexion;
    }


}
